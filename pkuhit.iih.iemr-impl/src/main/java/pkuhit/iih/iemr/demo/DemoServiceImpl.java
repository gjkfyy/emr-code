/**
 * <p>文件名:		DemoServiceImpl.java</p>
 * <p>版权:		CopyrightTag</p>
 * <p>公司:		CompanyTag</p>
 * @author		李德强(li_deqiang@founder.com, readwall@163.com)
 */

package pkuhit.iih.iemr.demo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * DemoServiceImpl
 * </p>
 * <p>
 * TODO
 * </p>
 * 
 * @author 李德强(li_deqiang@founder.com, readwall@163.com)
 * @version 0.0.0
 *          <table style="border:1px solid gray;">
 *          <tr>
 *          <th width="100px">版本号</th>
 *          <th width="100px">动作</th>
 *          <th width="100px">修改人</th>
 *          <th width="100px">修改时间</th>
 *          </tr>
 *          <!-- 以 Table 方式书写修改历史 -->
 *          <tr>
 *          <td>0.0.0</td>
 *          <td>创建类</td>
 *          <td>李德强</td>
 *          <td>2014年11月29日 下午2:03:52</td>
 *          </tr>
 *          <tr>
 *          <td>XXX</td>
 *          <td>XXX</td>
 *          <td>XXX</td>
 *          <td>XXX</td>
 *          </tr>
 *          </table>
 */
public class DemoServiceImpl  implements DemoService{

	/**
	 * 构造器
	 */
	public DemoServiceImpl() {
	}
	

	public List<DemoModel> getDemo(Map demo) {
		
		for(Object e : demo.keySet()) {
			System.out.println(demo.get(e));
		}

		List<DemoModel> list = new ArrayList<DemoModel>();
		for(int i = 0; i < 10; i ++) {
			DemoModel dm = new DemoModel();
			dm.setDate(new Date());
			dm.setIntv(i);
			dm.setStr("测试" + i);
			list.add(dm);
		}
		return list;
	}



	@Override
	public List<DemoModel> getDemoList(String id) {
		System.out.println(id);
		List<DemoModel> list = new ArrayList<DemoModel>();
		for(int i = 0; i < 1; i ++) {
			DemoModel dm = new DemoModel();
			dm.setDate(new Date());
			dm.setIntv(i);
			dm.setStr("测试" + i);
			list.add(dm);
		}
		return list;
	}

	@Override
	public void addDemo(DemoModel model) {
		System.out.println(model.getIntv());		
		System.out.println(model.getDate());		
		System.out.println(model.getStr());		
	}



	@Override
	public void updateDemo(DemoModel model) {
		System.out.println(model.getIntv());		
		System.out.println(model.getDate());		
		System.out.println(model.getStr());	
	}



	@Override
	public void removeDemo(String id) {
		System.out.println(id);
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
