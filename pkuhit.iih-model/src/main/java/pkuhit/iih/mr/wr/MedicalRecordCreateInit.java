
package pkuhit.iih.mr.wr;

import java.util.List;

import pkuhit.iih.mr.md.MrType;
import pkuhit.iih.mr.md.MrTypeCustomCategory;
import pkuhit.org.Employee;

/**
 * 病历文书新建画面初始化数据model <p>MedicalRecordCreateInit</p> <p>TODO</p>
 * 
 * @author 李春学(li_chunxue@founder.com)
 * @version 0.0.0 <table style="border:1px solid gray;"> <tr> <th
 *          width="100px">版本号</th><th width="100px">动作</th><th
 *          width="100px">修改人</th><th width="100px">修改时间</th> </tr> <!-- 以 Table
 *          方式书写修改历史 --> <tr>
 *          <td>0.0.0</td><td>创建类</td><td>李春学</td><td>2014年12月13日 下午2:14:22</td>
 *          </tr> <tr> <td>XXX</td><td>XXX</td><td>XXX</td><td>XXX</td> </tr>
 *          </table>
 */
public class MedicalRecordCreateInit {

	public MedicalRecordCreateInit() {

		super();

	}
	private List<MrTypeCustomCategory> mrTypeCustomCategorys;

	private MrType[] mrTypes;

	private List<Employee> employees;
	
	private String searchTemplateConfig;
	
	private boolean deselectedEnabled;

	
	public String getSearchTemplateConfig() {
		return searchTemplateConfig;
	}


	public void setSearchTemplateConfig(String searchTemplateConfig) {
		this.searchTemplateConfig = searchTemplateConfig;
	}


	public List<MrTypeCustomCategory> getMrTypeCustomCategorys() {
	
		return mrTypeCustomCategorys;
	}

	
	public void setMrTypeCustomCategorys(List<MrTypeCustomCategory> mrTypeCustomCategorys) {
	
		this.mrTypeCustomCategorys = mrTypeCustomCategorys;
	}
	
	public List<Employee> getEmployees() {
	
		return employees;
	}

	
	public void setEmployees(List<Employee> employees) {
	
		this.employees = employees;
	}


	
	public MrType[] getMrTypes() {
	
		return mrTypes;
	}


	
	public void setMrTypes(MrType[] mrTypes) {
	
		this.mrTypes = mrTypes;
	}


	public boolean isDeselectedEnabled() {
		return deselectedEnabled;
	}


	public void setDeselectedEnabled(boolean deselectedEnabled) {
		this.deselectedEnabled = deselectedEnabled;
	}
}
