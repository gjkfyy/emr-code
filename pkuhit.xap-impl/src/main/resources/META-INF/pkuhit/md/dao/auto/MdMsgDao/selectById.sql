select
  MSG_CD,
  MSG_TP_CD,
  NM,
  DES,
  NM_EN,
  SHT_NM_EN,
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
  MD_MSG
where
  MSG_CD = /* msgCd */'a'
and del_f = 0
