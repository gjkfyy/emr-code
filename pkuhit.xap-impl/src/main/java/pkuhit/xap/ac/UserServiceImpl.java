package pkuhit.xap.ac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.sql.Clob;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.shiro.codec.Hex;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.seasar.doma.jdbc.SelectOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import pkuhit.md.DictionaryService;
import pkuhit.org.Employee;
import pkuhit.org.dao.auto.OrgDao;
import pkuhit.org.dao.auto.OrgEmpDeptDao;
import pkuhit.org.dao.auto.entity.Org;
import pkuhit.org.dao.auto.entity.OrgEmp;
import pkuhit.org.dao.auto.entity.OrgEmpDept;
import pkuhit.org.dao.custom.CustomOrgDao;
import pkuhit.xap.dao.auto.XapRoleDao;
import pkuhit.xap.dao.auto.XapUserDao;
import pkuhit.xap.dao.auto.XapUserRoleDao;
import pkuhit.xap.dao.auto.entity.XapRole;
import pkuhit.xap.dao.auto.entity.XapUser;
import pkuhit.xap.dao.auto.entity.XapUserRole;
import pkuhit.xap.dao.custom.CustomOrgEmpDeptDao;
import pkuhit.xap.dao.custom.CustomXapUserDao;
import pkuhit.xap.dao.custom.CustomXapUserRoleDao;
import pkuhit.xap.pm.ParamsSetService;
import pkuhit.xap.pub.MessageCode;
import pkuhit.xap.util.BeanCopyUtil;
import xap.sv.annotation.Reference;
import xap.sv.dao.DaoFactory;
import xap.sv.i18n.MessageSource;
import xap.sv.log.DebugLogger;
import xap.sv.model.ArrayResult;
import xap.sv.model.ArrayResultBuilder;
import xap.sv.model.SingleResult;
import xap.sv.model.SingleResultBuilder;
import xap.sv.notification.Notification;
import xap.sv.notification.exception.NotificationException;
import xap.util.UUIDGenerator;
public class UserServiceImpl implements UserService
{
    @Autowired
    XapUserDao xapUserDao;

    @Autowired
    CustomXapUserDao cusXapUserDao;
    
    @Autowired
    OrgDao orgDao ;
    
    @Autowired
    OrgEmpDeptDao orgEmpDeptDao;
    
    @Autowired
    CustomOrgDao customOrgDao;
    
    @Autowired
    CustomOrgEmpDeptDao customOrgEmpDeptDao ;
    
    @Autowired
	XapRoleDao xapRoleDao;
    
    @Autowired
    CustomXapUserRoleDao customXapUserRoleDao;

    @Reference
    MessageSource messageSource;
    
	@Reference
	private DictionaryService dictionaryService;

	@Autowired
	XapUserRoleDao xapUserRoleDao;
	
	@Autowired
	CustomXapUserRoleDao cusXapUserRoleDao;


	@Reference
	ParamsSetService paramsSetService;
	
	@Reference
    DaoFactory daoFactory;
	
	@Autowired
	CustomXapUserDao customXapUserDao;
	
    @Override
    public User create(User user)
    {
        // TODO Auto-generated method stub
        XapUser xapUser = new XapUser();

        if (StringUtils.isEmpty(user.getId()))
        {
            throw new NotificationException(new Notification(
                    MessageCode.M10010,
                    messageSource.fetchMessage(MessageCode.M10021)));
        }

        if (StringUtils.isEmpty(user.getEmployeeId()))
        {
            throw new NotificationException(new Notification(
                    MessageCode.M10010,
                    messageSource.fetchMessage(MessageCode.M10022)));
        }

        if (StringUtils.isEmpty(user.getOrganizationCode()))
        {
            throw new NotificationException(new Notification(
                    MessageCode.M10010,
                    messageSource.fetchMessage(MessageCode.M10023)));
        }

        BeanCopyUtil.modelToEntity(xapUser, user);
        xapUser.setPwd(Md5Hash.fromHexString(
                Hex.encodeToString(user.getPassword().getBytes())).toString());
        xapUserDao.insert(xapUser);
        return user;
    }

