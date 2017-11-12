
package pkuhit.iih.mr.wr;

import java.io.StringReader;
import java.math.BigInteger;
import java.net.URL;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.namespace.QName;

import org.apache.commons.lang3.StringUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.seasar.doma.jdbc.OptimisticLockException;
import org.seasar.doma.jdbc.SelectOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import pkuhit.iih.ass.di.AssDiagnosisService;
import pkuhit.iih.di.DiagnosisModel;
import pkuhit.iih.en.md.EncounterType;
import pkuhit.iih.en.md.PatientModel;
import pkuhit.iih.mr.dao.auto.MrAmrDao;
import pkuhit.iih.mr.dao.auto.MrDao;
import pkuhit.iih.mr.dao.auto.entity.Mr;
import pkuhit.iih.mr.dao.auto.entity.MrAmr;
import pkuhit.iih.mr.md.AmrStatus;
import pkuhit.iih.mr.md.MrStatus;
import pkuhit.iih.mr.pub.MessageCode;
import pkuhit.iih.mr.wr.dao.CusMrAmrDao;
import pkuhit.iih.mr.wr.dao.CusMrDao;
import pkuhit.iih.mr.wr.org.tempuri.IEMRExp;
import pkuhit.iih.mr.wr.org.tempuri.IEMRExpservice;
import pkuhit.iih.pub.IihUtils;
import pkuhit.iih.pub.PerformancePrinter;
import pkuhit.md.DictionaryService;
import pkuhit.md.SysFunctionCode;
import pkuhit.xap.ac.Session;
import pkuhit.xap.ac.UserRoleService;
import pkuhit.xap.pm.Param;
import pkuhit.xap.pm.ParamsService;
import pkuhit.xap.pm.ParamsSetService;
import pkuhit.xap.util.BeanCopyUtil;
import xap.sv.annotation.Reference;
import xap.sv.model.ArrayResult;
import xap.sv.model.ArrayResultBuilder;
import xap.sv.model.SingleResult;
import xap.sv.model.SingleResultBuilder;
import xap.sv.notification.Notification;
import xap.sv.notification.exception.NotificationException;
import xap.sv.util.UUIDGenerator;
import ei.cis.service.CisConsMrAmrService;
import ei.cis.service.CisStepDeptMrAmrService;
import ei.en.mz.service.MzEiEncounterService;
import ei.en.zy.service.ZyEiEncounterService;
import ei.his.service.HisConsMrAmrService;
import ei.his.service.HisStepDeptMrAmrService;

public class AmrServiceImpl implements AmrService {
	private Logger log = LoggerFactory.getLogger(AmrServiceImpl.class);

	
	@Reference
	ParamsService paramsService;
	
	@Autowired
	MrAmrDao mrAmrDao;
	
	@Autowired
	MrDao mrDao;
	
	@Autowired
	CusMrDao cusMrDao;
	
	@Autowired
	CusMrAmrDao cusMrAmrDao;

	@Reference
	DictionaryService dictionnaryService;
	
	@Autowired
	AssDiagnosisService diService;
	
	@Reference
	iih.di.service.intf.DiService  oracleDiService;
	
	@Reference
	ParamsSetService paramsSetService;

	@Reference
	MzEiEncounterService mzEncounterService;

	@Reference
	ZyEiEncounterService zyEncounterService;
	
	@Reference
	QaAmrService qaAmrService;
	
	@Reference
	UserRoleService userRoleService; //用户 角色
	
	@Reference
	CisConsMrAmrService cisConsMrAmrService;  //cis 会诊
	
	@Reference
	CisStepDeptMrAmrService  cisStepDeptMrAmrService;  //cis 跨科
	
	@Reference
    DictionaryService dictionaryService;
	
	@Reference
	HisConsMrAmrService hisConsMrAmrService;  //cis 会诊
	
	@Reference
	HisStepDeptMrAmrService  hisStepDeptMrAmrService;  //cis 跨科
	
	public AmrServiceImpl() {

	}

	/*
	 * (non-Javadoc)
	 * @see pkuhit.iih.mr.wr.AmrService#create(pkuhit.iih.mr.wr.Amr)
	 */
	@Override
	public SingleResult<Amr> create(Amr io)
		throws Throwable {

		MrAmr mrAmr = new MrAmr();
		BeanCopyUtil.modelToEntity(mrAmr, io);
		mrAmrDao.insertExludeNull(mrAmr);
		return this.get(mrAmr.getEnPk());
	}

	/*
	 * (non-Javadoc)
	 * @see pkuhit.iih.mr.wr.AmrService#delete(java.lang.String)
	 */
	@Override
	public SingleResult<Amr> delete(String id)
		throws Throwable {

		MrAmr mrAmr = new MrAmr();
		mrAmr.setEnPk(id);
		mrAmrDao.markDelete(mrAmr);
		return this.get(id);
	}

	/*
	 * (non-Javadoc)
	 * @see pkuhit.iih.mr.wr.AmrService#update(java.lang.String,
	 * pkuhit.iih.mr.wr.Amr)
	 */
	@Override
	public SingleResult<Amr> update(String id, Amr io)
		throws Throwable {

		MrAmr mrAmr = new MrAmr();
		BeanCopyUtil.modelToEntity(mrAmr, io);
		mrAmr.setEnCnt(BigInteger.valueOf(Long.valueOf(io.getEncounterCount())));
		mrAmrDao.updateExcludeNull(mrAmr);
		return this.get(id);
	}

