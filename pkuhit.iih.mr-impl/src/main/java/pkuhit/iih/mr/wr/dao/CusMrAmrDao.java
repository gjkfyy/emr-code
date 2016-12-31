
package pkuhit.iih.mr.wr.dao;

import java.math.BigInteger;
import java.util.List;

import org.seasar.doma.Dao;
import org.seasar.doma.Select;
import org.seasar.doma.jdbc.SelectOptions;

import pkuhit.iih.mr.dao.auto.entity.MrAmr;
import xap.sv.dao.annotation.RepositoryConfig;

/**
 */
@Dao
@RepositoryConfig
public interface CusMrAmrDao {
	/**
     * @param currentDeptCode科室编号,receiveTime,finishTime,
     * inpatientNo住院号,patientId患者姓名,pageNumber,pageSize
     * @return the MrAmr entity
     */
	@Select
	List<MrAmr> selectParientAll(String currentDeptCode,String receiveTime,String finishTime,
			String amrNo,String patientName,Integer checkQa,Integer arcF,String mrAmrType,SelectOptions options);
	@Select
	List<MrAmr> selectMrAmrs(String enStaCd,String amrStaCd, String curGrpCd, String enTpCd,String paId,String amrGroupCd);
	
	@Select
	List<MrAmr> selectUnXmlConvertMrAmrs(String arcTime);
	
	@Select
	List<MrAmr> selectUnachiveMrAmrs(String enTpCd);
	@Select
	List<MrAmr> selectMrAmrByPaIdAndEnCnt(String paId,BigInteger enCnt);
	//是否存在该就诊
	@Select
	Integer isExistEncounter(String enPk);
	
	@Select
	Integer isExistPatient(String patient_id);
	@Select
	String selectOracleDate();
	
	@Select 
	List<MrAmr> selectParientAllForMrb(List<String> enTypeCodeList,List<String> userRoleDeptListToSearch, String doctorCode,String receiveTime, String finishTime,String idCardNo, String amrNo,String paId, String patientName,String mobile,String amrStaCd,List<String> mrTypeList,SelectOptions options);
	
	@Select 
	MrAmr selectByPaIdAndEnCntAndVisitFlag(String paId,Integer enCnt,String visitFlag);
	
}
