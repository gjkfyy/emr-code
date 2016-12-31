package pkuhit.md;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.cache.Cache;
import org.springframework.util.StringUtils;

import pkuhit.md.Dictionary.Item;
import pkuhit.md.Dictionary.SimpleItem;
import xap.sv.app.Application;
import xap.sv.app.Application.Mode;
import xap.sv.component.ModeAware;
import xap.sv.log.DebugLogger;
import xap.sv.service.cache.CacheableService;
import xap.sv.util.CipherUtil;

public abstract class CacheableDictionaryService extends
        CacheableService<DictionaryService> implements DictionaryService,
        ModeAware
{
    final static String CACHE_NAME = CacheableDictionaryService.class.getName()
        + "_cache_name";

    protected Mode mode;

    @Override
    public final Dictionary[] searchDictionary(DictionarySearchKey key)
    {
        // 如果ID是逗号分隔的,需要拆分Key
        String id = key.getId();

        // Added by wujunhui 合并id中重复的值.
        id = mergeIds(id);
        key.setId(id);
        // End

        String[] idList = id.split(",");
        Collection<DictionarySearchKey> keyList = new ArrayList<DictionarySearchKey>();
        if (idList.length == 1)
        {
            // 单ID才支持多Code查询
            SearchKeyBuilder builder = SearchKeyBuilder.newSearchKey().withDictId(
                    idList[0]);
            String[] codeList = StringUtils.tokenizeToStringArray(
                    key.getCodeList(), ",");
            if (codeList != null)
            {
                for (String code : codeList)
                {
                    builder.addCode(code);
                }
            }
            DictionarySearchKey k = builder.build();
            k.setKeyword(key.getKeyword());
            keyList.add(k);
        }
        else if (idList.length > 1)
        {
            for (int i = 0; i < idList.length; i++)
            {
                DictionarySearchKey k = SearchKeyBuilder.newSearchKey().withDictId(
                        idList[i]).build();
                keyList.add(k);
            }
        }
        return searchDictionary(keyList);
    }

    private static String mergeIds(String ids)
    {
        StringBuffer mergedIds = new StringBuffer();
        Set<String> set = new HashSet<String>();
        String[] idList = ids.split(",");
        for (int i = 0; i < idList.length; i++)
        {
            String id = idList[i];
            if (set.add(id))
            {
                mergedIds.append(id + ',');
            }
        }

        String strMergedIds = mergedIds.toString();
        if (strMergedIds.length() > 0)
        {
            strMergedIds = strMergedIds.substring(0, strMergedIds.length() - 1);
        }

        return strMergedIds;
    }

    public static void main(String[] args)
    {
        String srcIds = "1,1,2,2,4,4,5,6";

        System.out.println(mergeIds(srcIds));
    }

    private Dictionary[] searchDictionary(
            Collection<DictionarySearchKey> keyList)
    {
        Collection<Dictionary> dictionaries = new ArrayList<Dictionary>();
        for (DictionarySearchKey key : keyList)
        {
            Dictionary dict = searchSingleDictionary(key);
            if (dict != null)
            {
                dictionaries.add(dict);
            }
        }
        return dictionaries.toArray(new Dictionary[dictionaries.size()]);
    }

    private Dictionary searchSingleDictionary(DictionarySearchKey key)
    {
        Dictionary dict = this.getDictionaryFromCache(key);
        if (dict == null)
        {
            DictionaryService delegate = this.getDelegate();
            if (delegate == null)
            {
                dict = doSearchSingleDictionary(key);
            }
            else
            {
                DebugLogger.log("request remote server.[DictionaryService:"
                    + key.getId() + "-" + key.getCode() + "]");
                Dictionary[] dictList = delegate.searchDictionary(key);
                if (dictList != null && dictList.length > 0)
                    dict = dictList[0];
            }
        }
        else
        {
//            DebugLogger.log("from cache server.[DictionaryService:"
//                + key.getId() + "-" + key.getCode() + "]");
        }
        return dict;
    }

    @Override
    public final Dictionary getDictionary(String dictId)
    {
        if (StringUtils.hasText(dictId))
        {
            DictionarySearchKey key = SearchKeyBuilder.newSearchKey().withDictId(
                    dictId).build();
            return searchSingleDictionary(key);
        }
        return null;
    }

    @Override
    public final SimpleItem[] getSimpleItems(String dictId, String... codes)
    {
        SearchKeyBuilder keyBuilder = SearchKeyBuilder.newSearchKey().withDictId(
                dictId);
        for (String code : codes)
        {
            keyBuilder.addCode(code);
        }
        DictionarySearchKey key = keyBuilder.build();
        Dictionary dict = this.searchSingleDictionary(key);
        // Dictionary dict = getDictionary(dictId);
        Map<String, SimpleItem> itemMap = new HashMap<String, SimpleItem>();
        for (Item item : dict.getData())
        {
            SimpleItem si = null;
            if (item instanceof SimpleItem)
            {
                si = (SimpleItem) item;
            }
            else if (item != null)
            {
                // TODO 远程访问返回的不是SimpleItem对象，而是Item
                si = new SimpleItem();
                si.putAll(item);
            }
            if (si != null)
                itemMap.put(si.getValue(), si);
        }

        List<SimpleItem> ret = new ArrayList<SimpleItem>();
        if (codes != null && codes.length > 0)
        {
            for (String code : codes)
            {
                ret.add(itemMap.get(code));
            }
        }
        else
        {
            ret.addAll(itemMap.values());
        }
        return ret.toArray(new SimpleItem[ret.size()]);
    }

    @Override
    public Dictionary remove(String dictId)
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public void setMode(Mode mode)
    {
        this.mode = mode;
    }

    @Override
    protected String getCacheName()
    {
        return CACHE_NAME;
    }

    protected abstract Dictionary doSearchSingleDictionary(
            DictionarySearchKey key);

    // private Dictionary getDictionaryFromCache(String dictId)
    private Dictionary getDictionaryFromCache(DictionarySearchKey key)
    {
        String dictId = key.getId();
        String cacheId = this.buildCacheId(key);
        // 生产模式下才会从缓存取数据
        if (Application.Mode.PRODUCTION.equals(mode))
        {
            // TODO 目前的实现，一次取出整个字典对象，但有可能只关心一个两个数据，需要改进
            Cache cache = getCache();
            SimpleItem[] items = cache.get(cacheId, SimpleItem[].class);
            if (items != null)
            {
                Dictionary dict = new Dictionary();
                dict.setId(dictId);
                for (Item item : items)
                {
                    dict.addItem(item);
                }
                return dict;
            }
        }
        return null;
    }

    protected String buildCacheId(DictionarySearchKey key)
    {
        StringBuilder seedBuilder = new StringBuilder();
        String id = key.getId();
        seedBuilder.append(id);
        String keyword = key.getKeyword();
        if (StringUtils.hasText(keyword))
        {
            seedBuilder.append(keyword);
        }
        String[] codeList = StringUtils.tokenizeToStringArray(
                key.getCodeList(), ",");
        if (codeList != null)
        {
            for (String code : codeList)
            {
                seedBuilder.append(code);
            }
        }
        return CipherUtil.getHashValue(seedBuilder.toString());
    }
}
