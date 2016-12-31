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
public class MrDocValueListener implements EntityListener<MrDocValue> {

    @Override
    public void preInsert(MrDocValue entity, PreInsertContext<MrDocValue> context) {
		Session session = Session.get();
		entity.crtUserId = session.getUserId();
    	entity.crtTime = new Timestamp(System.currentTimeMillis());
    	entity.lastUpdUserId = session.getUserId();
    	entity.lastUpdTime = entity.crtTime;
    	entity.delF = (short)0;
      	entity.crtDeptCd = session.getDeptId();
    }

    @Override
    public void preUpdate(MrDocValue entity, PreUpdateContext<MrDocValue> context) {
		Session session = Session.get();
		entity.lastUpdUserId = session.getUserId();
    	entity.lastUpdTime = new Timestamp(System.currentTimeMillis());
    	entity.lastUpdDeptCd = session.getDeptId();    	
    }

    @Override
    public void preDelete(MrDocValue entity, PreDeleteContext<MrDocValue> context) {
    }

    @Override
    public void postInsert(MrDocValue entity, PostInsertContext<MrDocValue> context) {
    }

    @Override
    public void postUpdate(MrDocValue entity, PostUpdateContext<MrDocValue> context) {
    }

    @Override
    public void postDelete(MrDocValue entity, PostDeleteContext<MrDocValue> context) {
    }
}