select amr.EN_PK,
       
       amr.EN_TP_CD,
       
       amr.AMR_STA_CD,
       
       amr.CUR_DEPT_CD

  from qa_auto_flt f
 inner join mr_amr amr
    on f.encounter_sn = amr.en_pk
   and f.div_flag = '1'

 where 1 = 1
   and amr.DEL_F = 0
   and f.DEL_F = 0
     
   and amr.AMR_STA_CD != 'MRM22.01'
   and amr.AMR_STA_CD != 'MRM22.07'
      
   and amr.en_tp_cd = 'ENM01.04' --就诊类型为住院
      
   and amr.qa_auto_scr is null

union all

select amr.EN_PK,
       
       amr.EN_TP_CD,
       
       amr.AMR_STA_CD,
       
       amr.CUR_DEPT_CD
  from qa_auto_flt f
 inner join mr_amr amr
    on f.encounter_sn = amr.en_pk
 WHERE amr.en_pk not in (SELECT Distinct flt.encounter_sn
                           FROM qa_auto_flt flt
                          WHERE flt.flt_flag = 1
                             or flt.flt_flag = 0)

   and amr.DEL_F = 0
   and f.DEL_F = 0
   
   and amr.AMR_STA_CD != 'MRM22.01'
   and amr.AMR_STA_CD != 'MRM22.07'
      
   and amr.en_tp_cd = 'ENM01.04' --就诊类型为住院
      
   and amr.qa_auto_scr is null
