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
public class XapBasefileListener implements EntityListener<XapBasefile> {

    @Override
    public void preInsert(XapBasefile entity, PreInsertContext<XapBasefile> context) {
		Session session = Session.get();
		entity.crtUserId = session.getUserId();
    	entity.crtTime = new Timestamp(System.currentTimeMillis());
    	entity.lastUpdUserId = session.getUserId();
    	entity.lastUpdTime = entity.crtTime;
    	entity.delF = (short)0;
      	entity.crtDeptCd = session.getDeptId();
    }

    @Override
    public void preUpdate(XapBasefile entity, PreUpdateContext<XapBasefile> context) {
		Session session = Session.get();
		entity.lastUpdUserId = session.getUserId();
    	entity.lastUpdTime = new Timestamp(System.currentTimeMillis());
    	entity.lastUpdDeptCd = session.getDeptId();    	
    }

    @Override
    public void preDelete(XapBasefile entity, PreDeleteContext<XapBasefile> context) {
    }

    @Override
    public void postInsert(XapBasefile entity, PostInsertContext<XapBasefile> context) {
    }

    @Override
    public void postUpdate(XapBasefile entity, PostUpdateContext<XapBasefile> context) {
    }

    @Override
    public void postDelete(XapBasefile entity, PostDeleteContext<XapBasefile> context) {
    }
}