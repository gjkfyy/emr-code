package pkuhit.iih.mr.tth.dao.custom;

import java.util.List;

import org.seasar.doma.Dao;
import org.seasar.doma.Select;

import pkuhit.iih.mr.tth.dao.auto.entity.MrTeethExam;
import pkuhit.iih.mr.tth.dao.auto.entity.MrTeethExamItem;
import xap.sv.dao.annotation.RepositoryConfig;

@Dao
@RepositoryConfig
public interface CusTeethExamDao
{
    @Select
    MrTeethExam selectTeethExamByEnPk(String enPk);
    
    @Select
    List<MrTeethExamItem> selectTeethExamItemByPk(String pk);
}
