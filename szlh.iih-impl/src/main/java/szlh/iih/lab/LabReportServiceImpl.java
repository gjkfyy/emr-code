package szlh.iih.lab;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.seasar.doma.jdbc.SelectOptions;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import pkuhit.iih.lab.LabReportService;
import pkuhit.xap.ass.LabReport;
import szlh.iih.lab.dao.LabReportDao;
import szlh.iih.lab.po.LabReportPo;
import xap.sv.model.ArrayResult;
import xap.sv.model.ArrayResultBuilder;
import xap.sv.model.SingleResult;
import xap.sv.model.SingleResultBuilder;

/**
 * @author guo_zhongbao
 *
 */
public class LabReportServiceImpl implements LabReportService {
	@Autowired
	LabReportDao labReportDao;

	/* (non-Javadoc)
	 * @see pkuhit.iih.lab.LabReportService#search(java.lang.String)
	 */
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

	/* (non-Javadoc)
	 * @see pkuhit.iih.lab.LabReportService#search(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public ArrayResult<LabReport> search(String enPk, String currentPageIndex,
			String pageSize) {
		if(null == currentPageIndex || !StringUtils.isNumeric(currentPageIndex)   || null == pageSize || !StringUtils.isNumeric(pageSize)  )
		{
			currentPageIndex= "1";
			pageSize = "1000";
		}
		SelectOptions options = SelectOptions.get().offset((Integer.valueOf(currentPageIndex)-1)*Integer.valueOf(pageSize)).limit(Integer.valueOf(pageSize)).count();			
		List<LabReportPo> poList = this.labReportDao.getLabByEnsn(enPk,options);
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
