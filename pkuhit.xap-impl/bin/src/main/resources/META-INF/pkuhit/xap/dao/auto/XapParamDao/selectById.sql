select
  PARAM_CD,
  NM,
  CODE,
  KEY,
  VALUE,
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
  XAP_PARAM
where
  PARAM_CD = /* paramCd */'a'
and del_f = 0
