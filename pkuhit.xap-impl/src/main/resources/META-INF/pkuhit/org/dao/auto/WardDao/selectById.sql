select
  WARD_CD,
  NM,
  DES,
  ALIAS_NM,
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
  WARD
where
  WARD_CD = /* wardCd */'a'
and del_f = 0
