select distinct MR_TP_CCAT_CD
from MD_MR_TP_CCAT_ITM
 where
  MR_TP_CD = /*typeCode*/'MRM16.70'
  and del_f = 0
  order by MR_TP_CCAT_CD