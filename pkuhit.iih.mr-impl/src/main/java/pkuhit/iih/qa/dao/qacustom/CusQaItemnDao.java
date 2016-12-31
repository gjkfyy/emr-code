
package pkuhit.iih.qa.dao.qacustom;

import java.util.List;
import java.util.Map;

import org.seasar.doma.Dao;
import org.seasar.doma.Select;

import pkuhit.iih.qa.dao.auto.entity.QaItm;
import xap.sv.dao.annotation.RepositoryConfig;

@Dao
@RepositoryConfig
public interface CusQaItemnDao {

	/**
	 * @param itemFirstCode
	 *            质控项目一级分类
	 * @param itemSecondCode
	 *            质控项目二级分类 
	 * 
	 * @return List pkuhit.iih.qa.dao.custom.entity.CusQaSysItem
	 */
	@Select  
	List<QaItm> searchQaItem(String itemFirstCode, String itemSecondCode);
	
	@Select  
	List<Map<String, Object>> searchQaItemList(String itemFirstCode, String itemSecondCode);
 
	@Select  
	QaItm selectQaItmById(String qaItmCd);
	
}
