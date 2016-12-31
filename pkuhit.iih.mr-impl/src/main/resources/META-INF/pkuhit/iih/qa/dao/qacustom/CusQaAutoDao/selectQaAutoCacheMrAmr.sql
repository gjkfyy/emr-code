select 
       amr.EN_PK,
       
       amr.EN_TP_CD,
       
       amr.AMR_STA_CD,
       
       amr.CUR_DEPT_CD

  from MR_AMR amr
      
 where 1 = 1
 
      /*%if statusStr != null && statusStr != "" */
   and amr.AMR_STA_CD = /*statusStr*/'1'
      /*%end */
      /*%if curDeptId != null && curDeptId != "" */
   and amr.CUR_DEPT_CD = /*curDeptId*/'1'
      /*%end */
      
   and amr.en_tp_cd = 'ENM01.04' --就诊类型为住院
   
   and amr.DEL_F = 0
   
  order by amr.CUR_BED_CD