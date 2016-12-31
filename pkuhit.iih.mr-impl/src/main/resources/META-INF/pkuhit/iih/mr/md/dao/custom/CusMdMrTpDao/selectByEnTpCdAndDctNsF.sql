 select  tp.mr_tp_cd, tp.nm, tp.sort_no
from MD_MR_TP tp 
where tp.del_f = 0 
and tp.mr_tp_cd in (
select itm.mr_tp_cd
from MD_MR_TP_CCAT_ITM itm 
 join MD_MR_TP_CCAT cat 
on itm.mr_tp_ccat_cd = cat.mr_tp_ccat_cd
where 
cat.del_f = 0 
        /*%if mrTpCcatCd != null && mrTpCcatCd != ""*/
         and cat.mr_tp_ccat_cd = /*mrTpCcatCd*/'a'
        /*%end */
       /*%if dctNsF != null && dctNsF != ""*/
         and cat.dct_ns_f = /*dctNsF*/'a'
        /*%end */
        /*%if enTpCd != null && enTpCd != "" */
  and itm.en_tp_cd = /*enTpCd*/'ENM01.04'
 /*%end */
)
  
 order by tp.sort_no
