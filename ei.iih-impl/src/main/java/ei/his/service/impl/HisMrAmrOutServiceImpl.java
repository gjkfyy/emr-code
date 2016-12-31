/**
 * 
 */
package ei.his.service.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.shiro.dao.DataAccessException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.CallableStatementCallback;
import org.springframework.jdbc.core.CallableStatementCreator;
import org.springframework.jdbc.core.JdbcTemplate;

import ei.his.service.HisMrAmrOutService;

/**
 * @author yao_lijie
 * 从iemr存储过程中查找患者
 */
public class HisMrAmrOutServiceImpl implements HisMrAmrOutService{

	protected static final int String = 0;

	public static Logger log = LoggerFactory
			.getLogger(HisMrAmrOutServiceImpl.class);

	@Autowired
	JdbcTemplate jdbcTemplate;
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ei.His.service.HisSyncEnAdtService#SychronizeEncounterAdtFromHis(java
	 * .util.Map)
	 */
	public List<String> getPatientOut(final String amrNo) {   
		  List resultList = (List) jdbcTemplate.execute(   
		     new CallableStatementCreator() {   
		        public CallableStatement createCallableStatement(Connection con) throws SQLException {   
		           String storedProc = "{call pkg_test.get_r(?,?)}";// 调用的sql   
		           CallableStatement cs = con.prepareCall(storedProc);   
		           cs.setString(1, amrNo);// 设置输入参数的值   
		           cs.registerOutParameter(2,-10);// 注册输出参数的类型   OracleTypes.CURSOR的值为-10
		           return cs;   
		        }   
		     }, new CallableStatementCallback() {   
		        public Object doInCallableStatement(CallableStatement cs) throws SQLException,DataAccessException {   
		           List resultsMap = new ArrayList();   
		           cs.execute();   
		           ResultSet rs = (ResultSet) cs.getObject(2);// 获取游标一行的值   
		           while (rs.next()) {// 转换每行的返回值到Map中   
		              Map rowMap = new HashMap();   
		              rowMap.put("en_pk", rs.getString("en_pk"));   
//		              rowMap.put("name", rs.getString("name"));   
		              resultsMap.add(rowMap);   
		           }   
		           rs.close();   
		           return resultsMap;   
		        }   
		  });   
		  List<String> enpkList = new ArrayList<String>();
		  for (int i = 0; i < resultList.size(); i++) {   
		     Map rowMap = (Map) resultList.get(i);   
		     String en_pk = rowMap.get("en_pk").toString();   
//		     String name = rowMap.get("name").toString();   
		     System.out.println("en_pk=" + en_pk);  
		     enpkList.add(en_pk);
		  }   
		  return enpkList;
		}   

}
