package pkuhit.xap.file;

import java.io.IOException;

import org.springframework.util.Assert;

import pkuhit.md.Dictionary;
import pkuhit.md.DictionaryService;
import pkuhit.xap.file.ObjectData;
import pkuhit.xap.file.ObjectMetadata;
import pkuhit.xap.file.StorageBucket;
import pkuhit.xap.file.StorageObject;
import pkuhit.xap.file.StorageService;
import xap.sv.annotation.Reference;

public class StorageServiceImpl implements StorageService
{
    @Reference
    DictionaryService dictionaryService;

    @Override
    public void createBucket(String ownerId, String bucketName,
            StorageBucket bucket)
    {
        Assert.hasText(ownerId);
    }

    @Override
    public StorageBucket[] listBuckets(String ownerId)
    {
        return null;
    }

    @Override
    public ObjectMetadata[] listObjects(String ownerId, String bucketName)
    {
        return null;
    }

    @Override
    public StorageObject readObject(String ownerId, String bucketName,
            String objectName)
    {
        String text = "this is test data!!";
        byte[] bytes = text.getBytes();
        ObjectData od = new ObjectData(bytes);
        ObjectMetadata meta = new ObjectMetadata("test1.jpg", new Long(
                bytes.length));
        StorageObject so = new StorageObject(meta, od);
        return so;
    }

    @Override
    public void writeObject(String ownerId, String bucketName, ObjectData data)
    {
        Assert.notNull(data);
        Assert.hasText(ownerId);
        Assert.hasText(bucketName);

        try
        {
            byte[] bytes = data.asByteArray();
            Assert.notNull(bytes);
        }
        catch (IOException e)
        {
            System.out.println("fail");
        }
    }
}