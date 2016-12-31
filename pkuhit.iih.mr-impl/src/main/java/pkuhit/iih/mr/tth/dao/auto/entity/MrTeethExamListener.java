package pkuhit.iih.mr.tth.dao.auto.entity;

import java.sql.Timestamp;

import org.seasar.doma.jdbc.entity.EntityListener;
import org.seasar.doma.jdbc.entity.PostDeleteContext;
import org.seasar.doma.jdbc.entity.PostInsertContext;
import org.seasar.doma.jdbc.entity.PostUpdateContext;
import org.seasar.doma.jdbc.entity.PreDeleteContext;
import org.seasar.doma.jdbc.entity.PreInsertContext;
import org.seasar.doma.jdbc.entity.PreUpdateContext;

import pkuhit.iih.mr.tth.dao.auto.entity.MrTeethExam;
import pkuhit.xap.ac.Session;

public class MrTeethExamListener implements EntityListener<MrTeethExam> 
{
    @Override
    public void preInsert(MrTeethExam entity, PreInsertContext<MrTeethExam> context) {
        Session session = Session.get();
        entity.crtUserId = session.getUserId();
        entity.crtTime = new Timestamp(System.currentTimeMillis());
        entity.lastUpdUserId = session.getUserId();
        entity.lastUpdTime = entity.crtTime;
        entity.delF = (short)0;
        entity.crtDeptCd = session.getDeptId();
    }

    @Override
    public void preUpdate(MrTeethExam entity, PreUpdateContext<MrTeethExam> context) {
        try{
            Session session = Session.get();
            entity.lastUpdUserId = session.getUserId();
            entity.lastUpdTime = new Timestamp(System.currentTimeMillis());
            entity.lastUpdDeptCd = session.getDeptId();   
        }catch(Exception e){
            
        }
    }

    @Override
    public void preDelete(MrTeethExam entity, PreDeleteContext<MrTeethExam> context) {
    }

    @Override
    public void postInsert(MrTeethExam entity, PostInsertContext<MrTeethExam> context) {
    }

    @Override
    public void postUpdate(MrTeethExam entity, PostUpdateContext<MrTeethExam> context) {
    }

    @Override
    public void postDelete(MrTeethExam entity, PostDeleteContext<MrTeethExam> context) {
    }
}
