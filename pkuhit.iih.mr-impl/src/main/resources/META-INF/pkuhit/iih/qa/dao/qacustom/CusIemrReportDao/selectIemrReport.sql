select
  distinct ir.ID,
  ir.NM,
  ir.DEPT_CD,
  ir.URL,
  ir.DES,
  ir.PARA_NM,
  ir.PARA_TP,
  ir.MEMO,
  ir.SORT_NO,
  ir.SPELL_NO,
  ir.WUBI_NO
from
  IEMR_REPORT ir
  left join IEMR_REPORT_ROLE irr on irr.IEMR_REPORT_ID=ir.ID
  left join XAP_USER_ROLE xur on xur.ROLE_CD=irr.ROLE_CD
where
  xur.USER_ID=/*userId*/'004917'
  /*%if reportType != null && reportType != "" */
  and ir.MEMO = /*reportType*/'QA'
  /*%end */
  and ir.DEL_F = 0
