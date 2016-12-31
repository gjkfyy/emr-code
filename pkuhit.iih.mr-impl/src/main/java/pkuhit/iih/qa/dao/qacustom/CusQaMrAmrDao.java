package pkuhit.iih.qa.dao.qacustom;

import java.util.List;
import java.util.Map;

import org.seasar.doma.Dao;
import org.seasar.doma.Select;
import org.seasar.doma.jdbc.SelectOptions;

import pkuhit.iih.qa.dao.auto.entity.Qa;
import pkuhit.iih.qa.dao.auto.entity.QaFlt;
import xap.sv.dao.annotation.RepositoryConfig;

/**
 * 
 * <p>CusQaAmrDao</p>
 * <p>质控查询患者列表所需接口</p>
 *
 * @author		yao_lijie 
 * @version		0.0.0
 */
@Dao
@RepositoryConfig
public interface CusQaMrAmrDao {
	
	/**
	 * 根据条件查询环节质控患者
	 * @param 
	 * @param SelectOptions options
	 * @return
	 */
	@Select
	List<Map<String, Object>> selectAmrByCondition(String qaTypeCode, String statusStr, String curDeptNm,
			String amrNo ,String patientName , String staIll,String rcvTime, String enStaCd, String suF, String qaFlag, SelectOptions options);
	
	/**
	 * 根据质控工作记录查询质控次数
	 * @param 
	 * @param SelectOptions options
	 * @return
	 */
	@Select
	int selectQaCount(String enPk,String qaTypeCode);
	
	/**
	 * 根据控工作记录查询质控医师
	 * @param 
	 * @param SelectOptions options
	 * @return
	 */
	@Select
	Map<String, Object> selectQa(String enPk,String qaTypeCode);
	
	/**
	 * 根据条件统计患者本次就诊或本次质控工作记录缺陷数
	 * @param enPk 就诊编码
	 * @param qaTypeCode 质控类型
	 * @return
	 */ 
	@Select
	Map<String, Object> selectAmrFaultStatistical(String enPk, String qaTypeCode);
	
	/**
	 * 根据条件统计患者本次就诊通知数
	 * @param enPk 就诊编码
	 * @param qaTypeCode 质控类型
	 * @return
	 */ 
	@Select
	int selectQaNoticeNum(String enPk, String qaTypeCode);

	/**
	 * 查询缺陷数及通知单状态数
	 * @param enPk 就诊编码
	 * @param qaTypeCode 质控类型
	 * @return
	 */ 
	@Select
	Map<String, Object> selectAmrFaultNoticeNum(String enPk, String qaTypeCode);
	
	/**
	 * 根据就诊序号查询环节质控患者
	 * @param 
	 * @return
	 */
	@Select
	List<Map<String, Object>> selectAmrByEnPkAndQaType(String enPk);
	
	
	/**
	 * 根据条件查询终末质控患者
	 * @param 
	 * @param SelectOptions options
	 * @return 
	 */
	@Select  
	List<Map<String, Object>> selectTerminalAmrByCondition(String qaTypeCode, String amrStatus, String curDeptNm,String amrNo ,String patientName ,String beginTime,String endTime,String enStaCd,String qaAutoScrMin,String qaAutoScrMax,String terminalQaStaCd,String deptQaStaCd, SelectOptions options);
	
	/**
	 * 转科 |转入、转出重症监护室 
	 */
	@Select
	List<Map<String, Object>> selectTerminalAmrZyAdtByCondition(String qaTypeCode, String amrStatus, String curDeptNm,String amrNo ,String patientName ,String beginTime,String endTime,String enStaCd,String specialMr, String qaAutoScrMin,String qaAutoScrMax, SelectOptions options);
	
	/**
	 * 医嘱相关
	 */
	@Select
	List<Map<String, Object>> selectTerminalAmrOrderByCondition(String qaTypeCode, String amrStatus, String curDeptNm,String amrNo ,String patientName ,String beginTime,String endTime,String enStaCd,String specialMr, String qaAutoScrMin,String qaAutoScrMax, SelectOptions options);
	
	/**
	 * 检验危急值
	 */
	@Select
	List<Map<String, Object>> selectTerminalAmrJyByCondition(String qaTypeCode, String amrStatus, String curDeptNm,String amrNo ,String patientName ,String beginTime,String endTime,String enStaCd, String qaAutoScrMin,String qaAutoScrMax, SelectOptions options);
	
	/**
	 * 住院超过30天
	 */
	@Select
	List<Map<String, Object>> selectTerminalAmrZyByCondition(String qaTypeCode, String amrStatus, String curDeptNm,String amrNo ,String patientName ,String beginTime,String endTime,String enStaCd, String qaAutoScrMin,String qaAutoScrMax, SelectOptions options);
	
	/**
	 * 重大，特殊手术患者
	 */
	@Select
	List<Map<String, Object>> selectTerminalAmrOpByCondition(String qaTypeCode, String amrStatus, String curDeptNm,String amrNo ,String patientName ,String beginTime,String endTime,String enStaCd, String qaAutoScrMin,String qaAutoScrMax, SelectOptions options);
	
	/**
	 * 手术前讨论记录  
	 */
	@Select
	List<Map<String, Object>> selectTerminalAmrSqtlByCondition(String qaTypeCode, String amrStatus, String curDeptNm,String amrNo ,String patientName ,String beginTime,String endTime,String enStaCd, String qaAutoScrMin,String qaAutoScrMax, SelectOptions options);
	
