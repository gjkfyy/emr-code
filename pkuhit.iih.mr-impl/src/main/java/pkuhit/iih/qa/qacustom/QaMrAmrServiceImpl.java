
package pkuhit.iih.qa.qacustom;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.seasar.doma.jdbc.SelectOptions;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import pkuhit.iih.ass.di.AssDiagnosisService;
import pkuhit.iih.di.DiagnosisModel;
import pkuhit.iih.en.md.EncounterStatus;
import pkuhit.iih.en.md.IllStatus;
import pkuhit.iih.mr.dao.auto.MrAmrDao;
import pkuhit.iih.mr.dao.auto.MrDao;
import pkuhit.iih.mr.dao.auto.entity.Mr;
import pkuhit.iih.mr.dao.auto.entity.MrAmr;
import pkuhit.iih.mr.md.AmrStatus;
import pkuhit.iih.mr.wr.Amr;
import pkuhit.iih.mr.wr.MedicalRecord;
import pkuhit.iih.mr.wr.MedicalRecordService;
import pkuhit.iih.qa.CusQaAutoFltModel;
import pkuhit.iih.qa.QaDivideModel;
import pkuhit.iih.qa.QaFault;
import pkuhit.iih.qa.dao.auto.QaDivideDao;
import pkuhit.iih.qa.dao.auto.entity.QaDivide;
import pkuhit.iih.qa.dao.auto.entity.QaFlt;
import pkuhit.iih.qa.dao.qacustom.CusQaMrAmrDao;
import pkuhit.iih.qa.dao.qacustom.CusQaRevisionNoticeDao;
import pkuhit.iih.qa.md.QaFltStatus;
import pkuhit.iih.qa.qaauto.QaItemService;
import pkuhit.iih.qa.qacustom.bizmodel.QaFaultStatistical;
import pkuhit.iih.qa.util.QaUtil;
import pkuhit.md.DictionaryService;
import pkuhit.md.SysFunctionCode;
import pkuhit.xap.ac.Session;
import pkuhit.xap.ac.UserRole;
import pkuhit.xap.ac.UserRoleService;
import pkuhit.xap.pm.Param;
import pkuhit.xap.pm.ParamsService;
import pkuhit.xap.util.BeanCopyUtil;
import xap.sv.annotation.Reference;
import xap.sv.model.ArrayResult;
import xap.sv.model.ArrayResultBuilder;
import xap.sv.model.SingleResult;
import xap.sv.model.SingleResultBuilder;
import xap.sv.servlet.mvc.annotation.RequestParam;
import xap.sv.util.UUIDGenerator;
/**
 * 
 * @author yao_lijie
 *
 */
public class QaMrAmrServiceImpl implements QaMrAmrService {
	
	@Autowired
	CusQaMrAmrDao cusQaMrAmrDao;

	@Reference
	DictionaryService dictionaryService;

	@Autowired
	MrDao mrDao;
	
	@Autowired
	MrAmrDao mrAmrDao;
	
	@Autowired
	CusQaRevisionNoticeDao cusQaRevisionNoticeDao;
	
	@Reference
	MedicalRecordService mRService;
	
	@Autowired
	QaDivideDao qaDivideDao;
	
	@Autowired
	AssDiagnosisService diService;
	
	@Reference
	QaItemService qaItemService;
	
	@Reference
	ParamsService paramsService; //系统参数设置
	
	@Reference
	UserRoleService userRoleService; //用户角色service
	
