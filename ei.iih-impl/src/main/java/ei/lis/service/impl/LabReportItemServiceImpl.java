package ei.lis.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.seasar.doma.jdbc.SelectOptions;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import pkuhit.xap.ass.LabReportItem;

import ei.lis.db.dao.LabReportDao;
import ei.lis.db.dao.po.LabReportItemPo;
import ei.lis.service.LabReportItemService;

import xap.sv.model.ArrayResult;
import xap.sv.model.ArrayResultBuilder;

public class LabReportItemServiceImpl implements LabReportItemService {
	@Autowired
	LabReportDao labReportDao;
	/* (non-Javadoc)
	 * @see pkuhit.iih.lab.LabReportItemItemService#search(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public ArrayResult<LabReportItem> search(String labRpPk, String currentPageIndex,
			String pageSize) {
		if(null == currentPageIndex || !StringUtils.isNumeric(currentPageIndex)   || null == pageSize || !StringUtils.isNumeric(pageSize)  )
		{
			currentPageIndex= "1";
			pageSize = "1000";
		}
		SelectOptions options = SelectOptions.get().offset((Integer.valueOf(currentPageIndex)-1)*Integer.valueOf(pageSize)).limit(Integer.valueOf(pageSize)).count();			
		List<LabReportItemPo> poList = this.labReportDao.getLabDetailItemListByReportId(labRpPk/*,options*/);
		long count = options.getCount();
		int total = Long.valueOf(count).intValue();
		LabReportItem[] voArray = null ;
		ArrayResultBuilder<LabReportItem> builder = ArrayResultBuilder.newArrayResult(LabReportItem.class);
		if(null != poList){
			 voArray = new LabReportItem[poList.size()];
			 int i = 0;
			 for(LabReportItemPo po : poList){
				 referenceValueHandler(po);
				 LabReportItem vo = new LabReportItem();
				 BeanUtils.copyProperties( po,vo);
				 voArray[i]= vo;
				 i++;
			 }
			 builder.withData(voArray);
		}
		ArrayResult<LabReportItem> rs = builder.build();
		rs.setTotal(total);
		return rs; 
	}
	
	/**
	 * 
	 * @description 处理正常值范围，只处理数值型
	 * @author jiaoxiantong
	 * @version v1.0
	 * @date 2014年4月28日 下午3:17:45
	 * @param labReportItem
	 */
	private void referenceValueHandler(LabReportItemPo labReportItem){
		if (labReportItem.getReferRange() != null) {
			String referenceValue = labReportItem.getReferRange();
			if (referenceValue.indexOf("-")>0) {
				String [] refStrings = referenceValue.split("-");
				if (refStrings != null && refStrings.length == 2) {
					try {
						float minValue = Float.parseFloat(refStrings[0]);
						float maxValue = Float.parseFloat(refStrings[1]);
						labReportItem.setMaxNrmlVal(maxValue+"");
						labReportItem.setMinNrmlVal(minValue+"");
						if(Float.parseFloat(labReportItem.getLabItmVal())>maxValue){
							labReportItem.setLabItmCompare("<font color='red'>↑</font>");
						}else if(Float.parseFloat(labReportItem.getLabItmVal())<minValue){
							labReportItem.setLabItmCompare("<font color='blue'>↓</font>");
						}else{
							labReportItem.setLabItmCompare("-");
						}
					} catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
					}
				}
			}
		}
	}
}
