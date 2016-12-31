select  
 USER_ROLE_CD,
  USER_ID,
  ROLE_CD,
  ORG_CD,
  START_TIME,
  STOP_TIME,
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
  from xap_user_role 
 where del_f = 0
   and role_cd in ('XAPM14.16', 'XAPM14.02', 'XAPM14.03')
/*%if userId != null */
 and USER_ID = /* userId */'a'
/*%end*/