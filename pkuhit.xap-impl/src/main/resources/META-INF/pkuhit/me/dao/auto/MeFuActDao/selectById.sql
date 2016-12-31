select
  FU_ACT_CD,
  FU_CD,
  XSV_CD,
  ACT_TP_CD,
  NM,
  DES,
  SHT_NM_EN,
  NM_EN,
  SORT_NO,
  UPD_CNT,
  CRT_TIME,
  CRT_USER_ID,
  CRT_DEPT_CD,
  LAST_UPD_TIME,
  LAST_UPD_DEPT_CD,
  LAST_UPD_USER_ID,
  DEL_F
from
  ME_FU_ACT
where
  FU_ACT_CD = /* fuActCd */'a'
and del_f = 0
