package pkuhit.md.dao.auto.entity;

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
public class MdGsListener implements EntityListener<MdGs> {

    @Override
    public void preInsert(MdGs entity, PreInsertContext<MdGs> context) {
		Session session = Session.get();
		entity.crtUserId = session.getUserId();
    	entity.crtTime = new Timestamp(System.currentTimeMillis());
    	entity.lastUpdUserId = session.getUserId();
    	entity.lastUpdTime = entity.crtTime;
    	entity.delF = (short)0;
      	entity.crtDeptCd = session.getDeptId();
    }

    @Override
    public void preUpdate(MdGs entity, PreUpdateContext<MdGs> context) {
		Session session = Session.get();
		entity.lastUpdUserId = session.getUserId();
    	entity.lastUpdTime = new Timestamp(System.currentTimeMillis());
    	entity.lastUpdDeptCd = session.getDeptId();    	
    }

    @Override
    public void preDelete(MdGs entity, PreDeleteContext<MdGs> context) {
    }

    @Override
    public void postInsert(MdGs entity, PostInsertContext<MdGs> context) {
    }

    @Override
    public void postUpdate(MdGs entity, PostUpdateContext<MdGs> context) {
    }

    @Override
    public void postDelete(MdGs entity, PostDeleteContext<MdGs> context) {
    }
}