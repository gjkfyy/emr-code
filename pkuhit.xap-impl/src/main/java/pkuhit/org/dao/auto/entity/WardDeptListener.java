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
public class WardDeptListener implements EntityListener<WardDept> {

    @Override
    public void preInsert(WardDept entity, PreInsertContext<WardDept> context) {
		Session session = Session.get();
		entity.crtUserId = session.getUserId();
    	entity.crtTime = new Timestamp(System.currentTimeMillis());
    	entity.lastUpdUserId = session.getUserId();
    	entity.lastUpdTime = entity.crtTime;
    	entity.delF = (short)0;
      	entity.crtDeptCd = session.getDeptId();
    }

    @Override
    public void preUpdate(WardDept entity, PreUpdateContext<WardDept> context) {
		Session session = Session.get();
		entity.lastUpdUserId = session.getUserId();
    	entity.lastUpdTime = new Timestamp(System.currentTimeMillis());
    	entity.lastUpdDeptCd = session.getDeptId();    	
    }

    @Override
    public void preDelete(WardDept entity, PreDeleteContext<WardDept> context) {
    }

    @Override
    public void postInsert(WardDept entity, PostInsertContext<WardDept> context) {
    }

    @Override
    public void postUpdate(WardDept entity, PostUpdateContext<WardDept> context) {
    }

    @Override
    public void postDelete(WardDept entity, PostDeleteContext<WardDept> context) {
    }
}