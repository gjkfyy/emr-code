select
  QA_ITM_CD,
  REQ,
  QA_DRP_SCR_TP_CD,
  ONCE_DRP_SCR,
  MAX_DRP_SCR,
  DFT_RFM_F,
  AUTO_QA_F,
  FST_CD,
  SND_CD,
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
  DEDUCT_DES
from
  QA_ITM
where
  QA_ITM_CD = /* qaItmCd */'a'
and del_f = 0
