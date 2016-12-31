package pkuhit.iih.iemr.qa;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import pkuhit.iih.en.EncounterModel;
import pkuhit.iih.en.md.EncounterStatus;
import pkuhit.iih.en.md.IllStatus;
import pkuhit.iih.iemr.pub.IihUtils;
import pkuhit.iih.mr.md.AmrStatus;
import pkuhit.iih.mr.pub.MessageCode;
import pkuhit.iih.mr.wr.Amr;
import pkuhit.iih.mr.wr.MedicalRecord;
import pkuhit.iih.mr.wr.MedicalRecordService;
import pkuhit.iih.mr.wr.QaAmrService;
import pkuhit.iih.pub.MrConfigCode;
import pkuhit.iih.qa.md.QaFaultConfirmResultStatus;
import pkuhit.iih.qa.md.QaFaultStatus;
import pkuhit.iih.qa.md.QaStaus;
import pkuhit.iih.qa.md.QaType;
import pkuhit.iih.qa.old.QaFault;
import pkuhit.iih.qa.old.QaFaultItem;
import pkuhit.iih.qa.old.QaRecord;
import pkuhit.xap.ac.Session;
import pkuhit.xap.cfg.ConfigItemData;
import pkuhit.xap.cfg.ConfigItemDataService;
import pkuhit.xap.md.TaskStatus;
import pkuhit.xap.md.TaskType;
import pkuhit.xap.task.Task;
import pkuhit.xap.task.TaskActionService;
import xap.sv.annotation.Reference;
import xap.sv.model.ArrayResult;
import xap.sv.model.ArrayResultBuilder;
import xap.sv.model.SingleResult;
import xap.sv.model.SingleResultBuilder;
import xap.sv.notification.Notification;
import xap.sv.notification.exception.NotificationException;
import xap.sv.util.UUIDGenerator;

/**
 * 
 * @author cheng_feng
 *
 */
public class FaultServiceImpl implements FaultService {

	@Reference
	pkuhit.iih.qa.QaRecordService qaRecordServiceMr;

	@Reference
	pkuhit.iih.qa.FaultRecordService faultRecordServiceMr;


	@Reference
	QaService qaService;

	@Reference
	pkuhit.iih.mr.wr.AmrService amrServiceMr;

//	@Reference
//	pkuhit.iih.en.EncounterService encounterServiceEn;

	@Reference
	QaAmrService qaAmrServiceMr;

	// --
	@Reference
	MedicalRecordService mRServiceMr;
	
	@Reference
	TaskActionService taServiceXap;
	
	@Reference
	ConfigItemDataService configItemDataService;
	
	@Reference
	IemrQaScoreCaculateService qaScoreCaculateService;
	
