select count(distinct q.qa_work_cd) as qaCount
  from qa q
 where 1 = 1
      /*%if enPk != null && enPk != "" && enPk != "undefined" */
   and q.EN_PK = /*enPk*/'a'
      /*%end */
      /*%if qaTypeCode != null && qaTypeCode != "" */
   and q.QA_TY_CD = /*qaTypeCode*/'a'
      /*%end */
   and q.DEL_F = 0
