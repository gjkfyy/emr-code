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
public class XapTaskEventTypeListener implements EntityListener<XapTaskEventType> {

    @Override
    public void preInsert(XapTaskEventType entity, PreInsertContext<XapTaskEventType> context) {
		Session session = Session.get();
		entity.crtUserId = session.getUserId();
    	entity.crtTime = new Timestamp(System.currentTimeMillis());
    	entity.lastUpdUserId = session.getUserId();
    	entity.lastUpdTime = entity.crtTime;
    	entity.delF = (short)0;
      	entity.crtDeptCd = session.getDeptId();
    }

    @Override
    public void preUpdate(XapTaskEventType entity, PreUpdateContext<XapTaskEventType> context) {
		Session session = Session.get();
		entity.lastUpdUserId = session.getUserId();
    	entity.lastUpdTime = new Timestamp(System.currentTimeMillis());
    	entity.lastUpdDeptCd = session.getDeptId();    	
    }

    @Override
    public void preDelete(XapTaskEventType entity, PreDeleteContext<XapTaskEventType> context) {
    }

    @Override
    public void postInsert(XapTaskEventType entity, PostInsertContext<XapTaskEventType> context) {
    }

    @Override
    public void postUpdate(XapTaskEventType entity, PostUpdateContext<XapTaskEventType> context) {
    }

    @Override
    public void postDelete(XapTaskEventType entity, PostDeleteContext<XapTaskEventType> context) {
    }
}