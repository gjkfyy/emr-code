
package pkuhit.iih.mr.wr;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import ei.cis.service.CisService;

import pkuhit.iih.mr.pub.MessageCode;
import pkuhit.iih.mr.wr.dao.CusOrgEmpDeptDao;
import pkuhit.iih.pub.PerformancePrinter;
import pkuhit.xap.ac.Session;
import pkuhit.xap.ac.User;
import pkuhit.xap.ac.UserService;
import pkuhit.xap.pm.ParamsSetService;
import pkuhit.xap.sy.SysConfigService;
import xap.sv.annotation.Reference;
import xap.sv.model.SingleResult;
import xap.sv.model.SingleResultBuilder;
import xap.sv.notification.Notification;
import xap.sv.notification.exception.NotificationException;

public class SignUserServiceImpl implements SignUserService {

//	@Reference
//	DataObjectService dataObjectService;
	
	@Reference
	UserService userService;
	
//	@Reference
//	MedicalRecordService medicalRecordService;
	
//	@Reference
//	WorkGroupEmpService workGroupEmpService;
	
	@Reference
	SysConfigService sysConfigService;
	
//	@Reference
//	AmrService amrService;
	
	@Autowired
	CusOrgEmpDeptDao cusOrgEmpDeptDao;
	
	@Reference
    CisService cisService;
	
	@Reference
	ParamsSetService paramsSetService;

	/*
	 * (non-Javadoc)
	 * @see pkuhit.iih.mr.wr.SignUserService#searchSignUser(java.util.Map)
	 */
	@Override
	public SingleResult<User> searchSignUser()
		throws Throwable {
		Session session=Session.get();
		String userId=session.getUserId();
		String deptCd=session.getDeptId();
		if(null == userId){
			Notification notification = new Notification(MessageCode.MISS_PARAM,"【用户名】");
			throw new NotificationException(notification);
		}
		SingleResult<User> result = null;
		SingleResultBuilder<User> builder = SingleResultBuilder.newSingleResult(User.class);
		PerformancePrinter.start("userService.get");
		User user=userService.selectUserById(userId).getData();
		PerformancePrinter.end("userService.get");
		PerformancePrinter.start("sysConfigService.get");
		String useCa=(String) sysConfigService.getObject("useCa");
		PerformancePrinter.end("sysConfigService.get");
		user.setUseCa(useCa);
		SingleResult<String> flagCisCaState = paramsSetService.searchFunFlagByKey("CIS_IS_USE_CA") ;
		if(null != flagCisCaState &&  null != flagCisCaState.getData() && flagCisCaState.getData().equalsIgnoreCase("1")){
			List<Map<String, Object>> isUseCaList = cisService.getCaState(user.getXapUserPk());
			if(isUseCaList.size()==1){
				String isUseCa=(String) isUseCaList.get(0).get("is_use_ca");
				if(null!=isUseCa&&!"".equals(isUseCa)){
					user.setIsUseCa(isUseCa);
				}
			}
		}
		PerformancePrinter.start("selectByDeptCdAndEmpId");
		List<Map<String,Object>> list=cusOrgEmpDeptDao.selectByDeptCdAndEmpId(deptCd, userId);
		if(list.size()==1){
			String signLvlCd=(String) list.get(0).get("SIGN_LVL_CD");
			if(null!=signLvlCd&&!"".equals(signLvlCd)){
				user.setSignLevelCode(signLvlCd);
			}
		}
		PerformancePrinter.end("selectByDeptCdAndEmpId");
		if(null!=user){
			builder.withData(user);
		}
		result=builder.build();
		return result;
	}

}
