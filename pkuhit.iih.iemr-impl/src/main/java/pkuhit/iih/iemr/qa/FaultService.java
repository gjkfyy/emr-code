package pkuhit.iih.iemr.qa;

import java.util.Map;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pkuhit.iih.mr.wr.Amr;
import pkuhit.iih.qa.old.QaFault;
import pkuhit.iih.qa.old.QaRecord;
import xap.sv.model.ArrayResult;
import xap.sv.model.SingleResult;
import xap.sv.servlet.mvc.annotation.ModelAttribute;
import xap.sv.servlet.mvc.annotation.RequestParam;
/**
 * 
 * @author cheng_feng
 *
 */
public interface FaultService {

	/**
	 * 创建【质控缺陷】（多记录）
	 * @param enPk 就诊编码
	 * @param qaTypeCode 质控类型编码
	 * @param List<QaFault> listValue 质控缺陷记录对象列表
	 * @return ArrayResult<QaFault>
	 * @throws Throwable
	 */
	@RequestMapping(value = "/qa/fault", method = RequestMethod.POST)
	ArrayResult<QaFault> create(@ModelAttribute CusCreateQaFault map) throws Throwable;
	
	/**
	 * 查询【完成本次质控统计信息】
	 * @param String encounterPk 就诊号
	 * @param String qaTypeCode 质控类型
	 * @return SingleResult<QaRecord>
	 * @throws Throwable
	 */
	@RequestMapping(value = "/qa/fault/statics", method = RequestMethod.GET)
	SingleResult<QaRecord> searchStatics(@RequestParam("encounterPk") String encounterPk, 
			@RequestParam("qaTypeCode") String qaTypeCode) throws Throwable;
	
	/**
	 * 提出【质控缺陷】服务
	 * @param List<String> id
	 * @return SingleResult<QaFault>
	 * @throws Throwable
	 */
//	@RequestMapping(value = "/qa/submitted/faults", method = RequestMethod.POST)
	SingleResult<QaFault> submit(@ModelAttribute SubmitQaFault fault) throws Throwable;
	
	/**
	 * 查询环节质控患者列表
	 * @param map 
		 	curDeptNm	就诊科室
			curMainDiNm	主诊断
			dangerIll	病危标志
					1：病危
			seriouslyIll	病重标志
					1：病重
			rcvTime	入院时间
					1.入院24小时内
					2.入院7日内
					3.全部在院
			leaveHospitalF	已出院（病案未完成）全部在院时不可用
			suF	手术标志
					1：手术
			amrStatus	病案状态
			qaFlag	质控标记
					0：未质控
					1：质控
			isDept	是否勾选科室质控中
					1：个人
					2：科室
	 * @return
	 * @throws Throwable
	 */
	@RequestMapping(value = "/mr/process/amrs", method = RequestMethod.GET)
	ArrayResult<Amr> searchProcessList(@RequestParam Map map) throws Throwable;
	
	/**
	 * 查询终末质控患者列表
	 * @param map 
		 	curDeptNm	就诊科室
			curMainDiNm	入院诊断（主诊断）
			dangerIll	病危标志
					1：病危
			seriouslyIll	病重标志
					1：病重
			rcvTime	入院时间（入科时间）标志   
					1：入院24小时内出院
					2：入院7日内出院
					3：全部
			suF	手术标志  
					1：手术
			scoredFlag 评分标记
					1：已评分
			qaFlag	质控标记
					0：未质控
					1：质控
			isDept	是否勾选科室质控中
					1：个人
					2：科室
	 * @return
	 * @throws Throwable
	 */
	@RequestMapping(value = "/mr/terminal/amrs", method = RequestMethod.GET)
	ArrayResult<Amr> serachTerminalList(@RequestParam Map map) throws Throwable;
	
	/**
	 * 病案开始质控服务（单记录）
	 * @param enPk 就诊主键
	 * @return SingleResult<Amr>
	 * @throws Throwable
	 */
	@RequestMapping(value = "/mr/qaStarted/amr/{id}", method = RequestMethod.POST)
	SingleResult<Amr> start(@PathVariable("id") String enPk) throws Throwable;
	
	/**
	 * 病案完成质控服务（单记录）
	 * @param enPk 就诊主键
	 * @return SingleResult<Amr>
	 * @throws Throwable
	 */
	@RequestMapping(value = "/mr/qaCompleted/amr/{id}", method = RequestMethod.POST)
	SingleResult<Amr> stop(@PathVariable("id") String enPk) throws Throwable;
	
	/**
	 * 病案撤销完成质控服务（单记录）
	 * @param enPk 就诊主键
	 * @return SingleResult<Amr>
	 * @throws Throwable
	 */
	@RequestMapping(value = "/mr/qaCompleted/amr/revoke/{id}", method = RequestMethod.POST)
	SingleResult<Amr> revoke(@PathVariable("id") String enPk) throws Throwable;
	
}
