select 
  qa.QA_PK,
  qa.EN_PK,
  qa.QA_TY_CD,
  m.amr_no,
  m.pa_nm,
  m.pa_id,
  m.sex_cd,
  m.age,
  m.cur_bed_cd,
  m.rcv_time,
  m.cur_main_di_cd,
  m.cur_mng_dct_id,
  n.status,
  n.rfm_time,
  n.memo,
  n.rfm_doctor_cd,
  qa.PLAN_TIME,
  qa.EXEC_BEGIN_TIME,
  qa.EXEC_END_TIME,
  qa.EXEC_USER_ID,
  qa.EXEC_DEPT_CD,
  qa.CMPL_F,
  qa.HAVE_FLT_F,
  qa.NEED_RFM_FLT_F,
  qa.RFM_DEADLINE,
  qa.DEADLINE,
  qa.REVISION_CD,
  qa.SORT_NO,
  qa.SPELL_NO,
  qa.WUBI_NO,
  qa.UPD_CNT,
  qa.CRT_TIME,
  qa.CRT_USER_ID,
  qa.CRT_DEPT_CD,
  qa.LAST_UPD_TIME,
  qa.LAST_UPD_DEPT_CD,
  qa.LAST_UPD_USER_ID,
  qa.DEL_F
from
  QA qa
left join MR_AMR m on qa.EN_PK=m.EN_PK
left join QA_REVISION_NOTICE n on qa.REVISION_CD=n.REVISION_CD
left join XAP_USER u on u.USER_ID = qa.CRT_USER_ID
left join XAP_USER us on us.USER_ID = n.RFM_DOCTOR_CD

  where 1=1  
  /*%if qaTypeCode != null && qaTypeCode != ""*/
  and qa.QA_TY_CD = /*qaTypeCode*/'a'
  /*%end */
  /*%if crtTimeStart != null && crtTimeStart != "" && crtTimeEnd != null && crtTimeEnd != ""*/
  and qa.CRT_TIME between to_date(/*crtTimeStart*/'a', 'yyyy-MM-dd hh24:mi:ss') and to_date(/*crtTimeEnd*/'a', 'yyyy-MM-dd hh24:mi:ss')
  /*%end */
  /*%if amrNo != null && amrNo != "" */
  and m.AMR_NO like /* @contain(amrNo) */'%g%'
  /*%end*/
  /*%if crtUserNm != null && crtUserNm != "" */
  and qa.CRT_USER_ID = /*crtUserNm*/'1'
  /*%end*/
  /*%if curDeptNm != null && curDeptNm != "" */
 	 and qa.CRT_DEPT_CD = /*curDeptNm*/'1'
	   /*%if isNurseRole == "true" */
	  and u.DCT_NS_F = 0
	  /*%end*/
	  /*%if isNurseRole == "false" */
	  and u.DCT_NS_F = 1
	  /*%end*/
  /*%end */
  /*%if rfmTimeStart != null && rfmTimeStart != "" && rfmTimeEnd != null && rfmTimeEnd != ""*/
  and n.RFM_TIME between to_date(/*rfmTimeStart*/'a', 'yyyy-MM-dd hh24:mi:ss') and to_date(/*rfmTimeEnd*/'a', 'yyyy-MM-dd hh24:mi:ss')
  /*%end */
   /*%if currentManageDoctorName != null && currentManageDoctorName != "" */
  and n.RFM_DOCTOR_CD = /*currentManageDoctorName*/'1'
  	 /*%if isNurseRole == "true" */
	  and us.DCT_NS_F = 0
	  /*%end*/
	  /*%if isNurseRole == "false" */
	  and us.DCT_NS_F = 1
	  /*%end*/
  /*%end*/
  and qa.DEL_F=0
  order by qa.CRT_TIME
