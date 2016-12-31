package ei.ass.nu.mz.dao;

import java.util.List;

import org.seasar.doma.Dao;
import org.seasar.doma.Select;
import org.seasar.doma.jdbc.SelectOptions;

import xap.sv.dao.annotation.RepositoryConfig;
import ei.ass.nu.auto.po.VitalsignPo;

@Dao
@RepositoryConfig
public interface MzDirectVitalsignDao {
	//根据就诊序号，获取生命体征列表
	@Select
	List<VitalsignPo>   getAcquisitionListByEnSn(String enPk,
			String acquisitionStartTime, String acquisitionStopTime,String isDesc ,SelectOptions options) ;
	
	//根据就诊序号，获取生命体征列表
	@Select
	VitalsignPo   getAcquisitionListByVitalSignPk(String vitalSignPk) ;
}
