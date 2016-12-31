package pkuhit.iih.mr.wr;

import java.util.Map;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import xap.sv.model.ArrayResult;
import xap.sv.model.SingleResult;
import xap.sv.servlet.mvc.annotation.RequestParam;

/**
 * @author guo_zhongbao
 * 转科记录查询接口
 */
public interface EnAdtFromIemrService {

	/**
	 * 查询转科记录
	 * @author guo_zhongbao
	 * @param  en_pk 就诊主键
	 * @param  patient_id 患者id
	 * @param  en_cnt 就诊次数
	 * @param  admiss_date_start 住院时间开始时间 yyyy-mm-dd h24:mi:ss
	 * @param  admiss_date_end 住院时间结束时间 yyyy-mm-dd h24:mi:ss
	 * @param  dis_date_start 出院时间开始时间 yyyy-mm-dd h24:mi:ss
	 * @param  dis_date_end 出院时间结束时间 yyyy-mm-dd h24:mi:ss
	 * @param  trans_reg_date_start 申请转科时间开始时间 yyyy-mm-dd h24:mi:ss
	 * @param  trans_reg_date_end 申请转科时间结束时间 yyyy-mm-dd h24:mi:ss
	 * @param  trans_date_start 转科日期开始时间 yyyy-mm-dd h24:mi:ss
	 * @param  trans_date_end 转科日期结束时间 yyyy-mm-dd h24:mi:ss
	 * @param  trans_type 转科类型:01转科;02转病区;03转房间;04转床
	 * @param  orig_dept 原科室
	 * @param  orig_ward 原病区
	 * @param  orig_room 原房间号
	 * @param  orig_bed 原床位
	 * @param  orig_opera 申请转科操作人
	 * @param  curr_dept 新科室
	 * @param  curr_ward 新病区
	 * @param  curr_room 新房间号
	 * @param  curr_bed 新床位
	 * @param  curr_opera 确认转科操作人
	 * @param  mark 标记
	 * @return 转科记录list
	 * */
	@RequestMapping(value = "/mr/wr/en/adt", method = RequestMethod.GET)
	ArrayResult<IemrEnAdtModel> search(@RequestParam Map map); 
	
	@RequestMapping(value = "/mr/wr/en/adt/{id}", method = RequestMethod.GET)
	SingleResult<IemrEnAdtModel> get(@PathVariable("id")  String id) ;
}
