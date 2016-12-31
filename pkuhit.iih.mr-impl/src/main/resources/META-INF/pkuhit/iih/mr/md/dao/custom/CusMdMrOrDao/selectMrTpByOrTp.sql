select mo.MR_TP_CD as mrTpCd,mt.nm as mrTpNm
from MD_MR_OR mo,MD_MR_TP mt
 where mo.MR_TP_CD = mt.MR_TP_CD
   /*%if orTpCd != null && orTpCd != "" */
   and mo.OR_TP_CD = /*orTpCd*/'02'
   /*%end */
   and mo.del_f = '0'
   and mt.del_f = '0'
   order by mt.sort_no