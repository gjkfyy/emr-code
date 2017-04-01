package pkuhit.iih.mr.wr.dao;

import java.util.List;
import java.util.Map;

import org.seasar.doma.Dao;
import org.seasar.doma.Select;
import org.seasar.doma.jdbc.SelectOptions;

import pkuhit.iih.mr.dao.auto.entity.Mr;
import xap.sv.dao.annotation.RepositoryConfig;


/**
 */
@Dao
@RepositoryConfig
public interface CusMrDao {

	/**
	 * 根据就诊号查询医疗记录
	 * FIXME 
	 * @param enPk
	 * @return
	 */
    @Select
	List<Mr> selectByEnPk(String enPk,String mrTypeCustomCode,String mrTypeCode,String deptCd,Integer nsF,String mrType);
    
	/**
	 * 根据就诊号查询医疗记录
	 * FIXME 
	 * @param enPk
	 * @return
	 */
    @Select
    List<Mr> selectByEnPkForContinuePrint(String enPk,String mrTypeCustomCode,String deptCd);
    
	/**
	 * 根据就诊号查询医疗记录
	 * FIXME 
	 * @param enPk
	 * @return
	 */
    @Select
    List<Mr> selectByEnPks(List<String> enPkList,String mrTypeCustomCode,String mrTypeCode);
    
	/**
	 * 根据就诊号查询医疗记录
	 * FIXME 
	 * @param enPk
	 * @return
	 */
    @Select
    List<Mr> selectByEnPksForMerge(List<String> enPkList,List<String> mrTypeCustomCodes);
    
	/**
	 * 根据就诊号查询医疗记录
	 * FIXME 
	 * @param enPk
	 * @return
	 */
    @Select
    List<Mr> selectByEnPkForMerge(String enPk,List<String> mrTypeCustomCodes);
    
	/**
	 * 根据就诊号查询医疗记录
	 * FIXME 
	 * @param enPk
	 * @return
	 */
    @Select
    List<Mr> selectByEnPksForEmergencyMrNumber(List<String> enPkList);
    
	/**
	 * 根据就诊号查询医疗记录
	 * FIXME 
	 * @param enPk
	 * @return
	 */
    @Select
    List<Mr> selectByEnPkForEmergencyMrNumber(String enPk,SelectOptions options);
    
    /**
     * 根据就诊号查询医疗记录
     * FIXME 
     * @param enPk
     * @return
     */
    @Select
    List<Map<String, Object>> selectMrByEnPk(String enPk,String mrTypeCustomCode,String mrTypeCode,String mrType);
    
    /**
     * 根据就诊组查询医疗记录
     * FIXME 
     * @param enPk
     * @return
     */
    @Select
    List<Map<String, Object>> selectMrByAmrGroup(List<String> enPks,String mrTypeCustomCode,String mrTypeCode);
    
    /**
     * 根据用户id查询已审签未归档患者
     * @param userId
     * @return
     */
    @Select
    List<Map<String, Object>> selectSignedPatients(String userId,String deptCd);
    
    /**
     * 根据用户id查询带科室审签未归档患者
     * @param userId
     * @return
     */
    @Select
    List<Map<String, Object>> selectWaitDeptSignPatients(String userId,String deptCd);
    
	/**
	 * 根据用户id查询已审签未规定文书
	 * @param userId
	 * @return
	 */
    @Select
    List<Map<String, Object>> selectSignedMrs(String userId,String deptCd,String patientId,SelectOptions options);
    
    /**
	 * 根据用户id查询待审签未规定文书
	 * @param userId
	 * @return
	 */
    @Select
    List<Map<String, Object>> selectWaitSignedMrs(String userId,String deptCd, SelectOptions options);
    
    /**
     * 根据用户id查询待科室审签未规定文书
     * @param userId
     * @return
     */
    @Select
    List<Map<String, Object>> selectWaitDeptSignedMrs(String userId,String deptCd,String patientId, SelectOptions options);
    
    /**
	 * 根据用户id查询已审签未规定文书
	 * @param userId
	 * @return
	 */
    @Select
    List<Map<String, Object>> selectQaFltForMr(String mrPk,String qaTypeCode);
    
    @Select
    List<Mr> selectMrsByEnPk(String enPk,List<String> mrTypeCodes,SelectOptions options);
    
    @Select
    List<Mr> selectMrsByEnPkAndDel(String enPk);
    
    /**
     * 获取就诊特定病历类型的病历信息列表
     * @param enPk 就诊
     * @param mrMypeCode 病历类型
     * 
     * */
    @Select
    List<Mr> selectMrsByEnPkAndMrTypeCode(String enPk,String templateId);
    
    @Select
	List<Mr> selectUnXmlConvertMrs(String enPk);
    
    @Select
	String selectMrSplFmByEnPk(String enPk);
    
    /**
     * 根据病历类型和就诊号查询已写文书
     * @param enPk,MrTpCd
     * @return
     */
    @Select
    List<Map<String, Object>> selectMrsByEnPkAndMrType(String enPk,String mrTpCd);

    @Select
	List<Mr> selectMrsByConds(String enPk, String ctrTime, String mrMypeCode);
    
    @Select
    List<Mr> selectBatchPrintMrs(String enPk,String tpCcatCd,String dctNsF,SelectOptions options);
    
}