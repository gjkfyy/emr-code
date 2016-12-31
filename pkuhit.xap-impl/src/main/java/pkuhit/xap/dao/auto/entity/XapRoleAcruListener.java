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
public class XapRoleAcruListener implements EntityListener<XapRoleAcru> {

    @Override
    public void preInsert(XapRoleAcru entity, PreInsertContext<XapRoleAcru> context) {
		Session session = Session.get();
		entity.crtUserId = session.getUserId();
    	entity.crtTime = new Timestamp(System.currentTimeMillis());
    	entity.lastUpdUserId = session.getUserId();
    	entity.lastUpdTime = entity.crtTime;
    	entity.delF = (short)0;
    }

    @Override
    public void preUpdate(XapRoleAcru entity, PreUpdateContext<XapRoleAcru> context) {
		Session session = Session.get();
		entity.lastUpdUserId = session.getUserId();
    	entity.lastUpdTime = new Timestamp(System.currentTimeMillis());
    }

    @Override
    public void preDelete(XapRoleAcru entity, PreDeleteContext<XapRoleAcru> context) {
    }

    @Override
    public void postInsert(XapRoleAcru entity, PostInsertContext<XapRoleAcru> context) {
    }

    @Override
    public void postUpdate(XapRoleAcru entity, PostUpdateContext<XapRoleAcru> context) {
    }

    @Override
    public void postDelete(XapRoleAcru entity, PostDeleteContext<XapRoleAcru> context) {
    }
}