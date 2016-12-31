package pkuhit.iih.iemr.sys;

import java.util.Map;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pkuhit.iih.en.EncounterModel;
import pkuhit.iih.mr.wr.Amr;
import pkuhit.org.Organization;
import pkuhit.xap.ac.MenuTreeData;
import pkuhit.xap.ac.User;
import pkuhit.xap.po.Portal;
import xap.sv.model.ArrayResult;
import xap.sv.model.SingleResult;
import xap.sv.model.TreeResult;
import xap.sv.servlet.mvc.annotation.ModelAttribute;
import xap.sv.servlet.mvc.annotation.RequestParam;

/**
 * 
 * @author meng.xinhua
 *
 */
public interface PortalService
{
    /**
     * 获取登录用户
     * @return UserId
     * @throws Throwable
     */
    @RequestMapping(value = "/searchLoginUser", method = RequestMethod.GET)
    String selectLoginUser();

    /**
     * 获取院区列表
     * @param userId(用户id)
     * @param orgTpCd(组织结构类型)
     * @return Organization[]
     * @throws Throwable
     */
    @RequestMapping(value = "/searchHospitalArea", method = RequestMethod.GET)
    Organization[] selectHospitalArea(@RequestParam Map<String, String> params);
    
    /**
     * 获取可登录部门列表
     * @param userId(用户id)
     * @param orgTpCd(组织结构类型)
     * @param parOrgCd(院区编码)
     * @param portalCd(门户编码)
     * @return Organization[]
     * @throws Throwable
     */
    @RequestMapping(value = "/searchDepartment", method = RequestMethod.GET)
    ArrayResult<Organization> selectDepartment(@RequestParam Map<String, String> params);
    
    /**
     * 获取可登录门户列表
     * @param userId(用户id)
     * @param orgCd(部门编码)
     * @return Portal
     * @throws Throwable
     */
    @RequestMapping(value = "/searchPortal", method = RequestMethod.GET)
    Portal[] selectPortal(@RequestParam Map<String, String> params);

    /**
     * 获取可访问菜单列表
     * @param userId(用户id)
     * @param orgCd(部门编码)
     * @param portalCd(门户编码)
     * @return TreeResult
     * @throws Throwable
     */
    @RequestMapping(value = "/searchPortalMenus", method = RequestMethod.GET)
    TreeResult<MenuTreeData> selectPortalMenus(
            @RequestParam Map<String, String> params);
    
    /**
     * 获取可访问菜单列表
     * @param userId(用户id)
     * @param orgCd(部门编码)
     * @param portalCd(门户编码)
     * @return TreeResult
     * @throws Throwable
     */
    @RequestMapping(value = "/poral/menus", method = RequestMethod.GET)
    TreeResult<MenuTreeData> searchPortalMenus(
            @RequestParam Map<String, String> params);

    /**
     * 保存登录院区、科室到会话
     * @param deptId(科室编码)
     * @param orgCd(院区编码)
     * @throws Throwable
     */
    @RequestMapping(value = "/saveDepartment", method = RequestMethod.GET)
    void saveDepartment(@RequestParam Map<String, String> params);
    
    /**
     * 获取患者列表
     * @param userId(用户id)
     * @param orgCd(科室编码)
     * @param enTpCd(就诊类型)
     * @param search(自定义检索条件)
     * @param group(分组条件)
     * @return EncounterModel[]
     * @throws Throwable
     */
//    @RequestMapping(value = "/searchPatient", method = RequestMethod.GET)
//    EncounterModel[] selectPatients(@RequestParam Map<String, String> params);
    
    /**
     * 获取患者历次就诊列表
     * @param enPk(就诊主键)
     * @return EncounterModel[]
     * @throws Throwable
     */
//    @RequestMapping(value = "/searchEncounter", method = RequestMethod.GET)
//    EncounterModel[] selectEncounters(@RequestParam Map<String, String> params);
    
    @RequestMapping(value = "/portal/test", method = RequestMethod.GET)
    void test();
    
    /**
     *【病案】更新服务（单记录）
     * @param id
     * @param io
     * @return
     * @throws Throwable
     */
    @RequestMapping(value = "/setDoctor/{id}", method = RequestMethod.PUT)
    SingleResult<Amr> setDoctor(@PathVariable("id") String id, @ModelAttribute Amr value)
        throws Throwable;
    
    /**
     * 验证用户权限
     * @param userId
     * @param orgCd
     * @return result
     * @throws Throwable
     */
    @RequestMapping(value = "/validateUser", method = RequestMethod.GET)
    SingleResult<Map> validateUser(@RequestParam Map<String, String> condition);
    
    /**
     * 验证CA证书
     * @param strDataTex原文
     * @param strSignTex签名
     * @return result
     * @throws Throwable
     */
    @RequestMapping(value = "/ca/getCACertUser", method = RequestMethod.GET)
    SingleResult<User> getCACertUser(@RequestParam Map<String, String> condition);
    
    /**
     * BJCA数字签名
     * @return result
     * @throws Throwable
     */
    @RequestMapping(value = "/ca/getBJCASigndata", method = RequestMethod.GET)
    Map<String,String> getBJCASigndata() throws Throwable;
    
    /**
     * BJCA获取证书信息
     * @return result
     * @throws Throwable
     */
    @RequestMapping(value = "/ca/getBJCACertInfo", method = RequestMethod.GET)
    Map<String,String> getBJCACertInfo(@RequestParam Map<String, String> param) throws Throwable;
    
    int searchMrCountByPatient(String enc_id);
}
