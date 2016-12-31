select
  DEPT_CD,
  WARD_CD,
  ORG_CD,
  DEPT_TP_CD,
  NM,
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
  WARD_DEPT
where
  DEPT_CD = /* deptCd */'a'
and del_f = 0
