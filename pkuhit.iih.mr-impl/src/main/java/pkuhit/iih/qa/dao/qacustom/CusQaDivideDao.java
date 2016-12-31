package pkuhit.iih.qa.dao.qacustom;

import java.util.List;
import java.util.Map;

import org.seasar.doma.Dao;
import org.seasar.doma.Select;
import org.seasar.doma.jdbc.SelectOptions;

import pkuhit.iih.qa.dao.auto.entity.QaDivideLevel;
import pkuhit.iih.qa.dao.auto.entity.QaItmFst;
import pkuhit.iih.qa.dao.auto.entity.QaItmSnd;
import xap.sv.dao.annotation.RepositoryConfig;

@Dao
@RepositoryConfig
public interface CusQaDivideDao {

	
	
	/** 
	 *  查询扣分项目
	 * @param encounterPk 就诊编码 
	 *        qaTypeCode 质控类型编码
	 *        SelectOptions options 分页参数 
	 * @return List<QaFault>
	 */  
	@Select
	List<Map<String, Object>> selectQaDivideByCondition(String encounterPk,
			String qaTypeCode, SelectOptions options);
	
	/** 
	 *  查询扣分项目
	 * @param encounterPk 就诊编码 
	 *        qaTypeCode 质控类型编码
	 * @return List<QaFault> 
	 */  
	@Select
	List<Map<String, Object>> selectQaDivide(String encounterPk,
			String qaTypeCode);
	
	/** 
	 *  查询病案等级
	 * @param 
	 * @return List<QaDivideLevelModel> 
	 */  
	@Select
	List<Map<String, Object>> selectQaDivideLevel();
	
	/** 
	 *  根据编码查询病案等级
	 * @param 
	 * @return List<QaDivideLevelModel> 
	 */  
	@Select
	QaDivideLevel selectLevelById(String qaDivideLevelCd);
	
	/** 
	 *  根据编码查询一级分类
	 * @param 
	 * @return List<QaDivideLevelModel> 
	 */  
	@Select
	QaItmFst selectFstById(String fstCd);
	
	/** 
	 *  根据编码查询二级分类
	 * @param 
	 * @return List<QaDivideLevelModel> 
	 */  
	@Select
	QaItmSnd selectSndById(String sndCd);
	
}
