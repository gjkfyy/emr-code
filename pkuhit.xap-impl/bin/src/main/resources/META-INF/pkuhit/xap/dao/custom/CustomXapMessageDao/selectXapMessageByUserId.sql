select mes.MES_ID,
       mes.SEND_USER_ID,
       mes.SEND_DATE,
       mes.RECEIVE_USER_ID,
       mes.RECEIVE_DATE,
       mes.PORTAL_CD,
       mes.MENU_CD,
       mes.CONTENT,
       mes.READ_FLAG,
       mes.MES_LEVEL,
       mes.MES_TYPE,
       mes.MEMO,
       mes.SORT_NO,
       mes.SPELL_NO,
       mes.WUBI_NO,
       mes.UPD_CNT,
       mes.CRT_TIME,
       mes.CRT_USER_ID,
       mes.CRT_DEPT_CD,
       mes.LAST_UPD_TIME,
       mes.LAST_UPD_DEPT_CD,
       mes.LAST_UPD_USER_ID,
       mes.DEL_F,
       task.TASK_ID,
       task.ENCOUNTER_SN
  from XAP_MESSAGE mes
  left join XAP_TASK task on mes.TASK_ID = task.TASK_ID and task.DEL_F = 0
  left join QA_AUTO_ITM_CONFIG qa on task.TASK_TYPE_CD = qa.QA_ITM_CD 
 where mes.RECEIVE_USER_ID = /* userId */'a'
   and mes.DEL_F = 0
   and (task.STATUS <> 'XAPM20.03' or task.STATUS is null)
   and (task.END_TIME is null or (task.task_type_cd like 'QAM16%' and to_number(task.END_TIME-sysdate)*24 < qa.RE_TIME_REMIND) )
 order by mes.SEND_DATE desc