select
  SPL_FM_CD,
  MR_PK,
  SYMPTOM,
  EVAL_PROJECT,
  CONTENT,
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
  MR_SPL_FM
where
  SPL_FM_CD = /* splFmCd */'a'
and del_f = 0
