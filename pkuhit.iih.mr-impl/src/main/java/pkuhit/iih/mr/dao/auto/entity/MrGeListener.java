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
public class MrGeListener implements EntityListener<MrGe> {

    @Override
    public void preInsert(MrGe entity, PreInsertContext<MrGe> context) {
		Session session = Session.get();
		entity.crtUserId = session.getUserId();
    	entity.crtTime = new Timestamp(System.currentTimeMillis());
    	entity.lastUpdUserId = session.getUserId();
    	entity.lastUpdTime = entity.crtTime;
    	entity.delF = (short)0;
      	entity.crtDeptCd = session.getDeptId();
    }

    @Override
    public void preUpdate(MrGe entity, PreUpdateContext<MrGe> context) {
		Session session = Session.get();
		entity.lastUpdUserId = session.getUserId();
    	entity.lastUpdTime = new Timestamp(System.currentTimeMillis());
    	entity.lastUpdDeptCd = session.getDeptId();    	
    }

    @Override
    public void preDelete(MrGe entity, PreDeleteContext<MrGe> context) {
    }

    @Override
    public void postInsert(MrGe entity, PostInsertContext<MrGe> context) {
    }

    @Override
    public void postUpdate(MrGe entity, PostUpdateContext<MrGe> context) {
    }

    @Override
    public void postDelete(MrGe entity, PostDeleteContext<MrGe> context) {
    }
}