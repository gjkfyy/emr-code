package pkuhit.iih.mr.tpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.BeanUtils;

import pkuhit.md.OwnerType;
import pkuhit.org.Organization;
import pkuhit.org.OrganizationService;
import pkuhit.org.md.OrgType;
import pkuhit.xap.ac.Session;
import xap.sv.annotation.Reference;
import xap.sv.model.ArrayResult;
import xap.sv.model.BaseNode;
import xap.sv.model.Composite;
import xap.util.UUIDGenerator;

public class MrTplHispitalTreeNode extends BaseNode<TemplateNavigatorTreeData>{


	@Reference
	OrganizationService organizationService ; //组织机构部门服务接口
	
	public MrTplHispitalTreeNode(TemplateNavigatorTreeData data,
			Map<String, String> condition) {
		super(data, condition);
		
		data.setNodeType(TemplateNavigatorTreeNodeType.ORG);
	}

	@Override
	public void loadChildren() {
		ArrayList<Composite<TemplateNavigatorTreeData>> children = 
				new ArrayList<Composite<TemplateNavigatorTreeData>>();
		
		TemplateNavigatorTreeData treeData;
		MrTplOwnerTreeNode ownerNode;
		Session session = this.getSession();
		// 个人节点
		treeData = new TemplateNavigatorTreeData();
		BeanUtils.copyProperties(this.getData(), treeData);
		treeData.setOwnerTypeCode(OwnerType.PERSONAL);
		treeData.setOwnerTypeName("个人");
		treeData.setOwnerCode(session.getUserId());
		treeData.setOwnerName(session.getUserName());
		ownerNode = new MrTplOwnerTreeNode(treeData, this.getCondition());
		children.add(ownerNode);
		
		// 全院节点
		treeData = new TemplateNavigatorTreeData();
		BeanUtils.copyProperties(this.getData(), treeData);
		treeData.setOwnerTypeCode(OwnerType.HOSPITAL_WIDE);
		treeData.setOwnerTypeName("全院");
		treeData.setOwnerCode(Session.get().getOrgCd());
		treeData.setOwnerName(this.getData().getHisOrgName());
		ownerNode = new MrTplOwnerTreeNode(treeData, this.getCondition());
		children.add(ownerNode);
		
		// 科室节点
		//TODO...
		Map params = new HashMap();
		params.put("parOrgCd", Session.get().getOrgCd());
		params.put("orgTpCd",OrgType.DEPT);
		ArrayResult<Organization> results = organizationService.search(params);
        if(results != null){
            Organization[] orgs = results.getDataList();
            if(orgs != null && orgs.length > 0){
                for(int i=0;i<orgs.length;i++){
                    Organization org = orgs[i];
                    String deptCode = org.getCode();
                    String deptName = org.getName();
                    
            		treeData = new TemplateNavigatorTreeData();
            		BeanUtils.copyProperties(this.getData(), treeData);
            		treeData.setOwnerTypeCode(OwnerType.DEPARTMENT);
            		treeData.setOwnerTypeName("科室");
            		treeData.setOwnerCode(deptCode);
            		treeData.setOwnerName(deptName);
            		ownerNode = new MrTplOwnerTreeNode(treeData, this.getCondition());
            		children.add(ownerNode);
                }
            }
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
		return this.getData().getHisOrgName();
	}	
	
	
	private Session getSession() {
		Session session = null;
		try {
			session = Session.get();
		} catch (Throwable ex) {
			//ex.printStackTrace();
		}
		
		//TODO... Mock data.
		if (session == null) {
			session = new Session(UUIDGenerator.getUUID(), "123456", "Test User", new Date());
		}
		
		return session;
	} 

}
