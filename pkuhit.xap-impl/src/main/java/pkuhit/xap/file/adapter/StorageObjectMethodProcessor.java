package pkuhit.xap.file.adapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.MethodParameter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServletServerHttpResponse;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.method.support.ModelAndViewContainer;

import pkuhit.xap.file.ObjectData;
import pkuhit.xap.file.ObjectMetadata;
import pkuhit.xap.file.StorageObject;

public class StorageObjectMethodProcessor implements
        HandlerMethodReturnValueHandler, HandlerMethodArgumentResolver
{
    @Override
    public boolean supportsReturnType(MethodParameter returnType)
    {
        return StorageObject.class.isAssignableFrom(returnType.getParameterType());
    }

    @Override
    public void handleReturnValue(Object returnValue,
            MethodParameter returnType, ModelAndViewContainer mavContainer,
            NativeWebRequest webRequest) throws Exception
    {
        StorageObject so = (StorageObject) returnValue;
        ServletServerHttpResponse response = new ServletServerHttpResponse(
                webRequest.getNativeResponse(HttpServletResponse.class));
        try
        {
            HttpHeaders headers = response.getHeaders();
            Long size = null;
            MediaType mt = null;
            if (so != null)
            {
                ObjectMetadata meta = so.getMeta();
                size = meta.getSize();
                mt = meta.getMediaType();
            }
            else
            {
                size = 0L;
                mt = MediaType.APPLICATION_OCTET_STREAM;
            }
            headers.setContentLength(size);
            headers.setContentType(mt);
            ObjectData od = so.getData();
            od.writeTo(response.getBody());
        }
        finally
        {
            response.close();
        }
    }

    @Override
    public boolean supportsParameter(MethodParameter parameter)
    {
        return ObjectData.class.isAssignableFrom(parameter.getParameterType());
    }

    @Override
    public Object resolveArgument(MethodParameter parameter,
            ModelAndViewContainer mavContainer, NativeWebRequest webRequest,
            WebDataBinderFactory binderFactory) throws Exception
    {
        // StorageRequest sr = (StorageRequest) webRequest.getAttribute(
        // StorageRequest.STORAGE_REQUEST_KEY,
        // RequestAttributes.SCOPE_REQUEST);
        // if (sr != null && sr.isObjectWriteRequest())
        // {
        // ObjectMetadata meta = sr.getMetadata();
        // HttpServletRequest nr =
        // webRequest.getNativeRequest(HttpServletRequest.class);
        // return new ObjectData(nr.getInputStream());
        // StorageObject sd = new StorageObject(meta, data);
        // return sd;
        // }
        HttpServletRequest nr = webRequest.getNativeRequest(HttpServletRequest.class);
        return new ObjectData(nr.getInputStream());
    }
}
