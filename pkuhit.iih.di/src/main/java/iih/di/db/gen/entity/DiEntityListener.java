package iih.di.db.gen.entity;

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
public class DiEntityListener implements EntityListener<DiEntity> {

    @Override
    public void preInsert(DiEntity entity, PreInsertContext<DiEntity> context) {
		Session session = Session.get();
		entity.crtUserId = session.getUserId();
    	entity.crtTime = new Timestamp(System.currentTimeMillis());
    	entity.lastUpdUserId = session.getUserId();
    	entity.lastUpdTime = entity.crtTime;
    	entity.delF = (short)0;
      	entity.crtDeptCd = session.getDeptId();
    }

    @Override
    public void preUpdate(DiEntity entity, PreUpdateContext<DiEntity> context) {
    	Session session = Session.get();
    	entity.lastUpdUserId = session.getUserId();
    	entity.lastUpdTime = entity.crtTime;
    }

    @Override
    public void preDelete(DiEntity entity, PreDeleteContext<DiEntity> context) {
    }

    @Override
    public void postInsert(DiEntity entity, PostInsertContext<DiEntity> context) {
    }

    @Override
    public void postUpdate(DiEntity entity, PostUpdateContext<DiEntity> context) {
    }

    @Override
    public void postDelete(DiEntity entity, PostDeleteContext<DiEntity> context) {
    }
    

}