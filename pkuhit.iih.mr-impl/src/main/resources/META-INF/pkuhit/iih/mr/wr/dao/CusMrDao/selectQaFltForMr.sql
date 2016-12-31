select
  flt.QA_FLT_PK
from
  QA_FLT flt
left join QA_FLT_ITM fi on fi.QA_FLT_PK = flt.QA_FLT_PK
left join QA qa on fi.QA_PK = qa.QA_PK
left join MR mr on mr.MR_PK = flt.TAR_OBJ_PK
where 1=1 
  /*%if mrPk != null && mrPk != "" */
  and mr.MR_PK = /*mrPk*/'a'
  /*%end */
  /*%if qaTypeCode != null && qaTypeCode != "" */
  and qa.QA_TY_CD = /*qaTypeCode*/'QAM03.01'
  /*%end */
  and flt.FLT_STA_CD = 'QAM01.02'
  and fi.ACTIVE_F = 1
  and flt.DEL_F = 0