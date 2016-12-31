package pkuhit.me;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import pkuhit.me.dao.custom.DataObjectMetadataDao;
import pkuhit.me.dao.custom.entity.ObjectAttributeMetadata;
import pkuhit.me.table.PrimaryKeyObjectMetadata;
import xap.sv.bundle.XapBundleContext;
import xap.sv.bundle.XapBundleContextAware;
import xap.sv.component.LifeCycleComponent;

import com.google.common.base.CaseFormat;

// TODO dataObjectMetadataRepository缓存化
public class SimpleDataObjectMetadataRepository implements
        DataObjectMetadataRepository, LifeCycleComponent, XapBundleContextAware
{
    @Autowired
    DataObjectMetadataDao dataObjectMetadataDao;

    Map<String, DataObjectMetadata> metadataCache = null;

    XapBundleContext xbc;

    @Override
    public void onStart()
    {
        metadataCache = Collections.synchronizedMap(new HashMap<String, DataObjectMetadata>());
        //获取所有需要缓存的对象，包括表及表里的个别字段
        List<ObjectAttributeMetadata> list = dataObjectMetadataDao.selectAllMetadata();
        for (ObjectAttributeMetadata oam : list)
        {
            String objectCd = oam.getObjectCd();
            Assert.hasText(objectCd, "objectCode must not be empty");
            String attributeCd = oam.getAttributeCd();
            Assert.hasText(attributeCd, "attributeCd must not be empty");
            String attributeName = oam.getAttributeName();
            Assert.hasText(attributeName, "attributeName must not be empty");
            attributeName = attributeName.replace(" ", "_");
            attributeName = columnNameToPropertyName(attributeName);
            oam.setAttributeName(attributeName);
            // TODO 等待数据完善
            if (!StringUtils.hasText(attributeName))
            {
                continue;
            }
            PrimaryKeyObjectMetadata pkom = null;
            if (!metadataCache.containsKey(objectCd))
            {
                pkom = new PrimaryKeyObjectMetadata();
                pkom.setObjectCd(objectCd);
                pkom.setTableName(oam.getTableName());
                metadataCache.put(objectCd, pkom);
            }
            DataObjectMetadata dom = metadataCache.get(objectCd);
            Assert.isTrue(dom instanceof PrimaryKeyObjectMetadata,
                    "dataObjectMetadata must be PrimaryKeyObjectMetadata");
            pkom = (PrimaryKeyObjectMetadata) dom;
            pkom.addAttribute(oam);
        }
    }

    @Override
    public void onDestory()
    {
        metadataCache = null;
    }

    @Override
    public DataObjectMetadata getDataObjectMetadata(String objectCd)
    {
        return metadataCache.get(objectCd);
    }

    @Override
    public DataObjectMetadata getDataObjectMetadataByAttribute(
            String attributeCd)
    {
        // DataObjectMetadata dopm = this.metadataCache.get(propertyCode);
        // for (DataObjectMetadata dom : this.metadataCache.values())
        // {
        // DataObjectPropertyMetadata m =
        // dom.getPropertyByName(dopm.getPropertyName());
        // if (m != null && m.getPropertyCode().equals(dopm.getPropertyCode()))
        // {
        // return dom;
        // }
        // }
        // return null;
        throw new UnsupportedOperationException();
    }

    String columnNameToPropertyName(String columnName)
    {
        if (!StringUtils.hasText(columnName))
            return null;
        CaseFormat from = CaseFormat.UPPER_UNDERSCORE;
        CaseFormat to = CaseFormat.LOWER_CAMEL;
        return from.to(to, columnName);
    }

    @Override
    public void setBundleContext(XapBundleContext context)
    {
        this.xbc = context;
    }

    @Override
    public DataObjectMetadata[] getAllDataObjectMetadatas()
    {
        return this.metadataCache.values().toArray(new DataObjectMetadata[0]);
    }
}
