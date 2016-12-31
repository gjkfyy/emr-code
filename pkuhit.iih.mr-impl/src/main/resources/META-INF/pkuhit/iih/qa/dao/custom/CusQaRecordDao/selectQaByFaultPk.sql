select
  qa.QA_PK,
  qa.QA_SYS_CD,
  qa.EN_PK,
  qa.QA_TY_CD,
  qa.AUTO_F,
  qa.PLAN_TIME,
  qa.EXEC_BEGIN_TIME,
  qa.EXEC_END_TIME,
  qa.EXEC_USER_ID,
  qa.EXEC_DEPT_CD,
  qa.CMPL_F,
  qa.HAVE_FLT_F,
  qa.NEED_RFM_FLT_F,
  qa.RFM_DEADLINE,
  qa.DEADLINE,
  qa.UPD_CNT,
  qa.CRT_TIME,
  qa.CRT_USER_ID,
  qa.CRT_DEPT_CD,
  qa.LAST_UPD_TIME,
  qa.LAST_UPD_DEPT_CD,
  qa.LAST_UPD_USER_ID,
  qa.DEL_F
from
  QA qa
  left join QA_FLT_ITM fi on fi.QA_PK=qa.QA_PK
  left join QA_FLT flt on flt.QA_FLT_PK=fi.QA_FLT_PK
where 1=1
  and flt.QA_FLT_PK = /* faultPk */'a'
  and qa.CMPL_F=0
  and fi.ACTIVE_F=1
