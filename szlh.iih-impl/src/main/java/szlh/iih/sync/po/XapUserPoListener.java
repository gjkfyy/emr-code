package szlh.iih.sync.po;

import org.seasar.doma.jdbc.entity.EntityListener;
import org.seasar.doma.jdbc.entity.PostDeleteContext;
import org.seasar.doma.jdbc.entity.PostInsertContext;
import org.seasar.doma.jdbc.entity.PostUpdateContext;
import org.seasar.doma.jdbc.entity.PreDeleteContext;
import org.seasar.doma.jdbc.entity.PreInsertContext;
import org.seasar.doma.jdbc.entity.PreUpdateContext;

public class XapUserPoListener implements  EntityListener<XapUserPo> {

    @Override
    public void postDelete(XapUserPo entity, PostDeleteContext<XapUserPo> context) {
    }

	@Override
	public void preInsert(XapUserPo entity, PreInsertContext<XapUserPo> context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void preUpdate(XapUserPo entity, PreUpdateContext<XapUserPo> context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void preDelete(XapUserPo entity, PreDeleteContext<XapUserPo> context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postInsert(XapUserPo entity, PostInsertContext<XapUserPo> context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postUpdate(XapUserPo entity, PostUpdateContext<XapUserPo> context) {
		// TODO Auto-generated method stub
		
	}



}
