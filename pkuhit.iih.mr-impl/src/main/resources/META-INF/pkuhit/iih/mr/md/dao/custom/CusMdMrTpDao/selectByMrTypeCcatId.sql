select distinct tp.MR_TP_CD,
tp.NM,
tp.DES,
tp.MR_SIGN_LVL_CD,
tp.ONLY_F,
tp.NEW_PAGE_F,
tp.SORT_NO,
tp.MEMO,
tp.PERMIT_F
  from MD_MR_TP tp, MD_MR_TP_CCAT_ITM itm
 where tp.MR_TP_CD = itm.MR_TP_CD
   and tp.del_f = 0
   and itm.del_f = 0
/*%if mrTypeCcatId != null && mrTypeCcatId != "" && mrTypeCcatId !="all"*/
 and itm.MR_TP_CCAT_CD = /*mrTypeCcatId*/'MRM14.02'
/*%end */
 order by to_number(tp.sort_no)