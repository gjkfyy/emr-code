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
public class DiSuiteShareEntityListener implements EntityListener<DiSuiteShareEntity> {

    @Override
    public void preInsert(DiSuiteShareEntity entity, PreInsertContext<DiSuiteShareEntity> context) {
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
    public void preUpdate(DiSuiteShareEntity entity, PreUpdateContext<DiSuiteShareEntity> context) {
		Session session = Session.get();
		entity.lastUpdUserId = session.getUserId();
    	entity.lastUpdTime = new Timestamp(System.currentTimeMillis());
    	entity.lastUpdDeptCd = session.getDeptId();    	
    }

    @Override
    public void preDelete(DiSuiteShareEntity entity, PreDeleteContext<DiSuiteShareEntity> context) {
    }

    @Override
    public void postInsert(DiSuiteShareEntity entity, PostInsertContext<DiSuiteShareEntity> context) {
    }

    @Override
    public void postUpdate(DiSuiteShareEntity entity, PostUpdateContext<DiSuiteShareEntity> context) {
    }

    @Override
    public void postDelete(DiSuiteShareEntity entity, PostDeleteContext<DiSuiteShareEntity> context) {
    }
    

}