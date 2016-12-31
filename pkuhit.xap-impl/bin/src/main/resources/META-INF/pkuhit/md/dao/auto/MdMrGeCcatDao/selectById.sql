select
  MR_GE_CCAT_CD,
  PAR_MR_GE_CCAT_CD,
  ORG_CD,
  NM,
  DES,
  LVL,
  LEAF_F,
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
  MD_MR_GE_CCAT
where
  MR_GE_CCAT_CD = /* mrGeCcatCd */'a'
and del_f = 0
