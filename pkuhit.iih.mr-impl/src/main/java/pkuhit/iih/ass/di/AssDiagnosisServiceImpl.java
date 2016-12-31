package pkuhit.iih.ass.di;

import iih.di.service.intf.DiService;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import pkuhit.iih.di.DiInService;
import pkuhit.iih.di.DiagnosisModel;
import pkuhit.iih.di.his.HisDiagnosisListModel;
import pkuhit.iih.en.md.EncounterType;
import pkuhit.iih.mr.wr.Amr;
import pkuhit.iih.mr.wr.AmrService;
import pkuhit.md.SysFunctionCode;
import pkuhit.utils.ParameterUtils;
import pkuhit.xap.pm.ParamsSetService;
import xap.sv.annotation.Reference;
import xap.sv.model.ArrayResult;
import xap.sv.model.ArrayResultBuilder;
import xap.sv.model.SingleResult;
import xap.sv.model.SingleResultBuilder;
import ei.ass.di.mz.service.MzDirectDiagnosisService;
import ei.ass.di.mz.service.MzSplitDiagnosisService;
import ei.ass.di.zy.service.ZyDirectDiagnosisService;
import ei.ass.di.zy.service.ZySplitDiagnosisService;

/**
 * @author guo_zhongbao
 *
 */
public class AssDiagnosisServiceImpl implements AssDiagnosisService {
	private Logger log = LoggerFactory.getLogger(AssDiagnosisServiceImpl.class);
	@Autowired
	DiInService diInService;
	@Autowired
	AmrService amrService;
	@Reference
	ParamsSetService paramsSetService;
	@Reference
	DiService localDiService ;
	@Reference
	MzDirectDiagnosisService mzDirectDiagnosisService;
	@Reference
	MzSplitDiagnosisService mzSplitDiagnosisService;
	@Reference
	ZyDirectDiagnosisService zyDirectDiagnosisService;
	@Reference
	ZySplitDiagnosisService zySplitDiagnosisService;

