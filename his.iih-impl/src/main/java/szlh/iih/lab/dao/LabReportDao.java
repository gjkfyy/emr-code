package szlh.iih.lab.dao;

import java.util.List;

import org.seasar.doma.Dao;
import org.seasar.doma.Select;
import org.seasar.doma.jdbc.SelectOptions;

import szlh.iih.lab.po.LabReportItemPo;
import szlh.iih.lab.po.LabReportPo;
import xap.sv.dao.annotation.RepositoryConfig;

@Dao
@RepositoryConfig
public interface LabReportDao {
	//根据就诊序号，获取检验报告列表
	@Select
	List<LabReportPo> getLabByEnsn(String enPk,String patientId, String times, SelectOptions options) ;
	
	//根据就诊序号，获取检验详情列表
	@Select
	LabReportPo getLabByLabSn (String labRpPk);
	
	//根据就诊序号，获取检验报告详情
	@Select
	List<LabReportItemPo> getLabDetailItemListByReportId(String labRpPk, SelectOptions options);
	
}
