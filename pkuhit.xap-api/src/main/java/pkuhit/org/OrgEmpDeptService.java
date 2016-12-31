package pkuhit.org;

import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import xap.sv.model.ArrayResult;
import xap.sv.model.SingleResult;
import xap.sv.servlet.mvc.annotation.ModelAttribute;
import xap.sv.servlet.mvc.annotation.RequestParam;

/**
 * @author wangyanli
 * 员工出诊科室服务类
 */
public interface OrgEmpDeptService {
	   /**
     * 
     * @description 更新机构
     * @author wang_yanli
     * @date 2016年09月22日 下午1:51:04
     * @param empDeptList
     * @return
     */
    @RequestMapping(value = "/orgEmpDept/update", method = RequestMethod.PUT)
    SingleResult<EmpDept> updateOrgEmpDept(@ModelAttribute EmpDeptList empDeptList);
    
    @RequestMapping(value = "/orgEmpDept", method = RequestMethod.GET)
    public ArrayResult<EmpDept> selectOrgEmpDept(@RequestParam Map<String, String> params);
}
