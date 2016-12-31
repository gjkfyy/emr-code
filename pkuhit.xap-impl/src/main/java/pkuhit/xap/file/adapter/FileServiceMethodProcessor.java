package pkuhit.xap.file.adapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServletServerHttpResponse;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.method.support.ModelAndViewContainer;

import pkuhit.xap.file.FileObject;
import pkuhit.xap.file.ObjectData;
import pkuhit.xap.file.converter.FileObjectHttpMessageConverter;
import xap.sv.servlet.mvc.annotation.RequestBody;

public class FileServiceMethodProcessor implements
        HandlerMethodReturnValueHandler, HandlerMethodArgumentResolver
{
    FileObjectHttpMessageConverter fileObjectHttpMessageConverter = new FileObjectHttpMessageConverter();

    @Override
    public boolean supportsReturnType(MethodParameter returnType)
    {
        return FileObject.class.isAssignableFrom(returnType.getParameterType());
    }

    @Override
    public void handleReturnValue(Object returnValue,
            MethodParameter returnType, ModelAndViewContainer mavContainer,
            NativeWebRequest webRequest) throws Exception
    {
        FileObject fi = (FileObject) returnValue;
        ServletServerHttpResponse response = new ServletServerHttpResponse(
                webRequest.getNativeResponse(HttpServletResponse.class));
        fileObjectHttpMessageConverter.write(fi,
                MediaType.APPLICATION_OCTET_STREAM, response);
        response.flush();
        response.close();
    }

    @Override
    public boolean supportsParameter(MethodParameter parameter)
    {
        return (parameter.hasParameterAnnotation(RequestBody.class) && byte[].class.equals(parameter.getParameterType()));
    }

    @Override
    public Object resolveArgument(MethodParameter parameter,
            ModelAndViewContainer mavContainer, NativeWebRequest webRequest,
            WebDataBinderFactory binderFactory) throws Exception
    {
        HttpServletRequest nr = webRequest.getNativeRequest(HttpServletRequest.class);
        return new ObjectData(nr.getInputStream()).asByteArray();
    }
}
