select
  FILE_PK,
  FILE_FMT_CD,
  FILE_DATA,
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
  XAP_BASEFILE
where
  FILE_PK = /* filePk */'a'
and del_f = 0
