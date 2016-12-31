package ei.lis.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.seasar.doma.jdbc.SelectOptions;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import pkuhit.xap.ass.LabReport;
import pkuhit.xap.pm.ParamsSetService;
import ei.lis.db.dao.LabReportDao;
import ei.lis.db.dao.po.LabReportPo;
import ei.lis.service.LabReportService;
import xap.sv.annotation.Reference;
import xap.sv.model.ArrayResult;
import xap.sv.model.ArrayResultBuilder;
import xap.sv.model.SingleResult;
import xap.sv.model.SingleResultBuilder;

public class LabReportServiceImpl implements LabReportService {
	@Autowired
	LabReportDao labReportDao;

	final String LAB_READ_FROM_VIEW_KEY = "LAB_READ_FROM_VIEW"; //从视图中读取检查报告
	
	@Reference
	ParamsSetService paramsSetService;
	
	@Override
	public SingleResult<LabReport> search(String labRpPk) {
		// TODO Auto-generated method stub
		LabReport vo = new  LabReport();
		LabReportPo po = labReportDao.getLabByLabSn(labRpPk);
		SingleResultBuilder<LabReport> builder = SingleResultBuilder.newSingleResult(LabReport.class);
		if(null != po){
			BeanUtils.copyProperties( po,vo);
			builder.withData(vo);
		}
		return builder.build();
	}

	@Override
	public ArrayResult<LabReport> search(String enPk, String currentPageIndex,
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

		ArrayResultBuilder<LabReport> builder = ArrayResultBuilder.newArrayResult(LabReport.class);
		int total = 0;
		SingleResult<String> rsFunFlag = paramsSetService.searchFunFlagByKey(LAB_READ_FROM_VIEW_KEY);
		if(null != rsFunFlag 
				&&  null != rsFunFlag.getData()
				&& rsFunFlag.getData().equalsIgnoreCase("1")
		)
		{
			List<LabReportPo> poList = this.labReportDao.getLabByEnsn(enPkArr[0], enCount/*,options*/);
			long count = options.getCount();
			total = Long.valueOf(count).intValue();
			LabReport[] voArray = null ;
			if(null != poList){
				 voArray = new LabReport[poList.size()];
				 int i = 0;
				 for(LabReportPo po : poList){
					 LabReport vo = new LabReport();
					 BeanUtils.copyProperties( po,vo);
					 voArray[i]= vo;
					 i++;
				 }
				 builder.withData(voArray);
			}
		}
		ArrayResult<LabReport> rs = builder.build();
		rs.setTotal(total);
		return rs;
	}
	
	@Override
    public ArrayResult<LabReport> searchForCis(String enPk, String currentPageIndex,
            String pageSize) {
        if(null == currentPageIndex || !StringUtils.isNumeric(currentPageIndex)   || null == pageSize || !StringUtils.isNumeric(pageSize)  )
        {
            currentPageIndex= "1";
            pageSize = "1000";
        }
        SelectOptions options = SelectOptions.get().offset((Integer.valueOf(currentPageIndex)-1)*Integer.valueOf(pageSize)).limit(Integer.valueOf(pageSize)).count();           
        List<LabReportPo> poList = this.labReportDao.getLabByEnpk(enPk);
        long count = options.getCount();
        int total = Long.valueOf(count).intValue();
        LabReport[] voArray = null ;
        ArrayResultBuilder<LabReport> builder = ArrayResultBuilder.newArrayResult(LabReport.class);
        if(null != poList){
             voArray = new LabReport[poList.size()];
             int i = 0;
             for(LabReportPo po : poList){
                 LabReport vo = new LabReport();
                 BeanUtils.copyProperties( po,vo);
                 voArray[i]= vo;
                 i++;
             }
             builder.withData(voArray);
        }
        ArrayResult<LabReport> rs = builder.build();
        rs.setTotal(total);
        return rs;
    }

}
