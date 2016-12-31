select 
  count(flt.QA_FLT_PK) as faultTotal, --缺陷数
  count(case when flt.FLT_STA_CD='QAM01.02' then 1 else null end ) as faultTodoReform, --待改数
  count(case when flt.FLT_STA_CD='QAM01.03' then 1 else null end ) as faultTodoReview, --待审数
  count(case when (flt.SBMT_TIME+qa.rfm_deadline)>sysdate then 1 else null end ) as faultOverDeadline --逾期数
from MR_AMR amr
  left join QA_FLT flt on amr.EN_PK=flt.EN_PK
  left join QA_FLT_ITM fi on fi.QA_FLT_PK=flt.QA_FLT_PK
  left join QA qa on qa.qa_pk=fi.QA_PK
--  left join MR_TRANS_DEPT td on amr.CUR_DEPT_CD = td.DEPT_CD
  where 1=1
  /*%if enPk != null && enPk != "" */
  and flt.EN_PK = /*enPk*/'a'
  /*%end */
  /*%if qaTypeCode != null && qaTypeCode != "" */
  and qa.QA_TY_CD = /*qaTypeCode*/'a'
  /*%end */
  and amr.DEL_F=0
  and flt.DEL_F=0
  and fi.ACTIVE_F=1