	public QaMrAmrServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public ArrayResult<Amr> search(Map<String, String> map) throws Throwable{
		
		//是否护士角色
		String isNurseRole = "false";
		Session session = Session.get();
		String userId = session.getUserId();
		String orgCd = session.getDeptId();//.getOrgCd();
		Map<String, String> params = new HashMap();
		params.put("userId", userId);
		params.put("orgCd", orgCd);
		ArrayResult<UserRole> userRoles = userRoleService.search(params);
		UserRole[] userRoleArray = userRoles.getDataList();
		for(UserRole userRole:userRoleArray){
			if(userRole.getRoleCode().equals("XAPM14.22")||userRole.getRoleCode().equals("XAPM14.23")){
				isNurseRole="true";
				break;
    		}
		}
		
		/*就诊对象查询条件*/
		String curDeptNm = getStringValueFromMap(map, "curDeptNm");//就诊科室
		String amrNo = getStringValueFromMap(map, "amrNo");//住院号
		String patientName = getStringValueFromMap(map, "patientName");//患者姓名
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
		String beginTime = getStringValueFromMap(map, "beginTime");
		String endTime = getStringValueFromMap(map, "endTime");
//		String leaveHospitalFlag = getStringValueFromMap(map, "enStaCd"); //在院或者已出院（病案未完成） 出院==诊毕  EncounterStatus
		/*病案对象查询条件*/
		String amrStatus = "";
		amrStatus += getStringValueFromMap(map, "amrStatus")+","; //病案状态
		if(",".equals(amrStatus)){
			amrStatus = "";
		}
		//---处理已出院---
		if(!StringUtils.isEmpty(enStaCd)){
			if("1".equals(enStaCd)){
				enStaCd = EncounterStatus.receipted;
			}else if("2".equals(enStaCd)){
				enStaCd = EncounterStatus.completed;
			}
		}
		String qaFlag =  getStringValueFromMap(map, "qaFlag"); //质控标记
		//--查询专项病例内容--
		String specialMr = getStringValueFromMap(map, "specialMr"); 
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
		String workScreen =  getStringValueFromMap(map, "workScreen"); //工作场景
		String qaTypeCode = QaFltStatus.QA_TY_CD_PROCESS;//环节质控
		
		String statusStr = AmrStatus.WRITE_STARTED;//书写已开始（环节质控） 
		/*List<String> amrStatusList = new ArrayList<String>();
		if(!StringUtils.isEmpty(amrStatus)){
			if(!"null".equals(amrStatus)){
				String[] amrStatusArr = amrStatus.split(",");
				amrStatusList = Arrays.asList(amrStatusArr);
			}
		}*/
		ArrayResultBuilder<Amr> builder = ArrayResultBuilder.newArrayResult(Amr.class);
		List<Map<String, Object>> mrAmrList = null; //患者列表
		Map<String, Object> mrAmr = null;//统计信息
		int qaCount=0;
		//质控信息
		Map<String, Object> amrMap = null;

		SelectOptions options = SelectOptions.get().offset((Integer.valueOf(pageNum)-1)*Integer.valueOf(pageSize)).limit(Integer.valueOf(pageSize)).count();			
		//mrAmrList = cusQaMrAmrDao.selectAmrByCondition(qaTypeCode, statusStr, curDeptNm,amrNo ,patientName, staIll, rcvTime, enStaCd, suF, qaFlag, options);
		if(specialMr.equals("")){
			//wangyanli 修改于20150422 查询病案时一并查询出缺陷数
			mrAmrList = cusQaMrAmrDao.selectAmrAndFaultByCondition(qaTypeCode, statusStr, curDeptNm,amrNo ,patientName, staIll, rcvTime, enStaCd, suF, qaFlag,beginTime,endTime,isNurseRole, options);
		}else if(specialMr.equals("01") || specialMr.equals("17")){//转科 |转入、转出重症监护室 
			mrAmrList = cusQaMrAmrDao.selectAmrAndFaultZyAdtByCondition(qaTypeCode, statusStr, curDeptNm,amrNo ,patientName, staIll, rcvTime, enStaCd, suF, qaFlag,beginTime,endTime,specialMr,isNurseRole, options);
		}else if(specialMr.equals("02") || specialMr.equals("04") || specialMr.equals("07") || specialMr.equals("08") || specialMr.equals("09") || specialMr.equals("10") || specialMr.equals("12")){
			//会诊 、非计划再次手术病例 、输血患者  、下病危，病重通知单的患者 、抢救患者、特护患者、死亡患者   
			mrAmrList = cusQaMrAmrDao.selectAmrAndFaultOrderByCondition(qaTypeCode, statusStr, curDeptNm,amrNo ,patientName, staIll, rcvTime, enStaCd, suF, qaFlag,beginTime,endTime,specialMr,isNurseRole, options);
		}else if(specialMr.equals("03")){//检验危急值
			mrAmrList = cusQaMrAmrDao.selectAmrAndFaultJyByCondition(qaTypeCode, statusStr, curDeptNm,amrNo ,patientName, staIll, rcvTime, enStaCd, suF, qaFlag,beginTime,endTime,isNurseRole, options);
		}else if(specialMr.equals("06")){//住院超过30天
			mrAmrList = cusQaMrAmrDao.selectAmrAndFaultZyByCondition(qaTypeCode, statusStr, curDeptNm,amrNo ,patientName, staIll, rcvTime, enStaCd, suF, qaFlag,beginTime,endTime,isNurseRole, options);
		}else if(specialMr.equals("11")){//重大，特殊手术患者
			mrAmrList = cusQaMrAmrDao.selectAmrAndFaultOpByCondition(qaTypeCode, statusStr, curDeptNm,amrNo ,patientName, staIll, rcvTime, enStaCd, suF, qaFlag,beginTime,endTime,isNurseRole, options);
		}else if(specialMr.equals("18")){//手术前讨论记录  
			mrAmrList = cusQaMrAmrDao.selectAmrAndFaultSqtlByCondition(qaTypeCode, statusStr, curDeptNm,amrNo ,patientName, staIll, rcvTime, enStaCd, suF, qaFlag,beginTime,endTime,isNurseRole, options);
		}else if(specialMr.equals("19") || specialMr.equals("20") ||specialMr.equals("21")){//有创诊疗操作记录 、疑难病例讨论、多学科会诊
			mrAmrList = cusQaMrAmrDao.selectAmrAndFaultYczlByCondition(qaTypeCode, statusStr, curDeptNm,amrNo ,patientName, specialMr,staIll, rcvTime, enStaCd, suF, qaFlag,beginTime,endTime,isNurseRole, options);
		}
		
		int total = 0;
		if(mrAmrList!=null&&mrAmrList.size()>0){
			long count = options.getCount();
			total = Long.valueOf(count).intValue();
			Amr [] amrs=new Amr[mrAmrList.size()];
			for(int i=0;i<mrAmrList.size();i++){
				Amr amr = new Amr();
				amrMap = mrAmrList.get(i);
				BeanCopyUtil.mapToModel(amr, amrMap, dictionaryService);
				String enPk = amr.getPk();
				qaCount = cusQaMrAmrDao.selectQaCount(enPk, qaTypeCode); //根据质控工作记录查询质控次数
				amr.setQaCount(qaCount);
				mrAmr = cusQaMrAmrDao.selectQa(enPk, qaTypeCode); //根据质控工作记录查询质控医师
				if(mrAmr!=null){
					BeanCopyUtil.mapToModel(amr, mrAmr, dictionaryService);
				}
				/*String enPk = amr.getPk();
				mrAmr = cusQaMrAmrDao.selectAmrFaultStatistical(enPk, qaTypeCode);
				if(mrAmr!=null){
					BeanCopyUtil.mapToModel(amr, mrAmr, dictionaryService);
				}*/
				//amr.setPk((String)mrAmrList.get(i).get("EN_PK"));
			//	从视图中获取主诊断
				ArrayResult<DiagnosisModel> diList = diService.search(amr.getPk(), "1", null, null, null);
				if(diList != null && diList.getDataList() != null){
				    DiagnosisModel[] diArr = diList.getDataList();
				    if(diArr != null && diArr.length>0){
				        amr.setCurrentMainDiagnosisCode(diArr[0].getDiPk());
				        amr.setCurrentMainDiagnosisName(diArr[0].getDiNm());
				    }
				}
				amrs[i] = amr;
			}
			if(amrs!=null){
				builder.withData(amrs);
			}
		}
		ArrayResult<Amr> amrResult = builder.build();
		amrResult.setTotal(total);
		return amrResult;
	}
	
	
	@Override
	public ArrayResult<Amr> searchTerminalList(Map map)
			throws Throwable {
		/*就诊对象查询条件*/
		String curDeptNm = getStringValueFromMap(map, "curDeptNm");//就诊科室
		String amrNo = getStringValueFromMap(map, "amrNo");//住院号
		String patientName = getStringValueFromMap(map, "patientName");//患者姓名
		String beginTime = getStringValueFromMap(map, "beginTime");//出院时间段
		String endTime = getStringValueFromMap(map, "endTime");
//		String rcvTime = getStringValueFromMap(map, "rcvTime"); //入院时间  1:入院24小时内、2:入院7日内、3:全部在院
		/*病案对象查询条件*/
		String amrStatus = getStringValueFromMap(map, "amrStatus");
		String terminalQaStaCd = getStringValueFromMap(map, "terminalQaStaCd"); //终末质控状态
		String deptQaStaCd = getStringValueFromMap(map, "deptQaStaCd"); //终末质控状态
		String qaTypeCode = getStringValueFromMap(map, "qaTypeCode");//科室/终末质控/医嘱质控QAM13.07（wangyanli add）
		//患者就诊状态，在医嘱质控时用，其他质控传入"",即可
		String enStaCd = "";
		if(qaTypeCode != null && qaTypeCode.equals("QAM13.07")){
			enStaCd = EncounterStatus.receipted;
		}

		//--查询专项病例内容--
		String specialMr = getStringValueFromMap(map, "specialMr"); 
		
		//--自动质控分数段查询--
		String qaAutoScrMin = getStringValueFromMap(map, "qaAutoScrMin"); 
		
		String qaAutoScrMax = getStringValueFromMap(map, "qaAutoScrMax"); 
		
		/*质控工作记录对象查询条件*/
		Session session = Session.get();
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
		/*String workScreen = getStringValueFromMap(map, "workScreen");//2：质控工作画面终末质控，3：质控评分画面

		if(!StringUtils.isEmpty(workScreen)){
				amrStatus += AmrStatus.QA_STARTED; //已签收
		}*/
		ArrayResultBuilder<Amr> builder = ArrayResultBuilder.newArrayResult(Amr.class);
		List<Map<String, Object>> mrAmrList = null; //患者列表
		Map<String, Object> mrAmr = null;//统计信息
		//质控信息
		Map<String, Object> amrMap = null;
		if(StringUtils.isBlank(pageNum)){
			pageNum = "1" ;
		}
		if(StringUtils.isBlank(pageSize)){
			pageSize = "25" ;
		}
		SelectOptions options = SelectOptions.get().offset((Integer.valueOf(pageNum)-1)*Integer.valueOf(pageSize)).limit(Integer.valueOf(pageSize)).count();			
		
		if(specialMr.equals("")){
			mrAmrList = cusQaMrAmrDao.selectTerminalAmrByCondition(qaTypeCode, amrStatus, curDeptNm,amrNo ,patientName,beginTime,endTime,enStaCd,qaAutoScrMin,qaAutoScrMax,terminalQaStaCd,deptQaStaCd,options);
		}else if(specialMr.equals("01") || specialMr.equals("17")){//转科 |转入、转出重症监护室 
			mrAmrList = cusQaMrAmrDao.selectTerminalAmrZyAdtByCondition(qaTypeCode, amrStatus, curDeptNm,amrNo ,patientName,beginTime,endTime,enStaCd,specialMr,qaAutoScrMin,qaAutoScrMax,options);
		}else if(specialMr.equals("02") || specialMr.equals("04") || specialMr.equals("07") || specialMr.equals("08") || specialMr.equals("09") || specialMr.equals("10") || specialMr.equals("12")){
			//会诊 、非计划再次手术病例 、输血患者  、下病危，病重通知单的患者 、抢救患者、特护患者、死亡患者   
			mrAmrList = cusQaMrAmrDao.selectTerminalAmrOrderByCondition(qaTypeCode, amrStatus, curDeptNm,amrNo ,patientName,beginTime,endTime,enStaCd,specialMr,qaAutoScrMin,qaAutoScrMax,options);
		}else if(specialMr.equals("03")){//检验危急值
			mrAmrList = cusQaMrAmrDao.selectTerminalAmrJyByCondition(qaTypeCode, amrStatus, curDeptNm,amrNo ,patientName,beginTime,endTime,enStaCd,qaAutoScrMin,qaAutoScrMax,options);
		}else if(specialMr.equals("06")){//住院超过30天
			mrAmrList = cusQaMrAmrDao.selectTerminalAmrZyByCondition(qaTypeCode, amrStatus, curDeptNm,amrNo ,patientName,beginTime,endTime,enStaCd,qaAutoScrMin,qaAutoScrMax,options);
		}else if(specialMr.equals("11")){//重大，特殊手术患者
			mrAmrList = cusQaMrAmrDao.selectTerminalAmrOpByCondition(qaTypeCode, amrStatus, curDeptNm,amrNo ,patientName,beginTime,endTime,enStaCd,qaAutoScrMin,qaAutoScrMax,options);
		}else if(specialMr.equals("18")){//手术前讨论记录  
			mrAmrList = cusQaMrAmrDao.selectTerminalAmrSqtlByCondition(qaTypeCode, amrStatus, curDeptNm,amrNo ,patientName,beginTime,endTime,enStaCd,qaAutoScrMin,qaAutoScrMax,options);
		}else if(specialMr.equals("19") || specialMr.equals("20") || specialMr.equals("21")){//有创诊疗操作记录 
			mrAmrList = cusQaMrAmrDao.selectTerminalAmrYczlByCondition(qaTypeCode, amrStatus, curDeptNm,amrNo ,patientName,specialMr,beginTime,endTime,enStaCd,qaAutoScrMin,qaAutoScrMax,options);
		}
		
		int total = 0;
		if(mrAmrList!=null&&mrAmrList.size()>0){
			long count = options.getCount();
			total = Long.valueOf(count).intValue();
			Amr [] amrs=new Amr[mrAmrList.size()];
			for(int i=0;i<mrAmrList.size();i++){
				Amr amr = new Amr();
				amrMap = mrAmrList.get(i);
				BeanCopyUtil.mapToModel(amr, amrMap, dictionaryService);
			    /* wangyanli（20150422）注掉以下代码，改造selectTerminalAmrByCondition方法，该方法一并查出缺陷数
			    String enPk = amr.getPk();
				
				mrAmr = cusQaMrAmrDao.selectAmrFaultStatistical(enPk, qaTypeCode);
				if(mrAmr!=null){
					BeanCopyUtil.mapToModel(amr, mrAmr, dictionaryService);
				}
				amr.setPk((String)mrAmrList.get(i).get("EN_PK"));*/
				String pk = amr.getPk();
				/*调用服务判断表格中按钮状态*/
				// 提缺陷完成和质控完成走一个状态-syh改                       judgeTerminalAmrState(pk,qaTypeCode);
				String btnFlag = QaUtil.amrFinishBtnFlag(cusQaMrAmrDao, dictionaryService, pk, qaTypeCode);
				amr.setBtnFlag(btnFlag);
				/*从视图中获取主诊断*/
				ArrayResult<DiagnosisModel> diList = diService.search(pk, "1", null, null, null);
				if(diList != null && diList.getDataList() != null){
				    DiagnosisModel[] diArr = diList.getDataList();
				    if(diArr != null && diArr.length>0){
				        amr.setCurrentMainDiagnosisCode(diArr[0].getDiPk());
				        amr.setCurrentMainDiagnosisName(diArr[0].getDiNm());
				    }
				}
				amrs[i] = amr;
			}
			if(amrs!=null){
				builder.withData(amrs);
			}
		}
		ArrayResult<Amr> amrResult = builder.build();
		amrResult.setTotal(total);
		return amrResult;
	}
	
