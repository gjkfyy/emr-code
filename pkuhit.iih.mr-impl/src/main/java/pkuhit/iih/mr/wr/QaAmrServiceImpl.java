
package pkuhit.iih.mr.wr;

import java.math.BigDecimal;
import java.sql.Array;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.seasar.doma.jdbc.SelectOptions;
import org.springframework.beans.factory.annotation.Autowired;

import pkuhit.iih.ass.di.AssDiagnosisService;
import pkuhit.iih.di.DiagnosisModel;
import pkuhit.iih.mr.dao.auto.MrAmrDao;
import pkuhit.iih.mr.dao.auto.MrDao;
import pkuhit.iih.mr.dao.auto.entity.Mr;
import pkuhit.iih.mr.dao.auto.entity.MrAmr;
import pkuhit.iih.mr.md.AmrStatus;
import pkuhit.iih.mr.wr.dao.CusQaAmrDao;
import pkuhit.iih.pub.CardUtil;
import pkuhit.iih.qa.QaRecordService;
import pkuhit.iih.qa.old.QaRecord;
import pkuhit.md.DictionaryService;
import pkuhit.md.SysFunctionCode;
import pkuhit.xap.pm.Param;
import pkuhit.xap.pm.ParamsService;
import pkuhit.xap.util.BeanCopyUtil;
import xap.sv.annotation.Reference;
import xap.sv.model.ArrayResult;
import xap.sv.model.ArrayResultBuilder;
import xap.sv.model.SingleResult;
import xap.sv.model.SingleResultBuilder;
import ei.his.service.HisMrAmrOutService;
/**
 * 
 * @author cheng_feng
 *
 */
public class QaAmrServiceImpl implements QaAmrService {

	@Autowired
	CusQaAmrDao cusQaAmrDao;

	@Reference
	DictionaryService dictionaryService;
	
	@Reference
	AmrService amrService; 
	
	@Autowired
	MrAmrDao mrAmrDao;
	
	@Autowired
	MrDao mrDao;
	
	@Reference
	QaRecordService qaRecordService ;
	
	@Reference
	MedicalRecordService mRService;
	
	@Autowired
	AssDiagnosisService diService;
	
	/*@Reference
	HisMrAmrOutService hisMrAmrOutService;*/
	
	@Reference
	ParamsService paramsService;
	
/*	@Reference
	CisEnViewService cisEnViewService;*/
	
	public QaAmrServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public ArrayResult<Amr> getAmrByStatusInProcess(String statusStr) throws Throwable {
		ArrayResultBuilder<Amr> builder = ArrayResultBuilder.newArrayResult(Amr.class);
		List<MrAmr> mrAmrList = cusQaAmrDao.selectAmrByStatusInProcess(statusStr);
		int total = 0;
		if(mrAmrList!=null&&mrAmrList.size()>0){
			total = mrAmrList.size();
			Amr [] amrs=new Amr[mrAmrList.size()];
			for(int i=0;i<mrAmrList.size();i++){
				MrAmr mrAmr = mrAmrList.get(i);
				Amr amr = new Amr();
				BeanCopyUtil.entityToModel(amr, mrAmr, Amr.OBJ_CD, dictionaryService);
				amrs[i] = amr;
			}
			builder.withData(amrs);
		}
		ArrayResult<Amr> amrResult = builder.build();
		amrResult.setTotal(total);
		return amrResult;
	}
	
