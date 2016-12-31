package pkuhit.me;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache.ValueWrapper;
import org.springframework.http.HttpMethod;
import org.springframework.util.Assert;

import pkuhit.me.dao.auto.entity.MeXsv;
import pkuhit.me.dao.custom.ServiceMetadataDao;
import xap.sv.component.LifeCycleComponent;
import xap.sv.service.meta.CacheableServiceMetadataRepository;
import xap.sv.service.meta.ServiceMetadata;
import xap.sv.service.meta.ServiceMetadataStore;
import xap.sv.service.meta.SimpleServiceMetadata;

public class DatabaseServiceMetadataRepository extends
        CacheableServiceMetadataRepository implements LifeCycleComponent
{
    @Autowired
    ServiceMetadataDao serviceMetadataDao;

    @Override
    public ServiceMetadata getServiceMetadataByRequest(
            HttpServletRequest request)
    {
        ServiceMetadataKey key = this.createKeyByRequest(request);
        return this.getServiceMetadataByKey(key);
    }

    @Override
    public ServiceMetadata getServiceMetadataByKey(ServiceMetadataKey key)
    {
        String strKey = key != null ? key.toString() : null;
        ValueWrapper vw = this.getCache().get(strKey);
        if (vw != null)
            return (ServiceMetadata) vw.get();
        return null;
    }

    @Override
    public void onStart()
    {
        this.getCache().clear();
        List<MeXsv> xsvList = serviceMetadataDao.selectAllMetadata();
        for (MeXsv xsv : xsvList)
        {
            createServiceMetadata(xsv);
        }
    }

    @Override
    public void onDestory()
    {
    }

    void createServiceMetadata(MeXsv xsv)
    {
        String httpMethod = xsv.getRestActCd();
        Assert.hasText(httpMethod, "httpMethod must not be empty");
        httpMethod = httpMethod.toUpperCase();
        String uriPattern = xsv.getRestRe();
        Assert.hasText(uriPattern, "uri must not be empty");
        ServiceMetadataKey key = new ServiceMetadataKey(uriPattern, httpMethod);
        SimpleServiceMetadata ssm = new SimpleServiceMetadata();
        ssm.setUri(uriPattern);
        ssm.setRequestMethod(HttpMethod.valueOf(httpMethod));
        ssm.setCode(xsv.getXsvCd());
        ssm.setText(xsv.getNm());
        this.getCache().put(key.toString(), ssm);
    }

    @Override
    protected ServiceMetadataStore getDelegate()
    {
        // TODO no delegate
        return null;
    }
}
