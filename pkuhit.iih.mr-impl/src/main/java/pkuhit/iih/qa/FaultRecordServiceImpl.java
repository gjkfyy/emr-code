package pkuhit.iih.qa;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.seasar.doma.jdbc.SelectOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import pkuhit.iih.qa.dao.auto.QaFltDao;
import pkuhit.iih.qa.dao.auto.QaFltItmDao;
import pkuhit.iih.qa.dao.auto.entity.QaFlt;
import pkuhit.iih.qa.dao.auto.entity.QaFltItm;
import pkuhit.iih.qa.dao.custom.CusQaFaultDao;
import pkuhit.iih.qa.dao.custom.CusQaItemDao;
import pkuhit.iih.qa.md.QaFaultStatus;
import pkuhit.iih.qa.old.QaFault;
import pkuhit.iih.qa.old.QaFaultItem;
import pkuhit.iih.qa.old.QaRecord;
import pkuhit.md.DictionaryService;
import pkuhit.xap.ac.Session;
import pkuhit.xap.util.BeanCopyUtil;
import xap.sv.annotation.Reference;
import xap.sv.model.ArrayResult;
import xap.sv.model.ArrayResultBuilder;
import xap.sv.model.SingleResult;
import xap.sv.model.SingleResultBuilder;
import xap.sv.util.UUIDGenerator;
/**
 * 
 * <p>FaultRecordServiceImpl</p>
 * <p>质控缺陷服务实现</p>
 *
 * @author		chengfeng(cheng_feng@founder.com)
 * @version		0.0.0
 */
public class FaultRecordServiceImpl implements FaultRecordService {
	
	@Autowired
	QaFltDao qaFltDao;
	
	@Autowired
	QaFltItmDao qaFltItmDao;

	@Autowired
	CusQaItemDao cusQaItemDao;

	@Autowired
	CusQaFaultDao cusQaFaultDao;
	
	
	@Reference
	QaRecordService qaRecordServiceMr;
	
	@Reference
	DictionaryService dictionaryService;
	
	public FaultRecordServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public SingleResult<QaFault> create(QaFault qaFault) throws Throwable {
		QaFlt qaFlt = new QaFlt();
		String id = qaFault.getPk();
		if(StringUtils.isBlank(id)){
			id = UUIDGenerator.getUUID();
			qaFault.setPk(id);
		}
		BeanCopyUtil.modelToEntity(qaFlt, qaFault);
		qaFltDao.insert(qaFlt);
		return this.getQaFaultById(id);
	}
	
	@Override
	@Transactional(rollbackFor = { RuntimeException.class })
	public ArrayResult<QaFault> update(CusQaFaultArr cusQaFaultArr) throws Throwable {
		ArrayResultBuilder<QaFault> builder = ArrayResultBuilder.newArrayResult(QaFault.class);
		Session session = Session.get();
		String userId = session.getUserId();
		String deptId = session.getDeptId();
		Timestamp tm = new Timestamp(System.currentTimeMillis());
		try{
			List<QaFault> qaFaultList = cusQaFaultArr.getQaFaultList();
			if(qaFaultList!=null&&qaFaultList.size()>0){
				QaFault[] qaFaultArray = new QaFault[qaFaultList.size()];
				for(int i=0;i<qaFaultList.size();i++){
					QaFault qaFault = qaFaultList.get(i);
					String id = qaFault.getPk();
					if(QaFault.FLT_CFM_RST_CD_NEETDROPSCORE.equals(qaFault.getFaultConfirmResult())||QaFault.FLT_CFM_RST_CD_NONDROPSCORE.equals(qaFault.getFaultConfirmResult())){
						qaFault.setVerifiedTime(tm);
						qaFault.setVerifiedUserId(userId);
						qaFault.setVerifiedDeptCode(deptId);
					}
					SingleResult<QaFault> qaFaultResult = this.updateById(id, qaFault);
					qaFaultArray[i] = qaFaultResult.getData();
				}
				if(qaFaultArray!=null){
	//				qaFaultArrayResult.setDataList(qaFaultArray);
					builder.withData(qaFaultArray);
				}
			}
		}catch(Exception e){
			throw new RuntimeException(e);
		}
//		return qaFaultArrayResult;
		return builder.build();
	}
	
	private void update(QaFault qaFault) throws Throwable {
		QaFlt qaFlt = new QaFlt();
		BeanCopyUtil.modelToEntity(qaFlt, qaFault);
		qaFltDao.updateExcludeNull(qaFlt);
	}
	
