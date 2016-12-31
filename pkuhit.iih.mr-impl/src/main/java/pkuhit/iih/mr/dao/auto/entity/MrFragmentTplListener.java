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
public class MrFragmentTplListener implements EntityListener<MrFragmentTpl> {

    @Override
    public void preInsert(MrFragmentTpl entity, PreInsertContext<MrFragmentTpl> context) {
		Session session = Session.get();
		entity.crtUserId = session.getUserId();
    	entity.crtTime = new Timestamp(System.currentTimeMillis());
    	entity.lastUpdUserId = session.getUserId();
    	entity.lastUpdTime = entity.crtTime;
    	entity.delF = (short)0;
    }

    @Override
    public void preUpdate(MrFragmentTpl entity, PreUpdateContext<MrFragmentTpl> context) {
		Session session = Session.get();
		entity.lastUpdUserId = session.getUserId();
    	entity.lastUpdTime = new Timestamp(System.currentTimeMillis());
    }

    @Override
    public void preDelete(MrFragmentTpl entity, PreDeleteContext<MrFragmentTpl> context) {
    }

    @Override
    public void postInsert(MrFragmentTpl entity, PostInsertContext<MrFragmentTpl> context) {
    }

    @Override
    public void postUpdate(MrFragmentTpl entity, PostUpdateContext<MrFragmentTpl> context) {
    }

    @Override
    public void postDelete(MrFragmentTpl entity, PostDeleteContext<MrFragmentTpl> context) {
    }
}