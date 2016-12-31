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
public class MdMrParaListener implements EntityListener<MdMrPara> {

    @Override
    public void preInsert(MdMrPara entity, PreInsertContext<MdMrPara> context) {
    	entity.delF = (short)0;
    }

    @Override
    public void preUpdate(MdMrPara entity, PreUpdateContext<MdMrPara> context) {
    }

    @Override
    public void preDelete(MdMrPara entity, PreDeleteContext<MdMrPara> context) {
    }

    @Override
    public void postInsert(MdMrPara entity, PostInsertContext<MdMrPara> context) {
    }

    @Override
    public void postUpdate(MdMrPara entity, PostUpdateContext<MdMrPara> context) {
    }

    @Override
    public void postDelete(MdMrPara entity, PostDeleteContext<MdMrPara> context) {
    }
}