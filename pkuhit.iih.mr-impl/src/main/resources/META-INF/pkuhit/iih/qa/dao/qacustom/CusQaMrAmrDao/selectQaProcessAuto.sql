select 
 distinct amr.EN_PK,
  amr.PA_ID,
  amr.EN_CNT,
  amr.PA_NM,
  amr.SEX_CD,
  amr.AGE,
  amr.ORG_CD,
  amr.AMR_NO,
  amr.EN_NO,
  amr.EN_TP_CD,
  amr.EN_STA_CD,
  amr.AMR_STA_CD,
  amr.AMR_RANK_CD,
  amr.QA_SCR,
  amr.REG_TIME,
  amr.REG_USER_ID,
  amr.REG_DEPT_CD,
  amr.RCV_USER_ID,
  amr.RCV_DEPT_CD,
  amr.RCV_TIME,
  amr.ILL_STA_CD,
  amr.NU_LVL_CD,
  amr.CUR_MAIN_DI_CD,
  amr.CUR_DEPT_CD,
  amr.CUR_DEPT_INTO_TIME,
  amr.CUR_WARD_CD,
  amr.CUR_WARD_INTO_TIME,
  amr.CUR_GRP_CD,
  amr.CUR_BED_CD,
  amr.CUR_MNG_DCT_ID,
  amr.CUR_MOJ_DCT_ID,
  amr.CUR_DRC_DCT_ID,
  amr.CUR_MNG_NUR_ID,
  amr.SU_F,
  amr.DEATH_F,
  amr.READM_F,
  amr.CALL_BACK_F,
  amr.FLUP_VISIT_F,
  amr.FNSH_TIME,
  amr.FNSH_USER_ID,
  amr.FNSH_DEPT_CD,
  amr.TERM_QA_CMPL_TIME,
  amr.TERM_QA_CMPL_USER_ID,
  amr.TERM_QA_CMPL_DEPT_CD
  from MR_AMR amr
  where 1=1
  
 	  /*%if statusStr != null && statusStr != "" */
   and amr.AMR_STA_CD =  /*statusStr*/'1'
      /*%end */
      /*%if curDeptNm != null && curDeptNm != "" */
   and amr.CUR_DEPT_CD = /*curDeptNm*/'1'
      /*%end */
      /*%if patientName != null && patientName != "" */
   and amr.pa_nm like /* @contain(patientName) */'%g%'
      /*%end*/
      /*%if amrNo != null && amrNo != "" */
   and amr.AMR_NO like /* @contain(amrNo) */'%g%'
      /*%end*/
 	  /*%if currentManageDoctorName != null && currentManageDoctorName != "" */
   and amr.cur_mng_dct_id = /*currentManageDoctorName*/'1'
	  /*%end*/
   and amr.en_tp_cd='ENM01.04'--就诊类型为住院
   and amr.DEL_F=0
   order by amr.CUR_BED_CD 
