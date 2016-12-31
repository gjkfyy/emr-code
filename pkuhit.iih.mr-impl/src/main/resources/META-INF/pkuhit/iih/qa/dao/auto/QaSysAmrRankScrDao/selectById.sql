select
  QA_SYS_AMR_RANK_SCR_CD,
  QA_SYS_AMR_CD,
  AMR_RANK_CD,
  MAX_SCR,
  MIN_SCR
from
  QA_SYS_AMR_RANK_SCR
where
  QA_SYS_AMR_RANK_SCR_CD = /* qaSysAmrRankScrCd */'a'
and del_f = 0
