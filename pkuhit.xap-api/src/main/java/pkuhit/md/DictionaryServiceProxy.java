package pkuhit.md;

import xap.sv.annotation.Reference;

public class DictionaryServiceProxy extends CacheableDictionaryService
{
    @Reference
    DictionaryService delegate;

    @Override
    protected DictionaryService getDelegate()
    {
        return delegate;
    }

    @Override
    protected Dictionary doSearchSingleDictionary(DictionarySearchKey key)
    {
        throw new UnsupportedOperationException();
    }

	@Override
	public String updateDictionary(String dictId) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}
}
