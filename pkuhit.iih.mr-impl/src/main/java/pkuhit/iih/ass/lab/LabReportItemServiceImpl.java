package pkuhit.iih.ass.lab;

import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.seasar.doma.jdbc.SelectOptions;

import pkuhit.md.SysFunctionCode;
import pkuhit.utils.ParameterUtils;
import pkuhit.xap.ass.LabReportItem;
import pkuhit.xap.pm.ParamsService;
import pkuhit.xap.pm.ParamsSetService;
import xap.sv.annotation.Reference;
import xap.sv.model.ArrayResult;
import xap.sv.model.SingleResult;
import ei.lis.service.LabReportItemFromIEService;
import ei.lis.service.LabReportItemService;

/**
 * @author guo_zhongbao
 *
 */
public class LabReportItemServiceImpl implements LabRepItemService {
	/* (non-Javadoc)
	 * @see pkuhit.iih.lab.LabReportItemItemService#search(java.lang.String, java.lang.String, java.lang.String)
	 */
	
	@Reference
	LabReportItemService labReportItemService;
	
	@Reference
	LabReportItemFromIEService labReportItemFromIEService;
	
	@Reference
	ParamsService paramsService;
	
	@Reference
	ParamsSetService paramsSetService;
	
	@Override
	public ArrayResult<LabReportItem> search(String labRpPk, String currentPageIndex,
			String pageSize) {
		if(null == currentPageIndex || !StringUtils.isNumeric(currentPageIndex)   || null == pageSize || !StringUtils.isNumeric(pageSize)  )
		{
			currentPageIndex= "1";
			pageSize = "1000";
		}
		SelectOptions options = SelectOptions.get().offset((Integer.valueOf(currentPageIndex)-1)*Integer.valueOf(pageSize)).limit(Integer.valueOf(pageSize)).count();			
//		
//		
//		List<LabReportItem> poList = null;
//		long count = options.getCount();
//		int total = Long.valueOf(count).intValue();
//		LabReportItem[] voArray = null ;
//		ArrayResultBuilder<LabReportItem> builder = ArrayResultBuilder.newArrayResult(LabReportItem.class);
//		if(null != poList){
//			 voArray = new LabReportItem[poList.size()];
//			 int i = 0;
//			 for(LabReportItem po : poList){
//				 referenceValueHandler(po);
//				 LabReportItem vo = new LabReportItem();
//				 BeanUtils.copyProperties( po,vo);
//				 voArray[i]= vo;
//				 i++;
//			 }
//			 builder.withData(voArray);
//		}
		
		ArrayResult<LabReportItem> rs = null;
		SingleResult<Map> rsMapParam = paramsSetService.searchByCode(SysFunctionCode.DATA_SOURCE);
		if(null != rsMapParam && null != rsMapParam.getData() && rsMapParam.getData().containsKey("ASS_JY")){
			String value = rsMapParam.getData().get("ASS_JY").toString().trim();
			if(value.equalsIgnoreCase(ParameterUtils.ASS_DS_IEREST)){
				rs = labReportItemFromIEService.search(labRpPk, currentPageIndex, pageSize);
			}else{
				rs = labReportItemService.search(labRpPk, currentPageIndex, pageSize);
			}
		}
		
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
	private void referenceValueHandler(LabReportItem labReportItem){
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
