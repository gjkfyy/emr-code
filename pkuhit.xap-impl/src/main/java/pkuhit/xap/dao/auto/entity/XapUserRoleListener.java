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
public class XapUserRoleListener implements EntityListener<XapUserRole> {

    @Override
    public void preInsert(XapUserRole entity, PreInsertContext<XapUserRole> context) {
		Session session = Session.get();
		entity.crtUserId = session.getUserId();
    	entity.crtTime = new Timestamp(System.currentTimeMillis());
    	entity.lastUpdUserId = session.getUserId();
    	entity.lastUpdTime = entity.crtTime;
    	entity.delF = (short)0;
      	entity.crtDeptCd = session.getDeptId();
    }

    @Override
    public void preUpdate(XapUserRole entity, PreUpdateContext<XapUserRole> context) {
		Session session = Session.get();
		entity.lastUpdUserId = session.getUserId();
    	entity.lastUpdTime = new Timestamp(System.currentTimeMillis());
    	entity.lastUpdDeptCd = session.getDeptId();    	
    }

    @Override
    public void preDelete(XapUserRole entity, PreDeleteContext<XapUserRole> context) {
    }

    @Override
    public void postInsert(XapUserRole entity, PostInsertContext<XapUserRole> context) {
    }

    @Override
    public void postUpdate(XapUserRole entity, PostUpdateContext<XapUserRole> context) {
    }

    @Override
    public void postDelete(XapUserRole entity, PostDeleteContext<XapUserRole> context) {
    }
}