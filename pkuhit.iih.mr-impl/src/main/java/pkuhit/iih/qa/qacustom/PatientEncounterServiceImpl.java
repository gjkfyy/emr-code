package pkuhit.iih.qa.qacustom;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import pkuhit.iih.en.md.EncounterStatus;
import pkuhit.iih.en.md.IllStatus;
import pkuhit.iih.mr.md.AmrStatus;
import pkuhit.iih.mr.wr.Amr;
import pkuhit.iih.qa.md.QaFltStatus;
import pkuhit.xap.ac.Session;
import xap.sv.annotation.Reference;
import xap.sv.model.ArrayResult;
/**
 * 
 * @author yao_lijie
 *
 */
public class PatientEncounterServiceImpl implements PatientEncounterService {
	
	@Reference
	QaMrAmrService qaMrAmrService;

	@Reference
	pkuhit.iih.qa.QaRecordService qaRecordServiceMr;

	public PatientEncounterServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public ArrayResult<Amr> searchProcessList(Map map)
			throws Throwable {
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
		String workScreen =  getStringValueFromMap(map, "workScreen"); //工作场景
		
		String statusStr = AmrStatus.WRITE_STARTED;//书写已开始（环节质控）
		amrStatus += statusStr+",";
		amrStatus = amrStatus.substring(0, amrStatus.length()-1);
		String qaTypeCode = QaFltStatus.QA_TY_CD_PROCESS;//环节质控
		Map mapCondition = new HashMap();
		mapCondition.put("statusStr", statusStr);
		mapCondition.put("qaTypeCode", qaTypeCode);
		mapCondition.put("amrStatus", amrStatus);
		mapCondition.put("curDeptNm", curDeptNm);
		mapCondition.put("amrNo", amrNo);
		mapCondition.put("patientName", patientName);
		mapCondition.put("staIll", staIll);
		mapCondition.put("rcvTime", rcvTime.toString());
		mapCondition.put("enStaCd", enStaCd);
		mapCondition.put("suF", suF.toString());
		mapCondition.put("qaFlag", qaFlag.toString());
		mapCondition.put("workScreen", workScreen);
		mapCondition.put("pageNum", pageNum);
		mapCondition.put("pageSize", pageSize);
		return this.getCusQaPatientResultByCondition(mapCondition);
	}

	private ArrayResult<Amr> getCusQaPatientResultByCondition(Map map) throws Throwable{
		ArrayResult<Amr> amrArrayResult = qaMrAmrService.search(map);
		return amrArrayResult;
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
