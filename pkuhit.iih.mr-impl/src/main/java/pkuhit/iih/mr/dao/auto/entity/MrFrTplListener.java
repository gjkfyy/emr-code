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
public class MrFrTplListener implements EntityListener<MrFrTpl> {

    @Override
    public void preInsert(MrFrTpl entity, PreInsertContext<MrFrTpl> context) {
		Session session = Session.get();
		entity.crtUserId = session.getUserId();
    	entity.crtTime = new Timestamp(System.currentTimeMillis());
    	entity.lastUpdUserId = session.getUserId();
    	entity.lastUpdTime = entity.crtTime;
    	entity.delF = (short)0;
      	entity.crtDeptCd = session.getDeptId();
    }

    @Override
    public void preUpdate(MrFrTpl entity, PreUpdateContext<MrFrTpl> context) {
		Session session = Session.get();
		entity.lastUpdUserId = session.getUserId();
    	entity.lastUpdTime = new Timestamp(System.currentTimeMillis());
    	entity.lastUpdDeptCd = session.getDeptId();    	
    }

    @Override
    public void preDelete(MrFrTpl entity, PreDeleteContext<MrFrTpl> context) {
    }

    @Override
    public void postInsert(MrFrTpl entity, PostInsertContext<MrFrTpl> context) {
    }

    @Override
    public void postUpdate(MrFrTpl entity, PostUpdateContext<MrFrTpl> context) {
    }

    @Override
    public void postDelete(MrFrTpl entity, PostDeleteContext<MrFrTpl> context) {
    }
}