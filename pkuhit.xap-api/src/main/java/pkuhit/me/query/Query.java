package pkuhit.me.query;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.util.Assert;

public class Query
{
    String objectCd;

    List<Filter> filters;

    public Query(String objectCd)
    {
        this.objectCd = objectCd;
    }

    public String getObjectCd()
    {
        return objectCd;
    }

    void addFilter(Filter filter)
    {
        Assert.notNull(filter, "filter must not be null");
        filters.add(filter);
    }

    void addFilters(List<Filter> filters)
    {
        if (this.filters == null)
        {
            this.filters = new ArrayList<Filter>();
        }
        this.filters.addAll(filters);
    }

    public List<Filter> getFilters()
    {
        return Collections.unmodifiableList(filters);
    }

    public static class Filter
    {
        String property;

        Object value;

        Operation operation;

        public Filter(String property, Object value)
        {
            this(property, value, null);
        }

        public Filter(String property, Object value, Operation operation)
        {
            Assert.hasText(property, "property must not be empty");
            this.property = property;
            this.value = value;
            if (operation == null)
            {
                operation = Operation.AND;
            }
            this.operation = operation;
        }

        public String getProperty()
        {
            return property;
        }

        public void setProperty(String property)
        {
            this.property = property;
        }

        public Object getValue()
        {
            return value;
        }

        public void setValue(Object value)
        {
            this.value = value;
        }

        public Operation getOperation()
        {
            return operation;
        }

        public void setOperation(Operation operation)
        {
            this.operation = operation;
        }
    }

    protected enum Operation
    {
        AND, OR
    }
}
