select
  QA_DIVIDE_LEVEL_CD,
  MIN_SCR,
  MAX_SCR,
  LVL,
  MEMO,
  SORT_NO,
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
  QA_DIVIDE_LEVEL
where
  QA_DIVIDE_LEVEL_CD = /* qaDivideLevelCd */'a'
and del_f = 0
