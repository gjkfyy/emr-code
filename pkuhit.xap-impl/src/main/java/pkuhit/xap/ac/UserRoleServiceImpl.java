package pkuhit.xap.ac;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.codec.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.sun.org.apache.bcel.internal.generic.NEW;

import pkuhit.org.Organization;
import pkuhit.org.OrganizationService;
import pkuhit.xap.dao.auto.XapRoleDao;
import pkuhit.xap.dao.auto.XapUserDao;
import pkuhit.xap.dao.auto.XapUserRoleDao;
import pkuhit.xap.dao.auto.entity.XapRole;
import pkuhit.xap.dao.auto.entity.XapUser;
import pkuhit.xap.dao.auto.entity.XapUserRole;
import pkuhit.xap.dao.custom.CustomXapUserDao;
import pkuhit.xap.dao.custom.CustomXapUserRoleDao;
import pkuhit.xap.pub.MessageCode;
import pkuhit.xap.util.FileUtil;
import xap.sv.model.ArrayResult;
import xap.sv.model.SingleResult;
import xap.sv.model.SingleResultBuilder;
import xap.sv.notification.Notification;
import xap.sv.notification.exception.NotificationException;
import xap.sv.util.BeanCopyUtil;
import xap.util.UUIDGenerator;

public class UserRoleServiceImpl implements UserRoleService {
	private Logger log = LoggerFactory.getLogger(UserRoleServiceImpl.class);
	@Autowired
	XapUserRoleDao xapUserRoleDao;
	@Autowired
	XapRoleDao xapRoleDao;
	@Autowired
	XapUserDao xapUserDao;
	@Autowired
	CustomXapUserRoleDao cusXapUserRoleDao;
	@Autowired
	CustomXapUserDao cusXapUserDao;
	@Autowired
	OrganizationService organizationService;
	public final String NURSE_ROLE = "XAPM14.16" ; //临床护士
	
	
	public final String ORG_MRB_ROLE = "XAPM14.17" ; //全院模板管理员
	
	public final String DEPT_MRB_ROLE = "XAPM14.18" ; //科室模板管理员
	
	/**
	 * 1、定义model对象。user，orgList，roleList
	 * 2、修改user信息（只更新pwd及状态）。
	 * 3、将user对象解析为userRoleList对象。
	 * 3、删除userRoleList对象。
	 * 4、新增userRoleList对象。
	 * @description
	 * @author jiao_xiantong
	 * @date 2014年12月9日 下午5:48:27
	 * @param userRole
	 * @return
	 * @see pkuhit.xap.ac.UserRoleService#create(pkuhit.xap.ac.UserRole)
	 */
	@Override
	public SingleResult<UserRole> create(User user) {
		// 数据校验
		// TODO...

		// 插入用户角色记录到用户角色表
//		XapUserRole xapUserRole = new XapUserRole();
//		xapUserRole.setUserRoleCd(UUIDGenerator.getUUID());
//		xapUserRoleDao.insert(xapUserRole);
//
//		// 查询结果并返回结果
//		xapUserRole = xapUserRoleDao.selectById(xapUserRole.getUserRoleCd());
//		userRole = new UserRole();
//		BeanCopyUtil.beanCopy(userRole, xapUserRole);
//		userRole = setupAttachInfo(userRole);
		SingleResult<UserRole> result = new SingleResult<UserRole>();
//		result.setData(userRole);
	    //更新用户 TODO 指定更新两个字段
		/*XapUser xapUser = xapUserDao.selectById(user.getId());
//	    BeanCopyUtil.beanCopy(xapUser, user);
	    xapUser.setPwd(Md5Hash.fromHexString(Hex.encodeToString(user.getPassword().getBytes())).toString());
	    xapUser.setUserStaCd(user.getStatusCode());
	    xapUserDao.updateExcludeNull(xapUser);*/
	    //构建userRole对象，并删除及保存
	    deleteByUserId(user.getId());
//	    if (user.getOrganizationList() != null)
//        {
//            for (Organization organization : user.getOrganizationList())
//            {
//                if (organization.getRoleList() != null)
//                {
//                    for (Role role : organization.getRoleList())
//                    {
//                        UserRole userRole = new UserRole();
//                        userRole.setOrganizationCode(organization.getCode());
//                        userRole.setRoleCode(role.getCode());
//                        userRole.setUserId(user.getId());
//                        save(userRole);
//                    }
//                }
//            }
//        }
	    UserRole userRole = new UserRole();
	    result.setData(userRole);
		return result;
	}
	
