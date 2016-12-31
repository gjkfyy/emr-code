/**
 * 
 */
package pkuhit.iih.mr.tpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import pkuhit.iih.mr.md.dao.auto.entity.MdMrGeCcat;
import pkuhit.iih.mr.tpl.dao.CusGroupElementDao;
import pkuhit.xap.ac.Session;
import xap.sv.app.Application;
import xap.sv.dao.DaoFactory;
import xap.sv.model.BaseNode;
import xap.sv.model.Composite;

/**
 * @author wu.junhui
 *
 */
public class GroupElementCategoryNode extends BaseNode<GroupElementCategory> {
	CusGroupElementDao cusGroupElementDao = null;
	/**
	 * @param data
	 * @param condition
	 */
	public GroupElementCategoryNode(GroupElementCategory data,
			Map<String, String> condition) {
		super(data, condition);
		DaoFactory df = Application.getInstance().getBundleContext().getServiceOfType(DaoFactory.class);
		this.cusGroupElementDao = df.getDao(CusGroupElementDao.class);
	}

	/* (non-Javadoc)
	 * @see pkuhit.iih.mr.tpl.GroupElementBaseNodeWrap#loadChildren()
	 */
	@Override
	public void loadChildren() {
		GroupElementCategory data = this.getData();
		Map<String, String> condition = this.getCondition();
		String code = data.getCode();
		String orgCode = Session.get().getOrgCd();
		String keyword = condition.get("keyWord");

		ArrayList<Composite<GroupElementCategory>> children = 
				new ArrayList<Composite<GroupElementCategory>>();
		//加载元素分类节点
		List<MdMrGeCcat> catList = cusGroupElementDao.selectCategory(orgCode, code, keyword);
		for (MdMrGeCcat item:catList) {
			GroupElementCategory treeData = new GroupElementCategory();
			treeData.setCode(item.getMrGeCcatCd());
			treeData.setName(item.getNm());
			
			GroupElementCategoryNode catNode = new GroupElementCategoryNode(treeData, this.getCondition());
			children.add(catNode);
		}
		
		
		//加载子节点
		this.setChildren(children);
		for(Composite<GroupElementCategory> item:children) {
			item.loadChildren();
		}
	}

	/* (non-Javadoc)
	 * @see xap.sv.model.Composite#getText()
	 */
	@Override
	public String getText() {
		return this.getData().getName();
	}
}
