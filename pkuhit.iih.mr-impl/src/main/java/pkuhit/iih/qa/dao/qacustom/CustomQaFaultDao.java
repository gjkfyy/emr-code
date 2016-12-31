package pkuhit.iih.qa.dao.qacustom;

import java.util.List;
import java.util.Map;

import org.seasar.doma.Dao;
import org.seasar.doma.Select;
import org.seasar.doma.jdbc.SelectOptions;

import pkuhit.iih.mr.md.dao.auto.entity.MdMrTp;
import pkuhit.iih.qa.dao.auto.entity.QaFlt;
import pkuhit.iih.qa.dao.auto.entity.QaSysAmr;
import pkuhit.iih.qa.dao.auto.entity.QaSysAmrRankScr;
import pkuhit.iih.qa.dao.auto.entity.QaSysItm;
import pkuhit.iih.qa.dao.auto.entity.QaSysMr;
import pkuhit.iih.qa.dao.auto.entity.QaSysSeg;
import xap.sv.dao.annotation.RepositoryConfig;

@Dao
@RepositoryConfig
public interface CustomQaFaultDao {

	
	
	/** 
	 *  查询质控的缺陷
	 * @param encounterPk 就诊编码 
	 *        qaTypeCode 质控类型编码
	 *        statusCode 缺陷状态编码 
	 *        submittedUserId 提出人 
	 *        submittedDeptCode 提出科室 
	 *        reformUserId 提出人 
	 *        reformDeptCode 提出科室 
	 *        reversionCd 通知书编码
	 *        SelectOptions options 分页参数
	 * @return List<QaFault>
	 */  
	@Select
	List<Map<String, Object>> selectQaFaultByCondition(String encounterPk,
			String qaTypeCode, String statusCode, 
			String submittedUserId, String submittedDeptCode,String reformUserId, String reformDeptCode, String reversionCd, SelectOptions options);
	
	
	@Select
	List<Map<String, Object>> selectQaFaultList(String encounterPk, SelectOptions options);
	
	
	/**
	 * 通过就诊序号和质控体系项目编码查询质控缺陷
	 * 
	 * @param enPk
	 * @param qaSysItmCd
	 * @return
	 */
	@Select
	List<QaFlt> selectQaFaultByRevisionCd(String revisionCd);
	
	
}
