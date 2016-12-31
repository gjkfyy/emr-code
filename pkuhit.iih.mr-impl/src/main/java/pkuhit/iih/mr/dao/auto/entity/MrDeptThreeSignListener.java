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
public class MrDeptThreeSignListener implements EntityListener<MrDeptThreeSign> {

    @Override
    public void preInsert(MrDeptThreeSign entity, PreInsertContext<MrDeptThreeSign> context) {
		Session session = Session.get();
		entity.crtUserId = session.getUserId();
    	entity.crtTime = new Timestamp(System.currentTimeMillis());
    	entity.lastUpdUserId = session.getUserId();
    	entity.lastUpdTime = entity.crtTime;
    	entity.delF = (short)0;
      	entity.crtDeptCd = session.getDeptId();
    }

    @Override
    public void preUpdate(MrDeptThreeSign entity, PreUpdateContext<MrDeptThreeSign> context) {
		Session session = Session.get();
		entity.lastUpdUserId = session.getUserId();
    	entity.lastUpdTime = new Timestamp(System.currentTimeMillis());
    	entity.lastUpdDeptCd = session.getDeptId();    	
    }

    @Override
    public void preDelete(MrDeptThreeSign entity, PreDeleteContext<MrDeptThreeSign> context) {
    }

    @Override
    public void postInsert(MrDeptThreeSign entity, PostInsertContext<MrDeptThreeSign> context) {
    }

    @Override
    public void postUpdate(MrDeptThreeSign entity, PostUpdateContext<MrDeptThreeSign> context) {
    }

    @Override
    public void postDelete(MrDeptThreeSign entity, PostDeleteContext<MrDeptThreeSign> context) {
    }
}