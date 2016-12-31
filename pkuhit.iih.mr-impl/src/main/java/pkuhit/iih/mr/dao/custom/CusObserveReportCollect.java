package pkuhit.iih.mr.dao.custom;

import java.util.List;

import org.seasar.doma.Dao;
import org.seasar.doma.Select;
import org.seasar.doma.jdbc.SelectOptions;

import pkuhit.iih.mr.dao.auto.entity.ObsReportCollectEntity;
import xap.sv.dao.annotation.RepositoryConfig;

/**
 * @author guo_zhongbao
 *  本地检查报告读取
 */
@Dao
@RepositoryConfig
public interface CusObserveReportCollect {
    @Select
    List<ObsReportCollectEntity> selectByEnpk(String enPk, SelectOptions options);
}
