select
  QA_SYS_CD,
  ORG_CD,
  RT_QA_SYS_CD,
  VER_NO,
  IN_USE_F,
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
  QA_SYS
where
  QA_SYS_CD = /* qaSysCd */'a'
and del_f = 0
