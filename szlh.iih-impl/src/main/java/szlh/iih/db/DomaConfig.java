package szlh.iih.db;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.seasar.doma.jdbc.Config;
import org.seasar.doma.jdbc.DomaAbstractConfig;
import org.seasar.doma.jdbc.dialect.Dialect;
import org.seasar.doma.jdbc.dialect.MssqlDialect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.TransactionAwareDataSourceProxy;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;



@Configuration
@EnableTransactionManagement
@PropertySource("classpath:/sqlserver.properties")
public class DomaConfig
{
	final static Logger logger = LoggerFactory.getLogger(DomaConfig.class);
	
	@Autowired
	private Environment env;
	
    @Bean
    public DataSource dataSource()
    {
        org.apache.commons.dbcp.BasicDataSource db = new BasicDataSource();
		db.setUrl(env.getProperty("jdbc.protocol")+"://"+env.getProperty("jdbc.ip")+":"+env.getProperty("jdbc.port")+"; DatabaseName="+env.getProperty("jdbc.databaseName"));
		db.setUsername(env.getProperty("jdbc.userName"));
		db.setPassword(env.getProperty("jdbc.userPwd"));
		db.setDriverClassName(env.getProperty("jdbc.driverName"));
		logger.error("db.getUrl():"+db.getUrl());
		logger.error("db.getDriverClassName():"+db.getDriverClassName());
		logger.error("db.getUsername():"+db.getUsername());
		logger.error("db.getPassword():"+db.getPassword());
        return db;
    }

    @Bean
    public PlatformTransactionManager transactionManager()
    {
        return new DataSourceTransactionManager(dataSource());
    }

    @Bean
    public Dialect dialect()
    {
        return new MssqlDialect();
    }

    @Bean(name = "mainConfig")
    public Config domaConfig()
    {
        return new MyDomaConfig();
    }

    public class MyDomaConfig extends DomaAbstractConfig
    {
        @Override
        public Dialect getDialect()
        {
            return dialect();
        }

        @Override
        public DataSource getDataSource()
        {
            return new TransactionAwareDataSourceProxy(dataSource());
        }
    }
}
