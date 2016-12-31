package iih.kr.db.cs.dao;

import iih.kr.db.cs.entity.DbDateEntity;
import iih.kr.db.cs.entity.DiSuiteModelEntity;
import iih.kr.db.cs.entity.MdDiSimpleEntity;
import iih.kr.db.cs.entity.MrTplSimpleEntity;
import iih.kr.db.gen.entity.DiSuiteDiEntity;
import iih.kr.db.gen.entity.DiSuiteEntity;
import iih.kr.db.gen.entity.DiSuiteShareEntity;
import iih.kr.db.gen.entity.DiSuiteTemplateEntity;
import iih.kr.db.gen.entity.DiSuiteTpEntity;
import iih.kr.db.gen.entity.MrTplEntity;

import java.util.List;

import org.seasar.doma.Dao;
import org.seasar.doma.Select;

import xap.sv.dao.annotation.RepositoryConfig;


/**
 * 
 */
@Dao
@RepositoryConfig
public interface KrDao {
	
	@Select
	DbDateEntity sysdate();

	//查询 所属类型所属编码的关联诊断的最大值
	@Select 
	int getMaxSortNoDiRelDi( String ownerType, String ownerCode,String diSuiteTypeCode,String diSuiteCode,
			String enTypeCode);
	
	//读取共享的组套
	@Select 
	List<DiSuiteShareEntity> getSharedKr(String sOwnerType, String sOwnerCode,String dOwnerType, String dOwnerCode);

	//读取指定数量的病历模板实体
	@Select
	List<MrTplSimpleEntity> selectAllMrTemplate(String orgCode,String ownerType, String ownerCode,String enTypeCode);
	
	@Select
	List<DiSuiteEntity> selectCcdByCategoryCode(String ownerType,
			String ownerCode,String orgCode,String diSuiteTypeCode,String enTypeCode);
	
	
	//查询通用的病历列表  所属类型所属编码的病历列表
	@Select 
	List<MrTplEntity> selectCOmmonMrDoc(String ownerType,
			String ownerCode,String enTypeCode);
	
	/**
	 * 是否存在该自定义分类名称
	 * */
	@Select 
	int selectCountOfCategoryName(String diSuiteTypeName,String orgCode,String ownerType,String ownerCode,String enTypeCode);
	
	/**
	 * 是否存在该所属类型所属编码 的自定义分类与诊断关系
	 * */
	@Select 
	int selectCountOfDiSuite(String orgCode,String ownerType,
			String ownerCode,String diSuiteTypeCode,String diCode ,String enTypeCode);
	
	/*以组套为主表的组套树*/
	@Select
	List<DiSuiteModelEntity> selectDiSuiteEntities(String ownerType, String ownerCode,
			String orgCode,String enTypeCode);

	/*以组套分类为主表的组套树*/
	@Select
	List<DiSuiteModelEntity> selectDiSuiteEntitiesForAdmin(String orgCode,String ownerType, String ownerCode,String enTypeCode);
	
	/**
	 * 获取自定义分类的最大顺序号
	 * */
	@Select
	Integer selectMaxSortNoForCC(String orgCode,String ownerType,
			String ownerCode,String enTypeCode);
	
	//读取指定数量的诊断实体
	@Select
	List<MdDiSimpleEntity> selectMdDi(String orgCode ,List<String> diCodes);
	
	/**
	 * 获取该诊断关联的其他诊断列表
	 * */
	@Select 
	List<DiSuiteDiEntity> selectRelDiByDiSuite(String diSuiteCode);
	
	/**
	 * 获取该诊断关联的病历列表
	 * */
	@Select 
	List<DiSuiteTemplateEntity> selectRelMrDocByDiSuite(String diSuiteCode);
	
	//读取指定数量的病历模板实体
	@Select
	List<MrTplSimpleEntity> selectMrTemplate(List<String> mrCodes);

	//获取该组套关联诊断 的最大sortno
	@Select
	Integer selectMaxSortNoForRelDi(String diSuiteCode);

	//获取该组套病历模板诊断 的最大sortno
	@Select
	Integer selectMaxSortNoForRelMr(String diSuiteCode);
	
	//获取所属的自定义分类列表
	@Select
	List<DiSuiteTpEntity> selectCategoryByOwner(String orgCode,String ownerType,
			String ownerCode,String enTypeCode);
	
}