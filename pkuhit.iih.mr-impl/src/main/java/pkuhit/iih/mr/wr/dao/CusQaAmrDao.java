package pkuhit.iih.mr.wr.dao;

import java.util.List;
import java.util.Map;

import org.seasar.doma.Dao;
import org.seasar.doma.Select;
import org.seasar.doma.jdbc.SelectOptions;

import pkuhit.iih.mr.dao.auto.entity.MrAmr;
import xap.sv.dao.annotation.RepositoryConfig;

/**
 * 
 * <p>CusQaAmrDao</p>
 * <p>质控查询患者列表所需接口</p>
 *
 * @author		chengfeng(cheng_feng@founder.com)
 * @version		0.0.0
 */
@Dao
@RepositoryConfig
public interface CusQaAmrDao {
	/**
	 * 环节质控
	 * @return
	 */
	@Select
    List<MrAmr> selectAmrByStatusInProcess(String statusStr);
	
	
	/**
	 * 质控患者查询列表
	 * @param statusStr
	 * @param qaTypeCode
	 * @param amrStatusList
	 * @param curDeptNm
	 * @param curMainDiNm
	 * @param staIll
	 * @param rcvTime
	 * @param enStaCd
	 * @param suF
	 * @param qaFlag
	 * @param excuteUserId
	 * @param executeDeptCode
	 * @param workScreen
	 * @param SelectOptions options
	 * @return
	 */
	@Select
	List<Map<String, Object>> selectAmrByStatusInQa(String qaTypeCode, List<String> amrStatusList, String curDeptNm, String curMainDiNm, String staIll, 
    		String rcvTime, String enStaCd, String suF, String qaFlag, String excuteUserId, String executeDeptCode, String workScreen, SelectOptions options);
	
	
	/**
	 * 根据条件查询患者
	 * @param 
	 * @param SelectOptions options
	 * @return
	 */
	@Select
	List<Map<String, Object>> selectAmrByCondition(String qaTypeCode, List<String> amrStatusList, String curDeptNm, String curMainDiNm, String staIll, 
    		String rcvTime, String enStaCd, String suF, String qaFlag, String excuteUserId, String executeDeptCode, String workScreen, SelectOptions options);
	
	/**
	 * 根据条件统计患者本次就诊或本次质控工作记录缺陷数
	 * @param enPk 就诊编码
	 * @param qaTypeCode 质控类型
	 * @return
	 */
	@Select
	Map<String, Object> selectAmrFaultStatistical(String enPk, String qaTypeCode);
	
	/**
	 * 菜单栏查询患者
	 * @return
	 */
	@Select
	List<Map<String, Object>> selectEncounterByCondition(String keyword, String deptCd, String userId, String enTpCd, String groupType, String patientName, String amrNo, String currentBedCode, String startDate, String endDate, String curMgDctId, SelectOptions options);
	
	/**
	 * 菜单栏查询患者
	 * @return
	 */
	@Select
	List<Map<String, Object>> selectReadEncounterByCondition(String keyword, String deptCd, String userId, String enTpCd, String groupType, String patientName, String amrNo, String patientId,String currentBedCode, String startDate, String endDate, String curMgDctId, SelectOptions options);
	
	/**
	 * 浏览病历平台（六院）
	 * @return
	 */
	@Select
	List<Map<String, Object>> selectOutReadEncounterByCondition(String keyword, String deptCd, String userId, String enTpCd, String groupType, String patientName, List<String> enpkList, String patientId,String currentBedCode, String startDate, String endDate, String curMgDctId, SelectOptions options);
	
	/**
	 * 智能助手查询患者
	 * @return
	 */
	@Select
	List<Map<String, Object>> selectEncounterToAssistant(String patientId,String cardCd);
	
	/**
     * 查询门诊患者
     * @return
     */
    @Select
    List<Map<String, Object>> selectEncounterForOutPatient(String deptCd, String userId, String groupType, String patientId, String patientName, String startDate, String endDate, SelectOptions options);
    
    /**
     * 查询患者(护理)
     * @return
     */
    @Select
    List<Map<String, Object>> selectEncounterForNursePatient(String groupType, String wardCd, String userId, String patientName, String amrNo, String currentBedCode, String curMgNurId, String startDate, String endDate, SelectOptions options);
    
    /**
     * 查询转科患者
     * @return
     */
    @Select
    List<Map<String, Object>> selectEncounterForAdtPatient(String deptCd, String wardCd, String patientName, String amrNo, String currentBedCode, SelectOptions options);
    
    /**
     * 查询患者（单记录） 
     * @param pk 就诊编码
     * @return
     */
    @Select
    Map<String, Object> selectEncounterById(String enPk);
    
    /**
     * 通过cis视图，查询患者 （住院的个人、科室病人适用）
     * @param pk 就诊编码
     * @return
     */ 
	@Select
	List<Map<String, Object>> selectEncounterFromViewByCondition(String keyword, String deptCd, String userId, String enTpCd, String groupType, String patientName, String amrNo, String currentBedCode, String startDate, String endDate, String curMgDctId, SelectOptions options);

	/**
	 * 通过cis视图，查询患者 （护理管理的个人、科室病人适用）
	 * @param pk 就诊编码
	 * @return
	 */ 
	 @Select
	 List<Map<String, Object>> selectEncounterForNursePatientFromView(String groupType, String wardCd, String userId, String patientName, String amrNo, String currentBedCode, String curMgNurId, String startDate, String endDate, SelectOptions options);

    
}