package pkuhit.xap.dao.custom;

import java.util.List;

import org.seasar.doma.Dao;
import org.seasar.doma.Select;

import pkuhit.xap.dao.auto.entity.XapCfgData;
import xap.sv.dao.annotation.RepositoryConfig;

@Dao
@RepositoryConfig
public interface CustomXapCfgDataDao {
   
	 @Select 
	 List<XapCfgData> selectCfgDataList(String orgCd, String cfgCd);
}
