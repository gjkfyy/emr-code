package pkuhit.iih.qa.qacustom;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.seasar.doma.jdbc.SelectOptions;
import org.springframework.beans.factory.annotation.Autowired;

import pkuhit.iih.ass.di.AssDiagnosisService;
import pkuhit.iih.di.DiagnosisModel;
import pkuhit.iih.qa.QaFault;
import pkuhit.iih.qa.QaNotification;
import pkuhit.iih.qa.QaWork;
import pkuhit.iih.qa.dao.auto.QaFltDao;
import pkuhit.iih.qa.dao.auto.QaRevisionNoticeDao;
import pkuhit.iih.qa.dao.auto.entity.QaFlt;
import pkuhit.iih.qa.dao.auto.entity.QaRevisionNotice;
import pkuhit.iih.qa.dao.qacustom.CusQaRevisionNoticeDao;
import pkuhit.iih.qa.dao.qacustom.CustomQaFaultDao;
import pkuhit.iih.qa.md.QaFltStatus;
import pkuhit.iih.qa.md.QaRevisionNoticeStatus;
import pkuhit.iih.qa.qacustom.bizmodel.CusQaFault;
import pkuhit.iih.qa.qacustom.bizmodel.QaFaultStatistical;
import pkuhit.iih.qa.util.QaUtil;
import pkuhit.md.DictionaryService;
import pkuhit.xap.ac.Session;
import pkuhit.xap.util.BeanCopyUtil;
import xap.sv.annotation.Reference;
import xap.sv.event.engin.EventEngin;
import xap.sv.model.ArrayResult;
import xap.sv.model.ArrayResultBuilder;
import xap.sv.model.SingleResult;
import xap.sv.model.SingleResultBuilder;

/**
 * 
 * <p>QaNotificationServiceImpl</p>
 * <p>整改通知服务实现</p>
 *
 * @author		chengfeng(cheng_feng@founder.com)
 * @version		0.0.0
 */
public class QaNotificationServiceImpl implements QaNotificationService {

	@Autowired
	QaRevisionNoticeDao qaRevisionNoticeDao;
	
	@Autowired
	CusQaRevisionNoticeDao cusQaRevisionNoticeDao;
	
	@Autowired
	QaFltDao qaFltDao;
	
	@Autowired
	CustomQaFaultDao customQaFaultDao;
	
	@Reference
	DictionaryService dictionaryService;
	
	@Autowired
	AssDiagnosisService diService;
	
	@Reference
	EventEngin eventEngin;
	
	public QaNotificationServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public ArrayResult<QaNotification> searchQaRevisionNotice(Map map)
			throws Throwable {
		ArrayResultBuilder<QaNotification> builder = ArrayResultBuilder.newArrayResult(QaNotification.class);
		Session session = Session.get();
		String userId = session.getUserId();
		String deptId = session.getDeptId();
		String workScreen = QaUtil.getStringValueFromMap(map, "workScreen");
		if(workScreen.isEmpty()){
			workScreen = "1";
		}
		String qaTypeCode = QaUtil.getStringValueFromMap(map, "qaTypeCode");
		String verifiedDeadline = QaUtil.getStringValueFromMap(map, "verifiedDeadline");
		int verified = 0;
		if(verifiedDeadline!=null){
			verified = Integer.valueOf(verifiedDeadline)*24*60;
		}
//		String pageNum = getStringValueFromMap(map, "pageNum");
//		String pageSize = getStringValueFromMap(map, "pageSize");
//		if(StringUtils.isBlank(pageNum)){
//			pageNum = "1" ;
//		}
//		if(StringUtils.isBlank(pageSize)){
//			pageSize = "25" ;
//		}
//		SelectOptions options = SelectOptions.get().offset((Integer.valueOf(pageNum)-1)*Integer.valueOf(pageSize)).limit(Integer.valueOf(pageSize)).count();
		
		List<Map<String, Object>> mapList = cusQaRevisionNoticeDao.selectQaRevisionNotice(qaTypeCode, userId, deptId, workScreen, verified);
		int total = 0;
		if(mapList!=null && mapList.size()>0){
//			long count = options.getCount();
			total = mapList.size();//Long.valueOf(count).intValue();
			QaNotification[] qaNotificationArr = new QaNotification[mapList.size()]; 
			for(int i=0;i<mapList.size();i++){
				QaNotification qaNotification = new QaNotification();
				Map<String, Object> qaRevisionNoticeMap = mapList.get(i);
				BeanCopyUtil.mapToModel(qaNotification, qaRevisionNoticeMap, dictionaryService);
				int faultNum = getFaultNumByRevisionCd(qaNotification.getRevisionCd());
				qaNotification.setDefectCount(faultNum);
				
//				从视图中获取主诊断
				ArrayResult<DiagnosisModel> diList = diService.search(qaNotification.getEnPk(), "1", null, null, null);
				if(diList != null && diList.getDataList() != null){
				    DiagnosisModel[] diArr = diList.getDataList();
				    if(diArr != null && diArr.length>0){
				    	qaNotification.setCurrentMainDiagnosisCode(diArr[0].getDiPk());
				    	qaNotification.setCurrentMainDiagnosisName(diArr[0].getDiNm());
				    }
				}
				qaNotificationArr[i] = qaNotification;
			}
			builder.withData(qaNotificationArr);
		}
		ArrayResult<QaNotification> qaNotificationResult = builder.build();
		qaNotificationResult.setTotal(total);
//		qaNotificationResult.setPageNum(Integer.valueOf(pageNum)); 
//		qaNotificationResult.setPageSize(Integer.valueOf(pageSize));
		return qaNotificationResult;
	}
	
