select
  CFG_DATA_CD,
  CFG_CD,
  VAL,
  MAX_VAL,
  MIN_VAL,
  ORG_CD,
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
  XAP_CFG_DATA
where
  CFG_DATA_CD = /* cfgDataCd */'a'
and del_f = 0
