package pkuhit.iih.qa;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import pkuhit.iih.qa.dao.auto.QaDao;
import pkuhit.iih.qa.dao.auto.entity.Qa;
import pkuhit.iih.qa.dao.custom.CusQaRecordDao;
import pkuhit.iih.qa.old.QaFault;
import pkuhit.iih.qa.old.QaRecord;
import pkuhit.md.DictionaryService;
import pkuhit.xap.ac.Session;
import pkuhit.xap.util.BeanCopyUtil;
import xap.sv.annotation.Reference;
import xap.sv.model.SingleResult;
import xap.sv.model.SingleResultBuilder;
import xap.sv.util.UUIDGenerator;
/**
 * 
 * <p>QaRecordServiceImpl</p>
 * <p>质控工作记录服务实现</p>
 *
 * @author		chengfeng(cheng_feng@founder.com)
 * @version		0.0.0
 */
public class QaRecordServiceImpl implements QaRecordService {
	
	@Autowired
	QaDao qaDao;
	
	@Autowired
	CusQaRecordDao cusQaRecordDao;
	
	@Reference
	DictionaryService dictionaryService;
	
	public QaRecordServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public SingleResult<QaRecord> create(QaRecord qaRecord) throws Throwable { 
		Qa qa = new Qa();
		String id = qaRecord.getPk();
		if("".equals(id)||id==null){
			id = UUIDGenerator.getUUID();
			qaRecord.setPk(id);
		}
		BeanCopyUtil.modelToEntity(qa, qaRecord);
		qaDao.insert(qa);
		return this.getQaRecordById(id);
	}

	@Override
	public SingleResult<QaRecord> updateById(String id, QaRecord qaRecord) throws Throwable {
		Qa qa= new Qa();
		BeanCopyUtil.modelToEntity(qa, qaRecord);
		qaDao.updateExcludeNull(qa);
		return this.getQaRecordById(id);
	}

	@Override
	public SingleResult<QaRecord> search(String pk) throws Throwable {
		SingleResult<QaRecord> qaRecordS = new SingleResult<QaRecord>();
		Qa qa= qaDao.selectById(pk);
		QaRecord qaRecordM = new QaRecord();
		BeanCopyUtil.entityToModel(qaRecordM, qa, QaRecord.OBJ_CD, dictionaryService);
		qaRecordS.setData(qaRecordM);
		return qaRecordS;
	}

	@Override
	public SingleResult<QaRecord> delete(String id) throws Throwable {
		Qa qa = qaDao.selectById(id);
		qa.setDelF((short)1);
		qaDao.markDelete(qa);
		return this.getQaRecordById(id);
	}

	@Override
	public String checkExistUncompleted(String enPk) throws Throwable {
		Session session = Session.get();
		String userId = session.getUserId();
		short cmplF = 0;
		List<Qa> qaList = cusQaRecordDao.selectByEnPk(enPk, userId, cmplF);
		String qaPk = "";
		if(qaList.size()>0){
			qaPk = qaList.get(0).getQaPk();
		}
		return qaPk;
	}
	
	/**
	 * 查询上一条质控工作记录ID
	 * @param String  enPk  就诊主键 
	 * @return 没有：""，有：qaPk编码
	 * @throws Throwable
	 */
	private String searchPreviousQa(String  enPk) throws Throwable {
		Session session = Session.get();
		String userId = session.getUserId();
		short cmplF = 1;
		List<Qa> qaList = cusQaRecordDao.selectByEnPk(enPk, userId, cmplF);
		String preQaPk = "";
		if(qaList.size()>1){
			preQaPk = qaList.get(1).getQaPk();
		}
		return preQaPk;
	}

	@Override
	public SingleResult<QaRecord> searchFaultStatistical(String qaPk,String userId, String deptCd) throws Throwable {
		Map<String, Object> map = null;
		map = cusQaRecordDao.selectFaultStatistical(qaPk, userId, deptCd);
		SingleResult<QaRecord> qaRecordResult = new SingleResult<QaRecord>();
		QaRecord qaRecord = new QaRecord();
		BeanCopyUtil.mapToModel(qaRecord, map);
		qaRecordResult.setData(qaRecord);
		return qaRecordResult;
	}
	
	@Override
	public SingleResult<QaRecord> searchLastCompleted(String enPk, String qaTypeCode) throws Throwable {
		SingleResultBuilder<QaRecord> builder = SingleResultBuilder.newSingleResult(QaRecord.class);
		Qa qa = cusQaRecordDao.selectLastCompleted(enPk, qaTypeCode);
		if(qa!=null){
			QaRecord qaRecord = new QaRecord();
			BeanCopyUtil.entityToModel(qaRecord, qa, QaRecord.OBJ_CD, dictionaryService);
			builder.withData(qaRecord);
		}
		return builder.build();
	}

	/*@Override
	public SingleResult<QaRecord> searchQaByFaultPk(String faultPk)
			throws Throwable {
		Qa qa = cusQaRecordDao.selectQaByFaultPk(faultPk);
		SingleResult<QaRecord> result = new SingleResult<QaRecord>();
		BeanCopyUtil.entityToModel(result, qa, QaRecord.OBJ_CD, dictionaryService);
		return result;
	}*/
	
	private SingleResult<QaRecord> getQaRecordById(String id) throws Throwable {
		SingleResultBuilder<QaRecord> builder = SingleResultBuilder.newSingleResult(QaRecord.class);
		Qa qa = qaDao.selectById(id);
		QaRecord qaRecord = new QaRecord();
		if (null != qa) {
			BeanCopyUtil.entityToModel(qaRecord, qa, QaFault.OBJ_CD, dictionaryService);
			builder.withData(qaRecord);
		}
		return builder.build();
	}
}
