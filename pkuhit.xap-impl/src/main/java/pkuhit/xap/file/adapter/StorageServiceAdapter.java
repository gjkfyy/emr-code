package pkuhit.xap.file.adapter;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.MediaType;
import org.springframework.web.method.support.HandlerMethodArgumentResolverComposite;
import org.springframework.web.method.support.HandlerMethodReturnValueHandlerComposite;

import pkuhit.xap.file.StorageService;
import xap.sv.annotation.Reference;
import xap.sv.servlet.BaseServiceAdapter;

public class StorageServiceAdapter extends BaseServiceAdapter
{
    @Reference
    StorageService StorageService;

    public final static StorageObjectMethodProcessor STORAGE_OBJECT_METHOD_PROCESSOR = new StorageObjectMethodProcessor();

    @Override
    protected boolean shouldHandle(HttpServletRequest request)
    {
        StorageRequest sr = new StorageRequest(request);
        // 不是存储服务的请求，返回
        return sr.isValid();
    }

    @Override
    protected void handle(HttpServletRequest request,
            HttpServletResponse response) throws Exception
    {
        // TODO 删除，这里测试用
        request.setAttribute("ownerId", "TestsUserName123");
        super.handle(request, response);
    }

    @Override
    protected HandlerMethodArgumentResolverComposite getArgumentResolvers(
            MediaType mediaType)
    {
        HandlerMethodArgumentResolverComposite resolvers = super.getArgumentResolvers(mediaType);
        resolvers.addResolver(STORAGE_OBJECT_METHOD_PROCESSOR);
        return resolvers;
    }

    @Override
    protected HandlerMethodReturnValueHandlerComposite getReturnValueHandlers(
            Collection<MediaType> mediaTypes)
    {
        HandlerMethodReturnValueHandlerComposite handlers = new HandlerMethodReturnValueHandlerComposite();
        handlers.addHandler(STORAGE_OBJECT_METHOD_PROCESSOR);
        // TODO 实现更好的方式设置Response的类型
        mediaTypes.add(MediaType.APPLICATION_JSON);
        handlers.addHandlers(super.getReturnValueHandlers(mediaTypes).getHandlers());
        return handlers;
    }
}
