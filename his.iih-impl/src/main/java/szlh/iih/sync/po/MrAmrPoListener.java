package szlh.iih.sync.po;

 

import org.seasar.doma.jdbc.entity.EntityListener;
import org.seasar.doma.jdbc.entity.PostDeleteContext;
import org.seasar.doma.jdbc.entity.PostInsertContext;
import org.seasar.doma.jdbc.entity.PostUpdateContext;
import org.seasar.doma.jdbc.entity.PreDeleteContext;
import org.seasar.doma.jdbc.entity.PreInsertContext;
import org.seasar.doma.jdbc.entity.PreUpdateContext;

 
public class MrAmrPoListener implements EntityListener<MrAmrPo> {

    @Override
    public void postDelete(MrAmrPo entity, PostDeleteContext<MrAmrPo> context) {
    }

	@Override
	public void preInsert(MrAmrPo entity, PreInsertContext<MrAmrPo> context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void preUpdate(MrAmrPo entity, PreUpdateContext<MrAmrPo> context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void preDelete(MrAmrPo entity, PreDeleteContext<MrAmrPo> context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postInsert(MrAmrPo entity, PostInsertContext<MrAmrPo> context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postUpdate(MrAmrPo entity, PostUpdateContext<MrAmrPo> context) {
		// TODO Auto-generated method stub
		
	}

}
