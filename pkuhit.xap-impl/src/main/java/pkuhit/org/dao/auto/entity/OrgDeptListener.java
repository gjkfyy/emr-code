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
public class OrgDeptListener implements EntityListener<OrgDept> {

    @Override
    public void preInsert(OrgDept entity, PreInsertContext<OrgDept> context) {
		Session session = Session.get();
		entity.crtUserId = session.getUserId();
    	entity.crtTime = new Timestamp(System.currentTimeMillis());
    	entity.lastUpdUserId = session.getUserId();
    	entity.lastUpdTime = entity.crtTime;
    	entity.delF = (short)0;
      	entity.crtDeptCd = session.getDeptId();
    }

    @Override
    public void preUpdate(OrgDept entity, PreUpdateContext<OrgDept> context) {
		Session session = Session.get();
		entity.lastUpdUserId = session.getUserId();
    	entity.lastUpdTime = new Timestamp(System.currentTimeMillis());
    	entity.lastUpdDeptCd = session.getDeptId();    	
    }

    @Override
    public void preDelete(OrgDept entity, PreDeleteContext<OrgDept> context) {
    }

    @Override
    public void postInsert(OrgDept entity, PostInsertContext<OrgDept> context) {
    }

    @Override
    public void postUpdate(OrgDept entity, PostUpdateContext<OrgDept> context) {
    }

    @Override
    public void postDelete(OrgDept entity, PostDeleteContext<OrgDept> context) {
    }
}