	public FaultServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	@Transactional(rollbackFor = { RuntimeException.class })
	public ArrayResult<QaFault> create(CusCreateQaFault cqf) throws Throwable {
		Session session = Session.get();
		String userId = session.getUserId();
		String deptId = session.getDeptId();
		String enPk = cqf.getEnPk();
		String qaTypeCode = cqf.getQaTypeCode();
		QaFault[] qaFaultArray = cqf.getQaFaultArray();
		String qaPk = "";// 质控工作记录主键
		short haveFaultFlag = 0;// 有缺陷标志，0：无缺陷，1：有缺陷
		int needReformFaultFlag = 0;// 有需要整改缺陷标志，0：需整改，1：不整改
		int qaCreateFlag = 0;// 标识质控工作记录是新建还是修改：0 修改，1 新建
		try{
			/* 判断是否存在质控工作记录 */
			qaPk = qaRecordServiceMr.checkExistUncompleted(enPk);
			if (StringUtils.isEmpty(qaPk)) {
				qaPk = UUIDGenerator.getUUID();
				qaCreateFlag = 1;
			}
			/* 补全质控缺陷数据 */
			Timestamp tm = new Timestamp(System.currentTimeMillis());
			if (qaFaultArray != null && qaFaultArray.length > 0) {
				haveFaultFlag = 1;
				String pkStr = "";
				String qaFaultPk = "";
				for (int i = 0; i < qaFaultArray.length; i++) {
					QaFault qaFault = qaFaultArray[i];
					qaFaultPk = UUIDGenerator.getUUID();
					qaFault.setPk(qaFaultPk);
					qaFault.setEnPk(enPk);
					qaFault.setFaultConfirmResult(QaFaultConfirmResultStatus.UNCONFIRMED);
					qaFault.setSubmittedTime(tm);
					qaFault.setSubmittedUserId(userId);
					qaFault.setSubmittedDeptCode(deptId);
					faultRecordServiceMr.create(qaFault);
					/* 补全工作记录质控缺陷 关联关系表 数据 */
					QaFaultItem qaFaultItem = new QaFaultItem();
					qaFaultItem.setPk(UUIDGenerator.getUUID());
					qaFaultItem.setQaPk(qaPk);
					qaFaultItem.setQaFaultPk(qaFaultPk);
					qaFaultItem.setActiveF((short)1);
	 				//qaFaultItemServiceMr.create(qaFaultItem);
					pkStr +=  qaFault.getQaSystemItemCode() + ",";
				}
				pkStr = pkStr.substring(0, pkStr.length() - 1);
				needReformFaultFlag = faultRecordServiceMr.checkIsNeedReform(pkStr);
			}
			if (qaCreateFlag == 1) {
				QaRecord qaRecord = new QaRecord();
				qaRecord.setPk(qaPk);
				qaRecord.setEncounterPk(enPk);
				qaRecord.setQaSystemCode(getQaSystemCode());
				qaRecord.setQaTypeCode(qaTypeCode);
				qaRecord.setAutoFlag((short) 0);
				qaRecord.setExecuteBeginTime(tm);
				qaRecord.setCompletedFlag((short) 0);
				qaRecord.setHaveFaultFlag((short) haveFaultFlag);
				qaRecord.setNeedReformFaultFlag((short) needReformFaultFlag);
				qaRecordServiceMr.create(qaRecord);
			}
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		//~~~~~~~~~返回需要修改~~~~~~~~~
		Map param = new HashMap();
		param.put("encounterPk", enPk);
		param.put("qaTypeCode", qaTypeCode);
		param.put("submittedUserId", userId);
		ArrayResult<QaFault> qaFaultArrayResult = faultRecordServiceMr.searchByCondition(param);
		return qaFaultArrayResult;
	}

	@Override
	@Transactional(rollbackFor = { RuntimeException.class })
	public SingleResult<QaRecord> searchStatics(String encounterPk,
			String qaTypeCode) throws Throwable {
		SingleResult<QaRecord> qaRecordResult = new SingleResult<QaRecord>();
		try{
			if(!StringUtils.isEmpty(encounterPk)&&!StringUtils.isEmpty(qaTypeCode)){
				Session session = Session.get();
				String userId = session.getUserId();
				String userName = session.getUserName();
				String deptId = session.getDeptId();
				String deptName = session.getDeptName();
				String currentQaPk = "";
				currentQaPk = qaRecordServiceMr.checkExistUncompleted(encounterPk);
				Timestamp tm = new Timestamp(System.currentTimeMillis());
				if (StringUtils.isEmpty(currentQaPk)) {// 若为空，则说明本次质控工作记录没有缺陷
					// 补全质控工作记录数据
					QaRecord qaRecord = new QaRecord();
					qaRecord.setEncounterPk(encounterPk);
					qaRecord.setQaTypeCode(qaTypeCode);
					qaRecord.setQaSystemCode(getQaSystemCode());//质控体系编码
					qaRecord.setExecuteBeginTime(tm);
					qaRecord.setExecuteEndTime(tm);
					qaRecord.setAutoFlag((short) 0);
					qaRecord.setCompletedFlag((short) 1);
					qaRecord.setHaveFaultFlag((short) 0);
					qaRecord.setNeedReformFaultFlag((short) 0);
					qaRecord.setExcuteUserId(userId);
					qaRecord.setExecuteDeptCode(deptId);
					qaRecord.setReformDeadline(BigInteger.valueOf(0));
					qaRecord.setDeadline(tm);
					qaRecordResult = qaRecordServiceMr.create(qaRecord);
				} else {
					qaRecordResult = qaRecordServiceMr.search(currentQaPk);
					SingleResult<Amr> amrResult = amrServiceMr.get(encounterPk);
					if(amrResult.getData()!=null){
						qaRecordResult.getData().setAmrNo(amrResult.getData().getAmrNo());// 病案号
						qaRecordResult.getData().setPatientName(amrResult.getData().getPatientName());// 患者姓名
						qaRecordResult.getData().setEncounterDept(amrResult.getData().getCurrentDeptName());// 就诊科室
						qaRecordResult.getData().setBedNo(amrResult.getData().getCurrentBedCode());// 床位号
						
					}
					/*SingleResult<EncounterModel> encounterResult = new SingleResult<EncounterModel>();
					encounterResult = encounterServiceEn.getEncounterDetail(encounterPk);
					if(encounterResult.getData()!=null){
						qaRecordResult.getData().setPatientName(encounterResult.getData().getPaNm());// 患者姓名
						qaRecordResult.getData().setEncounterDept(encounterResult.getData().getCurDeptNm());// 就诊科室
						qaRecordResult.getData().setBedNo(encounterResult.getData().getCurBedCd());// 床位号
					}*/
					qaRecordResult.getData().setExcuteUserName(userName);
					qaRecordResult.getData().setExecuteDeptName(deptName);
					qaRecordResult.getData().setExecuteEndTime(tm);// 质控时间
					// 判断质控类型，若为环节质控：统计当前登录人、若为终末质控：统计当前登陆科室
					if (QaRecord.QA_TYPE_CODE_INPROCESS.equals(qaTypeCode)) {
						deptId = "";
					} else if (QaRecord.QA_TYPE_CODE_TERMINAL.equals(qaTypeCode)) {
						userId = "";
					}
					SingleResult<QaRecord> qaRecordStatistical = new SingleResult<QaRecord>();
					qaRecordStatistical = qaRecordServiceMr.searchFaultStatistical(currentQaPk, userId, deptId);
					qaRecordResult.getData().setFaultTotal(qaRecordStatistical.getData().getFaultTotal());
					qaRecordResult.getData().setFaultTodoReform(qaRecordStatistical.getData().getFaultTodoReform());
					qaRecordResult.getData().setFaultReviewed(qaRecordStatistical.getData().getFaultReviewed());
					qaRecordResult.getData().setFaultTodoReview(qaRecordStatistical.getData().getFaultTodoReview());
					qaRecordResult.getData().setFaultReformed(qaRecordStatistical.getData().getFaultReformed());
					qaRecordResult.getData().setFaultSubmited(qaRecordStatistical.getData().getFaultSubmited());
				}
			} 
				/*else {
				//提示参数不能为空~~~~~~
				return null;
			}*/
		}catch(Exception e){
			throw new RuntimeException(e);
		}finally{
			return qaRecordResult;
		}
	}
	
	

	// 提出缺陷->质控完成时的操作
	@Override
	@Deprecated
	public SingleResult<QaFault> submit(SubmitQaFault param) throws Throwable {
		// TODO 事物控制
		// 调用【更改质控工作记录】服务，质控工作记录表更改完成标志=1，质控完成时间=当前服务器系统时间
		int reformDeadline = 1;
		String enPk = param.getEncounterPk();
		String qaPk = qaRecordServiceMr.checkExistUncompleted(enPk);
		//FIXME
		qaPk = "ff";
		SingleResult<QaRecord> search = qaRecordServiceMr.search(qaPk);
		QaRecord data = search.getData();
		data.setReformDeadline(BigInteger.valueOf((long) reformDeadline));
		Date deadLineDate = IihUtils.dateIncrease(reformDeadline);
		data.setDeadline(deadLineDate);
		data.setCompletedFlag((short) 1);
		data.setExecuteEndTime(new Date());
		//FIXME
		data.setPk("pk");
		qaRecordServiceMr.updateById(data.getPk(), data);

		// 修改“质控_缺陷”表缺陷状态
		String[] dataList = param.getDataList();
		// for modify
		// List<String> wait2ModifyMrCodes = new LinkedList<String>();
		Map<String, List<String>> mrs2faultsMap = new HashMap<String, List<String>>();
		for (String pk : dataList) {
			SingleResult<QaFault> sr = faultRecordServiceMr.searchById(pk);
			QaFault qaFault = sr.getData();
			qaFault.setStatusCode(QaFaultStatus.SUBMITTED);
			qaFault.setFaultConfirmResult(QaFault.FLT_CFM_RST_CD_UNCONFIRMED);
			faultRecordServiceMr.updateById(pk, qaFault);
			String mrPk = qaFault.getTargetObjectCode();

			if (mrs2faultsMap.get(mrPk) != null) {
				mrs2faultsMap.get(mrPk).add(pk);
			} else {
				List<String> faults = new ArrayList<String>();
				faults.add(pk);
				mrs2faultsMap.put(mrPk, faults);
			}
			// if (!wait2ModifyMrCodes.contains(qaFault.getTargetObjectCode()))
			// {
			// 病例文书
			// wait2ModifyMrCodes.add(qaFault.getTargetObjectCode());
			// }
		}

		// TODO 调用【查询医疗组】服务，给医疗组内的医生发送任务，调用【发送任务】服务（共通组提供服务）
		// 查询就诊所在医疗组下的所有医生 from gzb，修正：不需要给医生发送
		Session s = Session.get();
		String userId = s.getUserId();
		String deptCode = s.getDeptId();

		for (String pk : mrs2faultsMap.keySet()) {
			List<String> list = mrs2faultsMap.get(pk);
			// 生成父任务
			Task task = new Task();
			// XAPM04.01 病历整改任务
			task.setTypeCode(TaskType.MR_REFORM_TASK);
			task.setTypeName("病历整改任务");
			task.setPk(UUIDGenerator.getUUID());
			task.setSorceObjectCode(MedicalRecord.OBJ_CD);
			task.setSorceObjectPk(pk);
			task.setTargetObjectCode(MedicalRecord.OBJ_CD);
			task.setTargetObjectPk(pk);
			task.setGroupFlag(1);
			task.setStatusCode(TaskStatus.SENT);
			task.setPlanBeginTime(new Date());
			task.setPlanDuration(reformDeadline);
			task.setSentTime(new Date());
			task.setSentUserId(userId);
			task.setSentDeptCode(deptCode);
			// task.setName(name);
			// task.

			// 一些信息来自质控工作记录
			taServiceXap.sent(task);
			for (String faultPk : list) {
				// 生成子任务
				Task tc = new Task();
				tc.setTypeCode(TaskType.MR_REFORM_TASK);
				task.setTypeName("病历整改任务");
				tc.setPk(UUIDGenerator.getUUID());
				tc.setParentPk(task.getPk());
				tc.setSorceObjectCode(QaFault.OBJ_CD);
				tc.setSorceObjectCode(faultPk);
				tc.setTargetObjectCode(MedicalRecord.OBJ_CD);
				tc.setTargetObjectPk(pk);
				tc.setGroupFlag(1);
				tc.setStatusCode(TaskStatus.SENT);
				tc.setPlanBeginTime(new Date());
				tc.setPlanDuration(reformDeadline);
				tc.setSentTime(new Date());
				tc.setSentUserId(userId);
				tc.setSentDeptCode(deptCode);
				taServiceXap.sent(tc);
			}
		}
		
		// modify 终末质控时，调用【修改病历记录文书】服务，修改病历文书状态为“整改要求已发送”
		if (param.getQaTypeCode() != null
				&& param.getQaTypeCode().equals(QaType.TERMINAL_QA)) {
			for (String pk : mrs2faultsMap.keySet()) {
				SingleResult<MedicalRecord> sr = mRServiceMr.searchById(pk, false);//mRServiceMr.searchById(pk, userSignLevelCode);
				MedicalRecord mr = sr.getData();
				mr.setStatusCode(QaStaus.REFORM_FAULT_SUBMITTED);
				mRServiceMr.update(pk, mr);//Mr.update(mr.getPk(), mr, userSignLevelCode);
			}
		}
		
		SingleResultBuilder builder =SingleResultBuilder.newSingleResult(QaFault.class);
		builder.withData(null);
//		SingleResult<QaFault> singleResult = new SingleResult<QaFault>();
//		singleResult.setData(new QaFault());
//		singleResult.setData(null);
//		return singleResult;
		return builder.build();
	}

	@Override
	public ArrayResult<Amr> searchProcessList(Map map)
			throws Throwable {
		/*就诊对象查询条件*/
		String curDeptNm = getStringValueFromMap(map, "curDeptNm");//就诊科室
		String curMainDiNm = getStringValueFromMap(map, "curMainDiNm");//主诊断
		String staIll = "";
		String dangerIll = getStringValueFromMap(map, "dangerIll");//病危
		if(!StringUtils.isEmpty(dangerIll)){
			if("1".equals(dangerIll)){
				staIll = IllStatus.DANGER_ILL;
			}
		}
		String seriouslyIll  = getStringValueFromMap(map, "seriouslyIll");//病重
		if(!StringUtils.isEmpty(seriouslyIll)){
			if("1".equals(dangerIll)){
				staIll = IllStatus.SERIOUSLY_ILL;
			}
		}
		String enStaCd = getStringValueFromMap(map, "enStaCd");//全部在院：已入科、已出院  ~~~~没用~~~~
		String rcvTime = getStringValueFromMap(map, "rcvTime"); //入院时间  1.入院24小时内 2.入院7日内 3.全部在院(已入科、已出院)
		String suF = getStringValueFromMap(map, "suF"); //手术标志  1.手术
		String leaveHospitalFlag = getStringValueFromMap(map, "leaveHospitalF"); //已出院（病案未完成）全部在院时不可用   出院==诊毕  EncounterStatus
		/*病案对象查询条件*/
		String amrStatus = "";
		amrStatus += getStringValueFromMap(map, "amrStatus")+","; //病案状态
		if(",".equals(amrStatus)){
			amrStatus = "";
		}
		//---处理已出院---
		if(!StringUtils.isEmpty(leaveHospitalFlag)){
			if("1".equals(leaveHospitalFlag)){
				enStaCd = EncounterStatus.completed;
				amrStatus += AmrStatus.WRITE_STARTED+",";//书写已开始
			}
		}
		String qaFlag =  getStringValueFromMap(map, "qaFlag"); //质控标记
		String pageNum = null;
		String pageSize = null;
		if(map.containsKey("pageNum") && map.containsKey("pageSize")){
			pageNum = (String)map.get("pageNum");
			pageSize = (String)map.get("pageSize");
		}
		if(null == pageNum || !StringUtils.isNumeric(pageNum)   || null == pageSize || !StringUtils.isNumeric(pageSize)  )
		{
			pageNum= "1";
			pageSize = "25";
		}
		/*质控工作记录对象查询条件*/
		Session session = Session.get();
		String excuteUserId = ""; //实际执行人ID
		String executeDeptCode = "";//实际执行科室编码
		String workScreen =  getStringValueFromMap(map, "workScreen"); //工作场景
		String isDept =  getStringValueFromMap(map, "isDept"); //是否勾选科室质控中
		if(!StringUtils.isEmpty(isDept)){
			if("1".equals(isDept)){
				excuteUserId = session.getUserId();
			} else if("2".equals(isDept)){
				executeDeptCode = session.getDeptId();
			}
		}
		String statusStr = AmrStatus.WRITE_STARTED;//书写已开始（环节质控）
		amrStatus += statusStr+",";
		amrStatus = amrStatus.substring(0, amrStatus.length()-1);
		String qaTypeCode = QaRecord.QA_TYPE_CODE_INPROCESS;//环节质控
		Map mapCondition = new HashMap();
		mapCondition.put("statusStr", statusStr);
		mapCondition.put("qaTypeCode", qaTypeCode);
		mapCondition.put("amrStatus", amrStatus);
		mapCondition.put("curDeptNm", curDeptNm);
		mapCondition.put("curMainDiNm", curMainDiNm);
		mapCondition.put("staIll", staIll);
		mapCondition.put("rcvTime", rcvTime.toString());
		mapCondition.put("enStaCd", enStaCd);
		mapCondition.put("suF", suF.toString());
		mapCondition.put("qaFlag", qaFlag.toString());
		mapCondition.put("excuteUserId", excuteUserId);
		mapCondition.put("executeDeptCode", executeDeptCode);
		mapCondition.put("workScreen", workScreen);
		mapCondition.put("pageNum", pageNum);
		mapCondition.put("pageSize", pageSize);
		return this.getCusQaPatientResultByCondition(mapCondition);
	}
	
	@Override
	public ArrayResult<Amr> serachTerminalList(Map map)
			throws Throwable {
		/*就诊对象查询条件*/
		String curDeptNm = getStringValueFromMap(map, "curDeptNm");//就诊科室
		String curMainDiNm = getStringValueFromMap(map, "curMainDiNm");//主诊断
		String staIll = "";
		String enStaCd = "";
		String dangerIll = getStringValueFromMap(map, "dangerIll");//病危 
		if(!StringUtils.isEmpty(dangerIll)){
			if("1".equals(dangerIll)){
				staIll = IllStatus.DANGER_ILL;
			}
		}
		String seriouslyIll  = getStringValueFromMap(map, "seriouslyIll");//病重 
		if(!StringUtils.isEmpty(seriouslyIll)){
			if("1".equals(seriouslyIll)){
				staIll = IllStatus.SERIOUSLY_ILL;
			}
		}
		String rcvTime = getStringValueFromMap(map, "rcvTime"); //入院时间  1:入院24小时内、2:入院7日内、3:全部在院
		String allTerminals = getStringValueFromMap(map, "allTerminals");//全部 病案状态
		String suF = getStringValueFromMap(map, "suF"); //手术标志
		/*病案对象查询条件*/
		String amrStatus = "";
		amrStatus += getStringValueFromMap(map, "amrStatus")+","; //病案状态
		if(",".equals(amrStatus)){
			amrStatus = "";
		}
		if(!StringUtils.isEmpty(allTerminals)){
			if("1".equals(allTerminals)){
				amrStatus += AmrStatus.QA_COMPLETED+",";
			}
		}
		String amrQaStatusFlag =  getStringValueFromMap(map, "amrQaStatusFlag"); //评分标记
		if(!StringUtils.isEmpty(amrQaStatusFlag)){
			if("1".equals(amrQaStatusFlag)){
				amrStatus += AmrStatus.WRITE_COMPLETED+",";
			}else if("2".equals(amrQaStatusFlag)){
				amrStatus += AmrStatus.QA_STARTED+",";
			}else if("3".equals(amrQaStatusFlag)){
				amrStatus += AmrStatus.QA_COMPLETED+",";
			}
		}
		String qaFlag =  getStringValueFromMap(map, "qaFlag"); //质控标记
		if(!StringUtils.isEmpty(qaFlag)){
			if("0".equals(qaFlag)){
//				amrStatus += AmrStatus.WRITE_COMPLETED+",";
			}else if("1".equals(qaFlag)){
				amrStatus += AmrStatus.QA_STARTED+",";
			}
		}
		/*质控工作记录对象查询条件*/
		Session session = Session.get();
		String excuteUserId = "";//实际执行人ID
		String executeDeptCode = "";//实际执行科室编码
		String pageNum = null;
		String pageSize = null;
		if(map.containsKey("pageNum") && map.containsKey("pageSize")){
			pageNum = (String)map.get("pageNum");
			pageSize = (String)map.get("pageSize");
		}
		if(null == pageNum || !StringUtils.isNumeric(pageNum)   || null == pageSize || !StringUtils.isNumeric(pageSize)  )
		{
			pageNum= "1";
			pageSize = "25";
		}
		String isDept =  getStringValueFromMap(map, "isDept"); //是否勾选科室质控中
		if(!StringUtils.isEmpty(isDept)){
			if("1".equals(isDept)){
				excuteUserId = session.getUserId();
			}else if("2".equals(isDept)){
				executeDeptCode = session.getDeptId();
			}
		}
		String workScreen = getStringValueFromMap(map, "workScreen");//2：质控工作画面终末质控，3：质控评分画面
		if(!StringUtils.isEmpty(workScreen)){
			if(StringUtils.isEmpty(amrQaStatusFlag)){
				if("2".equals(workScreen)){
					amrStatus += AmrStatus.WRITE_COMPLETED+",";
					amrStatus += AmrStatus.QA_STARTED+",";
				}else if("3".equals(workScreen)){
					amrStatus += AmrStatus.QA_STARTED+",";
					amrStatus += AmrStatus.QA_COMPLETED+",";
				}
			}
		}
		//2015-01-06  cf 
		if(StringUtils.isEmpty(workScreen)){
			if(StringUtils.isEmpty(amrQaStatusFlag)){
				amrStatus += AmrStatus.WRITE_COMPLETED+",";
				amrStatus += AmrStatus.QA_STARTED+",";
				amrStatus += AmrStatus.QA_COMPLETED+",";
			}
		}
		String statusStr = "";
		if(StringUtils.isEmpty(amrQaStatusFlag)&&!"2".equals(workScreen)&&!"3".equals(workScreen)){
			statusStr = AmrStatus.WRITE_COMPLETED;//书写已完成（可以进入终末质控）
		}
		amrStatus += statusStr+",";
		amrStatus = amrStatus.substring(0, amrStatus.length()-1);
		String qaTypeCode = QaRecord.QA_TYPE_CODE_TERMINAL;//终末质控
		Map mapCondition = new HashMap();
		mapCondition.put("statusStr", statusStr);
		mapCondition.put("qaTypeCode", qaTypeCode);
		mapCondition.put("amrStatus", amrStatus);
		mapCondition.put("curDeptNm", curDeptNm);
		mapCondition.put("curMainDiNm", curMainDiNm);
		mapCondition.put("staIll", staIll);
		mapCondition.put("rcvTime", rcvTime.toString());
		mapCondition.put("enStaCd", enStaCd);
		mapCondition.put("suF", suF.toString());
		mapCondition.put("qaFlag", qaFlag.toString());
		mapCondition.put("excuteUserId", excuteUserId);
		mapCondition.put("executeDeptCode", executeDeptCode);
		mapCondition.put("workScreen", workScreen);
		mapCondition.put("pageNum", pageNum);
		mapCondition.put("pageSize", pageSize);
		return this.getCusQaPatientResultByCondition(mapCondition);
	}

	private ArrayResult<Amr> getCusQaPatientResultByCondition(Map map) throws Throwable{
		ArrayResult<Amr> amrArrayResult = qaAmrServiceMr.search(map);
		return amrArrayResult;
	}
	
	private ArrayResult<CusQaPatient> getCusQaPatientResultByCondition2(Map map) throws Throwable{
		ArrayResultBuilder<CusQaPatient> builder = ArrayResultBuilder.newArrayResult(CusQaPatient.class);
		String enPk = "";
		String qaPk = "";
		String qaTypeCode = getStringValueFromMap(map, "qaTypeCode");
		ArrayResult<Amr> amrResult = qaAmrServiceMr.getAmrByStatusInQa(map);
		int total = 0;
		String pageSizeStr = getStringValueFromMap(map, "pageSize");
		int pageSize = 25 ;
		if(!StringUtils.isBlank(pageSizeStr)){
			pageSize = Integer.valueOf(pageSizeStr);
		}
		if(amrResult.getDataList()!=null){
			total = amrResult.getTotal();
			SingleResult<EncounterModel> encounterResult = new SingleResult<EncounterModel>();
			SingleResult<QaRecord> qaRecordResult = new SingleResult<QaRecord>();
			int ps = (pageSize > amrResult.getDataList().length ? amrResult.getDataList().length : pageSize);
			CusQaPatient[] cusQaPatientArray = new CusQaPatient[ps];
			for (int i = 0; i < ps; i++) {
				CusQaPatient cusQaPatient = new CusQaPatient();
				CusAmr cusAmr = new CusAmr();
				EncounterModel encounterModel = new EncounterModel();
				Amr amr = amrResult.getDataList()[i];
				enPk = amr.getPk();
				BeanUtils.copyProperties(amr, cusAmr);
//				encounterResult = encounterServiceEn.getEncounterDetail(enPk);
				if(encounterResult.getData()!=null){
					encounterModel = encounterResult.getData();
					//满足条件的数据添加到cusAmr
					cusAmr.setAmrNo(amr.getAmrNo());
					cusAmr.setStatusName(amr.getStatusName());
					//查询质控工作记录中存在工作记录，若存在设置质控标记=1，否则0
					//判断是否有完成的质控工作记录，取最后一个完成的质控工作记录信息
					qaRecordResult = qaRecordServiceMr.searchLastCompleted(enPk, qaTypeCode);
					if(qaRecordResult.getData()!=null){
						qaPk = qaRecordResult.getData().getPk();
						cusAmr.setExcuteUserName(qaRecordResult.getData().getExcuteUserName());
						cusAmr.setExecuteDeptName(qaRecordResult.getData().getExecuteDeptName());
						cusAmr.setExecuteEndTime(qaRecordResult.getData().getExecuteEndTime());
						if(StringUtils.isEmpty(qaPk)){
							qaRecordResult = qaRecordServiceMr.searchFaultStatistical(qaPk, "", "");
							if(qaRecordResult.getData()!=null){
								cusAmr.setFaultTotal(qaRecordResult.getData().getFaultTotal());
								cusAmr.setFaultTodoReform(qaRecordResult.getData().getFaultTodoReform());
								cusAmr.setFaultTodoReview(qaRecordResult.getData().getFaultTodoReview());
							}
						}
					}
					cusQaPatient.setEncounterModel(encounterModel);
					cusQaPatient.setCusAmr(cusAmr);
					cusQaPatientArray[i] = cusQaPatient;
				}
			}
			builder.withData(cusQaPatientArray);
		}
		ArrayResult<CusQaPatient> cusQaPatientResult = builder.build();
		cusQaPatientResult.setTotal(total);
		return cusQaPatientResult;
	}
	
	@Override
	@Transactional(rollbackFor = { RuntimeException.class })
	public SingleResult<Amr> start(String enPk) throws Throwable {
		SingleResult<Amr> amrResult = new SingleResult<Amr>();
		try{
			amrResult = amrServiceMr.startQa(enPk);
			qaAmrServiceMr.setQaStatusCode(enPk, QaStaus.QA_STARTED);
			String qaSystemItemCode = getQaSystemCode();
			String str = faultRecordServiceMr.createFaultExtendInProcess(enPk, qaSystemItemCode);
		}catch (Exception e) {
            throw new RuntimeException(e);
        }
		return amrResult;
	}
	
	@Override
	@Transactional(rollbackFor = { RuntimeException.class })
	public SingleResult<Amr> stop(@PathVariable("id") String id) throws Throwable{
		String rank = null;
		SingleResult<Amr> amrResult = new SingleResult<Amr>();
		//判断质控状态（由前台判断？后台判断之后返回前台参数或Message？）~~~~~~~~~~~
		try{
			//修改enPk下的所有缺陷状态为已审核，若有未确认结果的（非扣分，不扣分），给前台提示
			ArrayResult<QaFault> faultArrayResult = faultRecordServiceMr.checkFaultReformResult(id);
			if(faultArrayResult.getTotal()>0){
				//返回前台message，不再执行后面代码
				Notification notification = new Notification(MessageCode.UN_FLT_CFM_RST);
				throw new NotificationException(notification);
			}
			faultRecordServiceMr.updateFaultStatusToVerified(id, "");
			SingleResult<Map> mapResult = qaScoreCaculateService.score(id);
			qaAmrServiceMr.setQaStatusCode(id, QaStaus.QA_COMPLETED);
			Map map = mapResult.getData();
			Double b = 0.0;
			if(map.containsKey("scoreValue")){
				b = (Double) map.get("scoreValue");
			}
			BigDecimal score = new BigDecimal(b);
			rank = getStringValueFromMap(map, "rankCode");
			//保存病案，并设置病案状态为“已完成质控”
			amrResult = qaAmrServiceMr.qaCompleted(id, score, rank);
		}catch (Exception e) {
            throw new RuntimeException(e);
        }
		return amrResult;
	}
	
	@Override
	@Transactional(rollbackFor = { RuntimeException.class })
	public SingleResult<Amr> revoke(@PathVariable("id") String id) throws Throwable{
		//判断病案状态（由前台判断？后台判断之后返回前台参数或Message？）~~~~~~~~~~~
		//修改病案状态为“终末质控中”，清空质控得分、病案等级字段
		SingleResult<Amr> amrResult = new SingleResult<Amr>();
		try{
			amrResult = qaAmrServiceMr.revokeQaCompleted(id);
			qaAmrServiceMr.setQaStatusCode(id, QaStaus.QA_STARTED);
		}catch (Exception e) {
            throw new RuntimeException(e);
        }
		return amrResult;
	}
	
	private String getQaSystemCode() throws Throwable{
		Session session = Session.get();
		String orgCd = session.getOrgCd();
		String qaSystemCode = "";
		Map params = new HashMap();
		params.put("orgCode", orgCd);
		params.put("configCode", MrConfigCode.QA_SYSTEM_CODE);
		 SingleResult<ConfigItemData> config = null;
		config = configItemDataService.search(params);
		qaSystemCode = config.getData().getValue();
		return qaSystemCode;
	}
	
	private String getStringValueFromMap(Map map,String key){
		String value = "";//null ;
		if(map.containsKey(key) && null != map.get(key)){
			value = (String)map.get(key);
			if(StringUtils.isBlank(value)){
				value = "";//null ;
			}
		}
		return value;
	}

}
