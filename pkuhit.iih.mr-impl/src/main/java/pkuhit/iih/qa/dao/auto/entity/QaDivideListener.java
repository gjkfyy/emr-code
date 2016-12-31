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
public class QaDivideListener implements EntityListener<QaDivide> {

    @Override
    public void preInsert(QaDivide entity, PreInsertContext<QaDivide> context) {
		//Session session = Session.get();
		//entity.crtUserId = session.getUserId();
    	entity.crtTime = new Timestamp(System.currentTimeMillis());
    	//entity.lastUpdUserId = session.getUserId();
    	entity.lastUpdTime = entity.crtTime;
    	entity.delF = (short)0;
      	//entity.crtDeptCd = session.getDeptId();
    }

    @Override
    public void preUpdate(QaDivide entity, PreUpdateContext<QaDivide> context) {
		Session session = Session.get();
		entity.lastUpdUserId = session.getUserId();
    	entity.lastUpdTime = new Timestamp(System.currentTimeMillis());
    	entity.lastUpdDeptCd = session.getDeptId();    	
    }

    @Override
    public void preDelete(QaDivide entity, PreDeleteContext<QaDivide> context) {
    }

    @Override
    public void postInsert(QaDivide entity, PostInsertContext<QaDivide> context) {
    }

    @Override
    public void postUpdate(QaDivide entity, PostUpdateContext<QaDivide> context) {
    }

    @Override
    public void postDelete(QaDivide entity, PostDeleteContext<QaDivide> context) {
    }
}