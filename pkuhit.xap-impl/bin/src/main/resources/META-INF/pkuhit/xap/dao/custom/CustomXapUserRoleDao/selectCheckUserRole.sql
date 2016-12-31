select
USER_ROLE_CD,
USER_ID,
ROLE_CD,
ORG_CD,
START_TIME,
STOP_TIME
from xap_user_role 
where del_f='0'
/*%if deptCd != null*/
  and org_cd= /* deptCd */'4309' 
/*%end*/
/*%if userId != null*/
  and user_Id=/* userId */'005285'
/*%end*/
  and role_cd='XAPM14.24' 
