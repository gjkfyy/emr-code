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
public class CaDataListener implements EntityListener<CaData> {

    @Override
    public void preInsert(CaData entity, PreInsertContext<CaData> context) {
		Session session = Session.get();
    }

    @Override
    public void preUpdate(CaData entity, PreUpdateContext<CaData> context) {
		Session session = Session.get(); 	
    }

    @Override
    public void preDelete(CaData entity, PreDeleteContext<CaData> context) {
    }

    @Override
    public void postInsert(CaData entity, PostInsertContext<CaData> context) {
    }

    @Override
    public void postUpdate(CaData entity, PostUpdateContext<CaData> context) {
    }

    @Override
    public void postDelete(CaData entity, PostDeleteContext<CaData> context) {
    }
}