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
public class MdMrTpSegListener implements EntityListener<MdMrTpSeg> {

    @Override
    public void preInsert(MdMrTpSeg entity, PreInsertContext<MdMrTpSeg> context) {
		Session session = Session.get();
		entity.crtUserId = session.getUserId();
    	entity.crtTime = new Timestamp(System.currentTimeMillis());
    	entity.lastUpdUserId = session.getUserId();
    	entity.lastUpdTime = entity.crtTime;
    	entity.delF = (short)0;
    }

    @Override
    public void preUpdate(MdMrTpSeg entity, PreUpdateContext<MdMrTpSeg> context) {
		Session session = Session.get();
		entity.lastUpdUserId = session.getUserId();
    	entity.lastUpdTime = new Timestamp(System.currentTimeMillis());
    }

    @Override
    public void preDelete(MdMrTpSeg entity, PreDeleteContext<MdMrTpSeg> context) {
    }

    @Override
    public void postInsert(MdMrTpSeg entity, PostInsertContext<MdMrTpSeg> context) {
    }

    @Override
    public void postUpdate(MdMrTpSeg entity, PostUpdateContext<MdMrTpSeg> context) {
    }

    @Override
    public void postDelete(MdMrTpSeg entity, PostDeleteContext<MdMrTpSeg> context) {
    }
}