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
public class QaFltItmListener implements EntityListener<QaFltItm> {

    @Override
    public void preInsert(QaFltItm entity, PreInsertContext<QaFltItm> context) {
		Session session = Session.get();
		entity.crtUserId = session.getUserId();
    	entity.crtTime = new Timestamp(System.currentTimeMillis());
    	entity.lastUpdUserId = session.getUserId();
    	entity.lastUpdTime = entity.crtTime;
    	entity.delF = (short)0;
      	entity.crtDeptCd = session.getDeptId();
    }

    @Override
    public void preUpdate(QaFltItm entity, PreUpdateContext<QaFltItm> context) {
		Session session = Session.get();
		entity.lastUpdUserId = session.getUserId();
    	entity.lastUpdTime = new Timestamp(System.currentTimeMillis());
    	entity.lastUpdDeptCd = session.getDeptId();    	
    }

    @Override
    public void preDelete(QaFltItm entity, PreDeleteContext<QaFltItm> context) {
    }

    @Override
    public void postInsert(QaFltItm entity, PostInsertContext<QaFltItm> context) {
    }

    @Override
    public void postUpdate(QaFltItm entity, PostUpdateContext<QaFltItm> context) {
    }

    @Override
    public void postDelete(QaFltItm entity, PostDeleteContext<QaFltItm> context) {
    }
}