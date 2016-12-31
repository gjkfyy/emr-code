package pkuhit.md.dao.custom;

import org.seasar.doma.Dao;
import org.seasar.doma.Select;

import pkuhit.md.dao.auto.entity.MdDi;

import java.util.List;

import xap.sv.dao.annotation.RepositoryConfig;

@Dao
@RepositoryConfig
public interface CustomMdDiDao {
	@Select(maxRows = 25)
	List<MdDi> selectMdDiList(String keyword);
}
