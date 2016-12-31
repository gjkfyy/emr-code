select
  QA_FLT_ITM_PK,
  QA_PK,
  QA_FLT_PK,
  ACTIVE_F,
  SORT_NO,
  UPD_CNT,
  CRT_TIME,
  CRT_USER_ID,
  CRT_DEPT_CD,
  LAST_UPD_TIME,
  LAST_UPD_DEPT_CD,
  LAST_UPD_USER_ID,
  DEL_F
from
  QA_FLT_ITM
where
  QA_FLT_PK = /* faultPk */'a'
  and ACTIVE_F = 1