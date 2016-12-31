select
  SND_CD,
  FST_CD,
  SCORE,
  NM,
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
  QA_ITM_SND q
where 1=1
/*%if nm != null*/
and q.NM = /*nm*/'1'
/*%end */
and del_f = 0
