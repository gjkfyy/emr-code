package pkuhit.org.dao.auto.entity;

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
public class EiNisWardConfigListener implements EntityListener<EiNisWardConfig> {

    @Override
    public void preInsert(EiNisWardConfig entity, PreInsertContext<EiNisWardConfig> context) {
		Session session = Session.get();
		entity.crtUserId = session.getUserId();
    	entity.crtTime = new Timestamp(System.currentTimeMillis());
    	entity.lastUpdUserId = session.getUserId();
    	entity.lastUpdTime = entity.crtTime;
    	entity.delF = (short)0;
      	entity.crtDeptCd = session.getDeptId();
    }

    @Override
    public void preUpdate(EiNisWardConfig entity, PreUpdateContext<EiNisWardConfig> context) {
		Session session = Session.get();
		entity.lastUpdUserId = session.getUserId();
    	entity.lastUpdTime = new Timestamp(System.currentTimeMillis());
    	entity.lastUpdDeptCd = session.getDeptId();    	
    }

    @Override
    public void preDelete(EiNisWardConfig entity, PreDeleteContext<EiNisWardConfig> context) {
    }

    @Override
    public void postInsert(EiNisWardConfig entity, PostInsertContext<EiNisWardConfig> context) {
    }

    @Override
    public void postUpdate(EiNisWardConfig entity, PostUpdateContext<EiNisWardConfig> context) {
    }

    @Override
    public void postDelete(EiNisWardConfig entity, PostDeleteContext<EiNisWardConfig> context) {
    }
}