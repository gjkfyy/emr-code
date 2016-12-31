select
  MR_TPL_DI_CD,
  MR_TPL_CD,
  DI_CD,
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
  MR_TPL_DI
where
  MR_TPL_DI_CD = /* mrTplDiCd */'a'
and del_f = 0
