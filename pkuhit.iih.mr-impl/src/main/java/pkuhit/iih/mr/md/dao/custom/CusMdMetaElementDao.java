package pkuhit.iih.mr.md.dao.custom;

import java.util.List;

import org.seasar.doma.Dao;
import org.seasar.doma.Select;
import org.seasar.doma.jdbc.SelectOptions;

import pkuhit.iih.mr.md.dao.auto.entity.MdMetaElement;
import xap.sv.dao.annotation.RepositoryConfig;

/**
 * @author guo_zhongbao
 * 病历模板类型
 */
@Dao
@RepositoryConfig
public interface CusMdMetaElementDao {

	/**
	 * 
	 * 根据数据元标识查询数据元 
	 * @param metaElementNm 名字
	 * @return
	 */
	@Select
	List<MdMetaElement>  selectByMetaElementNm(String metaElementNm,String spellNo);
	
	/**
	 * 
	 * 根据搜索条件（名称或者拼音或者五笔）来查询数据元
	 * @param cond 名称或者拼音或者五笔
	 * @param options 查询选项
	 * @return
	 */
	@Select
	List<MdMetaElement>  selectByMetaElementNmOrSpellNo(String cond,SelectOptions options);

	@Select
	String getNewSn();
}
