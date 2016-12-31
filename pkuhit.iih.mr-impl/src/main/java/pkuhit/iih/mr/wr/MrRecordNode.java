package pkuhit.iih.mr.wr;

import java.util.Map;

import pkuhit.iih.mr.dao.custom.CusMrTreeDao;
import xap.sv.app.Application;
import xap.sv.dao.DaoFactory;
import xap.sv.model.BaseNode;

public class MrRecordNode extends BaseNode<MrTreeData> {
	CusMrTreeDao cusMrTreeDao = null;
	
	public MrRecordNode(MrTreeData data, Map<String, String> condition) {
		super(data, condition);
		data.setNodeType("2");
		
		DaoFactory df = Application.getInstance().getBundleContext().getServiceOfType(DaoFactory.class);
		this.cusMrTreeDao = df.getDao(CusMrTreeDao.class);
	}

	@Override
	public String getText() {
		return this.getData().getName();
	}

	@Override
	public void loadChildren() {
	}

}
