package pkuhit.iih.mr.tpl;

import java.util.Map;

import xap.sv.model.BaseNode;

public class MrTplLeafNode  extends BaseNode<TemplateNavigatorTreeData> {
	public MrTplLeafNode(TemplateNavigatorTreeData data,
			Map<String, String> condition) {
		super(data, condition);
		
		data.setNodeType(TemplateNavigatorTreeNodeType.MRTPL);
	}

	/* (non-Javadoc)
	 * @see pkuhit.iih.mr.tpl.GroupElementBaseNodeWrap#loadChildren()
	 */
	@Override
	public void loadChildren() {

	}
	
	/* (non-Javadoc)
	 * @see xap.sv.model.Composite#getText()
	 */
	@Override
	public String getText() {
		return this.getData().getTemplateName();
	}	

}

