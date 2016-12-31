
package ei.iih.db.cfg;

import java.util.Map;

import javax.sql.DataSource;

import org.seasar.doma.jdbc.DomaAbstractConfig;
import org.seasar.doma.jdbc.dialect.*;


public class DomaConfig extends DomaAbstractConfig {
	
	private Dialect dialect;
	
	private DataSource dataSource;
	
	private Map<String,String> dialectMap; //每个数据源对应的字典
	
	private Dialect sqlserverDialect = new MssqlDialect();
	
	private Dialect oracleDialect = new OracleDialect();
	
	private Dialect db2Dialect = new Db2Dialect();
	
	private Dialect h2Dialect = new H2Dialect();
	
	private Dialect hsqldbDialect = new HsqldbDialect() ;
	
	private Dialect mssql2008Dialect = new Mssql2008Dialect() ;
	
	private Dialect mysqlDialect = new MysqlDialect();
	
	private Dialect postgresDialect = new PostgresDialect();
	
	private Dialect sqliteDialect = new SqliteDialect();
	/**
	 * 构造器
	 */
	public DomaConfig() {
		// TODO Auto-generated constructor stub
	}
	
	
//	public void setDialect(Dialect dialect) {
//		this.dialect = dialect;
//	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	public void setDialectMap(Map<String,String> dialectMap) {
		this.dialectMap = dialectMap;
		
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see org.seasar.doma.jdbc.Config#getDataSource()
	 */
	@Override
	public DataSource getDataSource() {
		return this.dataSource;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.seasar.doma.jdbc.Config#getDialect()
	 */
	@Override
	public Dialect getDialect() {
		System.out.println("CustomerContextHolder.getCustomerType() is " + CustomerContextHolder.getCustomerType());
		String dialectName =  dialectMap.get("default"); //默认字典
		if(null == CustomerContextHolder.getCustomerType()){
			//dialectName = dialectMap.get("default");
		}else{
			dialectName = dialectMap.get(CustomerContextHolder.getCustomerType());
		}
		System.out.println("dialectName is " + dialectName);
/*		if(CustomerContextHolder.DATASOURCE_HIS.equals(CustomerContextHolder.getCustomerType())) {
			this.dialect = this.sqlserverDialect;
		}else if(CustomerContextHolder.DATASOURCE_CIS.equals(CustomerContextHolder.getCustomerType())) {
			this.dialect = this.sqlserverDialect;
		}else if(CustomerContextHolder.DATASOURCE_ASS_DI_MZ.equals(CustomerContextHolder.getCustomerType())) {
			this.dialect = this.sqlserverDialect;
		}else if(CustomerContextHolder.DATASOURCE_ASS_DI_ZY.equals(CustomerContextHolder.getCustomerType())) {
			this.dialect = this.sqlserverDialect;
		}else if(CustomerContextHolder.DATASOURCE_ASS_OR_MZ.equals(CustomerContextHolder.getCustomerType())) {
			this.dialect = this.sqlserverDialect;
		}else if(CustomerContextHolder.DATASOURCE_ASS_OR_ZY.equals(CustomerContextHolder.getCustomerType())) {
			this.dialect = this.sqlserverDialect;
		}else if(CustomerContextHolder.DATASOURCE_ASS_NU_MZ.equals(CustomerContextHolder.getCustomerType())) {
			this.dialect = this.sqlserverDialect;
		}else if(CustomerContextHolder.DATASOURCE_ASS_NU_ZY.equals(CustomerContextHolder.getCustomerType())) {
			this.dialect = this.sqlserverDialect;
		}else {
			this.dialect = this.oracleDialect;
		}*/
		this.dialect = null ;
		if(dialectName.equalsIgnoreCase("Sqlserver")){
			this.dialect  = this.sqlserverDialect; 
		}else if(dialectName.equalsIgnoreCase("oracle")){
			this.dialect = this.oracleDialect;
		}else if(dialectName.equalsIgnoreCase("Db2")){
			this.dialect = this.db2Dialect;
		}else if(dialectName.equalsIgnoreCase("h2")){
			this.dialect  = this.h2Dialect; 
		}else if(dialectName.equalsIgnoreCase("hsqldb")){
			this.dialect = this.hsqldbDialect;
		}else if(dialectName.equalsIgnoreCase("mssql2008")){
			this.dialect = this.mssql2008Dialect;
		}else if(dialectName.equalsIgnoreCase("mysql")){
			this.dialect  = this.mysqlDialect; 
		}else if(dialectName.equalsIgnoreCase("postgres")){
			this.dialect = this.postgresDialect;
		}else if(dialectName.equalsIgnoreCase("sqlite")){
			this.dialect = this.sqliteDialect;
		}else{
			System.out.println("不支持的数据库");
		}
		
		return this.dialect;
	}

	/**
	 * FIXME
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
