package pkuhit.org;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import pkuhit.org.dao.custom.CustomNisWardConfigDao;

public class NisWardConfigServiceImpl implements NisWardConfigService
{
    @Autowired
    CustomNisWardConfigDao customNisWardConfigDao;
    
    @Override
    public List<Map<String, Object>> searchOrgByIp(String ip){
        return customNisWardConfigDao.selectOrgByIp(ip);
    }
}
