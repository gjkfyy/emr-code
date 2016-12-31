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
public class MdMsgListener implements EntityListener<MdMsg> {

    @Override
    public void preInsert(MdMsg entity, PreInsertContext<MdMsg> context) {
		Session session = Session.get();
		entity.crtUserId = session.getUserId();
    	entity.crtTime = new Timestamp(System.currentTimeMillis());
    	entity.lastUpdUserId = session.getUserId();
    	entity.lastUpdTime = entity.crtTime;
    	entity.delF = (short)0;
    }

    @Override
    public void preUpdate(MdMsg entity, PreUpdateContext<MdMsg> context) {
		Session session = Session.get();
		entity.lastUpdUserId = session.getUserId();
    	entity.lastUpdTime = new Timestamp(System.currentTimeMillis());
    }

    @Override
    public void preDelete(MdMsg entity, PreDeleteContext<MdMsg> context) {
    }

    @Override
    public void postInsert(MdMsg entity, PostInsertContext<MdMsg> context) {
    }

    @Override
    public void postUpdate(MdMsg entity, PostUpdateContext<MdMsg> context) {
    }

    @Override
    public void postDelete(MdMsg entity, PostDeleteContext<MdMsg> context) {
    }
}