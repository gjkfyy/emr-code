package szlh.iih.sync.po;

import org.seasar.doma.jdbc.entity.EntityListener;
import org.seasar.doma.jdbc.entity.PostDeleteContext;
import org.seasar.doma.jdbc.entity.PostInsertContext;
import org.seasar.doma.jdbc.entity.PostUpdateContext;
import org.seasar.doma.jdbc.entity.PreDeleteContext;
import org.seasar.doma.jdbc.entity.PreInsertContext;
import org.seasar.doma.jdbc.entity.PreUpdateContext;

public class XapOrgEmpPoListener implements  EntityListener<XapOrgEmpPo> {

    @Override
    public void postDelete(XapOrgEmpPo entity, PostDeleteContext<XapOrgEmpPo> context) {
    }

	@Override
	public void preInsert(XapOrgEmpPo entity, PreInsertContext<XapOrgEmpPo> context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void preUpdate(XapOrgEmpPo entity, PreUpdateContext<XapOrgEmpPo> context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void preDelete(XapOrgEmpPo entity, PreDeleteContext<XapOrgEmpPo> context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postInsert(XapOrgEmpPo entity, PostInsertContext<XapOrgEmpPo> context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postUpdate(XapOrgEmpPo entity, PostUpdateContext<XapOrgEmpPo> context) {
		// TODO Auto-generated method stub
		
	}

}
