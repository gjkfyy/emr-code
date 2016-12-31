select
  MD_MR_PARA_CD,
  NM,
  DEL_F
from
  MD_MR_PARA
where
  MD_MR_PARA_CD = /* mdMrParaCd */'a'
and del_f = 0