	private void deleteByUserId(String userId){
	    List<XapUserRole> list = cusXapUserRoleDao.selectXapUserRoleList(userId, null, null);
	    if (list != null)
        {
	        xapUserRoleDao.batchDelete(list);
//            for (XapUserRole xapUserRole : list)
//            {
//                xapUserRoleDao.delete(xapUserRole);
//            }
        }
//	    cusXapUserRoleDao.deleteByUserId(userId);
	}
	/**
	 * 
	 * @description 
	 * @author jiao_xiantong
	 * @date 2014年12月10日 下午11:30:20
	 * @param userRole
	 */
	private void save(UserRole userRole){
	    XapUserRole xapUserRole = new XapUserRole();
	    xapUserRole.setUserRoleCd(UUIDGenerator.getUUID());
	    xapUserRole.setUserId(userRole.getUserId());
	    xapUserRole.setRoleCd(userRole.getRoleCode());
	    xapUserRole.setOrgCd(userRole.getOrganizationCode());
	    xapUserRoleDao.insert(xapUserRole);
	}

	@Override
	public SingleResult<UserRole> update(String userRoleId,  UserRole userRole) {
		// 数据校验
		// TODO...

		// 更新用户角色记录到用户角色表
		XapUserRole xapUserRole = xapUserRoleDao.selectById(userRoleId);
		if (xapUserRole == null) {
			Notification notification = new Notification(MessageCode.M10010, "userId");
			throw new NotificationException(notification);
		}
		
		
		//TODO...格式转换？？
		//启用时间
		//xapUserRole.setStartTime(userRole.getStartTime());
		//停用时间
		//xapUserRole.setStopTime(userRole.getStopTime());
		xapUserRoleDao.updateExcludeNull(xapUserRole);

		// 查询结果并返回结果
		userRole = new UserRole();
		xapUserRole = xapUserRoleDao.selectById(xapUserRole.getUserRoleCd());
		
		
		BeanCopyUtil.beanCopy(userRole, xapUserRole);
		userRole = setupAttachInfo(userRole);
		SingleResult<UserRole> result = new SingleResult<UserRole>();
		result.setData(userRole);
		return result;
	}

	@Override
	public SingleResult<UserRole> delete(String userRoleId) {
		//数据校验
		//TODO...
		
		//标记数据为逻辑删除
		XapUserRole xapUserRole = xapUserRoleDao.selectById(userRoleId);
		// TODO 删除标志常量定义在哪里？？
		xapUserRole.setDelF((short) 1);
		xapUserRoleDao.markDelete(xapUserRole);
		
		return new SingleResult<UserRole>();
	}

	@Override
	public SingleResult<UserRole> selectById(String userRoleId) {
		//数据校验
		//TODO...
		
		//查询数据
		XapUserRole xapUserRole = xapUserRoleDao.selectById(userRoleId);
		if (xapUserRole == null) {
			throw new NotificationException(new Notification(MessageCode.M10010, "111"));
		}
		
		UserRole userRole = new UserRole();
		BeanCopyUtil.beanCopy(userRole, xapUserRole);
		userRole = setupAttachInfo(userRole);
		
		//返回结果
		SingleResult<UserRole> result = new SingleResult<UserRole>();
		result.setData(userRole);
		return result;
	}

	@Override
	public ArrayResult<UserRole> search(Map<String, String> params) {
		String userId = null;
		if(params.containsKey("userId")){
			Object o = params.get("userId");
			if(null != o ){
				String os = (String)o;
				if(!StringUtils.isBlank(os)){
					userId = os ;
				}
			}
		}
		String orgCd = null;
		if(params.containsKey("orgCd")){
			Object o = params.get("orgCd");
			if(null != o ){
				String os = (String)o;
				if(!StringUtils.isBlank(os)){
					orgCd = os ;
				}
			}
		}
		String roleId = null;
		if(params.containsKey("roleId")){
			Object o = params.get("roleId");
			if(null != o ){
				String os = (String)o;
				if(!StringUtils.isBlank(os)){
					roleId = os ;
				}
			}
		}
		
		//TODO 可能需要考虑排序
		List<XapUserRole> list = cusXapUserRoleDao
				.selectXapUserRoleList(userId, orgCd, roleId);
		List<UserRole> userRoleList = new ArrayList<UserRole>();
		if (list != null) {
			for (XapUserRole xapUserRole : list) {
				UserRole userRole = this.wrapUserRole(xapUserRole);//new UserRole();
				
				userRoleList.add(userRole);
			}
		}
		
		ArrayResult<UserRole> result = new ArrayResult<UserRole>();
		UserRole[] userRoles = new UserRole[userRoleList.size()];
		result.setDataList(userRoleList.toArray(userRoles));
		return result;
	}

	
	private UserRole wrapUserRole(XapUserRole xapUserRole) {
		UserRole userRole = new UserRole();
		BeanCopyUtil.beanCopy(userRole, xapUserRole);
		userRole = setupAttachInfo(userRole);
		return userRole;
	}
	
	/**
	 * 设置用户角色关联的其他辅助信息字段
	 * 
	 * @param userRole
	 *            用户角色对象
	 * @return 用户角色对象
	 */
	private UserRole setupAttachInfo(UserRole userRole) {
		//设置角色名称
		XapRole role = xapRoleDao.selectById(userRole.getRoleCode());
		if (role != null) {
			userRole.setRoleName(role.getNm());
		}
		SingleResult<Organization> orgRs = organizationService.selectByCode(userRole.getOrganizationCode());
		if(null != orgRs && null != orgRs.getData()){
			userRole.setOrganizationName(orgRs.getData().getName());
		}
		//设置用户名称
		//TODO ?? 从人员表获取？ OR 用户表中添加用户名称字段。
		
		return userRole;
	}

