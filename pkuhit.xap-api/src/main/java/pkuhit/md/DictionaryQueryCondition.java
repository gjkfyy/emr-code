package pkuhit.md;

import java.util.HashMap;
import java.util.Map;

public class DictionaryQueryCondition
{
    String operation;

    Map<String, Object> data = new HashMap<String, Object>();

    public DictionaryQueryCondition(Map<String, Object> data)
    {
        this.data = data;
    }

    public String getOperation()
    {
        return operation;
    }

    public void setOperation(String operation)
    {
        this.operation = operation;
    }

    public Object get(String name)
    {
        return this.data.get(name);
    }

    public Map<String, Object> getData()
    {
        Map<String, Object> ret = new HashMap<String, Object>(this.data);
        return ret;
    }
}
