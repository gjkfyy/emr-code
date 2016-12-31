select
  TEETH_PK,
  EN_PK,
  EXAM_DOCTOR_CD,
  EXAM_DATE,
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
  MR_TEETH_EXAM
where
  TEETH_PK = /* teethPk */'a'
and del_f = 0
