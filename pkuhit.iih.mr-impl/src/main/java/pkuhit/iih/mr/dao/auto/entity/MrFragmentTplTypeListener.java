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
public class MrFragmentTplTypeListener implements EntityListener<MrFragmentTplType> {

    @Override
    public void preInsert(MrFragmentTplType entity, PreInsertContext<MrFragmentTplType> context) {
		Session session = Session.get();
		entity.crtUserId = session.getUserId();
    	entity.crtTime = new Timestamp(System.currentTimeMillis());
    	entity.lastUpdUserId = session.getUserId();
    	entity.lastUpdTime = entity.crtTime;
    	entity.delF = (short)0;
    }

    @Override
    public void preUpdate(MrFragmentTplType entity, PreUpdateContext<MrFragmentTplType> context) {
		Session session = Session.get();
		entity.lastUpdUserId = session.getUserId();
    	entity.lastUpdTime = new Timestamp(System.currentTimeMillis());
    }

    @Override
    public void preDelete(MrFragmentTplType entity, PreDeleteContext<MrFragmentTplType> context) {
    }

    @Override
    public void postInsert(MrFragmentTplType entity, PostInsertContext<MrFragmentTplType> context) {
    }

    @Override
    public void postUpdate(MrFragmentTplType entity, PostUpdateContext<MrFragmentTplType> context) {
    }

    @Override
    public void postDelete(MrFragmentTplType entity, PostDeleteContext<MrFragmentTplType> context) {
    }
}