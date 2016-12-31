package pkuhit.iih.mr.tpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

import org.springframework.beans.BeanUtils;

import pkuhit.iih.pub.IihUtils;
import pkuhit.md.OwnerType;
import pkuhit.org.Organization;
import pkuhit.xap.ac.Session;
import xap.sv.model.BaseNode;
import xap.sv.model.Composite;
import xap.util.UUIDGenerator;

public class GEHispitalTreeNode extends BaseNode<GETreeData> {

	
	public GEHispitalTreeNode(GETreeData data,
			Map<String, String> condition) {
		super(data, condition);
		
		data.setNodeType("1");
	}

	@Override
	public void loadChildren() {
		ArrayList<Composite<GETreeData>> children = 
				new ArrayList<Composite<GETreeData>>();
		
		GETreeData treeData;
		GEOwnerTreeNode ownerNode;
		Session session = this.getSession();
		// 个人节点
		treeData = new GETreeData();
		BeanUtils.copyProperties(this.getData(), treeData);
		treeData.setOwnerTypeCode(OwnerType.PERSONAL);
		treeData.setOwnerTypeName("个人");
		treeData.setOwnerCode(session.getUserId());
		treeData.setOwnerName(session.getUserName());
		ownerNode = new GEOwnerTreeNode(treeData, this.getCondition());
		children.add(ownerNode);
		
		// 全院节点
		treeData = new GETreeData();
		BeanUtils.copyProperties(this.getData(), treeData);
		treeData.setOwnerTypeCode(OwnerType.HOSPITAL_WIDE);
		treeData.setOwnerTypeName("全院");
		treeData.setOwnerCode(Session.get().getOrgCd());
		treeData.setOwnerName(this.getData().getHisOrgName());
		ownerNode = new GEOwnerTreeNode(treeData, this.getCondition());
		children.add(ownerNode);
		
		// 科室节点
		//TODO...
		if(this.getCondition().containsKey("deptCodeArr")){
			String deptCodeS = (String)(this.getCondition().get("deptCodeArr"));
			String deptNameS = (String)(this.getCondition().get("deptNameArr"));
            String[] deptCodeArr = deptCodeS.split(",");
            String[] deptNameArr = deptNameS.split(",");
            if(deptCodeArr != null && deptCodeArr.length > 0){
                for(int i=0;i<deptCodeArr.length;i++){
                    String deptCode =  deptCodeArr[i];
                    String deptName =  deptNameArr[i];
            		treeData = new GETreeData();
            		BeanUtils.copyProperties(this.getData(), treeData);
            		treeData.setOwnerTypeCode(OwnerType.DEPARTMENT);
            		treeData.setOwnerTypeName("科室");
            		treeData.setOwnerCode(deptCode);
            		treeData.setOwnerName(deptName);
            		ownerNode = new GEOwnerTreeNode(treeData, this.getCondition());
            		children.add(ownerNode);
                }
            }
		}
		
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
