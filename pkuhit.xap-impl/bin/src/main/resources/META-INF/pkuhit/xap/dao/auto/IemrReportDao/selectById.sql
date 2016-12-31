select
  ID,
  NM,
  DEPT_CD,
  URL,
  DES,
  PARA_NM,
  PARA_TP,
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
  IEMR_REPORT
where
  ID = /* id */'a'
and del_f = 0
