package pkuhit.iih.qa.qacustom;

import java.util.Map;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pkuhit.iih.mr.wr.Amr;
import pkuhit.iih.qa.CusQaAutoFltModel;
import xap.sv.model.ArrayResult;
import xap.sv.model.SingleResult;
import xap.sv.servlet.mvc.annotation.ModelAttribute;
import xap.sv.servlet.mvc.annotation.RequestParam;
/**
 * 
 * @author yao_lijie
 *
 */
public interface QaMrAmrService {
	
	/**
	 * 查询环节质控患者列表
	 * @param map 
		 	curDeptNm	就诊科室
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
	 * @return
	 * @throws Throwable
	 */
	@RequestMapping(value = "/inprocess/amrs", method = RequestMethod.GET)
	ArrayResult<Amr> search(@RequestParam Map<String, String> condition)  throws Throwable;
	
	/**
	 * 终末质控查询病案列表
	 * @return 病案列表
	 */
	@RequestMapping(value = "/qa/terminal/amrs", method = RequestMethod.GET)
	ArrayResult<Amr> searchTerminalList(@RequestParam Map map) throws Throwable;
	
	
	/**
	 * 判断终末【完成】按钮的状态（将按钮放到表格中，在初始化列表中返回结果）
	 * @param pk 就诊外键
	 * @return String
	 * @throws Throwable
	 *//*
	@RequestMapping(value = "/qa/judgeState/amr", method = RequestMethod.GET)
	String judgeTerminalAmrState(@RequestParam Map map) throws Throwable;*/
	
	/**
	 * 签收
	 * @return 病案列表
	 */
	@RequestMapping(value = "/qa/qaStarted/amr", method = RequestMethod.PUT)
	SingleResult<Amr> signTerminalAmr(@ModelAttribute Map map) throws Throwable;
	
	/**
	 * 打回
	 * @return 病案列表
	 */
	@RequestMapping(value = "/qa/back/amr/{id}", method = RequestMethod.PUT)
	SingleResult<Amr> backTerminalAmr(@PathVariable("id") String pk) throws Throwable;
	
	/**
	 * 完成终末质控并同步缺陷数据到评分
	 * @return 病案列表
	 */
	@RequestMapping(value = "/qa/qaCompleted/amr/{id}", method = RequestMethod.PUT)
	SingleResult<Amr> finishTerminalAmr(@PathVariable("id") String pk, @RequestParam Map map) throws Throwable;
	
	
	/**
	 * 完成科室质控并同步缺陷数据到评分
	 * @return 病案列表
	 */
	@RequestMapping(value = "/qa/qaCompletedDept/amr/{id}", method = RequestMethod.PUT)
	SingleResult<Amr> finishDeptAmr(@PathVariable("id") String pk, @RequestParam Map map) throws Throwable;
	
	
	/**
	 * 环节自动质控查询患者列表
	 * @return 患者列表
	 */
	@RequestMapping(value = "/qa/inprocess/autowork", method = RequestMethod.GET)
	ArrayResult<Amr> searchQaProcessAutoList(@RequestParam Map map) throws Throwable;
	
	/**
	 * 科室自动质控查询医生列表
	 * @return 医生列表
	 */
	@RequestMapping(value = "/qa/autowork", method = RequestMethod.GET)
	ArrayResult<CusQaAutoFltModel> searchQaAutoList(@RequestParam Map map) throws Throwable;
	
}
