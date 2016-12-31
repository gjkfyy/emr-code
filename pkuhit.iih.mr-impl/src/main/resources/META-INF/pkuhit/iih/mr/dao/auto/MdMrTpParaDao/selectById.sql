select
  MD_MR_TP_PARA_PK,
  MD_MR_TP_CD,
  MD_MR_PARA_CD,
  DEL_F
from
  MD_MR_TP_PARA
where
  MD_MR_TP_PARA_PK = /* mdMrTpParaPk */'a'
and del_f = 0
