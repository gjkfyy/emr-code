package ei.cis.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import ei.cis.db.dao.CisMzClinicRoomConfigDao;
import ei.cis.service.CisMzClinicRoomConfigService;

public class CisMzClinicRoomConfigServiceImpl implements CisMzClinicRoomConfigService
{
    @Autowired
    CisMzClinicRoomConfigDao cisMzClinicRoomConfigDao;
    
    @Override
    public List<Map<String, Object>> searchDeptByIp(String ip)
    {
        return cisMzClinicRoomConfigDao.selectOrgByIp(ip);
    }
}
