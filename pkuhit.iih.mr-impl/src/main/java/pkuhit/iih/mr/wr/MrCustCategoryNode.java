package pkuhit.iih.mr.wr;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;

import pkuhit.iih.mr.dao.auto.entity.Mr;
import pkuhit.iih.mr.dao.custom.CusMrTreeDao;
import pkuhit.iih.mr.md.dao.auto.entity.MdMrTpCcat;
import xap.sv.app.Application;
import xap.sv.dao.DaoFactory;
import xap.sv.model.BaseNode;
import xap.sv.model.Composite;

public class MrCustCategoryNode extends BaseNode<MrTreeData> {
	CusMrTreeDao cusMrTreeDao = null;
	
	public MrCustCategoryNode(MrTreeData data, Map<String, String> condition) {
		super(data, condition);
		data.setNodeType("1");
		
		DaoFactory df = Application.getInstance().getBundleContext().getServiceOfType(DaoFactory.class);
		this.cusMrTreeDao = df.getDao(CusMrTreeDao.class);
	}

	@Override
	public String getText() {
		return this.getData().getCustCategoryName();
	}

	@Override
	public void loadChildren() {
//		String orgCode = Session.get().getOrgCd();
		String custCategoryCode= this.getData().getCustCategoryCode();
		String encounterCode = this.getCondition().get("encounterCode");

		ArrayList<Composite<MrTreeData>> catChildren = 
				new ArrayList<Composite<MrTreeData>>();
		//加载分类节点
		List<MdMrTpCcat> catList = cusMrTreeDao.selectMrCustCategory(/*custCategoryCode*/);
		for (MdMrTpCcat item:catList) {
			//如果该自定义分类下面在该次就诊总没有病历文书，那么不抛弃该节点。
			String childCatCode = item.getMrTpCcatCd();
			List<Mr> mrList = cusMrTreeDao.selectMr(encounterCode, childCatCode);
			if (mrList == null || mrList.size() == 0) {
				continue;
			}
			
			MrTreeData treeData = new MrTreeData();
			BeanUtils.copyProperties(this.getData(), treeData);
			treeData.setCode(childCatCode);
			treeData.setName(item.getNm());
			treeData.setCustCategoryCode(childCatCode);
			treeData.setCustCategoryName(item.getNm());
			MrCustCategoryNode catNode = new MrCustCategoryNode(treeData, this.getCondition());
			
			//加载文书节点
			ArrayList<Composite<MrTreeData>> mrChildren = 
	                new ArrayList<Composite<MrTreeData>>();
	        for(Mr mrItem:mrList) {
	            MrTreeData mrTreeData = new MrTreeData();
	            BeanUtils.copyProperties(this.getData(), mrTreeData);
	            mrTreeData.setCode(mrItem.getMrPk());
	            mrTreeData.setName(mrItem.getNm());
	            MrRecordNode elementNode = new MrRecordNode(mrTreeData, this.getCondition());
	            mrChildren.add(elementNode);
	        }
			catNode.setChildren(mrChildren);
			catChildren.add(catNode);
		}
		this.setChildren(catChildren);
		
		
//		for(Composite<MrTreeData> item:children) {
//			item.loadChildren();
//		}
	}

}
