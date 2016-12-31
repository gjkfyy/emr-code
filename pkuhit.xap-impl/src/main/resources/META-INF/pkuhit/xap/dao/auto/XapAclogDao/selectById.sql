select
  ACLOG_PK,
  USER_ID,
  XSV_CD,
  INPUT,
  OUTPUT,
  ACT_TIME,
  ACT_DEPT_CD,
  UPD_CNT,
  CRT_TIME,
  CRT_USER_ID,
  CRT_DEPT_CD,
  LAST_UPD_TIME,
  LAST_UPD_DEPT_CD,
  LAST_UPD_USER_ID,
  DEL_F
from
  XAP_ACLOG
where
  ACLOG_PK = /* aclogPk */'a'
and del_f = 0
