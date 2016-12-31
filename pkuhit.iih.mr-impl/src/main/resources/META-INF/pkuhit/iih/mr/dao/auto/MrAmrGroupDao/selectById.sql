select
  MR_AMR_GROUP_CD,
  NAME,
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
  MR_AMR_GROUP
where
  MR_AMR_GROUP_CD = /* mrAmrGroupCd */'a'
and del_f = 0
