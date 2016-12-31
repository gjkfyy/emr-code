select div.QA_ITM_PK,
       
       itm.once_drp_scr,
       itm.SND_CD,
       itm.fst_cd,
       itm.QA_DRP_SCR_TP_CD,
       fst.score as firstMaxScore,
       snd.score as secondMaxScore,
       itm.max_drp_scr,
       sum(div.DEDUCT_SCR_TIMES),
       (case
         when sum(itm.once_drp_scr * div.DEDUCT_SCR_TIMES) < itm.max_drp_scr then
          sum(itm.once_drp_scr * div.DEDUCT_SCR_TIMES)
         else
          (case
            when itm.max_drp_scr is null then
             sum(itm.once_drp_scr * div.DEDUCT_SCR_TIMES)
            else
             max_drp_scr
          end)
       end) as itemScore,
       sum(itm.once_drp_scr * div.DEDUCT_SCR_TIMES) as itemScoreTemp

  from QA_DIVIDE div
  left join QA_ITM itm
    on div.QA_ITM_PK = itm.QA_ITM_CD
  left join QA_ITM_FST fst
    on itm.FST_CD = fst.FST_CD
   left join QA_ITM_SND snd
    on itm.SND_CD = snd.SND_CD
 where 1 = 1
      
   /*%if encounterPk != null && encounterPk != "" && encounterPk != "undefined" */
  and div.EN_PK = /*encounterPk*/'a'
  /*%end */
  
   /*%if qaTypeCode != null && qaTypeCode != "" */
   /*%if qaTypeCode == "QAM13.02"*/
  and (div.QA_TY_CD = /*qaTypeCode*/'QAM13.02' or QA_TY_CD = 'QAM13.06') --科室自动质控评分暂时不用'QAM13.05'
  /*%end */
    /*%if qaTypeCode == "QAM13.03"*/
  and (div.QA_TY_CD = /*qaTypeCode*/'QAM13.03' or QA_TY_CD = 'QAM13.06')
  /*%end */
    /*%if qaTypeCode == "QAM13.06"*/
  and (div.QA_TY_CD = 'QAM13.06')
  /*%end */
  /*%end */
 
  and div.del_f = '0'
  group by div.qa_itm_pk, 
  itm.once_drp_scr, 
  itm.max_drp_scr,  
  itm.SND_CD,
  itm.fst_cd, 
  fst.score ,
  snd.score ,
  itm.QA_DRP_SCR_TP_CD
