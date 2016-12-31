select
  PARA_PK,
  PA_ID,
  EN_PK,
  MR_PK,
  MR_TPL_CD,
  MR_TP_CD,
  PARA_CD,
  PARA_NM,
  PARA_CONTENT,
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
  MR_PARA
where
  PARA_PK = /* paraPk */'a'
and del_f = 0
