select
  DATA_ACRU_CD,
  OBJ_CD,
  NM,
  DES,
  SHT_NM_EN,
  NM_EN,
  RULE,
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
  ME_DATA_ACRU
where
  DATA_ACRU_CD = /* dataAcruCd */'a'
and del_f = 0
