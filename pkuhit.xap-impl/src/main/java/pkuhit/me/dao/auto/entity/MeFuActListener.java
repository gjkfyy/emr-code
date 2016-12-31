package pkuhit.me.dao.auto.entity;

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
public class MeFuActListener implements EntityListener<MeFuAct> {

    @Override
    public void preInsert(MeFuAct entity, PreInsertContext<MeFuAct> context) {
		Session session = Session.get();
		entity.crtUserId = session.getUserId();
    	entity.crtTime = new Timestamp(System.currentTimeMillis());
    	entity.lastUpdUserId = session.getUserId();
    	entity.lastUpdTime = entity.crtTime;
    	entity.delF = (short)0;
    }

    @Override
    public void preUpdate(MeFuAct entity, PreUpdateContext<MeFuAct> context) {
		Session session = Session.get();
		entity.lastUpdUserId = session.getUserId();
    	entity.lastUpdTime = new Timestamp(System.currentTimeMillis());
    }

    @Override
    public void preDelete(MeFuAct entity, PreDeleteContext<MeFuAct> context) {
    }

    @Override
    public void postInsert(MeFuAct entity, PostInsertContext<MeFuAct> context) {
    }

    @Override
    public void postUpdate(MeFuAct entity, PostUpdateContext<MeFuAct> context) {
    }

    @Override
    public void postDelete(MeFuAct entity, PostDeleteContext<MeFuAct> context) {
    }
}