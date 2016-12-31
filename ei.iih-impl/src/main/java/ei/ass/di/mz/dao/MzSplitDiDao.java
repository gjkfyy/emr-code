package ei.ass.di.mz.dao;

import java.util.List;

import org.seasar.doma.Dao;
import org.seasar.doma.Select;
import org.seasar.doma.jdbc.SelectOptions;

import xap.sv.dao.annotation.RepositoryConfig;
import ei.ass.di.auto.po.DiagnosisPo;
import ei.ass.di.auto.po.MzPatientDiagnosisEntity;

/**
 * @author guo_zhongbao
 * 门诊，根据pa_id,times直接查询dao
 */
@Dao
@RepositoryConfig
public interface MzSplitDiDao {
	//诊断列表
	@Select
	List<DiagnosisPo> getDisListByEnSn(String  patientId,String times, String isMainF,String onlyNotStop ,SelectOptions options);
	//诊断详情
	@Select
	DiagnosisPo getDibDiDetail(String diPk);
	
	//获取指定就诊的部分诊断
	@Select
	List<MzPatientDiagnosisEntity> getDisListByDicodes(String  patientId,String times, List<String> diCodeList ) ;
	
}
