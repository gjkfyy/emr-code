select mmtc.mr_tp_ccat_cd, mmtc.nm
  from md_mr_tp_ccat mmtc
 where mmtc.del_f = '0'
   and mmtc.mr_tp_ccat_cd in (select mmtci.mr_tp_ccat_cd
                                from md_mr_tp_ccat_itm mmtci
                               where mmtci.del_f = '0'
                                 /*%if enTpCd != null && enTpCd != "" */
                                 and mmtci.en_tp_cd = /*enTpCd*/'a'
                                /*%end */
                              )
   /*%if doctorNuserFlag != null */
   and mmtc.dct_ns_f = /*doctorNuserFlag*/1
   /*%end */
order by CAST(mmtc.sort_no AS INTEGER)