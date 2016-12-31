package pkuhit.iih.en;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import xap.sv.model.ArrayResult;
import xap.sv.servlet.mvc.annotation.RequestParam;

public interface TreatmentGroupService {
	/**
	 * 根据就诊PK和用户ID获得用户在诊疗组中的信息 
	 * @param enPk 就诊序号
	 * @param empId 人员ID
	 * @return TreatmentGroupMember
	 * http://localhost:8081/en/treatmentGroup?xmode=debug&
	 */
	@RequestMapping(value = "/en/treatgroup/members", method = RequestMethod.GET)
	ArrayResult<TreatmentGroupMemberModel> getTreatmentGroupMember(@RequestParam("enPk") String enPk,@RequestParam("empId")  String empId) ;
	
}
