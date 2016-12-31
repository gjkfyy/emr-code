package pkuhit.me;

public class DataObjectId
{
    String objectCode;

    Object value;

    public String getObjectCode()
    {
        return objectCode;
    }

    public void setObjectCode(String objectCode)
    {
        this.objectCode = objectCode;
    }

    public Object getValue()
    {
        return value;
    }

    public void setValue(Object value)
    {
        this.value = value;
    }

    @Override
    public int hashCode()
    {
        String str = (value != null ? value.toString() : "");
        str += (objectCode != null ? objectCode : "");
        return str.hashCode();
    }
}
