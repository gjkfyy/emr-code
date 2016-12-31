package pkuhit.iih.system.status;

import org.apache.shiro.session.mgt.eis.EnterpriseCacheSessionDAO;
import org.apache.shiro.session.mgt.eis.SessionDAO;
import org.springframework.beans.factory.annotation.Autowired;

import pkuhit.xap.up.ClientUpdateService;
import xap.sv.annotation.Reference;

public class SystemStatusServiceImpl implements SystemStatusService {

	@Autowired
	SessionDAO sessionDAO;
	
	@Reference
	ClientUpdateService clientUpdateService;
	
	@Override
	public int getSessionSize() {
		// TODO Auto-generated method stub
		EnterpriseCacheSessionDAO enterpriseCacheSessionDAO = (org.apache.shiro.session.mgt.eis.EnterpriseCacheSessionDAO) sessionDAO;
		if (enterpriseCacheSessionDAO.getActiveSessionsCache() != null) {
			// TODO 导出当前session到一个文件，查看是否有过期session。
//			Collection<Session> list = enterpriseCacheSessionDAO.getActiveSessions();
//			for (Session session : list) {
//				session.getLastAccessTime();
//				System.out.println(session.getAttribute("pkuhit.xap.ac.Session_session_user_name_key"));
//			}
			return enterpriseCacheSessionDAO.getActiveSessionsCache().size();
		}
		return 0;
	}
	@Override
	public String getSystemStatus(){
		int sessionSize = getSessionSize();
		String version = clientUpdateService.getVersion();
		String statusMsg = "the current version is : "+version+"\r\nthe current session size : "+sessionSize;
		return statusMsg;
	}

}
