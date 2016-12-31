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
public class XapRoleMenuListener implements EntityListener<XapRoleMenu> {

    @Override
    public void preInsert(XapRoleMenu entity, PreInsertContext<XapRoleMenu> context) {
		Session session = Session.get();
		entity.crtUserId = session.getUserId();
    	entity.crtTime = new Timestamp(System.currentTimeMillis());
    	entity.lastUpdUserId = session.getUserId();
    	entity.lastUpdTime = entity.crtTime;
    	entity.delF = (short)0;
      	entity.crtDeptCd = session.getDeptId();
    }

    @Override
    public void preUpdate(XapRoleMenu entity, PreUpdateContext<XapRoleMenu> context) {
		Session session = Session.get();
		entity.lastUpdUserId = session.getUserId();
    	entity.lastUpdTime = new Timestamp(System.currentTimeMillis());
    	entity.lastUpdDeptCd = session.getDeptId();    	
    }

    @Override
    public void preDelete(XapRoleMenu entity, PreDeleteContext<XapRoleMenu> context) {
    }

    @Override
    public void postInsert(XapRoleMenu entity, PostInsertContext<XapRoleMenu> context) {
    }

    @Override
    public void postUpdate(XapRoleMenu entity, PostUpdateContext<XapRoleMenu> context) {
    }

    @Override
    public void postDelete(XapRoleMenu entity, PostDeleteContext<XapRoleMenu> context) {
    }
}