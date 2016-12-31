package pkuhit.me.dao.custom;

import java.util.List;

import org.seasar.doma.Dao;
import org.seasar.doma.Select;
import org.seasar.doma.jdbc.SelectOptions;

import pkuhit.me.dao.auto.entity.MeObjAttr;
import xap.sv.dao.annotation.RepositoryConfig;

@Dao
@RepositoryConfig
public interface CustomMeObjAttrDao {

    @Select
    List<MeObjAttr> selectAllObjectAttribute(String keyword, String type, SelectOptions options);

}
