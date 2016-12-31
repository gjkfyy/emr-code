package pkuhit.me;

import javax.servlet.http.HttpServletRequest;

import org.springframework.cache.Cache.ValueWrapper;

import xap.sv.service.meta.CacheableServiceMetadataRepository;
import xap.sv.service.meta.ServiceMetadata;
import xap.sv.service.meta.ServiceMetadataStore;

public class ServiceMetadataRepositoryProxy extends
        CacheableServiceMetadataRepository
{
    // @Reference
    // ServiceMetadataStore delegate;

    @Override
    public ServiceMetadata getServiceMetadataByRequest(
            HttpServletRequest request)
    {
        ServiceMetadataKey key = this.createKeyByRequest(request);
        return getServiceMetadataByKey(key);
    }

    @Override
    public ServiceMetadata getServiceMetadataByKey(ServiceMetadataKey key)
    {
        ValueWrapper vw = this.getCache().get(key.toString());
        if (vw != null)
        {
            ServiceMetadata meta = (ServiceMetadata) vw.get();
            if (meta != null)
            {
                return meta;
            }
        }
        return null;
        // return delegate.getServiceMetadataByKey(key);
    }

    @Override
    protected ServiceMetadataStore getDelegate()
    {
        return null;
    }
}
