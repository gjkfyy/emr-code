package pkuhit.iih.mr.wr;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import pkuhit.iih.mr.dao.auto.EnAdtEntityDao;
import pkuhit.iih.mr.dao.auto.entity.EnAdtEntity;
import pkuhit.iih.mr.wr.dao.CusEnAdtFromIemrDao;
import xap.sv.model.ArrayResult;
import xap.sv.model.ArrayResultBuilder;
import xap.sv.model.SingleResult;
import xap.sv.model.SingleResultBuilder;

/**
 * @author guo_zhongbao
 *
 */
public class EnAdtFromIemrServiceImpl implements EnAdtFromIemrService {

	@Autowired
	EnAdtEntityDao autoEnAdtEntityDao;
	
	@Autowired
	CusEnAdtFromIemrDao cusEnAdtFromIemrDao;
	/* (non-Javadoc)
	 * @see pkuhit.iih.mr.wr.EnAdtFromIemrService#search(java.util.Map)
	 */
	@Override
	public ArrayResult<IemrEnAdtModel> search(Map map) {
		String en_pk=null; 
		if(verifyExistKey(map,"en_pk")){
			en_pk = (String)map.get("en_pk");
		}
		String patient_id=null; 
		if(verifyExistKey(map,"patient_id")){
			patient_id= (String)map.get("patient_id");
		}
		String en_cnt=null;
		if(verifyExistKey(map,"en_cnt")){
			en_cnt = (String)map.get("en_cnt");
		}
		Integer ledger_sn=null; 
		Integer trans_times=null; 
		String admiss_date_start=null;
		if(verifyExistKey(map,"admiss_date_start")){
			admiss_date_start = (String)map.get("admiss_date_start");
		}
		String admiss_date_end=null;
		if(verifyExistKey(map,"admiss_date_end")){
			admiss_date_end= (String)map.get("admiss_date_end");
		}
		String dis_date_start=null;
		if(verifyExistKey(map,"dis_date_start")){
			dis_date_start= (String)map.get("dis_date_start");
		}
		String dis_date_end=null;
		if(verifyExistKey(map,"dis_date_end")){
			dis_date_end = (String)map.get("dis_date_end");
		}
		String trans_reg_date_start=null;
		if(verifyExistKey(map,"trans_reg_date_start")){
			trans_reg_date_start = (String)map.get("trans_reg_date_start");
		}
		String trans_reg_date_end=null;
		if(verifyExistKey(map,"trans_reg_date_end")){
			trans_reg_date_end = (String)map.get("trans_reg_date_end");
		}
		String trans_date_start=null;
		if(verifyExistKey(map,"trans_date_start")){
			trans_date_start= (String)map.get("trans_date_start");
		}
		String trans_date_end=null;
		if(verifyExistKey(map,"trans_date_end")){
			trans_date_end = (String)map.get("trans_date_end");
		}
		String trans_type=null;
		if(verifyExistKey(map,"trans_type")){
			trans_type= (String)map.get("trans_type");
		}
		String orig_dept=null;
		if(verifyExistKey(map,"orig_dept")){
			orig_dept = (String)map.get("orig_dept");
		}
		String orig_ward=null;
		if(verifyExistKey(map,"orig_ward")){
			orig_ward = (String)map.get("orig_ward");
		}
		String orig_room=null;
		if(verifyExistKey(map,"orig_room")){
			orig_room = (String)map.get("orig_room");
		}
		String orig_bed=null;
		if(verifyExistKey(map,"orig_bed")){
			orig_bed = (String)map.get("orig_bed");
		}
		String orig_opera=null;
		if(verifyExistKey(map,"orig_opera")){
			orig_opera = (String)map.get("orig_opera");
		}
		String curr_dept=null;
		if(verifyExistKey(map,"curr_dept")){
			curr_dept = (String)map.get("curr_dept");
		}
		String curr_ward=null;
		if(verifyExistKey(map,"curr_ward")){
			curr_ward = (String)map.get("curr_ward");
		}
		String curr_room=null;
		if(verifyExistKey(map,"curr_room")){
			curr_room= (String)map.get("curr_room");
		}
		String curr_bed=null;
		if(verifyExistKey(map,"curr_bed")){
			curr_bed = (String)map.get("curr_bed");
		}
		String curr_opera=null;
		if(verifyExistKey(map,"curr_opera")){
			curr_opera = (String)map.get("curr_opera");
		}
		String mark=null;
		if(verifyExistKey(map,"mark")){
			mark= (String)map.get("mark");
		}
		ArrayResultBuilder<IemrEnAdtModel> builder = ArrayResultBuilder.newArrayResult(IemrEnAdtModel.class);
		int total = 0;
		List<EnAdtEntity> list = cusEnAdtFromIemrDao.selectEnAdtFromIemrList(en_pk, patient_id, en_cnt, ledger_sn, trans_times, admiss_date_start, admiss_date_end, dis_date_start, dis_date_end, trans_reg_date_start, trans_reg_date_end, trans_date_start, trans_date_end, trans_type, orig_dept, orig_ward, orig_room, orig_bed, orig_opera, curr_dept, curr_ward, curr_room, curr_bed, curr_opera, mark);
		if(null != list && !list.isEmpty())
		{
			total = list.size() ;
			IemrEnAdtModel[] voArray = new IemrEnAdtModel[total];
			for(int i = 0 ; i < total ; i ++){
				EnAdtEntity entity = list.get(i) ;
				IemrEnAdtModel model = transEntityToModel(entity);
				voArray[i] = model ;
			}
			builder.withData(voArray);
		}
		ArrayResult<IemrEnAdtModel> rs = builder.build();
		rs.setTotal(total);
		return rs;
	}

