package pkuhit.xap.dao.custom;

import java.util.List;
import java.util.Map;

import org.seasar.doma.Dao;
import org.seasar.doma.Select;
import org.seasar.doma.jdbc.SelectOptions;

import pkuhit.xap.dao.auto.entity.XapMessage;
import xap.sv.dao.annotation.RepositoryConfig;

@Dao
@RepositoryConfig
public interface CustomXapMessageDao {
//	@Select 
//	List<XapMessage> selectXapMessageByUserId(String userId, SelectOptions options);
//	@Select
//	List<XapMessage> selectXapMessageByUserIdAndReadFlag(String userId, String readFlag);     
	@Select 
	List<Map<String, Object>> selectXapMessageByUserId(String userId, SelectOptions options);
	@Select
	List<Map<String, Object>> selectXapMessageByUserIdAndReadFlag(String userId, String readFlag);     
	@Select
	String selectMngDocCdByEnpk(String enPk);
}
