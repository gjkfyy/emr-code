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
public class MrAmrGroupListener implements EntityListener<MrAmrGroup> {

    @Override
    public void preInsert(MrAmrGroup entity, PreInsertContext<MrAmrGroup> context) {
		Session session = Session.get();
		entity.crtUserId = session.getUserId();
    	entity.crtTime = new Timestamp(System.currentTimeMillis());
    	entity.lastUpdUserId = session.getUserId();
    	entity.lastUpdTime = entity.crtTime;
    	entity.delF = (short)0;
      	entity.crtDeptCd = session.getDeptId();
    }

    @Override
    public void preUpdate(MrAmrGroup entity, PreUpdateContext<MrAmrGroup> context) {
		Session session = Session.get();
		entity.lastUpdUserId = session.getUserId();
    	entity.lastUpdTime = new Timestamp(System.currentTimeMillis());
    	entity.lastUpdDeptCd = session.getDeptId();    	
    }

    @Override
    public void preDelete(MrAmrGroup entity, PreDeleteContext<MrAmrGroup> context) {
    }

    @Override
    public void postInsert(MrAmrGroup entity, PostInsertContext<MrAmrGroup> context) {
    }

    @Override
    public void postUpdate(MrAmrGroup entity, PostUpdateContext<MrAmrGroup> context) {
    }

    @Override
    public void postDelete(MrAmrGroup entity, PostDeleteContext<MrAmrGroup> context) {
    }
}