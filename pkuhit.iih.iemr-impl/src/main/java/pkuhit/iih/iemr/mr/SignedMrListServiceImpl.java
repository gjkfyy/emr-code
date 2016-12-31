
package pkuhit.iih.iemr.mr;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pkuhit.iih.mr.wr.AmrService;
import pkuhit.iih.mr.wr.SignMr;
import pkuhit.md.DictionaryService;
import pkuhit.md.OwnerType;
import pkuhit.org.WorkGroupEmp;
import pkuhit.org.WorkGroupEmpService;
import pkuhit.xap.ac.Session;
import xap.sv.annotation.Reference;
import xap.sv.model.ArrayResult;

public class SignedMrListServiceImpl implements SignedMrListService {

	private Logger log = LoggerFactory.getLogger(SignedMrListServiceImpl.class);

	@Reference
	pkuhit.iih.mr.wr.MedicalRecordService mrMedicalRecordService;

	@Reference
	WorkGroupEmpService workGroupEmpService;

	@Reference
	AmrService amrService;

	/*
	 * (non-Javadoc)
	 * @see
	 * pkuhit.iih.iemr.mr.SignedMrListService#searchSignedMrList(java.util.Map)
	 */
	@Override
	public ArrayResult<SignMr> searchSignedMrList(Map<String, String> param)
		throws Throwable {
		Session session = Session.get();
		String userId = session.getUserId();
		String personalOrWorkGroup = param.get("personalOrWorkGroup");
		Map<String, String> condition = new HashMap<String, String>();
		if (OwnerType.PERSONAL.equals(personalOrWorkGroup)) {
			condition.put("userId", userId);
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
		return mrMedicalRecordService.getSignedMrs(condition);
	}
}
