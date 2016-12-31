select
  FU_EV_CD,
  FU_EL_CD,
  FU_ACT_CD,
  EV_TP_CD,
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
  ME_FU_EV
where
  FU_EV_CD = /* fuEvCd */'a'
and del_f = 0
