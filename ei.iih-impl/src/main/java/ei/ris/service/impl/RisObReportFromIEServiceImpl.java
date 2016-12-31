package ei.ris.service.impl;

import java.util.Map;

import org.springframework.http.HttpMethod;

import pkuhit.xap.ass.ObsReport;
import pkuhit.xap.util.BeanCopyUtil;
import xap.sv.model.ArrayResult;
import xap.sv.model.ArrayResultBuilder;
import xap.sv.model.SingleResult;
import ei.common.RestRequestCommon;
import ei.ris.db.dto.ObservationReportDto;
import ei.ris.db.dto.ObservationReportItemDto;
import ei.ris.service.RisObReportFromIEService;
import ei.util.HttpReqUtil;
import ei.util.HttpUrlUtil;

//调用集成平台的rest服务，读取检验报告，则用该类
public class RisObReportFromIEServiceImpl implements RisObReportFromIEService{

	@Override
	public ArrayResult<ObsReport> search(String enPk, String currentPageIndex,
			String pageSize) {
		
		ArrayResultBuilder<ObsReport> builder = ArrayResultBuilder.newArrayResult(ObsReport.class);

		//获得患者就诊参数
		String patientSn = "";
		String visitSn = "";
		
		RestRequestCommon restRequestCommon = new RestRequestCommon();
		Map<String,String> visitInfo = restRequestCommon.getPatientInfo(enPk);
		
		patientSn = visitInfo.get("patientSn");
		visitSn = visitInfo.get("visitSn");
		//如果visitSn、patientSn为空则，返回的是所有患者信息，此信息没有用，故返回空
		if(visitSn.equals("")||patientSn.equals("")){
			ArrayResult<ObsReport> rs = builder.build();
			rs.setTotal(0);
			return rs;
		}
		String param = "patientSn="+patientSn+"&visitSn="+visitSn;
		String urlStr = restRequestCommon.getRequestUrl(param,HttpUrlUtil.observationReportWsRequestEntity);
		
		try {
			ObservationReportDto[] result = (ObservationReportDto[])HttpReqUtil.getServerResult(urlStr, HttpMethod.GET, ObservationReportDto.class);
			ObservationReportDto obReportDto = null;
			//model数组
			ObsReport[]  observationReportArray = null;
			if(null != result && result.length>0){
				observationReportArray = new ObsReport[result.length];
				for(int i=0;i<result.length;i++){
					ObsReport vo = new  ObsReport();
					obReportDto = (ObservationReportDto)result[i];
					BeanCopyUtil.entityToModel(vo, obReportDto, null, null);
					observationReportArray[i] = vo;
				}
			}
			
			if(null != observationReportArray){
				//根据检查报告单号获得检查项目内容（由于集成平台提供的接口为：检查报告一个接口，检查报告结果一个接口，所以需要拼接）
				for (ObsReport observationReport : observationReportArray) {
					String obRpPk = observationReport.getObRpPk();
					//obRpPk = "17040659";
					ArrayResult<ObsReport> obItems = getObservationReportItems(obRpPk);
					if(null != obItems.getDataList() && obItems.getDataList().length>0){
						ObsReport obItem = obItems.getDataList()[0];
						observationReport.setObImpr(obItem.getObImpr());//检查印象
						observationReport.setObFndg(obItem.getObFndg());//检查所见
						observationReport.setRlsUserNm(obItem.getRlsUserNm());//报告医师
						observationReport.setRlsTime(obItem.getRlsTime());//报告时间
						observationReport.setAdv(obItem.getAdv());//建议
						observationReport.setObRpStaNm("已审核");//集成平台返回的报告均为已审核
				}
			}
				builder.withData(observationReportArray);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

		ArrayResult<ObsReport> rs = builder.build();
		rs.setTotal(0);
		return rs;
	}

	public ArrayResult<ObsReport> getObservationReportItems(String obRpPk) {
		
		ArrayResultBuilder<ObsReport> builder = ArrayResultBuilder.newArrayResult(ObsReport.class);

		RestRequestCommon restRequestCommon = new RestRequestCommon();
		String param = "reportSn="+obRpPk;
		String urlStr = restRequestCommon.getRequestUrl(param,HttpUrlUtil.observationReportItemsWsRequestEntity);
		
		try {
			ObservationReportItemDto[] result = (ObservationReportItemDto[])HttpReqUtil.getServerResult(urlStr, HttpMethod.GET, ObservationReportItemDto.class);
			ObservationReportItemDto  obReportItemDto = null;
			ObsReport[]  observationReportArray = null;
			if(null != result && result.length>0){
				observationReportArray = new ObsReport[result.length];
				for(int i=0;i<result.length;i++){
					ObsReport vo = new  ObsReport();
					obReportItemDto = (ObservationReportItemDto)result[i];
					BeanCopyUtil.entityToModel(vo, obReportItemDto, null, null);
					String obFnd = "检查所见： "+vo.getObFndg()+" \n";
					String obImpr = "检查印象： "+vo.getObImpr();
					vo.setObImpr(obFnd+obImpr);
					observationReportArray[i] = vo;
				}
				
			}
			if(null != observationReportArray){
				builder.withData(observationReportArray);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		ArrayResult<ObsReport> rs = builder.build();
		rs.setTotal(0);
		return rs;
	}

	@Override
	public SingleResult<ObsReport> search(String obRpPk) {
		// TODO Auto-generated method stub
		return null;
	}



}


