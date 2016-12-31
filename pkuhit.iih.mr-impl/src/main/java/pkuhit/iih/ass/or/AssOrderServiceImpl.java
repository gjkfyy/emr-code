package pkuhit.iih.ass.or;

import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import pkuhit.iih.en.md.EncounterType;
import pkuhit.iih.mr.wr.Amr;
import pkuhit.iih.mr.wr.AmrService;
import pkuhit.iih.or.OrderModel;
import pkuhit.md.SysFunctionCode;
import pkuhit.utils.ParameterUtils;
import pkuhit.xap.pm.ParamsSetService;
import xap.sv.annotation.Reference;
import xap.sv.model.ArrayResult;
import xap.sv.model.ArrayResultBuilder;
import xap.sv.model.SingleResult;
import xap.sv.model.SingleResultBuilder;
import ei.ass.or.mz.service.MzDirectOrderService;
import ei.ass.or.mz.service.MzSplitOrderService;
import ei.ass.or.zy.service.ZyDirectOrderService;
import ei.ass.or.zy.service.ZySplitOrderService;
/**
 * @author guo_zhongbao
 *
 */
public class AssOrderServiceImpl implements AssOrderService{

	private Logger log = LoggerFactory.getLogger(AssOrderServiceImpl.class);
	@Autowired
	AmrService amrService;
	@Reference
	ParamsSetService paramsSetService;
	