	@Override
	public ArrayResult<Amr> getAmrByStatusInQa(Map map) throws Throwable {
		String statusStr = getStringValueFromMap(map, "statusStr");
		String qaTypeCode = getStringValueFromMap(map, "qaTypeCode");
		String amrStatus = getStringValueFromMap(map, "amrStatus"); 
		List<String> amrStatusList = new ArrayList<String>();
		if(!StringUtils.isEmpty(amrStatus)){
			if(!"null".equals(amrStatus)){
				String[] amrStatusArr = amrStatus.split(",");
				amrStatusList = Arrays.asList(amrStatusArr);
			}
		}
		String curDeptNm = getStringValueFromMap(map, "curDeptNm"); 
		String curMainDiNm = getStringValueFromMap(map, "curMainDiNm"); 
		String staIll = getStringValueFromMap(map, "staIll");  
		String rcvTime = getStringValueFromMap(map, "rcvTime");
		String enStaCd = getStringValueFromMap(map, "enStaCd");
		String suF = getStringValueFromMap(map, "suF");
		String qaFlag = getStringValueFromMap(map, "qaFlag");
		String excuteUserId = getStringValueFromMap(map, "excuteUserId");
		String executeDeptCode = getStringValueFromMap(map, "executeDeptCode");
		String workScreen = getStringValueFromMap(map, "workScreen");
		String pageNum = getStringValueFromMap(map, "pageNum");
		String pageSize = getStringValueFromMap(map, "pageSize");
		ArrayResultBuilder<Amr> builder = ArrayResultBuilder.newArrayResult(Amr.class);
		List<Map<String, Object>> mrAmrList = null;
		Map<String, Object> amrMap = null;
		if(StringUtils.isBlank(pageNum)){
			pageNum = "1" ;
		}
		if(StringUtils.isBlank(pageSize)){
			pageSize = "25" ;
		}
		SelectOptions options = SelectOptions.get().offset((Integer.valueOf(pageNum)-1)*Integer.valueOf(pageSize)).limit(Integer.valueOf(pageSize)).count();			
		mrAmrList = cusQaAmrDao.selectAmrByStatusInQa(qaTypeCode, amrStatusList, curDeptNm, curMainDiNm, staIll, rcvTime, enStaCd, suF, qaFlag, excuteUserId, executeDeptCode, workScreen, options);
		int total = 0;
		if(mrAmrList!=null&&mrAmrList.size()>0){
			long count = options.getCount();
			total = Long.valueOf(count).intValue();
			Amr [] amrs=new Amr[mrAmrList.size()];
			for(int i=0;i<mrAmrList.size();i++){
				Amr amr = new Amr();
				amrMap = mrAmrList.get(i);
				BeanCopyUtil.mapToModel(amr, amrMap);
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
	public SingleResult<Amr> qaCompleted(String enPk, BigDecimal score, String rank)
			throws Throwable {
		SingleResult<Amr> amrResult = amrService.get(enPk);
		Amr amr = amrResult.getData();
		amr.setStatusCode(AmrStatus.QA_COMPLETED);	// 已完成质控
		amr.setRankCode(rank);
		amr.setScore(score);
		amrResult = amrService.update(enPk, amr);
		return amrResult;
	}

	@Override
	public SingleResult<Amr> revokeQaCompleted(String enPk) throws Throwable {
		MrAmr mrAmr = mrAmrDao.selectById(enPk);
		mrAmr.setAmrStaCd(AmrStatus.QA_STARTED);	// 已开始质控
		mrAmr.setAmrRankCd(null);
		mrAmr.setQaScr(null);
		mrAmrDao.update(mrAmr);
		SingleResult<Amr> amrResult = amrService.get(enPk);
		return amrResult;
	}
	

	@Override
	public ArrayResult<Amr> search(Map<String, String> map) throws Throwable{
		String statusStr = getStringValueFromMap(map, "statusStr");
		String qaTypeCode = getStringValueFromMap(map, "qaTypeCode");
		String amrStatus = getStringValueFromMap(map, "amrStatus"); 
		List<String> amrStatusList = new ArrayList<String>();
		if(!StringUtils.isEmpty(amrStatus)){
			if(!"null".equals(amrStatus)){
				String[] amrStatusArr = amrStatus.split(",");
				amrStatusList = Arrays.asList(amrStatusArr);
			}
		}
		String curDeptNm = getStringValueFromMap(map, "curDeptNm"); 
		String curMainDiNm = getStringValueFromMap(map, "curMainDiNm"); 
		String staIll = getStringValueFromMap(map, "staIll");  
		String rcvTime = getStringValueFromMap(map, "rcvTime");
		String enStaCd = getStringValueFromMap(map, "enStaCd");
		String suF = getStringValueFromMap(map, "suF");
		String qaFlag = getStringValueFromMap(map, "qaFlag");
		String excuteUserId = getStringValueFromMap(map, "excuteUserId");
		String executeDeptCode = getStringValueFromMap(map, "executeDeptCode");
		String workScreen = getStringValueFromMap(map, "workScreen");
		String pageNum = getStringValueFromMap(map, "pageNum");
		String pageSize = getStringValueFromMap(map, "pageSize");
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
		mrAmrList = cusQaAmrDao.selectAmrByCondition(qaTypeCode, amrStatusList, curDeptNm, curMainDiNm, staIll, rcvTime, enStaCd, suF, qaFlag, excuteUserId, executeDeptCode, workScreen, options);
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
				mrAmr = cusQaAmrDao.selectAmrFaultStatistical(enPk, qaTypeCode);
				if(mrAmr!=null){
					BeanCopyUtil.mapToModel(amr, mrAmr, dictionaryService);
				}
				SingleResult<QaRecord> qaResult = qaRecordService.searchLastCompleted(enPk, qaTypeCode);
				if(qaResult.getData()!=null){
					amr.setExcuteUserName(qaResult.getData().getExcuteUserName());
					amr.setExecuteDeptName(qaResult.getData().getExecuteDeptName());
					amr.setExecuteEndTime(qaResult.getData().getExecuteEndTime());
				}
				amr.setPk((String)mrAmrList.get(i).get("EN_PK"));
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

	@Override
	public ArrayResult<Amr> searchEncounterList(Map<String, String> map)
			throws Throwable {
		ArrayResultBuilder<Amr> builder = ArrayResultBuilder.newArrayResult(Amr.class);
		ArrayResult<Amr> amrArrayResult = new ArrayResult<Amr>();
		List<Map<String, Object>> mrAmrList = null; //患者列表
		String patientId = getStringValueFromMap(map, "patientId").trim();
		String keyword = getStringValueFromMap(map, "keyword").toUpperCase();
		String deptCd = getStringValueFromMap(map, "deptCd");
		String wardCd = getStringValueFromMap(map, "wardCd");
		String userId = getStringValueFromMap(map, "userId");
		String enTpCd = getStringValueFromMap(map, "enTpCd");
		String groupType = getStringValueFromMap(map, "groupType");
		String workScreen = getStringValueFromMap(map, "workScreen");
		String portalCd = getStringValueFromMap(map, "portalCd");
		String ifShowOutpatient = getStringValueFromMap(map, "ifShowOutpatient");
		String pageNum = getStringValueFromMap(map, "pageNum");
		String pageSize = getStringValueFromMap(map, "pageSize");
		if(StringUtils.isBlank(pageNum)){
			pageNum = "1" ;
		}
		if(StringUtils.isBlank(pageSize)){
			pageSize = "25" ;
		}
		DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd 00:00:00");
		DateFormat edf = new SimpleDateFormat("yyyy-MM-dd 23:59:59");
		Calendar calendar = Calendar.getInstance();
		String startDate = getStringValueFromMap(map, "startDate");
		if(!StringUtils.isBlank(startDate)){
		    calendar.setTimeInMillis(Long.parseLong(startDate));
		    Date sDate = calendar.getTime();
            startDate = sdf.format(sDate);
        }
		String endDate = getStringValueFromMap(map, "endDate");
		if(!StringUtils.isBlank(endDate)){
            calendar.setTimeInMillis(Long.parseLong(endDate));
            Date eDate = calendar.getTime();
            endDate = edf.format(eDate);
        }
		String enDate = getStringValueFromMap(map, "enDate");
        if(!StringUtils.isBlank(enDate)){
            calendar.setTimeInMillis(Long.parseLong(enDate));
            Date rcvDate = calendar.getTime();
            startDate = sdf.format(rcvDate);
            endDate = edf.format(rcvDate);
        }
		String amrNo = getStringValueFromMap(map, "amrNo");
		String patientName = getStringValueFromMap(map, "patientName");
		String currentBedCode = getStringValueFromMap(map, "currentBedCode");
		String curMgDctId = getStringValueFromMap(map, "curMgDctId");
		String curMgNurId = getStringValueFromMap(map, "curMgNurId");
		SelectOptions options = SelectOptions.get().offset((Integer.valueOf(pageNum)-1)*Integer.valueOf(pageSize)).limit(Integer.valueOf(pageSize)).count();			
		String inPaViewParam=getInPatientViewParam();
		if(!StringUtils.isEmpty(workScreen)){
			if("1".equals(workScreen)){
			    if("3".equals(groupType))//转科
			        mrAmrList = cusQaAmrDao.selectEncounterForAdtPatient(deptCd, wardCd, patientName, amrNo, currentBedCode, options);
			    else{
			    	//住院  (本人患者、全科患者)读取患者信息时，添加开关 值=1则从视图读取，否则按照原来从本地mr_amr表读取 wangyanli 20160804
			    	
			    	if(("1".equals(groupType) || "2".equals(groupType) ) && inPaViewParam != null && inPaViewParam.equals("1")){
			    		
			    		mrAmrList = cusQaAmrDao.selectEncounterFromViewByCondition(keyword, deptCd, userId, enTpCd, groupType, patientName, amrNo, currentBedCode, startDate, endDate, curMgDctId, options);
			    	}else{
			    		if("XAPM06.07".equals(portalCd)){//匿名浏览病历，只查看写过病历的
			    			if(ifShowOutpatient.equals("true") && amrNo != ""){
			    				List<String> enpkList = new ArrayList<String>();
			    				//enpkList = hisMrAmrOutService.getPatientOut(amrNo);//通过住院号查找门诊患者
			    				
			    				mrAmrList = cusQaAmrDao.selectOutReadEncounterByCondition(keyword, deptCd, userId, enTpCd, groupType, patientName, enpkList,patientId, currentBedCode, startDate, endDate, curMgDctId, options);
			    			}else{
			    				mrAmrList = cusQaAmrDao.selectReadEncounterByCondition(keyword, deptCd, userId, enTpCd, groupType, patientName, amrNo,patientId, currentBedCode, startDate, endDate, curMgDctId, options);
			    			}
			    		}else{
				    		mrAmrList = cusQaAmrDao.selectEncounterByCondition(keyword, deptCd, userId, enTpCd, groupType, patientName, amrNo, currentBedCode, startDate, endDate, curMgDctId, options);
			    		}
			    	}
			    }
			}else if("2".equals(workScreen)){
				mrAmrList = cusQaAmrDao.selectEncounterToAssistant(patientId,null);
			}else if("3".equals(workScreen)){
                mrAmrList = cusQaAmrDao.selectEncounterForOutPatient(deptCd, userId, groupType, patientId, patientName, startDate, endDate, options);
			}else if("4".equals(workScreen)){
			    if("3".equals(groupType))//转科
                    mrAmrList = cusQaAmrDao.selectEncounterForAdtPatient(deptCd, wardCd, patientName, amrNo, currentBedCode, options);
                else{
                	//护理管理住院患者  (本人患者、全科患者)读取患者信息时，住院护理用同一个开关   值=1则从视图读取，否则按照原来从本地mr_amr表读取 wangyanli 20160906
			    	if(("1".equals(groupType) || "2".equals(groupType) ) && inPaViewParam != null && inPaViewParam.equals("1")){
			    		
			    		mrAmrList = cusQaAmrDao.selectEncounterForNursePatientFromView(groupType, wardCd, userId, patientName, amrNo, currentBedCode, curMgNurId, startDate, endDate, options);
			    	}else{
			    		mrAmrList = cusQaAmrDao.selectEncounterForNursePatient(groupType, wardCd, userId, patientName, amrNo, currentBedCode, curMgNurId, startDate, endDate, options);
			    	}

                }
			}    
		}
		int total = 0;
		if(mrAmrList!=null&&mrAmrList.size()>0){
			long count = options.getCount();
			total = Long.valueOf(count).intValue();
			Amr [] amrs=new Amr[mrAmrList.size()];
			Map<String, Object> amrMap = null;
			for(int i=0;i<mrAmrList.size();i++){
				Amr amr = new Amr();
				amrMap = mrAmrList.get(i);
				BeanCopyUtil.mapToModel(amr, amrMap, dictionaryService);
				if(("1".equals(groupType) || "2".equals(groupType) ) && inPaViewParam != null && inPaViewParam.equals("1")){
					
				}else{
					ArrayResult<DiagnosisModel> diList = diService.search(amr.getPk(), null, null, null, null);
					if(diList != null && diList.getDataList() != null){
					    DiagnosisModel[] diArr = diList.getDataList();
					    if(diArr != null && diArr.length>0){
					        amr.setCurrentMainDiagnosisCode(diArr[0].getDiPk());
					        amr.setCurrentMainDiagnosisName(diArr[0].getDiNm());
					    }
					}
				}
				
				amrs[i] = amr;
			}
			builder.withData(amrs);
		}
		amrArrayResult = builder.build();
		amrArrayResult.setTotal(total);
		return amrArrayResult;
	}
	
	@Override
    public SingleResult<Amr> getEncounterById(String id) throws Throwable {
	    SingleResult<Amr> result;
        SingleResultBuilder<Amr> builder = SingleResultBuilder.newSingleResult(Amr.class);
        Map<String, Object> map  = cusQaAmrDao.selectEncounterById(id);
        if (null != map) {
            Amr amr = new Amr();
            BeanCopyUtil.mapToModel(amr, map, dictionaryService);
            ArrayResult<DiagnosisModel> diList = diService.search(amr.getPk(), null, null, null, null);
            if(diList != null && diList.getDataList() != null){
                DiagnosisModel[] diArr = diList.getDataList();
                if(diArr != null && diArr.length>0){
                    amr.setCurrentMainDiagnosisCode(diArr[0].getDiPk());
                    amr.setCurrentMainDiagnosisName(diArr[0].getDiNm());
                }
            }
            builder.withData(amr);
        }
        result = builder.build();
        return result;
    }
	
	@Override
    public SingleResult<Amr> getEncounterByPatientId(String id) throws Throwable {
        SingleResult<Amr> result;
        SingleResultBuilder<Amr> builder = SingleResultBuilder.newSingleResult(Amr.class);
        List<Map<String, Object>> mrAmrList = null; //患者列表
        SelectOptions options = SelectOptions.get().offset((Integer.valueOf("1")-1)*Integer.valueOf("30")).limit(Integer.valueOf("30")).count();
        String paId,cardCd;
        if(CardUtil.isIDCard(id)){
        	paId=null;
        	cardCd=id;
        }else{
        	paId=id;
        	cardCd=null;
        }
        mrAmrList  = cusQaAmrDao.selectEncounterToAssistant(paId,cardCd);
        if(mrAmrList != null && mrAmrList.size() > 0){
            Map<String, Object> map = mrAmrList.get(0);
            if (null != map) {
                Amr amr = new Amr();
                BeanCopyUtil.mapToModel(amr, map, dictionaryService);
                ArrayResult<DiagnosisModel> diList = diService.search(amr.getPk(), null, null, null, null);
                if(diList != null && diList.getDataList() != null){
                    DiagnosisModel[] diArr = diList.getDataList();
                    if(diArr != null && diArr.length>0){
                        amr.setCurrentMainDiagnosisCode(diArr[0].getDiPk());
                        amr.setCurrentMainDiagnosisName(diArr[0].getDiNm());
                    }
                }
                builder.withData(amr);
            }
        }
        result = builder.build();
        return result;
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
	
	   //配置住院（护理）患者列表：读视图or读本地mr_amr表
		private String getInPatientViewParam() {

			String inPaViewParam="";
			Param[] inPatientViewParams = paramsService.getParam(SysFunctionCode.IN_PATIENT_VIEW).getDataList();
			for(int i=0; i<inPatientViewParams.length ; i++){
				Param param=inPatientViewParams[i];
				if(param.getKey().equals("IN_PATIENT_VIEW") && null!=param.getValue()){
					inPaViewParam=param.getValue();
					break;
				}
			}
				
			return inPaViewParam;
		
			
		}
}
