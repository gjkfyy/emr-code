select
  ORG_CD,
  ORG_TP_CD,
  NM,
  DES,
  SHT_NM,
  ALIAS_NM,
  DIST_CD,
  SUBDIST_NM,
  ZIP_NO,
  TEL_NO,
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
  ORG
where
  ORG_CD = /* orgCd */'a'
and del_f = 0
