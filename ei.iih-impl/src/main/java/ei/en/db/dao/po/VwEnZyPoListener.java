package ei.en.db.dao.po;

 

import org.seasar.doma.jdbc.entity.EntityListener;
import org.seasar.doma.jdbc.entity.PostDeleteContext;
import org.seasar.doma.jdbc.entity.PostInsertContext;
import org.seasar.doma.jdbc.entity.PostUpdateContext;
import org.seasar.doma.jdbc.entity.PreDeleteContext;
import org.seasar.doma.jdbc.entity.PreInsertContext;
import org.seasar.doma.jdbc.entity.PreUpdateContext;

 
public class VwEnZyPoListener implements EntityListener<VwEnZyPo> {

    @Override
    public void postDelete(VwEnZyPo entity, PostDeleteContext<VwEnZyPo> context) {
    }

	@Override
	public void preInsert(VwEnZyPo entity, PreInsertContext<VwEnZyPo> context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void preUpdate(VwEnZyPo entity, PreUpdateContext<VwEnZyPo> context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void preDelete(VwEnZyPo entity, PreDeleteContext<VwEnZyPo> context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postInsert(VwEnZyPo entity, PostInsertContext<VwEnZyPo> context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postUpdate(VwEnZyPo entity, PostUpdateContext<VwEnZyPo> context) {
		// TODO Auto-generated method stub
		
	}

}
