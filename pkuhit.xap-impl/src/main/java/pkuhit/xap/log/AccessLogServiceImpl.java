package pkuhit.xap.log;

import org.springframework.beans.factory.annotation.Autowired;

import pkuhit.md.DictionaryService;
import pkuhit.xap.dao.auto.XapAclogDao;
import pkuhit.xap.dao.auto.entity.XapAclog;
import pkuhit.xap.util.BeanCopyUtil;
import xap.sv.annotation.Reference;

public class AccessLogServiceImpl implements AccessLogService {
   
	@Autowired
	XapAclogDao xapAclogDao;
	@Reference
	DictionaryService dictionaryService;

	@Override
	public AccessLog create(AccessLog accessLog) {
		// TODO Auto-generated method stub
		XapAclog entity = new XapAclog();
		BeanCopyUtil.modelToEntity(entity, accessLog);
		xapAclogDao.insert(entity);
		return accessLog;
	}

	@Override
	public AccessLog update(AccessLog accessLog) {
		// TODO Auto-generated method stub
		XapAclog entity = new XapAclog();
		BeanCopyUtil.modelToEntity(entity, accessLog);
		xapAclogDao.updateExcludeNull(entity);
		return accessLog;
	}

	@Override
	public AccessLog delete(AccessLog accessLog) {
		// TODO Auto-generated method stub
		XapAclog entity = new XapAclog();
		BeanCopyUtil.modelToEntity(entity, accessLog);
		xapAclogDao.markDelete(entity);
		return accessLog;
	}

	@Override
	public AccessLog select() {
		// TODO Auto-generated method stub
		XapAclog entity = xapAclogDao.selectById("");
		AccessLog accessLog = new AccessLog();
		BeanCopyUtil.entityToModel(accessLog, entity, accessLog.OBJ_CD, dictionaryService);
		return accessLog;
	}

}
