select
  QA_SYS_RULE_CD,
  QA_SYS_ITM_CD,
  RULE_CD,
  SORT_NO,
  UPD_CNT,
  CRT_TIME,
  CRT_USER_ID,
  CRT_DEPT_CD,
  LAST_UPD_TIME,
  LAST_UPD_DEPT_CD,
  LAST_UPD_USER_ID,
  DEL_F
from
  QA_SYS_RULE
where
  QA_SYS_RULE_CD = /* qaSysRuleCd */'a'
and del_f = 0