	public ArrayResult<MedicalRecord> setQaStatusCode(String enPk, String qaStatusCode) throws Throwable{
		ArrayResultBuilder<MedicalRecord> builder = ArrayResultBuilder.newArrayResult(MedicalRecord.class);
		ArrayResult<MedicalRecord> mrArrayResult = new ArrayResult<MedicalRecord>();
		Map param = new HashMap();
		param.put("encounterPk", enPk);
		mrArrayResult = mRService.search(param);
		MedicalRecord[] mrArr = mrArrayResult.getDataList();
		if(mrArrayResult.getTotal()!=null&&mrArrayResult.getTotal()>0){
			for(int i=0;i<mrArrayResult.getTotal();i++){
				MedicalRecord mr = new MedicalRecord();
				Mr m = new Mr();
				mr = mrArr[i];
				mr.setQaStatusCode(qaStatusCode);
				BeanCopyUtil.modelToEntity(m, mr);
				mrDao.updateExcludeNull(m);
			}
			builder.withData(mrArr);
		}
		
		return builder.build();
	}
	
	
	public String judgeTerminalAmrState(String enPk,String qaTypeCode) throws Throwable {
		String str = "0";
		/*String enPk = getStringValueFromMap(map, "pk");
		String qaTypeCode = getStringValueFromMap(map, "qaTypeCode");*/
		SingleResult<QaFaultStatistical>  statisticalResult = faultStatistical(enPk,qaTypeCode);
		if(statisticalResult.getData()!=null){
			QaFaultStatistical qaFaultStatistical = statisticalResult.getData();
			BigDecimal toReform=qaFaultStatistical.getToReform();
			BigDecimal reformed=qaFaultStatistical.getReformed();
			BigDecimal otherState=qaFaultStatistical.getOtherState();
//			BigDecimal revisionNum=qaFaultStatistical.getRevisionNum();
			int toReformNum = 0;
			if(toReform!=null){
				toReformNum = toReform.intValue();
			}
			int reformedNum = 0;
			if(reformed!=null){
				reformedNum = reformed.intValue();
			}
			int otherStateNum = 0;
			if(otherState!=null){
				otherStateNum = otherState.intValue();
			}
			/*int revisionNumber = 0;
			if(revisionNum!=null){
				revisionNumber = revisionNum.intValue();
			}*/
			if(reformedNum>0 || toReformNum>0){
				str = "1";
			}else if(otherStateNum>0){
				int revisionNumber = this.getQaRevisionNoticeNum(enPk,qaTypeCode);
				if(revisionNumber >0){
					str = "1";
				}else{
					str = "2";
				}
			}else{
				str = "2";
			}
		}
		return str;
	}
	
