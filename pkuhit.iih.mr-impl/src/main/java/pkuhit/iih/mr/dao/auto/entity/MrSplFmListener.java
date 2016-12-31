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
public class MrSplFmListener implements EntityListener<MrSplFm> {

    @Override
    public void preInsert(MrSplFm entity, PreInsertContext<MrSplFm> context) {
		Session session = Session.get();
		entity.crtUserId = session.getUserId();
    	entity.crtTime = new Timestamp(System.currentTimeMillis());
    	entity.lastUpdUserId = session.getUserId();
    	entity.lastUpdTime = entity.crtTime;
    	entity.delF = (short)0;
      	entity.crtDeptCd = session.getDeptId();
    }

    @Override
    public void preUpdate(MrSplFm entity, PreUpdateContext<MrSplFm> context) {
		Session session = Session.get();
		entity.lastUpdUserId = session.getUserId();
    	entity.lastUpdTime = new Timestamp(System.currentTimeMillis());
    	entity.lastUpdDeptCd = session.getDeptId();    	
    }

    @Override
    public void preDelete(MrSplFm entity, PreDeleteContext<MrSplFm> context) {
    }

    @Override
    public void postInsert(MrSplFm entity, PostInsertContext<MrSplFm> context) {
    }

    @Override
    public void postUpdate(MrSplFm entity, PostUpdateContext<MrSplFm> context) {
    }

    @Override
    public void postDelete(MrSplFm entity, PostDeleteContext<MrSplFm> context) {
    }
}