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
public class QaSysListener implements EntityListener<QaSys> {

    @Override
    public void preInsert(QaSys entity, PreInsertContext<QaSys> context) {
		Session session = Session.get();
		entity.crtUserId = session.getUserId();
    	entity.crtTime = new Timestamp(System.currentTimeMillis());
    	entity.lastUpdUserId = session.getUserId();
    	entity.lastUpdTime = entity.crtTime;
    	entity.delF = (short)0;
      	entity.crtDeptCd = session.getDeptId();
    }

    @Override
    public void preUpdate(QaSys entity, PreUpdateContext<QaSys> context) {
		Session session = Session.get();
		entity.lastUpdUserId = session.getUserId();
    	entity.lastUpdTime = new Timestamp(System.currentTimeMillis());
    	entity.lastUpdDeptCd = session.getDeptId();    	
    }

    @Override
    public void preDelete(QaSys entity, PreDeleteContext<QaSys> context) {
    }

    @Override
    public void postInsert(QaSys entity, PostInsertContext<QaSys> context) {
    }

    @Override
    public void postUpdate(QaSys entity, PostUpdateContext<QaSys> context) {
    }

    @Override
    public void postDelete(QaSys entity, PostDeleteContext<QaSys> context) {
    }
}