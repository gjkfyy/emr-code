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
public class MeDoListener implements EntityListener<MeDo> {

    @Override
    public void preInsert(MeDo entity, PreInsertContext<MeDo> context) {
		Session session = Session.get();
		entity.crtUserId = session.getUserId();
    	entity.crtTime = new Timestamp(System.currentTimeMillis());
    	entity.lastUpdUserId = session.getUserId();
    	entity.lastUpdTime = entity.crtTime;
    	entity.delF = (short)0;
    }

    @Override
    public void preUpdate(MeDo entity, PreUpdateContext<MeDo> context) {
		Session session = Session.get();
		entity.lastUpdUserId = session.getUserId();
    	entity.lastUpdTime = new Timestamp(System.currentTimeMillis());
    }

    @Override
    public void preDelete(MeDo entity, PreDeleteContext<MeDo> context) {
    }

    @Override
    public void postInsert(MeDo entity, PostInsertContext<MeDo> context) {
    }

    @Override
    public void postUpdate(MeDo entity, PostUpdateContext<MeDo> context) {
    }

    @Override
    public void postDelete(MeDo entity, PostDeleteContext<MeDo> context) {
    }
}