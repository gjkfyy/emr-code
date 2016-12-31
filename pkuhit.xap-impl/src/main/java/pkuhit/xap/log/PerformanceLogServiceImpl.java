package pkuhit.xap.log;

import org.springframework.beans.factory.annotation.Autowired;

import pkuhit.md.DictionaryService;
import pkuhit.xap.dao.auto.XapPfmlogDao;
import pkuhit.xap.dao.auto.entity.XapPfmlog;
import pkuhit.xap.util.BeanCopyUtil;
import xap.sv.annotation.Reference;

public class PerformanceLogServiceImpl implements PerformanceLogService {
    
	 @Autowired
	 XapPfmlogDao xapPfmlogDao;
	 @Reference
	 DictionaryService dictionaryService;
	@Override
	public PerformanceLog create(PerformanceLog performanceLog) {
		// TODO Auto-generated method stub
		XapPfmlog entity = new XapPfmlog();
		BeanCopyUtil.modelToEntity(entity, performanceLog);
		xapPfmlogDao.insertExludeNull(entity);
		return performanceLog;
	}

	@Override
	public PerformanceLog update(PerformanceLog performanceLog) {
		// TODO Auto-generated method stub
		XapPfmlog entity = new XapPfmlog();
		BeanCopyUtil.modelToEntity(entity, performanceLog);
		xapPfmlogDao.updateExcludeNull(entity);
		return performanceLog;
	}

	@Override
	public PerformanceLog delete(PerformanceLog performanceLog) {
		// TODO Auto-generated method stub
		XapPfmlog entity = new XapPfmlog();
		BeanCopyUtil.modelToEntity(entity, performanceLog);
		xapPfmlogDao.markDelete(entity);
		return performanceLog;
	}

	@Override
	public PerformanceLog select() {
		// TODO Auto-generated method stub
		XapPfmlog entity =xapPfmlogDao.selectById("");
		PerformanceLog performanceLog = new PerformanceLog();
		BeanCopyUtil.entityToModel(performanceLog, entity, performanceLog.OBJ_CD, dictionaryService);
		return performanceLog;
	}

}
