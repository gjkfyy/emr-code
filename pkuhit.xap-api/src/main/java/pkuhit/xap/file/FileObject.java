package pkuhit.xap.file;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileObject
{
    String id;

    String name;

    Long size;

    ObjectData data;

    public FileObject(String id, Long size, InputStream in) throws IOException
    {
        this.id = id;
        this.size = size;
        this.data = new ObjectData(in);
    }

    public String getId()
    {
        return id;
    }

    public Long getSize()
    {
        return size;
    }

    public InputStream asInputStream() throws IOException
    {
        return data.asInputStream();
    }

    public byte[] asByteArray() throws IOException
    {
        return this.data.asByteArray();
    }

    public void writeTo(OutputStream out) throws IOException
    {
        data.writeTo(out);
    }

    public enum Type
    {
        BIZ, BASE
    }
}
