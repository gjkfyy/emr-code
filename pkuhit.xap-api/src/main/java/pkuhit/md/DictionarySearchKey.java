package pkuhit.md;

import org.springframework.util.StringUtils;

public class DictionarySearchKey
{
    String id;

    String keyword;

    String codeList;

    @Deprecated
    String code;

    @Deprecated
    String name;

    @Deprecated
    String pinyin;

    @Deprecated
    String wubi;

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getCode()
    {
        return code;
    }

    public void setCode(String code)
    {
        this.code = code;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getPinyin()
    {
        return pinyin;
    }

    public void setPinyin(String pinyin)
    {
        this.pinyin = pinyin;
    }

    public String getWubi()
    {
        return wubi;
    }

    public void setWubi(String wubi)
    {
        this.wubi = wubi;
    }

    public static boolean hasMultipleId(DictionarySearchKey key)
    {
        String id = key.getId();
        if (id != null)
            return id.indexOf(",") > 0;
        return false;
    }

    /**
     * @return the keyword
     */
    public String getKeyword()
    {
        return keyword;
    }

    /**
     * @param keyword the keyword to set
     */
    public void setKeyword(String keyword)
    {
        this.keyword = keyword;
    }

    public String getCodeList()
    {
        return codeList;
    }

    public void setCodeList(String codeList)
    {
        this.codeList = codeList;
    }
}