	@Reference
	MzDirectOrderService mzDirectOrderService;
	@Reference
	MzSplitOrderService mzSplitOrderService;
	@Reference
	ZyDirectOrderService zyDirectOrderService;
	@Reference
	ZySplitOrderService zySplitOrderService;

	
	@Override
	public SingleResult<OrderModel> search(String orPk, String enTypeCode) {
		SingleResultBuilder<OrderModel> builder = SingleResultBuilder.newSingleResult(OrderModel.class);
		SingleResult<OrderModel> rs = null;
		if(!StringUtils.isBlank(orPk)){
					log.debug("EncounterType is:"+enTypeCode);
					if(EncounterType.OUTPATIENT.equalsIgnoreCase(enTypeCode)
						|| EncounterType.EMERGENCY.equalsIgnoreCase(enTypeCode)
					 ){
						//门诊 急诊
						SingleResult<Map> rsMapParam = paramsSetService.searchByCode(SysFunctionCode.DATA_SOURCE);
						if(null != rsMapParam && null != rsMapParam.getData() && rsMapParam.getData().containsKey("ASS_OR_MZ")){
							String value = rsMapParam.getData().get("ASS_OR_MZ").toString();
							log.debug("ASS_OR_MZ is:"+value);
							if(ParameterUtils.ASS_DS_ENPK_DIRECT.equalsIgnoreCase(value)){
								rs = mzDirectOrderService.search(orPk);
							}else if(ParameterUtils.ASS_DS_ENPK_SPLIT.equalsIgnoreCase(value)){
									rs = mzSplitOrderService.search(orPk);
								}
						}else{
								if(null == rsMapParam ){
									log.info("数据库参数配置中,读取code为SYSM01.16的参数，不存在");
								}else if (null == rsMapParam.getData()){
									log.info("数据库参数配置中,读取code为SYSM01.16的参数，第一条为null");
								} else if(!rsMapParam.getData().containsKey("ASS_OR_MZ")){
									log.info("数据库参数配置中,读取code为SYSM01.16的参数，不包含key为ASS_OR_MZ的记录");
								}else{
									log.info("数据库参数配置中,读取code为SYSM01.16的参数，配置不正确，key为ASS_OR_MZ，value为"+rsMapParam.getData().get("ASS_OR_MZ").toString()+"。");
								}
							}
					}
					else if(EncounterType.INPATIENT.equalsIgnoreCase(enTypeCode)){
							//住院
						SingleResult<Map> rsMapParam = paramsSetService.searchByCode(SysFunctionCode.DATA_SOURCE);
						if(null != rsMapParam && null != rsMapParam.getData() && rsMapParam.getData().containsKey("ASS_OR_ZY")){
							String value = rsMapParam.getData().get("ASS_OR_ZY").toString();
							log.debug("ASS_OR_ZY is:"+value);	
							if(ParameterUtils.ASS_DS_ENPK_DIRECT.equalsIgnoreCase(value)){
								rs = zyDirectOrderService.search(orPk);
							}else if(ParameterUtils.ASS_DS_ENPK_SPLIT.equalsIgnoreCase(value)){
									rs = zySplitOrderService.search(orPk);
								}
						}else{
								if(null == rsMapParam ){
									log.info("数据库参数配置中,读取code为SYSM01.16的参数，不存在");
								}else if (null == rsMapParam.getData()){
									log.info("数据库参数配置中,读取code为SYSM01.16的参数，第一条为null");
								} else if(!rsMapParam.getData().containsKey("ASS_OR_ZY")){
									log.info("数据库参数配置中,读取code为SYSM01.16的参数，不包含key为ASS_OR_ZY的记录");
								}else{
									log.info("数据库参数配置中,读取code为SYSM01.16的参数，配置不正确，key为ASS_OR_ZY，value为"+rsMapParam.getData().get("ASS_OR_ZY").toString()+"。");
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
	public ArrayResult<OrderModel> search(String enPk, String longOrF,
			String enTypeCode,String orTpNm,String svNm, String currentPageIndex, String pageSize) {
		// TODO Auto-generated method stub
		ArrayResultBuilder<OrderModel> builder = ArrayResultBuilder.newArrayResult(OrderModel.class);
		ArrayResult<OrderModel> rs = null;
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
						if(null != rsMapParam && null != rsMapParam.getData() && rsMapParam.getData().containsKey("ASS_OR_MZ")){
							String value = rsMapParam.getData().get("ASS_OR_MZ").toString();
							log.debug("ASS_OR_MZ is:"+value);
							if(ParameterUtils.ASS_DS_ENPK_DIRECT.equalsIgnoreCase(value)){
								rs = mzDirectOrderService.search(enPk, longOrF, enTypeCode, currentPageIndex, pageSize);
							}else if(ParameterUtils.ASS_DS_ENPK_SPLIT.equalsIgnoreCase(value)){
								String[] arr = ParameterUtils.splitEnPk(enPk);
								if(null!= arr && !StringUtils.isBlank(arr[0]) && !StringUtils.isBlank(arr[1])){
									rs = mzSplitOrderService.search(arr[0], arr[1], longOrF, enTypeCode,currentPageIndex, pageSize);
								}
							}
						}else{
							if(null == rsMapParam ){
								log.info("数据库参数配置中,读取code为SYSM01.16的参数，不存在");
							}else if (null == rsMapParam.getData()){
								log.info("数据库参数配置中,读取code为SYSM01.16的参数，第一条为null");
							} else if(!rsMapParam.getData().containsKey("ASS_OR_MZ")){
								log.info("数据库参数配置中,读取code为SYSM01.16的参数，不包含key为ASS_OR_MZ的记录");
							}else{
								log.info("数据库参数配置中,读取code为SYSM01.16的参数，key为ASS_OR_MZ，value为"+rsMapParam.getData().get("ASS_OR_MZ").toString()+"。");
							}
						}
					}
					else if(EncounterType.INPATIENT.equalsIgnoreCase(mrAmr.getEncounterTypeCode())){
							//住院
						SingleResult<Map> rsMapParam = paramsSetService.searchByCode(SysFunctionCode.DATA_SOURCE);
						if(null != rsMapParam && null != rsMapParam.getData() && rsMapParam.getData().containsKey("ASS_OR_ZY")){
							String value = rsMapParam.getData().get("ASS_OR_ZY").toString();
							log.debug("ASS_OR_ZY is:"+value);	
							if(ParameterUtils.ASS_DS_ENPK_DIRECT.equalsIgnoreCase(value)){
								rs = zyDirectOrderService.search(enPk, longOrF, enTypeCode,orTpNm,svNm, currentPageIndex, pageSize);
							}else if(ParameterUtils.ASS_DS_ENPK_SPLIT.equalsIgnoreCase(value)){
								String[] arr = ParameterUtils.splitEnPk(enPk);
								if(null!= arr && !StringUtils.isBlank(arr[0]) && !StringUtils.isBlank(arr[1])){
									rs = zySplitOrderService.search(arr[0], arr[1], longOrF, enTypeCode,orTpNm,svNm, currentPageIndex, pageSize);
								}
							}
						}else{
							if(null == rsMapParam ){
								log.info("数据库参数配置中,读取code为SYSM01.16的参数，不存在");
							}else if (null == rsMapParam.getData()){
								log.info("数据库参数配置中,读取code为SYSM01.16的参数，第一条为null");
							} else if(!rsMapParam.getData().containsKey("ASS_OR_ZY")){
								log.info("数据库参数配置中,读取code为SYSM01.16的参数，不包含key为ASS_OR_ZY的记录");
							}else{
								log.info("数据库参数配置中,读取code为SYSM01.16的参数，key为ASS_OR_ZY，value为"+rsMapParam.getData().get("ASS_OR_ZY").toString()+"。");
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
			}
		}else{
			log.info("enPk  is Blank");	
			rs = builder.build();
		}
		if(null == rs){
			rs = builder.build();
			rs.setTotal(0);
		}
		return rs;
	}

}
