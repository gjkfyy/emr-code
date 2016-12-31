select
  MR_TP_CCAT_ITM_CD,
  MR_TP_CCAT_CD,
  MR_TP_CD,
  EN_TP_CD,
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
  MD_MR_TP_CCAT_ITM
where
  MR_TP_CCAT_ITM_CD = /* mrTpCcatItmCd */'a'
and del_f = 0
