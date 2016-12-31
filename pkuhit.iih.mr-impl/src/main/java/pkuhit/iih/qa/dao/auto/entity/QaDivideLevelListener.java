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
public class QaDivideLevelListener implements EntityListener<QaDivideLevel> {

    @Override
    public void preInsert(QaDivideLevel entity, PreInsertContext<QaDivideLevel> context) {
		Session session = Session.get();
		entity.crtUserId = session.getUserId();
    	entity.crtTime = new Timestamp(System.currentTimeMillis());
    	entity.lastUpdUserId = session.getUserId();
    	entity.lastUpdTime = entity.crtTime;
    	entity.delF = (short)0;
      	entity.crtDeptCd = session.getDeptId();
    }

    @Override
    public void preUpdate(QaDivideLevel entity, PreUpdateContext<QaDivideLevel> context) {
		Session session = Session.get();
		entity.lastUpdUserId = session.getUserId();
    	entity.lastUpdTime = new Timestamp(System.currentTimeMillis());
    	entity.lastUpdDeptCd = session.getDeptId();    	
    }

    @Override
    public void preDelete(QaDivideLevel entity, PreDeleteContext<QaDivideLevel> context) {
    }

    @Override
    public void postInsert(QaDivideLevel entity, PostInsertContext<QaDivideLevel> context) {
    }

    @Override
    public void postUpdate(QaDivideLevel entity, PostUpdateContext<QaDivideLevel> context) {
    }

    @Override
    public void postDelete(QaDivideLevel entity, PostDeleteContext<QaDivideLevel> context) {
    }
}