select
  EN_ADT_CD,
  EN_PK,
  PATIENT_ID,
  EN_CNT,
  LEDGER_SN,
  TRANS_TIMES,
  ADMISS_DATE,
  DIS_DATE,
  TRANS_REG_DATE,
  TRANS_DATE,
  TRANS_TYPE,
  ORIG_DEPT,
  ORIG_WARD,
  ORIG_ROOM,
  ORIG_BED,
  ORIG_OPERA,
  CURR_DEPT,
  CURR_WARD,
  CURR_ROOM,
  CURR_BED,
  CURR_OPERA,
  MARK
from
  EN_ADT t
where
1=1
  /*%if en_pk != null && en_pk != "" */
   and t.en_pk =/*en_pk*/'a'
	 /*%end */ 
		   /*%if patient_id != null && patient_id != "" */
   and t.patient_id =/*patient_id*/'a'
	 /*%end */
			   /*%if en_cnt != null && en_cnt != "" */
   and t.en_cnt =/*en_cnt*/'a'
	 /*%end */ 
     /*%if ledger_sn != null  */
		and t.ledger_sn = /*ledger_sn*/1
			 /*%end */ 
     /*%if trans_times != null  */
		and t.trans_times = /*trans_times*/1
			 /*%end */ 
		   /*%if admiss_date_start != null && admiss_date_start != "" */
        and to_char(t.admiss_date,'yyyy-mm-dd hh:mi:ss') >= /* admiss_date_start */'2014-8-27 16:20:00'
	 /*%end */ 
		   /*%if admiss_date_end != null && admiss_date_end != "" */
    and to_char(t.admiss_date,'yyyy-mm-dd hh:mi:ss') <= /* admiss_date_end */'2014-8-27 16:20:00'
	 /*%end */ 
		   /*%if dis_date_start != null && dis_date_start != "" */
   and to_char(t.dis_date,'yyyy-mm-dd hh:mi:ss') >= /* dis_date_start */'2014-8-27 16:20:00'
	 /*%end */ 
		   /*%if dis_date_end != null && dis_date_end != "" */
   and to_char(t.dis_date,'yyyy-mm-dd hh:mi:ss') <= /* dis_date_end */'2014-8-27 16:20:00'
	 /*%end */ 
		   /*%if trans_reg_date_start != null && trans_reg_date_start != "" */
   and to_char(t.trans_reg_date,'yyyy-mm-dd hh:mi:ss') >= /* trans_reg_date_start */'2014-8-27 16:20:00'
	 /*%end */ 
		   /*%if trans_reg_date_end != null && trans_reg_date_end != "" */
    and to_char(t.trans_reg_date,'yyyy-mm-dd hh:mi:ss') <= /* trans_reg_date_end */'2014-8-27 16:20:00'
	 /*%end */ 
		   /*%if trans_date_start != null && trans_date_start != "" */
    and to_char(t.trans_date,'yyyy-mm-dd hh:mi:ss') >= /* trans_date_start */'2014-8-27 16:20:00'
	 /*%end */ 
		   /*%if trans_date_end != null && trans_date_end != "" */
    and to_char(t.trans_date,'yyyy-mm-dd hh:mi:ss') <= /* trans_date_end */'2014-8-27 16:20:00'
	 /*%end */ 
		   /*%if trans_type != null && trans_type != "" */
   and t.trans_type =/*trans_type*/'a'
	 /*%end */ 
		   /*%if orig_dept != null && orig_dept != "" */
   and t.orig_dept =/*orig_dept*/'a'
	 /*%end */ 
		   /*%if orig_ward != null && orig_ward != "" */
   and t.orig_ward =/*orig_ward*/'a'
	 /*%end */ 
		   /*%if orig_room != null && orig_room != "" */
   and t.orig_room =/*orig_room*/'a'
	 /*%end */ 
		   /*%if orig_bed != null && orig_bed != "" */
   and t.orig_bed =/*orig_bed*/'a'
	 /*%end */ 
		   /*%if orig_opera != null && orig_opera != "" */
   and t.orig_opera =/*orig_opera*/'a'
	 /*%end */ 
		   /*%if curr_dept != null && curr_dept != "" */
   and t.curr_dept =/*curr_dept*/'a'
	 /*%end */ 
		   /*%if curr_ward != null && curr_ward != "" */
   and t.curr_ward =/*curr_ward*/'a'
	 /*%end */ 
		   /*%if curr_room != null && curr_room != "" */
   and t.curr_room =/*curr_room*/'a'
	 /*%end */ 
		   /*%if curr_bed != null && curr_bed != "" */
   and t.curr_bed =/*curr_bed*/'a'
	 /*%end */ 
		   /*%if curr_opera != null && curr_opera != "" */
   and t.curr_opera =/*curr_opera*/'a'
	 /*%end */ 
		   /*%if mark != null && mark != "" */
   and t.mark =/*mark*/'a'
	 /*%end */ 
