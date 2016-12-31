package ei.ass.nu.zy.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.seasar.doma.jdbc.SelectOptions;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import pkuhit.iih.nu.Vitalsign;
import pkuhit.xap.pm.ParamsSetService;
import xap.sv.annotation.Reference;
import xap.sv.model.ArrayResult;
import xap.sv.model.ArrayResultBuilder;
import xap.sv.model.SingleResult;
import xap.sv.model.SingleResultBuilder;
import ei.ass.nu.auto.po.VitalsignPo;
import ei.ass.nu.zy.dao.ZySplitVitalsignDao;
import ei.ass.nu.zy.service.ZySplitVitalsignService;

/**
 * @author guo_zhongbao
 *
 */
public class ZySplitVitalsignServiceImpl implements ZySplitVitalsignService {

	final String NU_READ_FROM_VIEW_KEY = "NU_READ_FROM_VIEW"; //从视图中读取检查报告
	
	@Reference
	ParamsSetService paramsSetService;
	
	@Autowired
	ZySplitVitalsignDao vitalsignDao;
	/* (non-Javadoc)
	 * @see pkuhit.iih.nu.VitalsignService#search(java.lang.String)
	 */
	@Override
	public SingleResult<Vitalsign> search(String vitalSignPk) {
		// TODO Auto-generated method stub
		VitalsignPo po = this.vitalsignDao.getAcquisitionListByVitalSignPk(vitalSignPk);
		Vitalsign vo = new Vitalsign();
		SingleResultBuilder<Vitalsign> builder = SingleResultBuilder.newSingleResult(Vitalsign.class);
		if(null != po){
			BeanUtils.copyProperties( po,vo);
			builder.withData(vo);
		}
		return builder.build();
	}

	/* (non-Javadoc)
	 * @see pkuhit.iih.nu.VitalsignService#search(java.util.Map)
	 */
	@Override
	public ArrayResult<Vitalsign> search(String patient_id,String times,String  acquisitionStartTime,String acquisitionStopTime,String currentPageIndex,String pageSize) {
		Vitalsign[] voArray = null ;
		if(null == currentPageIndex || !StringUtils.isNumeric(currentPageIndex)   || null == pageSize || !StringUtils.isNumeric(pageSize)  )
		{
			currentPageIndex= "1";
			pageSize = "1000";
		}
		ArrayResultBuilder<Vitalsign> builder = ArrayResultBuilder.newArrayResult(Vitalsign.class);
		int total = 0 ;
		SingleResult<String> rsFunFlag = paramsSetService.searchFunFlagByKey(NU_READ_FROM_VIEW_KEY);
		if(null != rsFunFlag 
					&&  null != rsFunFlag.getData()
					&& null != rsFunFlag.getData()
					&& rsFunFlag.getData().equalsIgnoreCase("1")
		)	
		{
			SelectOptions options = SelectOptions.get().offset((Integer.valueOf(currentPageIndex)-1)*Integer.valueOf(pageSize)).limit(Integer.valueOf(pageSize)).count();			
			List<VitalsignPo> poList = this.vitalsignDao.getAcquisitionListByEnSn(patient_id,times, acquisitionStartTime, acquisitionStopTime,"desc"/*,options*/);
			long count = options.getCount();
			total = Long.valueOf(count).intValue();
	
			if(null != poList){
				 voArray = new Vitalsign[poList.size()];
				 int i = 0;
				 for(VitalsignPo po : poList){
					 Vitalsign vo = new Vitalsign();
					 BeanUtils.copyProperties( po,vo);
					 voArray[i]= vo;
					 i++;
				 }
				 builder.withData(voArray);
			}
		}
		ArrayResult<Vitalsign> rs = builder.build();
		rs.setTotal(total);
		return rs;
	}

	@Override
	public SingleResult<Vitalsign> searchRecodeForMacro(String patient_id,String times) {
		String	currentPageIndex= "1";
		String  pageSize = "1000";
		SelectOptions options = SelectOptions.get().offset((Integer.valueOf(currentPageIndex)-1)*Integer.valueOf(pageSize)).limit(Integer.valueOf(pageSize)).count();			
		List<VitalsignPo> poList = this.vitalsignDao.getAcquisitionListByEnSn(patient_id,times, null, null,null/*,options*/);
		Vitalsign vo = new Vitalsign();
		SingleResultBuilder<Vitalsign> builder = SingleResultBuilder.newSingleResult(Vitalsign.class);
		if(null != poList && poList.size() > 0){
			vo.setEnPk(patient_id+"_"+ times);
//			vo.setPaId(paId);
			for(VitalsignPo po:poList){
                String bodyTemperature = po.getTemper(); //体温
                String breathe = po.getBreathe();//呼吸
                String pulse = po.getPulse();//脉搏
                if(bodyTemperature!=null||breathe!=null||pulse!=null){
                    vo.setTemper(bodyTemperature);
                    vo.setBreathe(breathe);
                    vo.setPulse(pulse);
                    break;
                }
            }
            for(VitalsignPo po:poList){
                String systolicPressure = po.getSystolicPress();//收缩压
                String diagstolicPressure = po.getDiastolicPress();//舒张压
                if(systolicPressure!=null||diagstolicPressure!=null){
                    vo.setSystolicPress(systolicPressure);
                    vo.setDiastolicPress(diagstolicPressure);
                    break;
                }
            }
            for(VitalsignPo po:poList){
                String heart = po.getHeartRate();//心率
                if(heart!=null){
                    vo.setHeartRate(heart);
                    break;
                }
            }
            for(VitalsignPo po:poList){
                String weight = po.getWeight();//体重
                if(weight!=null){
                    vo.setWeight(weight);
                    break;
                }
            }
            for(VitalsignPo po:poList){
                String bldOxygen = po.getBldOxygen();//血氧
                if(bldOxygen!=null){
                    vo.setBldOxygen(bldOxygen);
                    break;
                }
            }
		}

		
		builder.withData(vo);
		return builder.build();
		
	}

}
