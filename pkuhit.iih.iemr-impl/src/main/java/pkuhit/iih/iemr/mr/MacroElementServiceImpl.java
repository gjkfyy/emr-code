package pkuhit.iih.iemr.mr;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pkuhit.iih.ass.di.AssDiagnosisService;
import pkuhit.iih.ass.nu.AssVitalsignService;
import pkuhit.iih.ass.or.AssOrderService;
import pkuhit.iih.di.DiagnosisModel;
import pkuhit.iih.en.md.EncounterType;
import pkuhit.iih.en.md.PatientModel;
import pkuhit.iih.iemr.pub.IihUtils;
import pkuhit.iih.mr.pub.MessageCode;
import pkuhit.iih.mr.tpl.MrFrTemplate;
import pkuhit.iih.mr.tpl.MrFrTplService;
import pkuhit.iih.mr.wr.AllValue;
import pkuhit.iih.mr.wr.Amr;
import pkuhit.iih.mr.wr.AmrService;
import pkuhit.iih.mr.wr.MacroElementValue;
import pkuhit.iih.mr.wr.MrSplFmValue;
import pkuhit.iih.mr.wr.NursingRecordService;
import pkuhit.iih.mr.wr.Prescription;
import pkuhit.iih.mr.wr.RefreshPrescriptionAndDisposal;
import pkuhit.iih.nu.Vitalsign;
import pkuhit.iih.or.OrderModel;
import pkuhit.md.SysFunctionCode;
import pkuhit.xap.ac.Session;
import pkuhit.xap.file.FileObject;
import pkuhit.xap.file.FileService;
import pkuhit.xap.pm.Param;
import pkuhit.xap.pm.ParamsService;
import pkuhit.xap.pm.ParamsSetService;
import xap.sv.annotation.Reference;
import xap.sv.model.ArrayResult;
import xap.sv.model.SingleResult;
import xap.sv.model.SingleResultBuilder;
import xap.sv.notification.Notification;
import xap.sv.notification.exception.NotificationException;
import xap.sv.servlet.mvc.annotation.RequestParam;

/**
 * 
 * <p>
 * MacroElementServiceImpl
 * </p>
 * <p>
 * 实现宏元素值查询服务
 * </p>
 * 
 * @author 李春学(li_chunxue@founder.com)
 * @version 0.0.0
 *          <table style="border:1px solid gray;">
 *          <tr>
 *          <th width="100px">版本号</th>
 *          <th width="100px">动作</th>
 *          <th width="100px">修改人</th>
 *          <th width="100px">修改时间</th>
 *          </tr>
 *          <!-- 以 Table 方式书写修改历史 -->
 *          <tr>
 *          <td>0.0.0</td>
 *          <td>创建类</td>
 *          <td>李春学</td>
 *          <td>2015年3月18日 下午2:39:44</td>
 *          </tr>
 *          </table>
 */
public class MacroElementServiceImpl implements MacroElementService {

