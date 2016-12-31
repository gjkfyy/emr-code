package pkuhit.iih.mr.wr.dao;
import java.util.List;
import java.util.Map;

import org.seasar.doma.Dao;
import org.seasar.doma.Select;

import xap.sv.dao.annotation.RepositoryConfig;

@Dao
@RepositoryConfig
public interface CusFileDao {
	@Select
	Map<String,Object> selectBizFileIsXml(String paId,String enCnt,List<String> mrTpCds);
}
