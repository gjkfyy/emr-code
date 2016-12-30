/**
 * 
 */
package szlh.iih.di;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.seasar.doma.jdbc.SelectOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import pkuhit.iih.di.DiagnosisModel;
import pkuhit.iih.di.DiagnosisService;
import pkuhit.iih.di.his.HisDiagnosisListModel;
import szlh.iih.di.dao.DiDao;
import szlh.iih.di.po.DiagnosisPo;
import xap.sv.model.ArrayResult;
import xap.sv.model.ArrayResultBuilder;
import xap.sv.model.SingleResult;
import xap.sv.model.SingleResultBuilder;

/**
 * @author guo_zhongbao
 *
 */
public class DiagnosisServiceImpl implements DiagnosisService {
	final static Logger logger = LoggerFactory.getLogger(DiagnosisService.class);
	@Autowired
	DiDao diDao ;
	
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
			 for(DiagnosisPo po : poList){
				 DiagnosisModel vo = new DiagnosisModel();
				 BeanUtils.copyProperties( po,vo);
				 voArray[i]= vo;
				 i++;
			 }
			builder.withData(voArray);
		}
		ArrayResult<DiagnosisModel> rs = builder.build();
		rs.setTotal(total);
		return rs;
	}

	@Override
	public void saveOrUpdateDiagnosis(HisDiagnosisListModel list,
			String patient_id, String times) {
		// TODO Auto-generated method stub
		logger.debug("南京鼓楼版本使用该方法，同步诊断到HIS中...");
	}

	@Override
	public void delDiagnosis(String delDiCode, String mainDiCode,
			String patient_id, String times) {
		logger.debug("南京鼓楼版本使用该方法，在his中删除诊断 ，并设置主诊断...");
	}
	
}
