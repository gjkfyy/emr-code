package pkuhit.iih.ass.lab;

import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import pkuhit.iih.en.md.EncounterType;
import pkuhit.iih.mr.dao.auto.MrAmrDao;
import pkuhit.iih.mr.dao.auto.entity.MrAmr;
import pkuhit.md.SysFunctionCode;
import pkuhit.utils.ParameterUtils;
import pkuhit.xap.ass.LabReport;
import pkuhit.xap.pm.ParamsService;
import pkuhit.xap.pm.ParamsSetService;
import xap.sv.annotation.Reference;
import xap.sv.model.ArrayResult;
import xap.sv.model.ArrayResultBuilder;
import xap.sv.model.SingleResult;
import ei.lis.service.LabReportFromIEService;
import ei.lis.service.LabReportService;

/**
 * @author guo_zhongbao
 *
 */
public class LabRepServiceImpl implements LabRepService {
	private Logger log = LoggerFactory.getLogger(LabRepServiceImpl.class);
	@Reference
	ParamsService paramsService;
	
	@Reference
	ParamsSetService paramsSetService;

	@Reference
	LabReportService labReportService;
	
	@Reference
	LabReportFromIEService labReportFromIEService;
	
	@Autowired
	MrAmrDao mrAmrDao;

	/* (non-Javadoc)
	 * @see pkuhit.iih.lab.LabReportService#search(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public ArrayResult<LabReport> search(String enPk, String currentPageIndex,
			String pageSize) {
		if(null == currentPageIndex || !StringUtils.isNumeric(currentPageIndex)   || null == pageSize || !StringUtils.isNumeric(pageSize)  )
		{
			currentPageIndex= "1";
			pageSize = "1000";
		}
		ArrayResultBuilder<LabReport> builder = ArrayResultBuilder.newArrayResult(LabReport.class);
		ArrayResult<LabReport> rs = null;
		SingleResult<String> rsFunFlag = paramsSetService.searchFunFlagByKey(ParameterUtils.LAB_READ_FROM_VIEW_KEY);
		if(null != rsFunFlag 
				&&  null != rsFunFlag.getData()
				&& rsFunFlag.getData().equalsIgnoreCase("1")
		)
		{
			SingleResult<Map> rsMapParam = paramsSetService.searchByCode(SysFunctionCode.DATA_SOURCE);
			if(null != rsMapParam && null != rsMapParam.getData() && rsMapParam.getData().containsKey("ASS_JY")){
				String value = rsMapParam.getData().get("ASS_JY").toString();
				log.debug(value);
				if(value.equalsIgnoreCase(ParameterUtils.ASS_DS_ENPK_DIRECT)){
					rs = labReportService.searchForCis(enPk, currentPageIndex, pageSize);
				}else if(value.equalsIgnoreCase(ParameterUtils.ASS_DS_ENPK_SPLIT)){
					String pk_enc = enPk ;
					if(enPk.indexOf("_") == -1){
						MrAmr mrAmr = mrAmrDao.selectById(enPk);
						if(mrAmr.getEnTpCd().equalsIgnoreCase(EncounterType.INPATIENT)){
							pk_enc = mrAmr.getAmrNo()+"_"+mrAmr.getEnCnt();
						}else{
							pk_enc = mrAmr.getPaId()+"_"+mrAmr.getEnCnt();
						}
					}
					rs = labReportService.search(pk_enc, currentPageIndex, pageSize);
				}else if(value.equalsIgnoreCase(ParameterUtils.ASS_DS_TOCIS)){
					MrAmr mrAmr = mrAmrDao.selectById(enPk);
					String pk_enc = mrAmr.getPaId()+"_"+mrAmr.getEnCnt();
					rs = labReportService.search(pk_enc, currentPageIndex, pageSize);
				}else if(value.equalsIgnoreCase(ParameterUtils.ASS_DS_IEREST)){
					rs = labReportFromIEService.search(enPk, currentPageIndex, pageSize);
				}
			}else{
				if(null == rsMapParam ){
					log.info("数据库参数配置中,读取code为SYSM01.16的参数，不存在");
				}else if (null == rsMapParam.getData()){
					log.info("数据库参数配置中,读取code为SYSM01.16的参数，第一条为null");
				} else if(!rsMapParam.getData().containsKey("ASS_JY")){
					log.info("数据库参数配置中,读取code为SYSM01.16的参数，不包含key为ASS_JY的记录");
				}else{
					log.info("数据库参数配置中,读取code为SYSM01.16的参数，key为ASS_JY，value为"+rsMapParam.getData().get("ASS_JY").toString()+"。");
				}
			}
		}else{
			if(null == rsFunFlag){
				log.info("数据库参数配置中未配置“从视图中读取检验报告”");
			}else if(null == rsFunFlag.getData()){
				log.info("数据库参数配置中未配置“从视图中读取检验报告”");
			}else{
				 log.info("数据库参数配置中“从视图中读取检验报告”的值为"+rsFunFlag.getData()+"。");
			}

		}
		if(null == rs){
			rs = builder.build() ;
			rs.setTotal(0);
		}
		return rs;
	}

}
