package szlh.iih.ob.dao;

import java.util.List;

import org.seasar.doma.Dao;
import org.seasar.doma.Select;
import org.seasar.doma.jdbc.SelectOptions;

import szlh.iih.ob.po.ObservationReportPo;
import xap.sv.dao.annotation.RepositoryConfig;

@Dao
@RepositoryConfig
public interface ObsDao {
	/*检查列表*/
	@Select
	List<ObservationReportPo> getObsListByEnSn(String enPk,String patientId, String times, SelectOptions options);
	/*检查详情*/
	@Select
	ObservationReportPo getObservationByObsSn(String obRpPk);
}
