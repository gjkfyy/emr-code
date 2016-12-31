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
public class MrAmrListener implements EntityListener<MrAmr> {

    @Override
    public void preInsert(MrAmr entity, PreInsertContext<MrAmr> context) {
		Session session = Session.get();
		entity.crtUserId = session.getUserId();
    	entity.crtTime = new Timestamp(System.currentTimeMillis());
    	entity.lastUpdUserId = session.getUserId();
    	entity.lastUpdTime = entity.crtTime;
    	entity.delF = (short)0;
      	entity.crtDeptCd = session.getDeptId();
    }

    @Override
    public void preUpdate(MrAmr entity, PreUpdateContext<MrAmr> context) {
    	try{
    		Session session = Session.get();
    		entity.lastUpdUserId = session.getUserId();
        	entity.lastUpdTime = new Timestamp(System.currentTimeMillis());
        	entity.lastUpdDeptCd = session.getDeptId();   
    	}catch(Exception e){
    		
    	}
    }

    @Override
    public void preDelete(MrAmr entity, PreDeleteContext<MrAmr> context) {
    }

    @Override
    public void postInsert(MrAmr entity, PostInsertContext<MrAmr> context) {
    }

    @Override
    public void postUpdate(MrAmr entity, PostUpdateContext<MrAmr> context) {
    }

    @Override
    public void postDelete(MrAmr entity, PostDeleteContext<MrAmr> context) {
    }
}