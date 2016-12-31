package pkuhit.iih.qa.dao.auto.entity;

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
public class QaSysMrListener implements EntityListener<QaSysMr> {

    @Override
    public void preInsert(QaSysMr entity, PreInsertContext<QaSysMr> context) {
		Session session = Session.get();
		entity.crtUserId = session.getUserId();
    	entity.crtTime = new Timestamp(System.currentTimeMillis());
    	entity.lastUpdUserId = session.getUserId();
    	entity.lastUpdTime = entity.crtTime;
    	entity.delF = (short)0;
      	entity.crtDeptCd = session.getDeptId();
    }

    @Override
    public void preUpdate(QaSysMr entity, PreUpdateContext<QaSysMr> context) {
		Session session = Session.get();
		entity.lastUpdUserId = session.getUserId();
    	entity.lastUpdTime = new Timestamp(System.currentTimeMillis());
    	entity.lastUpdDeptCd = session.getDeptId();    	
    }

    @Override
    public void preDelete(QaSysMr entity, PreDeleteContext<QaSysMr> context) {
    }

    @Override
    public void postInsert(QaSysMr entity, PostInsertContext<QaSysMr> context) {
    }

    @Override
    public void postUpdate(QaSysMr entity, PostUpdateContext<QaSysMr> context) {
    }

    @Override
    public void postDelete(QaSysMr entity, PostDeleteContext<QaSysMr> context) {
    }
}