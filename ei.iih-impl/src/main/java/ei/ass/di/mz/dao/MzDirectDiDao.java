package ei.ass.di.mz.dao;

import java.util.List;

import org.seasar.doma.Dao;
import org.seasar.doma.Select;
import org.seasar.doma.jdbc.SelectOptions;

import xap.sv.dao.annotation.RepositoryConfig;
import ei.ass.di.auto.po.DiagnosisPo;

/**
 * @author guo_zhongbao
 * 门诊，根据enpk直接查询dao
 */
@Dao
@RepositoryConfig
public interface MzDirectDiDao {
	//诊断列表
	@Select
	List<DiagnosisPo> getDisListByEnSn(String enPk, String isMainF,String onlyNotStop ,SelectOptions options);
	//诊断详情
	@Select
	DiagnosisPo getDibDiDetail(String diPk);
}
