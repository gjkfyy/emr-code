package pkuhit.iih.ass.ob;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.seasar.doma.jdbc.SelectOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import pkuhit.iih.en.md.EncounterType;
import pkuhit.iih.mr.dao.auto.MrAmrDao;
import pkuhit.iih.mr.dao.auto.entity.MrAmr;
import pkuhit.iih.mr.dao.auto.entity.ObsReportCollectEntity;
import pkuhit.iih.mr.dao.custom.CusObserveReportCollect;
import pkuhit.iih.mr.wr.Amr;
import pkuhit.iih.mr.wr.AmrService;
import pkuhit.md.SysFunctionCode;
import pkuhit.utils.ParameterUtils;
import pkuhit.xap.ass.ObsReport;
import pkuhit.xap.pm.ParamsService;
import pkuhit.xap.pm.ParamsSetService;
import xap.sv.annotation.Reference;
import xap.sv.model.ArrayResult;
import xap.sv.model.ArrayResultBuilder;
import xap.sv.model.SingleResult;
import xap.sv.model.SingleResultBuilder;
import ei.cis.service.CisService;
import ei.ris.service.RisObReportFromIEService;
import ei.ris.service.RisObReportService;

/**
 * @author guo_zhongbao
 * 检查服务
 */
public class ObsServiceImpl implements ObsService {
	private Logger log = LoggerFactory.getLogger(ObsServiceImpl.class);
	@Reference
	ParamsService paramsService;
	@Autowired
	AmrService amrService;
	@Reference
	RisObReportService risObReportService;
	
	@Reference
	RisObReportFromIEService risObReportFromIEService;
	
	@Reference
	CisService cisService;
	@Reference
	ParamsSetService paramsSetService;
	@Autowired
	CusObserveReportCollect localdao;
	
	@Autowired
	MrAmrDao mrAmrDao;
	/* (non-Javadoc)
	 * @see pkuhit.iih.or.ObsService#search(java.lang.String)
	 */
	@Override
	public SingleResult<ObsReport> search(String obRpPk) {
		SingleResultBuilder<ObsReport> builder = SingleResultBuilder.newSingleResult(ObsReport.class);
		
		return builder.build();
	}

