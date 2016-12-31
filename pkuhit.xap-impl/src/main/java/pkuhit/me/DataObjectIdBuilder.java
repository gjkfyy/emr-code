package pkuhit.me;

import org.springframework.util.Assert;

public class DataObjectIdBuilder
{
    String objectCd;

    Object value;

    public static DataObjectIdBuilder newIdentifier()
    {
        return new DataObjectIdBuilder();
    }

    public DataObjectIdBuilder withObjectCd(String objectCd)
    {
        this.objectCd = objectCd;
        return this;
    }

    public DataObjectIdBuilder withValue(Object value)
    {
        this.value = value;
        return this;
    }

    public DataObjectId build()
    {
        Assert.hasText(objectCd, "objectCd must not be empty");
        DataObjectId id = new DataObjectId();
        id.setObjectCode(objectCd);
        id.setValue(value);
        return id;
    }
}
