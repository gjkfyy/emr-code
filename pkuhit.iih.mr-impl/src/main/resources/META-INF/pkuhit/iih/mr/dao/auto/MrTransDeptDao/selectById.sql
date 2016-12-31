select
  MR_TRANS_DEPT_PK,
  EN_PK,
  DEPT_CD,
  TRANS_TIME,
  UPD_CNT,
  CRT_TIME,
  CRT_USER_ID,
  CRT_DEPT_CD,
  LAST_UPD_TIME,
  LAST_UPD_DEPT_CD,
  LAST_UPD_USER_ID,
  DEL_F
from
  MR_TRANS_DEPT
where
  MR_TRANS_DEPT_PK = /* mrTransDeptPk */'a'
and del_f = 0
