package iih.di.db.gen.entity;

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
public class MdDiEntityListener implements EntityListener<MdDiEntity> {

    @Override
    public void preInsert(MdDiEntity entity, PreInsertContext<MdDiEntity> context) {
		Session session = Session.get();
		entity.crtUserId = session.getUserId();
    	entity.crtTime = new Timestamp(System.currentTimeMillis());
    	entity.lastUpdUserId = session.getUserId();
    	entity.lastUpdTime = entity.crtTime;
    	entity.delF = (short)0;
      	entity.crtDeptCd = session.getDeptId();
    }

    @Override
    public void preUpdate(MdDiEntity entity, PreUpdateContext<MdDiEntity> context) {
    	Session session = Session.get();
    	entity.lastUpdUserId = session.getUserId();
    	entity.lastUpdTime = entity.crtTime;
    }

    @Override
    public void preDelete(MdDiEntity entity, PreDeleteContext<MdDiEntity> context) {
    }

    @Override
    public void postInsert(MdDiEntity entity, PostInsertContext<MdDiEntity> context) {
    }

    @Override
    public void postUpdate(MdDiEntity entity, PostUpdateContext<MdDiEntity> context) {
    }

    @Override
    public void postDelete(MdDiEntity entity, PostDeleteContext<MdDiEntity> context) {
    }
    

}