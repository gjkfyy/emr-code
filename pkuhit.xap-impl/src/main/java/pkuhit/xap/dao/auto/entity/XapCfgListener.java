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
public class XapCfgListener implements EntityListener<XapCfg> {

    @Override
    public void preInsert(XapCfg entity, PreInsertContext<XapCfg> context) {
		Session session = Session.get();
		entity.crtUserId = session.getUserId();
    	entity.crtTime = new Timestamp(System.currentTimeMillis());
    	entity.lastUpdUserId = session.getUserId();
    	entity.lastUpdTime = entity.crtTime;
    	entity.delF = (short)0;
      	entity.crtDeptCd = session.getDeptId();
    }

    @Override
    public void preUpdate(XapCfg entity, PreUpdateContext<XapCfg> context) {
		Session session = Session.get();
		entity.lastUpdUserId = session.getUserId();
    	entity.lastUpdTime = new Timestamp(System.currentTimeMillis());
    	entity.lastUpdDeptCd = session.getDeptId();    	
    }

    @Override
    public void preDelete(XapCfg entity, PreDeleteContext<XapCfg> context) {
    }

    @Override
    public void postInsert(XapCfg entity, PostInsertContext<XapCfg> context) {
    }

    @Override
    public void postUpdate(XapCfg entity, PostUpdateContext<XapCfg> context) {
    }

    @Override
    public void postDelete(XapCfg entity, PostDeleteContext<XapCfg> context) {
    }
}