	@Override
	@Deprecated
	public void save(String enPk, List<QaFault> listValue) throws Throwable {
		if(listValue!=null&&listValue.size()>0){
			String qaFaultPk = "";
			String qaPk = "";
//			String preQaPk = "";
			String statusCode = "";
			/*
			 * statusFlag
			 * 列表缺陷状态均为新建、已审核：0
			 * 【新建一条质控工作记录，且修改上一条质控工作记录为已完成】，
			 * 存在已提出状态且整改时间不为空：1
			 * 【修改上一条质控工作记录为已删除】
			 * */
			int statusFlag = 0;
			for(int i=0;i<listValue.size();i++){
				QaFault qaFault = listValue.get(i);
				statusCode = qaFault.getStatusCode();
				if((QaFault.STATUS_CODE_CREATED.equals(statusCode)||QaFault.STATUS_CODE_VERIFIED.equals(statusCode))&&!QaFault.STATUS_CODE_SUBMITTED.equals(statusCode)&&!QaFault.STATUS_CODE_REFORMED.equals(statusCode)){
					statusFlag = 0;
				}else{
					if(QaFault.STATUS_CODE_SUBMITTED.equals(statusCode)&&qaFault.getReformedTime()!=null){
						statusFlag = 1;
					}
				}
				qaFaultPk = qaFault.getPk();
				if(!"".equals(qaFaultPk)&&qaFaultPk!=null){
					this.update(qaFault);
				}
				/* 补全工作记录质控缺陷数据 */
				QaFaultItem qaFaultItem = new QaFaultItem();
				qaFaultItem.setPk(UUIDGenerator.getUUID());
				qaFaultItem.setQaPk(qaPk);
				qaFaultItem.setQaFaultPk(qaFaultPk);
				qaFaultItem.setActiveF((short)1);
				//qaFaultItemServiceMr.create(qaFaultItem);
			}
			/*if(statusFlag==0){
				 //查询上一条工作记录，修改其完成状态为已完成 
				preQaPk = qaRecordServiceMr.searchPreviousQa(enPk);
				if(!"".equals(preQaPk)){
					SingleResult<QaRecord> qaRecord = qaRecordServiceMr.search(preQaPk);
					QaRecord qaRecordM = new QaRecord();
					qaRecordM.setCompletedFlag((short)1);
					qaRecordServiceMr.update(qaRecordM);
				}
			}else{
				 //查询上一条工作记录，删除 
				preQaPk = qaRecordServiceMr.searchPreviousQa(enPk);
				if(!"".equals(preQaPk)){
					qaRecordServiceMr.delete(preQaPk);
				}
			}*/
		}
	}
	
	@Override
	public SingleResult<CusQaFault> search(Map map) throws Throwable {
		SingleResultBuilder<CusQaFault> builder = SingleResultBuilder.newSingleResult(CusQaFault.class);
		CusQaFault cusQaFault = new CusQaFault();
		Map mapCondition = new HashMap();
		if(map!=null){
			String encounterPk = null ;
			if(map.containsKey("encounterPk")){
				encounterPk = map.get("encounterPk").toString();
			}
			String currentQaPk = null; 
			if(encounterPk!=null){
				currentQaPk = qaRecordServiceMr.checkExistUncompleted(encounterPk);
			}
			Session session = Session.get();
			String userId = session.getUserId();
			String deptId = session.getDeptId();
			String qaTypeCode = getStringValueFromMap(map, "qaTypeCode");
			String statusCode = getStringValueFromMap(map, "statusCode");
			String dropFlag = getStringValueFromMap(map, "dropFlag");
			String workScreen = "";
			if(map.containsKey("workScreen")){
				workScreen = map.get("workScreen").toString();
			}
			String isDept = "";
			if(map.containsKey("isDept")){
				isDept = map.get("isDept").toString();
			}
			if("1".equals(workScreen)){
				mapCondition.put("encounterPk", encounterPk);
				mapCondition.put("qaTypeCode", qaTypeCode);
				mapCondition.put("statusCode", statusCode);
				mapCondition.put("dropFlag", dropFlag);
				mapCondition.put("submittedUserId", userId);
				mapCondition.put("submittedDeptCode", "");
			}else if("2".equals(workScreen)||"3".equals(workScreen)){
				mapCondition.put("encounterPk", encounterPk);
				mapCondition.put("qaTypeCode", qaTypeCode);
				mapCondition.put("statusCode", statusCode);
				mapCondition.put("dropFlag", dropFlag);
				mapCondition.put("submittedUserId", "");
				mapCondition.put("submittedDeptCode", "");
			}else if("4".equals(workScreen)||"5".equals(workScreen)){
				if("1".equals(isDept)){
					mapCondition.put("submittedUserId", userId);
					mapCondition.put("submittedDeptCode", "");
				}else if("2".equals(isDept)){
					mapCondition.put("submittedUserId", "");
					mapCondition.put("submittedDeptCode", deptId);
				}
				mapCondition.put("encounterPk", encounterPk);
				mapCondition.put("qaTypeCode", qaTypeCode);
				mapCondition.put("statusCode", statusCode);
				mapCondition.put("dropFlag", dropFlag);
			}else if("6".equals(workScreen)){
				mapCondition.put("encounterPk", encounterPk);
				mapCondition.put("qaTypeCode", "");
				mapCondition.put("statusCode", QaFault.STATUS_CODE_SUBMITTED);//已提出
				mapCondition.put("dropFlag", "");
				mapCondition.put("submittedUserId", "");
				mapCondition.put("submittedDeptCode", "");
			}
			ArrayResult<QaFault> qaFaultArrayResult = searchByCondition(mapCondition);
			cusQaFault.setCurrentQaPk(currentQaPk);
			cusQaFault.setQaFaultList(qaFaultArrayResult);
			builder.withData(cusQaFault);
		}
		return builder.build();
	}

