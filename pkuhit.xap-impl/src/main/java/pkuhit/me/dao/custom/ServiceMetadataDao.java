package pkuhit.me.dao.custom;

import java.util.List;

import org.seasar.doma.Dao;
import org.seasar.doma.Select;

import pkuhit.me.dao.auto.entity.MeXsv;
import xap.sv.dao.annotation.RepositoryConfig;

@Dao
@RepositoryConfig
public interface ServiceMetadataDao
{
    @Select
    MeXsv selectMetadataByRestInfo(String restPattern, String method);
    
    @Select
    List<MeXsv> selectAllMetadata();
}
