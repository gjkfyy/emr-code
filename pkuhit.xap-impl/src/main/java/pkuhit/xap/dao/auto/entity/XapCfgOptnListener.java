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
public class XapCfgOptnListener implements EntityListener<XapCfgOptn> {

    @Override
    public void preInsert(XapCfgOptn entity, PreInsertContext<XapCfgOptn> context) {
		Session session = Session.get();
		entity.crtUserId = session.getUserId();
    	entity.crtTime = new Timestamp(System.currentTimeMillis());
    	entity.lastUpdUserId = session.getUserId();
    	entity.lastUpdTime = entity.crtTime;
    	entity.delF = (short)0;
    }

    @Override
    public void preUpdate(XapCfgOptn entity, PreUpdateContext<XapCfgOptn> context) {
		Session session = Session.get();
		entity.lastUpdUserId = session.getUserId();
    	entity.lastUpdTime = new Timestamp(System.currentTimeMillis());
    }

    @Override
    public void preDelete(XapCfgOptn entity, PreDeleteContext<XapCfgOptn> context) {
    }

    @Override
    public void postInsert(XapCfgOptn entity, PostInsertContext<XapCfgOptn> context) {
    }

    @Override
    public void postUpdate(XapCfgOptn entity, PostUpdateContext<XapCfgOptn> context) {
    }

    @Override
    public void postDelete(XapCfgOptn entity, PostDeleteContext<XapCfgOptn> context) {
    }
}