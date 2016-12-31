package pkuhit.xap.dao.custom;

import org.seasar.doma.Dao;
import org.seasar.doma.Select;


import java.util.List;
import java.util.Map;

import xap.sv.dao.annotation.RepositoryConfig;

/**
 */
@Dao
@RepositoryConfig
public interface CutomXapMrTaskDao {
	
	@Select 
	List<Map<String, Object>> searchTaskTypesByCondition(String eventTypeCode);
	
	@Select  
	List<Map<String, Object>> searchTasksByCondition(String enPk,String mrTypeCode);
	
}
