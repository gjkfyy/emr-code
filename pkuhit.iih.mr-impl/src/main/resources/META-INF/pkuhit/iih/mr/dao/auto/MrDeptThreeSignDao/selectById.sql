select
  SING_CD,
  DEPT_CD,
  EMPLOYEE_CD,
  SIGN_LVL_CD,
  MNG_DCT_ID,
  SUP_DCT_ID,
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
  MR_DEPT_THREE_SIGN
where
  SING_CD = /* singCd */'a'
and del_f = 0
