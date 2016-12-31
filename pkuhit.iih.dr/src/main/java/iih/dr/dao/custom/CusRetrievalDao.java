package iih.dr.dao.custom;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.seasar.doma.Dao;
import org.seasar.doma.Select;

import xap.sv.dao.annotation.RepositoryConfig;

@Dao
@RepositoryConfig
public interface CusRetrievalDao {
	
	@Select
	List<Map<String, Object>> selectRetrievalByCondition(String retrievalCd, String retrievalNm, String ownTpCd, String responsibleCd, String retrievalKey, String deptCd, Date lastUpdTime);
	
	@Select
	List<Map<String, Object>> selectAmrByEnpkstr(List<String> enPkList);
	
}
