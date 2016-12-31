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
public class QaAutoFltListener implements EntityListener<QaAutoFlt> {

    @Override
    public void preInsert(QaAutoFlt entity, PreInsertContext<QaAutoFlt> context) {
	//	Session session = Session.get();
		//entity.crtUserId = session.getUserId();
    	entity.crtTime = new Timestamp(System.currentTimeMillis());
    	//entity.lastUpdUserId = session.getUserId();
    	entity.lastUpdTime = entity.crtTime;
    	entity.delF = (short)0;
      //	entity.crtDeptCd = session.getDeptId();
    }

    @Override
    public void preUpdate(QaAutoFlt entity, PreUpdateContext<QaAutoFlt> context) {
		//Session session = Session.get();
		//entity.lastUpdUserId = session.getUserId();
    	entity.lastUpdTime = new Timestamp(System.currentTimeMillis());
    	//entity.lastUpdDeptCd = session.getDeptId();    	
    }

    @Override
    public void preDelete(QaAutoFlt entity, PreDeleteContext<QaAutoFlt> context) {
    }

    @Override
    public void postInsert(QaAutoFlt entity, PostInsertContext<QaAutoFlt> context) {
    }

    @Override
    public void postUpdate(QaAutoFlt entity, PostUpdateContext<QaAutoFlt> context) {
    }

    @Override
    public void postDelete(QaAutoFlt entity, PostDeleteContext<QaAutoFlt> context) {
    }
}