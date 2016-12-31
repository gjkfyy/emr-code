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
public class IemrReportListener implements EntityListener<IemrReport> {

    @Override
    public void preInsert(IemrReport entity, PreInsertContext<IemrReport> context) {
		Session session = Session.get();
		entity.crtUserId = session.getUserId();
    	entity.crtTime = new Timestamp(System.currentTimeMillis());
    	entity.lastUpdUserId = session.getUserId();
    	entity.lastUpdTime = entity.crtTime;
    	entity.delF = (short)0;
      	entity.crtDeptCd = session.getDeptId();
    }

    @Override
    public void preUpdate(IemrReport entity, PreUpdateContext<IemrReport> context) {
		Session session = Session.get();
		entity.lastUpdUserId = session.getUserId();
    	entity.lastUpdTime = new Timestamp(System.currentTimeMillis());
    	entity.lastUpdDeptCd = session.getDeptId();    	
    }

    @Override
    public void preDelete(IemrReport entity, PreDeleteContext<IemrReport> context) {
    }

    @Override
    public void postInsert(IemrReport entity, PostInsertContext<IemrReport> context) {
    }

    @Override
    public void postUpdate(IemrReport entity, PostUpdateContext<IemrReport> context) {
    }

    @Override
    public void postDelete(IemrReport entity, PostDeleteContext<IemrReport> context) {
    }
}