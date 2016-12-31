select
  QA_PK,
  QA_SYS_CD,
  EN_PK,
  QA_TY_CD,
  AUTO_F,
  PLAN_TIME,
  EXEC_BEGIN_TIME,
  EXEC_END_TIME,
  EXEC_USER_ID,
  EXEC_DEPT_CD,
  CMPL_F,
  HAVE_FLT_F,
  NEED_RFM_FLT_F,
  RFM_DEADLINE,
  DEADLINE,
  UPD_CNT,
  CRT_TIME,
  CRT_USER_ID,
  CRT_DEPT_CD,
  LAST_UPD_TIME,
  LAST_UPD_DEPT_CD,
  LAST_UPD_USER_ID,
  DEL_F
from
  QA
where 1=1
  /*%if enPk != null && enPk != "" */
  and EN_PK = /* enPk */'a'
  /*%end */
  /*%if userId != null && userId != "" */
  and CRT_USER_ID = /* userId */'a'
  /*%end */
  and AUTO_F=0
  /*%if cmplF != null */
  and CMPL_F=/* cmplF */0
  /*%end */
  and DEL_F=0
order by CRT_TIME desc