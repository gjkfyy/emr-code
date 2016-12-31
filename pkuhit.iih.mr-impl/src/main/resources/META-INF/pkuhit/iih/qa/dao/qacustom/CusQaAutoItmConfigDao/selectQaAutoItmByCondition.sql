select a.QA_ITM_CONFIG_CD,
       a.qa_itm_cd,
       a.mr_types,
       a.event_type_code,
       a.dead_hours,
       a.use_flag,
       a.mr_op_type,
       a.qa_rl_cd,
       a.qa_rl_tp_cd,
       a.qa_itm_tp_cd,
       a.job_title_cd,
       a.del_f
  from QA_AUTO_ITM_CONFIG a
 where a.use_flag = 1
   /*%if qaItmCd != null*/
   and QA_ITM_CD = /* qaItmCd */'a'
   /*%end */
   /*%if qaItmTpCd != null*/
   and QA_ITM_TP_CD = /* qaItmTpCd */'a'
   /*%end */
   and a.DEL_F = 0