select
  MR_SHARE_ELEMENT_CD,
  NM,
  DES,
  CATEGORY,
  MACRO_FLAG,
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
  DEL_F,
  DS_SQL
from
  MD_MR_SHARE_ELEMENT
where
  MR_SHARE_ELEMENT_CD = /* mrShareElementCd */'a'
and del_f = 0
