package ei.ass.di.auto.po;

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
public class ZyPatientDiagnosisEntityListener implements EntityListener<ZyPatientDiagnosisEntity> {

    @Override
    public void preInsert(ZyPatientDiagnosisEntity entity, PreInsertContext<ZyPatientDiagnosisEntity> context) {

    }

    @Override
    public void preUpdate(ZyPatientDiagnosisEntity entity, PreUpdateContext<ZyPatientDiagnosisEntity> context) {
 	
    }

    @Override
    public void preDelete(ZyPatientDiagnosisEntity entity, PreDeleteContext<ZyPatientDiagnosisEntity> context) {
    }

    @Override
    public void postInsert(ZyPatientDiagnosisEntity entity, PostInsertContext<ZyPatientDiagnosisEntity> context) {
    }

    @Override
    public void postUpdate(ZyPatientDiagnosisEntity entity, PostUpdateContext<ZyPatientDiagnosisEntity> context) {
    }

    @Override
    public void postDelete(ZyPatientDiagnosisEntity entity, PostDeleteContext<ZyPatientDiagnosisEntity> context) {
    }
    

}