	//wangyanli 修改
	@Override  
	public ArrayResult<QaFault> searchByCondition(Map map) throws Throwable {
		String encounterPk = getStringValueFromMap(map, "encounterPk");
		String qaTypeCode = getStringValueFromMap(map, "qaTypeCode");
		String statusCode = getStringValueFromMap(map, "statusCode");
		String dropFlag = getStringValueFromMap(map, "dropFlag");
		String submittedUserId = getStringValueFromMap(map, "submittedUserId");
		String submittedDeptCode = getStringValueFromMap(map, "submittedDeptCode");
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
		ArrayResultBuilder<QaFault> builder = ArrayResultBuilder.newArrayResult(QaFault.class);
		List<Map<String, Object>> qaFaultList = null;
		Map<String, Object> mapFault = null;
		SelectOptions options = SelectOptions.get().offset((Integer.valueOf(pageNum)-1)*Integer.valueOf(pageSize)).limit(Integer.valueOf(pageSize)).count();			
		long count = options.getCount();
		int total = Long.valueOf(count).intValue();
		qaFaultList = cusQaFaultDao.selectQaFaultByCondition(encounterPk, qaTypeCode, statusCode, dropFlag, submittedUserId, submittedDeptCode, options);
		//qaFaultList = cusQaFaultDao.selectQaFltByCondition(encounterPk, qaTypeCode, statusCode, dropFlag, submittedUserId, submittedDeptCode, options);
		if(qaFaultList!=null){
			if(qaFaultList.size()>0){
				QaFault[] qaFaultArray = new QaFault[qaFaultList.size()];
				for(int i=0;i<qaFaultList.size();i++){
					QaFault qaFault = new QaFault();
					mapFault = qaFaultList.get(i);
					BeanCopyUtil.mapToModel(qaFault, mapFault);
					qaFaultArray[i] = qaFault;
				}
				if(qaFaultArray!=null){
					builder.withData(qaFaultArray);
				}
			}
		}
		ArrayResult<QaFault> faultArrayResult = builder.build();
		faultArrayResult.setTotal(total);
		return faultArrayResult;
	}
/*	@Override  chengfeng
	public ArrayResult<QaFault> searchByCondition(Map map) throws Throwable {
		String encounterPk = getStringValueFromMap(map, "encounterPk");
		String qaTypeCode = getStringValueFromMap(map, "qaTypeCode");
		String statusCode = getStringValueFromMap(map, "statusCode");
		String dropFlag = getStringValueFromMap(map, "dropFlag");
		String submittedUserId = getStringValueFromMap(map, "submittedUserId");
		String submittedDeptCode = getStringValueFromMap(map, "submittedDeptCode");
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
		ArrayResultBuilder<QaFault> builder = ArrayResultBuilder.newArrayResult(QaFault.class);
		List<Map<String, Object>> qaFaultList = null;
		Map<String, Object> mapFault = null;
		SelectOptions options = SelectOptions.get().offset((Integer.valueOf(pageNum)-1)*Integer.valueOf(pageSize)).limit(Integer.valueOf(pageSize)).count();			
		long count = options.getCount();
		int total = Long.valueOf(count).intValue();
		qaFaultList = cusQaFaultDao.selectQaFltByCondition(encounterPk, qaTypeCode, statusCode, dropFlag, submittedUserId, submittedDeptCode, options);
		if(qaFaultList!=null){
			if(qaFaultList.size()>0){
				QaFault[] qaFaultArray = new QaFault[qaFaultList.size()];
				for(int i=0;i<qaFaultList.size();i++){
					QaFault qaFault = new QaFault();
					mapFault = qaFaultList.get(i);
					BeanCopyUtil.mapToModel(qaFault, mapFault);
					qaFaultArray[i] = qaFault;
				}
				if(qaFaultArray!=null){
					builder.withData(qaFaultArray);
				}
			}
		}
		ArrayResult<QaFault> faultArrayResult = builder.build();
		faultArrayResult.setTotal(total);
		return faultArrayResult;
	}
*/	
	/*private QaFault mapToModelQaFault(Map<String, Object>mapFault){
		QaFault qaFault = new QaFault();
		qaFault.setPk(mapFault.get("QA_FLT_PK").toString());
		qaFault.setQaPk(mapFault.get("QAPK").toString());
		qaFault.setQaSystemItemCode(mapFault.get("QA_SYS_ITM_CD").toString());
		qaFault.setFaultFromCode(mapFault.get("FLT_STA_CD").toString());
		qaFault.setReformRequirement(mapFault.get("RFM_REQ").toString());
		return qaFault;
	}*/
	
