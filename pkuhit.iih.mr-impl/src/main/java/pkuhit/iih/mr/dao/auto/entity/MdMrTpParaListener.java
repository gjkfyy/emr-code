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
public class MdMrTpParaListener implements EntityListener<MdMrTpPara> {

    @Override
    public void preInsert(MdMrTpPara entity, PreInsertContext<MdMrTpPara> context) {
		Session session = Session.get();
    	entity.delF = (short)0;
    }

    @Override
    public void preUpdate(MdMrTpPara entity, PreUpdateContext<MdMrTpPara> context) {
    }

    @Override
    public void preDelete(MdMrTpPara entity, PreDeleteContext<MdMrTpPara> context) {
    }

    @Override
    public void postInsert(MdMrTpPara entity, PostInsertContext<MdMrTpPara> context) {
    }

    @Override
    public void postUpdate(MdMrTpPara entity, PostUpdateContext<MdMrTpPara> context) {
    }

    @Override
    public void postDelete(MdMrTpPara entity, PostDeleteContext<MdMrTpPara> context) {
    }
}