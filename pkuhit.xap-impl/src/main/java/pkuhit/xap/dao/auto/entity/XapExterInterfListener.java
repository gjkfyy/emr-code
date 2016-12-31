package pkuhit.xap.dao.auto.entity;

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
public class XapExterInterfListener implements EntityListener<XapExterInterf> {

    @Override
    public void preInsert(XapExterInterf entity, PreInsertContext<XapExterInterf> context) {
		Session session = Session.get();
		entity.crtUserId = session.getUserId();
    	entity.crtTime = new Timestamp(System.currentTimeMillis());
    	entity.lastUpdUserId = session.getUserId();
    	entity.lastUpdTime = entity.crtTime;
    	entity.delF = (short)0;
      	entity.crtDeptCd = session.getDeptId();
    }

    @Override
    public void preUpdate(XapExterInterf entity, PreUpdateContext<XapExterInterf> context) {
		Session session = Session.get();
		entity.lastUpdUserId = session.getUserId();
    	entity.lastUpdTime = new Timestamp(System.currentTimeMillis());
    	entity.lastUpdDeptCd = session.getDeptId();    	
    }

    @Override
    public void preDelete(XapExterInterf entity, PreDeleteContext<XapExterInterf> context) {
    }

    @Override
    public void postInsert(XapExterInterf entity, PostInsertContext<XapExterInterf> context) {
    }

    @Override
    public void postUpdate(XapExterInterf entity, PostUpdateContext<XapExterInterf> context) {
    }

    @Override
    public void postDelete(XapExterInterf entity, PostDeleteContext<XapExterInterf> context) {
    }
}