package ei.ris.db.dao;

import java.util.List;

import org.seasar.doma.Dao;
import org.seasar.doma.Select;
import org.seasar.doma.jdbc.SelectOptions;

import ei.ris.db.dao.po.ObservationReportPo;

import xap.sv.dao.annotation.RepositoryConfig;

@Dao
@RepositoryConfig
public interface ObsDao {
	/*检查列表*/
	@Select
	List<ObservationReportPo> getObsListByEnpk(String paId, String enCnt/*, SelectOptions options*/);
	/*检查详情*/
	@Select
	ObservationReportPo getObservationByObsSn(String obRpPk);
	/*检查列表*/
    @Select
    List<ObservationReportPo> getObsListByEnSn(String enPk/*, SelectOptions options*/);
	/*检查列表*/
    @Select
    List<ObservationReportPo> getObsListByObsNo(List<String> obRpNos);
}
