package pkuhit.md.dao.auto.entity;

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
public class MdBizRoleListener implements EntityListener<MdBizRole> {

    @Override
    public void preInsert(MdBizRole entity, PreInsertContext<MdBizRole> context) {
		Session session = Session.get();
		entity.crtUserId = session.getUserId();
    	entity.crtTime = new Timestamp(System.currentTimeMillis());
    	entity.lastUpdUserId = session.getUserId();
    	entity.lastUpdTime = entity.crtTime;
    	entity.delF = (short)0;
    }

    @Override
    public void preUpdate(MdBizRole entity, PreUpdateContext<MdBizRole> context) {
		Session session = Session.get();
		entity.lastUpdUserId = session.getUserId();
    	entity.lastUpdTime = new Timestamp(System.currentTimeMillis());
    }

    @Override
    public void preDelete(MdBizRole entity, PreDeleteContext<MdBizRole> context) {
    }

    @Override
    public void postInsert(MdBizRole entity, PostInsertContext<MdBizRole> context) {
    }

    @Override
    public void postUpdate(MdBizRole entity, PostUpdateContext<MdBizRole> context) {
    }

    @Override
    public void postDelete(MdBizRole entity, PostDeleteContext<MdBizRole> context) {
    }
}