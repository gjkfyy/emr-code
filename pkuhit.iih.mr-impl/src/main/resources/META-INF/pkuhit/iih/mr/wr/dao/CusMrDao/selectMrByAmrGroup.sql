select m.mr_pk,
       m.nm,
       m.en_pk,
       m.upd_cnt,
       m.crt_time,
       m.biz_time,
       m.crt_user_id,
       (select o.nm from ORG_EMP o where o.emp_no = m.crt_user_id) user_nm,
       m.del_f
  from mr m
 where m.del_f = '0'
   and m.en_pk in /*enPks*/('a')
   /*%if mrTypeCustomCode != null && mrTypeCustomCode != "" */
   and m.mr_tp_cd in (select mmtc.mr_tp_cd
                        from md_mr_tp_ccat_itm mmtc
                       where mmtc.mr_tp_ccat_cd = /*mrTypeCustomCode*/'a')
	 /*%end */
   /*%if mrTypeCode != null && mrTypeCode != "" */
   and m.mr_tp_cd =/*mrTypeCode*/'a'
	 /*%end */
   order by m.biz_time