	@Override
	public SingleResult<Amr> signTerminalAmr(Map map) throws Throwable {
		List<Map> list = (List<Map>)map.get("datas");
		String qaDeptTerminalParalle = (String) map.get("qaDeptTerminalParalle");
		String qaTypeCode = (String) map.get("qaTypeCd");
		SingleResult<Amr> amrResult = null;
        for(int i=0;i<list.size();i++){
            String pk = (String)list.get(i).get("pk");
            if(qaDeptTerminalParalle.equals("true")){
            	amrResult = updateAmrStatus(pk, AmrStatus.QA_STARTED,qaDeptTerminalParalle,qaTypeCode);
            }else{
            	amrResult = updateAmrStatus(pk, AmrStatus.QA_STARTED,qaDeptTerminalParalle,null);
            }
            
		}
		return amrResult;
	}

	@Override
	public SingleResult<Amr> backTerminalAmr(String pk) throws Throwable {
		SingleResult<Amr> amrResult = updateAmrStatus(pk, AmrStatus.WRITE_STARTED,null,null);
		return amrResult;
	}

	@Override
	public SingleResult<Amr> finishTerminalAmr(String pk, Map map) throws Throwable {
		String qaDeptTerminalParalle = getStringValueFromMap(map, "qaDeptTerminalParalle");
		String qaTypeCode = QaFltStatus.QA_TY_CD_TERMINAL;//终末质控
		SingleResult<Amr> amrResult = updateAmrStatus(pk, AmrStatus.QA_COMPLETED,qaDeptTerminalParalle,qaTypeCode); //已终末质控
	
		List<QaFlt> qaFaultList = new ArrayList<QaFlt>(); //缺陷列表 
		qaFaultList = cusQaMrAmrDao.selectQaFaults(pk,qaTypeCode);
			try{
				if (qaFaultList != null && qaFaultList.size() > 0) {
					for (int i = 0; i < qaFaultList.size(); i++) {
						QaDivide qaDivide =new QaDivide();
						QaFlt qaFlt = new QaFlt();
						qaFlt = qaFaultList.get(i);
						BeanUtils.copyProperties(qaFlt, qaDivide);
						qaDivide.setQaDivideCd(UUIDGenerator.getUUID());
						qaDivide.setQaItmPk(qaFlt.getQaItmCd());
						qaDivideDao.insertExludeNull(qaDivide);
					}
				}
			}catch(Exception e){
				throw new RuntimeException(e);
			}
			//系统参数配置是否启用补充自动质控,默认不启用
			boolean qaAutoEnable=false;
			Param[] params=paramsService.getParam(SysFunctionCode.QA_AUTO_CONFIG).getDataList();
			if(params.length>0){
				Param param=params[0];
				if("1".equals(param.getValue())){
					qaAutoEnable=true;
				}
			}
			if(qaAutoEnable){
				//补充自动质控 --wangyanli20150618
				String qaAutoTypeCode = QaFltStatus.QA_TY_CD_AUTO_TERMINAL;//终末自动质控
				qaItemService.qaAutoTest(pk,qaAutoTypeCode);
			}
		return amrResult;	
	}
	
