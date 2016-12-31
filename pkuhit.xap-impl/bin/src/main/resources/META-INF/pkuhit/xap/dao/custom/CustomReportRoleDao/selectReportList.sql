select
  ID,
  NM,
  DEPT_CD,
  URL,
  DES,
  PARA_NM,
  PARA_TP,
  MEMO
from
  IEMR_REPORT
where
  DEL_F = 0
order by SORT_NO