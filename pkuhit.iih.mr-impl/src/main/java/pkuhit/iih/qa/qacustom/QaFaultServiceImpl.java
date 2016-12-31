package pkuhit.iih.qa.qacustom;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.seasar.doma.jdbc.SelectOptions;
import org.springframework.beans.factory.annotation.Autowired;

import pkuhit.iih.mr.wr.Amr;
import pkuhit.iih.pub.IihUtils;
import pkuhit.iih.qa.EmrEventModel;
import pkuhit.iih.qa.QaFault;
import pkuhit.iih.qa.QaNotification;
import pkuhit.iih.qa.QaRecord;
import pkuhit.iih.qa.cache.Cache;
import pkuhit.iih.qa.cache.CacheManager;
import pkuhit.iih.qa.dao.auto.QaDao;
import pkuhit.iih.qa.dao.auto.QaFltDao;
import pkuhit.iih.qa.dao.auto.QaRevisionNoticeDao;
import pkuhit.iih.qa.dao.auto.entity.Qa;
import pkuhit.iih.qa.dao.auto.entity.QaFlt;
import pkuhit.iih.qa.dao.auto.entity.QaRevisionNotice;
import pkuhit.iih.qa.dao.custom.CusQaFaultDao;
import pkuhit.iih.qa.dao.qacustom.CusQaMrAmrDao;
import pkuhit.iih.qa.dao.qacustom.CusQaRevisionNoticeDao;
import pkuhit.iih.qa.dao.qacustom.CustomQaFaultDao;
import pkuhit.iih.qa.md.QaFltStatus;
import pkuhit.iih.qa.md.QaRevisionNoticeStatus;
import pkuhit.iih.qa.qacustom.bizmodel.CusCreateQaFault;
import pkuhit.iih.qa.qacustom.bizmodel.CusQaFault;
import pkuhit.iih.qa.qacustom.bizmodel.QaFaultStatistical;
import pkuhit.iih.qa.util.QaUtil;
import pkuhit.md.DictionaryService;
import pkuhit.xap.ac.Session;
import pkuhit.xap.ac.User;
import pkuhit.xap.ac.UserRole;
import pkuhit.xap.ac.UserRoleService;
import pkuhit.xap.ac.UserService;
import pkuhit.xap.mes.Message;
import pkuhit.xap.mes.MessageService;
import pkuhit.xap.util.BeanCopyUtil;
import xap.sv.annotation.Reference;
import xap.sv.event.engin.EventEngin;
import xap.sv.model.ArrayResult;
import xap.sv.model.ArrayResultBuilder;
import xap.sv.model.SingleResult;
import xap.sv.model.SingleResultBuilder;
import xap.sv.notification.exception.NotificationException;
import xap.sv.util.UUIDGenerator;

/**
 * 
 * @author wang_yanli
 *
 */
public class QaFaultServiceImpl implements QaFaultService {

	//-------------------------cf add 2015-01-27 begin---------------------------
	@Autowired
	QaFltDao qaFltDao;
	
	@Autowired
	CusQaFaultDao cusFaultDao;
	
	@Autowired
	CusQaRevisionNoticeDao cusQaRevisionNoticeDao;
	
	@Reference
	DictionaryService dictionaryService;
	
	@Reference
	MessageService messageService;
	
	@Reference
	UserRoleService userRoleService;
	
	//-------------------------cf add 2015-01-27 end---------------------------
	
	@Autowired
	QaDao qaDao;

	@Reference
	pkuhit.iih.mr.wr.AmrService  amrService;
	
	@Reference
	UserService  userService;

	@Autowired
	CusQaMrAmrDao cusQaMrAmrDao;

	@Autowired
	CustomQaFaultDao cusQaFaultDao;
	
	@Autowired
	QaRevisionNoticeDao qaRevisionNoticeDao;
	
	@Reference
	EventEngin eventEngin;
	
	
	public QaFaultServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	//wangyanli保存质控缺陷服务实现
	@Override
	
