package pkuhit.xap.stat;

import java.util.List;


public class StatisticsBaseDAO {
	/**
	 * 
	 * @description 根据sql查询，并返回list，通用方法。
	 * @author jiaoxiantong
	 * @version v1.0
	 * @date Mar 26, 2013 1:43:42 PM
	 * @param sql
	 * @return
	 * @throws Exception
	 */
	public List<Object> getSumObjectBySQL(String sql) throws Exception{
//		Query query = this.getSession().createSQLQuery(sql);
//		List<Object> list = query.list();
		List<Object> list = null;
		return list;
	}
}
