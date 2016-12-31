package pkuhit.iih.mr.wr;

import java.math.BigDecimal;
import java.util.Map;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import xap.sv.model.ArrayResult;
import xap.sv.model.SingleResult;
import xap.sv.servlet.mvc.annotation.RequestParam;
/**
 * 
 * @author cheng_feng
 *
 */
public interface QaAmrService {

	/**
	 *【病案】查询服务（多记录） 
	 * @return ArrayResult<Amr>
	 * @throws Throwable
	 */
	@RequestMapping(value = "/mr/amrs/getAmrByStatusInProcess", method = RequestMethod.GET)
	ArrayResult<Amr> getAmrByStatusInProcess(@RequestParam("statusStr") String statusStr) throws Throwable;
	
	/**
	 *【病案】完成评分
	 * @return SingleResult<Amr>
	 * @throws Throwable
	 */
	@RequestMapping(value = "/mr/amrs/qaCompleted/{id}", method = RequestMethod.POST)
	SingleResult<Amr> qaCompleted(@PathVariable("id") String enPk, @RequestParam("score") BigDecimal score, @RequestParam("rank") String rank) throws Throwable;
	
	/**
	 *【病案】撤销完成评分
	 * @return SingleResult<Amr>
	 * @throws Throwable
	 */
	@RequestMapping(value = "/mr/amrs/revokeQaCompleted/{id}", method = RequestMethod.POST)
	SingleResult<Amr> revokeQaCompleted(@PathVariable("id") String enPk) throws Throwable;
	
	/**
	 *【病案】查询服务（多记录） 
	 *	@param amrStatus, 
	 *					curDeptNm, 
	 *					curMainDiNm, 
	 *					staIll, 
	 *					rcvTime, 
	 *					enStaCd, 
	 *					suF, 
	 *					qaFlag, 
	 *					excuteUserId, 
	 *					executeDeptCode
	 * @return ArrayResult<Amr>
	 * @throws Throwable
	 */
	@RequestMapping(value = "/mr/amrs/getAmrByStatusInQa", method = RequestMethod.GET)
	ArrayResult<Amr> getAmrByStatusInQa(@RequestParam Map map) throws Throwable;
	
	/**
	 * 查询病案列表
	 * @return 病案列表
	 */
	@RequestMapping(value = "/mr/amrs", method = RequestMethod.GET)
	ArrayResult<Amr> search(@RequestParam Map<String, String> condition)  throws Throwable;

	/**
	 * 查询病案列表
	 * @param enPk 就诊编码
	 * @param qaStatusCode 要修改的病历文书状态
	 * @return 病案列表
	 */
	@RequestMapping(value = "/mr/setQaStatusCode", method = RequestMethod.PUT)
	ArrayResult<MedicalRecord> setQaStatusCode(@RequestParam("enPk") String enPk, @RequestParam("qaStatusCode") String qaStatusCode) throws Throwable;

	/**
	 * 查询患者列表
	 * @param keword 搜索关键字（根据病案患者姓名、床位号)
	 * @param deptCd 当前科室编码  (匹配病案患者当前就诊科室)
	 * @param userId 主管医生、主治医生、主任医生
	 * @param enTpCd 就诊类型
	 * @param patientId 当前患者ID
	 * @param pageNum 第几页，默认1
	 * @param pageSize 每页显示条数，默认100
	 * @param workScreen 工作场景  1-患者导航，2-智能助手（历次就诊）
	 * @param groupType 分组标记   1-我的患者、2-科室患者、3-转科患者
	 * @param patientName 患者姓名
	 * @param amrNo 住院号
	 * @param startDate 起始时间
	 * @param endDate 截止时间
	 * @return ArrayResult<Amr> 病案列表
	 */
	@RequestMapping(value = "/mr/ens", method = RequestMethod.GET)
	ArrayResult<Amr> searchEncounterList(@RequestParam Map<String, String> condition)  throws Throwable;
	
	/**
     * 查询患者（单记录） 
     * @param id
     * @return
     * @throws Throwable
     */
    @RequestMapping(value = "/mr/ens/{id}", method = RequestMethod.GET)
    SingleResult<Amr> getEncounterById(@PathVariable("id")  String id) throws Throwable;
    
    /**
     * 查询患者（单记录） 
     * @param id
     * @return
     * @throws Throwable
     */
    @RequestMapping(value = "/mr/patient/{id}", method = RequestMethod.GET)
    SingleResult<Amr> getEncounterByPatientId(@PathVariable("id")  String id) throws Throwable;

}
