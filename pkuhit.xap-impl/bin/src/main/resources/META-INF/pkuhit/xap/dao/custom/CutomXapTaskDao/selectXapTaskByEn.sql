SELECT task.UPD_CNT,
       task.CRT_TIME,
       task.CRT_USER_ID,
       task.CRT_DEPT_CD,
       task.LAST_UPD_TIME,
       task.LAST_UPD_DEPT_CD,
       task.LAST_UPD_USER_ID,
       task.DEL_F,
       task.TASK_ID,
       task.TASK_TYPE_CD,
       task.DOC_SN,
       task.EVENT_ID,
       task.BEGIN_TIME,
       task.END_TIME,
       task.ENCOUNTER_SN,
       task.COMPLETE_TIME,
       task.STATUS,
       task.MEMO,
       tasktype.NM TASK_TYPE_NM,
       tasktype.MD_MR_TP_CD,
       tp.nm MD_MR_TP_NM,
       trunc((task.end_time - sysdate) * 24) SURPLUS_TIME
  FROM XAP_TASK task
  right join xap_task_type tasktype on task.TASK_TYPE_CD =
                                      tasktype.TASK_TYPE_CD
                                  and tasktype.del_f = 0
  right join md_mr_tp tp on tp.mr_tp_cd =
                           (case when instr(tasktype.md_mr_tp_cd, ',') > 0 then
                            substr(tasktype.md_mr_tp_cd,
                                   0,
                                   instr(tasktype.md_mr_tp_cd, ',') - 1) else
                            tasktype.md_mr_tp_cd end)
                       and tp.del_f = 0
 where task.del_f = 0
/*%if encounterSn != null */
and ENCOUNTER_SN = /*encounterSn*/'aa'
/*%end*/
and task.STATUS <> 'XAPM20.03'