package pkuhit.md;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.apache.shiro.util.StringUtils;

import pkuhit.me.DataObject;
import pkuhit.me.DataObjectMetadata;
import pkuhit.me.DataObjectMetadataRepository;
import pkuhit.me.DataObjectService;
import pkuhit.me.query.Query;
import pkuhit.me.query.QueryBuilder;
import xap.sv.app.Application;
import xap.sv.bundle.XapBundleContext;
import xap.sv.log.DebugLogger;

public class SimpleDictionaryQueryService implements DictionaryQueryService
{
    DataObjectService dataObjectService;

    DataObjectMetadataRepository dataObjectMetadataRepository;

    public void setDataObjectService(DataObjectService dataObjectService)
    {
        this.dataObjectService = dataObjectService;
    }

    public void setDataObjectMetadataRepository(
            DataObjectMetadataRepository dataObjectMetadataRepository)
    {
        this.dataObjectMetadataRepository = dataObjectMetadataRepository;
    }

    @Override
    public Dictionary[] execute(DictionaryQueryCondition condition)
    {
        String str = (String) condition.get("id");
        List<Dictionary> ret = new ArrayList<Dictionary>();
        if (str != null)
        {
            String[] list = str.split(",");
            for (int i = 0; i < list.length; i++)
            {
                String dictCd = list[i];
                Dictionary dict = this.createDictionary(dictCd, condition);
                // TODO 更合适的方式设置空字典数据
                if (dict == null)
                {
                    dict = new Dictionary();
                    dict.setId(dictCd);
                }
                ret.add(dict);
            }
        }
        return ret.toArray(new Dictionary[ret.size()]);
    }

    Dictionary createDictionary(String dictCd,
            DictionaryQueryCondition condition)
    {
        List<DataObject> objectList = new ArrayList<DataObject>();
        String codeList = (String) condition.get("codeList");
        if (StringUtils.hasText(codeList))
        {
            for (String code : StringUtils.tokenizeToStringArray(codeList, ","))
            {
                List<DataObject> l = searchDataObjectsByCode(dictCd, code);
                if (l != null)
                    objectList.addAll(l);
            }
        }
        else
        {
            List<DataObject> l = searchDataObjectsByCode(dictCd, null);
            if (l != null)
                objectList.addAll(l);
        }

        if (objectList != null && objectList.size() > 0)
        {
            Dictionary dict = new Dictionary();
            dict.setId(dictCd);
            for (DataObject o : objectList)
            {
                GeneralData m = o.getObject(GeneralData.class);
                Dictionary.Item item = new Dictionary.SimpleItem(m.getCode(),
                        m.getName());
                dict.addItem(item);
            }
            return dict;

        }
        else
        {
            XapBundleContext xbc = Application.getInstance().getBundleContext();
            Map<String, DictionaryQueryService> services = xbc.getServicesOfType(DictionaryQueryService.class);
            for (DictionaryQueryService service : services.values())
            {
                if (service == this)
                {
                    continue;
                }
                Map d = condition.getData();
                d.put("id", dictCd);
                DictionaryQueryCondition dqc = new DictionaryQueryCondition(d);
                Dictionary[] dicts = service.execute(dqc);
                if (dicts == null || dicts.length <= 0)
                    continue;
                return dicts[0];
            }
        }
        return null;
    }

    List<DataObject> searchDataObjectsByCode(String dictCd, String code)
    {
        QueryBuilder builder = null;
        DataObjectMetadata dom = dataObjectMetadataRepository.getDataObjectMetadata(dictCd);
        if (dom != null && !dom.isCommonMD())
        {
            builder = QueryBuilder.newQuery(dom.getObjectCd());
        }
        else
        {
            // TODO 常量
            builder = QueryBuilder.newQuery("MDM01").and("objectCode", dictCd);
        }
        if (code != null && dom != null)
        {
            builder.and(dom.getKey().getAttributeName(), code);
        }
        Query query = builder.build();

        DataObject[] objectArray = dataObjectService.executeQuery(query);
//        DebugLogger.log("cache "+dictCd+ " sum rows:"+objectArray.length+"  ");
        return Arrays.asList(objectArray);
    }
}