	/*@Override
	public SingleResult<CusQaFault> search(CusQaFaultSearchCondition searchCondition) throws Throwable {
		SingleResult<CusQaFault> cusQaFaultS = new SingleResult<CusQaFault>();
		CusQaFault cusQaFault = new CusQaFault();
		if(searchCondition!=null){
			String currentQaPk = qaRecordServiceMr.checkExistUncompleted(searchCondition.getEncounterPk());
			if("".equals(currentQaPk)){
				//没有未完成的质控工作记录
				return null;
			}
			Session session = Session.get();
			String userId = session.getUserId();
			String deptId = session.getDeptId();
			int workScreen = searchCondition.getWorkScreen();
			int isDept = searchCondition.getIsDept();
			QaFault qaFault = new QaFault();
			if(workScreen==1){
				searchCondition.setSubmittedUserId(userId);
				searchCondition.setSubmittedDeptCode(null);
			}else if(workScreen==2||workScreen==3){
				searchCondition.setSubmittedUserId(null);
				searchCondition.setSubmittedDeptCode(null);
			}else if(workScreen==4||workScreen==5){
				if(isDept==0){
					searchCondition.setSubmittedUserId(userId);
					searchCondition.setSubmittedDeptCode(null);
				}else if(isDept==1){
					searchCondition.setSubmittedUserId(null);
					searchCondition.setSubmittedDeptCode(deptId);
				}
				searchCondition.setStatusCode(null);
				searchCondition.setDropFlag(null);
			}else if(workScreen==6){
				searchCondition.setQaTypeCode(null);
				searchCondition.setStatusCode(QaFault.STATUS_CODE_SUBMITTED);//已提出
				searchCondition.setDropFlag(null);
				searchCondition.setSubmittedUserId(null);
				searchCondition.setSubmittedDeptCode(null);
			}
			ArrayResult<QaFault> qaFaultList = this.searchByCondition(searchCondition);
			cusQaFault.setCurrentQaPk(currentQaPk);
			cusQaFault.setQaFaultList(qaFaultList);
		}
		cusQaFaultS.setData(cusQaFault);
		return cusQaFaultS;
	}*/
	
	/*public ArrayResult<QaFault> searchByCondition(CusQaFaultSearchCondition searchCondition) throws Throwable {
		String encounterPk = searchCondition.getEncounterPk();
		String qaTypeCode = searchCondition.getQaTypeCode();
		String statusCode = searchCondition.getStatusCode();
		String dropFlag = searchCondition.getDropFlag().toString();
		String submittedUserId = searchCondition.getSubmittedUserId();
		String submittedDeptCode = searchCondition.getSubmittedDeptCode();
		ArrayResult<QaFault> qaFaultArray= (ArrayResult<QaFault>) cusQaFaultDao.selectQaFltByCondition(encounterPk, qaTypeCode, statusCode, dropFlag, submittedUserId, submittedDeptCode);
		return qaFaultArray;
	}*/

