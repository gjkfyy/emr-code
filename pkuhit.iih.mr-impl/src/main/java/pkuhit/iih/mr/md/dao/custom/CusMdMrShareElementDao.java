package pkuhit.iih.mr.md.dao.custom;

import java.util.List;

import org.seasar.doma.Dao;
import org.seasar.doma.Select;
import org.seasar.doma.jdbc.SelectOptions;

import pkuhit.iih.mr.md.dao.auto.entity.MdMrShareElement;
import xap.sv.dao.annotation.RepositoryConfig;

/**
 * @author guo_zhongbao
 * 病历模板类型
 */
@Dao
@RepositoryConfig
public interface CusMdMrShareElementDao {

	/**
	 * 
	 * 根据宏元素标识查询共享元素 
	 * @param macroFlag 宏元素标识
	 * @return
	 */
	@Select
	 List<MdMrShareElement>  selectByMacroFlag(String macroFlag,String spellNo);
	
	@Select
    List<MdMrShareElement>  selectAll(SelectOptions options);

}