	public ArrayResult<QaFault> create(CusCreateQaFault cqf) throws Throwable {
		Session session = Session.get();
		String userId = session.getUserId();
		String deptId = session.getDeptId();
		String enPk = cqf.getEnPk();
		String qaTypeCode = cqf.getQaTypeCode();
		String currentDeptCode = cqf.getCurrentDeptCode();
		String curMngDctId = cqf.getCurMngDctId();
		QaFault[] qaFaultArray = cqf.getQaFaultArray();
		try{
			Timestamp tm = new Timestamp(System.currentTimeMillis());
			if (qaFaultArray != null && qaFaultArray.length > 0) {
				String qaFaultPk = "";
				for (int i = 0; i < qaFaultArray.length; i++) {
					QaFault qaFault = qaFaultArray[i];
					qaFaultPk = UUIDGenerator.getUUID();
					qaFault.setQaFltPk(qaFaultPk);
					qaFault.setEnPk(enPk);
					qaFault.setSbmtTime(tm);
					qaFault.setSbmtUserId(userId);
					qaFault.setSbmtDeptCd(deptId);
					qaFault.setFltStaCd(QaFltStatus.TOREFORM);//初始录入时缺陷状态为：待整改
					qaFault.setRfmUserId(curMngDctId);
					qaFault.setRfmDeptCd(currentDeptCode);
					//保存缺陷记录
					QaFlt qaFlt = new QaFlt();
					BeanCopyUtil.modelToEntity(qaFlt, qaFault);
					qaFltDao.insert(qaFlt);
				}
			}
			
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		//~~~~~~~~~返回需要修改~~~~~~~~~
		Map param = new HashMap();
		param.put("encounterPk", enPk);
		param.put("qaTypeCode", qaTypeCode);
		param.put("submittedUserId", userId);
		SingleResult<CusQaFault> cusQaFault = search(param);
		ArrayResult<QaFault> qaFaultArrayResult = cusQaFault.getData().getQaFaultList();
		return qaFaultArrayResult;
	}

	
	@Override
	public SingleResult<QaFault> delete(String id) throws Throwable {
		QaFlt qaFlt= qaFltDao.selectById(id);
		qaFlt.setDelF((short)1);
		qaFltDao.markDelete(qaFlt);
		return SingleResultBuilder.newSingleResult(QaFault.class).build();
	}
	
	@Override
	public SingleResult<QaFault> edit(String id,QaFault value) throws Throwable {
		QaFlt qaFlt= qaFltDao.selectById(id);
		if(value.getRfmDes() != null){
			qaFlt.setRfmDes(value.getRfmDes());
		}
		qaFltDao.updateExcludeNull(qaFlt);
		return SingleResultBuilder.newSingleResult(QaFault.class).build();
	}

	@Override
	public SingleResult<CusQaFault> search(Map map) throws Throwable {
		
		SingleResultBuilder<CusQaFault> builder = SingleResultBuilder.newSingleResult(CusQaFault.class);
		
		if(map!=null){
			
			CusQaFault cusQaFault = new CusQaFault();
			
			//查询条件准备==================================开始===================================================
			String encounterPk = null ;
			//质控类型包括环节质控、科室质控、终末质控
			String qaTypeCode = null ;
			
			String workScreen = "";
			//关联的通知书编码（新建的缺陷不关联任何通知书）
			String revisionCd = "";
			if(map.containsKey("encounterPk")){
				encounterPk = map.get("encounterPk").toString();
			}
			if(map.containsKey("revisionCd")){
				revisionCd = map.get("revisionCd").toString();
			}
		
			Session session = Session.get();
			//当前登录者=提出人（SBMT_USER_ID）
			String userId = session.getUserId();
			//当前登录者部门=提出人所在科室（SBMT_DEPT_CD）
			String deptId = session.getDeptId();
			//当前登录者=提出人（SBMT_USER_ID）
			if(map.containsKey("workScreen")){
				workScreen = map.get("workScreen").toString();
			}
			String reformUserId = "";
			if(map.containsKey("reformUserId")){
				reformUserId = map.get("reformUserId").toString();
			}
			String reformDeptId = "";
			if(map.containsKey("reformDeptId")){
				reformDeptId = map.get("reformDeptId").toString();
			}
			//根据不同的工作场景查询给查询条件赋值1=环节质控工作、2=环节质控追踪、3=医生整改、4=终末质控工作、5=终末质控追踪、6=终末医生整改
			//QA_TY_CD质控类型
			//如果为环节质控工作：查询QA_TY_CD=QAM13.01、REVISION_CD is null、
			if("1".equals(workScreen)){
				qaTypeCode =  QaFltStatus.QA_TY_CD_PROCESS; //"QAM13.01";
				revisionCd = null;
				
			}else if("2".equals(workScreen)){
				qaTypeCode =  QaFltStatus.QA_TY_CD_PROCESS;
				
			}else if("3".equals(workScreen)){
				qaTypeCode =  QaFltStatus.QA_TY_CD_PROCESS;
				qaTypeCode =  QaFltStatus.QA_TY_CD_TERMINAL;
				if(reformUserId.isEmpty()){
					reformUserId = userId;
				}
				if(reformDeptId.isEmpty()){
					reformDeptId = deptId;
				}
				userId = "";
				deptId = "";
				
			}else if("4".equals(workScreen)){
				qaTypeCode =  QaFltStatus.QA_TY_CD_TERMINAL;
				revisionCd = null;
				
			}else if("5".equals(workScreen)){
				qaTypeCode =  QaFltStatus.QA_TY_CD_TERMINAL;
				
			}else if("6".equals(workScreen)){
				qaTypeCode =  QaFltStatus.QA_TY_CD_TERMINAL;
				if(reformUserId.isEmpty()){
					reformUserId = userId;
				}
				if(reformDeptId.isEmpty()){
					reformDeptId = deptId;
				}
				userId = "";
				deptId = "";
				
			}
			
			//添加分页部分
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
			//查询条件准备=======================================结束===========================================		
			
			ArrayResultBuilder<QaFault> arrayBuilder = ArrayResultBuilder.newArrayResult(QaFault.class);
			List<Map<String, Object>> qaFaultList = null;
			Map<String, Object> mapFault = null;
			SelectOptions options = SelectOptions.get().offset((Integer.valueOf(pageNum)-1)*Integer.valueOf(pageSize)).limit(Integer.valueOf(pageSize)).count();			
			long count = options.getCount();
			int total = Long.valueOf(count).intValue();
			
			qaFaultList = cusQaFaultDao.selectQaFaultByCondition(encounterPk, 
					qaTypeCode, null,  userId, deptId, reformUserId, reformDeptId,revisionCd, options);
			if(null != qaFaultList){
				if(qaFaultList.size()>0){
					QaFault[] qaFaultArray = new QaFault[qaFaultList.size()];
					for(int i=0;i<qaFaultList.size();i++){
						QaFault qaFault = new QaFault();
						mapFault = qaFaultList.get(i);
						BeanCopyUtil.mapToModel(qaFault, mapFault,dictionaryService);
						//qaFault.getStatusCode();
						//dictionaryService.getSimpleItems(QaFault.OBJ_CD, qaFault.getStatusCode());
						qaFaultArray[i] = qaFault;
					}
					if(qaFaultArray!=null){
						arrayBuilder.withData(qaFaultArray);
					}
				}
			}

			String btnFlag = QaUtil.amrFinishBtnFlag(cusQaMrAmrDao, dictionaryService, encounterPk, qaTypeCode);
			
			
			ArrayResult<QaFault> qaFaultArrayResult = arrayBuilder.build();
			qaFaultArrayResult.setTotal(total);			
			cusQaFault.setRevisionCd(revisionCd);
			cusQaFault.setQaFaultList(qaFaultArrayResult);
			cusQaFault.setBtnFlag(btnFlag);
			builder.withData(cusQaFault);
		}
		return builder.build();
	}


	
	//发送整改通知单
	public SingleResult<QaFault> submit(CusCreateQaFault param) throws Throwable {
		try {
			
			String workScreen = param.getWorkScreen();//1=环节工作、2=环节追踪、4=终末工作、5=终末追踪、8=科室工作、9=科室追踪
			if(workScreen.equals("2") || workScreen.equals("5") || workScreen.equals("9")){
				
				return reSubmitQaRevisionNotice(param);
			}
			// 质控完成时间=当前服务器系统时间
			int reformDeadline = param.getReformDeadline();
			String enPk = param.getEnPk();
			String qaTypeCode = param.getQaTypeCode();
			String reformMemo = param.getReformMemo();
			boolean haveFault = param.getHaveFault();
			String currentDeptCode = "";//患者当前科室编码
			String curMngDctId = "";//整改医生编码
			
			String menuCd = ""; //菜单编码
			String portalCd = ""; //portal编码
			//获得当前时间
			Date currentTime = new Date();
			
			Session s = Session.get();
			String userId = s.getUserId();
			String deptCode = s.getDeptId();

			String qaTypeName = "";
			String qaWorkCd = "";
			qaWorkCd = UUIDGenerator.getUUID();
			
			//是否护士角色  wangyanli 20160805
			String isNurseRole = "false";
			Session session = Session.get();
			String orgCd = session.getDeptId();//.getOrgCd();
			Map<String, String> params = new HashMap();
			params.put("userId", userId);
			params.put("orgCd", orgCd);
			ArrayResult<UserRole> userRoles = userRoleService.search(params);
			UserRole[] userRoleArray = userRoles.getDataList();
			for(UserRole userRole:userRoleArray){
				if(userRole.getRoleCode().equals("XAPM14.22")||userRole.getRoleCode().equals("XAPM14.23")){
					isNurseRole="true";
					break;
	    		}
			}
			//根据不同的工作场景查询给查询条件赋值1=环节质控工作、2=环节质控追踪、3=医生整改、4=终末质控工作、5=终末质控追踪、6=终末医生整改
			//QA_TY_CD质控类型
			//如果为环节质控工作：查询QA_TY_CD=QAM13.01、REVISION_CD is null、
			portalCd = isNurseRole.equals("false")? QaFltStatus.IIH_INP_FU_WK :QaFltStatus.IIH_INP_FU_WK_NUR;
			if("1".equals(workScreen)){
				qaTypeCode =  QaFltStatus.QA_TY_CD_PROCESS; //"QAM13.01" 环节质控
				menuCd = isNurseRole.equals("false")? QaFltStatus.QA_RFM_MENU_PROCESS :QaFltStatus.QA_RFM_MENU_PROCESS_NUR;
				qaTypeName = "环节质控：";
			}else if("4".equals(workScreen)){
				qaTypeCode =  QaFltStatus.QA_TY_CD_TERMINAL; //终末质控
				menuCd = isNurseRole.equals("false")? QaFltStatus.QA_RFM_MENU_TERMINAL :QaFltStatus.QA_RFM_MENU_TERMINAL_NUR;
				qaTypeName = "终末质控：";
			}else if("8".equals(workScreen)){
				qaTypeCode =  QaFltStatus.QA_TY_CD_DEPT; //科室质控
				menuCd = isNurseRole.equals("false")? QaFltStatus.QA_RFM_MENU_DEPT :QaFltStatus.QA_RFM_MENU_DEPT_NUR;
				qaTypeName = "科室质控：";
			}else if("13".equals(workScreen)){
				qaTypeCode =  QaFltStatus.QA_TY_CD_ORDER; //医嘱质控
				menuCd = QaFltStatus.QA_RFM_MENU_ORDER;
				qaTypeName = "医嘱质控：";
			}
			//如果有缺陷则完成三件事情：1、发送通知单；2、生成质控工作记录；3、生成消息
			if(haveFault){
				//查询当前就诊中未发送的缺陷，对应几个接收医生
				List<QaFlt> qaFltList = cusFaultDao.selectRfmUsersByEnpk(enPk);
				if(qaFltList!=null && qaFltList.size()>0){
					
					
					//根据医生生成缺陷通知单和质控工作记录
					for(int m=0;m<qaFltList.size();m++){
						QaFlt qaFltUser = qaFltList.get(m);
						currentDeptCode = qaFltUser.getRfmDeptCd();//患者当前科室编码
						curMngDctId = qaFltUser.getRfmUserId();//整改医生编码
						
						//1、生成通知单========================
						String qaNoticePk = "";
						Timestamp tm = new Timestamp(System.currentTimeMillis());
						QaRevisionNotice qaRevisionNotice = new QaRevisionNotice();
						qaNoticePk = UUIDGenerator.getUUID();
						qaRevisionNotice.setRevisionCd(qaNoticePk);//.setPk(qaNoticePk);
						qaRevisionNotice.setEnPk(enPk);
						qaRevisionNotice.setStatus(QaRevisionNoticeStatus.TOREFORM);//通知书的状态待整改
						qaRevisionNotice.setSendTime(tm);
						qaRevisionNotice.setExecDoctorCd(userId);
						qaRevisionNotice.setExecDeptCd(deptCode);
						BigInteger rfDeadline = BigInteger.valueOf((long) reformDeadline);
						qaRevisionNotice.setRfmDeadline(rfDeadline);
						
						if (currentTime != null) {
							Date deadLineDate = IihUtils.dateIncrease(currentTime, reformDeadline);
							Timestamp ts = new Timestamp(deadLineDate.getTime());
							qaRevisionNotice.setDeadline(ts);
						}
//						if("".equals(curMngDctId)){
//							curMngDctId = userId;
//						}
						
						qaRevisionNotice.setRfmDoctorCd(curMngDctId);
						qaRevisionNotice.setRfmDeptCd(currentDeptCode);
						qaRevisionNotice.setCmplF("0");
						qaRevisionNotice.setMemo(reformMemo);
						qaRevisionNotice.setQaTyCd(qaTypeCode);
						BeanCopyUtil.modelToEntity(qaRevisionNotice, qaRevisionNotice);
						qaRevisionNoticeDao.insert(qaRevisionNotice);
						
						//更新缺陷表 缺陷状态、任务主键========================QaRevisionNoticeDao
						//缺陷查询条件
						Map paramMap = new HashMap();
						paramMap.put("encounterPk", enPk);
						paramMap.put("qaTypeCode", qaTypeCode);
						paramMap.put("submittedUserId", userId);
						paramMap.put("reformDeptId", currentDeptCode);
						paramMap.put("reformUserId", curMngDctId);
						
						SingleResult<CusQaFault> cusQaFault = search(paramMap);
						ArrayResult<QaFault> qaFaultArrayResult = cusQaFault.getData().getQaFaultList();
						QaFault[] dataList = qaFaultArrayResult.getDataList();
						if(null != dataList){
							for(int i=0; i<dataList.length;i++){
								QaFault qaFault = dataList[i];
								qaFault.setRevisionCd(qaNoticePk);
								
								//更新缺陷
								QaFlt qaFlt = new QaFlt();
								BeanCopyUtil.modelToEntity(qaFlt, qaFault);
								qaFltDao.updateExcludeNull(qaFlt);
							}
						}
										
						//2、生成质控工作记录=================================
						String qaRecordPk = "";
						qaRecordPk = UUIDGenerator.getUUID();
						QaRecord qaRecord = new QaRecord();
						qaRecord.setPk(qaRecordPk);
						qaRecord.setEncounterPk(enPk);
						qaRecord.setQaTypeCode(qaTypeCode);
						qaRecord.setAutoFlag((short) 0);
						qaRecord.setHaveFaultFlag((short) 0); //？  如果有质控工作记录 是0 or 1？？？？？？？？？？？？？？？？？？？、
						qaRecord.setRevisionCd(qaNoticePk);
						qaRecord.setExcuteUserId(userId);
						qaRecord.setExecuteDeptCode(deptCode);
						qaRecord.setQaWorkCd(qaWorkCd);
						//保存质控工作记录
						Qa qa = new Qa();
						BeanCopyUtil.modelToEntity(qa, qaRecord);
						qaDao.insert(qa);
						
						//3、生成消息
						Message msg = new Message();
						String msgContent = qaTypeName+"患者【"+param.getPatientName()+"】的病历需要修改";
						String msgPk = UUIDGenerator.getUUID();
						msg.setMesId(msgPk);
						msg.setSendUserId(userId);//发送人-质控医生
						msg.setSendDate(tm);//发送时间
						msg.setReceiveUserId(curMngDctId);//接收人-整改医生
						msg.setReceiveDate(tm);
						msg.setPortalCd(portalCd);
						msg.setMenuCd(menuCd); //菜单编码
						msg.setContent(msgContent);
						msg.setReadFlag(0+""); //未读
						msg.setMesLevel((short)0); //级别问一般
						msg.setMesType("0");//质控消息
						//生成任务
						QaNotification qaNotification = new QaNotification();
						BeanCopyUtil.entityToModel(qaNotification, qaRevisionNotice, QaNotification.OBJ_CD, dictionaryService);
						Map<String, Object> map=new HashMap<String, Object>();
						map.put("qaNotification", qaNotification);
						map.put("msg", msg);
						eventEngin.fire("TASK_NOTICE", map);
						/*Message msg = new Message();
						String msgContent = qaTypeName+"患者【"+param.getPatientName()+"】的病历需要修改";
						String msgPk = UUIDGenerator.getUUID();
						msg.setMesId(msgPk);
						msg.setSendUserId(userId);//发送人-质控医生
						msg.setSendDate(tm);//发送时间
						msg.setReceiveUserId(curMngDctId);//接收人-整改医生
						msg.setReceiveDate(tm);
						msg.setPortalCd(QaFltStatus.IIH_INP_FU_WK);
						msg.setMenuCd(menuCd); //菜单编码
						msg.setContent(msgContent);
						msg.setReadFlag(0+""); //未读
						msg.setMesLevel((short)0); //级别问一般
						msg.setMesType("0");//质控消息
						messageService.sendMessage(msg);*/
						
					}
				}
				
			}else{
				//生成质控工作记录
				String qaRecordPk = "";
				qaRecordPk = UUIDGenerator.getUUID();
				QaRecord qaRecord = new QaRecord();
				qaRecord.setPk(qaRecordPk);
				qaRecord.setEncounterPk(enPk);
				qaRecord.setQaTypeCode(qaTypeCode);
				qaRecord.setAutoFlag((short) 0);
				qaRecord.setHaveFaultFlag((short) 1);
				qaRecord.setExcuteUserId(userId);
				qaRecord.setExecuteDeptCode(deptCode);
				qaRecord.setQaWorkCd(qaWorkCd);
				//保存质控工作记录
				Qa qa = new Qa();
				BeanCopyUtil.modelToEntity(qa, qaRecord);
				qaDao.insert(qa);
			}			
			//更新病案状态
			List<Map<String, Object>> mrAmrList = null; //患者-病案列表
			//质控信息
			mrAmrList = cusQaMrAmrDao.selectAmrByEnPkAndQaType(enPk);
			Map<String, Object> amrMap = null;
			
			if(null!= mrAmrList && mrAmrList.size()>0){
					Amr amr = new Amr();	
					amrMap = mrAmrList.get(0);
					BeanCopyUtil.mapToModel(amr, amrMap);
					if("1".equals(workScreen)){
						amr.setInprocess("1");
					}else if("4".equals(workScreen)){
						amr.setTerminal("1");
					}else if("8".equals(workScreen)){
						amr.setDeptTerminal("1");
					}
					
					String arPk = amr.getPk();
					if(arPk!=null){
						amrService.update(arPk, amr);
					}
			}
			
			return SingleResultBuilder.newSingleResult(QaFault.class).build();
		} catch (NotificationException e) {
			throw e;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	//再次发送整改通知单
	public SingleResult<QaFault> reSubmitQaRevisionNotice(CusCreateQaFault param) throws Throwable {
		try {
			String workScreen = param.getWorkScreen();//1=环节工作、2=环节追踪、4=终末工作、5=终末追踪、8=科室工作、9=科室追踪
			String revisionCd = param.getRevisionCd();
			// 质控完成时间=当前服务器系统时间
			int reformDeadline = param.getReformDeadline();
			String reformMemo = param.getReformMemo(); //整改说明
			//获得当前时间
			Date currentTime = new Date();
			if(null != revisionCd){
				
				//是否护士角色
				String isNurseRole = "false";
				Session session = Session.get();
				String userId = session.getUserId();
				String orgCd = session.getDeptId();//.getOrgCd();
				Map<String, String> params = new HashMap();
				params.put("userId", userId);
				params.put("orgCd", orgCd);
				ArrayResult<UserRole> userRoles = userRoleService.search(params);
				UserRole[] userRoleArray = userRoles.getDataList();
				for(UserRole userRole:userRoleArray){
					if(userRole.getRoleCode().equals("XAPM14.22")||userRole.getRoleCode().equals("XAPM14.23")){
						isNurseRole="true";
						break;
		    		}
				}
				
				QaRevisionNotice qaRevisionNotice = qaRevisionNoticeDao.selectById(revisionCd);
				if(qaRevisionNotice!=null){
					qaRevisionNotice.setStatus(QaRevisionNoticeStatus.TOREFORM);
					BigInteger rfDeadline = BigInteger.valueOf((long) reformDeadline);
					qaRevisionNotice.setRfmDeadline(rfDeadline);
					qaRevisionNotice.setMemo(reformMemo);
					Date deadLineDate = IihUtils.dateIncrease(currentTime,
							reformDeadline);
					Timestamp ts = new Timestamp(deadLineDate.getTime());
					qaRevisionNotice.setDeadline(ts);
					qaRevisionNoticeDao.updateExcludeNull(qaRevisionNotice);
					//生成消息
					Timestamp tm = new Timestamp(System.currentTimeMillis());
					String menuCd = ""; //菜单编码
					String portalCd ="";//门户编码
					String qaTypeName = "";
					//根据不同的工作场景查询给查询条件赋值1=环节质控工作、2=环节质控追踪、3=医生整改、4=终末质控工作、5=终末质控追踪、6=终末医生整改
					//QA_TY_CD质控类型
					//如果为环节质控工作：查询QA_TY_CD=QAM13.01、REVISION_CD is null、
					portalCd = isNurseRole.equals("false")? QaFltStatus.IIH_INP_FU_WK :QaFltStatus.IIH_INP_FU_WK_NUR;
					if("2".equals(workScreen)){
						
						menuCd = isNurseRole.equals("false")? QaFltStatus.QA_RFM_MENU_PROCESS :QaFltStatus.QA_RFM_MENU_PROCESS_NUR;
						
						qaTypeName = "环节质控：";
						
					}else if("5".equals(workScreen)){
						menuCd = isNurseRole.equals("false")? QaFltStatus.QA_RFM_MENU_TERMINAL :QaFltStatus.QA_RFM_MENU_TERMINAL_NUR;
						qaTypeName = "终末质控：";
						
					}else if("9".equals(workScreen)){
						menuCd = isNurseRole.equals("false")? QaFltStatus.QA_RFM_MENU_DEPT :QaFltStatus.QA_RFM_MENU_DEPT_NUR;
						qaTypeName = "科室质控：";
					}
					Message msg = new Message();
					String msgContent = qaTypeName+"患者【"+param.getPatientName()+"】的病历需要修改";
					String msgPk = UUIDGenerator.getUUID();
					msg.setMesId(msgPk);
					msg.setSendUserId(qaRevisionNotice.getCrtUserId());//发送人-质控医生
					msg.setSendDate(tm);//发送时间
					msg.setReceiveUserId(qaRevisionNotice.getRfmDoctorCd());//接收人-整改医生
					msg.setReceiveDate(tm);
					msg.setPortalCd(portalCd);
					msg.setMenuCd(menuCd); //菜单编码
					msg.setContent(msgContent);
					msg.setReadFlag(0+""); //未读
					msg.setMesLevel((short)0); //级别问一般
					msg.setMesType("0");//质控消息
					
					//生成任务
					QaNotification qaNotification = new QaNotification();
					BeanCopyUtil.entityToModel(qaNotification, qaRevisionNotice, QaNotification.OBJ_CD, dictionaryService);
					Map<String, Object> map=new HashMap<String, Object>();
					map.put("qaNotification", qaNotification);
					map.put("msg", msg);
					eventEngin.fire("TASK_NOTICE", map);
				}
			}		
			
			return SingleResultBuilder.newSingleResult(QaFault.class).build();
		} catch (NotificationException e) {
			throw e;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	//-------------------------cf add 2015-01-27 begin---------------------------

	@Override
	public SingleResult<QaFault> checkPass(String faultPk) throws Throwable {
		SingleResult<QaFault> qaFaultResult = updateQaFaultStatus(faultPk, QaFltStatus.VERIFIED);
		return qaFaultResult;
	}

	@Override
	public SingleResult<QaFault> deduction(String faultPk) throws Throwable {
		SingleResult<QaFault> qaFaultResult = updateQaFaultStatus(faultPk, QaFltStatus.DEDUCTIONED);
		return qaFaultResult;
	}

	@Override
	public SingleResult<QaFault> rectification(String faultPk) throws Throwable {
		SingleResult<QaFault> qaFaultResult = updateQaFaultStatus(faultPk, QaFltStatus.TOREFORM);
		return qaFaultResult;
	}
	
	@Override
	public SingleResult<QaFault> rfmDefect(String faultPk) throws Throwable {
		SingleResult<QaFault> qaFaultResult = updateQaFaultStatus(faultPk, QaFltStatus.REFORMED);//已整改
		return qaFaultResult;
	}
	
	@Override
	public SingleResult<QaFault> backDefect(String faultPk) throws Throwable {
		SingleResult<QaFault> qaFaultResult = updateQaFaultStatus(faultPk, QaFltStatus.TOREFORM);//待整改
		return qaFaultResult;
	}
	
	private ArrayResult<QaFault> getQaFaults(String faultPk){
		ArrayResultBuilder<QaFault> builder = ArrayResultBuilder.newArrayResult(QaFault.class);
		QaFlt qaFlt = qaFltDao.selectById(faultPk);
		String revisionCd = qaFlt.getRevisionCd();
		List<QaFlt> qaFltList = cusFaultDao.selectQaFaultByRevisionCd(revisionCd);
		int total = 0;
		if(qaFltList!=null && qaFltList.size()>0){
			total = qaFltList.size();
			QaFault[] qaFaultArr = new QaFault[qaFltList.size()];
			for(int i=0;i<qaFltList.size();i++){
				QaFlt qaFltE = qaFltList.get(i);
				QaFault qaFault = new QaFault();
				BeanCopyUtil.entityToModel(qaFault, qaFltE, QaFault.OBJ_CD, dictionaryService);
				qaFaultArr[i] = qaFault;
			}
			builder.withData(qaFaultArr);
		}
		ArrayResult<QaFault> qaFaultResult = builder.build();
		qaFaultResult.setTotal(total);
		return qaFaultResult;
	}
	
	private SingleResult<QaFault> updateQaFaultStatus(String faultPk, String qaFaultStatus){
		SingleResultBuilder<QaFault> builder = SingleResultBuilder.newSingleResult(QaFault.class);
		Timestamp tm = new Timestamp(System.currentTimeMillis());
		Session session = Session.get();
		String userId = session.getUserId();
		String deptId = session.getDeptId();
		QaFlt qaFlt = qaFltDao.selectById(faultPk);
		qaFlt.setFltStaCd(qaFaultStatus);
		if(qaFaultStatus.equals(QaFltStatus.REFORMED)){
			qaFlt.setRfmUserId(userId);
			qaFlt.setRfmDeptCd(deptId);
			qaFlt.setRfmTime(tm);
		}
		qaFltDao.updateExcludeNull(qaFlt);
		QaFault qaFault = new QaFault();
		BeanCopyUtil.entityToModel(qaFault, qaFlt, QaFault.OBJ_CD, dictionaryService);
		builder.withData(qaFault);
		return builder.build();
	}

	@Override
	public ArrayResult<User> searchDeptEmps(Map param) throws Throwable {

		Session session = Session.get();
		String orgCd = session.getDeptId();//用户登录科室/病区
		Map<String,String> parasMap = new HashMap();
		parasMap.put("orgCd", orgCd);
		parasMap.put("dctNsF", "0");
		parasMap.put("pageSize", "100");
		
		//缓存 整改人信息，过期时间设置为24小时：86400000毫秒
		String deptEmpKey = "deptEmps"+"_"+orgCd;
		Cache deptEmpCache = CacheManager.getCacheInfo(deptEmpKey);
		if(null != deptEmpCache && deptEmpCache.isExpired()){
			CacheManager.clearOnly(deptEmpKey);
		}
		ArrayResult<User> userList = null;
		if(null != deptEmpCache && !deptEmpCache.isExpired()){
			
			userList = (ArrayResult<User>) deptEmpCache.getValue();
		}else{
			userList = userService.search(parasMap);
			Long timeOut = 86400000+System.currentTimeMillis();
			deptEmpCache = new Cache(deptEmpKey,userList,timeOut,false);
			
			CacheManager.putCache(deptEmpKey, deptEmpCache);

		}
		
		return userList;
	}

	
	//-------------------------cf add 2015-01-27 end---------------------------

	//-------------------------cf add 2015-07-01 begin---------------------------
	//查询当前就诊中未发送的缺陷，对应几个接收医生
	//select distinct(f.rfm_user_id) from qa_flt f where f.del_f='0' and f.en_pk='867414'
	/*private ArrayResult<QaFault> getRfmUsers(String enPk){
		ArrayResultBuilder<QaFault> builder = ArrayResultBuilder.newArrayResult(QaFault.class);
		List<QaFlt> qaFltList = cusFaultDao.selectRfmUsersByEnpk(enPk);
		int total = 0;
		if(qaFltList!=null && qaFltList.size()>0){
			total = qaFltList.size();
			QaFault[] qaFaultArr = new QaFault[qaFltList.size()];
			for(int i=0;i<qaFltList.size();i++){
				QaFault qaFault = new QaFault();
				BeanCopyUtil.mapToModel(qaFault, qaFltList.get(i));
				qaFaultArr[i] = qaFault;
			}
			builder.withData(qaFaultArr);
		}
		ArrayResult<QaFault> qaFaultResult = builder.build();
		qaFaultResult.setTotal(total);
		return qaFaultResult;
	}*/
	
	//-------------------------cf add 2015-07-01 end---------------------------

}
