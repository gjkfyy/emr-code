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
public class MrTplEntityListener implements EntityListener<MrTplEntity> {

    @Override
    public void preInsert(MrTplEntity entity, PreInsertContext<MrTplEntity> context) {
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
    public void preUpdate(MrTplEntity entity, PreUpdateContext<MrTplEntity> context) {
		Session session = Session.get();
		entity.lastUpdUserId = session.getUserId();
    	entity.lastUpdTime = new Timestamp(System.currentTimeMillis());
    	entity.lastUpdDeptCd = session.getDeptId();    	
    }

    @Override
    public void preDelete(MrTplEntity entity, PreDeleteContext<MrTplEntity> context) {
    }

    @Override
    public void postInsert(MrTplEntity entity, PostInsertContext<MrTplEntity> context) {
    }

    @Override
    public void postUpdate(MrTplEntity entity, PostUpdateContext<MrTplEntity> context) {
    }

    @Override
    public void postDelete(MrTplEntity entity, PostDeleteContext<MrTplEntity> context) {
    }
    

}