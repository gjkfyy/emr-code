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
public class MrTransDeptListener implements EntityListener<MrTransDept> {

    @Override
    public void preInsert(MrTransDept entity, PreInsertContext<MrTransDept> context) {
		Session session = Session.get();
		entity.crtUserId = session.getUserId();
    	entity.crtTime = new Timestamp(System.currentTimeMillis());
    	entity.lastUpdUserId = session.getUserId();
    	entity.lastUpdTime = entity.crtTime;
    	entity.delF = (short)0;
      	entity.crtDeptCd = session.getDeptId();
    }

    @Override
    public void preUpdate(MrTransDept entity, PreUpdateContext<MrTransDept> context) {
		Session session = Session.get();
		entity.lastUpdUserId = session.getUserId();
    	entity.lastUpdTime = new Timestamp(System.currentTimeMillis());
    	entity.lastUpdDeptCd = session.getDeptId();    	
    }

    @Override
    public void preDelete(MrTransDept entity, PreDeleteContext<MrTransDept> context) {
    }

    @Override
    public void postInsert(MrTransDept entity, PostInsertContext<MrTransDept> context) {
    }

    @Override
    public void postUpdate(MrTransDept entity, PostUpdateContext<MrTransDept> context) {
    }

    @Override
    public void postDelete(MrTransDept entity, PostDeleteContext<MrTransDept> context) {
    }
}