	@Override
	public SingleResult<QaFault> delete(String id) throws Throwable {
		QaFlt qaFlt= qaFltDao.selectById(id);
		qaFlt.setDelF((short)1);
		qaFltDao.markDelete(qaFlt);
		return this.getQaFaultById(id);
	}

	/*@Override
	public void verify(String id) throws Throwable {
		SingleResult<QaFault> qaFaultS = this.search(id);
		QaFault qaFault = new QaFault();
		qaFaultS.setData(qaFault);
		qaFault.setStatusCode(QaFault.STATUS_CODE_VERIFIED);//已审核
		this.update(qaFault);
	}*/

	@Override
	public int checkIsNeedReform(String qaItemPkStr) throws Throwable {
		int isNeedReform = 0;
		List<String> qaItemPkList = new ArrayList<String>();
		if(!StringUtils.isEmpty(qaItemPkStr)){
			if(!"null".equals(qaItemPkStr)){
				String[] qaItemPkArr = qaItemPkStr.split(",");
				qaItemPkList = Arrays.asList(qaItemPkArr);
				int needReformNum = cusQaItemDao.selectByQaItemPk(qaItemPkList);
				if(needReformNum>0){
					isNeedReform = 1;
				}
			}
		}
		return isNeedReform;
	}

	@Override
	public SingleResult<QaFault> searchById(String id) throws Throwable {
		return this.getQaFaultById(id);
	}

