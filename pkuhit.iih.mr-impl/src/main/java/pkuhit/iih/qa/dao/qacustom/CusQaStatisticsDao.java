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
public interface CusQaStatisticsDao {
	 
	@Select
	List<Map<String, Object>> selectAmrLevelRate();
	@Select 
	List<Map<String, Object>> selectAmrCounts();

	
	
	
}
