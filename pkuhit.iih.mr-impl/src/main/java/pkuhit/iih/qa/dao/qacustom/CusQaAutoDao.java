package pkuhit.iih.qa.dao.qacustom;

import java.util.List;
import java.util.Map;

import org.seasar.doma.Dao;
import org.seasar.doma.Select;
import org.seasar.doma.jdbc.SelectOptions;

import pkuhit.iih.mr.dao.auto.entity.MrAmr;
import xap.sv.dao.annotation.RepositoryConfig;

@Dao
@RepositoryConfig
public interface CusQaAutoDao {

	
	
	/** 
	 *  查询单个患者的文书，用于自动质控
	 * @param 
	 * @return List<QaAutoModel>    
	 */  
	@Select
	List<Map<String, Object>> selectQaMr(String mrAmr,
			String xapUser,String orgEmp,String enPk);
	
	/**
	 * 查询患者，用于自动质控
	 * @param statusStr
	 * @param curDeptNm
	 * @param options
	 * @return 
	 */
	@Select
	List<MrAmr> selectQaAutoCacheMrAmr(String statusStr,String curDeptId, SelectOptions options);
	
	/** 
	 *  根据条件，查询单个患者的文书
	 * @param  
	 * @return List<QaAutoModel>      
	 */   
	@Select
	List<Map<String, Object>> selectQaMrByCondition(String enPk,List<String> mrTypes,String mrStaCd);
	
	/** 
	 *  根据事件类型条件，查询所有符合的自动质控项
	 * @param  
	 * @return List<QaAutoModel>     
	 */ 
	@Select 
	List<Map<String, Object>> searchQaItemsByCondition(String eventTypeCode);
	
	/** 
	 *  根据条件，查询所有符合的自动质控项，用于预生成缺陷的质控项，查询结果包括
	 * @param    
	 * @return List<QaAutoModel>   
	 */ 
	@Select 
	List<Map<String, Object>> searchPreFltQaItemsByCondition(String currentTime, String qaItmTpCd, String fltFlag);
	
	/** 
	 * 查询所有病历文书类型
	 * @param   
	 * @return    
	 */ 
	@Select 
	List<Map<String, Object>> searchMdMrType();
	
	@Select
	List<Map<String, Object>> selectQaAutoFltByCondition(String currentManageDoctorId,String deptCd,String amrNo,String patientName,String mrTypes,String enStaCd,SelectOptions options);
	
	/**
	 * 查询患者没有进行自动质控评分的患者
	 * @param statusStr
	 * @param curDeptNm
	 * @param options
	 * @return 
	 */ 
	@Select
	List<MrAmr> selectQaAutoMrAmrByCondition();
}
