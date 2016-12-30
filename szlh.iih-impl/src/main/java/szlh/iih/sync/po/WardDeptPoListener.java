package szlh.iih.sync.po;

import org.seasar.doma.jdbc.entity.EntityListener;
import org.seasar.doma.jdbc.entity.PostDeleteContext;
import org.seasar.doma.jdbc.entity.PostInsertContext;
import org.seasar.doma.jdbc.entity.PostUpdateContext;
import org.seasar.doma.jdbc.entity.PreDeleteContext;
import org.seasar.doma.jdbc.entity.PreInsertContext;
import org.seasar.doma.jdbc.entity.PreUpdateContext;

public class WardDeptPoListener implements EntityListener<WardDeptPo> {

    @Override
    public void postDelete(WardDeptPo entity, PostDeleteContext<WardDeptPo> context) {
    }

	@Override
	public void preInsert(WardDeptPo entity, PreInsertContext<WardDeptPo> context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void preUpdate(WardDeptPo entity, PreUpdateContext<WardDeptPo> context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void preDelete(WardDeptPo entity, PreDeleteContext<WardDeptPo> context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postInsert(WardDeptPo entity, PostInsertContext<WardDeptPo> context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postUpdate(WardDeptPo entity, PostUpdateContext<WardDeptPo> context) {
		// TODO Auto-generated method stub
		
	}




}
