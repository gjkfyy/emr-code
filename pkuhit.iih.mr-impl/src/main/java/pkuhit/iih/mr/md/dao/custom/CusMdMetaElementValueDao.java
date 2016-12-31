package pkuhit.iih.mr.md.dao.custom;

import java.util.List;

import org.seasar.doma.Dao;
import org.seasar.doma.Select;

import pkuhit.iih.mr.md.dao.auto.entity.MdMetaElementValue;
import xap.sv.dao.annotation.RepositoryConfig;

/**
 * @author guo_zhongbao
 * 病历模板类型
 */
@Dao
@RepositoryConfig
public interface CusMdMetaElementValueDao {

	/**
	 * 
	 * 根据数据元标识查询数据元 
	 * @param metaElementNm 名字
	 * @return
	 */
	@Select
	List<MdMetaElementValue>  selectByDataElementCd(String dataElementCd);

	@Select
	String getNewSn();
	
	@Select
	String getMaxDimenValueCode(String dataElementCd);
}
