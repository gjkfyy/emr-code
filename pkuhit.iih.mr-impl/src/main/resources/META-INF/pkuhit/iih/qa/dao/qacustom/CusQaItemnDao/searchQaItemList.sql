select  itm.QA_ITM_CD,
		itm.REQ,
		itm.QA_DRP_SCR_TP_CD,
		itm.FST_CD,
	    itm.SND_CD,
	    itm.DEDUCT_DES,
	    itm.ONCE_DRP_SCR,
        itm.MAX_DRP_SCR,
        itm.AUTO_QA_F,
        q.USE_FLAG,
        q.QA_ITM_TP_CD
  from QA_ITM itm
  left join QA_AUTO_ITM_CONFIG q on itm.qa_itm_cd = q.qa_itm_cd
  where 1=1
 
  /*%if itemFirstCode != null && itemFirstCode != "" */
   and itm.fst_cd = /* itemFirstCode */'a'
  /*%end */
  /*%if itemSecondCode != null && itemSecondCode != "" */
   and itm.snd_cd = /* itemSecondCode */'b'
   /*%end */
   and itm.del_f = 0

