select
  PFMLOG_PK,
  USER_ID,
  XSV_CD,
  INPUT,
  OUTPUT,
  ELAPSED_TIME,
  BEGIN_TIME,
  END_TIME,
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
  XAP_PFMLOG
where
  PFMLOG_PK = /* pfmlogPk */'a'
and del_f = 0