    @Override
    public SingleResult<User> update(String userId, User user)
    {
    	//■　数据校验
        if (StringUtils.isEmpty(userId))
        {
            throw new NotificationException(new Notification(
                    MessageCode.M10010, "id"));
        }
        
        //■ 更新用户信息 
        //更新用户主信息 
        XapUser xapUser = xapUserDao.selectById(userId);
        String signPicture = user.getSignPicture();
		XapUserDao dao = daoFactory.getDao(XapUserDao.class);
        Clob clob = dao.createClob();
        try {
			clob.setString(1, signPicture);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(xapUser != null){
			xapUser.setSignPic(clob);
			xapUserDao.update(xapUser);
		}
//        String password = user.getPassword();
//        if (password != null && !password.equals(xapUser.getPwd())) {
//        	xapUser.setPwd(Md5Hash.fromHexString(Hex.encodeToString(password.getBytes())).toString());
//        }
        
//        xapUser.setUserStaCd(user.getStatusCode());
//	    xapUserDao.updateExcludeNull(xapUser);
        
        //更新用户角色
        this.deleteUserRoleByUserId(user.getId());
        List<UserRole> userRoleList = user.getUserRoleList();
        if (userRoleList != null) {
        	for(UserRole item:userRoleList) {
        		item.setUserId(user.getId());
        		this.saveUserRole(item);
        	}
        }
        
       //更新出诊科室信息：审签等级、上级医师
        List<WardDeptModel> wardDeptList = user.getWardDeptList();
        if(wardDeptList != null){
        	for(WardDeptModel item:wardDeptList){
        		this.saveOrgEmpDept(item);
        	}
        }
        
        //■　返回更新后的用户
//        xapUser = xapUserDao.selectById(userId);
        //String orgCd = Session.get().getOrgCd();
        user = this.wrapData(xapUser, null);
        SingleResultBuilder<User> builder = SingleResultBuilder.newSingleResult(User.class);
        builder.withData(user);
		return builder.build();
    }
    
	private void saveUserRole(UserRole userRole){
	    XapUserRole xapUserRole = new XapUserRole();
	    xapUserRole.setUserRoleCd(UUIDGenerator.getUUID());
	    xapUserRole.setUserId(userRole.getUserId());
	    xapUserRole.setRoleCd(userRole.getRoleCode());
	    xapUserRole.setOrgCd(userRole.getOrganizationCode());
	    xapUserRoleDao.insert(xapUserRole);
	}
    
	private void deleteUserRoleByUserId(String userId){
	    List<XapUserRole> list = cusXapUserRoleDao.selectXapUserRoleList(userId, null, null);
	    if (list != null){
	        xapUserRoleDao.batchDelete(list);
        }
	}    
	
	private void saveOrgEmpDept(WardDeptModel wardDept){
		String empDeptCd = wardDept.getEmpDeptCd();
		if(empDeptCd!=null){
			if(!empDeptCd.isEmpty()){
				OrgEmpDept orgEmpDept = orgEmpDeptDao.selectById(empDeptCd);
				orgEmpDept.setCurDrcDctId(wardDept.getCurDrcDctId());
				orgEmpDept.setCurDeputyDrcDctId(wardDept.getCurDeputyDrcDctId());
				orgEmpDept.setSignLvlCd(wardDept.getSignLvlCd());
				orgEmpDeptDao.updateExcludeNull(orgEmpDept);
			}
		}
	}

    @Override
    public String delete(String userId)
    {
        // TODO Auto-generated method stub
        XapUser xapUser = xapUserDao.selectById(userId);
        xapUserDao.delete(xapUser);
        return "";
    }

    @Override
    public SingleResult<User> selectById(String userId)
    {
        XapUser xapUser = xapUserDao.selectById(userId);
        
        //String orgCd = Session.get().getOrgCd();
        //User user = this.wrapData(xapUser, orgCd);
        //TODO 目前用户角色还不支持院区隔离
        User user = this.wrapData(xapUser, null);
        Clob clob = null;
        if (xapUser != null)
        {
            clob = xapUser.getSignPic();
        }
        try
        {
            if(clob!=null && clob.length()!=0){
	            String content = clob.getSubString((long)1,(int)clob.length());
	            user.setSignPicture(content);
            }
        }
        catch (Exception e)
        {
            throw new RuntimeException(e);
        }
        SingleResultBuilder<User> builder = SingleResultBuilder.newSingleResult(User.class);
        builder.withData(user);
		return builder.build();
    }
    
    @Override
    public SingleResult<User> selectUserById(String userId)
    {
    	XapUser xapUser = xapUserDao.selectById(userId);
    	
    	//String orgCd = Session.get().getOrgCd();
    	//User user = this.wrapData(xapUser, orgCd);
    	//TODO 目前用户角色还不支持院区隔离
    	User user = new User();
    	BeanCopyUtil.entityToModel(user, xapUser, User.OBJ_CD, dictionaryService);
    	String jobTitleName = customXapUserDao.searchJobTitle(user.getJobTitleCode());
    	user.setJobTitleName(jobTitleName);
    	SingleResultBuilder<User> builder = SingleResultBuilder.newSingleResult(User.class);
    	builder.withData(user);
    	return builder.build();
    }

    @Override
    public ArrayResult<User> search(Map<String, String> params)
    {
    	//■ 查询数据
        //科室编码
    	String orgCd = getParamValue(params, "orgCd");
    	if(orgCd!=null){
    		if("undefined".equals(orgCd.trim())){
        		orgCd = null;
        	}
    	}
        String statusCd = getParamValue(params, "statusCd");
        String userId = getParamValue(params, "userId");
        String name = getParamValue(params, "name");
        String curDeptNm = getParamValue(params, "curDeptNm");
        String empId = getParamValue(params, "empId");
        String pageNum = null;
		String pageSize = null;
		if (params.containsKey("pageNum") && params.containsKey("pageSize")) {
			pageNum = (String) params.get("pageNum");
			pageSize = (String) params.get("pageSize");
		}
		if (org.apache.commons.lang3.StringUtils.isBlank(pageNum)) {
			pageNum = "1";
		}
		if (org.apache.commons.lang3.StringUtils.isBlank(pageSize)) {
			pageSize = "20";
		}
		SelectOptions options = SelectOptions.get().offset((Integer.valueOf(pageNum) - 1) * Integer.valueOf(pageSize))
				.limit(Integer.valueOf(pageSize)).count();
		 //wangyanli add 添加参数 dctNsF 2016-11-8
        String dctNsF = getParamValue(params, "dctNsF");
        List<XapUser> list = cusXapUserDao.selectXapUserList(orgCd, statusCd, userId, name, curDeptNm,empId,dctNsF,options);
        
        //■　装配并返回
        ArrayResultBuilder<User> builder = ArrayResultBuilder.newArrayResult(User.class);
        int size = 0;
        if (list != null && list.size() > 0)
        {
            User[] userList = new User[list.size()];
            int i = 0;
            for (XapUser xapUser : list)
            {
                userList[i] = this.wrapData(xapUser, orgCd);
                i++;
            }
            
            builder.withData(userList);
            size = userList.length;
        }
        
        ArrayResult<User> arrayResult = builder.build();
        arrayResult.setTotal(Integer.valueOf(options.getCount()+""));
        return arrayResult;
    }
    
    private User wrapData(XapUser xapUser, String orgCd) {
    	User user = new User();
    	BeanCopyUtil.entityToModel(user, xapUser, User.OBJ_CD, dictionaryService);
    	
    	//设置用户角色列表
    	List<UserRole> userRoleList = this.getUserRoleAndDeptList(user.getId());
    	user.setUserRoleList(userRoleList);
    	
    	//设置出诊科室列表
    	List<Map<String, Object>> wardDeptList = customOrgEmpDeptDao.selectWardDeptByUserId(user.getId());
    	List<WardDeptModel> wardDeptModelList = new ArrayList<WardDeptModel>();
    	for(int i=0; i<wardDeptList.size();i++){
    		WardDeptModel wardDeptModel = new WardDeptModel();
        	BeanCopyUtil.mapToModel(wardDeptModel, wardDeptList.get(i));
        	wardDeptModelList.add(wardDeptModel);
    	}
    	user.setWardDeptList(wardDeptModelList);
    	
    	//设置所属科室名称
    	String serviceDepartName = "";
    	Map<String, Object> orgEmpDeptMap = customOrgEmpDeptDao.selectDeptNmByOrgCd(user.getOrganizationCode());
    	if(orgEmpDeptMap!=null){
        	serviceDepartName = orgEmpDeptMap.get("NM").toString();
    	}
		
    	user.setServiceDepartName(serviceDepartName);
    	
    	return user;
    }
    
    private List<UserRole> getUserRoleAndDeptList(String userId) {
    	List<UserRole> userRoleList = new ArrayList<UserRole>();
    	
    	List<XapUserRole> xapUserRoleList = this.customXapUserRoleDao.selectXapUserRoleList(userId, null, null);
    	for (XapUserRole item:xapUserRoleList) {
    		UserRole userRole = new UserRole();
    		BeanCopyUtil.entityToModel(userRole, item, null, dictionaryService);
    		
    		//设置角色名称
    		XapRole role = xapRoleDao.selectById(userRole.getRoleCode());
    		if (role != null) {
    			userRole.setRoleName(role.getNm());
    		}
    		
    		//设置部门名称
    		Map<String, Object> orgEmpDept = customOrgEmpDeptDao.selectDeptNmByOrgCd(item.getOrgCd());
    		if(orgEmpDept!=null){
    			String deptNm = orgEmpDept.get("NM").toString();
    			userRole.setOrganizationName(deptNm);
    		}
    		
    		userRoleList.add(userRole);
    	}
    	
    	return userRoleList;
    }
    
    String getParamValue(Map<String, String> params, String paramName)
    {
        String value = params.get(paramName);
        if (!StringUtils.hasText(value))
        {
            return null;
        }
        return value;
    }

	@Override
	public ArrayResult<Employee> searchEmp(Map<String, String> params) {
		// TODO Auto-generated method stub
		String deptCd = params.get("deptCd");
		String keyword = params.get("keyword");
		String id = params.get("id");
    	int pageSize = 100;
    	if(StringUtils.hasText(params.get("pageSize"))){
    		pageSize = Integer.parseInt(params.get("pageSize"));
    	}
    	if (keyword != null) {
//			keyword = keyword.toLowerCase();
    		DebugLogger.log("searchEmp keyword:"
                    + keyword + "]");
		}
		SelectOptions options = SelectOptions.get().offset(0).limit(pageSize).count();
		List<OrgEmp> orgEmpList = customOrgDao.selectOrgEmpListByDept(keyword, deptCd, id, options);
		ArrayResult<Employee> arrayResult = new ArrayResult<Employee>();
		if (orgEmpList != null) {
			Employee [] empList = new Employee[orgEmpList.size()];
			int i = 0;
			for (OrgEmp orgEmp : orgEmpList) {
				Employee employee = new Employee();
				BeanCopyUtil.entityToModel(employee, orgEmp, null, dictionaryService);
				empList[i] = employee;
				i++;
			}
			arrayResult.setDataList(empList);
		}
		return arrayResult;
	}

	@Override
	public SingleResult<User> selectMrSignById(String userId) {
		SingleResult<User> result=new SingleResult<User>();
		User user=new User();
		XapUser xapUser=xapUserDao.selectById(userId);
		BeanCopyUtil.entityToModel(user, xapUser, "", dictionaryService);
		if(xapUser.getSignPic()==null&&"".equals(xapUser.getSignPic())){ 
			throw new NotificationException(new Notification(pkuhit.iih.mr.pub.MessageCode.USE_SGIN_PIC_NULL,userId));
		}else{
			if(xapUser.getSignPic()!=null)
			user.setSignPicture(this.clobToString(xapUser.getSignPic())) ;
		}
		result.setData(user);
		return result;
	}
	public String clobToString(Clob clob) {

		String reString = "";
		Reader is;
		try {
			is = clob.getCharacterStream();
			BufferedReader br = new BufferedReader(is);
			String s = br.readLine();
			StringBuffer sb = new StringBuffer();
			while (s != null) {// 执行循环将字符串全部取出付值给StringBuffer由StringBuffer转成STRING
			sb.append(s);
			s = br.readLine();
			}
			reString = sb.toString();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return reString;
		}
}
