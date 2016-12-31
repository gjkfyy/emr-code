select
  USER_ROLE_CD,
  USER_ID,
  ROLE_CD,
  ORG_CD,
  START_TIME,
  STOP_TIME,
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
  XAP_USER_ROLE
where
  USER_ROLE_CD = /* userRoleCd */'a'
and del_f = 0