	/*
	 * (non-Javadoc)
	 * @see pkuhit.iih.mr.wr.AmrService#get(java.lang.String)
	 */
	@Override
	public SingleResult<Amr> get(String id)
		throws Throwable {

		SingleResult<Amr> result;
		SingleResultBuilder<Amr> builder = SingleResultBuilder.newSingleResult(Amr.class);
		PerformancePrinter.start("mrAmrDao.selectById");
		MrAmr mrAmr = mrAmrDao.selectById(id);
		PerformancePrinter.end("mrAmrDao.selectById");
		if (null != mrAmr) {
			Amr amr = new Amr();// this.mrAmrToMrAmr(mrAmr);
//			amr = this.mrAmrToMrAmr(mrAmr);
			PerformancePrinter.start("Amr-entityToModel");
			BeanCopyUtil.entityToModel(amr, mrAmr, Amr.OBJ_CD, dictionnaryService);
			PerformancePrinter.end("Amr-entityToModel");
			amr.setEncounterCount(mrAmr.getEnCnt().toString());//String.valueOf(b));
			PerformancePrinter.start("diService.search");
			//yjb
			/*ArrayResult<DiagnosisModel> diList = diService.search(amr.getPk(), "1", null, null, null);
			PerformancePrinter.end("diService.search");
            if(diList != null && diList.getDataList() != null){
                DiagnosisModel[] diArr = diList.getDataList();
                if(diArr != null && diArr.length>0){
                    amr.setCurrentMainDiagnosisCode(diArr[0].getDiPk());
                    amr.setCurrentMainDiagnosisName(diArr[0].getDiNm());
                }
            }*/
			builder.withData(amr);
		}
		result = builder.build();
		return result;
	}
	/*
	 * (non-Javadoc)
	 * @see pkuhit.iih.mr.wr.AmrService#search(java.lang.String[])
	 */
	@Override
	public ArrayResult<Amr> search(Map map)
		throws Throwable {
		ArrayResult<Amr> result;
		ArrayResultBuilder<Amr> builder = ArrayResultBuilder.newArrayResult(Amr.class);
		String currentDeptCode=map.get("currentDeptCode")!=null?map.get("currentDeptCode").toString():"";
		String receiveTime=map.get("receiveTime")!=null?map.get("receiveTime").toString():"";
		String finishTime=map.get("finishTime")!=null?map.get("finishTime").toString():"";
		String amrNo=map.get("amrNo")!=null?map.get("amrNo").toString():"";
		String patientName=map.get("patientName")!=null?map.get("patientName").toString():"";
		String pageNum=map.get("pageNum")!=null?map.get("pageNum").toString():"";
		String pageSize=map.get("pageSize")!=null?map.get("pageSize").toString():"";
		String qaF=map.get("qaF")!=null&&map.get("qaF")!=""?map.get("qaF").toString():"";
		String arcF=map.get("arcF")!=null&&map.get("arcF")!=""?map.get("arcF").toString():"";
		if(pageNum.equals("")){
			pageNum="1";
		}
		if(pageSize.equals("")){
			pageSize="25";
		}
		int total = 0;
		SelectOptions options = SelectOptions.get().offset((Integer.valueOf(pageNum)-1)*Integer.valueOf(pageSize)).limit(Integer.valueOf(pageSize)).count();
		String nurArchiveCheck=paramsSetService.searchFunFlagByKey("NUR_ARCHIVE_CHECK").getData();
		List<MrAmr> mrAmr= cusMrAmrDao.selectParientAll(currentDeptCode.trim(), receiveTime, finishTime, amrNo.trim(), patientName.trim(),Integer.valueOf(qaF),Integer.valueOf(arcF),nurArchiveCheck,options);
		List<Amr>  amrs=new ArrayList<Amr>();
		if(mrAmr!=null&&mrAmr.size()>0){
			long count = options.getCount();
			total = Long.valueOf(count).intValue();
			for (MrAmr mrAmr2 : mrAmr) {
				Amr amr = new Amr();
				BeanCopyUtil.entityToModel(amr, mrAmr2, Amr.OBJ_CD, dictionnaryService);
				amrs.add(amr);
			}
		}
		
		builder.withData(amrs.toArray(new Amr[0]));
		result = builder.build();
		result.setTotal(total);
		return result;
	}

	/*
	 * (non-Javadoc)
	 * @see pkuhit.iih.mr.wr.AmrService#startWrite(java.lang.String)
	 */
	@Override
	public SingleResult<Amr> startWrite(String id)
		throws Throwable {

		MrAmr mrAmr = new MrAmr();
		mrAmr.setEnPk(id);
		mrAmr.setAmrStaCd(AmrStatus.WRITE_STARTED);
		mrAmrDao.updateExcludeNull(mrAmr);
		return this.get(id);
	}

	/*
	 * (non-Javadoc)
	 * @see pkuhit.iih.mr.wr.AmrService#completeWrite(java.lang.String)
	 */
	@Override
	public SingleResult<Amr> completeWrite(String id)
		throws Throwable {
		MrAmr amr=mrAmrDao.selectById(id);
//		MrAmr mrAmr = new MrAmr();
//		mrAmr.setEnPk(id);
		if(amr.getAmrStaCd().equals(AmrStatus.WRITE_STARTED)){//书写病历才能设置完成状态
			amr.setAmrStaCd(AmrStatus.WRITE_COMPLETED);
			amr.setFnshTime(new Timestamp(System.currentTimeMillis()));
			mrAmrDao.updateExcludeNull(amr);
		}
		return this.get(id);
	}

	/*
	 * (non-Javadoc)
	 * @see pkuhit.iih.mr.wr.AmrService#cancelWriteCompleted(java.lang.String)
	 */
	@Override
	public SingleResult<Amr> cancelWriteCompleted(String id)
		throws Throwable {

		MrAmr mrAmr = new MrAmr();
		mrAmr.setEnPk(id);
		mrAmr.setAmrStaCd(AmrStatus.WRITE_STARTED);
		mrAmrDao.updateExcludeNull(mrAmr);
		return this.get(id);
	}

	/*
	 * (non-Javadoc)
	 * @see pkuhit.iih.mr.wr.AmrService#startQa(java.lang.String)
	 */
	@Override
	public SingleResult<Amr> startQa(String id)
		throws Throwable {

		MrAmr mrAmr = new MrAmr();
		mrAmr.setEnPk(id);
		mrAmr.setAmrStaCd(AmrStatus.QA_STARTED);
		mrAmrDao.updateExcludeNull(mrAmr);
		return this.get(id);
	}

	/*
	 * (non-Javadoc)
	 * @see pkuhit.iih.mr.wr.AmrService#completeQa(java.lang.String)
	 */
	@Override
	public SingleResult<Amr> completeQa(String id)
		throws Throwable {

		MrAmr mrAmr = new MrAmr();
		mrAmr.setEnPk(id);
		mrAmr.setAmrStaCd(AmrStatus.QA_COMPLETED);
		mrAmrDao.updateExcludeNull(mrAmr);
		return this.get(id);
	}

	/*
	 * (non-Javadoc)
	 * @see pkuhit.iih.mr.wr.AmrService#cancelQaCompleted(java.lang.String)
	 */
	@Override
	public SingleResult<Amr> cancelQaCompleted(String id)
		throws Throwable {

		MrAmr mrAmr = new MrAmr();
		mrAmr.setEnPk(id);
		mrAmr.setAmrStaCd(AmrStatus.QA_STARTED);
		mrAmrDao.updateExcludeNull(mrAmr);
		return this.get(id);
	}

