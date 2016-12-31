package pkuhit.iih.qa.dao.auto.entity;

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
public class QaSysAmrRankScrListener implements EntityListener<QaSysAmrRankScr> {

    @Override
    public void preInsert(QaSysAmrRankScr entity, PreInsertContext<QaSysAmrRankScr> context) {
		Session session = Session.get();
//		entity.crtUserId = session.getUserId();
//    	entity.crtTime = new Timestamp(System.currentTimeMillis());
//    	entity.lastUpdUserId = session.getUserId();
//    	entity.lastUpdTime = entity.crtTime;
//    	entity.delF = (short)0;
//      	entity.crtDeptCd = session.getDeptId();
    }

    @Override
    public void preUpdate(QaSysAmrRankScr entity, PreUpdateContext<QaSysAmrRankScr> context) {
		Session session = Session.get();
//		entity.lastUpdUserId = session.getUserId();
//    	entity.lastUpdTime = new Timestamp(System.currentTimeMillis());
//    	entity.lastUpdDeptCd = session.getDeptId();    	
    }

    @Override
    public void preDelete(QaSysAmrRankScr entity, PreDeleteContext<QaSysAmrRankScr> context) {
    }

    @Override
    public void postInsert(QaSysAmrRankScr entity, PostInsertContext<QaSysAmrRankScr> context) {
    }

    @Override
    public void postUpdate(QaSysAmrRankScr entity, PostUpdateContext<QaSysAmrRankScr> context) {
    }

    @Override
    public void postDelete(QaSysAmrRankScr entity, PostDeleteContext<QaSysAmrRankScr> context) {
    }
}