package ei.lis.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

import pkuhit.iih.mr.wr.Amr;
import pkuhit.xap.ass.LabReport;
import pkuhit.xap.ass.LabReportItem;
import pkuhit.xap.ass.ObsReport;
import pkuhit.xap.util.BeanCopyUtil;
import xap.sv.model.ArrayResult;
import xap.sv.model.ArrayResultBuilder;
import xap.sv.model.SingleResult;
import ei.common.RestRequestCommon;
import ei.lis.db.dto.LisReportDto;
import ei.lis.db.dto.LisReportItemOutDto;
import ei.lis.service.LabReportFromIEService;
import ei.util.HttpReqUtil;
import ei.util.HttpUrlUtil;

//调用集成平台的rest服务，读取检验报告，则用该类
public class LabReportFromIEServiceImpl implements LabReportFromIEService{
	public static Logger log = LoggerFactory
			.getLogger(LabReportFromIEServiceImpl.class);

	static HashMap<String,LisReportItemOutDto[]> cacheMap = new HashMap(); 
	
	@Override
	public ArrayResult<LabReport> search(String enPk, String currentPageIndex,
			String pageSize) {
		//log.warn("log.warn into LabReportFromIEServiceImpl============================================");
		ArrayResultBuilder<LabReport> builder = ArrayResultBuilder.newArrayResult(LabReport.class);

		//获得患者就诊参数
		String patientSn = "";
		String visitSn = "";
		
		RestRequestCommon restRequestCommon = new RestRequestCommon();
		Map<String,String> visitInfo = restRequestCommon.getPatientInfo(enPk);
		
		patientSn = visitInfo.get("patientSn");
		visitSn = visitInfo.get("visitSn");
		
		//如果visitSn、patientSn为空则，返回的是所有患者信息，此信息没有用，故返回空
		if(visitSn.equals("")||patientSn.equals("")){
			ArrayResult<LabReport> rs = builder.build();
			rs.setTotal(0);
			return rs;
		}
		
		String param = "visitSn="+visitSn+"&patientSn="+patientSn;
		String urlStr = restRequestCommon.getRequestUrl(param,HttpUrlUtil.labReportWsRequestEntity);
		log.debug("LabReport  rest url is :"+urlStr);
		try {
			LisReportDto[] result = (LisReportDto[])HttpReqUtil.getServerResult(urlStr, HttpMethod.GET, LisReportDto.class);
			LisReportDto lisReportInterEntity = null;
			LabReport[]  labReportArray = null;
			if(null != result && result.length>0){
				labReportArray = new LabReport[result.length];
				for(int i=0;i<result.length;i++){
					LabReport vo = new  LabReport();
					lisReportInterEntity = (LisReportDto)result[i];
					BeanCopyUtil.entityToModel(vo, lisReportInterEntity, null, null);
					labReportArray[i] = vo;
				}
				
			}
			if(null != labReportArray){
					//根据检验报告单号获得报告单号、检查时间、报告医师
					for (LabReport labReport : labReportArray) {
						String labRpPk = labReport.getLabRpPk();
						//obRpPk = "17040659";
						ArrayResult<LisReportItemOutDto> labItemOuts = getLabReportItemOuts(labRpPk);
						if(null != labItemOuts.getDataList() && labItemOuts.getDataList().length>0){
							LisReportItemOutDto labItemOut = labItemOuts.getDataList()[0];
							labReport.setLabRpNo(labItemOut.getReportno());//报告单号
							labReport.setExecTime(labItemOut.getReceivetime());//检查时间
							labReport.setExecDctNm(labItemOut.getAuditname());//报告医师
							labReport.setLabRpStaNm("已审核");//集成平台读取的数据均为已审核报告数据
				
					   }
				    }
					builder.withData(labReportArray);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		ArrayResult<LabReport> rs = builder.build();
		rs.setTotal(0);
		return rs;
	}

	public ArrayResult<LisReportItemOutDto> getLabReportItemOuts(String labRpPk) {
		ArrayResultBuilder<LisReportItemOutDto> builder = ArrayResultBuilder.newArrayResult(LisReportItemOutDto.class);
	
		RestRequestCommon restRequestCommon = new RestRequestCommon();
		String param = "reportSn="+labRpPk;
		String urlStr = restRequestCommon.getRequestUrl(param,HttpUrlUtil.labReportItemWsRequestEntity);
		log.warn("LabReportItem rest url is :"+urlStr);
		
		try {
			LisReportItemOutDto[] result = (LisReportItemOutDto[])HttpReqUtil.getServerResult(urlStr, HttpMethod.GET,LisReportItemOutDto.class);
			
			if(null != result){
				log.warn("检验项目 LisReportItemOutDto[] 不为空============================");
				builder.withData(result);
				//如果结果不为空，则放入缓存
				cacheMap.put(labRpPk, result);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		ArrayResult<LisReportItemOutDto> rs = builder.build();
		rs.setTotal(0);
		return rs;
	}
	
	
	@Override
	public SingleResult<LabReport> search(String labRpPk) {
		// TODO Auto-generated method stub
		return null;
	}


	public static void main(String[] args){
		RestTemplate rest = new RestTemplate();
		String urlStr = "http://localhost:8081/xap/mr/ens?workScreen=3&groupType=1&userId=A1058&deptCd=9300001&pageSize=30&pageNum=&patientId=&patientName=&startDate=1448553600000&endDate=1450972800000&xmode=debug";
		try {
			Amr[] result = (Amr[])HttpReqUtil.getServerResult(urlStr, HttpMethod.GET, Amr.class);
			System.out.println("success"+result.length);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}