	/*
	 * (non-Javadoc)
	 * @see pkuhit.iih.mr.wr.AmrService#archived(java.lang.String)
	 */
	@Override
	@Transactional
	public SingleResult<Amr> archived(String id)
		throws Throwable {
		// 得到session
		Session session = Session.get();
		Timestamp date = new Timestamp(System.currentTimeMillis());
		String userId = session.getUserId();
		List<Mr> mrs=cusMrDao.selectByEnPk(id, null, null,null,null,null);
		for(Mr mrDoc:mrs){
			// 得到医疗记录
			Mr mr = mrDao.selectById(mrDoc.getMrPk());
			// 设置医疗记录状态为已提交
			mr.setMrStaCd(MrStatus.SUBMITTED);
			// 设置提交人
			mr.setSubmitCd(userId);
			//设置提交时间
			mr.setSubmitDate(date);
			//首次提交设置逻辑提交时间
			if(null==mr.getLgcSmtTime()){
				mr.setLgcSmtTime(date);
			}
			mr.setCompletedF(Short.valueOf("1"));
			
			// 持久化
			try{
				mrDao.updateExcludeNull(mr);
			}catch (OptimisticLockException e){
				Notification msg = null;
				msg = new Notification(MessageCode.OPTIMISTIC_LOCK);
				throw new NotificationException(msg);
			}
		}
		MrAmr mrAmr = new MrAmr();
		mrAmr.setEnPk(id);
		mrAmr.setAmrStaCd(AmrStatus.ARCHIVED);
		mrAmr.setRcvTime(new Timestamp(System.currentTimeMillis()));
		mrAmrDao.updateExcludeNull(mrAmr);
		return this.get(id);
	}

	@Override
	public SingleResult<Amr> getAmr(String id) throws Throwable {
		SingleResult<Amr> result;
		SingleResultBuilder<Amr> builder = SingleResultBuilder.newSingleResult(Amr.class);
		
		MrAmr mrAmr = mrAmrDao.selectById(id);
		Amr amr=new  Amr();
		amr.setEncounterTypeCode(mrAmr.getEnTpCd());
		amr.setPk(id);
		builder.withData(amr);
		result=builder.build();
		return result;
	}

