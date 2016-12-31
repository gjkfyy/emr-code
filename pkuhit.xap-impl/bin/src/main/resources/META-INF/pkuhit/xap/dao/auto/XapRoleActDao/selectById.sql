select
  ROLE_ACT_CD,
  ROLE_FU_CD,
  FU_ACT_CD,
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
  XAP_ROLE_ACT
where
  ROLE_ACT_CD = /* roleActCd */'a'
and del_f = 0
