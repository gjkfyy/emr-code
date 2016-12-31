package iih.kr.db.gen.entity;

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
public class DiSuiteTpEntityListener implements EntityListener<DiSuiteTpEntity> {

    @Override
    public void preInsert(DiSuiteTpEntity entity, PreInsertContext<DiSuiteTpEntity> context) {
		Session session = Session.get();
		entity.crtUserId = session.getUserId();
    	entity.crtTime = new Timestamp(System.currentTimeMillis());
    	entity.lastUpdUserId = session.getUserId();
    	entity.lastUpdTime = entity.crtTime;
    	entity.delF = (short)0;
      	entity.crtDeptCd = session.getDeptId();
      	entity.lastUpdDeptCd = session.getDeptId();  
    }

    @Override
    public void preUpdate(DiSuiteTpEntity entity, PreUpdateContext<DiSuiteTpEntity> context) {
		Session session = Session.get();
		entity.lastUpdUserId = session.getUserId();
    	entity.lastUpdTime = new Timestamp(System.currentTimeMillis());
    	entity.lastUpdDeptCd = session.getDeptId();    	
    }

    @Override
    public void preDelete(DiSuiteTpEntity entity, PreDeleteContext<DiSuiteTpEntity> context) {
    }

    @Override
    public void postInsert(DiSuiteTpEntity entity, PostInsertContext<DiSuiteTpEntity> context) {
    }

    @Override
    public void postUpdate(DiSuiteTpEntity entity, PostUpdateContext<DiSuiteTpEntity> context) {
    }

    @Override
    public void postDelete(DiSuiteTpEntity entity, PostDeleteContext<DiSuiteTpEntity> context) {
    }
    

}