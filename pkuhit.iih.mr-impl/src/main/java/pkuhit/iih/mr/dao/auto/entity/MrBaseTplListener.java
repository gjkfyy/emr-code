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
public class MrBaseTplListener implements EntityListener<MrBaseTpl> {

    @Override
    public void preInsert(MrBaseTpl entity, PreInsertContext<MrBaseTpl> context) {
		Session session = Session.get();
		entity.crtUserId = session.getUserId();
    	entity.crtTime = new Timestamp(System.currentTimeMillis());
    	entity.lastUpdUserId = session.getUserId();
    	entity.lastUpdTime = entity.crtTime;
    	entity.delF = (short)0;
      	entity.crtDeptCd = session.getDeptId();
    }

    @Override
    public void preUpdate(MrBaseTpl entity, PreUpdateContext<MrBaseTpl> context) {
		Session session = Session.get();
		entity.lastUpdUserId = session.getUserId();
    	entity.lastUpdTime = new Timestamp(System.currentTimeMillis());
    	entity.lastUpdDeptCd = session.getDeptId();    	
    }

    @Override
    public void preDelete(MrBaseTpl entity, PreDeleteContext<MrBaseTpl> context) {
    }

    @Override
    public void postInsert(MrBaseTpl entity, PostInsertContext<MrBaseTpl> context) {
    }

    @Override
    public void postUpdate(MrBaseTpl entity, PostUpdateContext<MrBaseTpl> context) {
    }

    @Override
    public void postDelete(MrBaseTpl entity, PostDeleteContext<MrBaseTpl> context) {
    }
}