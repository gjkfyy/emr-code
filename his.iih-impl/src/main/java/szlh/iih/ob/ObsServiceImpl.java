package szlh.iih.ob;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.seasar.doma.jdbc.SelectOptions;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import pkuhit.iih.ob.ObservationReportService;
import pkuhit.xap.ass.ObsReport;
import pkuhit.xap.pm.ParamsSetService;
import szlh.iih.ob.dao.ObsDao;
import szlh.iih.ob.po.ObservationReportPo;
import xap.sv.annotation.Reference;
import xap.sv.model.ArrayResult;
import xap.sv.model.ArrayResultBuilder;
import xap.sv.model.SingleResult;
import xap.sv.model.SingleResultBuilder;

/**
 * @author guo_zhongbao
 * 医嘱视图
 */
public class ObsServiceImpl implements ObservationReportService {
	 
	final String OB_READ_FROM_VIEW_KEY = "OB_READ_FROM_VIEW"; //从视图中读取检查报告
	@Autowired
	ObsDao obsDao;
	
	@Reference
	ParamsSetService paramsSetService;
	
	/* (non-Javadoc)
	 * @see pkuhit.iih.or.ObsService#search(java.lang.String)
	 */
	@Override
	public SingleResult<ObsReport> search(String obRpPk) {
		ObsReport vo = new ObsReport();
		ObservationReportPo po = obsDao.getObservationByObsSn(obRpPk);
		SingleResultBuilder<ObsReport> builder = SingleResultBuilder.newSingleResult(ObsReport.class);
		if(null != po){
			BeanUtils.copyProperties( po,vo);
			builder.withData(vo);
		}
		return builder.build();
	}

	/* (non-Javadoc)
	 * @see pkuhit.iih.or.ObsService#search(java.util.Map)
	 */
	@Override
	public ArrayResult<ObsReport> search(String enPk, String currentPageIndex,
			String pageSize) {
		if(null == currentPageIndex || !StringUtils.isNumeric(currentPageIndex)   || null == pageSize || !StringUtils.isNumeric(pageSize)  )
		{
			currentPageIndex= "1";
			pageSize = "1000";
		}
		ArrayResultBuilder<ObsReport> builder = ArrayResultBuilder.newArrayResult(ObsReport.class);
		int total = 0 ;
		SingleResult<String> rsFunFlag = paramsSetService.searchFunFlagByKey(OB_READ_FROM_VIEW_KEY);
		if(null != rsFunFlag 
				&&  null != rsFunFlag.getData()
				&& null != rsFunFlag.getData()
				&& rsFunFlag.getData().equalsIgnoreCase("1")
		)
		{	
			String patientId = null ;
			String times = null ;
			if(enPk.contains("_")){
				String[] arr = enPk.split("_");
				patientId = arr[0] ;
				times = arr[1] ;
			}
			SelectOptions options = SelectOptions.get().offset((Integer.valueOf(currentPageIndex)-1)*Integer.valueOf(pageSize)).limit(Integer.valueOf(pageSize)).count();			
			List<ObservationReportPo> poList = this.obsDao.getObsListByEnSn(null,patientId,times,options);
			long count = options.getCount();
			total = Long.valueOf(count).intValue();
			ObsReport[] voArray = null ;
			if(null != poList){
				 voArray = new ObsReport[poList.size()];
				 int i = 0;
				 for(ObservationReportPo po : poList){
					 ObsReport vo = new ObsReport();
					 BeanUtils.copyProperties( po,vo);
					 voArray[i]= vo;
					 i++;
				 }
				 builder.withData(voArray);
			}
		}
		ArrayResult<ObsReport> rs = builder.build();
		rs.setTotal(total);
		return rs;
	}

	@Override
	public ArrayResult<ObsReport> searchByObsOrder(String enPk, String currentPageIndex,
			String pageSize) {
		return null;
	}
}