	//开始整改
	@Override
	public SingleResult<QaNotification> startRfmRevisionNotice(String revisionCd)
			throws Throwable {
		SingleResultBuilder<QaNotification> builder = SingleResultBuilder.newSingleResult(QaNotification.class);
		try{
			QaRevisionNotice qaRevisionNotice = qaRevisionNoticeDao.selectById(revisionCd);
			if(qaRevisionNotice!=null){
				qaRevisionNotice.setStatus(QaRevisionNoticeStatus.REFORMING);
				qaRevisionNoticeDao.updateExcludeNull(qaRevisionNotice);
				//修改任务状态
				QaNotification qaNotification = new QaNotification();
				BeanCopyUtil.entityToModel(qaNotification, qaRevisionNotice, QaNotification.OBJ_CD, dictionaryService);
				Map<String, Object> map=new HashMap<String, Object>();
				map.put("qaNotification", qaNotification);
				eventEngin.fire("TASK_NOTICE_HANDLE", map);
			}
		}catch (Exception e) {
            throw new RuntimeException(e);
        }
		return builder.build();
	}
	
	//完成整改
	@Override
//	@Transactional(rollbackFor = { RuntimeException.class })
	public SingleResult<QaNotification> finishRfmRevisionNotice(String revisionCd)
			throws Throwable {
		SingleResultBuilder<QaNotification> builder = SingleResultBuilder.newSingleResult(QaNotification.class);
		Session session = Session.get();
		Timestamp ts = new Timestamp(System.currentTimeMillis());
		try{
//			if(!isExistToReformFault(revisionCd)){
				QaRevisionNotice qaRevisionNotice = qaRevisionNoticeDao.selectById(revisionCd);
				if(qaRevisionNotice!=null){
					qaRevisionNotice.setStatus(QaRevisionNoticeStatus.REFORMED);
					qaRevisionNotice.setRfmTime(ts);
					qaRevisionNoticeDao.updateExcludeNull(qaRevisionNotice);
					//修改任务状态
					QaNotification qaNotification = new QaNotification();
					BeanCopyUtil.entityToModel(qaNotification, qaRevisionNotice, QaNotification.OBJ_CD, dictionaryService);
					Map<String, Object> map=new HashMap<String, Object>();
					map.put("qaNotification", qaNotification);
					eventEngin.fire("TASK_NOTICE_HANDLE", map);
				}
//			}
		}catch (Exception e) {
            throw new RuntimeException(e);
        }
		return builder.build();
	}
	
	
	@Override
//	@Transactional(rollbackFor = { RuntimeException.class })
	public SingleResult<QaNotification> finishQaRevisionNotice(String revisionCd)
			throws Throwable {
		SingleResultBuilder<QaNotification> builder = SingleResultBuilder.newSingleResult(QaNotification.class);
		Session session = Session.get();
		String userId = session.getUserId();
		String deptId = session.getDeptId();
		Timestamp ts = new Timestamp(System.currentTimeMillis());
		try{
			if(!isExistToReformFault(revisionCd) && !isExistReformedFault(revisionCd)){
				QaRevisionNotice qaRevisionNotice = qaRevisionNoticeDao.selectById(revisionCd);
				if(qaRevisionNotice!=null){
					qaRevisionNotice.setVrfUserId(userId);
					qaRevisionNotice.setVrfDeptCd(deptId);
					qaRevisionNotice.setVrfTime(ts);
					qaRevisionNotice.setStatus(QaRevisionNoticeStatus.VERIFIED);
					qaRevisionNotice.setCmplF("1");
					qaRevisionNoticeDao.updateExcludeNull(qaRevisionNotice);
					//修改缺陷信息
					modifyFault(userId, deptId, ts, revisionCd);
				}
//				Notification notification = new Notification(MessageCode.COMPLETED_REVISION_NOTICE);
//				throw new NotificationException(notification);
				builder.withData(qaRevisionNotice);
			}
		}catch (Exception e) {
            throw new RuntimeException(e);
        }
		return builder.build();
	}
	
