package pkuhit.xap.file;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import com.google.common.io.ByteSource;
import com.google.common.io.ByteStreams;

public class ObjectData
{
    ByteSource byteSource;

    public ObjectData(InputStream in) throws IOException
    {
        this.byteSource = ByteSource.wrap(ByteStreams.toByteArray(in));
    }

    public ObjectData(byte[] bytes)
    {
        this.byteSource = ByteSource.wrap(bytes);
    }

    public InputStream asInputStream() throws IOException
    {
        return byteSource.openStream();
    }

    public byte[] asByteArray() throws IOException
    {
        return this.byteSource.read();
    }

    public void writeTo(OutputStream out) throws IOException
    {
        out.write(this.asByteArray());
    }
}
