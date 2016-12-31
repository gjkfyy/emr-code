package pkuhit.xap.file;

import javax.activation.FileTypeMap;

import org.springframework.http.MediaType;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

public class ObjectMetadata
{
    String name;

    MediaType mediaType;

    Long size;

    public ObjectMetadata(String name, Long size)
    {
        Assert.hasText(name, "ObjectMetadata's name must not be null ");
        Assert.notNull(size, "ObjectMetadata's size must not be null ");
        this.name = name;
        this.size = size;
        String mimeType = FileTypeMap.getDefaultFileTypeMap().getContentType(
                name);
        if (StringUtils.hasText(mimeType))
        {
            mediaType = MediaType.parseMediaType(mimeType);
        }
        Assert.notNull(mediaType,
                "ObjectMetadata's mediaType must not be null ");
    }

    public String getName()
    {
        return name;
    }

    public MediaType getMediaType()
    {
        return mediaType;
    }

    public Long getSize()
    {
        return size;
    }
}
