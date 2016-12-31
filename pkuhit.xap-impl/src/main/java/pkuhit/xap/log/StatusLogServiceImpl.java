package pkuhit.xap.log;

import org.springframework.beans.factory.annotation.Autowired;

import pkuhit.md.DictionaryService;
import pkuhit.xap.dao.auto.XapStalogDao;
import pkuhit.xap.dao.auto.entity.XapStalog;
import pkuhit.xap.util.BeanCopyUtil;
import xap.sv.annotation.Reference;

public class StatusLogServiceImpl implements StatusLogService {
   
	 @Autowired
	 XapStalogDao xapStalogDao;
	 
	 @Reference
	 DictionaryService dictionaryService;
	
	@Override
	public StatusLog create(StatusLog statusLog) {
		// TODO Auto-generated method stub
		XapStalog entity = new XapStalog();
		BeanCopyUtil.modelToEntity(entity, statusLog);
		xapStalogDao.insertExludeNull(entity);
		return statusLog;
	}

	@Override
	public StatusLog update(StatusLog statusLog) {
		// TODO Auto-generated method stub
		XapStalog entity = new XapStalog();
		BeanCopyUtil.modelToEntity(entity, statusLog);
		xapStalogDao.updateExcludeNull(entity);
		return statusLog;
	}

	@Override
	public StatusLog delete(StatusLog statusLog) {
		// TODO Auto-generated method stub
		XapStalog entity = new XapStalog();
		BeanCopyUtil.modelToEntity(entity, statusLog);
		xapStalogDao.markDelete(entity);
		return statusLog;
	}

	@Override
	public StatusLog select() {
		// TODO Auto-generated method stub
		StatusLog statusLog = new StatusLog();
		XapStalog entity = xapStalogDao.selectById("");
		BeanCopyUtil.entityToModel(statusLog, entity, statusLog.OBJ_CD, dictionaryService);
		return statusLog;
	}

}
