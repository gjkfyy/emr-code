package pkuhit.org;

import java.util.Map;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import xap.sv.model.ArrayResult;
import xap.sv.model.SingleResult;
import xap.sv.servlet.mvc.annotation.RequestParam;

/**
 * @author yz
 * 员工服务类
 */
public interface OrgEmpService {
    /**
     * 
     * @description 根据员工IDempId查询员工姓名
     * @author jiao_xiantong
     * @date 2014年12月12日 下午1:51:04
     * @param organization
     * @return
     */
    @RequestMapping(value = "/org/employee/{empId}", method = RequestMethod.GET)
    SingleResult<String> selectByCode(
            @PathVariable("empId") String empId);
    
    /**
     * 根据出诊科室，获取出诊该科室的员工
     * @param deptCode 出诊科室
     * */
    @RequestMapping(value = "/org/dept/employee", method = RequestMethod.GET)
    ArrayResult<EmployeeForCombx> selectByDeptCode(@RequestParam Map<String, String> params);
}
