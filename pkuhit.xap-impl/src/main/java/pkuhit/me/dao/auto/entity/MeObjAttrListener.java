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
public class MeObjAttrListener implements EntityListener<MeObjAttr> {

    @Override
    public void preInsert(MeObjAttr entity, PreInsertContext<MeObjAttr> context) {
		Session session = Session.get();
		entity.crtUserId = session.getUserId();
    	entity.crtTime = new Timestamp(System.currentTimeMillis());
    	entity.lastUpdUserId = session.getUserId();
    	entity.lastUpdTime = entity.crtTime;
    	entity.delF = (short)0;
      	entity.crtDeptCd = session.getDeptId();
    }

    @Override
    public void preUpdate(MeObjAttr entity, PreUpdateContext<MeObjAttr> context) {
		Session session = Session.get();
		entity.lastUpdUserId = session.getUserId();
    	entity.lastUpdTime = new Timestamp(System.currentTimeMillis());
    	entity.lastUpdDeptCd = session.getDeptId();    	
    }

    @Override
    public void preDelete(MeObjAttr entity, PreDeleteContext<MeObjAttr> context) {
    }

    @Override
    public void postInsert(MeObjAttr entity, PostInsertContext<MeObjAttr> context) {
    }

    @Override
    public void postUpdate(MeObjAttr entity, PostUpdateContext<MeObjAttr> context) {
    }

    @Override
    public void postDelete(MeObjAttr entity, PostDeleteContext<MeObjAttr> context) {
    }
}