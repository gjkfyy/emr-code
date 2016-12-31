select
  MR_SIGN_PK,
  MR_PK,
  SIGN_LVL_CD,
  SIGN_TIME,
  SIGN_USER_ID,
  SIGN_DEPT_CD,
  UPD_CNT,
  CRT_TIME,
  CRT_USER_ID,
  CRT_DEPT_CD,
  LAST_UPD_TIME,
  LAST_UPD_DEPT_CD,
  LAST_UPD_USER_ID,
  DEL_F
from
  MR_SIGN
where
  MR_SIGN_PK = /* mrSignPk */'a'
and del_f = 0