	@Override
	public String notificationFaultStatistical(Map map) throws Throwable {
		String str = "0";//返回结果如果为空字符串报错，0为默认返回结果
		String revisionCd = QaUtil.getStringValueFromMap(map, "revisionCd");
		String workScreen = QaUtil.getStringValueFromMap(map, "workScreen");
		SingleResult<QaFaultStatistical>  statisticalResult = faultStatistical(revisionCd);
		if(statisticalResult.getData()!=null){
			QaFaultStatistical qaFaultStatistical = statisticalResult.getData();
			BigDecimal toReform=qaFaultStatistical.getToReform();
			int toReformNum = 0;
			if(toReform!=null){
				toReformNum = toReform.intValue();
			}
			BigDecimal reformed=qaFaultStatistical.getReformed();
			int reformedNum = 0;
			if(reformed!=null){
				reformedNum = reformed.intValue();
			}
			if("2".equals(workScreen)||"5".equals(workScreen)||"9".equals(workScreen)){
				if(reformedNum>0){ //存在未审核的缺陷
					str = "1";
				} else if(toReformNum>0){ //存在再整改的缺陷
					str = "2";
				} else {
					str = "3";
				}
			}else if("3".equals(workScreen)||"6".equals(workScreen)||"10".equals(workScreen)){
				if(toReformNum>0){ //存在待整改的缺陷
					str = "2";
				}
			}
		}
		return str;
	}

