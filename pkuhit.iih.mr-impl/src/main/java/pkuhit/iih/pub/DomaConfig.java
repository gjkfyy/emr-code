package pkuhit.iih.pub;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.seasar.doma.jdbc.Config;
import org.seasar.doma.jdbc.DomaAbstractConfig;
import org.seasar.doma.jdbc.dialect.Dialect;
import org.seasar.doma.jdbc.dialect.OracleDialect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.TransactionAwareDataSourceProxy;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import xap.sv.dao.config.DaoConfigProxy;

@Configuration
@EnableTransactionManagement
//@PropertySource("classpath:/db.cfg.properties")
public class DomaConfig {

//	private DataSource dataSource;
//	
//	@Autowired
//	private DaoConfigProxy daoConfigProxy;
//	@Bean
//	public DataSource dataSource() {
//		// org.apache.commons.dbcp.BasicDataSource db = new BasicDataSource();
//		// db.setUrl("jdbc:oracle:thin:@172.18.65.158:1521:orcl");
//		// db.setUsername("iih_szlh");
//		// db.setPassword("iih_SZLH");
//		// db.setDriverClassName("oracle.jdbc.driver.OracleDriver");
//		// return db;
//		return this.daoConfigProxy.getDataSource();
//	}
//
////	@Autowired
//	public void dataSource(DataSource dataSource) {
//		this.dataSource = this.daoConfigProxy.getDataSource();
//	}
//
//	@Bean
//	public PlatformTransactionManager transactionManager() {
//		return new DataSourceTransactionManager(dataSource());
//	}
//
//	@Bean
//	public Dialect dialect() {
//		return new OracleDialect();
//	}
//
//	@Bean(name = "mainConfig")
//	public Config domaConfig() {
//		return new MyDomaConfig();
//	}
//
//	public class MyDomaConfig extends DomaAbstractConfig {
//		@Override
//		public Dialect getDialect() {
//			return dialect();
//		}
//
//		@Override
//		@Autowired
//		public DataSource getDataSource() {
//			return new TransactionAwareDataSourceProxy(dataSource());
//		}
//	}
}
