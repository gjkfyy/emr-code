package pkuhit.md;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.springframework.util.Assert;

import pkuhit.md.Dictionary.SimpleItem;
import pkuhit.me.DataObject;
import pkuhit.me.DataObjectMetadata;
import pkuhit.me.DataObjectMetadataRepository;
import pkuhit.me.DataObjectService;
import pkuhit.me.query.Query;
import pkuhit.me.query.QueryBuilder;
import xap.sv.app.Application;
import xap.sv.app.Application.Mode;
import xap.sv.component.LifeCycleComponent;
import xap.sv.log.DebugLogger;
import xap.sv.log.InfoLogger;
import xap.sv.util.Ordered;

public class DictionaryServiceImpl extends CacheableDictionaryService implements
        LifeCycleComponent, Ordered
{
    DataObjectService dataObjectService;

    SimpleDictionaryQueryService simpleDictionaryQueryService;

    DataObjectMetadataRepository dataObjectMetadataRepository;

    public void setSimpleDictionaryQueryService(
            SimpleDictionaryQueryService simpleDictionaryQueryService)
    {
        this.simpleDictionaryQueryService = simpleDictionaryQueryService;
    }

    public void setDataObjectMetadataRepository(
            DataObjectMetadataRepository dataObjectMetadataRepository)
    {
        this.dataObjectMetadataRepository = dataObjectMetadataRepository;
    }

    public void setDataObjectService(DataObjectService dataObjectService)
    {
        this.dataObjectService = dataObjectService;
    }

    @Override
    protected DictionaryService getDelegate()
    {
        return null;
    }

    @Override
    public void onStart()
    {
        // TODO 目前在系统启动时清空缓存
        this.getCache().clear();

        // 加载字典数据
        if (Mode.PRODUCTION.equals(Application.getInstance().getMode()))
        {
            Set<String> processedIds = new HashSet<String>();
            InfoLogger.log("start cache metadata.....");
            for (DataObjectMetadata meta : this.dataObjectMetadataRepository.getAllDataObjectMetadatas())
            {
                if (meta.isCacheable())
                {
                    initDataObjectCache(meta, processedIds);
                }
            }
            InfoLogger.log("complite cache metadata");
        }
    }

    @Override
    public void onDestory()
    {
    }

    private void initDataObjectCache(DataObjectMetadata meta,
            Set<String> processedIds)
    {
        String dictId = meta.getObjectCd();
        if (meta.isMDM01())
        {
            Query query = QueryBuilder.newQuery("MDM01").build();
            DataObject[] objects = dataObjectService.executeQuery(query);
            for (DataObject object : objects)
            {
                String objCd = (String) object.getValue("objectCode");
                initDictionaryCache(objCd, processedIds);
            }
        }
        else
        {
            initDictionaryCache(dictId, processedIds);
        }
    }

    private void initDictionaryCache(String dictId, Set<String> processedIds)
    {
        if (processedIds.contains(dictId))
            // 已经处理过的就跳过
            return;
        DebugLogger.log("Begin prepare dictionary data [" + dictId + "]");
        SimpleItem[] items = getSimpleItems(dictId);
        DebugLogger.log("cache [" + dictId + "] sum rows:"+items.length+"......");
        for (SimpleItem item : items)
        {
            getSimpleItems(dictId, item.getValue(String.class));
        }
        processedIds.add(dictId);
        DebugLogger.log("End prepare dictionary data [" + dictId + "]");
    }

    @Override
    protected Dictionary doSearchSingleDictionary(DictionarySearchKey key)
    {
        Dictionary dict = null;
        Map<String, Object> condition = new HashMap<String, Object>();
        condition.put("id", key.getId());
        condition.put("keyword", key.getKeyword());
        condition.put("codeList", key.getCodeList());
        DictionaryQueryCondition dc = new DictionaryQueryCondition(condition);
        Dictionary[] dictionaries = simpleDictionaryQueryService.execute(dc);
        if (dictionaries != null && dictionaries.length > 0)
            dict = dictionaries[0];
        if (dict != null)
            saveDictionaryToCache(key, dict);
        return dict;
    }

    private void saveDictionaryToCache(DictionarySearchKey key, Dictionary dict)
    {
        DataObjectMetadata dom = this.dataObjectMetadataRepository.getDataObjectMetadata(dict.getId());
        if (dom != null && !dom.isCacheable())
            return;
        String cacheId = this.buildCacheId(key);
        // 生产模式下才会向缓存存数据
        if (Application.Mode.PRODUCTION.equals(mode))
        {
            Assert.notNull(dict);
            Assert.notNull(dict.getId());
            getCache().put(cacheId, dict.getData().toArray(new SimpleItem[0]));
        }
    }

    @Override
    public int getOrder()
    {
        // level 1
        return 1;
    }

	@Override
	public String updateDictionary(String dictId) {
		SearchKeyBuilder keyBuilder = SearchKeyBuilder.newSearchKey().withDictId(
                dictId);
		DictionarySearchKey key = keyBuilder.build();
		//根据key获取cacheId
		String cacheId = this.buildCacheId(key);
		//清空cacheId对应的cache
		this.getCache().evict(cacheId);
		Dictionary dict = null;
        Map<String, Object> condition = new HashMap<String, Object>();
        condition.put("id", key.getId());
        condition.put("keyword", key.getKeyword());
        condition.put("codeList", key.getCodeList());
        DictionaryQueryCondition dc = new DictionaryQueryCondition(condition);
        Dictionary[] dictionaries = simpleDictionaryQueryService.execute(dc);
        if (dictionaries != null && dictionaries.length > 0)
            dict = dictionaries[0];
        if (dict != null){
            saveDictionaryToCache(key, dict);
        }
		return "Success";
	}
}
