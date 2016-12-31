package pkuhit.iih.qa.qaauto.dataSearcher;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import pkuhit.iih.mr.dao.auto.MrAmrDao;
import pkuhit.iih.qa.EmrEventModel;
import pkuhit.iih.qa.QaAutoEventService;
import pkuhit.iih.qa.cache.Cache;
import pkuhit.iih.qa.cache.CacheManager;
import pkuhit.md.DictionaryService;
import pkuhit.xap.ac.Session;
import xap.ru.engin.data.Condition;
import xap.ru.engin.data.DataSearcher;
import xap.ru.engin.data.SearchResult;
import xap.sv.annotation.Reference;
import xap.sv.model.ArrayResult;

public class QaAutoEmrEventDataSearcher implements DataSearcher {

	@Autowired
	MrAmrDao mrAmrDao;

	@Reference
	DictionaryService dictionaryService;
	
	@Reference
	QaAutoEventService qaAutoEventService;

	@SuppressWarnings("unchecked")
	@Override
	public SearchResult<EmrEventModel> search(Condition condition) {
		//获取itemEvent中的condition
		Map<String, Object> searchCondition = null;
		String enPk = "";
		String haveSession = "true";
		
		if(condition != null){
			searchCondition = condition.getSearchCondition();
		}
		if(searchCondition != null){
			enPk = searchCondition.get("enPk").toString();
			haveSession = searchCondition.get("haveSession") !=null ? searchCondition.get("haveSession").toString() : "true";
		}
		//查询患者病案，获取就诊信息
		SearchResult<EmrEventModel> searchResult = new SearchResult<EmrEventModel>();
		
		String emrEventKey = "";
		if(haveSession.equals("true")){
			Session session = Session.get();
			String curDeptId = session.getDeptId();
			emrEventKey = curDeptId+"_emrEvent_"+enPk;
		}else{ //预生成缺陷没有session，使用此key
			String qaWay= "preFltQa";
			emrEventKey = qaWay+"_emrEvent_"+enPk;
		}
		Cache emrEventCache = CacheManager.getCacheInfo(emrEventKey);
		Map<String,List<EmrEventModel>> emrEventMap = new HashMap<String,List<EmrEventModel>>();
		if(null != emrEventCache){
			emrEventMap = (Map<String, List<EmrEventModel>>) emrEventCache.getValue();
		}else{
			emrEventCache = new Cache(emrEventKey,emrEventMap,0,false);
			CacheManager.putCache(emrEventKey, emrEventCache);
		}
		
		if(emrEventMap.containsKey(enPk)){
			searchResult.setKey(emrEventKey);
			searchResult.setResultList(emrEventMap.get(enPk));
			return searchResult;
		}
		
		
		try {
			ArrayResult<EmrEventModel> EmrEventResult = qaAutoEventService.getEventTypeList(enPk);
			EmrEventModel[] emrEventModelArray = EmrEventResult.getDataList();
		
			searchResult.setKey(emrEventKey);
			if(null!=emrEventModelArray){
				
				searchResult.setResultList(Arrays.asList(emrEventModelArray));
				//把查询结果存入缓存map中
				emrEventMap.put(enPk, Arrays.asList(emrEventModelArray));
			}
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
		return searchResult;
	}
	
	

}
