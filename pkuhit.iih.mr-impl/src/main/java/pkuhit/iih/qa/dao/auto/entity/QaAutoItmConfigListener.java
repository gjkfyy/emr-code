package pkuhit.iih.qa.dao.auto.entity;

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
public class QaAutoItmConfigListener implements EntityListener<QaAutoItmConfig> {

    @Override
    public void preInsert(QaAutoItmConfig entity, PreInsertContext<QaAutoItmConfig> context) {
		Session session = Session.get();
		entity.crtUserId = session.getUserId();
    	entity.crtTime = new Timestamp(System.currentTimeMillis());
    	entity.lastUpdUserId = session.getUserId();
    	entity.lastUpdTime = entity.crtTime;
    	entity.delF = (short)0;
      	entity.crtDeptCd = session.getDeptId();
    }

    @Override
    public void preUpdate(QaAutoItmConfig entity, PreUpdateContext<QaAutoItmConfig> context) {
		Session session = Session.get();
		entity.lastUpdUserId = session.getUserId();
    	entity.lastUpdTime = new Timestamp(System.currentTimeMillis());
    	entity.lastUpdDeptCd = session.getDeptId();    	
    }

    @Override
    public void preDelete(QaAutoItmConfig entity, PreDeleteContext<QaAutoItmConfig> context) {
    }

    @Override
    public void postInsert(QaAutoItmConfig entity, PostInsertContext<QaAutoItmConfig> context) {
    }

    @Override
    public void postUpdate(QaAutoItmConfig entity, PostUpdateContext<QaAutoItmConfig> context) {
    }

    @Override
    public void postDelete(QaAutoItmConfig entity, PostDeleteContext<QaAutoItmConfig> context) {
    }
}