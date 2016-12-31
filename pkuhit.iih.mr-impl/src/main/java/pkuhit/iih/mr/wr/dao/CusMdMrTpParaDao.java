package pkuhit.iih.mr.wr.dao;

import java.util.List;

import org.seasar.doma.Dao;
import org.seasar.doma.Select;

import pkuhit.iih.mr.dao.auto.entity.MdMrTpPara;
import xap.sv.dao.annotation.RepositoryConfig;


/**
 * 段落内容DAO
 */
@Dao
@RepositoryConfig
public interface CusMdMrTpParaDao {
	@Select
	List<MdMrTpPara> selectByMdMrTpCd(String mdMrTpCd);
}