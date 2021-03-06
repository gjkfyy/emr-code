package pkuhit.org.dao.auto.entity;

import java.sql.Timestamp;

import org.seasar.doma.jdbc.entity.EntityListener;
import org.seasar.doma.jdbc.entity.PostDeleteContext;
import org.seasar.doma.jdbc.entity.PostInsertContext;
import org.seasar.doma.jdbc.entity.PostUpdateContext;
import org.seasar.doma.jdbc.entity.PreDeleteContext;
import org.seasar.doma.jdbc.entity.PreInsertContext;
import org.seasar.doma.jdbc.entity.PreUpdateContext;

import pkuhit.xap.ac.Session;

/**
 * 
 */
public class OrgEmpDeptListener implements EntityListener<OrgEmpDept> {

    @Override
    public void preInsert(OrgEmpDept entity, PreInsertContext<OrgEmpDept> context) {
		Session session = Session.get();
		entity.crtUserId = session.getUserId();
    	entity.crtTime = new Timestamp(System.currentTimeMillis());
    	entity.lastUpdUserId = session.getUserId();
    	entity.lastUpdTime = entity.crtTime;
    	entity.delF = (short)0;
      	entity.crtDeptCd = session.getDeptId();
    }

    @Override
    public void preUpdate(OrgEmpDept entity, PreUpdateContext<OrgEmpDept> context) {
		Session session = Session.get();
		entity.lastUpdUserId = session.getUserId();
    	entity.lastUpdTime = new Timestamp(System.currentTimeMillis());
    	entity.lastUpdDeptCd = session.getDeptId();    	
    }

    @Override
    public void preDelete(OrgEmpDept entity, PreDeleteContext<OrgEmpDept> context) {
    }

    @Override
    public void postInsert(OrgEmpDept entity, PostInsertContext<OrgEmpDept> context) {
    }

    @Override
    public void postUpdate(OrgEmpDept entity, PostUpdateContext<OrgEmpDept> context) {
    }

    @Override
    public void postDelete(OrgEmpDept entity, PostDeleteContext<OrgEmpDept> context) {
    }
}