package pkuhit.iih.qa.qaauto.resultHandler;

import xap.ru.engin.data.DataModel;
import xap.ru.engin.item.ItemEvent;
import xap.ru.engin.result.ResultHandler;

public class QaItemResultHandler implements ResultHandler{

	@Override
	public void handle(DataModel dataModel,ItemEvent itemEvent) {
		// TODO Auto-generated method stub
		itemEvent.setQaValidateModelMap(dataModel.getValidateResultList());
	}

}
