package pkuhit.iih.qa.dao.custom;

import java.util.List;

import org.seasar.doma.Dao;
import org.seasar.doma.Select;

import pkuhit.iih.qa.dao.auto.entity.QaFltItm;
import xap.sv.dao.annotation.RepositoryConfig;

@Dao
@RepositoryConfig
public interface CusQaItemDao {
	
	@Select
    int selectByQaItemPk(List<String> qaItemPkList);
	
	@Select
	QaFltItm selectFaultItemByFaultPk(String faultPk);
	
}
