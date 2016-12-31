select 
count(case when rn.status in ('QAM11.01','QAM11.02','QAM11.03') then 1 else null end ) revisionNum
from QA_REVISION_NOTICE rn
  where 1=1
  /*%if enPk != null && enPk != "" */
  and rn.EN_PK = /*enPk*/'722189'
  /*%end */
  /*%if qaTypeCode != null && qaTypeCode != "" */
  and rn.QA_TY_CD = /*qaTypeCode*/'a'
  /*%end */
  and rn.DEL_F=0