	@Override
	public SingleResult<Amr> finishDeptAmr(String pk, Map map) throws Throwable {
		String qaDeptTerminalParalle = getStringValueFromMap(map, "qaDeptTerminalParalle");
		String qaTypeCode = QaFltStatus.QA_TY_CD_DEPT;//科室质控
		SingleResult<Amr> amrResult = updateAmrStatus(pk, AmrStatus.QA_DEPT,qaDeptTerminalParalle,qaTypeCode); //已科室质控
		List<QaFlt> qaFaultList = new ArrayList<QaFlt>(); //缺陷列表    同步到评分表中
		qaFaultList = cusQaMrAmrDao.selectQaFaults(pk,qaTypeCode);
			try{
				if (qaFaultList != null && qaFaultList.size() > 0) {
					for (int i = 0; i < qaFaultList.size(); i++) {
						QaDivide qaDivide =new QaDivide();
						QaFlt qaFlt = new QaFlt();
						qaFlt = qaFaultList.get(i);
						BeanUtils.copyProperties(qaFlt, qaDivide);
						qaDivide.setQaDivideCd(UUIDGenerator.getUUID());
						qaDivide.setQaItmPk(qaFlt.getQaItmCd());
						qaDivideDao.insertExludeNull(qaDivide);
					}
				}
			}catch(Exception e){
				throw new RuntimeException(e);
			}
		
			//系统参数配置是否启用补充自动质控,默认不启用
			boolean qaAutoEnable=false;
			Param[] params=paramsService.getParam(SysFunctionCode.QA_AUTO_CONFIG).getDataList();
			if(params.length>0){
				Param param=params[0];
				if("1".equals(param.getValue())){
					qaAutoEnable=true;
				}
			}
			if(qaAutoEnable){
				//补充自动质控 --wangyanli
				String qaAutoTypeCode = QaFltStatus.QA_TY_CD_AUTO_DEPT;
				qaItemService.qaAutoTest(pk,qaAutoTypeCode);
			}
		return amrResult;
	}
	
