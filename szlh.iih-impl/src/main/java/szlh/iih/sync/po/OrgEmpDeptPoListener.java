package szlh.iih.sync.po;

import org.seasar.doma.jdbc.entity.EntityListener;
import org.seasar.doma.jdbc.entity.PostDeleteContext;
import org.seasar.doma.jdbc.entity.PostInsertContext;
import org.seasar.doma.jdbc.entity.PostUpdateContext;
import org.seasar.doma.jdbc.entity.PreDeleteContext;
import org.seasar.doma.jdbc.entity.PreInsertContext;
import org.seasar.doma.jdbc.entity.PreUpdateContext;

public class OrgEmpDeptPoListener implements EntityListener<OrgEmpDeptPo> {

    @Override
    public void postDelete(OrgEmpDeptPo entity, PostDeleteContext<OrgEmpDeptPo> context) {
    }

	@Override
	public void preInsert(OrgEmpDeptPo entity, PreInsertContext<OrgEmpDeptPo> context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void preUpdate(OrgEmpDeptPo entity, PreUpdateContext<OrgEmpDeptPo> context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void preDelete(OrgEmpDeptPo entity, PreDeleteContext<OrgEmpDeptPo> context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postInsert(OrgEmpDeptPo entity, PostInsertContext<OrgEmpDeptPo> context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postUpdate(OrgEmpDeptPo entity, PostUpdateContext<OrgEmpDeptPo> context) {
		// TODO Auto-generated method stub
		
	}




}
