package pkuhit.me;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import xap.sv.service.meta.ServiceMetadata;

public interface ServiceRegistry
{
    @RequestMapping(value = "/services/{bundleId}/{serviceName}", method = RequestMethod.GET)
    ServiceMetadata getServiceMetadata(
            @PathVariable("bundleId") String bundleId,
            @PathVariable("serviceName") String serviceName);

    @RequestMapping(value = "/services/{bundleId}", method = RequestMethod.GET)
    ServiceMetadata[] getServiceMetadatas(
            @PathVariable("bundleId") String bundleId);

    @RequestMapping(value = "/serverInfo", method = RequestMethod.GET)
    ServerInfo getServerInfo();
}
