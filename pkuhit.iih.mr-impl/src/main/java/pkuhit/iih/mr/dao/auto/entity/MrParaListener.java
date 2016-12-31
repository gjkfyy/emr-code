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
public class MrParaListener implements EntityListener<MrPara> {

    @Override
    public void preInsert(MrPara entity, PreInsertContext<MrPara> context) {
//		Session session = Session.get();
//		entity.crtUserId = session.getUserId();
    	entity.crtTime = new Timestamp(System.currentTimeMillis());
//    	entity.lastUpdUserId = session.getUserId();
    	entity.lastUpdTime = entity.crtTime;
    	entity.delF = (short)0;
//      	entity.crtDeptCd = session.getDeptId();
    }

    @Override
    public void preUpdate(MrPara entity, PreUpdateContext<MrPara> context) {
//		Session session = Session.get();
//		entity.lastUpdUserId = session.getUserId();
    	entity.lastUpdTime = new Timestamp(System.currentTimeMillis());
//    	entity.lastUpdDeptCd = session.getDeptId();    	
    }

    @Override
    public void preDelete(MrPara entity, PreDeleteContext<MrPara> context) {
    }

    @Override
    public void postInsert(MrPara entity, PostInsertContext<MrPara> context) {
    }

    @Override
    public void postUpdate(MrPara entity, PostUpdateContext<MrPara> context) {
    }

    @Override
    public void postDelete(MrPara entity, PostDeleteContext<MrPara> context) {
    }
}