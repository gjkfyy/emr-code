/**
 * 
 */
package pkuhit.org;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import pkuhit.md.dao.auto.MdBizRoleDao;
import pkuhit.md.dao.auto.entity.MdBizRole;
import pkuhit.org.dao.auto.OrgEmpDao;
import pkuhit.org.dao.auto.entity.OrgWgEmp;
import pkuhit.org.dao.custom.CustomOrgWgEmpDao;
import pkuhit.xap.dao.auto.XapUserDao;
import pkuhit.xap.dao.auto.entity.XapUser;
import pkuhit.xap.util.BeanCopyUtil;
import xap.sv.model.ArrayResult;
import xap.sv.model.ArrayResultBuilder;

/**
 * @author wu.junhui
 *
 */
public class WorkGroupEmpServiceImpl implements WorkGroupEmpService {
 
	@Autowired
	CustomOrgWgEmpDao customOrgWgEmpDao;

	@Autowired
	OrgEmpDao orgEmpDao;
	
	@Autowired
	XapUserDao xapUserDao;
	
	@Autowired
	MdBizRoleDao mdBizRoleDao;
	
	/* (non-Javadoc)
	 * @see pkuhit.org.WorkGroupEmpService#search(java.util.Map)
	 */
	@Override
	public ArrayResult<WorkGroupEmp> search(Map<String, String> params) {
		//■ 查询数据列表
		//String orgCode = params.get("");
		String wgCd = params.get("wgcd");
		String userId = params.get("userId");
		String empId = params.get("empId");
		
		if (StringUtils.isBlank(empId) && !StringUtils.isBlank(userId)) {
			XapUser xapUser = xapUserDao.selectById(userId);
			if (xapUser != null) {
				empId = xapUser.getEmpId();
			}
		}
		
		List<OrgWgEmp> orgWgEmpList = this.customOrgWgEmpDao.selectOrgWgEmpList(wgCd, empId);
		
		//■ 返回结果
		ArrayResultBuilder<WorkGroupEmp> builder = ArrayResultBuilder.newArrayResult(WorkGroupEmp.class);
		int size = orgWgEmpList.size();
		if (size > 0) {
			WorkGroupEmp[] workGroupEmps = new WorkGroupEmp[size];
			for (int i = 0; i < size; i++) {
				OrgWgEmp orgWgEmp = orgWgEmpList.get(i);
				workGroupEmps[i] = this.wrapWorkGroupEmp(orgWgEmp);
			}
			builder.withData(workGroupEmps);
		}
		ArrayResult<WorkGroupEmp> rs = builder.build();
		rs.setTotal(size);
		return rs;
	}
	
	
	private WorkGroupEmp wrapWorkGroupEmp(OrgWgEmp orgWgEmp) {
		if (orgWgEmp == null) {
			return null;
		}
		
		WorkGroupEmp workGroupEmp = new WorkGroupEmp();
		BeanCopyUtil.entityToModel(workGroupEmp, orgWgEmp, null, null);
		
		//设置审签等级编码
		String bizRoleCd = orgWgEmp.getBizRoleCd();
		if (!StringUtils.isBlank(bizRoleCd)) {
			MdBizRole mdBizRole = this.mdBizRoleDao.selectById(bizRoleCd);
			
			if (mdBizRole != null) {
				workGroupEmp.setSignLvlCd(mdBizRole.getSignLvlCd());
			}
		}
		
		return workGroupEmp;
	}

}
