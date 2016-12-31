package pkuhit.iih.pub;

import javax.sql.DataSource;

import org.seasar.doma.jdbc.DomaAbstractConfig;
import org.seasar.doma.jdbc.dialect.Dialect;

public class MyDomaConfig extends DomaAbstractConfig
{
    DataSource dataSource;

    Dialect dialect;

    @Override
    public DataSource getDataSource()
    {
        return dataSource;
    }

    @Override
    public Dialect getDialect()
    {
        return dialect;
    }

    public void setDataSource(DataSource dataSource)
    {
        this.dataSource = dataSource;
    }

    public void setDialect(Dialect dialect)
    {
        this.dialect = dialect;
    }

}
