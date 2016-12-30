package szlh.iih.mr.po;

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
public class IemrDocContentListener implements EntityListener<IemrDocContent> {

    @Override
    public void preInsert(IemrDocContent entity, PreInsertContext<IemrDocContent> context) {
    }

    @Override
    public void preUpdate(IemrDocContent entity, PreUpdateContext<IemrDocContent> context) {
    }

    @Override
    public void preDelete(IemrDocContent entity, PreDeleteContext<IemrDocContent> context) {
    }

    @Override
    public void postInsert(IemrDocContent entity, PostInsertContext<IemrDocContent> context) {
    }

    @Override
    public void postUpdate(IemrDocContent entity, PostUpdateContext<IemrDocContent> context) {
    }

    @Override
    public void postDelete(IemrDocContent entity, PostDeleteContext<IemrDocContent> context) {
    }
}