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
public class MeDataAcruListener implements EntityListener<MeDataAcru> {

    @Override
    public void preInsert(MeDataAcru entity, PreInsertContext<MeDataAcru> context) {
		Session session = Session.get();
		entity.crtUserId = session.getUserId();
    	entity.crtTime = new Timestamp(System.currentTimeMillis());
    	entity.lastUpdUserId = session.getUserId();
    	entity.lastUpdTime = entity.crtTime;
    	entity.delF = (short)0;
    }

    @Override
    public void preUpdate(MeDataAcru entity, PreUpdateContext<MeDataAcru> context) {
		Session session = Session.get();
		entity.lastUpdUserId = session.getUserId();
    	entity.lastUpdTime = new Timestamp(System.currentTimeMillis());
    }

    @Override
    public void preDelete(MeDataAcru entity, PreDeleteContext<MeDataAcru> context) {
    }

    @Override
    public void postInsert(MeDataAcru entity, PostInsertContext<MeDataAcru> context) {
    }

    @Override
    public void postUpdate(MeDataAcru entity, PostUpdateContext<MeDataAcru> context) {
    }

    @Override
    public void postDelete(MeDataAcru entity, PostDeleteContext<MeDataAcru> context) {
    }
}