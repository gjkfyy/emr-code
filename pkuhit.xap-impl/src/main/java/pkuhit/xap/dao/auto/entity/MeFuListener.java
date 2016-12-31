package pkuhit.xap.dao.auto.entity;

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
public class MeFuListener implements EntityListener<MeFu> {

    @Override
    public void preInsert(MeFu entity, PreInsertContext<MeFu> context) {
		Session session = Session.get();
		entity.crtUserId = session.getUserId();
    	entity.crtTime = new Timestamp(System.currentTimeMillis());
    	entity.lastUpdUserId = session.getUserId();
    	entity.lastUpdTime = entity.crtTime;
    	entity.delF = (short)0;
    }

    @Override
    public void preUpdate(MeFu entity, PreUpdateContext<MeFu> context) {
		Session session = Session.get();
		entity.lastUpdUserId = session.getUserId();
    	entity.lastUpdTime = new Timestamp(System.currentTimeMillis());
    }

    @Override
    public void preDelete(MeFu entity, PreDeleteContext<MeFu> context) {
    }

    @Override
    public void postInsert(MeFu entity, PostInsertContext<MeFu> context) {
    }

    @Override
    public void postUpdate(MeFu entity, PostUpdateContext<MeFu> context) {
    }

    @Override
    public void postDelete(MeFu entity, PostDeleteContext<MeFu> context) {
    }
    
}