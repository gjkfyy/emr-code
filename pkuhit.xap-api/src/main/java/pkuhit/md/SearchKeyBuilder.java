package pkuhit.md;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.shiro.util.StringUtils;
import org.springframework.util.Assert;

public class SearchKeyBuilder
{
    String[] dictIdList;

    Map<String, Object> others;

    String name;

    List<String> codeList;

    String pinyin;

    String wubi;

    String keyword;

    public static SearchKeyBuilder newSearchKey()
    {
        return new SearchKeyBuilder();
    }

    public SearchKeyBuilder withDictIdList(String[] dictIdList)
    {
        this.dictIdList = dictIdList;
        return this;
    }

    public SearchKeyBuilder withDictId(String dictId)
    {
        dictIdList = StringUtils.tokenizeToStringArray(dictId, ",");
        return this;
    }

    public SearchKeyBuilder withProperty(String pName, Object pValue)
    {
        others.put(pName, pValue);
        return this;
    }

    public SearchKeyBuilder withName(String name)
    {
        this.name = name;
        return this;
    }

    public SearchKeyBuilder addCode(String code)
    {
        if (StringUtils.hasText(code))
        {
            if (codeList == null)
                codeList = new ArrayList<String>();
            codeList.add(code);
        }
        return this;
    }

    public SearchKeyBuilder withPinyin(String pinyin)
    {
        this.pinyin = pinyin;
        return this;
    }

    public SearchKeyBuilder withWubi(String wubi)
    {
        this.wubi = wubi;
        return this;
    }

    public DictionarySearchKey build()
    {
        Assert.isTrue(dictIdList.length > 0, "dictId must be set");
        DictionarySearchKey key = new DictionarySearchKey();
        if (dictIdList.length > 1)
        {
            assertIsNull("properties", others);
            assertIsNull("name", name);
            Assert.isTrue(codeList.size() <= 0);
            assertIsNull("pinyin", pinyin);
            assertIsNull("wubi", wubi);
            key.setId(StringUtils.toDelimitedString(dictIdList, ","));
        }
        else
        {
            key.setCodeList(StringUtils.toDelimitedString(codeList, ","));
            key.setId(dictIdList[0]);
            key.setName(name);
            key.setPinyin(pinyin);
            key.setWubi(wubi);
        }
        return key;
    }

    void assertIsNull(String name, Object value)
    {
        Assert.isNull(value, name
            + " must be null when dictId is delimited by comma");
    }
}
