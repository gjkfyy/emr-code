package iih.dr.dao.custom;

import org.seasar.doma.Dao;
import org.seasar.doma.Select;
import xap.sv.dao.annotation.RepositoryConfig;


import iih.dr.dao.auto.entity.IemrRetrievalResult;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Dao
@RepositoryConfig
public interface CusRetrievalResultDao {

	@Select
	List<Map<String, Object>> selectRetrievalAmrByCondition(Date lastUpdTime);
	
	@Select
	Map<String, Object> selectResultLastUpdTime();
	
	@Select
	List<Map<String, Object>> selectResultByRetrievalCd(String retrievalCd);
	
	@Select
    IemrRetrievalResult selectByResultCd(String resultCd);
}