package ei.ris.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.dom4j.DocumentException;
import org.seasar.doma.jdbc.SelectOptions;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pkuhit.xap.ass.ObsReport;
import pkuhit.xap.pm.ParamsSetService;
import xap.sv.annotation.Reference;
import xap.sv.model.ArrayResult;
import xap.sv.model.ArrayResultBuilder;
import xap.sv.model.SingleResult;
import xap.sv.model.SingleResultBuilder;
import ei.ris.db.dao.ObsDao;
import ei.ris.db.dao.po.ObservationReportPo;
import ei.ris.service.RisObReportService;
import ei.ris.util.AnalyticObsContent;


@Service
public class RisObReportServiceImpl implements RisObReportService {

	@Autowired
	ObsDao obsDao;
	@Reference
	ParamsSetService paramsSetService;
	final String OB_READ_FROM_VIEW_KEY = "OB_READ_FROM_VIEW"; //从视图中读取检查报告
	/**
	 * 构造器
	 */
	public RisObReportServiceImpl() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public SingleResult<ObsReport> search(String obRpPk) {
		ObsReport vo = new ObsReport();
		ObservationReportPo po = obsDao.getObservationByObsSn(obRpPk);
		AnalyticObsContent analyticObs = new AnalyticObsContent();
		String obImprStr = "";
		try {
			obImprStr = analyticObs.getObImprContent(po.getObImpr());
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		po.setObImpr(obImprStr);
		SingleResultBuilder<ObsReport> builder = SingleResultBuilder.newSingleResult(ObsReport.class);
		if(null != po){
			BeanUtils.copyProperties( po,vo);
			builder.withData(vo);
		}
		return builder.build();
	}

	@Override
	public ArrayResult<ObsReport> search(String enPk, String currentPageIndex,
			String pageSize) {
		if(null == currentPageIndex || !StringUtils.isNumeric(currentPageIndex)   || null == pageSize || !StringUtils.isNumeric(pageSize)  )
		{
			currentPageIndex= "1";
			pageSize = "1000";
		}
		SelectOptions options = SelectOptions.get().offset((Integer.valueOf(currentPageIndex)-1)*Integer.valueOf(pageSize)).limit(Integer.valueOf(pageSize)).count();			
		String enPkArr[] = enPk.split("_");
		String enCount = "0";
		if(enPkArr.length==2){
			enCount = enPkArr[1];
		}
		ObsReport[] voArray = null ;
		ArrayResultBuilder<ObsReport> builder = ArrayResultBuilder.newArrayResult(ObsReport.class);
		int total = 0 ;
		SingleResult<String> rsFunFlag = paramsSetService.searchFunFlagByKey(OB_READ_FROM_VIEW_KEY);
		if(null != rsFunFlag 
				&&  null != rsFunFlag.getData()
				&& null != rsFunFlag.getData()
				&& rsFunFlag.getData().equalsIgnoreCase("1")
		)
		{
			List<ObservationReportPo> poList = this.obsDao.getObsListByEnpk(enPkArr[0], enCount/*, options*/);
			long count = options.getCount();
			total = Long.valueOf(count).intValue();

			if(null != poList){
				 voArray = new ObsReport[poList.size()];
				 int i = 0;
				 for(ObservationReportPo po : poList){
					 AnalyticObsContent analyticObs = new AnalyticObsContent();
					 String obImprStr = "";
					 String regex = "/<+/g";//判断是否为xml格式
					 try {
						 boolean len = (po.getObImpr()).matches(regex);
						 if(len){
							 obImprStr = analyticObs.getObImprContent(po.getObImpr());
						 	}else{
						 		obImprStr =po.getObImpr();
						 	}
					 } catch (DocumentException e) {
					 	e.printStackTrace();
					 }
					 po.setObImpr(obImprStr);
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
    public ArrayResult<ObsReport> searchForCis(String enPk, String currentPageIndex,
            String pageSize) {
        if(null == currentPageIndex || !StringUtils.isNumeric(currentPageIndex)   || null == pageSize || !StringUtils.isNumeric(pageSize)  )
        {
            currentPageIndex= "1";
            pageSize = "1000";
        }
        SelectOptions options = SelectOptions.get().offset((Integer.valueOf(currentPageIndex)-1)*Integer.valueOf(pageSize)).limit(Integer.valueOf(pageSize)).count();           
        List<ObservationReportPo> poList = this.obsDao.getObsListByEnSn(enPk);
        long count = options.getCount();
        int total = Long.valueOf(count).intValue();
        ObsReport[] voArray = null ;
        ArrayResultBuilder<ObsReport> builder = ArrayResultBuilder.newArrayResult(ObsReport.class);
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
        ArrayResult<ObsReport> rs = builder.build();
        rs.setTotal(total);
        return rs;
    }
	
	public List<ObsReport> searchObsListByObsNo(List<String> applyCodeList){
	    List<ObservationReportPo> poList = obsDao.getObsListByObsNo(applyCodeList);
	    List<ObsReport> result = new ArrayList<ObsReport>();
	    if(null != poList){
            for(ObservationReportPo po : poList){
                AnalyticObsContent analyticObs = new AnalyticObsContent();
                String obImprStr = "";
                try {
                   obImprStr = analyticObs.getObImprContent(po.getObImpr());
                } catch (DocumentException e) {
                   e.printStackTrace();
                }
                po.setObImpr(obImprStr);
                ObsReport vo = new ObsReport();
                BeanUtils.copyProperties( po,vo);
                result.add(vo);
            }
        }
	    return result;
	}

}
