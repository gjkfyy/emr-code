package iih.di.db.entity;

import org.seasar.doma.jdbc.entity.EntityListener;
import org.seasar.doma.jdbc.entity.PostDeleteContext;
import org.seasar.doma.jdbc.entity.PostInsertContext;
import org.seasar.doma.jdbc.entity.PostUpdateContext;
import org.seasar.doma.jdbc.entity.PreDeleteContext;
import org.seasar.doma.jdbc.entity.PreInsertContext;
import org.seasar.doma.jdbc.entity.PreUpdateContext;

/**
 * 
 */
public class DibDiListener implements EntityListener<DibDi> {

    @Override
    public void preInsert(DibDi entity, PreInsertContext<DibDi> context) {
    }

    @Override
    public void preUpdate(DibDi entity, PreUpdateContext<DibDi> context) {
    }

    @Override
    public void preDelete(DibDi entity, PreDeleteContext<DibDi> context) {
    }

    @Override
    public void postInsert(DibDi entity, PostInsertContext<DibDi> context) {
    }

    @Override
    public void postUpdate(DibDi entity, PostUpdateContext<DibDi> context) {
    }

    @Override
    public void postDelete(DibDi entity, PostDeleteContext<DibDi> context) {
    }
}