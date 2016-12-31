package iih.dr.dao.auto.entity;

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
public class IemrRetrievalResultListener implements EntityListener<IemrRetrievalResult> {

    @Override
    public void preInsert(IemrRetrievalResult entity, PreInsertContext<IemrRetrievalResult> context) {
//		Session session = Session.get();
//		entity.crtUserId = session.getUserId();
    	entity.crtTime = new Timestamp(System.currentTimeMillis());
//    	entity.lastUpdUserId = session.getUserId();
    	entity.lastUpdTime = entity.crtTime;
    	entity.delF = (short)0;
//      	entity.crtDeptCd = session.getDeptId();
    }

    @Override
    public void preUpdate(IemrRetrievalResult entity, PreUpdateContext<IemrRetrievalResult> context) {
//		Session session = Session.get();
//		entity.lastUpdUserId = session.getUserId();
    	entity.lastUpdTime = new Timestamp(System.currentTimeMillis());
//    	entity.lastUpdDeptCd = session.getDeptId();    	
    }

    @Override
    public void preDelete(IemrRetrievalResult entity, PreDeleteContext<IemrRetrievalResult> context) {
    }

    @Override
    public void postInsert(IemrRetrievalResult entity, PostInsertContext<IemrRetrievalResult> context) {
    }

    @Override
    public void postUpdate(IemrRetrievalResult entity, PostUpdateContext<IemrRetrievalResult> context) {
    }

    @Override
    public void postDelete(IemrRetrievalResult entity, PostDeleteContext<IemrRetrievalResult> context) {
    }
}