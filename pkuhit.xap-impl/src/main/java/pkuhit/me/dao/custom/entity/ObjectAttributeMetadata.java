package pkuhit.me.dao.custom.entity;

import org.seasar.doma.Column;
import org.seasar.doma.Entity;

@Entity
public class ObjectAttributeMetadata
{
    @Column(name = "OBJECT_CD")
    String objectCd;

    @Column(name = "ATTRIBUTE_CD")
    String attributeCd;

    @Column(name = "TABLE_NAME")
    String tableName;

    @Column(name = "COLUMN_NAME")
    String columnName;

    @Column(name = "ATTRIBUTE_NAME")
    String attributeName;

    @Column(name = "ATTRIBUTE_TEXT")
    String attributeText;

    @Column(name = "PRIMARY_KEY_FLAG")
    int primaryKeyFlag;

    @Column(name = "COMMON_MD_FLAG")
    int commonMDFlag;

    @Column(name = "CACHE_FLAG")
    int cacheFlag;

    public String getObjectCd()
    {
        return objectCd;
    }

    public void setObjectCd(String objectCd)
    {
        this.objectCd = objectCd;
    }

    public String getAttributeCd()
    {
        return attributeCd;
    }

    public void setAttributeCd(String attributeCd)
    {
        this.attributeCd = attributeCd;
    }

    public String getTableName()
    {
        return tableName;
    }

    public void setTableName(String tableName)
    {
        this.tableName = tableName;
    }

    public String getColumnName()
    {
        return columnName;
    }

    public void setColumnName(String columnName)
    {
        this.columnName = columnName;
    }

    public String getAttributeName()
    {
        return attributeName;
    }

    public void setAttributeName(String attributeName)
    {
        this.attributeName = attributeName;
    }

    public String getAttributeText()
    {
        return attributeText;
    }

    public void setAttributeText(String attributeText)
    {
        this.attributeText = attributeText;
    }

    public int getPrimaryKeyFlag()
    {
        return primaryKeyFlag;
    }

    public void setPrimaryKeyFlag(int primaryKeyFlag)
    {
        this.primaryKeyFlag = primaryKeyFlag;
    }

    public int getCommonMDFlag()
    {
        return commonMDFlag;
    }

    public void setCommonMDFlag(int commonMDFlag)
    {
        this.commonMDFlag = commonMDFlag;
    }

    public int getCacheFlag()
    {
        return cacheFlag;
    }

    public void setCacheFlag(int cacheFlag)
    {
        this.cacheFlag = cacheFlag;
    }
}
