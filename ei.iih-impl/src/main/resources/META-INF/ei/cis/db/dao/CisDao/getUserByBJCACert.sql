select user_id xap_user_pk,
       employment_id USER_ID,
       employment_id emp_id,
       case active
         when '1' then
          'XAPM01.01'
         when '0' then
          'XAPM01.02'
       end USER_STA_CD,
       '' SIGN_PIC,
       case password
         when '' then
          'MTIzNA=='
         else
          password
       end PWD,
       legal_name nm,
       lower(py_code) NM_SPELL,
       case gender
         when '2' then
          'MDM05.02'
         when '1' then
          'MDM05.01'
       end SEX_CD,
       '' EMAIL,
       '' JOB_TITLE_CD,
       '' MOBILE_NO,
       tel_addr TEL_NO,
       org_id ORG_CD,
       0 del_f,
       login_name login_nm,
       0 UPD_CNT
  from auth_user u, employee e
 where u.employment_id = e.emp_sn
   and u.sys_id = 'CIS'
      /*%if strCertId != null */
 		AND  e.id_card = /*strCertId*/'SF11010119790705005' 
     /*%end */
