/**
 * 
 */
package pkuhit.org;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import oracle.net.aso.e;

import org.springframework.beans.factory.annotation.Autowired;

import pkuhit.org.dao.auto.OrgEmpDao;
import pkuhit.org.dao.auto.entity.OrgEmp;
import pkuhit.org.dao.custom.CusOrgEmpDao;
import pkuhit.org.OrgEmpService;
import xap.sv.model.ArrayResult;
import xap.sv.model.ArrayResultBuilder;
import xap.sv.model.SingleResult;
import xap.sv.model.SingleResultBuilder;

/**
 *  员工服务类
 */
public class OrgEmpServiceImpl implements OrgEmpService {

	@Autowired
	OrgEmpDao orgEmpDao;
	
	@Autowired
	CusOrgEmpDao cusOrgEmpDao;
	/* (non-Javadoc)
	 * @see pkuhit.org.OrgEmpService#selectByCode(java.lang.String)
	 */
	@Override
	public SingleResult<String> selectByCode(String empId) {
		SingleResultBuilder<String>  builder = SingleResultBuilder.newSingleResult(String.class) ;
		OrgEmp orgEmp = orgEmpDao.selectById(empId);
		if(null != orgEmp){
			builder.withData(orgEmp.getNm());
		}
		SingleResult<String> rs = builder.build();
		return rs; 
	}
	@Override
	public ArrayResult<EmployeeForCombx> selectByDeptCode(
			Map<String, String> params) {
		String deptCode = null ;
		ArrayResultBuilder<EmployeeForCombx> builder = ArrayResultBuilder.newArrayResult(EmployeeForCombx.class);
		if(params.containsKey("deptCode")){
			deptCode = (String)params.get("deptCode");
		}
		List<Map<String, Object>> empByDept = cusOrgEmpDao.getEmpByDept(deptCode);
		if(empByDept!= null && empByDept.size() > 0){
			System.out.println(empByDept.size());
			EmployeeForCombx[] voList = new EmployeeForCombx[empByDept.size() ];
			for(int i = 0 ; i < empByDept.size() ; i ++ ){
				Map<String, Object> map = empByDept.get(i);
				EmployeeForCombx vo = new EmployeeForCombx();
				vo.setCode((String)map.get("CODE"));
				vo.setName(((String)map.get("NAME")));
				//vo.setLongName((String)map.get("CODE")+"_"+(String)map.get("NAME"));
				voList[i] = vo ;
			}
			builder.withData(voList);
		}
		ArrayResult<EmployeeForCombx> rs = builder.build();
		return rs ;
	}

}
