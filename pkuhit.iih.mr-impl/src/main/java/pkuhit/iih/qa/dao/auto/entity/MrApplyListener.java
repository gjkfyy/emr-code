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
public class MrApplyListener implements EntityListener<MrApply> {

    @Override
    public void preInsert(MrApply entity, PreInsertContext<MrApply> context) {
//		Session session = Session.get();
//		entity.crtUserId = session.getUserId();
    	entity.crtTime = new Timestamp(System.currentTimeMillis());
//    	entity.lastUpdUserId = session.getUserId();
    	entity.lastUpdTime = entity.crtTime;
    	entity.delF = (short)0;
//      	entity.crtDeptCd = session.getDeptId();
    }

    @Override
    public void preUpdate(MrApply entity, PreUpdateContext<MrApply> context) {
		Session session = Session.get();
		entity.lastUpdUserId = session.getUserId();
    	entity.lastUpdTime = new Timestamp(System.currentTimeMillis());
    	entity.lastUpdDeptCd = session.getDeptId();    	
    }

    @Override
    public void preDelete(MrApply entity, PreDeleteContext<MrApply> context) {
    }

    @Override
    public void postInsert(MrApply entity, PostInsertContext<MrApply> context) {
    }

    @Override
    public void postUpdate(MrApply entity, PostUpdateContext<MrApply> context) {
    }

    @Override
    public void postDelete(MrApply entity, PostDeleteContext<MrApply> context) {
    }
}