	/* (non-Javadoc)
	 * @see pkuhit.iih.mr.wr.EnAdtFromIemrService#get(java.lang.String)
	 */
	@Override
	public SingleResult<IemrEnAdtModel> get(String id) {
		EnAdtEntity entity = autoEnAdtEntityDao.selectById(id);
		SingleResultBuilder<IemrEnAdtModel> builder = SingleResultBuilder.newSingleResult(IemrEnAdtModel.class);
		if(null != entity){
			IemrEnAdtModel model = transEntityToModel(entity);
			builder.withData(model);
		}
		SingleResult<IemrEnAdtModel> rs = builder.build();
		return rs;
	}
	private IemrEnAdtModel transEntityToModel(EnAdtEntity entity   ){
		IemrEnAdtModel model = new IemrEnAdtModel();
		model.setAdmissDate(entity.getAdmissDate());
		model.setCurrBed(entity.getCurrBed());
		model.setCurrDept(entity.getCurrDept());
		model.setCurrWard(entity.getCurrWard());
		model.setCurrOpera(entity.getCurrOpera());
		model.setCurrRoom(entity.getCurrRoom());
		model.setDisDate(entity.getDisDate());
		model.setEnAdtCd(entity.getEnAdtCd());
		model.setEnCnt(entity.getEnCnt());
		model.setEnPk(entity.getEnPk());
		model.setLedgerSn(entity.getLedgerSn().intValue());
		model.setMark(entity.getMark());
		model.setOrigBed(entity.getOrigBed());
		model.setOrigDept(entity.getOrigDept());
		model.setOrigOpera(entity.getOrigOpera());
		model.setOrigRoom(entity.getOrigRoom());
		model.setOrigWard(entity.getOrigWard());
		model.setPatientId(entity.getPatientId());
		model.setTransDate(entity.getTransDate());
		model.setTransRegDate(entity.getTransRegDate());
		model.setTransTimes(entity.getTransTimes().intValue());
		model.setTransType(entity.getTransType());
		return model;
	}
	
	private boolean verifyExistKey(Map map, String key) {
		if (map.containsKey(key) && null != map.get(key)
				&& ! (StringUtils.isBlank((String)map.get(key)))) {
			return true;
		}
		return false;
	}
}
