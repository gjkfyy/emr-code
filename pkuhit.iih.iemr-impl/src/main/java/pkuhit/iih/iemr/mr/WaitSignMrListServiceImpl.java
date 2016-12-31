
package pkuhit.iih.iemr.mr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;

import pkuhit.iih.en.EncounterModel;
import pkuhit.iih.en.EncounterService;
import pkuhit.iih.en.TreatmentGroupMemberModel;
import pkuhit.iih.en.TreatmentGroupService;
import pkuhit.iih.en.md.EncounterStatus;
import pkuhit.iih.mr.wr.MedicalRecord;
import pkuhit.iih.mr.wr.SignMr;
import pkuhit.md.DictionaryService;
import pkuhit.md.OwnerType;
import pkuhit.org.WorkGroupEmp;
import pkuhit.org.WorkGroupEmpService;
import pkuhit.xap.ac.Session;
import xap.sv.annotation.Reference;
import xap.sv.model.ArrayResult;
import xap.sv.model.ArrayResultBuilder;


public class WaitSignMrListServiceImpl implements WaitSignMrListService {

	private Logger log = LoggerFactory.getLogger(WaitSignMrListServiceImpl.class);
	@Reference
	pkuhit.iih.mr.wr.MedicalRecordService medicalRecordService;
	@Reference
	WorkGroupEmpService workGroupEmpService;
//	@Reference
//	EncounterService encounterService;
//	@Reference
//	TreatmentGroupService treatmentGroupService;

	/*
	 * (non-Javadoc)
	 * @see pkuhit.iih.iemr.mr.WaitSignMrListService#searchWaitSignMrList(java.util.Map)
	 */
	@Override
	public ArrayResult<SignMr> searchWaitSignMrList(Map<String, String> param)
		throws Throwable {

		Session session = Session.get();
		String userId = session.getUserId();
		String personalOrWorkGroup = param.get("personalOrWorkGroup");
		Map<String, String> condition = new HashMap<String, String>();
		if (OwnerType.PERSONAL.equals(personalOrWorkGroup)) {
			condition.put("userId", userId);
			log.debug("userId:"+userId);
		}
		else if (OwnerType.DEPARTMENT.equals(personalOrWorkGroup)) {
			Map<String, String> params = new HashMap<String, String>();
			params.put("userId", userId);
			WorkGroupEmp[] workGroupEmps = workGroupEmpService.search(params).getDataList();
			String currentGroupCodes =null;
			for (WorkGroupEmp workGroupEmp : workGroupEmps) {
				if(null==currentGroupCodes){
					currentGroupCodes=workGroupEmp.getWorkGroupCode();
				}else{
					currentGroupCodes=currentGroupCodes+","+workGroupEmp.getWorkGroupCode();
				}
			}
			condition.put("currentGroupCodes", currentGroupCodes);
		}
		return medicalRecordService.getWaitSignedMrs(condition);
	}

	/**
	 * 根据就诊序号encounterModels查询待审签医疗记录
	 * 
	 * @param encounterModels
	 * @return
	 * @throws Throwable
	 *//*
	public List<SignMr> getSignMrList(EncounterModel[] encounterModels)
		throws Throwable {

		List<SignMr> waitSignMrs = new ArrayList<SignMr>();
		for (EncounterModel en : encounterModels) {
			Map<String, String> map = new HashMap<String, String>();
			map.put("encounterPk", en.getEnPk());
			MedicalRecord[] medicalRecords = medicalRecordService.search(map).getDataList();
			for (int i=0;null!=medicalRecords&&i< medicalRecords.length;i++) {
				MedicalRecord medicalRecord=medicalRecords[i];
				if (medicalRecord.getCanSign() == 1) {
					SignMr waitSignMr = new SignMr();
					BeanUtils.copyProperties(medicalRecord, waitSignMr);
					EncounterModel encounter = encounterService.getEncounterDetail(en.getEnPk()).getData();
					waitSignMr.setBedNo(encounter.getCurBedCd());
					waitSignMr.setPatientName(encounter.getPaNm());
					waitSignMr.setSexCode(encounter.getSexCd());
					waitSignMr.setSexName(encounter.getSexNm());
					waitSignMrs.add(waitSignMr);
				}
			}
		}
		return waitSignMrs;
	}*/
}
