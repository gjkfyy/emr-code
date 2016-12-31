package pkuhit.me.dao.auto.entity;

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
public class MeXsvListener implements EntityListener<MeXsv> {

    @Override
    public void preInsert(MeXsv entity, PreInsertContext<MeXsv> context) {
		Session session = Session.get();
		entity.crtUserId = session.getUserId();
    	entity.crtTime = new Timestamp(System.currentTimeMillis());
    	entity.lastUpdUserId = session.getUserId();
    	entity.lastUpdTime = entity.crtTime;
    	entity.delF = (short)0;
      	entity.crtDeptCd = session.getDeptId();
    }

    @Override
    public void preUpdate(MeXsv entity, PreUpdateContext<MeXsv> context) {
		Session session = Session.get();
		entity.lastUpdUserId = session.getUserId();
    	entity.lastUpdTime = new Timestamp(System.currentTimeMillis());
    	entity.lastUpdDeptCd = session.getDeptId();    	
    }

    @Override
    public void preDelete(MeXsv entity, PreDeleteContext<MeXsv> context) {
    }

    @Override
    public void postInsert(MeXsv entity, PostInsertContext<MeXsv> context) {
    }

    @Override
    public void postUpdate(MeXsv entity, PostUpdateContext<MeXsv> context) {
    }

    @Override
    public void postDelete(MeXsv entity, PostDeleteContext<MeXsv> context) {
    }
}