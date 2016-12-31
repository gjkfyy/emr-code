package pkuhit.iih.mr.wr.dao;

import java.util.List;

import org.seasar.doma.Dao;
import org.seasar.doma.Select;

import pkuhit.iih.mr.dao.auto.entity.MrDocValue;
import xap.sv.dao.annotation.RepositoryConfig;


/**
 */
@Dao
@RepositoryConfig
public interface CusMrDocValueDao {

	/**
	 * 根据就诊号查询医疗记录
	 * FIXME 
	 * @param enPk
	 * @return
	 */
    @Select
    List<MrDocValue> selectByEnPkAndMrPkAndElemId(String enPk,String mrPk,String elemId);
}