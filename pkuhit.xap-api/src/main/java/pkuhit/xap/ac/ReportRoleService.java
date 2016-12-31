package pkuhit.xap.ac;

import java.util.Map;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pkuhit.iih.qa.IemrReportModel;

import xap.sv.annotation.Service;
import xap.sv.servlet.mvc.annotation.ModelAttribute;
import xap.sv.servlet.mvc.annotation.RequestParam;
import xap.sv.model.ArrayResult;
import xap.sv.model.SingleResult;

/**
 * 报表角色资源相关的服务接口
 * @author cheng_feng
 *
 */
@Service
public interface ReportRoleService
{
    /**
     * 查询报表列表
     * @return
     */
	@RequestMapping(value = "/role/reports", method = RequestMethod.GET)
	public ArrayResult<IemrReportModel> search(@RequestParam Map<String, String> params);
	
	/**
     * 根据角色查询该角色下的报表
     * @param roleCode String [角色ID]查询条件
     * @return
     */
	@RequestMapping(value = "/role/choosereports", method = RequestMethod.GET)
	public ArrayResult<IemrReportModel> searchReportsByRoleCode(@RequestParam Map<String, String> params);
	
	/**
     * 保存该角色下的报表
     * @param roleCode String [角色ID]
     * @param roleReportList String [报表列表]
     * @return
     */
	@RequestMapping(value = "/role/savereport/{id}", method = RequestMethod.PUT)
	public SingleResult<ReportRole> saveReportsByRoleCode(@PathVariable("id") String roleCode, @ModelAttribute ReportRole reportRole);
}
