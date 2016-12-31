package pkuhit.iih.iemr.qa;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Timestamp;

import pkuhit.iih.mr.md.AmrStatus;
import pkuhit.iih.mr.wr.Amr;
import pkuhit.iih.qa.old.QaRecord;
import pkuhit.xap.ac.Session;
import pkuhit.xap.sy.SysConfigService;
import xap.sv.annotation.Reference;
import xap.sv.model.SingleResult;
import xap.sv.util.BeanCopyUtil;
import xap.sv.util.UUIDGenerator;
/**
 * 
 * @author cheng_feng
 *
 */
public class QaServiceImpl implements QaService {
	
	@Reference
	SysConfigService sysConfigService;
	
	@Reference
	pkuhit.iih.qa.QaRecordService qaRecordServiceMr;
	
	@Reference
	pkuhit.iih.mr.wr.AmrService amrServiceMr;
	
	public QaServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void create(QaRecord qaRecordM) throws Throwable { 
		String enPk = qaRecordM.getEncounterPk();
		if(checkCanOperateByAmrStatus(enPk)){
			//调用发消息~~~~~~~~~~~~
			return;
		}
		Session session = Session.get();
		String userId = session.getUserId();
		String deptId = session.getDeptId();
		
		QaRecord qaRecord = new QaRecord();
		String qaPk = qaRecordM.getPk();
		if(qaPk==null||"".equals(qaPk)){
			qaPk = UUIDGenerator.getUUID();
		}
		String qaTypeCode = qaRecordM.getQaTypeCode();
		Short autoFlag = qaRecordM.getAutoFlag();
//		BigDecimal autoFlag = new BigDecimal(qaRecordM.getAutoFlag().toString());
		Timestamp executeBeginTime = (Timestamp) qaRecordM.getExecuteBeginTime();
		BigInteger reformDeadline = qaRecordM.getReformDeadline();
		Short completedFlag = qaRecordM.getCompletedFlag();
//		BigDecimal completedFlag = new BigDecimal(qaRecordM.getCompletedFlag().toString());
		qaRecord.setPk(qaPk);
		qaRecord.setQaSystemCode(sysConfigService.getObject("qaSystemCode").toString());//获取质控体系编码，读取配置项~~~~~~~~~~~~
		qaRecord.setEncounterPk(enPk);
		qaRecord.setQaTypeCode(qaTypeCode);
		qaRecord.setAutoFlag(autoFlag);
		BigDecimal zero = new BigDecimal(0);
		BigDecimal one = new BigDecimal(1);
//		if(autoFlag.compareTo(zero)==0){//手动质控
		if(autoFlag==0){//手动质控
			qaRecord.setExecuteBeginTime(executeBeginTime);
		}else{//自动质控
			qaRecord.setPlanTime(new Timestamp(System.currentTimeMillis()));
		}
		qaRecord.setCompletedFlag(completedFlag);
//		if(completedFlag.compareTo(one)==0){//已完成
		if(completedFlag==1){//已完成
			qaRecord.setExecuteEndTime(new Timestamp(System.currentTimeMillis()));
			qaRecord.setExcuteUserId(userId);
			qaRecord.setExecuteDeptCode(deptId);
		}
		qaRecord.setReformDeadline(reformDeadline);
		Short haveFaultFlag = qaRecordM.getHaveFaultFlag();
		Short needReformFaultFlag = qaRecordM.getNeedReformFaultFlag();
//		BigDecimal haveFaultFlag = new BigDecimal(qaRecordM.getHaveFaultFlag().toString());
//		BigDecimal needReformFaultFlag = new BigDecimal(qaRecordM.getNeedReformFaultFlag().toString());
//		qaRecord.setHaveFaultFlag(haveFaultFlag);
//		qaRecord.setNeedReformFaultFlag(needReformFaultFlag);
		
		qaRecordServiceMr.create(qaRecord);
	}

	@Override
	public SingleResult<QaRecord> update(String id, QaRecord qaRecord) throws Throwable {
		String enPk = qaRecord.getEncounterPk();
		if(checkCanOperateByAmrStatus(enPk)){
			//调用发消息~~~~~~~~~~~~~
			return null;
		}
		SingleResult<QaRecord> qaRecordS = qaRecordServiceMr.updateById(id, qaRecord);
		return qaRecordS;
	}

	@Override
	public SingleResult<QaRecord> search(String pk) throws Throwable {
		SingleResult<QaRecord> qaRecordS = qaRecordServiceMr.search(pk);
		return qaRecordS;
	}

	@Override
	public void delete(String pk) throws Throwable {
		SingleResult<QaRecord> qaRecordS = qaRecordServiceMr.search(pk);
		QaRecord qaRecord = new QaRecord();
		BeanCopyUtil.beanCopy(qaRecord, qaRecordS);
		String enPk = qaRecord.getEncounterPk();
		if(checkCanOperateByAmrStatus(enPk)){
			//调用发消息~~~~~~~~~~~~~
			return;
		}
		qaRecordServiceMr.delete(pk);
	}

	@Override
	public void complete(String pk) throws Throwable {
		Session session = Session.get();
		String userId = session.getUserId();
		String deptId = session.getDeptId();
		SingleResult<QaRecord> qaRecordS = qaRecordServiceMr.search(pk);
		String enPk = qaRecordS.getData().getEncounterPk();
		if(checkCanOperateByAmrStatus(enPk)){
			//调用发消息~~~~~~~~~~~~~~
			return;
		}
		QaRecord qaRecord = new QaRecord();
		BeanCopyUtil.beanCopy(qaRecord, qaRecordS);
		qaRecord.setExecuteEndTime(new Timestamp(System.currentTimeMillis()));
		qaRecord.setExcuteUserId(userId);
		qaRecord.setExecuteDeptCode(deptId);
		qaRecord.setCompletedFlag((short)1);
//		qaRecord.setCompletedFlag(new BigDecimal(1));
		//【质控类型编码】为终末质控，将病历文书状态设置为“整改要求已发送”
		//2.3调用【发送整改通知服务】（共通组提供）
		//2.4调用【创建任务服务】（共通组提供）

	}
	
	public boolean checkCanOperateByAmrStatus(String enPk) throws Throwable {
		boolean canOperate = true;
		SingleResult<Amr> amr  = amrServiceMr.get(enPk);
		String statusCode = amr.getData().getStatusCode();
		if(AmrStatus.ARCHIVED.equals(statusCode)){// 已归档
			canOperate = false;
		}
		return canOperate;
	}
	
}
