select ccat.mr_tp_ccat_cd
  from md_mr_tp_ccat_itm ccat
 where ccat.del_f = 0
   and ccat.mr_tp_cd = /*mrTpCd*/'aa'
   and ccat.en_tp_cd =
       (select amr.en_tp_cd from mr_amr amr where amr.en_pk = /*encounterSn*/'aa')