package pkuhit.iih.iemr.qa;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.transaction.annotation.Transactional;

import pkuhit.iih.en.EncounterModel;
import pkuhit.iih.mr.wr.Amr;
import pkuhit.iih.mr.wr.MedicalRecordService;
import pkuhit.iih.mr.wr.QaAmrService;
import pkuhit.iih.pub.MrConfigCode;
import pkuhit.iih.qa.CusQaFault;
import pkuhit.iih.qa.old.QaFault;
import pkuhit.iih.qa.old.QaFaultItem;
import pkuhit.iih.qa.old.QaRecord;
import pkuhit.xap.ac.Session;
import pkuhit.xap.cfg.ConfigItemData;
import pkuhit.xap.cfg.ConfigItemDataService;
import pkuhit.xap.task.TaskActionService;
import xap.sv.annotation.Reference;
import xap.sv.model.ArrayResult;
import xap.sv.model.SingleResult;
import xap.sv.model.SingleResultBuilder;
import xap.sv.util.UUIDGenerator;

/**
 * 
 * @author wang_yanli
 *
 */
public class QaFaultServiceImpl implements QaFaultService {

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
	
	public QaFaultServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	//wangyanli保存质控缺陷服务实现
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
					SingleResult<EncounterModel> encounterResult = new SingleResult<EncounterModel>();
//					encounterResult = encounterServiceEn.getEncounterDetail(encounterPk);
					if(encounterResult.getData()!=null){
						qaRecordResult.getData().setPatientName(encounterResult.getData().getPaNm());// 患者姓名
						qaRecordResult.getData().setEncounterDept(encounterResult.getData().getCurDeptNm());// 就诊科室
						qaRecordResult.getData().setBedNo(encounterResult.getData().getCurBedCd());// 床位号
					}
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
				else {
				//提示参数不能为空~~~~~~
				return null;
			}
		}catch(Exception e){
			throw new RuntimeException(e);
		}finally{
			return qaRecordResult;
		}
	}
	
	
	@Override
	public SingleResult<CusQaFault> search(Map map) throws Throwable {
		SingleResultBuilder<CusQaFault> builder = SingleResultBuilder.newSingleResult(CusQaFault.class);
		CusQaFault cusQaFault = new CusQaFault();
		Map mapCondition = new HashMap();
		if(map!=null){
			String encounterPk = null ;
			if(map.containsKey("encounterPk")){
				encounterPk = map.get("encounterPk").toString();
			}
			String currentQaPk = null; 
			if(encounterPk!=null){
				currentQaPk = qaRecordServiceMr.checkExistUncompleted(encounterPk);
			}
			Session session = Session.get();
			String userId = session.getUserId();
			String deptId = session.getDeptId();
			String qaTypeCode = getStringValueFromMap(map, "qaTypeCode");
			String statusCode = getStringValueFromMap(map, "statusCode");
			String dropFlag = getStringValueFromMap(map, "dropFlag");
			String workScreen = "";
			if(map.containsKey("workScreen")){
				workScreen = map.get("workScreen").toString();
			}
			String isDept = "";
			if(map.containsKey("isDept")){
				isDept = map.get("isDept").toString();
			}
			if("1".equals(workScreen)){
				mapCondition.put("encounterPk", encounterPk);
				mapCondition.put("qaTypeCode", qaTypeCode);
				mapCondition.put("statusCode", statusCode);
				mapCondition.put("dropFlag", dropFlag);
				mapCondition.put("submittedUserId", userId);
				mapCondition.put("submittedDeptCode", "");
			}else if("2".equals(workScreen)||"3".equals(workScreen)){
				mapCondition.put("encounterPk", encounterPk);
				mapCondition.put("qaTypeCode", qaTypeCode);
				mapCondition.put("statusCode", statusCode);
				mapCondition.put("dropFlag", dropFlag);
				mapCondition.put("submittedUserId", "");
				mapCondition.put("submittedDeptCode", "");
			}else if("4".equals(workScreen)||"5".equals(workScreen)){
				if("1".equals(isDept)){
					mapCondition.put("submittedUserId", userId);
					mapCondition.put("submittedDeptCode", "");
				}else if("2".equals(isDept)){
					mapCondition.put("submittedUserId", "");
					mapCondition.put("submittedDeptCode", deptId);
				}
				mapCondition.put("encounterPk", encounterPk);
				mapCondition.put("qaTypeCode", qaTypeCode);
				mapCondition.put("statusCode", statusCode);
				mapCondition.put("dropFlag", dropFlag);
			}else if("6".equals(workScreen)){
				mapCondition.put("encounterPk", encounterPk);
				mapCondition.put("qaTypeCode", "");
				mapCondition.put("statusCode", QaFault.STATUS_CODE_SUBMITTED);//已提出
				mapCondition.put("dropFlag", "");
				mapCondition.put("submittedUserId", "");
				mapCondition.put("submittedDeptCode", "");
			} 
			/*ArrayResult<QaFault> qaFaultArrayResult = searchByCondition(mapCondition);
			cusQaFault.setCurrentQaPk(currentQaPk);
			cusQaFault.setQaFaultList(qaFaultArrayResult);*/
			builder.withData(cusQaFault);
		}
		return builder.build();
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
	
	public String getStringValueFromMap(Map map,String key){
		String value = null ;
		if(map.containsKey(key)){
			value = (String)map.get(key);
			if(StringUtils.isBlank(value)){
				value = null ;
			}
		}
		return value;
	}

}
