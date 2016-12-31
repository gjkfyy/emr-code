package pkuhit.me.dao.custom;

import java.util.List;

import org.seasar.doma.Dao;
import org.seasar.doma.Select;

import pkuhit.me.dao.custom.entity.ObjectAttributeMetadata;
import xap.sv.dao.annotation.RepositoryConfig;

@Dao
@RepositoryConfig
public interface DataObjectMetadataDao  
{
    @Select
    List<ObjectAttributeMetadata> selectAllMetadata();  
}