	@Override
	public SingleResult<Amr> cancelArchived(String id) throws Throwable {
		MrAmr mrAmr = new MrAmr();
		mrAmr.setEnPk(id);
		mrAmr.setAmrStaCd(AmrStatus.WRITE_STARTED);
		mrAmr.setRcvTime(new Timestamp(System.currentTimeMillis()));
		mrAmrDao.updateExcludeNull(mrAmr);
		return this.get(id);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public SingleResult<Map> checkAmrGroup(String id) throws Throwable {
		SingleResult<Map> result;
		SingleResultBuilder<Map> builder = SingleResultBuilder.newSingleResult(Map.class);
		//是否启用就诊组标识,默认不启用
		Map<String,Boolean> map=new HashMap<String,Boolean>();
		boolean amrGroupEnable=false;
		boolean flag=false;
		Param[] params=paramsService.getParam(SysFunctionCode.AMR_GROUP_ENABLE).getDataList();
		if(params.length>0){
			Param param=params[0];
			if("1".equals(param.getValue())){
				amrGroupEnable=true;
			}
		}
		if(amrGroupEnable){
			List<Mr> mrs=cusMrDao.selectByEnPk(id, null, null,null,1,null);
			if(mrs.size()==0){
				MrAmr curMrAmr=mrAmrDao.selectById(id);
				if(null==curMrAmr.getMrAmrGroupCd()&&curMrAmr.getEnTpCd().equals(EncounterType.EMERGENCY)){
					BigInteger enCnt=curMrAmr.getEnCnt();
					List<MrAmr> mrAmrs=cusMrAmrDao.selectMrAmrByPaIdAndEnCnt(curMrAmr.getPaId(),enCnt);
					if(mrAmrs.size()>0){
						MrAmr mrAmrLast= mrAmrs.get(0);
						long lastRevTime=mrAmrLast.getRcvTime().getTime();//上次就诊时间
						long curRevTime=curMrAmr.getRcvTime().getTime();//本次就诊时间
						long interval=curRevTime-lastRevTime;//两次就诊时间差
						if(interval<259200000){
							flag = true;
						}
					}
				}
			}
		}
		map.put("accordAmrGroup", flag);
		builder.withData(map);
		result=builder.build();
		return result;
	}

	@Override
	public void createAmrGroup(String id) throws Throwable {
		MrAmr curMrAmr=mrAmrDao.selectById(id);
		if(null==curMrAmr.getMrAmrGroupCd()){
			BigInteger enCnt=curMrAmr.getEnCnt();
			List<MrAmr> mrAmrs=cusMrAmrDao.selectMrAmrByPaIdAndEnCnt(curMrAmr.getPaId(),enCnt);
			if(mrAmrs.size()>0){
				MrAmr mrAmrLast= mrAmrs.get(0);
				long lastRevTime=mrAmrLast.getRcvTime().getTime();//上次就诊时间
				long curRevTime=curMrAmr.getRcvTime().getTime();//本次就诊时间
				long interval=curRevTime-lastRevTime;//两次就诊时间差
				if(interval<259200000){
					if(null!=mrAmrLast.getMrAmrGroupCd()){
						curMrAmr.setMrAmrGroupCd(mrAmrLast.getMrAmrGroupCd());
					}else{
						mrAmrLast.setMrAmrGroupCd(UUIDGenerator.getUUID());
						curMrAmr.setMrAmrGroupCd(mrAmrLast.getMrAmrGroupCd());
						mrAmrDao.updateExcludeNull(mrAmrLast);
					}
					mrAmrDao.updateExcludeNull(curMrAmr);
					PerformancePrinter.start("oracleDiService.saveCopyDisByEnSn");
					//复制 上次（mrAmrLast）的诊断到当前（ curMrAmr）的诊断中
					oracleDiService.saveCopyDisByEnSn(mrAmrLast.getEnPk(), curMrAmr.getEnPk());
					PerformancePrinter.end("oracleDiService.saveCopyDisByEnSn");
				}
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * @see pkuhit.iih.mr.wr.AmrService#autoAmrarchived()
	 */
	@Override
	public void autoAmrarchived() {
		int inMrSet=24;
		int outMrSet=24;
		int emergencyMrSet=24;
		boolean enableF=false;
		Param[] params=paramsService.getParam(SysFunctionCode.AUTO_AMR_ARCHIVED_CONFIG).getDataList();
		for(Param param:params){
			if(IihUtils.isInteger(param.getValue())){
				if("IN_EMR".equals(param.getKey())){
					inMrSet=Integer.parseInt(param.getValue());
				}else if("OUT_MR".equals(param.getKey())){
					outMrSet=Integer.parseInt(param.getValue());
				}else if("EMERGENCY_MR".equals(param.getKey())){
					emergencyMrSet=Integer.parseInt(param.getValue());
				}else  if("启用标识".equals(param.getKey())){
					if("1".equals(param.getValue())){
						enableF=true;
					}
				}else{
					log.error("自动归档时间配置【"+param.getKey()+"】参数值【"+param.getValue()+"】错误");
				}
			}
		}
		if(enableF){
			this.amrarchived(EncounterType.INPATIENT, inMrSet);//住院病历归档
			this.amrarchived(EncounterType.OUTPATIENT, outMrSet);//门诊病历归档
			this.amrarchived(EncounterType.EMERGENCY, emergencyMrSet);//急诊病历归档
		}
	}
	
	private void amrarchived(String enTpCd,int timeSet){
		log.debug("........start auto "+enTpCd+" archived........");
		long nowTime=System.currentTimeMillis();
		List<MrAmr> amrs=cusMrAmrDao.selectUnachiveMrAmrs(enTpCd);
		int count=0;
		for(MrAmr mrAmr:amrs){
			long fnshTime=mrAmr.getFnshTime().getTime();
			long requireTime=fnshTime+timeSet*60*60*1000;
			if(nowTime>=requireTime){
				mrAmr.setAmrStaCd(AmrStatus.ARCHIVED);
				log.debug("........archived "+mrAmr.getEnPk()+"........");
				mrAmrDao.update(mrAmr);
				count++;
			}
		}
		log.debug("........end auto "+enTpCd+" archived "+count+" records........");
	}

	@Override
	public SingleResult<Amr> insertOrUpdateEn(String id, Map map)
			throws Throwable {
		//从数据库获取就诊
		PerformancePrinter.start("isExistEncounter");
		Integer count = this.cusMrAmrDao.isExistEncounter(id);
		PerformancePrinter.end("isExistEncounter");
		PerformancePrinter.start("isExistPatient");
		Integer count_patient = 0;
		if(id.indexOf("_") > 0){
	
			count_patient = this.cusMrAmrDao.isExistPatient(id.substring(0, id.indexOf("_")));
		}else if(map.containsKey("enSource") && map.get("enSource").toString().equals("CIS") ){	//如果为cis则enpk没有"_"连接符，根据enpk查出该患者信息 wangyanli 20160810
			String patientId = "";
			String times = "";
			if(map.containsKey("patientId") ){
				patientId = map.get("patientId").toString();
			}
			if(map.containsKey("times") ){
				times = map.get("times").toString();
			}			
			count_patient = this.cusMrAmrDao.isExistPatient(patientId);
			
		}
		if(count_patient.intValue() == 0){
			map.put("notExistPatient", "1" );
		}
		PerformancePrinter.end("isExistPatient");
		//数据不存在就诊
		//读取就诊源， 0-本库   1-his 2-cis 3-第三方其他数据源
	
		SingleResult<Map> rsMapParam = paramsSetService.searchByCode(SysFunctionCode.DATA_SOURCE);
		if(null != rsMapParam && null != rsMapParam.getData() && rsMapParam.getData().containsKey("EN_SOURCE")){
			String value = rsMapParam.getData().get("EN_SOURCE").toString();
			if(!"0".equalsIgnoreCase(value) ){
				log.debug("xap_params表中code=SYSM01.16，key=EN_SOURCE的value值不为0，从第三方同步就诊数据");
				String enTypeCode = null ;
				if (null != map && map.containsKey("enTypeCode")) {
					enTypeCode = map.get("enTypeCode").toString();
					log.debug("enTypeCode is：" + enTypeCode);
					if (EncounterType.OUTPATIENT.equalsIgnoreCase(enTypeCode)) {
						SingleResult<String> flagSyncEnFromMz = paramsSetService.searchFunFlagByKey("SYNC_EN_FROM_DS_MZ") ;
						if(null != flagSyncEnFromMz 
								&&  null != flagSyncEnFromMz.getData()
								&& flagSyncEnFromMz.getData().equalsIgnoreCase("1")
						)
						{
							// 门诊
							if(count.intValue() ==0){
								PerformancePrinter.start("insertEncounterToDB");
								mzEncounterService.insertEncounterToDB(id, map);
								PerformancePrinter.end("insertEncounterToDB");
							}else{
								PerformancePrinter.start("updateEncounterToDB");
								mzEncounterService.updateEncounterToDB(id, map);
								PerformancePrinter.end("updateEncounterToDB");
							}
						}
					} else if (EncounterType.INPATIENT.equalsIgnoreCase(enTypeCode)) {
						SingleResult<String> flagSyncEnFromMz = paramsSetService.searchFunFlagByKey("SYNC_EN_FROM_DS_ZY") ;
						if(null != flagSyncEnFromMz 
								&&  null != flagSyncEnFromMz.getData()
								&& flagSyncEnFromMz.getData().equalsIgnoreCase("1")
						)
						{
							// 住院
							if(count.intValue() ==0){
								PerformancePrinter.start("insertEncounterToDB");
								zyEncounterService.insertEncounterToDB(id, map);
								PerformancePrinter.end("insertEncounterToDB");
							}else{
								PerformancePrinter.start("updateEncounterToDB");
								zyEncounterService.updateEncounterToDB(id, map);
								PerformancePrinter.end("updateEncounterToDB");
							}
						}
					} 
				}else{
					log.info("传入参数中enTypeCode");
				}
				
				

				
			
			}else{
				log.info("xap_params表中code=SYSM01.16，key=EN_SOURCE的value值为0，则从本库取就诊，不同步");
			}
		}
		PerformancePrinter.start("call get(id)");
		SingleResult<Amr> amr =  qaAmrService.getEncounterById(id);
		PerformancePrinter.end("call get(id)");
		return amr ;
	}

	
	@Override
	public ArrayResult<Amr> searchForMrb(Map map) throws Throwable {
		
		ArrayResult<Amr> result;
		ArrayResultBuilder<Amr> builder = ArrayResultBuilder.newArrayResult(Amr.class);
		String enTypeCode = map.get("enTypeCode")!=null?map.get("enTypeCode").toString().trim():null;
		String searchDeptCode=map.get("deptCode")!=null?map.get("deptCode").toString().trim():null;
		String doctorCode =map.get("doctorCode")!=null?map.get("doctorCode").toString().trim():null;
		String receiveTime=map.get("startTime")!=null?map.get("startTime").toString().trim():null;
		String finishTime=map.get("endTime")!=null?map.get("endTime").toString().trim():null;
		String idCardNo=map.get("idCardNo")!=null?map.get("idCardNo").toString().trim():null;
		String amrNo=map.get("amrNo")!=null?map.get("amrNo").toString().trim():null;
		String paId=map.get("paId")!=null?map.get("paId").toString().trim():null;
		String patientName=map.get("patientName")!=null?map.get("patientName").toString().trim():null;
		String pageNum=map.get("pageNum")!=null?map.get("pageNum").toString().trim():null;
		String mobile=map.get("mobile")!=null?map.get("mobile").toString().trim():null;
		String pageSize=map.get("pageSize")!=null?map.get("pageSize").toString().trim():null;
		String amrStaCd=map.get("checkArchive")!=null&&map.get("checkArchive")!=""?map.get("checkArchive").toString().trim():null;
		List mrTypeList = new ArrayList<String>();
		if(map.get("mrTypes")!=null  && map.get("mrTypes") instanceof String){
			String[] mrTypes = {map.get("mrTypes").toString()};
			mrTypeList =  Arrays.asList(mrTypes);
		}else if(map.get("mrTypes")!=null){
			String[] mrTypes = (String[]) (map.get("mrTypes")!=null?map.get("mrTypes"):null);
			mrTypeList =  Arrays.asList(mrTypes);
		}
		
		
		if(pageNum.equals("")){
			pageNum="1";
		}
		//List<String> userRoleDeptListToSearch = new ArrayList<String>() ;//查询的科室范围
		if(pageSize.equals("")){
			pageSize="25";
		}
		Session session = Session.get();
		String userId = session.getUserId() ;
		List<String> userRoleMrbDeptList = userRoleService.userRoleMrbDeptList(userId,searchDeptCode);
		if(null == userRoleMrbDeptList){
			//当为null，表示没有可以查询的科室
			result = builder.build();
			result.setTotal(0);
			return result;
		}
		int total = 0;
		List<String> enTypeCodeList = new ArrayList<String>();
		if(!StringUtils.isBlank(enTypeCode)){
			enTypeCodeList.add(enTypeCode);
			if(enTypeCode.equalsIgnoreCase("ENM01.01")){
				enTypeCodeList.add("ENM01.02");
			}
		}
		SelectOptions options = SelectOptions.get().offset((Integer.valueOf(pageNum)-1)*Integer.valueOf(pageSize)).limit(Integer.valueOf(pageSize)).count();			
		List<MrAmr> mrAmr= cusMrAmrDao.selectParientAllForMrb(enTypeCodeList,userRoleMrbDeptList, doctorCode,receiveTime, finishTime,idCardNo, amrNo,paId, patientName,mobile,amrStaCd,mrTypeList,options);
		List<Amr>  amrs=new ArrayList<Amr>();
		if(mrAmr!=null&&mrAmr.size()>0){
			long count = options.getCount();
			total = Long.valueOf(count).intValue();
			for (MrAmr mrAmr2 : mrAmr) {
				Amr amr = new Amr();
				BeanCopyUtil.entityToModel(amr, mrAmr2, Amr.OBJ_CD, dictionnaryService);
				amr.setEncounterCount(mrAmr2.getEnCnt().toString());
				amrs.add(amr);
			}
		}
		
		builder.withData(amrs.toArray(new Amr[0]));
		result = builder.build();
		result.setTotal(total);
		return result;
	
	}
	@Override
	public SingleResult<String> searchOtherOmr(Map<String, String> map) throws Throwable {
		SingleResult<String> result = new SingleResult<String>();
		Param[] params=paramsService.getParam(SysFunctionCode.OTHER_EMR_PATH).getDataList();
    	String filePath=null;
    	for (Param param : params) {
			if(param.getKey().equals("OTHER_EMR_WEBSERVICE_URL"))
			{
				filePath=param.getValue();
			}
		}
		URL url = null;
		URL baseUrl;
        baseUrl = pkuhit.iih.mr.wr.org.tempuri.IEMRExpservice.class.getResource(".");            
		url = new URL(baseUrl, filePath);
		//先调用service，然后找到serviceImpl，最后找方法  new URL("file:/D:/test/test.wsdl")
    	IEMRExpservice iemrService =new IEMRExpservice(url,new QName("http://tempuri.org/", "IEMRExpservice"));
    	IEMRExp iemrExp = iemrService.getIEMRExpPort();
    	String wsCode = getStringValueFromMap(map, "enType").trim();//调用电子病历1为门诊，0为住院
    	//String wsCode = "1";		
    	String xmlStr = iemrExp.getEmrFramework(wsCode);
    	SAXReader saxReader = new SAXReader();
		Document docx= null;
		Document docx1= null;
		Document docx2= null;
		try{
			if(xmlStr!=null && xmlStr.length()!=0){
				docx= (Document) saxReader.read(new StringReader(xmlStr));
			}else{
				return null;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
//		String patid = "000047561400"+"+32";
		String enSn = getStringValueFromMap(map, "encounterSn").trim();
//		String enSn = id;
		String[] a =enSn.split("_");//根据空格拆分
		String  patid = a[0]+"+"+a[1];
		String mrContent = "";
  		Element rootElem = ((org.dom4j.Document) docx).getRootElement(); //根节点<data-record>
  		List<Element> listOne = rootElem.elements();
  		String frameworkCode = null;
		/*for (Element child : listOne) {}
			frameworkCode = child.attributeValue("id");
		   //已知属性名情况下
		   System.out.println("id: " + child.attributeValue("id"));*/
		   if(wsCode.equals("0")){
			   frameworkCode="4";//出院记录
		   }else if(wsCode.equals("1")){
			   frameworkCode="11";//门诊
		   }
		   String mrTree = iemrExp.getPatChildNodes(wsCode, patid, frameworkCode);
		   try {
				docx1= (Document) saxReader.read(new StringReader(mrTree));
			} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
		   	Element rootElem1 = docx1.getRootElement(); //根节点<data-record>
			List<Element> listOne1 = rootElem1.elements();
			String colId = "0";
			for (Element child1 : listOne1) {
				String recId = child1.attributeValue("id");
				String mrContentXml = iemrExp.getDocXML(wsCode, frameworkCode, recId, colId);
		  		docx2= (Document) saxReader.read(new StringReader(mrContentXml));
				Element rootElem2 = docx2.getRootElement();
				List<Element> listOne3 = rootElem2.elements();
				for(Element childThree : listOne3){
					List<Element> listOne4 = childThree.elements();
					if(listOne4!=null && listOne4.size()>0)
						for(int i=0;i<listOne4.size();i++){
							mrContent +=listOne4.get(i).getText();
						}
//						mrContent=listOne4.get(0).getText();
				}
			}
				
		
  		
		/*String[] arr = mrContent.split(" ");//根据空格拆分
		String mr = "";
		for(int i =0;i<arr.length;i++){
			if(arr[i].indexOf("：") == -1){
			String ar =arr[i];
			mr +=ar;
//			i++;
			}else{
				String a =" \r\n"+arr[i];
				mr +=a;
			}
			
		}*/
        SingleResult<String> test= new SingleResult<String>();
        test.setData("1");
        if(mrContent.equals("")){
        	return test;
        }else{
        	result.setData(mrContent);
        	return result;  		
        }
	}
	
	private String getStringValueFromMap(Map map,String key){
		String value = "";//null ;
		if(map.containsKey(key) && null != map.get(key)){
			value = (String)map.get(key);
			if(StringUtils.isBlank(value)){
				value = "";//null ;
			}
		}
		return value;
	}
	@Override
	public SingleResult<Map> iemrCallHis() throws Throwable {

		SingleResult<Map> result;
		SingleResultBuilder<Map> builder = SingleResultBuilder.newSingleResult(Map.class);
		Map<String,String> map=new HashMap<String,String>();
		String  iemrCallCisParam="";
		Param[] emrCallCisParams=paramsService.getParam(SysFunctionCode.EMR_CALL_CIS).getDataList();
		for(int i=0; i<emrCallCisParams.length ; i++){
			Param param=emrCallCisParams[i];
			if(param.getKey().equals("IEMR_CALL_CIS")){//&&"1".equals(param.getValue())
				iemrCallCisParam=param.getValue();
				break;
			}
		}
			
		map.put("iemrCallCisParam", iemrCallCisParam);
		builder.withData(map);
		result=builder.build();
		return result;
	
		
	}

	@Override
	public ArrayResult<Amr> getMrAmrForCons(String consRespDeptId,
			String consRespDctId, String oderStartTime, String orderEndTime	 , String enTpCd) {
		log.debug("EncounterType is:"+ enTpCd);
		List<Map<String, Object>>  mrAmrList  = new ArrayList<Map<String, Object>>() ;
	    ArrayResultBuilder<Amr> builder = ArrayResultBuilder.newArrayResult(Amr.class);
        ArrayResult<Amr> amrArrayResult = new ArrayResult<Amr>();
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd 00:00:00");
        DateFormat edf = new SimpleDateFormat("yyyy-MM-dd 23:59:59");
        Calendar calendar = Calendar.getInstance();
        String sStartTime = null;
        String sEndTime = null;
        if(!StringUtils.isBlank(oderStartTime)){
            calendar.setTimeInMillis(Long.parseLong(oderStartTime));
            Date sDate = calendar.getTime();
            sStartTime = sdf.format(sDate);
        }
        if(!StringUtils.isBlank(orderEndTime)){
            calendar.setTimeInMillis(Long.parseLong(orderEndTime));
            Date eDate = calendar.getTime();
            sEndTime = edf.format(eDate);
        }
		//查询是否开关
		SingleResult<String> rsFunFlag = paramsSetService.searchFunFlagByKey("MRAMR_FLAG_CONS");
		if(null != rsFunFlag 
				&&  null != rsFunFlag.getData()
				&& rsFunFlag.getData().equalsIgnoreCase("1")
		)
		{
			if(EncounterType.OUTPATIENT.equalsIgnoreCase(enTpCd)
				|| EncounterType.EMERGENCY.equalsIgnoreCase(enTpCd)
			 ){
				//门诊 急诊
				SingleResult<Map> rsMapParam = paramsSetService.searchByCode(SysFunctionCode.DATA_SOURCE);
				if(null != rsMapParam && null != rsMapParam.getData() && rsMapParam.getData().containsKey("DS_CONS_MZ")){
					String value = rsMapParam.getData().get("DS_CONS_MZ").toString();
					log.debug("DS_CONS_MZ is:"+value);
					if("HIS".equalsIgnoreCase(value)){
						mrAmrList  = hisConsMrAmrService.getMZList(consRespDeptId, consRespDctId, oderStartTime, orderEndTime);
					}else if("CIS".equalsIgnoreCase(value)){
						mrAmrList = cisConsMrAmrService.getMZList(consRespDeptId, consRespDctId, oderStartTime, orderEndTime);
					}else{
						log.info("数据库参数配置中,读取code为SYSM01.16的参数，key为 DS_CONS_MZ 的value值 配置不正确，应该为his或者cis");
					}
				}else{
					if(null == rsMapParam ){
						log.info("数据库参数配置中,读取code为SYSM01.16的参数，不存在");
					}else if (null == rsMapParam.getData()){
						log.info("数据库参数配置中,读取code为SYSM01.16的参数，第一条为null");
					} else if(!rsMapParam.getData().containsKey("DS_CONS_MZ")){
						log.info("数据库参数配置中,读取code为SYSM01.16的参数，不包含key为DS_CONS_MZ的记录");
					}else{
						log.info("数据库参数配置中,读取code为SYSM01.16的参数，配置不正确，key为DS_CONS_MZ，value为"+rsMapParam.getData().get("DS_CONS_MZ").toString()+"。");
					}
				}
			}
			else if(EncounterType.INPATIENT.equalsIgnoreCase(enTpCd)){
				//住院
				SingleResult<Map> rsMapParam = paramsSetService.searchByCode(SysFunctionCode.DATA_SOURCE);
				if(null != rsMapParam && null != rsMapParam.getData() && rsMapParam.getData().containsKey("DS_CONS_ZY")){
					String value = rsMapParam.getData().get("DS_CONS_ZY").toString();
					log.debug("DS_CONS_ZY is:"+value);
					if("HIS".equalsIgnoreCase(value)){
						mrAmrList  = hisConsMrAmrService.getZYList(consRespDeptId, consRespDctId, oderStartTime, orderEndTime);
					}else if("CIS".equalsIgnoreCase(value)){
						mrAmrList = cisConsMrAmrService.getZYList(consRespDeptId, consRespDctId, oderStartTime, orderEndTime);
					}else{
						log.info("数据库参数配置中,读取code为SYSM01.16的参数，key为 DS_CONS_ZY 的value值 配置不正确，应该为his或者cis");
					}
				}else{
					if(null == rsMapParam ){
						log.info("数据库参数配置中,读取code为SYSM01.16的参数，不存在");
					}else if (null == rsMapParam.getData()){
						log.info("数据库参数配置中,读取code为SYSM01.16的参数，第一条为null");
					} else if(!rsMapParam.getData().containsKey("DS_CONS_ZY")){
						log.info("数据库参数配置中,读取code为SYSM01.16的参数，不包含key为DS_CONS_ZY的记录");
					}else{
						log.info("数据库参数配置中,读取code为SYSM01.16的参数，配置不正确，key为DS_CONS_ZY，value为"+rsMapParam.getData().get("DS_CONS_ZY").toString()+"。");
					}
				}
			}
		}else{
			if(null == rsFunFlag){
				log.info("数据库参数配置中未配置“会诊就诊同步”开关 ：code为SYSM01.0, key为MRAMR_FLAG_CONS");
			}else if(null == rsFunFlag.getData()){
				log.info("数据库参数配置中未配置“会诊就诊同步”开关：code为SYSM01.0, key为MRAMR_FLAG_CONS");
			}else{
				 log.info("数据库参数配置中“会诊就诊同步”开关，code为SYSM01.0, key为MRAMR_FLAG_CONS，value值为"+rsFunFlag.getData()+"。");
			}
		}
	    int total = 0;
        if(mrAmrList!=null&&mrAmrList.size()>0){
            total = mrAmrList.size();
            Amr [] amrs=new Amr[mrAmrList.size()];
            Map<String, Object> amrMap = null;
            Map<String, Object> tmpMap = null;
            for(int i=0;i<mrAmrList.size();i++){
                Amr amr = new Amr();
                amrMap = mrAmrList.get(i);
                tmpMap = new HashMap<String, Object>();
                tmpMap.put("EN_PK", amrMap.get("EN_PK"));
                tmpMap.put("PA_ID", amrMap.get("PA_ID"));
                tmpMap.put("CUR_BED_CD", amrMap.get("CUR_BED_CD"));
                tmpMap.put("AMR_NO", amrMap.get("AMR_NO"));
                tmpMap.put("PA_NM", amrMap.get("PA_NM"));
                tmpMap.put("SEX_CD", amrMap.get("SEX_CD"));
                tmpMap.put("AGE", amrMap.get("AGE"));
                tmpMap.put("CUR_DEPT_INTO_TIME", amrMap.get("CUR_DEPT_INTO_TIME"));
                tmpMap.put("CUR_MNG_DCT_ID", amrMap.get("CUR_MNG_DCT_ID"));
                tmpMap.put("exec_unit", amrMap.get("exec_unit"));
                tmpMap.put("resp_time", amrMap.get("resp_time"));
                tmpMap.put("requestDeptCode", amrMap.get("requestDeptCode"));
                tmpMap.put("requestDeptName", amrMap.get("requestDeptName"));
                tmpMap.put("mr_summary", amrMap.get("mr_summary"));
                BeanCopyUtil.mapToModel(amr, tmpMap, dictionaryService);
                amrs[i] = amr;
            }
            builder.withData(amrs);
        }
        amrArrayResult = builder.build();
        amrArrayResult.setTotal(total);
        return amrArrayResult;
		
	}

	@Override
	public ArrayResult<Amr> getMrAmrForStepDept(String stepRespDeptId,
			String stepRespDctId, String stepStartTime, String stepEndTime , String enTpCd) {
	    ArrayResultBuilder<Amr> builder = ArrayResultBuilder.newArrayResult(Amr.class);
        ArrayResult<Amr> amrArrayResult = new ArrayResult<Amr>();
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd 00:00:00");
        DateFormat edf = new SimpleDateFormat("yyyy-MM-dd 23:59:59");
        Calendar calendar = Calendar.getInstance();
        String sStartTime = null;
        String sEndTime = null;
        if(!StringUtils.isBlank(stepStartTime)){
            calendar.setTimeInMillis(Long.parseLong(stepStartTime));
            Date sDate = calendar.getTime();
            sStartTime = sdf.format(sDate);
        }
        if(!StringUtils.isBlank(stepEndTime)){
            calendar.setTimeInMillis(Long.parseLong(stepEndTime));
            Date eDate = calendar.getTime();
            sEndTime = edf.format(eDate);
        }
        int total = 0;
		log.debug("EncounterType is:"+ enTpCd);
		List<Map<String, Object>>  mrAmrList  = new ArrayList<Map<String, Object>>() ;
		SingleResult<String> rsFunFlag = paramsSetService.searchFunFlagByKey("MRAMR_FLAG_STEPDEPT");
		if(null != rsFunFlag 
				&&  null != rsFunFlag.getData()
				&& rsFunFlag.getData().equalsIgnoreCase("1")
		)
		{
			if(EncounterType.OUTPATIENT.equalsIgnoreCase(enTpCd)
					|| EncounterType.EMERGENCY.equalsIgnoreCase(enTpCd)
				 ){
					//门诊 急诊
					SingleResult<Map> rsMapParam = paramsSetService.searchByCode(SysFunctionCode.DATA_SOURCE);
					if(null != rsMapParam && null != rsMapParam.getData() && rsMapParam.getData().containsKey("DS_STEPDEPT_MZ")){
						String value = rsMapParam.getData().get("DS_STEPDEPT_MZ").toString();
						log.debug("DS_STEPDEPT_MZ is:"+value);
						if("HIS".equalsIgnoreCase(value)){
							mrAmrList  = hisStepDeptMrAmrService.getMZList(stepRespDeptId, stepRespDctId, stepStartTime, stepEndTime);
						}else if("CIS".equalsIgnoreCase(value)){
							mrAmrList = cisStepDeptMrAmrService.getMZList(stepRespDeptId, stepRespDctId, stepStartTime, stepEndTime);
						}else{
							log.info("数据库参数配置中,读取code为SYSM01.16的参数，key为 DS_STEPDEPT_MZ 的value值 配置不正确，应该为his或者cis");
						}
					}else{
						if(null == rsMapParam ){
							log.info("数据库参数配置中,读取code为SYSM01.16的参数，不存在");
						}else if (null == rsMapParam.getData()){
							log.info("数据库参数配置中,读取code为SYSM01.16的参数，第一条为null");
						} else if(!rsMapParam.getData().containsKey("DS_STEPDEPT_MZ")){
							log.info("数据库参数配置中,读取code为SYSM01.16的参数，不包含key为DS_STEPDEPT_MZ的记录");
						}else{
							log.info("数据库参数配置中,读取code为SYSM01.16的参数，配置不正确，key为DS_STEPDEPT_MZ，value为"+rsMapParam.getData().get("DS_STEPDEPT_MZ").toString()+"。");
						}
					}
				}
				else if(EncounterType.INPATIENT.equalsIgnoreCase(enTpCd)){
					//住院
					SingleResult<Map> rsMapParam = paramsSetService.searchByCode(SysFunctionCode.DATA_SOURCE);
					if(null != rsMapParam && null != rsMapParam.getData() && rsMapParam.getData().containsKey("DS_STEPDEPT_ZY")){
						String value = rsMapParam.getData().get("DS_STEPDEPT_ZY").toString();
						log.debug("DS_STEPDEPT_ZY is:"+value);
						if("HIS".equalsIgnoreCase(value)){
							mrAmrList  = hisStepDeptMrAmrService.getZYList(stepRespDeptId, stepRespDctId, stepStartTime, stepEndTime);
						}else if("CIS".equalsIgnoreCase(value)){
							mrAmrList = cisStepDeptMrAmrService.getZYList(stepRespDeptId, stepRespDctId, stepStartTime, stepEndTime);
						}else{
							log.info("数据库参数配置中,读取code为SYSM01.16的参数，key为 DS_STEPDEPT_ZY 的value值 配置不正确，应该为his或者cis");
						}
					}else{
						if(null == rsMapParam ){
							log.info("数据库参数配置中,读取code为SYSM01.16的参数，不存在");
						}else if (null == rsMapParam.getData()){
							log.info("数据库参数配置中,读取code为SYSM01.16的参数，第一条为null");
						} else if(!rsMapParam.getData().containsKey("DS_STEPDEPT_ZY")){
							log.info("数据库参数配置中,读取code为SYSM01.16的参数，不包含key为DS_STEPDEPT_ZY的记录");
						}else{
							log.info("数据库参数配置中,读取code为SYSM01.16的参数，配置不正确，key为DS_STEPDEPT_ZY，value为"+rsMapParam.getData().get("DS_STEPDEPT_ZY").toString()+"。");
						}
					}
				}
			}else{
				if(null == rsFunFlag){
					log.info("数据库参数配置中未配置“跨科就诊同步”开关 ：code为SYSM01.0, key为MRAMR_FLAG_STEPDEPT");
				}else if(null == rsFunFlag.getData()){
					log.info("数据库参数配置中未配置“跨科就诊同步”开关：code为SYSM01.0, key为MRAMR_FLAG_STEPDEPT");
				}else{
					 log.info("数据库参数配置中“跨科就诊同步”开关，code为SYSM01.0, key为MRAMR_FLAG_STEPDEPT，value值为"+rsFunFlag.getData()+"。");
				}
			}
	       if(mrAmrList!=null&&mrAmrList.size()>0){
	            total = mrAmrList.size();
	            Amr [] amrs=new Amr[mrAmrList.size()];
	            Map<String, Object> amrMap = null;
	            Map<String, Object> tmpMap = null;
	            for(int i=0;i<mrAmrList.size();i++){
	                Amr amr = new Amr();
	                amrMap = mrAmrList.get(i);
	                tmpMap = new HashMap<String, Object>();
	                tmpMap.put("EN_PK", amrMap.get("EN_PK"));
	                tmpMap.put("PA_ID", amrMap.get("PA_ID"));
	                tmpMap.put("CUR_BED_CD", amrMap.get("CUR_BED_CD"));
	                tmpMap.put("AMR_NO", amrMap.get("AMR_NO"));
	                tmpMap.put("PA_NM", amrMap.get("PA_NM"));
	                tmpMap.put("SEX_CD", amrMap.get("SEX_CD"));
	                tmpMap.put("AGE", amrMap.get("AGE"));
	                tmpMap.put("CUR_DEPT_INTO_TIME", amrMap.get("CUR_DEPT_INTO_TIME"));
	                tmpMap.put("CUR_MNG_DCT_ID", amrMap.get("CUR_MNG_DCT_ID"));
	                tmpMap.put("exec_unit", amrMap.get("exec_unit"));
	                tmpMap.put("resp_time", amrMap.get("resp_time"));
	                BeanCopyUtil.mapToModel(amr, tmpMap, dictionaryService);
	                amrs[i] = amr;
	                
	            }
	            builder.withData(amrs);
	        }
	        amrArrayResult = builder.build();
	        amrArrayResult.setTotal(total);
	        return amrArrayResult;
		
	
	}

	@Override
	public SingleResult<Amr> syncPaToMrAmr(Map<String, String> map)
			throws Throwable {
		String enPk = "";
		if(map != null ){
			enPk = map.containsKey("enPk")?map.get("enPk").toString():"";
		}
		//从数据库获取就诊
		PerformancePrinter.start("isExistEncounter");
		boolean aa = map.containsKey("patientId");
		Integer count = this.cusMrAmrDao.isExistEncounter(enPk);
		PerformancePrinter.end("isExistEncounter");
		map.put("enSource", "CIS");
		
		//只有患者本次就诊信息不存在，才保存
		if(count == 0){
			insertOrUpdateEn(enPk, map);
		}
		SingleResultBuilder<Amr> builder = SingleResultBuilder.newSingleResult(Amr.class);
		return builder.build();
	}
	
	@Override
	public PatientModel getPatientDetail(Map<String, String> map){
		String paId = null ;
		String enTypeCode = null ;
		PatientModel rs= null ;
		if(map != null ){
			paId = map.containsKey("paId")?map.get("paId").toString():"";
			enTypeCode =  map.containsKey("enTypeCode")?map.get("enTypeCode").toString():"";
			if(StringUtils.isBlank(paId) || StringUtils.isBlank(enTypeCode)){	
				log.info("paId is |"+paId+"|");
				log.info("enTypeCode is |"+enTypeCode+"|");
				log.info("StringUtils.isBlank(paId) || StringUtils.isBlank(enTypeCode)");
				log.info("rs is null");
				
			}else{
				log.debug("enTypeCode is |"+enTypeCode+"|");
				if(EncounterType.OUTPATIENT.equalsIgnoreCase(enTypeCode)
						|| EncounterType.EMERGENCY.equalsIgnoreCase(enTypeCode)
					 ){
					
						//门诊 急诊
					rs = this.mzEncounterService.getPatientDetailForMz(paId);
					log.debug("mz");
				}else{
					if(EncounterType.INPATIENT.equalsIgnoreCase(enTypeCode)
						 ){
						
							//住院
						rs = 	this.zyEncounterService.getPatientDetailForZy(paId);
						log.debug("zy");
					}
				}
			}

		}else{
			log.info("map is null ,rs is null");
		}
		return rs;
	}
}
