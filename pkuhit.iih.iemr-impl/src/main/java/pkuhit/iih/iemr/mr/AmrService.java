package pkuhit.iih.iemr.mr;

/**
 * 病案相关的服务。
 * @author wu.junhui
 *
 */
public interface AmrService {

	
	/**
	 * 查询病案信息列表
	 */
	///en_patient/{deptCd}/{managerDoctorCd}
	
	
	/**
	 * 根据病案ID或者就诊NO查询单条病案信息
	 */
	///en_patient/{enSn}
	
	
	/**
	 * 查询环节质控中的病案信息列表
	 */
	///qa_patient_in
	
	
	/**
	 * 查询终末质控中的病案信息列表
	 */
	///qa_patient_inTerminal
}
