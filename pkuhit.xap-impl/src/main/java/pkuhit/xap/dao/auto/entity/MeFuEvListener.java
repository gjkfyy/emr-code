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
public class MeFuEvListener implements EntityListener<MeFuEv> {

    @Override
    public void preInsert(MeFuEv entity, PreInsertContext<MeFuEv> context) {
		Session session = Session.get();
		entity.crtUserId = session.getUserId();
    	entity.crtTime = new Timestamp(System.currentTimeMillis());
    	entity.lastUpdUserId = session.getUserId();
    	entity.lastUpdTime = entity.crtTime;
    	entity.delF = (short)0;
    }

    @Override
    public void preUpdate(MeFuEv entity, PreUpdateContext<MeFuEv> context) {
		Session session = Session.get();
		entity.lastUpdUserId = session.getUserId();
    	entity.lastUpdTime = new Timestamp(System.currentTimeMillis());
    }

    @Override
    public void preDelete(MeFuEv entity, PreDeleteContext<MeFuEv> context) {
    }

    @Override
    public void postInsert(MeFuEv entity, PostInsertContext<MeFuEv> context) {
    }

    @Override
    public void postUpdate(MeFuEv entity, PostUpdateContext<MeFuEv> context) {
    }

    @Override
    public void postDelete(MeFuEv entity, PostDeleteContext<MeFuEv> context) {
    }
    
}