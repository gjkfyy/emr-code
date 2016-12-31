package pkuhit.iih.qa.qaauto.dataSearcher;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import pkuhit.iih.qa.QaAutoModel;
import pkuhit.iih.qa.cache.Cache;
import pkuhit.iih.qa.cache.CacheManager;
import pkuhit.iih.qa.dao.qacustom.CusQaAutoDao;
import pkuhit.md.DictionaryService;
import pkuhit.xap.ac.Session;
import pkuhit.xap.util.BeanCopyUtil;
import xap.ru.engin.data.Condition;
import xap.ru.engin.data.DataSearcher;
import xap.ru.engin.data.SearchResult;
import xap.sv.annotation.Reference;

public class EnMrListDataSearcher implements DataSearcher {

	@Autowired
	CusQaAutoDao cusQaAutoDao;

	@Reference
	DictionaryService dictionaryService;

	@SuppressWarnings("unchecked")
	@Override
	public SearchResult<QaAutoModel> search(Condition condition) {
		//获取itemEvent中的condition
		Map<String, Object> searchCondition = null;
		String enPk = "";
		String haveSession = "true";
		
		if(condition != null){
			searchCondition = condition.getSearchCondition();
		}
		if(searchCondition != null){
			enPk = searchCondition.get("enPk").toString();
		}
		SearchResult<QaAutoModel> searchResult = new SearchResult<QaAutoModel>();
		if(condition != null){
			enPk = condition.getSearchCondition().get("enPk").toString();
			haveSession = searchCondition.get("haveSession") !=null ? searchCondition.get("haveSession").toString() : "true";
		}
		String mrKey = "";
		if(haveSession.equals("true")){
			Session session = Session.get();
			String curDeptId = session.getDeptId();
			mrKey = curDeptId+"_mr_"+enPk;
		}else{ //预生成缺陷没有session，使用此key
			String qaWay= "preFltQa";
			mrKey = qaWay+"_mr_"+enPk;
		}
		Cache mrCache = CacheManager.getCacheInfo(mrKey);
		Map<String,List<QaAutoModel>> mrMap = new HashMap<String,List<QaAutoModel>>();
		if(null != mrCache){
			mrMap = (Map<String, List<QaAutoModel>>) mrCache.getValue();
		}else{
			mrCache = new Cache(mrKey,mrMap,0,false);
			CacheManager.putCache(mrKey, mrCache);
		}
		
		if(null != mrMap && mrMap.containsKey(enPk)){
			searchResult.setKey(mrKey);
			searchResult.setResultList(mrMap.get(enPk));
			return searchResult;
		}
		List<Map<String, Object>> qaAutoMrList = cusQaAutoDao.selectQaMr("1",
				"1", "1", enPk);
		List<QaAutoModel> qaAutoMrModelList = new ArrayList<QaAutoModel>();
		// 查询结果转换为qaAutoModel的list
		qaAutoMrModelList = convertQaAutoMapToModel(qaAutoMrList);
		
		searchResult.setKey(mrKey);
		searchResult.setResultList(qaAutoMrModelList);
		//把查询结果存入缓存map中
		mrMap.put(enPk, qaAutoMrModelList);
		System.out.println("this is enMrDatasearch");
		return searchResult;
	}

	private List<QaAutoModel> convertQaAutoMapToModel(
			List<Map<String, Object>> qaAutoMrList) {
		List<QaAutoModel> qaAutoMrModelList = new ArrayList<QaAutoModel>();
		if (null != qaAutoMrList) {
			if (qaAutoMrList.size() > 0) {
				Map<String, Object> mapQaAutoMr = null;
				for (int i = 0; i < qaAutoMrList.size(); i++) {
					QaAutoModel qaAutoModel = new QaAutoModel();
					mapQaAutoMr = qaAutoMrList.get(i);
					BeanCopyUtil.mapToModel(qaAutoModel, mapQaAutoMr,
							dictionaryService);
					qaAutoMrModelList.add(qaAutoModel);
				}
			}
		}
		return qaAutoMrModelList;
	}

}
