select
  EMP_DEPT_CD,
  WARD_DEPT_CD,
  EMP_ID,
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
  DEL_F,
  SIGN_LVL_CD,
  CUR_DRC_DCT_ID,
  CUR_DEPUTY_DRC_DCT_ID
from
  ORG_EMP_DEPT
where
  EMP_DEPT_CD = /* empDeptCd */'a'
and del_f = 0
