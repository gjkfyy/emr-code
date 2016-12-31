package ei.lis.service.impl;

import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpMethod;

import pkuhit.xap.ass.LabReportItem;
import pkuhit.xap.util.BeanCopyUtil;
import xap.sv.model.ArrayResult;
import xap.sv.model.ArrayResultBuilder;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import ei.common.RestRequestCommon;
import ei.lis.db.dto.LisReportItemDto;
import ei.lis.db.dto.LisReportItemOutDto;
import ei.lis.service.LabReportItemFromIEService;
import ei.util.HttpReqUtil;
import ei.util.HttpUrlUtil;

//调用集成平台的rest服务，读取检验报告，则用该类
public class LabReportItemFromIEServiceImpl implements LabReportItemFromIEService{

	public static String READ_RPITM_METHOD = "cache";//该变量用于配置读取检验项目方式，cache，如果在别的方法里已经获取到，直接在缓存容器（该缓存只缓存本患者的检验信息）里取，url直接调用集成平台获取
	public static Logger log = LoggerFactory
			.getLogger(LabReportItemFromIEServiceImpl.class);
	@Override
	public ArrayResult<LabReportItem> search(String labRpPk, String currentPageIndex,
			String pageSize) {
		
		ArrayResultBuilder<LabReportItem> builder = ArrayResultBuilder.newArrayResult(LabReportItem.class);
	
		RestRequestCommon restRequestCommon = new RestRequestCommon();
		String param = "reportSn="+labRpPk;
		String urlStr = restRequestCommon.getRequestUrl(param,HttpUrlUtil.labReportItemWsRequestEntity);
		
		try {
			String result = null;
			LisReportItemOutDto[] lisReportItemOutDtos = null;
			if(READ_RPITM_METHOD.equals("url")){
				result = HttpReqUtil.getServerResultOfStr(urlStr, HttpMethod.GET);
			}else if(READ_RPITM_METHOD.equals("cache")){
				//lisReportItemOutDtos = (LisReportItemOutDto[])HttpReqUtil.getServerResult(urlStr, HttpMethod.GET,LisReportItemOutDto.class);
				HashMap<String,LisReportItemOutDto[]> cacheMap = LabReportFromIEServiceImpl.cacheMap;
				lisReportItemOutDtos= cacheMap.get(labRpPk);
			}
			
			LisReportItemDto  lisReportItemInterEntity = null;
			LabReportItem[]  labReportItemArray = null;
			LisReportItemDto[] subItemReult = null;
			
			if(READ_RPITM_METHOD.equals("url")){
				if(null != result && !result.equals("")){
					//result数组中只有一个对象，对象中需要获取subItem数组
					JSONArray testReult = JSON.parseArray(result);
					JSONObject resultObj = testReult.size()>0 ? testReult.getJSONObject(0):null;
					String resultStr = resultObj != null ?resultObj.toString():"";
					JSONObject json = JSON.parseObject(resultStr);
					String  subItemStr = (json != null) ? json.getString("subItem"):"[]";
					subItemReult = (LisReportItemDto[])HttpReqUtil.getResultObject(subItemStr, LisReportItemDto.class);//getResultObject.getDTOArray(subItemStr, LisReportItemDto.class);
				}
			}else if(READ_RPITM_METHOD.equals("cache")){
				subItemReult = (lisReportItemOutDtos != null && lisReportItemOutDtos.length>0) ? lisReportItemOutDtos[0].getSubItem():null;
			}
			//对得到的结果接进行entityToModel转换
			if(null != subItemReult && subItemReult.length>0){
				labReportItemArray = new LabReportItem[subItemReult.length];
				for(int i=0;i<subItemReult.length;i++){
					LabReportItem vo = new  LabReportItem();
					lisReportItemInterEntity = (LisReportItemDto)subItemReult[i];
					BeanCopyUtil.entityToModel(vo, lisReportItemInterEntity, null, null);
					labReportItemArray[i] = vo;
				}
			}
				
			if(null != labReportItemArray){
				builder.withData(labReportItemArray);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		ArrayResult<LabReportItem> rs = builder.build();
		rs.setTotal(0);
		return rs;
	}
}


