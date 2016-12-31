package pkuhit.iih.mr.tpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.seasar.doma.jdbc.SelectOptions;
import org.springframework.beans.BeanUtils;

import pkuhit.iih.mr.dao.auto.entity.MrGe;
import pkuhit.iih.mr.md.dao.auto.entity.MdMrGeCcat;
import pkuhit.iih.mr.tpl.dao.CusGroupElementDao;
import xap.sv.app.Application;
import xap.sv.dao.DaoFactory;
import xap.sv.model.BaseNode;
import xap.sv.model.Composite;

public class MrTplCategoryTreeNode  extends BaseNode<TemplateNavigatorTreeData>  {
	CusGroupElementDao cusGroupElementDao = null;
	/**
	 * @param data
	 * @param condition
	 */
	public MrTplCategoryTreeNode(TemplateNavigatorTreeData data,
			Map<String, String> condition) {
		super(data, condition);
		// TODO Auto-generated constructor stub
		
		data.setNodeType(TemplateNavigatorTreeNodeType.MRCATEGORY);
		
		DaoFactory df = Application.getInstance().getBundleContext().getServiceOfType(DaoFactory.class);
		this.cusGroupElementDao = df.getDao(CusGroupElementDao.class);
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
		String categoryCd = this.getData().getTemplateCategoryCode();
		String typeCode = condition.get("typeCode");
		String keyword = condition.get("keyWord");

		ArrayList<Composite<TemplateNavigatorTreeData>> children = 
				new ArrayList<Composite<TemplateNavigatorTreeData>>();
		//加载元素分类节点
		List<MdMrGeCcat> catList = cusGroupElementDao.selectGroupElementCategory(orgCd, ownTpCd, ownCd, typeCode, categoryCd, keyword);
		for (MdMrGeCcat item:catList) {
			TemplateNavigatorTreeData treeData = new TemplateNavigatorTreeData();
			BeanUtils.copyProperties(this.getData(), treeData);
			treeData.setTemplateCategoryCode(item.getMrGeCcatCd());
			treeData.setTemplateCategoryName(item.getNm());
			MrTplCategoryTreeNode catNode = new MrTplCategoryTreeNode(treeData, this.getCondition());
			children.add(catNode);
		}
		String pageNum = null; 
		String pageSize = null; 
		if(null == pageNum || !StringUtils.isNumeric(pageNum) || null == pageSize || !StringUtils.isNumeric(pageSize) ) 
		{ 
		pageNum= "1"; 
		pageSize = "1000"; 
		} 
		SelectOptions options = SelectOptions.get().offset((Integer.valueOf(pageNum)-1)*Integer.valueOf(pageSize)).limit(Integer.valueOf(pageSize)).count();
		//加载元素节点
		List<MrGe> geList = cusGroupElementDao.selectGroupElement(orgCd, ownTpCd, ownCd, typeCode, categoryCd, null, keyword,options);
		for(MrGe item:geList) {
			TemplateNavigatorTreeData treeData = new TemplateNavigatorTreeData();
			BeanUtils.copyProperties(this.getData(), treeData);
			treeData.setId(item.getMrGeCd());
			treeData.setText(item.getNm());
			MrTplTypeTreeNode elementNode = new MrTplTypeTreeNode(treeData, this.getCondition());
			children.add(elementNode);
		}
		
		
		//加载子节点
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
		return this.getData().getTemplateCategoryName();
	}

}
