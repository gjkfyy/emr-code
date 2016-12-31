package pkuhit.iih.mr.md.dao.auto.entity;

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
public class MdMrTpListener implements EntityListener<MdMrTp> {

    @Override
    public void preInsert(MdMrTp entity, PreInsertContext<MdMrTp> context) {
		Session session = Session.get();
		entity.crtUserId = session.getUserId();
    	entity.crtTime = new Timestamp(System.currentTimeMillis());
    	entity.lastUpdUserId = session.getUserId();
    	entity.lastUpdTime = entity.crtTime;
    	entity.delF = (short)0;
      	entity.crtDeptCd = session.getDeptId();
    }

    @Override
    public void preUpdate(MdMrTp entity, PreUpdateContext<MdMrTp> context) {
		Session session = Session.get();
		entity.lastUpdUserId = session.getUserId();
    	entity.lastUpdTime = new Timestamp(System.currentTimeMillis());
    	entity.lastUpdDeptCd = session.getDeptId();    	
    }

    @Override
    public void preDelete(MdMrTp entity, PreDeleteContext<MdMrTp> context) {
    }

    @Override
    public void postInsert(MdMrTp entity, PostInsertContext<MdMrTp> context) {
    }

    @Override
    public void postUpdate(MdMrTp entity, PostUpdateContext<MdMrTp> context) {
    }

    @Override
    public void postDelete(MdMrTp entity, PostDeleteContext<MdMrTp> context) {
    }
}