package pkuhit.md;

import xap.sv.annotation.Reference;

public class DictionaryUpdateServiceImpl implements DictionaryUpdateService{
	
	@Reference
	DictionaryService dictionaryService;
	
	@Override
	public String updateDictionaryByDictId(String dictId) {
		// TODO Auto-generated method stub
		return dictionaryService.updateDictionary(dictId);
	}

}
