package ei.ass.or.zy.dao;

import java.util.List;

import org.seasar.doma.Dao;
import org.seasar.doma.Select;
import org.seasar.doma.jdbc.SelectOptions;

import xap.sv.dao.annotation.RepositoryConfig;
import ei.ass.or.auto.po.OrderPo;

@Dao
@RepositoryConfig
public interface ZyDirectOrderDao {
	/*医嘱列表*/
	@Select
	List<OrderPo> getOrderListByEnSn(String enPk,String longOrF,String orTpNm,String svNm, SelectOptions options);
	/*医嘱列表*/
	@Select
	List<OrderPo> getOrderOutpListByEnSn(String enPk, SelectOptions options);
	/*医嘱详情*/
	@Select
	OrderPo OrderDetailByOrderSn(String orPk);
}
