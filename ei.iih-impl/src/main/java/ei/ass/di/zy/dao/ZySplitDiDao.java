package ei.ass.di.zy.dao;

import java.util.List;

import org.seasar.doma.Dao;
import org.seasar.doma.Select;
import org.seasar.doma.jdbc.SelectOptions;

import xap.sv.dao.annotation.RepositoryConfig;
import ei.ass.di.auto.po.DiagnosisPo;
import ei.ass.di.auto.po.ZyPatientDiagnosisEntity;

/**
 * @author guo_zhongbao
 *
 */


@RepositoryConfig
@Dao
public interface ZySplitDiDao {
	//诊断列表
	@Select
	List<DiagnosisPo> getDisListByEnSn(String  patientId,String times, String isMainF,String onlyNotStop ,SelectOptions options);
	//诊断详情
	@Select
	DiagnosisPo getDibDiDetail(String diPk);
	
	//获取指定就诊的部分诊断
	@Select
	List<ZyPatientDiagnosisEntity> getDisListByDicodes(String  patientId,String times, List<String> diCodeList ) ;
	
}
