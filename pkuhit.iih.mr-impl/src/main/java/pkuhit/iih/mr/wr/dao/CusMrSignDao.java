package pkuhit.iih.mr.wr.dao;

import java.util.List;

import org.seasar.doma.Dao;
import org.seasar.doma.Select;

import pkuhit.iih.mr.dao.auto.entity.MrSign;
import xap.sv.dao.annotation.RepositoryConfig;


/**
 */
@Dao
@RepositoryConfig
public interface CusMrSignDao {

	/**
	 * 根据医疗记录主键和用户id查询医疗记录签名 
	 * @param mrPk
	 * @param userId
	 * @return
	 */
    @Select
    List<MrSign> selectByMrPkAndUserId(String mrPk,String userId);
}