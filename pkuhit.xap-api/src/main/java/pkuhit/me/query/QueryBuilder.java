package pkuhit.me.query;

import java.util.ArrayList;
import java.util.List;

import pkuhit.me.query.Query.Filter;

public class QueryBuilder
{
    String objectCd;

    List<Filter> filters = new ArrayList<Filter>();

    public QueryBuilder(String objectCd)
    {
        this.objectCd = objectCd;
    }

    public static QueryBuilder newQuery(String objectCd)
    {
        return new QueryBuilder(objectCd);
    }

    public QueryBuilder and(String property, Object value)
    {
        Filter filter = new Filter(property, value);
        filters.add(filter);
        return this;
    }

    public Query build()
    {
        Query query = new Query(objectCd);
        query.addFilters(filters);
        return query;
    }
}
