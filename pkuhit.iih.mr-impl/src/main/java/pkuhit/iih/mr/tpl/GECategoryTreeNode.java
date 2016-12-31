/**
 * 
 */
package pkuhit.iih.mr.tpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.seasar.doma.jdbc.SelectOptions;
import org.springframework.beans.BeanUtils;

import pkuhit.iih.mr.dao.auto.entity.MrGe;
import pkuhit.iih.mr.md.dao.auto.entity.MdMrGeCcat;
import pkuhit.iih.mr.tpl.dao.CusGroupElementDao;
import xap.sv.app.Application;
import xap.sv.dao.DaoFactory;
import xap.sv.model.BaseNode;
import xap.sv.model.Composite;

/**
 * @author wu.junhui
 *
 */
public class GECategoryTreeNode extends BaseNode<GETreeData> {
	CusGroupElementDao cusGroupElementDao = null;
	/**
	 * @param data
	 * @param condition
	 */
	public GECategoryTreeNode(GETreeData data,
			Map<String, String> condition) {
		super(data, condition);
		// TODO Auto-generated constructor stub
		
		data.setNodeType("3");
		
		DaoFactory df = Application.getInstance().getBundleContext().getServiceOfType(DaoFactory.class);
		this.cusGroupElementDao = df.getDao(CusGroupElementDao.class);
	}

	/* (non-Javadoc)
	 * @see pkuhit.iih.mr.tpl.GroupElementBaseNodeWrap#loadChildren()
	 */
	@Override
	public void loadChildren() {
		GETreeData data = this.getData();
		Map<String, String> condition = this.getCondition();
		
		String orgCd = data.getHisOrgCode();
		String ownTpCd = data.getOwnerTypeCode();
		String ownCd = data.getOwnerCode();
		String categoryCd = this.getData().getCustomCategoryCode();
		String typeCode = condition.get("typeCode");
		String keyWord = condition.get("keyWord");

		ArrayList<Composite<GETreeData>> children = 
				new ArrayList<Composite<GETreeData>>();
		//加载元素分类节点
		List<MdMrGeCcat> catList = cusGroupElementDao.selectGroupElementCategory(orgCd, ownTpCd, ownCd, typeCode, categoryCd, keyWord);
		for (MdMrGeCcat item:catList) {
			GETreeData treeData = new GETreeData();
			BeanUtils.copyProperties(this.getData(), treeData);
			treeData.setCustomCategoryCode(item.getMrGeCcatCd());
			treeData.setCustomCategoryName(item.getNm());
			GECategoryTreeNode catNode = new GECategoryTreeNode(treeData, this.getCondition());
			children.add(catNode);
		}
		String pageNum = "1";
		String pageSize = "1000"; 
		SelectOptions options = SelectOptions.get().offset((Integer.valueOf(pageNum)-1)*Integer.valueOf(pageSize)).limit(Integer.valueOf(pageSize)).count();

		//加载元素节点
		List<MrGe> geList = cusGroupElementDao.selectGroupElement(orgCd, ownTpCd, ownCd, typeCode, categoryCd, null, keyWord,options);
		for(MrGe item:geList) {
			GETreeData treeData = new GETreeData();
			BeanUtils.copyProperties(this.getData(), treeData);
			treeData.setCode(item.getMrGeCd());
			treeData.setName(item.getNm());
			treeData.setFilePk(item.getFilePk());
			GELeafNode elementNode = new GELeafNode(treeData, this.getCondition());
			children.add(elementNode);
		}
		
		
		//加载子节点
		this.setChildren(children);
		for(Composite<GETreeData> item:children) {
			item.loadChildren();
		}
	}

	/* (non-Javadoc)
	 * @see xap.sv.model.Composite#getText()
	 */
	@Override
	public String getText() {
		return this.getData().getCustomCategoryName();
	}

}
