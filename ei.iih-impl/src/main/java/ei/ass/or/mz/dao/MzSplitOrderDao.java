package ei.ass.or.mz.dao;

import java.util.List;

import org.seasar.doma.Dao;
import org.seasar.doma.Select;

import xap.sv.dao.annotation.RepositoryConfig;
import ei.ass.or.auto.po.OrderPo;

@Dao
@RepositoryConfig
public interface MzSplitOrderDao {
	/*医嘱列表*/
	@Select
	List<OrderPo> getOrderListByEnSn(String patient_id ,String times,String longOrF/*, SelectOptions options*/);
	/*医嘱详情*/
	@Select
	OrderPo OrderDetailByOrderSn(String orPk);
}
