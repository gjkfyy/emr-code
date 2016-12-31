package pkuhit.iih.qa.dao.qacustom;

import java.util.List;
import java.util.Map;

import org.seasar.doma.Dao;
import org.seasar.doma.Select;

import pkuhit.iih.qa.dao.auto.entity.IemrReport;

import xap.sv.dao.annotation.RepositoryConfig;

@Dao
@RepositoryConfig
public interface CusIemrReportDao {
	/** 
	 *  查询质控报表列表
	 * @param 
	 * @return List<QaAutoModel>    
	 */  
	@Select 
	List<Map<String, Object>> selectIemrReport(String userId,String reportType);
	
}
