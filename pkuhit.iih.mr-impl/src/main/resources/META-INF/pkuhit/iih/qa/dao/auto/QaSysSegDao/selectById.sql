select
  QA_SYS_SEG_CD,
  QA_SYS_MR_CD,
  MR_SEG_TP_CD,
  REQ,
  TTL_SCR,
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
  QA_SYS_SEG
where
  QA_SYS_SEG_CD = /* qaSysSegCd */'a'
and del_f = 0
