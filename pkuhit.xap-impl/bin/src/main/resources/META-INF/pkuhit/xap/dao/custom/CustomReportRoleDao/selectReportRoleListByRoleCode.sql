select
  IEMR_REPORT_ROLE_ID,
  IEMR_REPORT_ID,
  ROLE_CD,
  MEMO
from
  IEMR_REPORT_ROLE
  where ROLE_CD=/*roleCode*/'XAPM14.08'