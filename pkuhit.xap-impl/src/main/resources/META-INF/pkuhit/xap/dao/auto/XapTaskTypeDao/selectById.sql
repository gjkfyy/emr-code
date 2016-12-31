select
  TASK_TYPE_CD,
  NM,
  MD_MR_TP_CD,
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
  DEAD_HOURS,
  USE_FLAG,
  QA_ITM_TP_CD,
  DCT_OP_TP_CD,
  JOB_TITLE_CD,
  QA_RL_TP_CD,
  QA_RL_CD
from
  XAP_TASK_TYPE
where
  TASK_TYPE_CD = /* taskTypeCd */'a'
and del_f = 0