	/**
	 * 有创诊疗操作记录
	 */
	@Select
	List<Map<String, Object>> selectTerminalAmrYczlByCondition(String qaTypeCode, String amrStatus, String curDeptNm,String amrNo ,String patientName ,String specialMr,String beginTime,String endTime,String enStaCd, String qaAutoScrMin,String qaAutoScrMax, SelectOptions options);
	
	/**
	 * 查询终末质控缺陷
	 * @param 
	 * @param SelectOptions options
	 * @return
	 */
	@Select
	List<QaFlt> selectQaFaults(String pk,String qaTypeCode);
	
	/**
	 * 根据条件查询质控患者列表及质控缺陷数（是对selectAmrByCondition方法的升级）
	 * wangyanli创建于2015-4-22 
	 * @param 
	 * @param SelectOptions options
	 * @return 
	 */
	@Select
	List<Map<String, Object>> selectAmrAndFaultByCondition(String qaTypeCode, String statusStr, String curDeptNm,
			String amrNo ,String patientName , String staIll,String rcvTime, String enStaCd, String suF, String qaFlag,String beginTime,String endTime, String isNurseRole,SelectOptions options);

	/**
	 * 根据条件查询质控患者列表及质控缺陷数（是对selectAmrByCondition方法的升级）(转科病例)
	 * yaolijie创建于2016-8-16 
	 * @param 
	 * @param SelectOptions options
	 * @return 
	 */
	@Select
	List<Map<String, Object>> selectAmrAndFaultZyAdtByCondition(String qaTypeCode, String statusStr, String curDeptNm,
			String amrNo ,String patientName , String staIll,String rcvTime, String enStaCd, String suF, String qaFlag,String beginTime,String endTime,String specialMr, String isNurseRole,SelectOptions options);
	
	/**
	 * 根据条件查询质控患者列表及质控缺陷数（是对selectAmrByCondition方法的升级）(相关医嘱病例)
	 * yaolijie创建于2016-8-16 
	 * @param 
	 * @param SelectOptions options
	 * @return 
	 */
	@Select
	List<Map<String, Object>> selectAmrAndFaultOrderByCondition(String qaTypeCode, String statusStr, String curDeptNm,
			String amrNo ,String patientName , String staIll,String rcvTime, String enStaCd, String suF, String qaFlag,String beginTime,String endTime, String specialMr,String isNurseRole,SelectOptions options);

	/**
	 * (检验危急值)
	 * @param 
	 * @param SelectOptions options
	 * @return 
	 */
	@Select
	List<Map<String, Object>> selectAmrAndFaultJyByCondition(String qaTypeCode, String statusStr, String curDeptNm,
			String amrNo ,String patientName , String staIll,String rcvTime, String enStaCd, String suF, String qaFlag,String beginTime,String endTime, String isNurseRole,SelectOptions options);
	
	/**
	 * (住院超过30天)
	 * @param 
	 * @param SelectOptions options
	 * @return 
	 */
	@Select
	List<Map<String, Object>> selectAmrAndFaultZyByCondition(String qaTypeCode, String statusStr, String curDeptNm,
			String amrNo ,String patientName , String staIll,String rcvTime, String enStaCd, String suF, String qaFlag,String beginTime,String endTime, String isNurseRole,SelectOptions options);

	/**
	 * (重大，特殊手术患者  )
	 * @param 
	 * @param SelectOptions options
	 * @return 
	 */
	@Select
	List<Map<String, Object>> selectAmrAndFaultOpByCondition(String qaTypeCode, String statusStr, String curDeptNm,
			String amrNo ,String patientName , String staIll,String rcvTime, String enStaCd, String suF, String qaFlag,String beginTime,String endTime, String isNurseRole,SelectOptions options);

	/**
	 * (手术前讨论记录 )
	 * @param 
	 * @param SelectOptions options
	 * @return 
	 */
	@Select
	List<Map<String, Object>> selectAmrAndFaultSqtlByCondition(String qaTypeCode, String statusStr, String curDeptNm,
			String amrNo ,String patientName , String staIll,String rcvTime, String enStaCd, String suF, String qaFlag,String beginTime,String endTime, String isNurseRole,SelectOptions options);

	/**
	 * 有创诊疗操作记录 、疑难病例讨论、多学科会诊
	 * @param 
	 * @param SelectOptions options
	 * @return 
	 */
	@Select
	List<Map<String, Object>> selectAmrAndFaultYczlByCondition(String qaTypeCode, String statusStr, String curDeptNm,
			String amrNo ,String patientName ,String specialMr, String staIll,String rcvTime, String enStaCd, String suF, String qaFlag,String beginTime,String endTime, String isNurseRole,SelectOptions options);
	
	/**
	 * 根据条件查询环节自动质控患者
	 * @param 
	 * @param SelectOptions options
	 * @return
	 */
	@Select
	List<Map<String, Object>> selectQaProcessAuto(String statusStr,String curDeptNm,
			String amrNo ,String patientName , String currentManageDoctorName,SelectOptions options);
	
	/**
	 * 根据条件查询自动质控患者
	 * @param 
	 * @param SelectOptions options
	 * @return
	 */
	/*@Select
	List<Map<String, Object>> selectQaAutoByCondition(String statusStr,String qaTypeCode, String curDeptNm,
			String amrNo ,String patientName , String currentManageDoctorName,SelectOptions options);*/
	
	@Select
	List<Map<String, Object>> selectQaAutoByCondition(String curDeptNm, String currentManageDoctorName,String enStaCd,SelectOptions options);
	
}