	private SingleResult<Amr> updateAmrStatus(String pk, String amrStatusCd,String qaDeptTerminalParalle,String qaTypeCode){
		SingleResultBuilder<Amr> builder = SingleResultBuilder.newSingleResult(Amr.class);
		MrAmr mrAmr = mrAmrDao.selectById(pk);
		
		if(null !=qaDeptTerminalParalle && qaDeptTerminalParalle.equals("true")){
			//科室质控完成 wangyanli 20160927
			if(qaTypeCode.equals("QAM13.02")){
				
				mrAmr.setDeptQaStaCd(amrStatusCd);
				
			}else if(qaTypeCode.equals("QAM13.03")){
				
				mrAmr.setTerminalQaStaCd(amrStatusCd); //终末
				
			}
		}else{
			mrAmr.setAmrStaCd(amrStatusCd);
		}
	
		try{
		mrAmrDao.update(mrAmr);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		Amr amr = new Amr();
		BeanCopyUtil.entityToModel(amr, mrAmr, QaFault.OBJ_CD, dictionaryService);
		builder.withData(amr);
		return builder.build();
	}

	private SingleResult<QaFaultStatistical> faultStatistical(String enPk,String qaTypeCode) throws Throwable {
		SingleResultBuilder<QaFaultStatistical> builder = SingleResultBuilder.newSingleResult(QaFaultStatistical.class);
//		String qaTypeCode = QaFltStatus.QA_TY_CD_TERMINAL;//终末质控
		Map map = cusQaMrAmrDao.selectAmrFaultNoticeNum(enPk, qaTypeCode);
		QaFaultStatistical 	qaFaultStatistical = new QaFaultStatistical();
		BeanCopyUtil.mapToModel(qaFaultStatistical, map, dictionaryService);
		builder.withData(qaFaultStatistical);
		return builder.build();
	}
	
	private int getQaRevisionNoticeNum(String enPk,String qaTypeCode) throws Throwable {
		int num=0;
//		String qaTypeCode = QaFltStatus.QA_TY_CD_TERMINAL;//终末质控
		num = cusQaMrAmrDao.selectQaNoticeNum(enPk, qaTypeCode);
		return num;
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
	
	@Override
	public ArrayResult<Amr> searchQaProcessAutoList(Map map)
			throws Throwable {
		/*查询条件*/
		String curDeptNm = QaUtil.getStringValueFromMap(map, "curDeptNm"); //科室
		String amrNo = QaUtil.getStringValueFromMap(map, "amrNo");//住院号
		String patientName = getStringValueFromMap(map, "patientName");//患者姓名
		String currentManageDoctorName = QaUtil.getStringValueFromMap(map, "currentManageDoctorName"); //整改医师
		String pageNum = null;
		String pageSize = null;
		if(map.containsKey("pageNum") && map.containsKey("pageSize")){
			pageNum = (String)map.get("pageNum");
			pageSize = (String)map.get("pageSize");
		}
		if(null == pageNum || !StringUtils.isNumeric(pageNum)   || null == pageSize || !StringUtils.isNumeric(pageSize)  )
		{
			pageNum= "1";
			pageSize = "15";
		}
		/*质控工作记录对象查询条件*/
		Session session = Session.get();
		String workScreen =  QaUtil.getStringValueFromMap(map, "workScreen"); //工作场景
		String qaTypeCode = QaFltStatus.QA_TY_CD_AUTO_PROCESS;//自动质控
		String statusStr = AmrStatus.WRITE_STARTED;//书写已开始（环节质控）
		
		ArrayResultBuilder<Amr> builder = ArrayResultBuilder.newArrayResult(Amr.class);
		List<Map<String, Object>> amrList = null; //患者列表
		//质控信息
		Map<String, Object> amrMap = null;
		
		ArrayResult<QaDivideModel> result = null; //患者列表
		String qaAutoTypeCode = QaFltStatus.QA_TY_CD_AUTO_PROCESS;

		SelectOptions options = SelectOptions.get().offset((Integer.valueOf(pageNum)-1)*Integer.valueOf(pageSize)).limit(Integer.valueOf(pageSize)).count();			
		amrList = cusQaMrAmrDao.selectQaProcessAuto(statusStr,curDeptNm,amrNo ,patientName, currentManageDoctorName,options);
		int total = 0;
		if(amrList!=null&&amrList.size()>0){
			long count = options.getCount();
			total = Long.valueOf(count).intValue();
			Amr [] qaWorks=new Amr[amrList.size()];
			for(int i=0;i<amrList.size();i++){
				Amr amr = new Amr();
				String enPk = (String)amrList.get(i).get("EN_PK");
				amrMap = amrList.get(i);
				BeanCopyUtil.mapToModel(amr, amrMap, dictionaryService);
				int size = 0;
				//系统参数配置是否启用补充自动质控,默认不启用
				boolean qaAutoEnable=false;
				Param[] params=paramsService.getParam(SysFunctionCode.QA_AUTO_CONFIG).getDataList();
				if(params.length>0){
					Param param=params[0];
					if("1".equals(param.getValue())){
						qaAutoEnable=true;
					}
				}
				if(qaAutoEnable){
					/*从接口中获取缺陷数*/
					result = qaItemService.qaAutoTest(enPk,qaAutoTypeCode);
					QaDivideModel[]  qaFaultList=result.getDataList();
					size=qaFaultList.length;
					amr.setFaultTotal(new BigDecimal(size));
				}
				
				/*从视图中获取主诊断*/
				ArrayResult<DiagnosisModel> diList = diService.search(enPk, "1", null, null, null);
				if(diList != null && diList.getDataList() != null){
				    DiagnosisModel[] diArr = diList.getDataList();
				    if(diArr != null && diArr.length>0){
				    	amr.setCurrentMainDiagnosisCode(diArr[0].getDiPk());
				    	amr.setCurrentMainDiagnosisName(diArr[0].getDiNm());
				    }
				}
				qaWorks[i] = amr;
			}
			if(qaWorks!=null){
				builder.withData(qaWorks);
			}
		}
		ArrayResult<Amr> amrResult = builder.build();
		amrResult.setTotal(total);
		return amrResult;
	}
	
	
	@Override
	public ArrayResult<CusQaAutoFltModel> searchQaAutoList(Map map)
			throws Throwable {
		/*查询条件*/
		String curDeptNm = QaUtil.getStringValueFromMap(map, "curDeptNm"); //科室
		String currentManageDoctorName = QaUtil.getStringValueFromMap(map, "currentManageDoctorName"); //医师
		String enStaCd = getStringValueFromMap(map, "enStaCd");//在院，出院未完成
		//---处理已出院---
		if(!StringUtils.isEmpty(enStaCd)){
			if("1".equals(enStaCd)){
				enStaCd = EncounterStatus.receipted;
			}else if("2".equals(enStaCd)){
				enStaCd = EncounterStatus.completed;
			}
		}
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
		String statusStr =  QaUtil.getStringValueFromMap(map, "amrState"); //病案状态
		String qaTypeCode = QaFltStatus.QA_TY_CD_AUTO_DEPT;//自动科室质控
		
		ArrayResultBuilder<CusQaAutoFltModel> builder = ArrayResultBuilder.newArrayResult(CusQaAutoFltModel.class);
		List<Map<String, Object>> qaList = null; //医生列表
		//质控信息
		Map<String, Object> amrMap = null;

		SelectOptions options = SelectOptions.get().offset((Integer.valueOf(pageNum)-1)*Integer.valueOf(pageSize)).limit(Integer.valueOf(pageSize)).count();			
		qaList = cusQaMrAmrDao.selectQaAutoByCondition(curDeptNm, currentManageDoctorName,enStaCd,options);
		int total = 0;
		if(qaList!=null&&qaList.size()>0){
			long count = options.getCount();
			total = Long.valueOf(count).intValue();
			CusQaAutoFltModel [] qaWorks=new CusQaAutoFltModel[qaList.size()];
			for(int i=0;i<qaList.size();i++){
				CusQaAutoFltModel cusQaAutoFltModel = new CusQaAutoFltModel();
				amrMap = qaList.get(i);
				BeanCopyUtil.mapToModel(cusQaAutoFltModel, amrMap, dictionaryService);
//				cusQaAutoFltModel.setPk((String)qaList.get(i).get("EN_PK"));
				qaWorks[i] = cusQaAutoFltModel;
			}
			if(qaWorks!=null){
				builder.withData(qaWorks);
			}
		}
		ArrayResult<CusQaAutoFltModel> amrResult = builder.build();
		amrResult.setTotal(total);
		return amrResult;
	}
}
