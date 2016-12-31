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
public class IemrReportRoleListener implements EntityListener<IemrReportRole> {

    @Override
    public void preInsert(IemrReportRole entity, PreInsertContext<IemrReportRole> context) {
		Session session = Session.get();
		entity.crtUserId = session.getUserId();
    	entity.crtTime = new Timestamp(System.currentTimeMillis());
    	entity.lastUpdUserId = session.getUserId();
    	entity.lastUpdTime = entity.crtTime;
    	entity.delF = (short)0;
      	entity.crtDeptCd = session.getDeptId();
    }

    @Override
    public void preUpdate(IemrReportRole entity, PreUpdateContext<IemrReportRole> context) {
		Session session = Session.get();
		entity.lastUpdUserId = session.getUserId();
    	entity.lastUpdTime = new Timestamp(System.currentTimeMillis());
    	entity.lastUpdDeptCd = session.getDeptId();    	
    }

    @Override
    public void preDelete(IemrReportRole entity, PreDeleteContext<IemrReportRole> context) {
    }

    @Override
    public void postInsert(IemrReportRole entity, PostInsertContext<IemrReportRole> context) {
    }

    @Override
    public void postUpdate(IemrReportRole entity, PostUpdateContext<IemrReportRole> context) {
    }

    @Override
    public void postDelete(IemrReportRole entity, PostDeleteContext<IemrReportRole> context) {
    }
}