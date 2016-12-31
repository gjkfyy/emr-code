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
public class QaItmSndListener implements EntityListener<QaItmSnd> {

    @Override
    public void preInsert(QaItmSnd entity, PreInsertContext<QaItmSnd> context) {
		Session session = Session.get();
		entity.crtUserId = session.getUserId();
    	entity.crtTime = new Timestamp(System.currentTimeMillis());
    	entity.lastUpdUserId = session.getUserId();
    	entity.lastUpdTime = entity.crtTime;
    	entity.delF = (short)0;
      	entity.crtDeptCd = session.getDeptId();
    }

    @Override
    public void preUpdate(QaItmSnd entity, PreUpdateContext<QaItmSnd> context) {
		Session session = Session.get();
		entity.lastUpdUserId = session.getUserId();
    	entity.lastUpdTime = new Timestamp(System.currentTimeMillis());
    	entity.lastUpdDeptCd = session.getDeptId();    	
    }

    @Override
    public void preDelete(QaItmSnd entity, PreDeleteContext<QaItmSnd> context) {
    }

    @Override
    public void postInsert(QaItmSnd entity, PostInsertContext<QaItmSnd> context) {
    }

    @Override
    public void postUpdate(QaItmSnd entity, PostUpdateContext<QaItmSnd> context) {
    }

    @Override
    public void postDelete(QaItmSnd entity, PostDeleteContext<QaItmSnd> context) {
    }
}