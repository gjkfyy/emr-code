package pkuhit.xap.task.dataSearcher;

import pkuhit.iih.qa.EmrEventModel;
import xap.ru.engin.data.Condition;
import xap.ru.engin.data.DataSearcher;
import xap.ru.engin.data.SearchResult;

public class SimpleDataSearcher implements DataSearcher {

	@SuppressWarnings("unchecked")
	@Override
	public SearchResult<EmrEventModel> search(Condition condition) {
		SearchResult<EmrEventModel> searchResult = new SearchResult<EmrEventModel>();
		searchResult.setKey("simple");
		searchResult.setResultList(null);
		return searchResult;
	}
	
	

}
