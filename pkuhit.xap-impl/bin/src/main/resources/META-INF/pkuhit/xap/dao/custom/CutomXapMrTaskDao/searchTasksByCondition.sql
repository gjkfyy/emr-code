select t.task_id,
       t.task_type_cd,
       t.doc_sn,
       t.event_id,
       t.begin_time,
       t.end_time,
       t.encounter_sn,
       t.complete_time,
       t.status,
       t.crt_time,       
       tp.md_mr_tp_cd,
       t.del_f

  from XAP_TASK t 
  left join XAP_TASK_TYPE tp
  on t.TASK_TYPE_CD = tp.TASK_TYPE_CD
 
 where 1=1
   /*%if enPk != null && enPk != ""*/
   and t.ENCOUNTER_SN = /*enPk*/'aa'
   /*%end*/
   /*%if mrTypeCode != null && mrTypeCode != ""*/
   and tp.MD_MR_TP_CD  like /* @contain(mrTypeCode) */'%g%'
   /*%end*/
     and t.DEL_F = 0
     and tp.DEL_F = 0