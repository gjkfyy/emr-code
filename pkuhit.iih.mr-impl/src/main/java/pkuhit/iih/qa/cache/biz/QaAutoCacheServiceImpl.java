
package pkuhit.iih.qa.cache.biz;

import java.util.List;
import java.util.Map;

import pkuhit.iih.qa.EmrEventModel;
import pkuhit.iih.qa.QaAutoModel;
import pkuhit.iih.qa.cache.Cache;
import pkuhit.iih.qa.cache.CacheManager;
import pkuhit.md.DictionaryService;
import pkuhit.xap.ac.Session;
import xap.sv.annotation.Reference;
/**
 * 
 * 该类用于缓存整个科室的一定数量的患者
 * @deprecated
 * @author wang_yanli
 * 
 *
 */
public class QaAutoCacheServiceImpl  implements QaAutoCacheService{
	

	@Reference
	QaAutoDataLoadService qaAutoDataLoadService;
	
	@Reference
	DictionaryService dictionaryService;

	
	public QaAutoCacheServiceImpl() {
		// TODO Auto-generated constructor stub
	}
    
	@Override
	public void putAutoDataToCache(Map map) throws Throwable{
		Session session  = Session.get();
		String curDeptId = session.getDeptId();//科室
		Map<String,List<QaAutoModel>> qaAutoMrModelsMap = qaAutoDataLoadService.searchQaAutoMrList(map);
		Map<String,List<EmrEventModel>>  qaAutoEmrEventModelsMap = qaAutoDataLoadService.searchQaAutoEventList(map);
		
		Cache mrCache = new Cache(curDeptId+"_mr",qaAutoMrModelsMap,0,false);
		Cache emrEventCache = new Cache(curDeptId+"_emrEvent",qaAutoEmrEventModelsMap,0,false);
		
		CacheManager.putCache(curDeptId+"_mr", mrCache ); 
		CacheManager.putCache(curDeptId+"_emrEvent", emrEventCache ); 
		
	}
}
