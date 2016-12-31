package pkuhit.iih.ass.nu;

import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import pkuhit.iih.en.md.EncounterType;
import pkuhit.iih.mr.wr.Amr;
import pkuhit.iih.mr.wr.AmrService;
import pkuhit.iih.nu.Vitalsign;
import pkuhit.md.SysFunctionCode;
import pkuhit.utils.ParameterUtils;
import pkuhit.xap.pm.ParamsSetService;
import xap.sv.annotation.Reference;
import xap.sv.model.ArrayResult;
import xap.sv.model.ArrayResultBuilder;
import xap.sv.model.SingleResult;
import xap.sv.model.SingleResultBuilder;
import ei.ass.nu.mz.service.MzDirectVitalsignService;
import ei.ass.nu.mz.service.MzSplitVitalsignService;
import ei.ass.nu.zy.service.ZyDirectVitalsignService;
import ei.ass.nu.zy.service.ZySplitVitalsignService;

public class AssVitalsignServiceImpl implements AssVitalsignService {

	private Logger log = LoggerFactory.getLogger(AssVitalsignServiceImpl.class);
	@Autowired
	AmrService amrService;
	@Reference
	ParamsSetService paramsSetService;
	
	@Reference
	MzDirectVitalsignService mzDirectVitalsignService;
	@Reference
	MzSplitVitalsignService mzSplitVitalsignService;
	@Reference
	ZyDirectVitalsignService zyDirectVitalsignService;
	@Reference
	ZySplitVitalsignService zySplitVitalsignService;
	@Override
	public SingleResult<Vitalsign> searchRecodeForMacro(String enPk) {

		SingleResultBuilder<Vitalsign> builder = SingleResultBuilder.newSingleResult(Vitalsign.class);
		SingleResult<Vitalsign> rs = null;
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
						if(null != rsMapParam && null != rsMapParam.getData() && rsMapParam.getData().containsKey("ASS_NU_MZ")){
							String value = rsMapParam.getData().get("ASS_NU_MZ").toString();
							log.debug("ASS_NU_MZ is:"+value);
							if(ParameterUtils.ASS_DS_ENPK_DIRECT.equalsIgnoreCase(value)){
								rs = mzDirectVitalsignService.searchRecodeForMacro(enPk);
							}else if(ParameterUtils.ASS_DS_ENPK_SPLIT.equalsIgnoreCase(value)){
								String[] arr = ParameterUtils.splitEnPk(enPk);
								if(null!= arr && !StringUtils.isBlank(arr[0]) && !StringUtils.isBlank(arr[1])){
									rs = mzSplitVitalsignService.searchRecodeForMacro(arr[0], arr[1]);
								}
							}
						}else{
							if(null == rsMapParam ){
								log.info("数据库参数配置中,读取code为SYSM01.16的参数，不存在");
							}else if (null == rsMapParam.getData()){
								log.info("数据库参数配置中,读取code为SYSM01.16的参数，第一条为null");
							} else if(!rsMapParam.getData().containsKey("ASS_NU_MZ")){
								log.info("数据库参数配置中,读取code为SYSM01.16的参数，不包含key为ASS_NU_MZ的记录");
							}else{
								log.info("数据库参数配置中,读取code为SYSM01.16的参数，配置不正确，key为ASS_NU_MZ，value为"+rsMapParam.getData().get("ASS_NU_MZ").toString()+"。");
							}
						}
					}
					else if(EncounterType.INPATIENT.equalsIgnoreCase(mrAmr.getEncounterTypeCode())){
							//住院
						SingleResult<Map> rsMapParam = paramsSetService.searchByCode(SysFunctionCode.DATA_SOURCE);
						if(null != rsMapParam && null != rsMapParam.getData() && rsMapParam.getData().containsKey("ASS_NU_ZY")){
							String value = rsMapParam.getData().get("ASS_NU_ZY").toString();
							log.debug("ASS_NU_ZY is:"+value);	
							if(ParameterUtils.ASS_DS_ENPK_DIRECT.equalsIgnoreCase(value)){
								rs = zyDirectVitalsignService.searchRecodeForMacro(enPk);
							}else if(ParameterUtils.ASS_DS_ENPK_SPLIT.equalsIgnoreCase(value)){
								String[] arr = ParameterUtils.splitEnPk(enPk);
								if(null!= arr && !StringUtils.isBlank(arr[0]) && !StringUtils.isBlank(arr[1])){
									rs = zySplitVitalsignService.searchRecodeForMacro(arr[0], arr[1]);
								}
							}
						}else{
							if(null == rsMapParam ){
								log.info("数据库参数配置中,读取code为SYSM01.16的参数，不存在");
							}else if (null == rsMapParam.getData()){
								log.info("数据库参数配置中,读取code为SYSM01.16的参数，第一条为null");
							} else if(!rsMapParam.getData().containsKey("ASS_NU_ZY")){
								log.info("数据库参数配置中,读取code为SYSM01.16的参数，不包含key为ASS_NU_ZY的记录");
							}else{
								log.info("数据库参数配置中,读取code为SYSM01.16的参数，配置不正确，key为ASS_NU_ZY，value为"+rsMapParam.getData().get("ASS_NU_ZY").toString()+"。");
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

	@Override
	public SingleResult<Vitalsign> search(String vitalSignPk,String enTypeCode) {
		SingleResultBuilder<Vitalsign> builder = SingleResultBuilder.newSingleResult(Vitalsign.class);
		SingleResult<Vitalsign> rs = null;
		if(!StringUtils.isBlank(vitalSignPk)){
					log.debug("EncounterType is:"+enTypeCode);
					if(EncounterType.OUTPATIENT.equalsIgnoreCase(enTypeCode)
						|| EncounterType.EMERGENCY.equalsIgnoreCase(enTypeCode)
					 ){
						//门诊 急诊
						SingleResult<Map> rsMapParam = paramsSetService.searchByCode(SysFunctionCode.DATA_SOURCE);
						if(null != rsMapParam && null != rsMapParam.getData() && rsMapParam.getData().containsKey("ASS_NU_MZ")){
							String value = rsMapParam.getData().get("ASS_NU_MZ").toString();
							log.debug("ASS_NU_MZ is:"+value);
							if(ParameterUtils.ASS_DS_ENPK_DIRECT.equalsIgnoreCase(value)){
								rs = mzDirectVitalsignService.search(vitalSignPk);
							}else if(ParameterUtils.ASS_DS_ENPK_SPLIT.equalsIgnoreCase(value)){
									rs = mzSplitVitalsignService.search(vitalSignPk);
								}
							}
					}
					else if(EncounterType.INPATIENT.equalsIgnoreCase(enTypeCode)){
							//住院
						SingleResult<Map> rsMapParam = paramsSetService.searchByCode(SysFunctionCode.DATA_SOURCE);
						if(null != rsMapParam && null != rsMapParam.getData() && rsMapParam.getData().containsKey("ASS_NU_ZY")){
							String value = rsMapParam.getData().get("ASS_NU_ZY").toString();
							log.debug("ASS_NU_ZY is:"+value);	
							if(ParameterUtils.ASS_DS_ENPK_DIRECT.equalsIgnoreCase(value)){
								rs = zyDirectVitalsignService.search(vitalSignPk);
							}else if(ParameterUtils.ASS_DS_ENPK_SPLIT.equalsIgnoreCase(value)){
									rs = zySplitVitalsignService.search(vitalSignPk);
								}
							}
					}
		
		}else{
			log.info("enPk  is Blank");	
			rs = builder.build();
		}
		return rs;
	}

	@Override
	public ArrayResult<Vitalsign> search(String enPk,
			String acquisitionStartTime, String acquisitionStopTime,
			String currentPageIndex, String pageSize) {
		ArrayResultBuilder<Vitalsign> builder = ArrayResultBuilder.newArrayResult(Vitalsign.class);
		ArrayResult<Vitalsign> rs = null;
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
						if(null != rsMapParam && null != rsMapParam.getData() && rsMapParam.getData().containsKey("ASS_NU_MZ")){
							String value = rsMapParam.getData().get("ASS_NU_MZ").toString();
							log.debug("ASS_NU_MZ is:"+value);
							if(ParameterUtils.ASS_DS_ENPK_DIRECT.equalsIgnoreCase(value)){
								rs = mzDirectVitalsignService.search(enPk, acquisitionStartTime, acquisitionStopTime, currentPageIndex, pageSize);
							}else if(ParameterUtils.ASS_DS_ENPK_SPLIT.equalsIgnoreCase(value)){
								String[] arr = ParameterUtils.splitEnPk(enPk);
								if(null!= arr && !StringUtils.isBlank(arr[0]) && !StringUtils.isBlank(arr[1])){
									rs = mzSplitVitalsignService.search(arr[0], arr[1], acquisitionStartTime, acquisitionStopTime, currentPageIndex, pageSize);
								}
							}
						}else{
							if(null == rsMapParam ){
								log.info("数据库参数配置中,读取code为SYSM01.16的参数，不存在");
							}else if (null == rsMapParam.getData()){
								log.info("数据库参数配置中,读取code为SYSM01.16的参数，第一条为null");
							} else if(!rsMapParam.getData().containsKey("ASS_NU_MZ")){
								log.info("数据库参数配置中,读取code为SYSM01.16的参数，不包含key为ASS_NU_MZ的记录");
							}else{
								log.info("数据库参数配置中,读取code为SYSM01.16的参数，配置不正确，key为ASS_NU_MZ，value为"+rsMapParam.getData().get("ASS_NU_MZ").toString()+"。");
							}
						}
					}
					else if(EncounterType.INPATIENT.equalsIgnoreCase(mrAmr.getEncounterTypeCode())){
							//住院
						SingleResult<Map> rsMapParam = paramsSetService.searchByCode(SysFunctionCode.DATA_SOURCE);
						if(null != rsMapParam && null != rsMapParam.getData() && rsMapParam.getData().containsKey("ASS_NU_ZY")){
							String value = rsMapParam.getData().get("ASS_NU_ZY").toString();
							log.debug("ASS_NU_ZY is:"+value);	
							if(ParameterUtils.ASS_DS_ENPK_DIRECT.equalsIgnoreCase(value)){
								rs = zyDirectVitalsignService.search(enPk, acquisitionStartTime, acquisitionStopTime, currentPageIndex, pageSize);
							}else if(ParameterUtils.ASS_DS_ENPK_SPLIT.equalsIgnoreCase(value)){
								String[] arr = ParameterUtils.splitEnPk(enPk);
								if(null!= arr && !StringUtils.isBlank(arr[0]) && !StringUtils.isBlank(arr[1])){
									rs = zySplitVitalsignService.search(arr[0], arr[1], acquisitionStartTime, acquisitionStopTime, currentPageIndex, pageSize);
								}
							}
						}else{
							if(null == rsMapParam ){
								log.info("数据库参数配置中,读取code为SYSM01.16的参数，不存在");
							}else if (null == rsMapParam.getData()){
								log.info("数据库参数配置中,读取code为SYSM01.16的参数，第一条为null");
							} else if(!rsMapParam.getData().containsKey("ASS_NU_ZY")){
								log.info("数据库参数配置中,读取code为SYSM01.16的参数，不包含key为ASS_NU_ZY的记录");
							}else{
								log.info("数据库参数配置中,读取code为SYSM01.16的参数，配置不正确，key为ASS_NU_ZY，value为"+rsMapParam.getData().get("ASS_NU_ZY").toString()+"。");
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

}
