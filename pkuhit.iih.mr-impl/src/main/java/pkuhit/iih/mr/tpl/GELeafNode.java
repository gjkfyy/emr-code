/**
 * 
 */
package pkuhit.iih.mr.tpl;

import java.util.Map;

import pkuhit.iih.mr.tpl.GETreeData;
import xap.sv.model.BaseNode;

/**
 * @author wu.junhui
 *
 */
public class GELeafNode extends BaseNode<GETreeData> {
	public GELeafNode(GETreeData data,
			Map<String, String> condition) {
		super(data, condition);
		
		data.setNodeType("4");
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
		return this.getData().getName();
	}	

}
