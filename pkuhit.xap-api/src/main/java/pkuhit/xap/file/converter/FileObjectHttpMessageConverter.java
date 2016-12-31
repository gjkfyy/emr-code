package pkuhit.xap.file.converter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;

import pkuhit.xap.file.FileObject;

public class FileObjectHttpMessageConverter implements
        HttpMessageConverter<FileObject>
{
    final static String FILE_OBJECT_ID_KEY = "FILE_OBJECT_ID";

    final static String FILE_OBJECT_SIZE_KEY = "FILE_OBJECT_SIZE";

    private List<MediaType> supportedMediaTypes = new ArrayList<MediaType>();

    public FileObjectHttpMessageConverter()
    {
        this.supportedMediaTypes.add(MediaType.APPLICATION_OCTET_STREAM);
    }

    @Override
    public boolean canRead(Class<?> clazz, MediaType mediaType)
    {
        return FileObject.class.equals(clazz);
    }

    @Override
    public boolean canWrite(Class<?> clazz, MediaType mediaType)
    {
        return FileObject.class.equals(clazz);
    }

    @Override
    public List<MediaType> getSupportedMediaTypes()
    {
        return Collections.unmodifiableList(supportedMediaTypes);
    }

    @Override
    public FileObject read(Class<? extends FileObject> clazz,
            HttpInputMessage inputMessage) throws IOException,
            HttpMessageNotReadableException
    {
        HttpHeaders headers = inputMessage.getHeaders();
        String foid = headers.getFirst(FILE_OBJECT_ID_KEY);
        String size = headers.getFirst(FILE_OBJECT_SIZE_KEY);
        FileObject fo = new FileObject(foid, Long.parseLong(size),
                inputMessage.getBody());
        return fo;
    }

    @Override
    public void write(FileObject t, MediaType contentType,
            HttpOutputMessage outputMessage) throws IOException,
            HttpMessageNotWritableException
    {
        HttpHeaders headers = outputMessage.getHeaders();
        headers.setContentType(contentType);
        headers.add(FILE_OBJECT_ID_KEY, t.getId());
        headers.add(FILE_OBJECT_SIZE_KEY, t.getSize().toString());
        t.writeTo(outputMessage.getBody());
    }
}
