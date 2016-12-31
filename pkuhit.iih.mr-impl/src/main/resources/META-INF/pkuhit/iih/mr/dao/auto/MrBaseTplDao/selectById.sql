select
  MR_BASE_TPL_CD,
  FILE_PK,
  NM,
  DES,
  PAPER_TP_CD,
  MR_BASE_TPL_STA_CD,
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
  MR_BASE_TPL
where
  MR_BASE_TPL_CD = /* mrBaseTplCd */'a'
and del_f = 0
