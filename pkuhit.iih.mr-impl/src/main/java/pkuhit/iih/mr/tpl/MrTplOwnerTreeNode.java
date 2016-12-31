package pkuhit.iih.mr.tpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;

import pkuhit.iih.mr.dao.custom.CusMrTreeDao;
import pkuhit.iih.mr.md.dao.auto.entity.MdMrTpCcat;
import xap.sv.app.Application;
import xap.sv.dao.DaoFactory;
import xap.sv.model.BaseNode;
import xap.sv.model.Composite;

public class MrTplOwnerTreeNode extends BaseNode<TemplateNavigatorTreeData> {
	CusMrTreeDao cusMrTreeDao = null;
	
	/**
	 * @param data
	 * @param condition
	 */
	public MrTplOwnerTreeNode(TemplateNavigatorTreeData data,
			Map<String, String> condition) {
		super(data, condition);
		
		data.setNodeType(TemplateNavigatorTreeNodeType.OWNER);
		
		DaoFactory df = Application.getInstance().getBundleContext().getServiceOfType(DaoFactory.class);
		this.cusMrTreeDao = df.getDao(CusMrTreeDao.class);
	}

	/* (non-Javadoc)
	 * @see pkuhit.iih.mr.tpl.GroupElementBaseNodeWrap#loadChildren()
	 */
	@Override
	public void loadChildren() {
		TemplateNavigatorTreeData data = this.getData();
		Map<String, String> condition = this.getCondition();
		
		String orgCd = data.getHisOrgCode();
		String ownTpCd = data.getOwnerTypeCode();
		String ownCd = data.getOwnerCode();
		String typeCode = condition.get("typeCode");
		String keyword = condition.get("keyWord");

		ArrayList<Composite<TemplateNavigatorTreeData>> children = 
				new ArrayList<Composite<TemplateNavigatorTreeData>>();
		//加载元素分类节点
		//List<MdMrTpCcat> catList = cusMrTreeDao.selectTemplateCategory(orgCd, ownTpCd, ownCd, null, keyword);
		List<MdMrTpCcat> catList = cusMrTreeDao.selectTemplateCategory();
		for (MdMrTpCcat item:catList) {
			TemplateNavigatorTreeData treeData = new TemplateNavigatorTreeData();
			BeanUtils.copyProperties(this.getData(), treeData);
			treeData.setTemplateCategoryCode(item.getMrTpCcatCd());
			treeData.setTemplateCategoryName(item.getNm());
			MrTplCategoryTreeNode catNode = new MrTplCategoryTreeNode(treeData, this.getCondition());
			children.add(catNode);
		}
		
		this.setChildren(children);
		
		for(Composite<TemplateNavigatorTreeData> item:children) {
			item.loadChildren();
		}
	}
	
	/* (non-Javadoc)
	 * @see xap.sv.model.Composite#getText()
	 */
	@Override
	public String getText() {
		return this.getData().getOwnerTypeName();
	}	

}
