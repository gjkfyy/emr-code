package pkuhit.xap.up;

import pkuhit.xap.sy.SysConfigService;
import xap.sv.annotation.Reference;

public class ClientUpdateServiceImpl implements ClientUpdateService{
	
	@Reference
	SysConfigService sysConfigService;
	
	
	@Override
	public String getVersion() {
		// TODO Auto-generated method stub
		String clientVersion = (String) sysConfigService.getObject("iemr.version");
		String version=clientVersion;
		return version;
	}

}
