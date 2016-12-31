select
  MR_FR_TPL_CD,
  FILE_PK,
  NM,
  STATUS,
  MR_FR_TPL_TP_CD,
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
  MR_FR_TPL
where
  MR_FR_TPL_CD = /* mrFrTplCd */'a'
and del_f = 0
