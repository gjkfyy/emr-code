select
  STALOG_PK,
  USER_ID,
  OBJ_ATTR_CD,
  OB_PK,
  PRE_STA_CD,
  NEXT_STA_CD,
  ACT_TIME,
  ACT_DEPT_CD,
  UPD_CNT,
  CRT_TIME,
  CRT_USER_ID,
  CRT_DEPT_CD,
  LAST_UPD_TIME,
  LAST_UPD_DEPT_CD,
  LAST_UPD_USER_ID,
  DEL_F
from
  XAP_STALOG
where
  STALOG_PK = /* stalogPk */'a'
and del_f = 0
