select
  AMR_RANK_SCR_CD,
  AMR_RANK_CD,
  ORG_CD,
  MAX_SCR,
  MIN_SCR,
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
  MR_AMR_RANK_SCR
where
  AMR_RANK_SCR_CD = /* amrRankScrCd */'a'
and del_f = 0
