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
public class XapPfmlogListener implements EntityListener<XapPfmlog> {

    @Override
    public void preInsert(XapPfmlog entity, PreInsertContext<XapPfmlog> context) {
		Session session = Session.get();
		entity.crtUserId = session.getUserId();
    	entity.crtTime = new Timestamp(System.currentTimeMillis());
    	entity.lastUpdUserId = session.getUserId();
    	entity.lastUpdTime = entity.crtTime;
    	entity.delF = (short)0;
    }

    @Override
    public void preUpdate(XapPfmlog entity, PreUpdateContext<XapPfmlog> context) {
		Session session = Session.get();
		entity.lastUpdUserId = session.getUserId();
    	entity.lastUpdTime = new Timestamp(System.currentTimeMillis());
    }

    @Override
    public void preDelete(XapPfmlog entity, PreDeleteContext<XapPfmlog> context) {
    }

    @Override
    public void postInsert(XapPfmlog entity, PostInsertContext<XapPfmlog> context) {
    }

    @Override
    public void postUpdate(XapPfmlog entity, PostUpdateContext<XapPfmlog> context) {
    }

    @Override
    public void postDelete(XapPfmlog entity, PostDeleteContext<XapPfmlog> context) {
    }
}