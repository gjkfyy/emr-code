package szlh.iih.sync.po;

import org.seasar.doma.jdbc.entity.EntityListener;
import org.seasar.doma.jdbc.entity.PostDeleteContext;
import org.seasar.doma.jdbc.entity.PostInsertContext;
import org.seasar.doma.jdbc.entity.PostUpdateContext;
import org.seasar.doma.jdbc.entity.PreDeleteContext;
import org.seasar.doma.jdbc.entity.PreInsertContext;
import org.seasar.doma.jdbc.entity.PreUpdateContext;

public class OrgPoListener implements EntityListener<OrgPo> {

    @Override
    public void postDelete(OrgPo entity, PostDeleteContext<OrgPo> context) {
    }

	@Override
	public void preInsert(OrgPo entity, PreInsertContext<OrgPo> context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void preUpdate(OrgPo entity, PreUpdateContext<OrgPo> context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void preDelete(OrgPo entity, PreDeleteContext<OrgPo> context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postInsert(OrgPo entity, PostInsertContext<OrgPo> context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postUpdate(OrgPo entity, PostUpdateContext<OrgPo> context) {
		// TODO Auto-generated method stub
		
	}




}
