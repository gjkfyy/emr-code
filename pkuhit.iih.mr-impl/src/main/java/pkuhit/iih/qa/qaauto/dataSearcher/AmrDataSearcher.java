package pkuhit.iih.qa.qaauto.dataSearcher;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import pkuhit.iih.mr.dao.auto.MrAmrDao;
import pkuhit.iih.mr.dao.auto.entity.MrAmr;
import pkuhit.iih.mr.wr.Amr;
import pkuhit.iih.qa.QaFault;
import pkuhit.md.DictionaryService;
import pkuhit.xap.util.BeanCopyUtil;
import xap.ru.engin.data.Condition;
import xap.ru.engin.data.DataSearcher;
import xap.ru.engin.data.SearchResult;
import xap.sv.annotation.Reference;

public class AmrDataSearcher implements DataSearcher {

	@Autowired
	MrAmrDao mrAmrDao;

	@Reference
	DictionaryService dictionaryService;
	
	

	@Override
	public SearchResult<Amr> search(Condition condition) {
		// TODO Auto-generated method stub
		String enPk = "";
		if(condition != null){
			enPk = condition.getSearchCondition().get("enPk").toString();
		}
		//鏌ヨ鎮ｈ�呯梾妗堬紝鑾峰彇灏辫瘖淇℃伅
		List<Amr> amrList = new ArrayList<Amr>();
		MrAmr mrAmr = mrAmrDao.selectById(enPk);
		Amr amr = new Amr();
		BeanCopyUtil.entityToModel(amr, mrAmr, QaFault.OBJ_CD, dictionaryService);
		SearchResult<Amr> searchResult = new SearchResult<Amr>();
		amrList.add(amr);
		searchResult.setKey("amr");
		searchResult.setResultList(amrList);
		System.out.println("this is enMrDatasearch");
		return searchResult;
	}

}
