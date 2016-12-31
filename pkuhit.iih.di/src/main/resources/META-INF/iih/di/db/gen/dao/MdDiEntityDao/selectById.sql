select
  DI_CD,
  ORG_CD,
  NM,
  DES,
  ICD_CD,
  INF_F,
  SYM_F,
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
  MD_DI
where
  DI_CD = /* diCd */'a'
and del_f = 0
