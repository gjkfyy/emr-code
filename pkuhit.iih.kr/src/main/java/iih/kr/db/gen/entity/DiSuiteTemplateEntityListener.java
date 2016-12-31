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
public class DiSuiteTemplateEntityListener implements EntityListener<DiSuiteTemplateEntity> {

    @Override
    public void preInsert(DiSuiteTemplateEntity entity, PreInsertContext<DiSuiteTemplateEntity> context) {
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
    public void preUpdate(DiSuiteTemplateEntity entity, PreUpdateContext<DiSuiteTemplateEntity> context) {
		Session session = Session.get();
		entity.lastUpdUserId = session.getUserId();
    	entity.lastUpdTime = new Timestamp(System.currentTimeMillis());
    	entity.lastUpdDeptCd = session.getDeptId();    	
    }

    @Override
    public void preDelete(DiSuiteTemplateEntity entity, PreDeleteContext<DiSuiteTemplateEntity> context) {
    }

    @Override
    public void postInsert(DiSuiteTemplateEntity entity, PostInsertContext<DiSuiteTemplateEntity> context) {
    }

    @Override
    public void postUpdate(DiSuiteTemplateEntity entity, PostUpdateContext<DiSuiteTemplateEntity> context) {
    }

    @Override
    public void postDelete(DiSuiteTemplateEntity entity, PostDeleteContext<DiSuiteTemplateEntity> context) {
    }
    

}