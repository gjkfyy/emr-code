select
  USER_ROLE_CD,
  USER_ID,
  ROLE_CD,
  ORG_CD,
  START_TIME,
  STOP_TIME,
  SORT_NO,
  UPD_CNT,
  CRT_TIME,
  CRT_USER_ID,
  CRT_DEPT_CD,
  LAST_UPD_TIME,
  LAST_UPD_DEPT_CD,
  LAST_UPD_USER_ID,
  DEL_F
from
  XAP_USER_ROLE
where 
 del_f = 0
/*%if userId != null */
  and  USER_ID = /* userId */'a'
/*%end*/
/*%if orgCd != null */
and  ORG_CD = /* orgCd */'a'
/*%end*/
/*%if roleId != null */
and  ROLE_CD = /* roleId */'a'
/*%end*/
