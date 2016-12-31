/**
 * 
 */
package ei.ass.di.zy.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.seasar.doma.jdbc.SelectOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import pkuhit.iih.di.DiagnosisModel;
import pkuhit.iih.di.his.HisDiagnosisListModel;
import xap.sv.model.ArrayResult;
import xap.sv.model.ArrayResultBuilder;
import xap.sv.model.SingleResult;
import xap.sv.model.SingleResultBuilder;
import ei.ass.di.auto.po.DiagnosisPo;
import ei.ass.di.zy.dao.ZyDirectDiDao;
import ei.ass.di.zy.service.ZyDirectDiagnosisService;

/**
 * @author guo_zhongbao
 *
 */
public class ZyDirectDiagnosisServiceImpl implements ZyDirectDiagnosisService {
	final static Logger logger = LoggerFactory.getLogger(ZyDirectDiagnosisServiceImpl.class);
	@Autowired
	ZyDirectDiDao diDao ;
	
	/* (non-Javadoc)
	 * @see pkuhit.iih.di.DiagnosisService#search(java.lang.String)
	 */
	@Override
	public SingleResult<DiagnosisModel> search(String diPk) {
		DiagnosisPo po = diDao.getDibDiDetail(diPk);
		DiagnosisModel vo = new DiagnosisModel() ;
		SingleResultBuilder<DiagnosisModel> builder = SingleResultBuilder.newSingleResult(DiagnosisModel.class);
		if(null != po){
			BeanUtils.copyProperties( po,vo);
			builder.withData(vo);
		}
		return builder.build();
	
	}

	/* (non-Javadoc)
	 * @see pkuhit.iih.di.DiagnosisService#search(java.util.Map)
	 */
	@Override
	public ArrayResult<DiagnosisModel> search(String enPk, String isMainF,String onlyNotStop, String currentPageIndex , String pageSize ) {
		logger.debug("encounterSn:"+enPk);
		logger.debug("isMainF:"+isMainF);
		logger.debug("onlyNotStop:"+onlyNotStop);
		logger.debug("currentPageIndex:"+currentPageIndex);
		logger.debug("pageSize:"+pageSize);
		if(null == currentPageIndex || !StringUtils.isNumeric(currentPageIndex)   || null == pageSize || !StringUtils.isNumeric(pageSize)  )
		{
			currentPageIndex= "1";
			pageSize = "1000";
		}
		String onlyMainF = null ;
		if(null != isMainF && (isMainF.equalsIgnoreCase("true")|| isMainF.equalsIgnoreCase("1"))){
			onlyMainF = "1";
		}
		SelectOptions options = SelectOptions.get().offset((Integer.valueOf(currentPageIndex)-1)*Integer.valueOf(pageSize)).limit(Integer.valueOf(pageSize)).count();			
		List<DiagnosisPo> poList = this.diDao.getDisListByEnSn(enPk,onlyMainF,onlyNotStop,options);
		long count = options.getCount();
		int total = Long.valueOf(count).intValue();
		DiagnosisModel[] voArray = null ;
		ArrayResultBuilder<DiagnosisModel> builder = ArrayResultBuilder.newArrayResult(DiagnosisModel.class);
		if(null != poList){
			 voArray = new DiagnosisModel[poList.size()];
			 int i = 0;
			 int j = 1 ;
			 for(DiagnosisPo po : poList){
				 DiagnosisModel vo = new DiagnosisModel();
				 BeanUtils.copyProperties( po,vo);
				 if(null != vo.getDiNm()){
					 vo.setLongDiNm(String.valueOf(j)+"."+vo.getDiNm());
					 if("1".equalsIgnoreCase(vo.getUncF())){
						 vo.setLongDiNm(vo.getLongDiNm()+"（？）");
					 }
					 if("1".equalsIgnoreCase(vo.getUnkF())){
						 vo.setLongDiNm(vo.getLongDiNm()+"（待查）"); 
					 }
				 }
				 voArray[i]= vo;
				 i++;
				 j++;
			 }
			builder.withData(voArray);
		}
		ArrayResult<DiagnosisModel> rs = builder.build();
		rs.setTotal(total);
		return rs;
	}

	@Override
	public void saveOrUpdateDiagnosis( HisDiagnosisListModel list,
			String enPk) {
		// TODO Auto-generated method stub
		logger.debug("南京鼓楼版本使用该方法，同步诊断到HIS中...");
	}

	@Override
	public void delDiagnosis( String delDiCode, String mainDiCode,String enPk) {
		logger.debug("南京鼓楼版本使用该方法，在his中删除诊断 ，并设置主诊断...");
	}
	
}
