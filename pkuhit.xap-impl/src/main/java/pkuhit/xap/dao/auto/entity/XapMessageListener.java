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
public class XapMessageListener implements EntityListener<XapMessage> {

    @Override
    public void preInsert(XapMessage entity, PreInsertContext<XapMessage> context) {
//		Session session = Session.get();
//		entity.crtUserId = session.getUserId();
    	entity.crtTime = new Timestamp(System.currentTimeMillis());
//    	entity.lastUpdUserId = session.getUserId();
    	entity.lastUpdTime = entity.crtTime;
    	entity.delF = (short)0;
//      	entity.crtDeptCd = session.getDeptId();
    }

    @Override
    public void preUpdate(XapMessage entity, PreUpdateContext<XapMessage> context) {
		Session session = Session.get();
		entity.lastUpdUserId = session.getUserId();
    	entity.lastUpdTime = new Timestamp(System.currentTimeMillis());
    	entity.lastUpdDeptCd = session.getDeptId();    	
    }

    @Override
    public void preDelete(XapMessage entity, PreDeleteContext<XapMessage> context) {
    }

    @Override
    public void postInsert(XapMessage entity, PostInsertContext<XapMessage> context) {
    }

    @Override
    public void postUpdate(XapMessage entity, PostUpdateContext<XapMessage> context) {
    }

    @Override
    public void postDelete(XapMessage entity, PostDeleteContext<XapMessage> context) {
    }
}