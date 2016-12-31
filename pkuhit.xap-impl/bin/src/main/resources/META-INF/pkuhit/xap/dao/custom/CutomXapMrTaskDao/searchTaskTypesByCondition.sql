select t.TASK_TYPE_CD,
       t.MD_MR_TP_CD,
       e.EVENT_TYPE_CD,
       t.dead_hours,
       t.use_flag,
       t.qa_rl_cd,
       t.qa_rl_tp_cd,
       t.qa_itm_tp_cd,
       t.job_title_cd,
       t.del_f,
       t.memo
  from XAP_TASK_TYPE t 
  left join XAP_TASK_EVENT_TYPE e 
  on t.TASK_TYPE_CD = e.TASK_TYPE_CD
 where t.use_flag = 1
	 /*%if eventTypeCode != null && eventTypeCode != ""*/
	 and e.EVENT_TYPE_CD = /*eventTypeCode*/'aa'
	 /*%end*/
     and t.DEL_F = 0
     and e.DEL_F = 0