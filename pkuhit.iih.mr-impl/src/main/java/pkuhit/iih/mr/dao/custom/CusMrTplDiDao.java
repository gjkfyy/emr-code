/**
 * 
 */
package pkuhit.iih.mr.dao.custom;

import java.util.List;

import org.seasar.doma.Dao;
import org.seasar.doma.Select;

import pkuhit.iih.mr.dao.auto.entity.MrTplDi;
import xap.sv.dao.annotation.RepositoryConfig;

/**
 * @author guo_zhongbao
 * 病历适应病种的自定义 数据访问接口
 */
@Dao
@RepositoryConfig
public interface CusMrTplDiDao {
	//根据医疗记录模板编码获得 适应病种
	@Select
	List<MrTplDi> getDiListByTpl(String mrTemplateCode);
	//根据诊断编码获得相应的模板
	@Select
	List<MrTplDi> getTplListByDi(String diCode);
}
