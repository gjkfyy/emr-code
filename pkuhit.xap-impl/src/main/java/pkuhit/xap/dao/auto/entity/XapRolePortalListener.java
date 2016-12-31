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
public class XapRolePortalListener implements EntityListener<XapRolePortal> {

    @Override
    public void preInsert(XapRolePortal entity, PreInsertContext<XapRolePortal> context) {
		Session session = Session.get();
		entity.crtUserId = session.getUserId();
    	entity.crtTime = new Timestamp(System.currentTimeMillis());
    	entity.lastUpdUserId = session.getUserId();
    	entity.lastUpdTime = entity.crtTime;
    	entity.delF = (short)0;
      	entity.crtDeptCd = session.getDeptId();
    }

    @Override
    public void preUpdate(XapRolePortal entity, PreUpdateContext<XapRolePortal> context) {
		Session session = Session.get();
		entity.lastUpdUserId = session.getUserId();
    	entity.lastUpdTime = new Timestamp(System.currentTimeMillis());
    	entity.lastUpdDeptCd = session.getDeptId();    	
    }

    @Override
    public void preDelete(XapRolePortal entity, PreDeleteContext<XapRolePortal> context) {
    }

    @Override
    public void postInsert(XapRolePortal entity, PostInsertContext<XapRolePortal> context) {
    }

    @Override
    public void postUpdate(XapRolePortal entity, PostUpdateContext<XapRolePortal> context) {
    }

    @Override
    public void postDelete(XapRolePortal entity, PostDeleteContext<XapRolePortal> context) {
    }
}