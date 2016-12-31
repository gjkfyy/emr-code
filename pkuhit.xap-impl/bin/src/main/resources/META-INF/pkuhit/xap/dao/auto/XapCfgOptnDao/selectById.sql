select
  OPTN_CD,
  CFG_CD,
  NM,
  DES,
  VAL,
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
  XAP_CFG_OPTN
where
  OPTN_CD = /* optnCd */'a'
and del_f = 0
