select
  ENCOUNTER_SN,
  MR_DOC_SN,
  DATA_ELEMENT_ID,
  VALUE,
  MRB_MR_DOC_VALUE_ID,
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
  MR_DOC_VALUE
where
  MRB_MR_DOC_VALUE_ID = /* mrbMrDocValueId */'a'
and del_f = 0
