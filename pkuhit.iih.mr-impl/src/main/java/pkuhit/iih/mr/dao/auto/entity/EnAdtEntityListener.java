package pkuhit.iih.mr.dao.auto.entity;

import org.seasar.doma.jdbc.entity.EntityListener;
import org.seasar.doma.jdbc.entity.PostDeleteContext;
import org.seasar.doma.jdbc.entity.PostInsertContext;
import org.seasar.doma.jdbc.entity.PostUpdateContext;
import org.seasar.doma.jdbc.entity.PreDeleteContext;
import org.seasar.doma.jdbc.entity.PreInsertContext;
import org.seasar.doma.jdbc.entity.PreUpdateContext;

/**
 *  转科记录本地查询
 */
public class EnAdtEntityListener implements EntityListener<EnAdtEntity> {

    @Override
    public void preInsert(EnAdtEntity entity, PreInsertContext<EnAdtEntity> context) {
    
    }

    @Override
    public void preUpdate(EnAdtEntity entity, PreUpdateContext<EnAdtEntity> context) {

    }

    @Override
    public void preDelete(EnAdtEntity entity, PreDeleteContext<EnAdtEntity> context) {
    }

    @Override
    public void postInsert(EnAdtEntity entity, PostInsertContext<EnAdtEntity> context) {
    }

    @Override
    public void postUpdate(EnAdtEntity entity, PostUpdateContext<EnAdtEntity> context) {
    }

    @Override
    public void postDelete(EnAdtEntity entity, PostDeleteContext<EnAdtEntity> context) {
    }
    

}