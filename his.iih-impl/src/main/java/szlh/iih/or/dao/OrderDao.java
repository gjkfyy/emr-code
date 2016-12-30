package szlh.iih.or.dao;

import java.util.List;
import org.seasar.doma.Dao;
import org.seasar.doma.Select;
import szlh.iih.or.po.OrderPo;
import xap.sv.dao.annotation.RepositoryConfig;

@Dao
@RepositoryConfig
public interface OrderDao {
	/*医嘱列表*/
	@Select
	List<OrderPo> getOrderListByEnSn(String patient_id ,String times,String longOrF/*, SelectOptions options*/);
	/*医嘱详情*/
	@Select
	OrderPo OrderDetailByOrderSn(String orPk);
}
