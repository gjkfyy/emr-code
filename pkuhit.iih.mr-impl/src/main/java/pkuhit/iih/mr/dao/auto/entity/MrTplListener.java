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
public class MrTplListener implements EntityListener<MrTpl> {

    @Override
    public void preInsert(MrTpl entity, PreInsertContext<MrTpl> context) {
		Session session = Session.get();
		entity.crtUserId = session.getUserId();
    	entity.crtTime = new Timestamp(System.currentTimeMillis());
    	entity.lastUpdUserId = session.getUserId();
    	entity.lastUpdTime = entity.crtTime;
    	entity.delF = (short)0;
      	entity.crtDeptCd = session.getDeptId();
    }

    @Override
    public void preUpdate(MrTpl entity, PreUpdateContext<MrTpl> context) {
		Session session = Session.get();
		entity.lastUpdUserId = session.getUserId();
    	entity.lastUpdTime = new Timestamp(System.currentTimeMillis());
    	entity.lastUpdDeptCd = session.getDeptId();    	
    }

    @Override
    public void preDelete(MrTpl entity, PreDeleteContext<MrTpl> context) {
    }

    @Override
    public void postInsert(MrTpl entity, PostInsertContext<MrTpl> context) {
    }

    @Override
    public void postUpdate(MrTpl entity, PostUpdateContext<MrTpl> context) {
    }

    @Override
    public void postDelete(MrTpl entity, PostDeleteContext<MrTpl> context) {
    }
}