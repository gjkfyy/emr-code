select 
  count(flt.QA_FLT_PK) as faultTotal --缺陷数
 from MR_AMR amr
  left join QA_FLT flt on amr.EN_PK=flt.EN_PK
  where 1=1
  /*%if enPk != null && enPk != "" */
  and flt.EN_PK = /*enPk*/'722189'
  /*%end */
  /*%if qaTypeCode != null && qaTypeCode != "" */
  and flt.QA_TY_CD = /*qaTypeCode*/'a'
  /*%end */
  and amr.DEL_F=0
  and flt.DEL_F=0