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
public class XapRoleFuListener implements EntityListener<XapRoleFu> {

    @Override
    public void preInsert(XapRoleFu entity, PreInsertContext<XapRoleFu> context) {
		Session session = Session.get();
		entity.crtUserId = session.getUserId();
    	entity.crtTime = new Timestamp(System.currentTimeMillis());
    	entity.lastUpdUserId = session.getUserId();
    	entity.lastUpdTime = entity.crtTime;
    	entity.delF = (short)0;
    }

    @Override
    public void preUpdate(XapRoleFu entity, PreUpdateContext<XapRoleFu> context) {
		Session session = Session.get();
		entity.lastUpdUserId = session.getUserId();
    	entity.lastUpdTime = new Timestamp(System.currentTimeMillis());
    }

    @Override
    public void preDelete(XapRoleFu entity, PreDeleteContext<XapRoleFu> context) {
    }

    @Override
    public void postInsert(XapRoleFu entity, PostInsertContext<XapRoleFu> context) {
    }

    @Override
    public void postUpdate(XapRoleFu entity, PostUpdateContext<XapRoleFu> context) {
    }

    @Override
    public void postDelete(XapRoleFu entity, PostDeleteContext<XapRoleFu> context) {
    }
}