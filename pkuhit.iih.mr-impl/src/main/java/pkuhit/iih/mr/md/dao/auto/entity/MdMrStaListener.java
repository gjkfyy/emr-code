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
public class MdMrStaListener implements EntityListener<MdMrSta> {

    @Override
    public void preInsert(MdMrSta entity, PreInsertContext<MdMrSta> context) {
		Session session = Session.get();
		entity.crtUserId = session.getUserId();
    	entity.crtTime = new Timestamp(System.currentTimeMillis());
    	entity.lastUpdUserId = session.getUserId();
    	entity.lastUpdTime = entity.crtTime;
    	entity.delF = (short)0;
      	entity.crtDeptCd = session.getDeptId();
    }

    @Override
    public void preUpdate(MdMrSta entity, PreUpdateContext<MdMrSta> context) {
		Session session = Session.get();
		entity.lastUpdUserId = session.getUserId();
    	entity.lastUpdTime = new Timestamp(System.currentTimeMillis());
    	entity.lastUpdDeptCd = session.getDeptId();    	
    }

    @Override
    public void preDelete(MdMrSta entity, PreDeleteContext<MdMrSta> context) {
    }

    @Override
    public void postInsert(MdMrSta entity, PostInsertContext<MdMrSta> context) {
    }

    @Override
    public void postUpdate(MdMrSta entity, PostUpdateContext<MdMrSta> context) {
    }

    @Override
    public void postDelete(MdMrSta entity, PostDeleteContext<MdMrSta> context) {
    }
}