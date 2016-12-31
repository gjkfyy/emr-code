package pkuhit.xap.file;

public class StorageObject
{
    ObjectMetadata meta;

    ObjectData data;

    public StorageObject(ObjectMetadata meta, ObjectData data)
    {
        this.meta = meta;
        this.data = data;
    }

    public ObjectMetadata getMeta()
    {
        return meta;
    }

    public ObjectData getData()
    {
        return data;
    }

    public void setData(ObjectData data)
    {
        this.data = data;
    }
}
