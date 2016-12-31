package pkuhit.org;

import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import xap.sv.model.ArrayResult;
import xap.sv.servlet.mvc.annotation.RequestParam;

public interface WorkGroupEmpService {

    /**
     * 查询工作组成员列表
     * @param params.orgCode  医院组织结构编码
     * @param params.wgCd 工作组编码
     * @param params.userId 用户ID
     * @param params.empId 人员ID
     * @return 工作组成员列表
     */
    @RequestMapping(value = "/workGroupEmps", method = RequestMethod.GET)
    ArrayResult<WorkGroupEmp> search(@RequestParam Map<String, String> params);
}
