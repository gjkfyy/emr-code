select
  WG_EMP_CD,
  EMP_ID,
  WG_CD,
  BIZ_ROLE_CD,
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
  ORG_WG_EMP
where
  WG_EMP_CD = /* wgEmpCd */'a'
and del_f = 0
