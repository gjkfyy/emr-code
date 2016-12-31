package pkuhit.me.table;

import pkuhit.me.DataObjectMetadata;

public class PrimaryKeyObjectMetadata extends DataObjectMetadata
{
    String tableName;

    // TODO 单主键？
    String primaryKey;

    public String getTableName()
    {
        return tableName;
    }

    public void setTableName(String tableName)
    {
        this.tableName = tableName;
    }

    public String getPrimaryKey()
    {
        return primaryKey;
    }

    public void setPrimaryKey(String primaryKey)
    {
        this.primaryKey = primaryKey;
    }
}