select distinct EN_TP_CD
  from MD_MR_TP_CCAT_ITM
 where MR_TP_CD = /*typeCode*/'MRM16.70'
   and del_f = 0
 order by EN_TP_CD