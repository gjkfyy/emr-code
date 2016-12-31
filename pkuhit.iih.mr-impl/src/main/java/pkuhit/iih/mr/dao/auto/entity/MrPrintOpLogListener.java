package pkuhit.iih.mr.dao.auto.entity;

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
public class MrPrintOpLogListener implements EntityListener<MrPrintOpLog> {

    @Override
    public void preInsert(MrPrintOpLog entity, PreInsertContext<MrPrintOpLog> context) {
		Session session = Session.get();
		entity.crtUserId = session.getUserId();
    	entity.crtTime = new Timestamp(System.currentTimeMillis());
    	entity.lastUpdUserId = session.getUserId();
    	entity.lastUpdTime = entity.crtTime;
    	entity.delF = (short)0;
      	entity.crtDeptCd = session.getDeptId();
    }

    @Override
    public void preUpdate(MrPrintOpLog entity, PreUpdateContext<MrPrintOpLog> context) {
		Session session = Session.get();
		entity.lastUpdUserId = session.getUserId();
    	entity.lastUpdTime = new Timestamp(System.currentTimeMillis());
    	entity.lastUpdDeptCd = session.getDeptId();    	
    }

    @Override
    public void preDelete(MrPrintOpLog entity, PreDeleteContext<MrPrintOpLog> context) {
    }

    @Override
    public void postInsert(MrPrintOpLog entity, PostInsertContext<MrPrintOpLog> context) {
    }

    @Override
    public void postUpdate(MrPrintOpLog entity, PostUpdateContext<MrPrintOpLog> context) {
    }

    @Override
    public void postDelete(MrPrintOpLog entity, PostDeleteContext<MrPrintOpLog> context) {
    }
}