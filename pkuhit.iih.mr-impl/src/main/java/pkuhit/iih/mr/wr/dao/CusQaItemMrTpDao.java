package pkuhit.iih.mr.wr.dao;

import java.util.List;

import org.seasar.doma.Dao;
import org.seasar.doma.Select;

import pkuhit.iih.qa.dao.auto.entity.QaItemMrTp;
import xap.sv.dao.annotation.RepositoryConfig;


/**
 */
@Dao
@RepositoryConfig
public interface CusQaItemMrTpDao {

	/**
	 * 根据就医疗记录类型编码查询质控项目一级分类医疗记录类型关系
	 * FIXME 
	 * @param enPk
	 * @return
	 */
    @Select 
    List<QaItemMrTp> selectByMrTpCd(String mrTypeCode);
}