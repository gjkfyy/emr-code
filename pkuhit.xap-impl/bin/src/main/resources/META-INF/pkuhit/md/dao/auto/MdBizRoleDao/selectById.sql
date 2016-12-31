select
  BIZ_ROLE_CD,
  SIGN_LVL_CD,
  NM,
  DES,
  NM_EN,
  SHT_NM_EN,
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
  MD_BIZ_ROLE
where
  BIZ_ROLE_CD = /* bizRoleCd */'a'
and del_f = 0
