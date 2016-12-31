package ei.iih.db.cfg;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.seasar.doma.jdbc.Config;
import org.seasar.doma.jdbc.DomaAbstractConfig;
import org.seasar.doma.jdbc.dialect.Dialect;
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
//@ComponentScan(basePackages = "tutorial")
@EnableTransactionManagement
@PropertySource("classpath:/cfg.properties")
public class DomaBeanConfig {

	@Autowired
	private Environment env;
	

	@Autowired
//	@Qualifier("dialect")
	private Dialect dialect;

	@Bean
	public DataSource dataSource() {
		org.apache.commons.dbcp.BasicDataSource db = new BasicDataSource();
		db.setUrl(env.getProperty("db.url"));
		db.setUsername(env.getProperty("db.username"));
		db.setPassword(env.getProperty("db.userpwd"));
		db.setDriverClassName(env.getProperty("db.driverclassname"));
		return db;
	}

	@Bean
	public PlatformTransactionManager transactionManager() {
		return new DataSourceTransactionManager(dataSource());
	}

	@Bean
	public Dialect dialect() {
		return dialect;
	}

	@Bean
	public Config domaConfig() {
		return new DomaAbstractConfig() {
			@Override
			public Dialect getDialect() {
				return dialect();
			}

			@Override
			public DataSource getDataSource() {
				return new TransactionAwareDataSourceProxy(dataSource());
			}
		};
	}
}