package pkuhit.iih.qa.dao.custom;

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
public interface CusQaFaultDao {

	/**
	 * @param encounterPk
	 *            就诊编码 qaTypeCode 质控类型编码 statusCode 缺陷状态编码 dropFlag 不扣分类型
	 *            submittedUserId 提出人 submittedDeptCode 提出科室 SelectOptions options
	 * @return List<QaFault>
	 */
	@Select
	List<Map<String, Object>> selectQaFltByCondition(String encounterPk,
			String qaTypeCode, String statusCode, String dropFlag,
			String submittedUserId, String submittedDeptCode, SelectOptions options);
	
	/**
	 * @param encounterPk
	 *            就诊编码 qaTypeCode 质控类型编码 statusCode 缺陷状态编码 
	 *            submittedUserId 提出人 submittedDeptCode 提出科室 SelectOptions options
	 * @return List<QaFault>
	 */
	@Select
	List<Map<String, Object>> selectQaFaultByCondition(String encounterPk,
			String qaTypeCode, String statusCode, String dropFlag,
			String submittedUserId, String submittedDeptCode, SelectOptions options);

	/**
	 * 查询需要从环节质控继承到终末质控的缺陷
	 * 
	 * @return List<QaFault>
	 */
	@Select
	List<QaFlt> selectQaFltExtendInProcess(String enPk);

	/**
	 * 查询当前质控工作记录需要整改的缺陷列表
	 * @param qaPk 质控工作记录编码
	 * @return List<String>
	 */
	@Select
	List<String> selectNeedReformFault(String qaPk);
	/**
	 * 查询缺陷列表 wangyanli
	 * @param qaPk 质控工作记录编码
	 * @return List<String>
	 */
	@Select
	List<String> selectUnSendFault(String qaPk);
	/**
	 * 通过质控体系编码和就诊类型码查询质控体系病案
	 * 
	 * @param qaSysCd
	 * @param enTpCd
	 * @return
	 */
	@Select
	QaSysAmr selectQaSysAmrBy(String qaSysCd, String enTpCd);

	/**
	 * 通过质控体系病案编码查询质控体系项目
	 * 
	 * @param qaSysAmrCd
	 * @return
	 */
	@Select
	List<QaSysItm> selectQaSysItemBy(String qaSysAmrCd);

	/**
	 * 通过质控体系病案编码获得质控体系医疗记录列表
	 * 
	 * @param qaSysAmrCd
	 * @return
	 */
	@Select
	List<QaSysMr> selectQaSysMrBy(String qaSysAmrCd);

	/**
	 * 查询某个病例文书类型的所有子病例文书类型
	 * 
	 * @param parentCd
	 * @return
	 */
	@Select
	List<MdMrTp> selectMrTpByParentCd(String parentCd);

	/**
	 * 通过医疗记录编码查询质控体系医疗记录段落
	 * 
	 * @param qaSysMrCd
	 * @return
	 */
	@Select
	List<QaSysSeg> selectQaSysSegsBy(String qaSysMrCd);

	/**
	 * 通过质控体系医疗记录编码查询查询质控体系项目列表
	 * 
	 * @param qaSysMrCd
	 * @return
	 */
	@Select
	List<QaSysItm> selectQaItemByMrType(String qaSysMrCd);

	/**
	 * 通过质控体系文书段落编码查询质控体系项目编码<br>
	 * FIXME 需不需要前面的限定条件，文书和病案编码？
	 * 
	 * @param qaSysSegCd
	 * @return
	 */
	@Select
	List<QaSysItm> selectQaItemByMrSeg(String qaSysSegCd);

	/**
	 * 通过就诊序号和质控体系项目编码查询质控缺陷
	 * 
	 * @param enPk
	 * @param qaSysItmCd
	 * @return
	 */
	@Select
	List<QaFlt> selectQaFaultByEnPkandQaSysItemCode(String enPk,
			String qaSysItmCd);

	/**
	 * 通过医疗记录类型查询质控体系医疗记录对象
	 * @param mrTpCd
	 * @return
	 */
	@Select
	QaSysMr selectQaSysMrByMrTpCd(String mrTpCd);
	
	
	@Select
	List<QaSysAmrRankScr> selectQaSysAmrRankScoreByQaSysAmrCd(String qaSysAmrCd); 
	
	/**
	 * 判断是否有未确认（缺陷确认结果为非扣分、非不扣分状态）的缺陷
	 * @param enPk 就诊编码
	 * @return
	 */
	@Select
	List<QaFlt> selectCheckFaultReformResult(String enPk); 
    
	/**
	 * 根据就诊编码、质控工作记录编码查询缺陷
	 * @param String  enPk  就诊编码
	 * @param String  qaPk  质控工作记录编码
	 * @return
	 */
	@Select
	List<QaFlt> selectFaultByEnpkAndQaPk(String enPk, String qaPk); 
	
	
	/**
	 * 通过就诊序号和质控体系项目编码查询质控缺陷
	 *  
	 * @param enPk
	 * @param qaSysItmCd
	 * @return
	 */
	@Select
	List<QaFlt> selectQaFaultByRevisionCd(String revisionCd);
	
	/**
	 * 通过就诊编码查询当前
	 *  
	 * @param enPk
	 * @return
	 */
	@Select
	List<QaFlt> selectRfmUsersByEnpk(String enPk);
	
}
