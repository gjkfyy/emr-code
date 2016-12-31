package pkuhit.me;

import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.PropertyValues;
import org.springframework.util.Assert;
import org.springframework.validation.DataBinder;

public class DataObject
{
    String id;

    Map<String, Object> objectData = null;

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        Assert.isNull(this.id, "do not set id more than once");
        this.id = id;
    }

    public <T> T getObject(Class<T> objectType)
    {
        Assert.notNull(objectType, "objectType must not be null");
        Assert.notNull(objectData, "objectData must have been set");
        T bean = BeanUtils.instantiate(objectType);
        PropertyValues pvs = new MutablePropertyValues(this.objectData);
        DataBinder binder = new DataBinder(bean);
        binder.bind(pvs);
        return objectType.cast(binder.getTarget());
    }

    public Object getValue(String name)
    {
        return this.objectData.get(name);
    }

    public void setObjectData(Map<String, Object> data)
    {
        this.objectData = data;
    }

    public Map<String, Object> getObjectData()
    {
        return objectData;
    }
}
