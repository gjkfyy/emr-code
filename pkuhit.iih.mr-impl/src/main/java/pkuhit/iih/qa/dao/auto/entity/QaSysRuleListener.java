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
public class QaSysRuleListener implements EntityListener<QaSysRule> {

    @Override
    public void preInsert(QaSysRule entity, PreInsertContext<QaSysRule> context) {
		Session session = Session.get();
		entity.crtUserId = session.getUserId();
    	entity.crtTime = new Timestamp(System.currentTimeMillis());
    	entity.lastUpdUserId = session.getUserId();
    	entity.lastUpdTime = entity.crtTime;
    	entity.delF = (short)0;
      	entity.crtDeptCd = session.getDeptId();
    }

    @Override
    public void preUpdate(QaSysRule entity, PreUpdateContext<QaSysRule> context) {
		Session session = Session.get();
		entity.lastUpdUserId = session.getUserId();
    	entity.lastUpdTime = new Timestamp(System.currentTimeMillis());
    	entity.lastUpdDeptCd = session.getDeptId();    	
    }

    @Override
    public void preDelete(QaSysRule entity, PreDeleteContext<QaSysRule> context) {
    }

    @Override
    public void postInsert(QaSysRule entity, PostInsertContext<QaSysRule> context) {
    }

    @Override
    public void postUpdate(QaSysRule entity, PostUpdateContext<QaSysRule> context) {
    }

    @Override
    public void postDelete(QaSysRule entity, PostDeleteContext<QaSysRule> context) {
    }
}