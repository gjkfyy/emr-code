package pkuhit.iih.mr.tth.dao.auto.entity;

import java.sql.Timestamp;

import org.seasar.doma.jdbc.entity.EntityListener;
import org.seasar.doma.jdbc.entity.PostDeleteContext;
import org.seasar.doma.jdbc.entity.PostInsertContext;
import org.seasar.doma.jdbc.entity.PostUpdateContext;
import org.seasar.doma.jdbc.entity.PreDeleteContext;
import org.seasar.doma.jdbc.entity.PreInsertContext;
import org.seasar.doma.jdbc.entity.PreUpdateContext;

import pkuhit.xap.ac.Session;

public class MrTeethExamItemListener implements EntityListener<MrTeethExamItem> 
{
    @Override
    public void preInsert(MrTeethExamItem entity, PreInsertContext<MrTeethExamItem> context) {
        Session session = Session.get();
        entity.crtUserId = session.getUserId();
        entity.crtTime = new Timestamp(System.currentTimeMillis());
        entity.lastUpdUserId = session.getUserId();
        entity.lastUpdTime = entity.crtTime;
        entity.delF = (short)0;
        entity.crtDeptCd = session.getDeptId();
    }

    @Override
    public void preUpdate(MrTeethExamItem entity, PreUpdateContext<MrTeethExamItem> context) {
        try{
            Session session = Session.get();
            entity.lastUpdUserId = session.getUserId();
            entity.lastUpdTime = new Timestamp(System.currentTimeMillis());
            entity.lastUpdDeptCd = session.getDeptId();   
        }catch(Exception e){
            
        }
    }

    @Override
    public void preDelete(MrTeethExamItem entity, PreDeleteContext<MrTeethExamItem> context) {
    }

    @Override
    public void postInsert(MrTeethExamItem entity, PostInsertContext<MrTeethExamItem> context) {
    }

    @Override
    public void postUpdate(MrTeethExamItem entity, PostUpdateContext<MrTeethExamItem> context) {
    }

    @Override
    public void postDelete(MrTeethExamItem entity, PostDeleteContext<MrTeethExamItem> context) {
    }
}