	@Override
	public SingleResult<CusQaFault> searchQaFaultByRevisionCd(Map map) throws Throwable {
		SingleResultBuilder<CusQaFault> builder = SingleResultBuilder.newSingleResult(CusQaFault.class);
		ArrayResultBuilder<QaFault> arrayBuilder = ArrayResultBuilder.newArrayResult(QaFault.class);
		CusQaFault cusQaFault = new CusQaFault();
		String revisionCd = QaUtil.getStringValueFromMap(map, "revisionCd");
		String pageNum="",pageSize="";
		if(StringUtils.isBlank(pageNum)){
			pageNum = "1" ;
		}
		if(StringUtils.isBlank(pageSize)){
			pageSize = "10000" ;
		}
		SelectOptions options = SelectOptions.get().offset((Integer.valueOf(pageNum)-1)*Integer.valueOf(pageSize)).limit(Integer.valueOf(pageSize)).count();
		List<Map<String, Object>> mapList = customQaFaultDao.selectQaFaultByCondition("", "", "", "", "", "", "" ,revisionCd, options);
		int total = 0;
		if(mapList!=null && mapList.size()>0){
			QaFault[] qaFaultArr = new QaFault[mapList.size()]; 
			total = Long.valueOf(options.getCount()).intValue();
			for(int i=0;i<mapList.size();i++){
				QaFault qaFault = new QaFault();
				Map<String, Object> qaFaultMap = mapList.get(i);
				BeanCopyUtil.mapToModel(qaFault, qaFaultMap, dictionaryService);
				qaFaultArr[i] = qaFault;
			}
			arrayBuilder.withData(qaFaultArr);
		}
		ArrayResult<QaFault> qaFaultArrayResult = arrayBuilder.build();
		qaFaultArrayResult.setTotal(total);			
		cusQaFault.setRevisionCd(revisionCd);
		cusQaFault.setQaFaultList(qaFaultArrayResult);
		builder.withData(cusQaFault);
		return builder.build();
	}
	
	
	@Override
	public SingleResult<CusQaFault> searchQaFaultByPk(Map map) throws Throwable {
		SingleResultBuilder<CusQaFault> builder = SingleResultBuilder.newSingleResult(CusQaFault.class);
		ArrayResultBuilder<QaFault> arrayBuilder = ArrayResultBuilder.newArrayResult(QaFault.class);
		CusQaFault cusQaFault = new CusQaFault();
		String pk = QaUtil.getStringValueFromMap(map, "pk");
		String pageNum="",pageSize="";
		if(StringUtils.isBlank(pageNum)){
			pageNum = "1" ;
		}
		if(StringUtils.isBlank(pageSize)){
			pageSize = "10000" ;
		}
		SelectOptions options = SelectOptions.get().offset((Integer.valueOf(pageNum)-1)*Integer.valueOf(pageSize)).limit(Integer.valueOf(pageSize)).count();
		List<Map<String, Object>> mapList = customQaFaultDao.selectQaFaultList(pk, options);
		int total = 0;
		if(mapList!=null && mapList.size()>0){
			QaFault[] qaFaultArr = new QaFault[mapList.size()]; 
			total = Long.valueOf(options.getCount()).intValue();
			for(int i=0;i<mapList.size();i++){
				QaFault qaFault = new QaFault();
				Map<String, Object> qaFaultMap = mapList.get(i);
				BeanCopyUtil.mapToModel(qaFault, qaFaultMap, dictionaryService);
				qaFaultArr[i] = qaFault;
			}
			arrayBuilder.withData(qaFaultArr);
		}
		ArrayResult<QaFault> qaFaultArrayResult = arrayBuilder.build();
		qaFaultArrayResult.setTotal(total);			
		cusQaFault.setQaFaultList(qaFaultArrayResult);
		builder.withData(cusQaFault);
		return builder.build();
	}
	
	private void modifyFault(String vrfUserId, String vrfDeptCd, Timestamp vrfTime, String revisionCd) throws Throwable{
		String pageNum="",pageSize="";
		if(StringUtils.isBlank(pageNum)){
			pageNum = "1" ;
		}
		if(StringUtils.isBlank(pageSize)){
			pageSize = "10000" ;
		}
		SelectOptions options = SelectOptions.get().offset((Integer.valueOf(pageNum)-1)*Integer.valueOf(pageSize)).limit(Integer.valueOf(pageSize)).count();
		List<Map<String, Object>> mapList = customQaFaultDao.selectQaFaultByCondition("", "", "", "", "","", "", revisionCd, options);
		if(mapList!=null && mapList.size()>0){
			for(int i=0;i<mapList.size();i++){
				QaFault qaFault = new QaFault();
				QaFlt qaFlt = new QaFlt();
				Map<String, Object> qaFaultMap = mapList.get(i);
				BeanCopyUtil.mapToModel(qaFault, qaFaultMap, dictionaryService);
				qaFault.setVrfUserId(vrfUserId);
				qaFault.setVrfDeptCd(vrfDeptCd);
				qaFault.setVrfTime(vrfTime);
				BeanCopyUtil.modelToEntity(qaFlt, qaFault);
				qaFltDao.updateExcludeNull(qaFlt);
			}
		}
	}
	
