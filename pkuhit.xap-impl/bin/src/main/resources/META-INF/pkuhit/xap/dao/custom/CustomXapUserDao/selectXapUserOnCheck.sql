select
  a.XAP_USER_PK,
  a.USER_ID,
  a.EMP_ID,
  a.USER_STA_CD,
  a.SIGN_PIC,
  a.PWD,
  a.NM,
  a.NM_SPELL,
  a.SEX_CD,
  a.EMAIL,
  a.JOB_TITLE_CD,
  a.MOBILE_NO,
  a.TEL_NO,
  a.ORG_CD,
  a.LOGIN_NM,
  a.IEMR_PWD
from
  XAP_USER a
where
  a.del_f = 0
/*%if orgCd != null*/
  and a.ORG_CD = /* orgCd */'a'
/*%end*/
/*%if iemrPwd != null*/
  and a.IEMR_PWD = /* iemrPwd */'a'
/*%end*/
/*%if userId != null*/
  and a.LOGIN_NM = /* userId */'a'
/*%end*/