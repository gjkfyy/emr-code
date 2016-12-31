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
public class MrListener implements EntityListener<Mr> {

	@Override
	public void preInsert(Mr entity, PreInsertContext<Mr> context) {
		Session session = Session.get();
		entity.crtUserId = session.getUserId();
		entity.crtTime = new Timestamp(System.currentTimeMillis());
		entity.lastUpdUserId = session.getUserId();
		entity.lastUpdTime = entity.crtTime;
		entity.delF = (short) 0;
		entity.crtDeptCd = session.getDeptId();
	}

	@Override
	public void preUpdate(Mr entity, PreUpdateContext<Mr> context) {
		try {
			Session session = Session.get();
			entity.lastUpdUserId = session.getUserId();
			entity.lastUpdTime = new Timestamp(System.currentTimeMillis());
			entity.lastUpdDeptCd = session.getDeptId();
		} catch (Exception e) {
		}
	}

	@Override
	public void preDelete(Mr entity, PreDeleteContext<Mr> context) {
	}

	@Override
	public void postInsert(Mr entity, PostInsertContext<Mr> context) {
	}

	@Override
	public void postUpdate(Mr entity, PostUpdateContext<Mr> context) {
	}

	@Override
	public void postDelete(Mr entity, PostDeleteContext<Mr> context) {
	}
}