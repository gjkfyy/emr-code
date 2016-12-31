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
public class XapTaskListener implements EntityListener<XapTask> {

    @Override
    public void preInsert(XapTask entity, PreInsertContext<XapTask> context) {
		/*Session session = Session.get();
		entity.crtUserId = session.getUserId();*/
    	entity.crtTime = new Timestamp(System.currentTimeMillis());
    	//entity.lastUpdUserId = session.getUserId();
    	entity.lastUpdTime = entity.crtTime;
    	entity.delF = (short)0;
      	//entity.crtDeptCd = session.getDeptId();
    }

    @Override
    public void preUpdate(XapTask entity, PreUpdateContext<XapTask> context) {
		Session session = Session.get();
		entity.lastUpdUserId = session.getUserId();
    	entity.lastUpdTime = new Timestamp(System.currentTimeMillis());
    	entity.lastUpdDeptCd = session.getDeptId();    	
    }

    @Override
    public void preDelete(XapTask entity, PreDeleteContext<XapTask> context) {
    }

    @Override
    public void postInsert(XapTask entity, PostInsertContext<XapTask> context) {
    }

    @Override
    public void postUpdate(XapTask entity, PostUpdateContext<XapTask> context) {
    }

    @Override
    public void postDelete(XapTask entity, PostDeleteContext<XapTask> context) {
    }
}