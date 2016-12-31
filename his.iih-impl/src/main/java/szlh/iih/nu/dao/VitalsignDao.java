package szlh.iih.nu.dao;

import java.util.List;

import org.seasar.doma.Dao;
import org.seasar.doma.Select;
import org.seasar.doma.jdbc.SelectOptions;

import szlh.iih.nu.po.VitalsignPo;
import xap.sv.dao.annotation.RepositoryConfig;

@Dao
@RepositoryConfig
public interface VitalsignDao {
	//根据就诊序号，获取生命体征列表
	@Select
	List<VitalsignPo>   getAcquisitionListByEnSn(String enPk,String patientId, String times,
			String acquisitionStartTime, String acquisitionStopTime,String isDesc/* ,SelectOptions options*/) ;
	
	//根据就诊序号，获取生命体征列表
	@Select
	VitalsignPo   getAcquisitionListByVitalSignPk(String vitalSignPk) ;
}
