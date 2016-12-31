select
  DI_SUITE_CD,
  DI_CD,
  DI_SUITE_TP_CD,
  OWNER_TYPE_CD,
  OWNER_CD,
  ORG_CD,
  DESCR,
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
  DI_SUITE
where
  DI_SUITE_CD = /* diSuiteCd */'a'
and del_f = 0
