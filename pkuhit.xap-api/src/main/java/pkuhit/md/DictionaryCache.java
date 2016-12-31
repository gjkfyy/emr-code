package pkuhit.md;

public interface DictionaryCache
{
    Dictionary getDictionary(String dictId);
    
    
    boolean hasDictionary(String dictId);
    
    Dictionary remove(String dictId);
    
    void save(Dictionary dict);
}
