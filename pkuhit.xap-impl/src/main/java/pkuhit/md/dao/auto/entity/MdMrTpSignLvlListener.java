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
public class MdMrTpSignLvlListener implements EntityListener<MdMrTpSignLvl> {

    @Override
    public void preInsert(MdMrTpSignLvl entity, PreInsertContext<MdMrTpSignLvl> context) {
		Session session = Session.get();
		entity.crtUserId = session.getUserId();
    	entity.crtTime = new Timestamp(System.currentTimeMillis());
    	entity.lastUpdUserId = session.getUserId();
    	entity.lastUpdTime = entity.crtTime;
    	entity.delF = (short)0;
    }

    @Override
    public void preUpdate(MdMrTpSignLvl entity, PreUpdateContext<MdMrTpSignLvl> context) {
		Session session = Session.get();
		entity.lastUpdUserId = session.getUserId();
    	entity.lastUpdTime = new Timestamp(System.currentTimeMillis());
    }

    @Override
    public void preDelete(MdMrTpSignLvl entity, PreDeleteContext<MdMrTpSignLvl> context) {
    }

    @Override
    public void postInsert(MdMrTpSignLvl entity, PostInsertContext<MdMrTpSignLvl> context) {
    }

    @Override
    public void postUpdate(MdMrTpSignLvl entity, PostUpdateContext<MdMrTpSignLvl> context) {
    }

    @Override
    public void postDelete(MdMrTpSignLvl entity, PostDeleteContext<MdMrTpSignLvl> context) {
    }
}