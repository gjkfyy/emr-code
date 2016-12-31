package pkuhit.iih.mr.wr.dao;


import java.util.List;
import java.util.Map;

import org.seasar.doma.Dao;
import org.seasar.doma.Select;

import pkuhit.iih.mr.dao.auto.entity.MrSplFm;
import xap.sv.dao.annotation.RepositoryConfig;


@Dao
@RepositoryConfig
public interface CusMrSplFmDao {

	@Select
	List<MrSplFm>  selectAll(String enPk,int fmType,String fmName); 
	
}
