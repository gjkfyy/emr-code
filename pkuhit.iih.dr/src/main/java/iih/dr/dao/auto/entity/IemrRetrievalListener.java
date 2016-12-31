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
public class IemrRetrievalListener implements EntityListener<IemrRetrieval> {

    @Override
    public void preInsert(IemrRetrieval entity, PreInsertContext<IemrRetrieval> context) {
		Session session = Session.get();
		entity.crtUserId = session.getUserId();
    	entity.crtTime = new Timestamp(System.currentTimeMillis());
    	entity.lastUpdUserId = session.getUserId();
    	entity.lastUpdTime = entity.crtTime;
    	entity.delF = (short)0;
      	entity.crtDeptCd = session.getDeptId();
    }

    @Override
    public void preUpdate(IemrRetrieval entity, PreUpdateContext<IemrRetrieval> context) {
		Session session = Session.get();
		entity.lastUpdUserId = session.getUserId();
    	entity.lastUpdTime = new Timestamp(System.currentTimeMillis());
    	entity.lastUpdDeptCd = session.getDeptId();    	
    }

    @Override
    public void preDelete(IemrRetrieval entity, PreDeleteContext<IemrRetrieval> context) {
    }

    @Override
    public void postInsert(IemrRetrieval entity, PostInsertContext<IemrRetrieval> context) {
    }

    @Override
    public void postUpdate(IemrRetrieval entity, PostUpdateContext<IemrRetrieval> context) {
    }

    @Override
    public void postDelete(IemrRetrieval entity, PostDeleteContext<IemrRetrieval> context) {
    }
}