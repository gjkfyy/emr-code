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
public class MdMetaElementValueListener implements EntityListener<MdMetaElementValue> {

    @Override
    public void preInsert(MdMetaElementValue entity, PreInsertContext<MdMetaElementValue> context) {
		Session session = Session.get();
		entity.crtUserId = session.getUserId();
    	entity.crtTime = new Timestamp(System.currentTimeMillis());
    	entity.lastUpdUserId = session.getUserId();
    	entity.lastUpdTime = entity.crtTime;
    	entity.delF = (short)0;
      	entity.crtDeptCd = session.getDeptId();
    }

    @Override
    public void preUpdate(MdMetaElementValue entity, PreUpdateContext<MdMetaElementValue> context) {
		Session session = Session.get();
		entity.lastUpdUserId = session.getUserId();
    	entity.lastUpdTime = new Timestamp(System.currentTimeMillis());
    	entity.lastUpdDeptCd = session.getDeptId();    	
    }

    @Override
    public void preDelete(MdMetaElementValue entity, PreDeleteContext<MdMetaElementValue> context) {
    }

    @Override
    public void postInsert(MdMetaElementValue entity, PostInsertContext<MdMetaElementValue> context) {
    }

    @Override
    public void postUpdate(MdMetaElementValue entity, PostUpdateContext<MdMetaElementValue> context) {
    }

    @Override
    public void postDelete(MdMetaElementValue entity, PostDeleteContext<MdMetaElementValue> context) {
    }
}