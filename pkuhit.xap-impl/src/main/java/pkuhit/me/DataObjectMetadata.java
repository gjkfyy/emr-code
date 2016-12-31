package pkuhit.me;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.springframework.util.StringUtils;

import pkuhit.me.dao.custom.entity.ObjectAttributeMetadata;

public class DataObjectMetadata
{
    String ObjectCd;

    ObjectAttributeMetadata pk;

    boolean commonMD;

    boolean isCacheable;

    Map<String, ObjectAttributeMetadata> attributesByName = new HashMap<String, ObjectAttributeMetadata>();

    Map<String, ObjectAttributeMetadata> attributesByColumn = new HashMap<String, ObjectAttributeMetadata>();

    public String getObjectCd()
    {
        return ObjectCd;
    }

    public void setObjectCd(String objectCd)
    {
        ObjectCd = objectCd;
    }

    public ObjectAttributeMetadata getAttributeByName(String propertyName)
    {
        return attributesByName.get(propertyName);
    }

    public ObjectAttributeMetadata getAttributeByColumn(String columnName)
    {
        return attributesByColumn.get(columnName);
    }

    public ObjectAttributeMetadata getKey()
    {
        return pk;
    }

    public boolean isCommonMD()
    {
        return commonMD;
    }

    public boolean isCacheable()
    {
        return isCacheable;
    }
    
    public boolean isMDM01()
    {
        return "MDM01".equals(ObjectCd);
    }

    public void addAttribute(ObjectAttributeMetadata oam)
    {
        attributesByName.put(oam.getAttributeName(), oam);
        String columnName = oam.getColumnName();
        if (StringUtils.hasText(columnName))
        {
            attributesByColumn.put(columnName, oam);
        }
        if (oam.getPrimaryKeyFlag() == 1)
            this.pk = oam;
        if (oam.getCommonMDFlag() == 1)
            this.commonMD = true;
        if (oam.getCacheFlag() == 1)
            this.isCacheable = true;
    }

    public Map<String, ObjectAttributeMetadata> getAttributes()
    {
        return Collections.unmodifiableMap(attributesByName);
    }
}
