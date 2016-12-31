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
public class ObsReportCollectEntityListener implements EntityListener<ObsReportCollectEntity> {

    @Override
    public void preInsert(ObsReportCollectEntity entity, PreInsertContext<ObsReportCollectEntity> context) {
 
    }

    @Override
    public void preUpdate(ObsReportCollectEntity entity, PreUpdateContext<ObsReportCollectEntity> context) {

    }

    @Override
    public void preDelete(ObsReportCollectEntity entity, PreDeleteContext<ObsReportCollectEntity> context) {
    }

    @Override
    public void postInsert(ObsReportCollectEntity entity, PostInsertContext<ObsReportCollectEntity> context) {
    }

    @Override
    public void postUpdate(ObsReportCollectEntity entity, PostUpdateContext<ObsReportCollectEntity> context) {
    }

    @Override
    public void postDelete(ObsReportCollectEntity entity, PostDeleteContext<ObsReportCollectEntity> context) {
    }
    

}