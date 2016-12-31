package szlh.iih.db;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.seasar.doma.jdbc.Config;
import org.seasar.doma.jdbc.DomaAbstractConfig;
import org.seasar.doma.jdbc.dialect.Db2Dialect;
import org.seasar.doma.jdbc.dialect.Dialect;
import org.seasar.doma.jdbc.dialect.H2Dialect;
import org.seasar.doma.jdbc.dialect.HsqldbDialect;
import org.seasar.doma.jdbc.dialect.Mssql2008Dialect;
import org.seasar.doma.jdbc.dialect.MssqlDialect;
import org.seasar.doma.jdbc.dialect.MysqlDialect;
import org.seasar.doma.jdbc.dialect.OracleDialect;
import org.seasar.doma.jdbc.dialect.PostgresDialect;
import org.seasar.doma.jdbc.dialect.SqliteDialect;
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
	
   /* @Bean
    public DataSource dataSource()
    {
        org.apache.commons.dbcp.BasicDataSource db = new BasicDataSource();
        if(null == env.getProperty("jdbc.instanceName")){
        	db.setUrl(env.getProperty("jdbc.protocol")+"://"+env.getProperty("jdbc.ip")+":"+env.getProperty("jdbc.port")+"; DatabaseName="+env.getProperty("jdbc.databaseName"));
        }else{
        	db.setUrl(env.getProperty("jdbc.protocol")+"://"+env.getProperty("jdbc.ip")+";instanceName="+env.getProperty("jdbc.instanceName")+"; DatabaseName="+env.getProperty("jdbc.databaseName"));
        }
		
		db.setUsername(env.getProperty("jdbc.userName"));
		db.setPassword(env.getProperty("jdbc.userPwd"));
		db.setDriverClassName(env.getProperty("jdbc.driverName"));
		logger.error("db.getUrl():"+db.getUrl());
		logger.error("db.getDriverClassName():"+db.getDriverClassName());
		logger.error("db.getUsername():"+db.getUsername());
		logger.error("db.getPassword():"+db.getPassword());
        return db;
    }*/
    
    @Bean
	public DataSource dataSource() {
		org.apache.commons.dbcp.BasicDataSource db = new BasicDataSource();
		db.setUrl(env.getProperty("db.url"));
		db.setUsername(env.getProperty("db.username"));
		db.setPassword(env.getProperty("db.password"));
		db.setDriverClassName(env.getProperty("db.driverclassname"));
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
    	if(env.containsProperty("db.dialectname")){
    		String dialectName =  env.getProperty("db.dialectname") ;
    		Dialect dialect = null ;
    		if(dialectName.equalsIgnoreCase("Sqlserver")){
    			dialect  = new MssqlDialect(); 
    		}else if(dialectName.equalsIgnoreCase("oracle")){
    			dialect = new OracleDialect();
    		}else if(dialectName.equalsIgnoreCase("Db2")){
    			dialect = new Db2Dialect();
    		}else if(dialectName.equalsIgnoreCase("h2")){
    			dialect  =  new H2Dialect();
    		}else if(dialectName.equalsIgnoreCase("hsqldb")){
    			dialect =  new HsqldbDialect() ;
    		}else if(dialectName.equalsIgnoreCase("mssql2008")){
    			dialect =  new Mssql2008Dialect() ;
    		}else if(dialectName.equalsIgnoreCase("mysql")){
    			dialect  = new MysqlDialect();
    		}else if(dialectName.equalsIgnoreCase("postgres")){
    			dialect = new PostgresDialect();
    		}else if(dialectName.equalsIgnoreCase("sqlite")){
    			dialect =  new SqliteDialect();
    		}else{
    			System.out.println("不支持的数据库");
    		}
    		return dialect ;
    	}else{
    		 return new MssqlDialect();
    	}
    
       
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
