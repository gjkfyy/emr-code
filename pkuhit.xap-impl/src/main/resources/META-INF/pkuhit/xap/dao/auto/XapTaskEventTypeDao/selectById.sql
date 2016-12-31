select
  TASK_EVENT_TYPE_CD,
  TASK_TYPE_CD,
  EVENT_TYPE_CD,
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
  DEL_F
from
  XAP_TASK_EVENT_TYPE
where
  TASK_EVENT_TYPE_CD = /* taskEventTypeCd */'a'
and del_f = 0
