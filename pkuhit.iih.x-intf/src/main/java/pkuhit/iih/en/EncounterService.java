/**
 * 
 */
package pkuhit.iih.en;

import java.util.Map;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import xap.sv.model.ArrayResult;
import xap.sv.model.SingleResult;
import xap.sv.servlet.mvc.annotation.RequestParam;

/**
 * @author guo_zhongbao
 * 就诊服务
 */
public interface EncounterService {
	   /**
     * 根据登陆科室和登陆人员查询患者就诊列表
     * @param curGrpCd 当前诊疗组
     * @param  curDeptCd 登录人员所在科室
     * @param   curMngDctId  登录人员code
     * @param enTpCd 就诊类型（住院/门诊）
     * @param 患者姓名paNm、床位号curBedCd、患者序号paId 
     * 就诊状态编码enStaCd 入院入科时间开始时间inpTimeStart 入院入科时间结束时间inpTimeStop 主诊断编码curMainDiCd    病情状态编码illStaCd
     * suF 手术标志    
     * 当前页数	currentPageIndex		  每页记录数pageSize	
     * @return 患者就诊列表
     * 测试地址：http://localhost:8081/encounterList?curDeptCd=0300&curMngDctId=003022&enTpCd=onp&paId=0000181054&enStaCd=compltd&xmode=debug
     */
    @RequestMapping(value = "/encounters", method = RequestMethod.GET)
    public ArrayResult<EncounterModel> getEncounterListByCondition(@RequestParam Map map );//@RequestParam("deptCd") String deptCd,@RequestParam("managerDoctorCd")String managerDoctorCd,@RequestParam("encounterTypeCd") String encounterTypeCd);
    
	/**
	 * 根据就诊序号，就诊详情
	 * @param enSn 就诊序号
	 * @return 就诊对象详情
	 * http://localhost:8081/encounterDetail/838535?xmode=debug
	 * */
	//@RequestMapping("/enDetail/{enSn}")
	@RequestMapping(value = "/encounter/{enPk}", method = RequestMethod.GET)
	public SingleResult<EncounterModel> getEncounterDetail(@PathVariable("enPk") String enPk);
	
	/**
	 * 根据就诊序号，获取前一个有效就诊
	 * @param enPk 当前的就诊序号
	 * @return 前一个就诊对象详情
	 * */
	@RequestMapping(value = "/encounter/getLastEffectiveEncounter", method = RequestMethod.GET)
	public EncounterModel getLastEffectiveEncounterByEncounterSn(@RequestParam("enPk") String enPk);
    /**
     * @author guo_zhongbao
     *  执行存储过程，将历史就诊copy到7日就诊表中。
     * @param patientId 患者id
     * */
	@RequestMapping(value = "/encounter/copyEnFromHisTo7day", method = RequestMethod.GET)
    Boolean getHistoryEncounterByExcuteProcedure(String patientId);
}
