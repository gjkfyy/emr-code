package szlh.iih.di.po;

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
public class MzPatientDiagnosisEntityListener implements EntityListener<MzPatientDiagnosisEntity> {

    @Override
    public void preInsert(MzPatientDiagnosisEntity entity, PreInsertContext<MzPatientDiagnosisEntity> context) {
    }

    @Override
    public void preUpdate(MzPatientDiagnosisEntity entity, PreUpdateContext<MzPatientDiagnosisEntity> context) {
    }

    @Override
    public void preDelete(MzPatientDiagnosisEntity entity, PreDeleteContext<MzPatientDiagnosisEntity> context) {
    }

    @Override
    public void postInsert(MzPatientDiagnosisEntity entity, PostInsertContext<MzPatientDiagnosisEntity> context) {
    }

    @Override
    public void postUpdate(MzPatientDiagnosisEntity entity, PostUpdateContext<MzPatientDiagnosisEntity> context) {
    }

    @Override
    public void postDelete(MzPatientDiagnosisEntity entity, PostDeleteContext<MzPatientDiagnosisEntity> context) {
    }
}