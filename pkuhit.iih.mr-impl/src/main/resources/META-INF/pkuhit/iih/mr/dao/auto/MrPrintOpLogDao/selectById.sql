select
  PRINT_LOG_CD,
  EN_PK,
  PA_ID,
  EN_CNT,
  MR_PK,
  PRINT_DOCTOR_CD,
  PRINT_TIME,
  SPELL_NO,
  WUBI_NO,
  UPD_CNT,
  CRT_TIME,
  CRT_USER_ID,
  CRT_DEPT_CD,
  LAST_UPD_TIME,
  LAST_UPD_DEPT_CD,
  LAST_UPD_USER_ID,
  DEL_F
from
  MR_PRINT_OP_LOG
where
  PRINT_LOG_CD = /* printLogCd */'a'
and del_f = 0
