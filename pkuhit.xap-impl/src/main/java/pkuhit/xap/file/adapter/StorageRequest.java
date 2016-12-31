package pkuhit.xap.file.adapter;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerExecutionChain;

import pkuhit.xap.file.ObjectMetadata;
import pkuhit.xap.file.StorageService;
import xap.sv.app.Application;

public class StorageRequest
{
    public final static String STORAGE_REQUEST_KEY = StorageRequest.class.getName()
        + "_storage_request_key";

    HttpServletRequest httpRequest;

    public StorageRequest(HttpServletRequest httpRequest)
    {
        this.httpRequest = httpRequest;
        this.httpRequest.setAttribute(STORAGE_REQUEST_KEY, this);
    }

    public boolean isValid()
    {
        HandlerExecutionChain chain;
        try
        {
            chain = Application.getInstance().getRequestMappingHandlerMapping().getHandler(
                    this.httpRequest);
            HandlerMethod hm = (HandlerMethod) chain.getHandler();
            // TODO
            return StorageService.class.isAssignableFrom(hm.getBeanType());
        }
        catch (Exception e)
        {
            return false;
        }
        // TODO 需要更灵活的方式
        // String path = httpRequest.getPathInfo();
        // if (StringUtils.hasText(path))
        // {
        // return path.startsWith("/xapss");
        // }
        // return false;
    }

    public boolean isObjectReadRequest()
    {
        return false;
    }

    public boolean isObjectWriteRequest()
    {
        return false;
    }

    public ObjectMetadata getMetadata()
    {
        this.httpRequest.getParameter("");
        // TODO meta service
        return null;
    }
}
