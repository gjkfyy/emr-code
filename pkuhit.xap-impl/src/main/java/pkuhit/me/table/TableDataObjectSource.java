package pkuhit.me.table;

import java.util.Map;
import java.util.regex.Pattern;

import org.springframework.cglib.beans.BeanMap;
import org.springframework.util.Assert;

import pkuhit.me.DataObject;
import pkuhit.me.DataObjectId;
import pkuhit.me.DataObjectMetadata;
import pkuhit.me.DataObjectSource;
import xap.sv.annotation.Reference;
import xap.sv.dao.DaoAdapter;
import xap.sv.dao.DaoFactory;

public class TableDataObjectSource implements DataObjectSource
{
    @Reference
    DaoFactory daoFactory;

    Pattern[] tableNamePatterns;

    public boolean support(DataObjectMetadata metadata)
    {
        if (metadata instanceof PrimaryKeyObjectMetadata)
        {
            PrimaryKeyObjectMetadata pkom = (PrimaryKeyObjectMetadata) metadata;
            for (Pattern pattern : tableNamePatterns)
            {
                boolean matched = pattern.matcher(pkom.getTableName()).matches();
                if (matched)
                    return true;
            }
        }
        return false;
    }

    public void setTableNames(String[] tableNames)
    {
        Assert.notEmpty(tableNames, "tableNames must be set");
        tableNamePatterns = new Pattern[tableNames.length];
        for (int i = 0; i < tableNames.length; i++)
        {
            tableNamePatterns[i] = Pattern.compile(tableNames[i].trim());
        }
    }

    @Override
    public DataObject getDataObject(DataObjectId id,
            DataObjectMetadata metadata)
    {
        if (metadata instanceof PrimaryKeyObjectMetadata)
        {
            PrimaryKeyObjectMetadata pkom = (PrimaryKeyObjectMetadata) metadata;
            DaoAdapter adapter = daoFactory.getDao(pkom.getTableName(),
                    DaoAdapter.class);
            if (adapter != null)
            {
                Object r = adapter.selectById(id.getValue());
                if (r == null)
                    return null;
                DataObject o = new DataObject();
                Map<String, Object> data = null;
                if (r instanceof Map)
                {
                    data = (Map) r;
                }
                else
                {
                    data = BeanMap.create(r);
                }
                o.setObjectData(data);
                return o;
            }
        }
        return null;
    }
}
