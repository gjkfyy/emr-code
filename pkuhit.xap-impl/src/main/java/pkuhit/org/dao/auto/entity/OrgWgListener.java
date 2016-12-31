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
public class OrgWgListener implements EntityListener<OrgWg> {

    @Override
    public void preInsert(OrgWg entity, PreInsertContext<OrgWg> context) {
		Session session = Session.get();
		entity.crtUserId = session.getUserId();
    	entity.crtTime = new Timestamp(System.currentTimeMillis());
    	entity.lastUpdUserId = session.getUserId();
    	entity.lastUpdTime = entity.crtTime;
    	entity.delF = (short)0;
      	entity.crtDeptCd = session.getDeptId();
    }

    @Override
    public void preUpdate(OrgWg entity, PreUpdateContext<OrgWg> context) {
		Session session = Session.get();
		entity.lastUpdUserId = session.getUserId();
    	entity.lastUpdTime = new Timestamp(System.currentTimeMillis());
    	entity.lastUpdDeptCd = session.getDeptId();    	
    }

    @Override
    public void preDelete(OrgWg entity, PreDeleteContext<OrgWg> context) {
    }

    @Override
    public void postInsert(OrgWg entity, PostInsertContext<OrgWg> context) {
    }

    @Override
    public void postUpdate(OrgWg entity, PostUpdateContext<OrgWg> context) {
    }

    @Override
    public void postDelete(OrgWg entity, PostDeleteContext<OrgWg> context) {
    }
}