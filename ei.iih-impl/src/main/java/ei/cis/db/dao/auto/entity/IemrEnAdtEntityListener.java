package ei.cis.db.dao.auto.entity;

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
public class IemrEnAdtEntityListener implements EntityListener<IemrEnAdtEntity> {

    @Override
    public void preInsert(IemrEnAdtEntity entity, PreInsertContext<IemrEnAdtEntity> context) {
    }

    @Override
    public void preUpdate(IemrEnAdtEntity entity, PreUpdateContext<IemrEnAdtEntity> context) {
    }

    @Override
    public void preDelete(IemrEnAdtEntity entity, PreDeleteContext<IemrEnAdtEntity> context) {
    }

    @Override
    public void postInsert(IemrEnAdtEntity entity, PostInsertContext<IemrEnAdtEntity> context) {
    }

    @Override
    public void postUpdate(IemrEnAdtEntity entity, PostUpdateContext<IemrEnAdtEntity> context) {
    }

    @Override
    public void postDelete(IemrEnAdtEntity entity, PostDeleteContext<IemrEnAdtEntity> context) {
    }
    

}