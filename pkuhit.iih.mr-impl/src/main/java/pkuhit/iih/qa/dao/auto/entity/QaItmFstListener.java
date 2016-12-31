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
public class QaItmFstListener implements EntityListener<QaItmFst> {

    @Override
    public void preInsert(QaItmFst entity, PreInsertContext<QaItmFst> context) {
		Session session = Session.get();
		entity.crtUserId = session.getUserId();
    	entity.crtTime = new Timestamp(System.currentTimeMillis());
    	entity.lastUpdUserId = session.getUserId();
    	entity.lastUpdTime = entity.crtTime;
    	entity.delF = (short)0;
      	entity.crtDeptCd = session.getDeptId();
    }

    @Override
    public void preUpdate(QaItmFst entity, PreUpdateContext<QaItmFst> context) {
		Session session = Session.get();
		entity.lastUpdUserId = session.getUserId();
    	entity.lastUpdTime = new Timestamp(System.currentTimeMillis());
    	entity.lastUpdDeptCd = session.getDeptId();    	
    }

    @Override
    public void preDelete(QaItmFst entity, PreDeleteContext<QaItmFst> context) {
    }

    @Override
    public void postInsert(QaItmFst entity, PostInsertContext<QaItmFst> context) {
    }

    @Override
    public void postUpdate(QaItmFst entity, PostUpdateContext<QaItmFst> context) {
    }

    @Override
    public void postDelete(QaItmFst entity, PostDeleteContext<QaItmFst> context) {
    }
}