	private SingleResult<QaFaultStatistical> faultStatistical(String revisionCd) throws Throwable {
		SingleResultBuilder<QaFaultStatistical> builder = SingleResultBuilder.newSingleResult(QaFaultStatistical.class);
		Map map = cusQaRevisionNoticeDao.selectFaultStatistical(revisionCd);
		QaFaultStatistical 	qaFaultStatistical = new QaFaultStatistical();
		BeanCopyUtil.mapToModel(qaFaultStatistical, map, dictionaryService);
		builder.withData(qaFaultStatistical);
		return builder.build();
	}
	
	private boolean isExistToReformFault(String revisionCd) throws Throwable {
		boolean b = false;
		SingleResult<QaFaultStatistical>  statisticalResult = faultStatistical(revisionCd);
		if(statisticalResult.getData()!=null){
			QaFaultStatistical qaFaultStatistical = statisticalResult.getData();
			BigDecimal toReform=qaFaultStatistical.getToReform();
			int toReformNum = 0;
			if(toReform!=null){
				toReformNum = toReform.intValue();
			}
			if(toReformNum>0){
				b = true;
			}
		}
		return b;
	}
	
	private boolean isExistReformedFault(String revisionCd) throws Throwable {
		boolean b = false;
		SingleResult<QaFaultStatistical>  statisticalResult = faultStatistical(revisionCd);
		if(statisticalResult.getData()!=null){
			QaFaultStatistical qaFaultStatistical = statisticalResult.getData();
			BigDecimal reformed=qaFaultStatistical.getReformed();
			int reformedNum = 0;
			if(reformed!=null){
				reformedNum = reformed.intValue();
			}
			if(reformedNum>0){
				b = true;
			}
		}
		return b;
	}
	
	private int getFaultNumByRevisionCd(String revisionCd) throws Throwable {
		int allFaultNum = 0;
		SingleResult<QaFaultStatistical>  statisticalResult = faultStatistical(revisionCd);
		if(statisticalResult.getData()!=null){
			QaFaultStatistical qaFaultStatistical = statisticalResult.getData();
			BigDecimal allFault=qaFaultStatistical.getAllFaultNum();
			if(allFault!=null){
				allFaultNum = allFault.intValue();
			}
		}
		return allFaultNum;
	}

