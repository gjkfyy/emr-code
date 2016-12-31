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
public class MdDiListener implements EntityListener<MdDi> {

    @Override
    public void preInsert(MdDi entity, PreInsertContext<MdDi> context) {
		Session session = Session.get();
		entity.crtUserId = session.getUserId();
    	entity.crtTime = new Timestamp(System.currentTimeMillis());
    	entity.lastUpdUserId = session.getUserId();
    	entity.lastUpdTime = entity.crtTime;
    	entity.delF = (short)0;
      	entity.crtDeptCd = session.getDeptId();
    }

    @Override
    public void preUpdate(MdDi entity, PreUpdateContext<MdDi> context) {
		Session session = Session.get();
		entity.lastUpdUserId = session.getUserId();
    	entity.lastUpdTime = new Timestamp(System.currentTimeMillis());
    	entity.lastUpdDeptCd = session.getDeptId();    	
    }

    @Override
    public void preDelete(MdDi entity, PreDeleteContext<MdDi> context) {
    }

    @Override
    public void postInsert(MdDi entity, PostInsertContext<MdDi> context) {
    }

    @Override
    public void postUpdate(MdDi entity, PostUpdateContext<MdDi> context) {
    }

    @Override
    public void postDelete(MdDi entity, PostDeleteContext<MdDi> context) {
    }
}