	@Override
	@Transactional(rollbackFor = { RuntimeException.class })
	public String createFaultExtendInProcess(String enPk, String qaSystemItemCode) throws Throwable {
		/* 判断是否有质控缺陷 */
		int needReformFaultFlag=0;
		int haveFaultFlag=0;
		int qaCreateFlag = 0;
		try{
			List<QaFlt> faultList = cusQaFaultDao.selectQaFltExtendInProcess(enPk);
			String qaPk = UUIDGenerator.getUUID();
			if(faultList!=null&&faultList.size()>0){
				qaCreateFlag = 1;
				haveFaultFlag = 1;
				String pkStr = "";
				for(int i=0;i<faultList.size();i++){
					QaFlt qaFault = faultList.get(i);
					//qaFault.setFltStaCd(QaFaultStatus.CREATED);
//					qaFault.setFltCfmRstCd(QaFault.FLT_CFM_RST_CD_UNCONFIRMED);
					qaFault.setVrfDeptCd(null);
					qaFault.setVrfTime(null);
					qaFault.setVrfUserId(null);
					qaFltDao.update(qaFault);
					QaFaultItem qaFaultItem = new QaFaultItem();
					/*删掉之前的关联关系，设置工作记录质控缺陷数据活动标志为0   */
					QaFltItm qaFltItm = new QaFltItm();
					qaFltItm = cusQaItemDao.selectFaultItemByFaultPk(qaFault.getQaFltPk());
					qaFltItm.setActiveF((short)0);
					qaFltItmDao.update(qaFltItm);
					/*创建新的关联关系*/
					qaFaultItem.setPk(UUIDGenerator.getUUID());
					qaFaultItem.setQaPk(qaPk);
					qaFaultItem.setQaFaultPk(qaFault.getQaFltPk());
					qaFaultItem.setActiveF((short)1);
					//qaFaultItemServiceMr.create(qaFaultItem);
//					pkStr += qaFault.getQaSysItmCd()+",";
				}
				pkStr = pkStr.substring(0, pkStr.length()-1);
				needReformFaultFlag = this.checkIsNeedReform(pkStr);
			}
			if(qaCreateFlag==1){
				QaRecord qaRecord = new QaRecord();
				qaRecord.setPk(qaPk);
				qaRecord.setEncounterPk(enPk);
				qaRecord.setQaSystemCode(qaSystemItemCode);
				qaRecord.setQaTypeCode(QaRecord.QA_TYPE_CODE_TERMINAL);//终末质控
				qaRecord.setAutoFlag((short)0);
				qaRecord.setExecuteBeginTime(new Timestamp(System.currentTimeMillis()));
				qaRecord.setCompletedFlag((short)0);
				qaRecord.setHaveFaultFlag((short)haveFaultFlag);
				qaRecord.setNeedReformFaultFlag((short)needReformFaultFlag);
				qaRecordServiceMr.create(qaRecord);
			}
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		return "ok";
	}

	@Override
	public SingleResult<QaFault> updateById(String id, QaFault qaFault)
			throws Throwable {
		QaFlt qaFlt = new QaFlt();
		BeanCopyUtil.modelToEntity(qaFlt, qaFault);
		qaFltDao.updateExcludeNull(qaFlt);
		return this.getQaFaultById(id);
	}
	
	@Override
	public List<String> needReformFault(String qaPk) throws Throwable {
		List<String> list = new ArrayList<String>();
		list = cusQaFaultDao.selectNeedReformFault(qaPk);
		return list;
	}
	
	//wangyanli
	@Override
	public List<String> unSendFault(String qaPk) throws Throwable {
		List<String> list = new ArrayList<String>();
		list = cusQaFaultDao.selectUnSendFault(qaPk);
		return list;
	}
	
	@Override
	public ArrayResult<QaFault> checkFaultReformResult(String enPk)
			throws Throwable {
		ArrayResultBuilder<QaFault> builder = ArrayResultBuilder.newArrayResult(QaFault.class);
		List<QaFlt> faultList = cusQaFaultDao.selectCheckFaultReformResult(enPk);
		int total = 0;
		if(faultList!=null&&faultList.size()>0){
			QaFault[] qaFaultArr = new QaFault[faultList.size()];
			total = faultList.size();
			for(int i=0;i<faultList.size();i++){
				QaFlt qaFlt = faultList.get(i);
				QaFault qaFault = new QaFault();
				BeanCopyUtil.entityToModel(qaFault, qaFlt, QaFault.OBJ_CD, dictionaryService);
				qaFaultArr[i] = qaFault;
			}
			builder.withData(qaFaultArr);
		}
		ArrayResult<QaFault> faultArrayResult = builder.build();
		faultArrayResult.setTotal(total);
		return faultArrayResult;
	}

	@Override
	public ArrayResult<QaFault> updateFaultStatusToVerified(String enPk, String qaPk)
			throws Throwable {
		Session session = Session.get();
		Timestamp vrfTime = new Timestamp(System.currentTimeMillis());
		String vrfUserId = session.getUserId();
		String vrfDeptCd = session.getDeptId();
		ArrayResultBuilder<QaFault> builder = ArrayResultBuilder.newArrayResult(QaFault.class);
		List<QaFlt> faultList = cusQaFaultDao.selectFaultByEnpkAndQaPk(enPk, qaPk);
		int total = 0;
		if(faultList!=null&&faultList.size()>0){
			QaFault[] qaFaultArr = new QaFault[faultList.size()];
			total = faultList.size();
			for(int i=0;i<faultList.size();i++){
				QaFlt qaFlt = faultList.get(i);
				qaFlt.setVrfTime(vrfTime);
				qaFlt.setVrfUserId(vrfUserId);
				qaFlt.setVrfDeptCd(vrfDeptCd);
				qaFlt.setFltStaCd(QaFaultStatus.VERIFIED);
				qaFltDao.updateExcludeNull(qaFlt);
				QaFault qaFault = new QaFault();
				BeanCopyUtil.entityToModel(qaFault, qaFlt, QaFault.OBJ_CD, dictionaryService);
				qaFaultArr[i] = qaFault;
			}
			builder.withData(qaFaultArr);
		}
		ArrayResult<QaFault> faultArrayResult = builder.build();
		faultArrayResult.setTotal(total);
		return faultArrayResult;
	}
	
	/*@Override
	public BigInteger calculateScore(String enPk, String qaTypeCode,
			String qaSystemCode, String encounterTypeCode) throws Throwable {
		// TODO Auto-generated method stub
		return null;
	}*/
	
	private SingleResult<QaFault> getQaFaultById(String id) throws Throwable {
		SingleResultBuilder<QaFault> builder = SingleResultBuilder.newSingleResult(QaFault.class);
		QaFlt qaFlt = qaFltDao.selectById(id);
		QaFault qaFault = new QaFault();
		if (null != qaFlt) {
			BeanCopyUtil.entityToModel(qaFault, qaFlt, QaFault.OBJ_CD, dictionaryService);
			builder.withData(qaFault);
		}
		return builder.build();
	}
	
	private String getStringValueFromMap(Map map,String key){
		String value = null ;
		if(map.containsKey(key)){
			value = (String)map.get(key);
			if(StringUtils.isBlank(value)){
				value = null ;
			}
		}
		return value;
	}

}
