package ei.en.db.dao.po;

 

import org.seasar.doma.jdbc.entity.EntityListener;
import org.seasar.doma.jdbc.entity.PostDeleteContext;
import org.seasar.doma.jdbc.entity.PostInsertContext;
import org.seasar.doma.jdbc.entity.PostUpdateContext;
import org.seasar.doma.jdbc.entity.PreDeleteContext;
import org.seasar.doma.jdbc.entity.PreInsertContext;
import org.seasar.doma.jdbc.entity.PreUpdateContext;

 
public class VwEnMzPoListener implements EntityListener<VwEnMzPo> {

    @Override
    public void postDelete(VwEnMzPo entity, PostDeleteContext<VwEnMzPo> context) {
    }

	@Override
	public void preInsert(VwEnMzPo entity, PreInsertContext<VwEnMzPo> context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void preUpdate(VwEnMzPo entity, PreUpdateContext<VwEnMzPo> context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void preDelete(VwEnMzPo entity, PreDeleteContext<VwEnMzPo> context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postInsert(VwEnMzPo entity, PostInsertContext<VwEnMzPo> context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postUpdate(VwEnMzPo entity, PostUpdateContext<VwEnMzPo> context) {
		// TODO Auto-generated method stub
		
	}

}
