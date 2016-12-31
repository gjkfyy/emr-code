package pkuhit.md;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Dictionary
{
    String id;

    List<Item> data = new ArrayList<Item>();

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public void addItem(Item item)
    {
        data.add(item);
    }

    public List<Item> getData()
    {
        return data;
    }

    @SuppressWarnings("serial")
    public static class Item extends HashMap<String, Object>
    {
        <T> T getValue(Class<T> type)
        {
            throw new UnsupportedOperationException();
        }
    }

    // TODO 设置国际化值或字典数据，自动查找国家化字符串
    @SuppressWarnings("serial")
    // public static class RecordItem extends HashMap<String, SimpleItem>
    public static class RecordItem extends Item
    {
        @Override
        public <T> T getValue(Class<T> type)
        {
            if (Map.class == type)
                return type.cast(this);
            return null;
        }
    }

    @SuppressWarnings("serial")
    public static class SimpleItem extends Item
    {
        final static String VALUE_KEY = "value";

        final static String TEXT_KEY = "text";

        public SimpleItem()
        {
        }

        public SimpleItem(String value, String text)
        {
            this.setValue(value);
            this.setText(text);
        }

        public String getValue()
        {
            return (String) this.get(VALUE_KEY);
        }

        public void setValue(String value)
        {
            this.put(VALUE_KEY, value);
        }

        public String getText()
        {
            return (String) this.get(TEXT_KEY);
        }

        public void setText(String text)
        {
            this.put(TEXT_KEY, text);
        }

        @Override
        public <T> T getValue(Class<T> type)
        {
            if (String.class == type)
                return type.cast(this.getValue());
            return null;
        }
    }
}
