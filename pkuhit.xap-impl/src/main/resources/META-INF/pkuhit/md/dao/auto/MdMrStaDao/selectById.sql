select
  MR_STA_CD,
  SIGN_LVL_CD,
  NEXT_MR_STA_CD,
  PRE_MR_STA_CD,
  NM,
  DES,
  SHT_NM_EN,
  NM_EN,
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
  MD_MR_STA
where
  MR_STA_CD = /* mrStaCd */'a'
and del_f = 0
