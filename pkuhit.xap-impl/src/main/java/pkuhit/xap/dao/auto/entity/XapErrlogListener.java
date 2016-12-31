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
public class XapErrlogListener implements EntityListener<XapErrlog> {

    @Override
    public void preInsert(XapErrlog entity, PreInsertContext<XapErrlog> context) {
		Session session = Session.get();
		entity.crtUserId = session.getUserId();
    	entity.crtTime = new Timestamp(System.currentTimeMillis());
    	entity.lastUpdUserId = session.getUserId();
    	entity.lastUpdTime = entity.crtTime;
    	entity.delF = (short)0;
    }

    @Override
    public void preUpdate(XapErrlog entity, PreUpdateContext<XapErrlog> context) {
		Session session = Session.get();
		entity.lastUpdUserId = session.getUserId();
    	entity.lastUpdTime = new Timestamp(System.currentTimeMillis());
    }

    @Override
    public void preDelete(XapErrlog entity, PreDeleteContext<XapErrlog> context) {
    }

    @Override
    public void postInsert(XapErrlog entity, PostInsertContext<XapErrlog> context) {
    }

    @Override
    public void postUpdate(XapErrlog entity, PostUpdateContext<XapErrlog> context) {
    }

    @Override
    public void postDelete(XapErrlog entity, PostDeleteContext<XapErrlog> context) {
    }
}