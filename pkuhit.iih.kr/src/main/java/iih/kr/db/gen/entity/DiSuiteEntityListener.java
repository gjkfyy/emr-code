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
public class DiSuiteEntityListener implements EntityListener<DiSuiteEntity> {

    @Override
    public void preInsert(DiSuiteEntity entity, PreInsertContext<DiSuiteEntity> context) {
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
    public void preUpdate(DiSuiteEntity entity, PreUpdateContext<DiSuiteEntity> context) {
		Session session = Session.get();
		entity.lastUpdUserId = session.getUserId();
    	entity.lastUpdTime = new Timestamp(System.currentTimeMillis());
    	entity.lastUpdDeptCd = session.getDeptId();    	
    }

    @Override
    public void preDelete(DiSuiteEntity entity, PreDeleteContext<DiSuiteEntity> context) {
    }

    @Override
    public void postInsert(DiSuiteEntity entity, PostInsertContext<DiSuiteEntity> context) {
    }

    @Override
    public void postUpdate(DiSuiteEntity entity, PostUpdateContext<DiSuiteEntity> context) {
    }

    @Override
    public void postDelete(DiSuiteEntity entity, PostDeleteContext<DiSuiteEntity> context) {
    }
    

}