select
  QA_ITM_CONFIG_CD,
  QA_ITM_CD,
  REQ,
  MR_TYPES,
  /*%if eventTypeCode != null*/
  /*eventTypeCode*/'a' as EVENT_TYPE_CODE,
  /*%else */
  EVENT_TYPE_CODE,
  /*%end */
  DEAD_HOURS,
  USE_FLAG,
  MEMO,
  SORT_NO,
  SPELL_NO,
  WUBI_NO,
  UPD_CNT,
  CRT_TIME,
  CRT_USER_ID,
  CRT_DEPT_CD,
  LAST_UPD_TIME,
  LAST_UPD_DEPT_CD,
  LAST_UPD_USER_ID,
  DEL_F,
  MR_OP_TYPE,
  QA_ITM_TP_CD,
  DCT_OP_TP_CD,
  JOB_TITLE_CD,
  QA_RL_TP_CD,
  QA_RL_CD
from
  QA_AUTO_ITM_CONFIG
where 1=1
/*%if eventTypeCode != null*/
and EVENT_TYPE_CODE like /* @contain(eventTypeCode) */'%g%'
/*%end */
and del_f = 0