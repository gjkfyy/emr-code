package ei.ass.nu.zy.dao;

import java.util.List;

import org.seasar.doma.Dao;
import org.seasar.doma.Select;

import xap.sv.dao.annotation.RepositoryConfig;
import ei.ass.nu.auto.po.VitalsignPo;

@Dao
@RepositoryConfig
public interface ZySplitVitalsignDao {
	//根据就诊序号，获取生命体征列表
	@Select
	List<VitalsignPo>   getAcquisitionListByEnSn(String patientId, String times,
			String acquisitionStartTime, String acquisitionStopTime,String isDesc/* ,SelectOptions options*/) ;
	
	//根据就诊序号，获取生命体征列表
	@Select
	VitalsignPo   getAcquisitionListByVitalSignPk(String vitalSignPk) ;
}