	/* (non-Javadoc)
	 * @see pkuhit.iih.ass.di.AssDiagnosisService#search(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public ArrayResult<DiagnosisModel> search(String enPk, String isMainF,
			String onlyNotStop, String currentPageIndex, String pageSize) {
		ArrayResultBuilder<DiagnosisModel> builder = ArrayResultBuilder.newArrayResult(DiagnosisModel.class);
		ArrayResult<DiagnosisModel> rs = null;
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
						if(null != rsMapParam && null != rsMapParam.getData() && rsMapParam.getData().containsKey("ASS_DI_MZ")){
							String value = rsMapParam.getData().get("ASS_DI_MZ").toString();
							log.debug("ASS_DI_MZ is:"+value);
							if(ParameterUtils.ASS_DS_LOCAL.equalsIgnoreCase(value)){
								Map paramMap = new HashMap();
								paramMap.put("isMainF", isMainF);
								rs = localDiService.getDisListByEnSn(enPk,  paramMap);
							}else if(ParameterUtils.ASS_DS_ENPK_DIRECT.equalsIgnoreCase(value)){
								rs = mzDirectDiagnosisService.search(enPk, isMainF, onlyNotStop, currentPageIndex, pageSize);
							}else if(ParameterUtils.ASS_DS_ENPK_SPLIT.equalsIgnoreCase(value)){
								String[] arr = ParameterUtils.splitEnPk(enPk);
								if(null!= arr && !StringUtils.isBlank(arr[0]) && !StringUtils.isBlank(arr[1])){
									rs = mzSplitDiagnosisService.search(arr[0], arr[1], isMainF, onlyNotStop, currentPageIndex, pageSize);
								}
							}
						}else{
							if(null == rsMapParam ){
								log.info("数据库参数配置中,读取code为SYSM01.16的参数，不存在");
							}else if (null == rsMapParam.getData()){
								log.info("数据库参数配置中,读取code为SYSM01.16的参数，第一条为null");
							} else if(!rsMapParam.getData().containsKey("ASS_DI_MZ")){
								log.info("数据库参数配置中,读取code为SYSM01.16的参数，不包含key为ASS_DI_MZ的记录");
							}else{
								log.info("数据库参数配置中,读取code为SYSM01.16的参数，配置不正确，key为ASS_DI_MZ，value为"+rsMapParam.getData().get("ASS_DI_MZ").toString()+"。");
							}
						}
					}
					else if(EncounterType.INPATIENT.equalsIgnoreCase(mrAmr.getEncounterTypeCode())){
							//住院
						SingleResult<Map> rsMapParam = paramsSetService.searchByCode(SysFunctionCode.DATA_SOURCE);
						if(null != rsMapParam && null != rsMapParam.getData() && rsMapParam.getData().containsKey("ASS_DI_ZY")){
							String value = rsMapParam.getData().get("ASS_DI_ZY").toString();
							log.debug("ASS_DI_ZY is:"+value);	
							if(ParameterUtils.ASS_DS_LOCAL.equalsIgnoreCase(value)){
								Map map = new HashMap();
								rs  = diInService.getDiInsListByEnSn(enPk,map);
							}else if(ParameterUtils.ASS_DS_ENPK_DIRECT.equalsIgnoreCase(value)){
								rs = zyDirectDiagnosisService.search(enPk, isMainF, onlyNotStop, currentPageIndex, pageSize);
							}else if(ParameterUtils.ASS_DS_ENPK_SPLIT.equalsIgnoreCase(value)){
								String[] arr = ParameterUtils.splitEnPk(enPk);
								if(null!= arr && !StringUtils.isBlank(arr[0]) && !StringUtils.isBlank(arr[1])){
									rs = zySplitDiagnosisService.search(arr[0], arr[1], isMainF, onlyNotStop, currentPageIndex, pageSize);
								}
							}
						}else{
							if(null == rsMapParam ){
								log.info("数据库参数配置中,读取code为SYSM01.16的参数，不存在");
							}else if (null == rsMapParam.getData()){
								log.info("数据库参数配置中,读取code为SYSM01.16的参数，第一条为null");
							} else if(!rsMapParam.getData().containsKey("ASS_DI_ZY")){
								log.info("数据库参数配置中,读取code为SYSM01.16的参数，不包含key为ASS_DI_ZY的记录");
							}else{
								log.info("数据库参数配置中,读取code为SYSM01.16的参数，配置不正确，key为ASS_DI_ZY，value为"+rsMapParam.getData().get("ASS_DI_ZY").toString()+"。");
							}
						}
					}
				}else{
					log.info("mrAmrRs.getData()  is null");	
				}
			}
			catch(Throwable ex){
				ex.printStackTrace();
			}
		}else{
			log.info("enPk  is Blank");	
		}
		if(null == rs){
			rs = builder.build();
		}
		return rs;
	}

	/* (non-Javadoc)
	 * @see pkuhit.iih.ass.di.AssDiagnosisService#search(java.lang.String)
	 */
	@Override
	public SingleResult<DiagnosisModel> search(String diPk,String enTypeCode) {
		SingleResultBuilder<DiagnosisModel> builder = SingleResultBuilder.newSingleResult(DiagnosisModel.class);
		SingleResult<DiagnosisModel> rs = null;
		if(!StringUtils.isBlank(diPk)){
					log.debug("EncounterType is:"+enTypeCode);
					if(EncounterType.OUTPATIENT.equalsIgnoreCase(enTypeCode)
						|| EncounterType.EMERGENCY.equalsIgnoreCase(enTypeCode)
					 ){
						//门诊 急诊
						SingleResult<Map> rsMapParam = paramsSetService.searchByCode(SysFunctionCode.DATA_SOURCE);
						if(null != rsMapParam && null != rsMapParam.getData() && rsMapParam.getData().containsKey("ASS_DI_MZ")){
							String value = rsMapParam.getData().get("ASS_DI_MZ").toString();
							log.debug("ASS_DI_MZ is:"+value);
							if(ParameterUtils.ASS_DS_ENPK_DIRECT.equalsIgnoreCase(value)){
								rs = mzDirectDiagnosisService.search(diPk);
							}else if(ParameterUtils.ASS_DS_ENPK_SPLIT.equalsIgnoreCase(value)){
									rs = mzSplitDiagnosisService.search(diPk);
								}
							}
					}
					else if(EncounterType.INPATIENT.equalsIgnoreCase(enTypeCode)){
							//住院
						SingleResult<Map> rsMapParam = paramsSetService.searchByCode(SysFunctionCode.DATA_SOURCE);
						if(null != rsMapParam && null != rsMapParam.getData() && rsMapParam.getData().containsKey("ASS_DI_ZY")){
							String value = rsMapParam.getData().get("ASS_DI_ZY").toString();
							log.debug("ASS_DI_ZY is:"+value);	
							if(ParameterUtils.ASS_DS_ENPK_DIRECT.equalsIgnoreCase(value)){
								rs = zyDirectDiagnosisService.search(diPk);
							}else if(ParameterUtils.ASS_DS_ENPK_SPLIT.equalsIgnoreCase(value)){
									rs = zySplitDiagnosisService.search(diPk);
								}
							}
					}
		
		}else{
			log.info("enPk  is Blank");	
			rs = builder.build();
		}
		return rs;
	
	}

	/* (non-Javadoc)
	 * @see pkuhit.iih.ass.di.AssDiagnosisService#saveOrUpdateDiagnosis(pkuhit.iih.di.his.HisDiagnosisListModel, java.lang.String, java.lang.String)
	 */
	@Override
	public void saveOrUpdateDiagnosis(HisDiagnosisListModel list,
			String patient_id, String times) {
		mzSplitDiagnosisService.saveOrUpdateDiagnosis(list, patient_id, times);
	}

	/* (non-Javadoc)
	 * @see pkuhit.iih.ass.di.AssDiagnosisService#delDiagnosis(java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public void delDiagnosis(String delDiCode, String mainDiCode,
			String patient_id, String times) {
		mzSplitDiagnosisService.delDiagnosis(delDiCode, mainDiCode, patient_id, times);
	}
	
	
}
