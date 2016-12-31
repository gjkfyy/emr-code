package pkuhit.xap.log;

import org.springframework.beans.factory.annotation.Autowired;

import pkuhit.md.DictionaryService;
import pkuhit.xap.dao.auto.XapErrlogDao;
import pkuhit.xap.dao.auto.entity.XapErrlog;
import pkuhit.xap.util.BeanCopyUtil;
import xap.sv.annotation.Reference;

public class ErrorLogServiceImpl implements ErrorLogService {
    
	@Autowired
	XapErrlogDao  xapErrLogDao;
	
	 @Reference
	 DictionaryService dictionaryService;
	 
	@Override
	public ErrorLog create(ErrorLog errorLog) {
		// TODO Auto-generated method stub
		XapErrlog entity = new XapErrlog();
		BeanCopyUtil.modelToEntity(entity, errorLog);
		xapErrLogDao.insert(entity);
		return errorLog;
	}

	@Override
	public ErrorLog update(ErrorLog errorLog) {
		// TODO Auto-generated method stub
		XapErrlog entity = new XapErrlog();
		BeanCopyUtil.modelToEntity(entity, errorLog);
		xapErrLogDao.updateExcludeNull(entity);
		return errorLog;
	}

	@Override
	public ErrorLog delete(ErrorLog errorLog) {
		// TODO Auto-generated method stub
		XapErrlog entity = new XapErrlog();
		BeanCopyUtil.modelToEntity(entity, errorLog);
		xapErrLogDao.markDelete(entity);
		return errorLog;
	}

	@Override
	public ErrorLog select() {
		// TODO Auto-generated method stub
		 
		return null;
	}

}
