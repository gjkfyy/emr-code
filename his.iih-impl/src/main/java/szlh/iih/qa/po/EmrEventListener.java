package szlh.iih.qa.po;

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
public class EmrEventListener implements EntityListener<EmrEvent> {

    @Override
    public void preInsert(EmrEvent entity, PreInsertContext<EmrEvent> context) {
    }

    @Override
    public void preUpdate(EmrEvent entity, PreUpdateContext<EmrEvent> context) {
    }

    @Override
    public void preDelete(EmrEvent entity, PreDeleteContext<EmrEvent> context) {
    }

    @Override
    public void postInsert(EmrEvent entity, PostInsertContext<EmrEvent> context) {
    }

    @Override
    public void postUpdate(EmrEvent entity, PostUpdateContext<EmrEvent> context) {
    }

    @Override
    public void postDelete(EmrEvent entity, PostDeleteContext<EmrEvent> context) {
    }
}