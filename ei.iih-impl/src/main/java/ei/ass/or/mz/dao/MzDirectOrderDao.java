package ei.ass.or.mz.dao;

import java.util.List;

import org.seasar.doma.Dao;
import org.seasar.doma.Select;
import org.seasar.doma.jdbc.SelectOptions;

import xap.sv.dao.annotation.RepositoryConfig;
import ei.ass.or.auto.po.OrderPo;

@Dao
@RepositoryConfig
public interface MzDirectOrderDao {
	/*医嘱列表*/
	@Select
	List<OrderPo> getOrderListByEnSn(String enPk,String longOrF, SelectOptions options);
	/*医嘱详情*/
	@Select
	OrderPo OrderDetailByOrderSn(String orPk);
}
