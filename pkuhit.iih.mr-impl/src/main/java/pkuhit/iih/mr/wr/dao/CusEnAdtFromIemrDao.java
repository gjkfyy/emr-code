package pkuhit.iih.mr.wr.dao;

import java.util.List;

import org.seasar.doma.Dao;
import org.seasar.doma.Select;

import pkuhit.iih.mr.dao.auto.entity.EnAdtEntity;
import xap.sv.dao.annotation.RepositoryConfig;

@Dao
@RepositoryConfig
public interface CusEnAdtFromIemrDao {
	@Select
	List<EnAdtEntity> selectEnAdtFromIemrList(
			String en_pk
			,String patient_id,
			String en_cnt
			,Integer ledger_sn
			,Integer trans_times
			,String admiss_date_start
			,String admiss_date_end
			,String dis_date_start
			,String dis_date_end
			,String trans_reg_date_start
			,String trans_reg_date_end
			,String trans_date_start
			,String trans_date_end
			,String trans_type
			,String orig_dept
			,String orig_ward
			,String orig_room
			,String orig_bed
			,String orig_opera
			,String curr_dept
			,String curr_ward
			,String curr_room
			,String curr_bed
			,String curr_opera
			,String mark);
}