	@Override
	public ArrayResult<QaWork> searchInprocessWork(Map map)
			throws Throwable {
		/*查询条件*/
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//定义格式，不显示毫秒
		SimpleDateFormat tsdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//定义格式，不显示毫秒
		String crtTimeStart = null;
		String crtTimeEnd = null;
		String rfmTimeStart = null;
		String rfmTimeEnd = null;	
		Timestamp ts = new Timestamp(System.currentTimeMillis());//系统当前时间
		ts.getTime();
		String crtTimeStartValue = QaUtil.getStringValueFromMap(map, "crtTimeStart");//质控日期开始时间
		if(crtTimeStartValue != null){
			long startLong = Long.parseLong(crtTimeStartValue);
			crtTimeStart = df.format(startLong);
			crtTimeStart +=" 00:00:00";
		}
		String crtTimeEndValue = QaUtil.getStringValueFromMap(map, "crtTimeEnd");// 结束日期
		if(crtTimeEndValue != null){
			long endLong = Long.parseLong(crtTimeEndValue);
			crtTimeEnd = df.format(endLong);
			crtTimeEnd +=" 23:59:59";
		}else{
			Long tsTime = ts.getTime();
			crtTimeEnd = tsdf.format(tsTime);
		}
		String amrNo = QaUtil.getStringValueFromMap(map, "amrNo");//住院号
		String crtUserNm = QaUtil.getStringValueFromMap(map, "crtUserNm");//质控医师
		String curDeptNm = QaUtil.getStringValueFromMap(map, "curDeptNm"); //质控科室
		String rfmTimeStartValue = QaUtil.getStringValueFromMap(map, "rfmTimeStart");//整改日期开始时间
		//wangyanli add 添加条件，区分护士、医生（如果登录用户为护士权限，则不能看到医生质控相关内容，医生同理）
		String isNurseRole =  QaUtil.getStringValueFromMap(map, "isNurseRole");
		if(rfmTimeStartValue != null){
			long startLong = Long.parseLong(rfmTimeStartValue);
			rfmTimeStart = df.format(startLong);
			rfmTimeStart +=" 00:00:00";
		}
		String rfmTimeEndValue = QaUtil.getStringValueFromMap(map, "rfmTimeEnd");// 结束日期
		if(rfmTimeEndValue != null){
			long endLong = Long.parseLong(rfmTimeEndValue);
			rfmTimeEnd = df.format(endLong);
			rfmTimeEnd +=" 23:59:59";
		}else{
			Long tsTime = ts.getTime();
			rfmTimeEnd = tsdf.format(tsTime);
		}
		String currentManageDoctorName = QaUtil.getStringValueFromMap(map, "currentManageDoctorName"); //整改医师
		String pageNum = null;
		String pageSize = null;
		if(map.containsKey("pageNum") && map.containsKey("pageSize")){
			pageNum = (String)map.get("pageNum");
			pageSize = (String)map.get("pageSize");
		}
		if(null == pageNum || !StringUtils.isNumeric(pageNum)   || null == pageSize || !StringUtils.isNumeric(pageSize)  )
		{
			pageNum= "1";
			pageSize = "25";
		}
		/*质控工作记录对象查询条件*/
		Session session = Session.get();
		String workScreen =  QaUtil.getStringValueFromMap(map, "workScreen"); //工作场景
		String qaTypeCode = QaFltStatus.QA_TY_CD_PROCESS;//环节质控
		
		ArrayResultBuilder<QaWork> builder = ArrayResultBuilder.newArrayResult(QaWork.class);
		List<Map<String, Object>> qaList = null; //患者列表
		//质控信息
		Map<String, Object> amrMap = null;

		SelectOptions options = SelectOptions.get().offset((Integer.valueOf(pageNum)-1)*Integer.valueOf(pageSize)).limit(Integer.valueOf(pageSize)).count();			
		qaList = cusQaRevisionNoticeDao.selectQaByCondition(qaTypeCode, crtTimeStart, crtTimeEnd,amrNo ,crtUserNm, curDeptNm, rfmTimeStart, rfmTimeEnd,currentManageDoctorName,isNurseRole,options);
		int total = 0;
		if(qaList!=null&&qaList.size()>0){
			long count = options.getCount();
			total = Long.valueOf(count).intValue();
			QaWork [] qaWorks=new QaWork[qaList.size()];
			for(int i=0;i<qaList.size();i++){
				QaWork qaWork = new QaWork();
				amrMap = qaList.get(i);
				BeanCopyUtil.mapToModel(qaWork, amrMap, dictionaryService);
				if(qaWork.getRevisionCd()!= null && qaWork.getRevisionCd()!= ""){
					int faultNum = getFaultNumByRevisionCd(qaWork.getRevisionCd());
					qaWork.setDefectCount(faultNum);
					if(qaWork.getMemo() != null && qaWork.getMemo() != ""){
						qaWork.setRevisionMemo(qaWork.getMemo());
					}else{
						qaWork.setRevisionMemo("文书存在缺陷");
					}
				}else{
					qaWork.setRevisionMemo("未发现明显缺陷");
				}
				if(qaWork.getStatus() == null){
					qaWork.setStatusNM("&nbsp;&nbsp;&nbsp;--");
				}
				qaWork.setPk((String)qaList.get(i).get("EN_PK"));
				/*从视图中获取主诊断*/
				ArrayResult<DiagnosisModel> diList = diService.search(qaWork.getPk(), "1", null, null, null);
				if(diList != null && diList.getDataList() != null){
				    DiagnosisModel[] diArr = diList.getDataList();
				    if(diArr != null && diArr.length>0){
				    	qaWork.setCurrentMainDiagnosisCode(diArr[0].getDiPk());
				    	qaWork.setCurrentMainDiagnosisName(diArr[0].getDiNm());
				    }
				}
				qaWorks[i] = qaWork;
			}
			if(qaWorks!=null){
				builder.withData(qaWorks);
			}
		}
		ArrayResult<QaWork> amrResult = builder.build();
		amrResult.setTotal(total);
		return amrResult;
	} 
	
}
