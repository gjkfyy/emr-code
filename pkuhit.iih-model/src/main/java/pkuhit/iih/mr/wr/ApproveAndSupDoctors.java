
package pkuhit.iih.mr.wr;

import java.util.List;

import pkuhit.org.Employee;

/**
 * 
 * <p>ApproveDoctors</p>
 * <p>病历文书属性修改画面的二级审签医师，三级审签医师，上级查房医师combox数据</p>
 *
 * @author		李春学(li_chunxue@founder.com)
 * @version		0.0.0
 * <table style="border:1px solid gray;">
 * <tr>
 * <th width="100px">版本号</th><th width="100px">动作</th><th width="100px">修改人</th><th width="100px">修改时间</th>
 * </tr>
 * <!-- 以 Table 方式书写修改历史 -->
 * <tr>
 * <td>0.0.0</td><td>创建类</td><td>李春学</td><td>2015年5月4日 上午11:08:48</td>
 * </tr>
 * <tr>
 * <td>XXX</td><td>XXX</td><td>XXX</td><td>XXX</td>
 * </tr>
 * </table>
 */
public class ApproveAndSupDoctors {

	public ApproveAndSupDoctors() {

		super();

	}

	private List<Employee> supDoctors;
	
	private List<Employee> twoSignLevelDoctors;
	
	private List<Employee> threeSignLevelDoctors;

	
	public List<Employee> getSupDoctors() {
	
		return supDoctors;
	}

	
	public void setSupDoctors(List<Employee> supDoctors) {
	
		this.supDoctors = supDoctors;
	}

	
	public List<Employee> getTwoSignLevelDoctors() {
	
		return twoSignLevelDoctors;
	}

	
	public void setTwoSignLevelDoctors(List<Employee> twoSignLevelDoctors) {
	
		this.twoSignLevelDoctors = twoSignLevelDoctors;
	}

	
	public List<Employee> getThreeSignLevelDoctors() {
	
		return threeSignLevelDoctors;
	}

	
	public void setThreeSignLevelDoctors(List<Employee> threeSignLevelDoctors) {
	
		this.threeSignLevelDoctors = threeSignLevelDoctors;
	}

}
