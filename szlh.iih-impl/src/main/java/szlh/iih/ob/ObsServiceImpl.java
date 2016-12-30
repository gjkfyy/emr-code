package szlh.iih.ob;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.seasar.doma.jdbc.SelectOptions;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import pkuhit.iih.ob.ObservationReportService;
import pkuhit.xap.ass.ObsReport;
import szlh.iih.ob.dao.ObsDao;
import szlh.iih.ob.po.ObservationReportPo;
import xap.sv.annotation.Reference;
import xap.sv.model.ArrayResult;
import xap.sv.model.ArrayResultBuilder;
import xap.sv.model.SingleResult;
import xap.sv.model.SingleResultBuilder;
import ei.ris.service.RisObReportService;

/**
 * @author guo_zhongbao
 * 医嘱视图
 */
public class ObsServiceImpl implements ObservationReportService {
	 
	@Autowired
	ObsDao obsDao;
	
	@Reference
	RisObReportService risObReportService;
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
		SelectOptions options = SelectOptions.get().offset((Integer.valueOf(currentPageIndex)-1)*Integer.valueOf(pageSize)).limit(Integer.valueOf(pageSize)).count();			
		List<ObservationReportPo> poList = this.obsDao.getObsListByEnSn(enPk,options);
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
	
	@Override
    public ArrayResult<ObsReport> searchByObsOrder(String enPk, String currentPageIndex,
            String pageSize) {
	    SelectOptions options = SelectOptions.get().offset((Integer.valueOf(currentPageIndex)-1)*Integer.valueOf(pageSize)).limit(Integer.valueOf(pageSize)).count();  
        long count = options.getCount();
        int total = Long.valueOf(count).intValue();
        ObsReport[] voArray = null ;
        ArrayResultBuilder<ObsReport> builder = ArrayResultBuilder.newArrayResult(ObsReport.class);
        if(null == currentPageIndex || !StringUtils.isNumeric(currentPageIndex)   || null == pageSize || !StringUtils.isNumeric(pageSize)  )
        {
            currentPageIndex= "1";
            pageSize = "1000";
        }
        List<String> applyCodeList = new ArrayList<String>();
        List<Map<String,Object>> list = this.obsDao.getObsOrderByEnSn(enPk);
        if(list != null && list.size() > 0){
            for(int i=0;i<list.size();i++){
                Map<String,Object> m = list.get(i);
                String applyCode = m.get("apply_code")==null?"":m.get("apply_code").toString();
                applyCodeList.add(applyCode);
            }
            List<ObsReport> poList = risObReportService.searchObsListByObsNo(applyCodeList);
            if(null != poList){
                 voArray = new ObsReport[poList.size()];
                 int i = 0;
                 for(ObsReport po : poList){
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

}