	private Logger log = LoggerFactory.getLogger(MacroElementServiceImpl.class);
	@Reference
	AmrService amrService;// 病案服务
/*	@Reference
	PatientService patientService;// 患者信息服务
*/	@Reference
	AssOrderService orderService;// 医嘱查询
	@Reference
	pkuhit.iih.mr.wr.MedicalRecordService medicalRecordService;// 医疗记录服务
	@Reference
	pkuhit.iih.mr.wr.OutMedicalRecordService outMedicalRecordService;// 医疗记录服务
	@Reference
	AssVitalsignService vitalsignService;// 生命体征服务
	@Reference
	ParamsService paramsService;//系统参数配置服务
	@Reference
    ParamsSetService paramsSetService;//系统参数配置服务
	@Reference
	MrFrTplService mrFrTplService;//
	@Reference
	FileService fileService ;
	@Reference
	AssDiagnosisService diagnosisService;
	@Reference
	NursingRecordService nursingRecordService;
	/*
	 * (non-Javadoc)
	 * 
	 * @see pkuhit.iih.iemr.mr.MacroElementService#searchById(java.lang.String)
	 */
	@Override
	public SingleResult<MacroElementValue> searchById(@RequestParam Map<String, String> param)
			throws Throwable {
		SingleResult<MacroElementValue> result = new SingleResult<MacroElementValue>();
		String encounterPk= param.get("encounterPk");
		MacroElementValue data = new MacroElementValue();// 宏元素值model
		Amr amr = amrService.get(encounterPk).getData();// 病案属性
		data.setAmr(amr);
		Map paInfoConditionMap = new HashMap();
		paInfoConditionMap.put("enTypeCode", amr.getEncounterTypeCode());
		paInfoConditionMap.put("paId", amr.getPatientId());
		PatientModel patient = amrService.getPatientDetail(paInfoConditionMap);// 患者基本信息
		data.setPatient(patient!=null?patient:new PatientModel());
		Vitalsign vitalsign=vitalsignService.searchRecodeForMacro(encounterPk).getData();
		data.setVitalsign(vitalsign==null?new Vitalsign():vitalsign);// 患者生命体征信息
		data.setEmergencyMrNumber(outMedicalRecordService.getEmergencyMrNumber(param));
		ArrayResult<DiagnosisModel> diags = diagnosisService.search(encounterPk,null,null,null,null);
		List<MrSplFmValue> mrSplFmValues= nursingRecordService.splFmTypeData(encounterPk,2+"").getData();
		if(mrSplFmValues!=null&&mrSplFmValues.size()>0)
		data.setMrSplFmValue(mrSplFmValues);
		DiagnosisModel[] diagnosisModels=diags.getDataList();
		if(null==diagnosisModels){
			diagnosisModels=new DiagnosisModel[0];
		}
		String allDiag=null;
		for(DiagnosisModel diagnosisModel:diagnosisModels){
			if(null==allDiag){
				allDiag=diagnosisModel.getLongDiNm();
			}else{
				allDiag=allDiag+","+diagnosisModel.getLongDiNm();
			}
		}
		data.setAllDiagnosis(allDiag);
		result.setData(data);
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * pkuhit.iih.iemr.mr.MacroElementService#searchAllValueByEnPk(java.lang
	 * .String, java.lang.String)
	 */
	@Override
	public SingleResult<AllValue> searchAllValueByEnPk(@RequestParam Map<String, String> param)
			throws Throwable {
		SingleResult<AllValue> result = null;
		SingleResultBuilder<AllValue> builder = SingleResultBuilder
				.newSingleResult(AllValue.class);
		String encounterPk= param.get("encounterPk");
		String mrPk= param.get("mrPk");
		AllValue allValue = new AllValue();// 该model包含宏元素值与引用元素值
		MacroElementValue data = this.searchById(param).getData();// 获取宏元素值
		allValue.setMacroElementValue(data);
		allValue.setMrElemValues(medicalRecordService.searchMrDocValueByMrPk(
				mrPk, encounterPk).getDataList());// 获取引用元素值
		RefreshPrescriptionAndDisposal prescriptionAndDisposal=this.searchAllPrescriptionAndDisposalByEnPk(encounterPk).getData();
		allValue.setRefreshPrescriptionAndDisposal(prescriptionAndDisposal);
		builder.withData(allValue);
		result = builder.build();
		return result;
	}


	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * pkuhit.iih.iemr.mr.MacroElementService#searchAllPrescriptionByEnPk(java
	 * .lang.String)
	 */
	public SingleResult<RefreshPrescriptionAndDisposal> searchAllPrescriptionAndDisposalByEnPk(String id) throws Throwable {
		SingleResult<RefreshPrescriptionAndDisposal> result = null;
		SingleResultBuilder<RefreshPrescriptionAndDisposal> builder = SingleResultBuilder
				.newSingleResult(RefreshPrescriptionAndDisposal.class);
		List<OrderModel> jianyanList = new ArrayList<OrderModel>();
		List<OrderModel> jianchaList = new ArrayList<OrderModel>();
		List<OrderModel> zhenliaoList = new ArrayList<OrderModel>();
		List<OrderModel> disposals = new ArrayList<OrderModel>();
		List<Prescription> prescriptionsList =new ArrayList<Prescription>(); //西药处方
		List<Prescription> cpmPrescriptionsList =new ArrayList<Prescription>(); //中成药处方
		List<OrderModel> cmXdPrescriptionsList =new ArrayList<OrderModel>(); //中草药协定处方
		List<OrderModel> cmFxdPrescriptionsList =new ArrayList<OrderModel>(); //中草药非协定处方
		List<OrderModel> cZlPrescriptionsList =new ArrayList<OrderModel>(); //中医治疗处方
		RefreshPrescriptionAndDisposal prescriptionAndDisposal=new RefreshPrescriptionAndDisposal();
		//从助手区的医嘱列表的后台 获得orders
		OrderModel[] orders = orderService.search(id,null, EncounterType.OUTPATIENT,null,null,null, null).getDataList();
		if(null==orders){
			orders=new OrderModel[0];
			log.info("pkuhit.iih.iemr.mr.MacroElementServiceImpl.searchAllPrescriptionAndDisposalByEnPk(String) 医嘱列表为null");
		}
		if(orders.length>0){
			//从系统参数表中 获取 门诊处方小模板设置SYSM01.5 的value，该值为处方小模板（表MR_FR_TPL）的code
			Param[] params=paramsService.getParam(SysFunctionCode.OUT_PRESCRIPTION_TEMPLATE_CONFIG).getDataList();
			if(params.length>0){
				Param param=params[0];
				String tempCode=param.getValue();
				MrFrTemplate mrFrTemplate=mrFrTplService.searchById(tempCode).getData();
				if(null!=mrFrTemplate){
					String filePk=mrFrTemplate.getFilePk();
					FileObject fileObject=fileService.getFile(filePk);
					if(null!=fileObject){
						prescriptionAndDisposal.setPrescriptionsTemplateFile(new String(fileObject.asByteArray()));
					}else{
						Notification notification = new Notification(MessageCode.FILE_GET_FATAL, "处方小模板"+tempCode);
						throw new NotificationException(notification);
					}
				}else{
					Notification notification = new Notification(MessageCode.OUT_PRESCRIPTION_TEMPLATE_NOT_EXITS, tempCode);
					throw new NotificationException(notification);
				}
			}else{
				Notification notification = new Notification(MessageCode.OUT_PRESCRIPTION_TEMPLATE_NOT_SET);
				throw new NotificationException(notification);
			}
		}else{
			log.info("pkuhit.iih.iemr.mr.MacroElementServiceImpl.searchAllPrescriptionAndDisposalByEnPk(String) 医嘱列表为空");
		}
		//把当天的order 按类型 写入到各自的数组中
		for (OrderModel order : orders) {
		    SingleResult<String> param= paramsSetService.searchFunFlagByKey("OMR_PRESCRIPTION_REFRESH_TIMELIMIT");
		    Calendar c = Calendar.getInstance();
		    int timeLimit = 0;
		    if(!StringUtils.isEmpty(param.getData()))
		        timeLimit = Integer.parseInt(param.getData());
		    c.add(Calendar.HOUR, 0-timeLimit);
		    Date beginTime= c.getTime();
		    Date endTime=new Date();
			Date crtTimeStr = order.getCrtTime();
			System.out.println("beginTime -> "+beginTime);
			System.out.println("endTime -> "+endTime);
			System.out.println("crtTimeStr -> "+crtTimeStr);
			
			String orUserId = order.getOrCrtDctCd();
            Session session = Session.get();
            String loginUserId = session.getUserId();
            log.info("orUserId = " + orUserId);
            log.info("loginUserId = " + loginUserId);
			if (crtTimeStr.after(beginTime) && loginUserId.equals(orUserId)) {
				log.debug("pkuhit.iih.iemr.mr.MacroElementServiceImpl.searchAllPrescriptionAndDisposalByEnPk(String)   order——pk is：" + order.getOrPk()+"|医嘱类型："+order.getOrTpCd());
				if ("01".equals(order.getOrTpCd())) {//检验
					log.debug("检验");
					jianyanList.add(order);
				} else if ("02".equals(order.getOrTpCd())) {//检查
					log.debug("检查");
					jianchaList.add(order);
				} else if ("03".equals(order.getOrTpCd())) {//诊疗
					log.debug("诊疗");
					zhenliaoList.add(order);
				}else if ("04".equals(order.getOrTpCd())/*||"05".equals(order.getOrTpCd())*/) {//西药
					log.debug("西药");
					convertToPrescription(order,prescriptionsList);
				}else if ("05".equals(order.getOrTpCd())) {//中成药
					log.debug("中成药");
					convertToPrescription(order,cpmPrescriptionsList);
				}else if ("06".equals(order.getOrTpCd())) {//协定草药处方
					log.debug("协定草药处方");
					cmXdPrescriptionsList.add(order);
				}else if ("07".equals(order.getOrTpCd())) {//非协定草药处方
					log.debug("非协定草药处方");
					cmFxdPrescriptionsList.add(order);
				}else if ("08".equals(order.getOrTpCd())) {//中医治疗
					log.debug("中医治疗");
					cZlPrescriptionsList.add(order);
				}
			}else{
				log.info("pkuhit.iih.iemr.mr.MacroElementServiceImpl.searchAllPrescriptionAndDisposalByEnPk(String) 非当日数据order——pk is：" + order.getOrPk());
			}
		}
		setOrderGroup(prescriptionsList);
		setOrderGroup(cpmPrescriptionsList);
		disposals.addAll(jianyanList);
		disposals.addAll(jianchaList);
		disposals.addAll(zhenliaoList);
		prescriptionAndDisposal.setDisposals(disposals);
		prescriptionAndDisposal.setPrescriptions(sortOrderByParentOrderSn(prescriptionsList));
		prescriptionAndDisposal.setCmXdPrescriptionsList(cmXdPrescriptionsList);
		prescriptionAndDisposal.setCmFxdPrescriptionsList(cmFxdPrescriptionsList);
		prescriptionAndDisposal.setCpmPrescriptions(cpmPrescriptionsList);
		prescriptionAndDisposal.setcZlPrescriptionsList(cZlPrescriptionsList);
		if(prescriptionsList.size()==0){
			Param[] params=paramsService.getParam(SysFunctionCode.OUT_PRESCRIPTION_SIGN_TEMPLATE_CONFIG).getDataList();
			if(params.length>0){
				Param param=params[0];
				String tempCode=param.getValue();
				MrFrTemplate mrFrTemplate=mrFrTplService.searchById(tempCode).getData();
				if(null!=mrFrTemplate){
					String filePk=mrFrTemplate.getFilePk();
					FileObject fileObject=fileService.getFile(filePk);
					if(null!=fileObject){
						prescriptionAndDisposal.setPrescriptionsSignTemplateFile(new String(fileObject.asByteArray()));
					}else{
						Notification notification = new Notification(MessageCode.FILE_GET_FATAL, "处方占位小模板文件："+filePk);
						throw new NotificationException(notification);
					}
				}else{
					Notification notification = new Notification(MessageCode.OUT_PRESCRIPTION_SIGN_TEMPLATE_NOT_EXITS, tempCode);
					throw new NotificationException(notification);
				}
			}else{
				Notification notification = new Notification(MessageCode.OUT_PRESCRIPTION_SIGN_TEMPLATE_NOT_SET);
				throw new NotificationException(notification);
			}
		}
		if(cpmPrescriptionsList.size()==0){
			Param[] params=paramsService.getParam(SysFunctionCode.OUT_CPM_PRESCRIPTION_SIGN_TEMPLATE_CONFIG).getDataList();
			if(params.length>0){
				Param param=params[0];
				String tempCode=param.getValue();
				MrFrTemplate mrFrTemplate=mrFrTplService.searchById(tempCode).getData();
				if(null!=mrFrTemplate){
					String filePk=mrFrTemplate.getFilePk();
					FileObject fileObject=fileService.getFile(filePk);
					if(null!=fileObject){
						prescriptionAndDisposal.setCpmPrescriptionsSignTemplateFile(new String(fileObject.asByteArray()));
					}else{
						Notification notification = new Notification(MessageCode.FILE_GET_FATAL, "中成药处方占位小模板文件："+filePk);
						throw new NotificationException(notification);
					}
				}else{
					Notification notification = new Notification(MessageCode.FILE_GET_FATAL, "中成药处方占位小模板："+tempCode);
					throw new NotificationException(notification);
				}
			}else{
				Notification notification = new Notification(MessageCode.OUT_CPM_PRESCRIPTION_SIGN_TEMPLATE_NOT_SET);
				throw new NotificationException(notification);
			}
		}else if(cpmPrescriptionsList.size()>0){
			Param[] params=paramsService.getParam(SysFunctionCode.OUT_CPM_PRESCRIPTION_TEMPLATE_CONFIG).getDataList();
			if(params.length>0){
				Param param=params[0];
				String tempCode=param.getValue();
				MrFrTemplate mrFrTemplate=mrFrTplService.searchById(tempCode).getData();
				if(null!=mrFrTemplate){
					String filePk=mrFrTemplate.getFilePk();
					FileObject fileObject=fileService.getFile(filePk);
					if(null!=fileObject){
						prescriptionAndDisposal.setCpmPrescriptionsTemplateFile(new String(fileObject.asByteArray()));
					}else{
						Notification notification = new Notification(MessageCode.FILE_GET_FATAL, "中成药处方小模板文件："+filePk);
						throw new NotificationException(notification);
					}
				}else{
					Notification notification = new Notification(MessageCode.FILE_GET_FATAL, "中成药处方小模板："+tempCode);
					throw new NotificationException(notification);
				}
			}else{
				Notification notification = new Notification(MessageCode.OUT_CPM_PRESCRIPTION_TEMPLATE_NOT_SET);
				throw new NotificationException(notification);
			}
		}
		if(cmFxdPrescriptionsList.size()>0){
			Param[] params=paramsService.getParam(SysFunctionCode.OUT_CFXD_PRESCRIPTION_TEMPLATE_CONFIG).getDataList();
			if(params.length>0){
				Param param=params[0];
				String tempCode=param.getValue();
				MrFrTemplate mrFrTemplate=mrFrTplService.searchById(tempCode).getData();
				if(null!=mrFrTemplate){
					String filePk=mrFrTemplate.getFilePk();
					FileObject fileObject=fileService.getFile(filePk);
					if(null!=fileObject){
						prescriptionAndDisposal.setCmFxdPrescriptionsTemplateFile(new String(fileObject.asByteArray()));
					}else{
						Notification notification = new Notification(MessageCode.FILE_GET_FATAL, "非协定草药药处方小模板文件："+filePk);
						throw new NotificationException(notification);
					}
				}else{
					Notification notification = new Notification(MessageCode.FILE_GET_FATAL, "非协定草药药处方小模板："+tempCode);
					throw new NotificationException(notification);
				}
			}else{
				Notification notification = new Notification(MessageCode.NOT_SET,"非协定草药药处方小模板");
				throw new NotificationException(notification);
			}
		}
		builder.withData(prescriptionAndDisposal);
		result = builder.build();
		return result;
    }
    /**
     * 补全分组信息
     * @param prescriptionsList
     * @return
     */
    public void convertToPrescription(OrderModel order,List<Prescription> prescriptionsList){
    	Prescription prescription=new Prescription();
		prescription.setName(IihUtils.strNullToNbsp(order.getSvNm()));
		prescription.setOrderSn(order.getOrPk()+"");
		prescription.setSpecifDosage(IihUtils.strNullToNbsp(order.getDosage()));
		prescription.setFrename(IihUtils.strNullToNbsp(order.getFreqNm()));
		prescription.setSupply(IihUtils.strNullToNbsp(order.getRouteNm()));
		prescription.setSpecification(IihUtils.strNullToNbsp(order.getSpec()));
		prescription.setChargeGroup(IihUtils.strNullToNbsp(order.getOrNoteNm()));
		if(null!=order.getParOrPk()&&(!"".equals(order.getParOrPk()))&&(!"0".equals(order.getParOrPk()))){
			prescription.setParentOrderSn(order.getParOrPk());
		}
		if(null!=order.getTakeAmountUnitNm()&&(!"".equals(order.getTakeAmountUnitNm()))){
			prescription.setDrugAmount(IihUtils.strNullToNbsp(order.getAmount())+order.getTakeAmountUnitNm());
		}else{
			prescription.setDrugAmount(IihUtils.strNullToNbsp(order.getAmount()));
		}
		prescriptionsList.add(prescription);
    }    
    /**
     * 补全分组信息
     * @param prescriptionsList
     * @return
     */
    public void setOrderGroup(List<Prescription> prescriptionsList){
    	for(Prescription prescription:prescriptionsList){
			if(haveSubOrder(prescription.getOrderSn(),prescriptionsList)){
				prescription.setParentOrderSn(prescription.getOrderSn());
			}
		}
    }
    
    /**
     * 根据医嘱编码判断该医嘱是否有子医嘱
     * @param orderSn
     * @param prescriptionsList
     * @return
     */
    public boolean haveSubOrder(String orderSn,List<Prescription> prescriptionsList){
    	for(Prescription prescription:prescriptionsList){
			if(orderSn.equals(prescription.getParentOrderSn())){
				return true;
			}
		}
		return false;
    }
    
    /**
     * 排序
     * @param prescriptionsList
     * @return
     */
    private List<Prescription> sortOrderByParentOrderSn(List<Prescription> prescriptionsList) {
    	List<Prescription> newPrescriptionsList =new ArrayList<Prescription>();
    	for(Prescription prescription:prescriptionsList){
    		if(prescription.getOrderSn().equals(prescription.getParentOrderSn())){
    			List<Prescription> subList=getSubPrescriptionsList(prescription,prescriptionsList);
    			newPrescriptionsList.add(prescription);
    			newPrescriptionsList.addAll(subList);
    		}else if(null==prescription.getParentOrderSn()||"".equals(prescription.getParentOrderSn())||"0".equals(prescription.getParentOrderSn())){
    			newPrescriptionsList.add(prescription);
    		}
    	}
		return newPrescriptionsList;
	}
    
    /**
     * 获取子医嘱列表 
     * @param prescription
     * @param prescriptionsList
     * @return
     */
    private List<Prescription> getSubPrescriptionsList(Prescription prescription, List<Prescription> prescriptionsList) {
		List<Prescription> subPrescriptionsList =new ArrayList<Prescription>(); 
		for(Prescription prescription2:prescriptionsList){
			if(prescription.getOrderSn().equals(prescription2.getParentOrderSn())&&(!prescription2.getOrderSn().equals(prescription2.getParentOrderSn()))){
				subPrescriptionsList.add(prescription2);
			}
		}
		return subPrescriptionsList;
	}
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * pkuhit.iih.iemr.mr.MacroElementService#searchAllPrescriptionByEnPk(java
	 * .lang.String)
	 */