	@Override
	public SingleResult<Integer> getDoctorOrNurseFlag(String userId) {
		//TODO 可能需要考虑排序
		Integer rsInteger = 1 ;
		SingleResultBuilder<Integer> builder = SingleResultBuilder.newSingleResult(Integer.class);
		List<XapUserRole> list = cusXapUserRoleDao.selectDoctorOrNurse(userId);
		if (list != null) {
			for (XapUserRole xapUserRole : list) {
				if(xapUserRole.getRoleCd().equalsIgnoreCase(NURSE_ROLE)){
					rsInteger = 0;
					break;
				}
			}
			builder.withData(rsInteger);
		}
		
		//根据用户id，获取角色
		return builder.build();
	}

	@Override
	public List<String> userRoleMrbDeptList(String userId , String searchDeptCode) {
	//	List<String> userRoleDeptListToSearch = new ArrayList<String>() ;//查询的科室范围
		Map<String, String> params = new HashMap<String, String>();
		params.put("userId", userId);
		ArrayResult<UserRole> results = search(params);//根据用户获得权限
		List<String> maxUserRoleList = new ArrayList<String>(); 
		List<String> deptCodeForRole = new ArrayList<String>(); 
		if (results != null && results.hasData()) {
			UserRole[] userRoles = results.getDataList();
			for(int i = 0 ; i < userRoles.length ; i++){
	       		UserRole ur = userRoles[i] ;
	       		if(ORG_MRB_ROLE.equalsIgnoreCase(ur.getRoleCode())){
	       			//能管理全院、所有科室的病历
	        		/*获得所有业务科室*/
	       			log.debug("能管理全院、所有科室的病历,获得所有业务科室");
	        			maxUserRoleList.add(ORG_MRB_ROLE);        			
	        	}else{ 
	        		if(DEPT_MRB_ROLE.equalsIgnoreCase(ur.getRoleCode())){
		        			//科室管理员，可以看到自己管理的科室
		        		maxUserRoleList.add(DEPT_MRB_ROLE);
		        		deptCodeForRole.add(ur.getOrganizationCode()); 
	        		}
	        	}
			}
		}
		if(maxUserRoleList.contains(ORG_MRB_ROLE)){//为全院病历管理员
			deptCodeForRole.clear();
			if(StringUtils.isBlank(searchDeptCode)){
				//科室条件为空，则全部可以查看的科室
				log.debug("科室条件为空，可以查看全部科室，return new ArryList");
			}else{
				deptCodeForRole.add(searchDeptCode);
			}
		}else{
			if(deptCodeForRole.isEmpty()){
				//没有可以查看的科室
				log.info("没有可以查看的科室,return null");
				return null;
			}else 
				if(StringUtils.isBlank(searchDeptCode)){
					//科室条件为空，则全部可以查看的科室
					log.debug("科室条件为空，可以查看全部科室，return new ArryList");
				}else{
					if(deptCodeForRole.contains(searchDeptCode)){
						//科室条件不为空，但是在权限范围内
						deptCodeForRole.clear();
						deptCodeForRole.add(searchDeptCode);
					}else{
						//科室条件不为空，但是在权限范围外，没有交叉
						log.info("科室条件不为空，但是在权限范围外，没有交叉,return null");
						return null;
					}
				}
		}
		return deptCodeForRole;
	
	}

	@Override
	public Object mrCheckSubmitUser(User user) {
		User resultUser=new User();
//		String iemrPwds = Base64.encodeToString("1234".getBytes());
//		String string=Base64.decodeToString("MTIzNA==".getBytes());
		String pwd = Base64.encodeToString(user.getPassword().getBytes());
		List<XapUserRole> xapUserRole=cusXapUserRoleDao.selectCheckUserRole(user.getLoginName(),user.getEmployeeId());
		if(xapUserRole!=null&&xapUserRole.size()>0){
			//验证医师是实习生
			resultUser.setStatusCode("2");
			return resultUser;
		}
		List<XapUser> xapUsers=cusXapUserDao.selectXapUserOnCheck(null, pwd, user.getLoginName());//user.getEmployeeId()
		if(xapUsers==null||xapUsers.size()<1){
			resultUser.setStatusCode("0");
			return resultUser;
		}
		XapUser xapUser =xapUsers.get(0);
		BeanCopyUtil.beanCopy(resultUser, xapUser);
		resultUser.setSignPicture(FileUtil.clobToString(xapUser.getSignPic())); 
		return resultUser;
	}

	@Override
	public Boolean checkPracticeDoctor(String userId,String deptCd) {
		List<XapUserRole> xapUserRoles=  cusXapUserRoleDao.selectCheckUserRole(userId,deptCd);
		if(xapUserRoles==null||xapUserRoles.size()<1){
			return true;//非实习医生
		}
		return false;
	}
}
