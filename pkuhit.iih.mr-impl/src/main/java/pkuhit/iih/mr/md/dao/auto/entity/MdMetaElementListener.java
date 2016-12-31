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
public class MdMetaElementListener implements EntityListener<MdMetaElement> {

    @Override
    public void preInsert(MdMetaElement entity, PreInsertContext<MdMetaElement> context) {
		Session session = Session.get();
		entity.crtUserId = session.getUserId();
    	entity.crtTime = new Timestamp(System.currentTimeMillis());
    	entity.lastUpdUserId = session.getUserId();
    	entity.lastUpdTime = entity.crtTime;
    	entity.delF = (short)0;
      	entity.crtDeptCd = session.getDeptId();
    }

    @Override
    public void preUpdate(MdMetaElement entity, PreUpdateContext<MdMetaElement> context) {
		Session session = Session.get();
		entity.lastUpdUserId = session.getUserId();
    	entity.lastUpdTime = new Timestamp(System.currentTimeMillis());
    	entity.lastUpdDeptCd = session.getDeptId();    	
    }

    @Override
    public void preDelete(MdMetaElement entity, PreDeleteContext<MdMetaElement> context) {
    }

    @Override
    public void postInsert(MdMetaElement entity, PostInsertContext<MdMetaElement> context) {
    }

    @Override
    public void postUpdate(MdMetaElement entity, PostUpdateContext<MdMetaElement> context) {
    }

    @Override
    public void postDelete(MdMetaElement entity, PostDeleteContext<MdMetaElement> context) {
    }
}