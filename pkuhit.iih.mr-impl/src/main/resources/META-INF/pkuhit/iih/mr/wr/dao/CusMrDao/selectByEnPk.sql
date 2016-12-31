select m.mr_pk,
       m.en_pk,
       m.mr_tpl_cd,
       m.file_pk,
       m.nm,
       m.mr_tp_cd,
       m.encounter_sn,
       m.mr_sta_cd,
       m.mr_qa_sta_cd,
       m.completed_f,
       m.sign_lvl_cd,
       m.biz_time,
       m.sup_dct_id,
       m.submit_cd,
       m.submit_date,
       m.dept_cd,
       m.treat_doctor_cd,
       m.mast_doctor_cd,
       m.mast_doctor_date,
       m.dir_doctor_cd,
       m.dir_doctor_date,
       m.memo,
       m.sort_no,
       m.spell_no,
       m.wubi_no,
       m.upd_cnt,
       m.crt_time,
       m.crt_user_id,
       m.crt_dept_cd,
       m.lgc_smt_time,
       m.last_upd_time,
       m.last_upd_dept_cd,
       m.last_upd_user_id,
       m.del_f
  from mr m
 where m.del_f = '0'
   and m.en_pk = /*enPk*/'a'
   and m.mr_tp_cd in (
   select itm.mr_tp_cd from md_mr_tp_ccat_itm itm,md_mr_tp_ccat ccat 
		where itm.mr_tp_ccat_cd=ccat.mr_tp_ccat_cd 
		/*%if nsF != null */
		and ccat.dct_ns_f=/*nsF*/1 
 		/*%end */  
		and  itm.del_f='0'  and ccat.del_f='0'
		/*%if mrTypeCustomCode != null && mrTypeCustomCode != "" */
		and itm.mr_tp_ccat_cd = /*mrTypeCustomCode*/'a'
 		/*%end */  
)
	
   /*%if mrTypeCode != null && mrTypeCode != "" */
   and m.mr_tp_cd =/*mrTypeCode*/'a'
	 /*%end */
   /*%if deptCd != null && deptCd != "" */
   and m.dept_cd=/*deptCd*/'a'
   /*%end */
   /*%if mrType != null && mrType != "" */
   and m.mr_sta_cd !=/*mrType*/'a'
	 /*%end */
   order by m.biz_time