package szlh.iih.sync.po;

import org.seasar.doma.jdbc.entity.EntityListener;
import org.seasar.doma.jdbc.entity.PostDeleteContext;
import org.seasar.doma.jdbc.entity.PostInsertContext;
import org.seasar.doma.jdbc.entity.PostUpdateContext;
import org.seasar.doma.jdbc.entity.PreDeleteContext;
import org.seasar.doma.jdbc.entity.PreInsertContext;
import org.seasar.doma.jdbc.entity.PreUpdateContext;

public class MdDiPoListener implements EntityListener<MdDiPo> {

    @Override
    public void postDelete(MdDiPo entity, PostDeleteContext<MdDiPo> context) {
    }

	@Override
	public void preInsert(MdDiPo entity, PreInsertContext<MdDiPo> context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void preUpdate(MdDiPo entity, PreUpdateContext<MdDiPo> context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void preDelete(MdDiPo entity, PreDeleteContext<MdDiPo> context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postInsert(MdDiPo entity, PostInsertContext<MdDiPo> context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postUpdate(MdDiPo entity, PostUpdateContext<MdDiPo> context) {
		// TODO Auto-generated method stub
		
	}


}