	/* (non-Javadoc)
	 * @see pkuhit.iih.or.ObsService#search(java.util.Map)
	 */
	@Override
	public ArrayResult<ObsReport> search(String enPk, String currentPageIndex,String pageSize) {
		if(null == currentPageIndex || !StringUtils.isNumeric(currentPageIndex)   || null == pageSize || !StringUtils.isNumeric(pageSize)  )
		{
			currentPageIndex= "1";
			pageSize = "1000";
		}
		ArrayResultBuilder<ObsReport> builder = ArrayResultBuilder.newArrayResult(ObsReport.class);
		ArrayResult<ObsReport> rs = null;
		SingleResult<String> rsFunFlag = paramsSetService.searchFunFlagByKey(ParameterUtils.OB_READ_FROM_VIEW_KEY);
		if(null != rsFunFlag 
				&&  null != rsFunFlag.getData()
				&& rsFunFlag.getData().equalsIgnoreCase("1")
		)
		{
			if(!StringUtils.isBlank(enPk)){
				try{
					SingleResult<Amr> mrAmrRs = amrService.getAmr(enPk);
					if(null!=mrAmrRs.getData()){
						Amr mrAmr = mrAmrRs.getData();
						log.debug("EncounterType is:"+mrAmr.getEncounterTypeCode());
						if(EncounterType.OUTPATIENT.equalsIgnoreCase(mrAmr.getEncounterTypeCode())
							|| EncounterType.EMERGENCY.equalsIgnoreCase(mrAmr.getEncounterTypeCode())
						 ){
							//门诊 急诊
							SingleResult<Map> rsMapParam = paramsSetService.searchByCode(SysFunctionCode.DATA_SOURCE);
							if(null != rsMapParam && null != rsMapParam.getData() && rsMapParam.getData().containsKey("ASS_JC_MZ")){
								String value = rsMapParam.getData().get("ASS_JC_MZ").toString();
								log.debug(value);
								if(value.equalsIgnoreCase(ParameterUtils.ASS_DS_ENPK_DIRECT)){
									rs = risObReportService.searchForCis(enPk,currentPageIndex,pageSize);
								}else if(value.equalsIgnoreCase(ParameterUtils.ASS_DS_ENPK_SPLIT)){
//									rs = risObReportService.search(enPk,currentPageIndex,pageSize);
									String pk_enc = enPk ;
									if(enPk.indexOf("_") == -1){
										MrAmr mrAmrOne = mrAmrDao.selectById(enPk);
										if(mrAmrOne.getEnTpCd().equalsIgnoreCase(EncounterType.INPATIENT)){
											pk_enc = mrAmrOne.getAmrNo()+"_"+mrAmrOne.getEnCnt();
										}else{
											pk_enc = mrAmrOne.getPaId()+"_"+mrAmrOne.getEnCnt();
										}
									}
									rs = risObReportService.search(pk_enc, currentPageIndex, pageSize);
								}else if(value.equalsIgnoreCase(ParameterUtils.ASS_DS_TOCIS)){
									rs = cisService.searchByObsOrder(enPk,currentPageIndex,pageSize);
								}else if(value.equalsIgnoreCase(ParameterUtils.ASS_DS_IEREST)){
									rs = risObReportFromIEService.search(enPk,currentPageIndex,pageSize);
								}else if(value.equalsIgnoreCase(ParameterUtils.ASS_DS_LOCAL)){
									rs =  this.searchFromLocal(enPk, currentPageIndex, pageSize);
								}
							}else{
								if(null == rsMapParam ){
									log.info("数据库参数配置中,读取code为SYSM01.16的参数，不存在");
								}else if (null == rsMapParam.getData()){
									log.info("数据库参数配置中,读取code为SYSM01.16的参数，第一条为null");
								} else if(!rsMapParam.getData().containsKey("ASS_JC_MZ")){
									log.info("数据库参数配置中,读取code为SYSM01.16的参数，不包含key为ASS_JC_MZ的记录");
								}else{
									log.info("数据库参数配置中,读取code为SYSM01.16的参数，key为ASS_JC_MZ，value为"+rsMapParam.getData().get("ASS_JC_MZ").toString()+"。");
								}
							}
						}else if(EncounterType.INPATIENT.equalsIgnoreCase(mrAmr.getEncounterTypeCode())){
							//住院
							SingleResult<Map> rsMapParam = paramsSetService.searchByCode(SysFunctionCode.DATA_SOURCE);
							if(null != rsMapParam && null != rsMapParam.getData() && rsMapParam.getData().containsKey("ASS_JC_ZY")){
								String value = rsMapParam.getData().get("ASS_JC_ZY").toString();
								log.debug(value);
								if(value.equalsIgnoreCase(ParameterUtils.ASS_DS_ENPK_DIRECT)){
									rs = risObReportService.searchForCis(enPk,currentPageIndex,pageSize);
								}else if(value.equalsIgnoreCase(ParameterUtils.ASS_DS_ENPK_SPLIT)){
//									rs = risObReportService.search(enPk,currentPageIndex,pageSize);
									String pk_enc = enPk ;
									if(enPk.indexOf("_") == -1){
										MrAmr mrAmrOne = mrAmrDao.selectById(enPk);
										if(mrAmrOne.getEnTpCd().equalsIgnoreCase(EncounterType.INPATIENT)){
											pk_enc = mrAmrOne.getAmrNo()+"_"+mrAmrOne.getEnCnt();
										}else{
											pk_enc = mrAmrOne.getPaId()+"_"+mrAmrOne.getEnCnt();
										}
									}
									rs = risObReportService.search(pk_enc, currentPageIndex, pageSize);
								}else if(value.equalsIgnoreCase(ParameterUtils.ASS_DS_TOCIS)){
									rs = cisService.searchByObsOrder(enPk,currentPageIndex,pageSize);
								}else if(value.equalsIgnoreCase(ParameterUtils.ASS_DS_IEREST)){
									rs = risObReportFromIEService.search(enPk,currentPageIndex,pageSize);
								}else if(value.equalsIgnoreCase(ParameterUtils.ASS_DS_LOCAL)){
									rs =  this.searchFromLocal(enPk, currentPageIndex, pageSize);
								}
							}else{
								if(null == rsMapParam ){
									log.info("数据库参数配置中,读取code为SYSM01.16的参数，不存在");
								}else if (null == rsMapParam.getData()){
									log.info("数据库参数配置中,读取code为SYSM01.16的参数，第一条为null");
								} else if(!rsMapParam.getData().containsKey("ASS_JC_ZY")){
									log.info("数据库参数配置中,读取code为SYSM01.16的参数，不包含key为ASS_JC_ZY的记录");
								}else{
									log.info("数据库参数配置中,读取code为SYSM01.16的参数，key为ASS_JC_ZY，value为"+rsMapParam.getData().get("ASS_JC_ZY").toString()+"。");
								}
							}
						}
					}else{
						log.info("mrAmrRs.getData()  is null");	
						rs = builder.build();
					}
				}
				catch(Throwable ex){
					ex.printStackTrace();
					rs = builder.build();
				}
			}else{
				log.info("enPk  is Blank");	
				rs = builder.build();
			}
		}else{
			if(null == rsFunFlag){
				log.info("数据库参数配置中未配置“从视图中读取检查报告”");
			}else if(null == rsFunFlag.getData()){
				log.info("数据库参数配置中未配置“从视图中读取检查报告”");
			}else{
				 log.info("数据库参数配置中“从视图中读取检查报告”的值为"+rsFunFlag.getData()+"。");
			}

		}
		if(null == rs ){
			rs = builder.build() ;
			rs.setTotal(0);
		}
		return rs;
	}
	@Override
    public ArrayResult<ObsReport> searchByObsOrder(String enPk, String currentPageIndex,
            String pageSize) {
    	//请配置查询方式为 toCis
    	return this.search(enPk, currentPageIndex, pageSize);
    }
	@Override
	public ArrayResult<ObsReport> searchFromLocal(String enPk, String currentPageIndex,String pageSize) {
        if(null == currentPageIndex || !StringUtils.isNumeric(currentPageIndex)   || null == pageSize || !StringUtils.isNumeric(pageSize)  )
        {
            currentPageIndex= "1";
            pageSize = "1000";
        }
        SelectOptions options = SelectOptions.get().offset((Integer.valueOf(currentPageIndex)-1)*Integer.valueOf(pageSize)).limit(Integer.valueOf(pageSize)).count();           
        List<ObsReportCollectEntity> poList = this.localdao.selectByEnpk(enPk, options);
        long count = options.getCount();
        int total = Long.valueOf(count).intValue();
        ObsReport[] voArray = null ;
        ArrayResultBuilder<ObsReport> builder = ArrayResultBuilder.newArrayResult(ObsReport.class);
        if(null != poList){
        	 voArray = new ObsReport[poList.size()];
             int i = 0;
             for(ObsReportCollectEntity po : poList){
                 ObsReport vo = new ObsReport();
                 BeanUtils.copyProperties( po,vo);
                 voArray[i]= vo;
                 i++;
             }
             builder.withData(voArray);
        }
        ArrayResult<ObsReport> rs = builder.build();
        rs.setTotal(total);
        return rs;
	}
}
