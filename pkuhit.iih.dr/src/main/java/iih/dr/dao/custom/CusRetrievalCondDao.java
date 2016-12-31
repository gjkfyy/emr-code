package iih.dr.dao.custom;

import java.util.List;
import java.util.Map;

import org.seasar.doma.Dao;
import org.seasar.doma.Select;

import xap.sv.dao.annotation.RepositoryConfig;

@Dao
@RepositoryConfig
public interface CusRetrievalCondDao {
	
	@Select
	List<Map<String, Object>> selectRetrievalCondByRetrievalcd(String retrievalCd, String condCd, String grade);
	
	@Select
	List<Map<String, Object>> selectRetrievalCondByUpcond(String upcond);
	
	@Select
	List<Map<String, Object>> selectRetrievalCondByCondno(String retrievalCd, int grade, String upcond);
	
	@Select
	int selectMaxCondNoByRetrievalcd(String retrievalCd);
	
	@Select
	List<Map<String, Object>> selectCondLogicByRetrieval(String retrievalCd, String enPk);
	
	@Select
	List<Map<String, Object>> selectBaseTemplate(String xmlFilePk);
	
}
