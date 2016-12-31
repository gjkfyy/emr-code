package pkuhit.xap.dao.auto.entity;

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
public class XapStalogListener implements EntityListener<XapStalog> {

    @Override
    public void preInsert(XapStalog entity, PreInsertContext<XapStalog> context) {
		Session session = Session.get();
		entity.crtUserId = session.getUserId();
    	entity.crtTime = new Timestamp(System.currentTimeMillis());
    	entity.lastUpdUserId = session.getUserId();
    	entity.lastUpdTime = entity.crtTime;
    	entity.delF = (short)0;
    }

    @Override
    public void preUpdate(XapStalog entity, PreUpdateContext<XapStalog> context) {
		Session session = Session.get();
		entity.lastUpdUserId = session.getUserId();
    	entity.lastUpdTime = new Timestamp(System.currentTimeMillis());
    }

    @Override
    public void preDelete(XapStalog entity, PreDeleteContext<XapStalog> context) {
    }

    @Override
    public void postInsert(XapStalog entity, PostInsertContext<XapStalog> context) {
    }

    @Override
    public void postUpdate(XapStalog entity, PostUpdateContext<XapStalog> context) {
    }

    @Override
    public void postDelete(XapStalog entity, PostDeleteContext<XapStalog> context) {
    }
}