select
  r.ID,
  r.NM,
  r.DEPT_CD,
  r.URL,
  r.DES,
  r.PARA_NM,
  r.PARA_TP,
  r.MEMO
from
  IEMR_REPORT r
  left join IEMR_REPORT_ROLE rr on rr.IEMR_REPORT_ID=r.ID
  where rr.ROLE_CD=/*roleCode*/'XAPM14.08'