/*	@Override
	public SingleResult<RefreshPrescription> searchAllPrescriptionByEnPk(
			String id) throws Throwable {
		SingleResult<RefreshPrescription> result = null;
		SingleResultBuilder<RefreshPrescription> builder = SingleResultBuilder
				.newSingleResult(RefreshPrescription.class);
		OrderModel[] orders = orderService.search(id, null, null).getDataList();
		RefreshPrescription refreshPrescription = new RefreshPrescription();
		refreshPrescription.setPrescriptionsTemplateFile("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X9iPFOKZvQ7UAUzJ08fnv/nov89/V8DZrfb96qx58dOn5z//2+tizfm//3nx1QevizX37m6ypFvzIr1lnfq92rJbXnA3xZjbHGPudjHGjnbq8bCGvaZ/3RS4V5iCoX38zbNnkoEtrWINkKw4xF7G12TY2C4o5ZcYrpqugv24q2ngPw4pc4mmi0/+taOZHtYSVP6p5ZUiNVUyUNf8/z4c/w9QSwcIEiDS0U8LAAA3QgAAUEsDBBQAAAgAALhgkUaT++ApnQMAAJ0DAAAIAAAAbWV0YS54bWw8P3htbCB2ZXJzaW9uPSIxLjAiIGVuY29kaW5nPSJVVEYtOCI/Pgo8b2ZmaWNlOmRvY3VtZW50LW1ldGEgeG1sbnM6b2ZmaWNlPSJ1cm46b2FzaXM6bmFtZXM6dGM6b3BlbmRvY3VtZW50OnhtbG5zOm9mZmljZToxLjAiIHhtbG5zOnhsaW5rPSJodHRwOi8vd3d3LnczLm9yZy8xOTk5L3hsaW5rIiB4bWxuczpkYz0iaHR0cDovL3B1cmwub3JnL2RjL2VsZW1lbnRzLzEuMS8iIHhtbG5zOm1ldGE9InVybjpvYXNpczpuYW1lczp0YzpvcGVuZG9jdW1lbnQ6eG1sbnM6bWV0YToxLjAiIHhtbG5zOm9vbz0iaHR0cDovL29wZW5vZmZpY2Uub3JnLzIwMDQvb2ZmaWNlIiB4bWxuczpncmRkbD0iaHR0cDovL3d3dy53My5vcmcvMjAwMy9nL2RhdGEtdmlldyMiIG9mZmljZTp2ZXJzaW9uPSIxLjIiPjxvZmZpY2U6bWV0YT48bWV0YTpjcmVhdGlvbi1kYXRlPjIwMTQtMDktMjZUMTc6MzQ6NTQuMDY8L21ldGE6Y3JlYXRpb24tZGF0ZT48bWV0YTpnZW5lcmF0b3I+T3Blbk9mZmljZS80LjAuMCRXaW4zMiBPcGVuT2ZmaWNlLm9yZ19wcm9qZWN0LzQwMG0zJEJ1aWxkLTk3MDI8L21ldGE6Z2VuZXJhdG9yPjxkYzpkYXRlPjIwMTUtMDQtMTdUMjA6MDU6NDguNjQ8L2RjOmRhdGU+PG1ldGE6ZWRpdGluZy1kdXJhdGlvbj5QMkRUMkgzMk0yMFM8L21ldGE6ZWRpdGluZy1kdXJhdGlvbj48bWV0YTplZGl0aW5nLWN5Y2xlcz4xMjwv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");
		List<Prescription> preList = new ArrayList<Prescription>();
		for (OrderModel order : orders) {
			if ("04".equals(order.getOrTpCd())||"05".equals(order.getOrTpCd())) {
			Prescription prescription = new Prescription();
			prescription.setName(IihUtils.strNullToNbsp(order.getSvNm()));
			prescription.setSpecifDosage(IihUtils.strNullToNbsp(order.getDosage()));
			prescription.setFrename(IihUtils.strNullToNbsp(order.getFreqNm()));
			prescription.setSupply(IihUtils.strNullToNbsp(order.getRouteNm()));
			prescription.setSpecifDosage(IihUtils.strNullToNbsp(order.getSpec()));
			prescription.setChargeGroup(IihUtils.strNullToNbsp(order.getInsruGrdNm()));
			prescription.setDrugAmount(IihUtils.strNullToNbsp(order.getTakeAmount()));
			preList.add(prescription);
			}
		}
		refreshPrescription.setPrescriptions(preList);
		builder.withData(refreshPrescription);
		result = builder.build();
		return result;
	}*/
}
