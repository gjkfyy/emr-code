select div.QA_DIVIDE_CD,
	   div.QA_ITM_PK,
       div.QA_TY_CD,
       div.EN_PK,
       div.DEDUCT_SCR_TIMES,
       div.DRP_DES,
       div.SBMT_USER_ID,
       u.DCT_NS_F,
       itm.REQ,
       itm.FST_CD,
       itm.DEDUCT_DES,
       fst.NM
       
  from QA_DIVIDE div
  left join QA_ITM itm
    on div.QA_ITM_PK = itm.QA_ITM_CD
  left join QA_ITM_FST fst
    on itm.FST_CD = fst.FST_CD
  left join XAP_USER u 
  	on u.USER_ID=div.SBMT_USER_ID
  where 1=1
   /*%if encounterPk != null && encounterPk != "" && encounterPk != "undefined" */
  and div.EN_PK = /*encounterPk*/'a'
  /*%end */
  /*%if qaTypeCode != null && qaTypeCode != "" */
   /*%if qaTypeCode == "QAM13.02"*/
  and (div.QA_TY_CD = /*qaTypeCode*/'QAM13.02' or QA_TY_CD = 'QAM13.06')--科室自动质控评分暂时不用'QAM13.05'
  /*%end */
  /*%if qaTypeCode == "QAM13.03"*/
  and (div.QA_TY_CD = /*qaTypeCode*/'QAM13.03' or QA_TY_CD = 'QAM13.06')
  /*%end */
   /*%if qaTypeCode == "QAM13.04"*/
  and (div.QA_TY_CD = /*qaTypeCode*/'QAM13.04')
  /*%end */
  /*%end */
  and div.del_f = '0'