package pkuhit.xap.file.adapter;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.MediaType;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.method.support.HandlerMethodArgumentResolverComposite;
import org.springframework.web.method.support.HandlerMethodReturnValueHandlerComposite;
import org.springframework.web.servlet.HandlerExecutionChain;

import pkuhit.xap.file.FileService;
import xap.sv.app.Application;
import xap.sv.servlet.BaseServiceAdapter;

public class FileServiceAdapter extends BaseServiceAdapter
{
    public final static FileServiceMethodProcessor FILE_SERVICE_METHOD_PROCESSOR = new FileServiceMethodProcessor();

    @Override
    protected boolean shouldHandle(HttpServletRequest request)
    {
        try
        {
            HandlerExecutionChain chain = Application.getInstance().getRequestMappingHandlerMapping().getHandler(
                    request);
            HandlerMethod hm = (HandlerMethod) chain.getHandler();
            return FileService.class.isAssignableFrom(hm.getBeanType());
        }
        catch (Exception e)
        {
            return false;
        }
    }

    @Override
    protected HandlerMethodArgumentResolverComposite getArgumentResolvers(
            MediaType mediaType)
    {
        HandlerMethodArgumentResolverComposite resolvers = super.getArgumentResolvers(mediaType);
        resolvers.addResolver(FILE_SERVICE_METHOD_PROCESSOR);
        return resolvers;
    }

    @Override
    protected HandlerMethodReturnValueHandlerComposite getReturnValueHandlers(
            Collection<MediaType> mediaTypes)
    {
        HandlerMethodReturnValueHandlerComposite handlers = new HandlerMethodReturnValueHandlerComposite();
        handlers.addHandler(FILE_SERVICE_METHOD_PROCESSOR);
        mediaTypes.add(MediaType.APPLICATION_JSON);
        handlers.addHandlers(super.getReturnValueHandlers(mediaTypes).getHandlers());
        return handlers;
    }
}
