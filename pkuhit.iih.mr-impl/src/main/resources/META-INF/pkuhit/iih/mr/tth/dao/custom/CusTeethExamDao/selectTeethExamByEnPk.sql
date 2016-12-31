select TEETH_PK,
       EN_PK,
       EXAM_DOCTOR_CD,
       EXAM_DATE,
       BOP,
       DI_DESC,
       OTH_DESC,
       TREAT_DESIGN
  from MR_TEETH_EXAM
 where 1 = 1
   /*%if enPk != null && enPk != "" */
   and EN_PK = /*enPk*/'a'
   /*%end */