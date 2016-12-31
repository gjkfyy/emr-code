select
  IEMR_REPORT_ROLE_ID,
  IEMR_REPORT_ID,
  ROLE_CD,
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
  IEMR_REPORT_ROLE
where
  IEMR_REPORT_ROLE_ID = /* iemrReportRoleId */'a'
and del_f = 0
