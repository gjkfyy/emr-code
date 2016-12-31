select
  ROLE_FU_CD,
  ROLE_CD,
  FU_CD,
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
  XAP_ROLE_FU
where
  ROLE_CD = /* roleCd */'a'
and del_f = 0
