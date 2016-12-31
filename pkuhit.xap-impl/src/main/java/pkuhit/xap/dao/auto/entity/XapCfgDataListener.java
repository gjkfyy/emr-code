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
public class XapCfgDataListener implements EntityListener<XapCfgData> {

    @Override
    public void preInsert(XapCfgData entity, PreInsertContext<XapCfgData> context) {
		Session session = Session.get();
		entity.crtUserId = session.getUserId();
    	entity.crtTime = new Timestamp(System.currentTimeMillis());
    	entity.lastUpdUserId = session.getUserId();
    	entity.lastUpdTime = entity.crtTime;
    	entity.delF = (short)0;
    }

    @Override
    public void preUpdate(XapCfgData entity, PreUpdateContext<XapCfgData> context) {
		Session session = Session.get();
		entity.lastUpdUserId = session.getUserId();
    	entity.lastUpdTime = new Timestamp(System.currentTimeMillis());
    }

    @Override
    public void preDelete(XapCfgData entity, PreDeleteContext<XapCfgData> context) {
    }

    @Override
    public void postInsert(XapCfgData entity, PostInsertContext<XapCfgData> context) {
    }

    @Override
    public void postUpdate(XapCfgData entity, PostUpdateContext<XapCfgData> context) {
    }

    @Override
    public void postDelete(XapCfgData entity, PostDeleteContext<XapCfgData> context) {
    }
}