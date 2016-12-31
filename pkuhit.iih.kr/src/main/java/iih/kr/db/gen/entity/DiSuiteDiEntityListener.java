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
public class DiSuiteDiEntityListener implements EntityListener<DiSuiteDiEntity> {

    @Override
    public void preInsert(DiSuiteDiEntity entity, PreInsertContext<DiSuiteDiEntity> context) {
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
    public void preUpdate(DiSuiteDiEntity entity, PreUpdateContext<DiSuiteDiEntity> context) {
		Session session = Session.get();
		entity.lastUpdUserId = session.getUserId();
    	entity.lastUpdTime = new Timestamp(System.currentTimeMillis());
    	entity.lastUpdDeptCd = session.getDeptId();    	
    }

    @Override
    public void preDelete(DiSuiteDiEntity entity, PreDeleteContext<DiSuiteDiEntity> context) {
    }

    @Override
    public void postInsert(DiSuiteDiEntity entity, PostInsertContext<DiSuiteDiEntity> context) {
    }

    @Override
    public void postUpdate(DiSuiteDiEntity entity, PostUpdateContext<DiSuiteDiEntity> context) {
    }

    @Override
    public void postDelete(DiSuiteDiEntity entity, PostDeleteContext<DiSuiteDiEntity> context) {
    }
    

}