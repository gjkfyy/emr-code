package szlh.iih.en.dao;

import java.util.List;

import org.seasar.doma.Dao;
import org.seasar.doma.Select;

import szlh.iih.en.po.PatientPo;
import xap.sv.dao.annotation.RepositoryConfig;

/**
 * @author guo_zhongbao
 * 患者查询接口
 */
@Dao
@RepositoryConfig
public interface PatientDao {
	 
	@Select
	public List<PatientPo> getPatientDetail(String paId);
	//查询门诊的患者信息
	@Select 
	public List<PatientPo> getPatientDetailForMz(String paId);
	//查询住院的患者信息
	@Select
	public List<PatientPo> getPatientDetailForZy(String paId);
}
