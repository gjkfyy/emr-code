select
  QA_AUTO_FLT_PK,
  QA_ITM_CD,
  DOC_SN,
  EVENT_ID,
  BEGIN_TIME,
  END_TIME,
  ENCOUNTER_SN,
  COMPLETE_TIME,
  APPLY_FLAG,
  FLT_FLAG,
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
  QA_AUTO_FLT
where
  QA_AUTO_FLT_PK = /* qaAutoFltPk */'a'
and del_f = 0
