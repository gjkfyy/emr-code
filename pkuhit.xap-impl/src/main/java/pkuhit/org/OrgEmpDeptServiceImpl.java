/**
 * 
 */
package pkuhit.org;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import pkuhit.md.DictionaryService;
import pkuhit.org.dao.auto.OrgEmpDeptDao;
import pkuhit.org.dao.auto.entity.OrgEmpDept;
import pkuhit.org.dao.custom.CustomWardDeptDao;
import pkuhit.xap.ac.User;
import pkuhit.xap.pm.ParamsSetService;
import pkuhit.xap.sy.SysConfigService;
import pkuhit.xap.util.BeanCopyUtil;
import xap.sv.annotation.Reference;
import xap.sv.model.ArrayResult;
import xap.sv.model.ArrayResultBuilder;
import xap.sv.model.SingleResult;
import xap.sv.model.SingleResultBuilder;
import xap.sv.servlet.RequestScope;


/**
 *  员工出诊科室服务类
 */
public class OrgEmpDeptServiceImpl implements OrgEmpDeptService {

	@Autowired
	OrgEmpDeptDao orgEmpDeptDao;
	
	@Autowired
	CustomWardDeptDao customWardDeptDao;
	

    @Reference
    pkuhit.xap.ac.UserService UserService;
    
    @Reference
    ParamsSetService paramsSetService;
    
    @Autowired
    SysConfigService sysConfigService;
    
	@Reference
	DictionaryService dictionaryService;
    
	@Override
	public SingleResult<EmpDept> updateOrgEmpDept(EmpDeptList empDeptList) {
		
		 List<EmpDept> list = null;
		if(empDeptList!=null){
			list = empDeptList.getEmpDeptList();
		}
		for(EmpDept empDept:list){
			OrgEmpDept orgEmpDept = new OrgEmpDept();
			orgEmpDept.setEmpDeptCd(empDept.getCode());
			orgEmpDept.setSortNo(empDept.getSortNo());
			orgEmpDeptDao.updateExcludeNull(orgEmpDept);
		}
        SingleResultBuilder<EmpDept> builder = SingleResultBuilder.newSingleResult(EmpDept.class);
        return builder.build();
	}

	@Override
    public ArrayResult<EmpDept> selectOrgEmpDept(Map<String, String> params)
    {
        ArrayResult<EmpDept> results = new ArrayResult<EmpDept>();
        ArrayResultBuilder<EmpDept> builder = ArrayResultBuilder.newArrayResult(EmpDept.class);
        String ip= RequestScope.getNativeRequest().getServletRequest().getRemoteAddr();
        
        //判断登录用户身份：0护士、1医生
        Short dctNsF = null;
        String userId = params.get("userId");
        Map<String, String> searchMap = new HashMap<String,String>();
        searchMap.put("userId", userId);
        searchMap.put("statusCd", "XAPM01.01");
        ArrayResult<User> users = UserService.search(searchMap);
        if(users != null && users.getTotal() > 0){
            User user = users.getDataList()[0];
            dctNsF = user.getDctNsF();
        }
        System.out.println("用户身份：" + dctNsF);
        
        if (dctNsF == 1){
            //医生登录
            String paramValue = paramsSetService.searchFunFlagByKey("DOCTOR_DEPT_ROOM_BY_IPADDR").getData();
            System.out.println("DOCTOR_DEPT_ROOM_BY_IPADDR参数：" + paramValue);
            if(!"1".equals(paramValue)){
            	//用户权限与出诊科室相关
                results = searchUserDepartments(params);
            }
        }else{
            //护士登录
            String paramValue = paramsSetService.searchFunFlagByKey("CHECH_IP_SEARCH_SELECT").getData();
            System.out.println("CHECH_IP_SEARCH_SELECT参数：" + paramValue);
            if(!"1".equals(paramValue)){
            	 //用户权限与病区相关
                results = searchUserDepartments(params);
            }
        }
        return results;
    }

	public ArrayResult<EmpDept> searchUserDepartments(Map<String, String> params) {
	    ArrayResult<EmpDept> results = new ArrayResult<EmpDept>();
	    ArrayResultBuilder<EmpDept> builder = ArrayResultBuilder.newArrayResult(EmpDept.class);
		
		String deployMode = "1";
		String userId = params.get("userId");
		deployMode = (String) sysConfigService.getObject("deployMode");
		
		Map<String, Object> mapOrgEmpDept = null;
		List<Map<String,Object>> orgEmpDeptList = this.customWardDeptDao.selectOrgEmpDeptListByUserId(userId,deployMode);
		if (orgEmpDeptList != null && orgEmpDeptList.size() > 0) {
			EmpDept[] voArray = new EmpDept[orgEmpDeptList.size()];
			for (int i = 0; i < orgEmpDeptList.size(); i++) {
				mapOrgEmpDept = orgEmpDeptList.get(i);
				EmpDept empDept = new EmpDept();
				BeanCopyUtil.mapToModel(empDept, mapOrgEmpDept,dictionaryService);
				//BeanCopyUtil.beanCopy(empDept, orgEmpDept);
				voArray[i] = empDept;
			}
			builder.withData(voArray);
			results = builder.build();
	        results.setTotal(orgEmpDeptList.size());
		}else{
			builder.withData(new EmpDept[0]);
			results = builder.build();
		}
		return results;
	}


}
