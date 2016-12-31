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
public class MrTplDeptListener implements EntityListener<MrTplDept> {

    @Override
    public void preInsert(MrTplDept entity, PreInsertContext<MrTplDept> context) {
		Session session = Session.get();
		entity.crtUserId = session.getUserId();
    	entity.crtTime = new Timestamp(System.currentTimeMillis());
    	entity.lastUpdUserId = session.getUserId();
    	entity.lastUpdTime = entity.crtTime;
    	entity.delF = (short)0;
      	entity.crtDeptCd = session.getDeptId();
    }

    @Override
    public void preUpdate(MrTplDept entity, PreUpdateContext<MrTplDept> context) {
		Session session = Session.get();
		entity.lastUpdUserId = session.getUserId();
    	entity.lastUpdTime = new Timestamp(System.currentTimeMillis());
    	entity.lastUpdDeptCd = session.getDeptId();    	
    }

    @Override
    public void preDelete(MrTplDept entity, PreDeleteContext<MrTplDept> context) {
    }

    @Override
    public void postInsert(MrTplDept entity, PostInsertContext<MrTplDept> context) {
    }

    @Override
    public void postUpdate(MrTplDept entity, PostUpdateContext<MrTplDept> context) {
    }

    @Override
    public void postDelete(MrTplDept entity, PostDeleteContext<MrTplDept> context) {
    }
}