select
  ROLE_ACRU_CD,
  ROLE_ACT_CD,
  DATA_ACRU_CD,
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
  XAP_ROLE_ACRU
where
  ROLE_ACRU_CD = /* roleAcruCd */'a'
and del_f = 0
