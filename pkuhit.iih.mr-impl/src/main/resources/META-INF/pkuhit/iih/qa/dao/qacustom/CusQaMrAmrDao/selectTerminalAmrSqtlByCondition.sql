select 
  amr.EN_PK,
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
  amr.QA_AUTO_SCR,
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
  amr.TERM_QA_CMPL_DEPT_CD,
  q.lvl,
  count(flt.en_pk) as faultTotal --缺陷数
   /*%if qaTypeCode != null && qaTypeCode != "" && qaTypeCode == "QAM13.03"*/
   ,(case when amr.terminal is not null then 1 else 0 end) as qaFlag
  /*%end */
 /*%if qaTypeCode != null && qaTypeCode != "" && qaTypeCode == "QAM13.02"*/
   ,(case when amr.dept_terminal is not null then 1 else 0 end) as qaFlag
  /*%end */
  from MR_AMR amr
  left join QA_FLT flt
    on amr.EN_PK = flt.EN_PK
    /*%if qaTypeCode != null && qaTypeCode != "" */
   and flt.QA_TY_CD = /*qaTypeCode*/'QAM13.01'
    /*%end */
   and flt.DEL_F = 0
  inner join  mr on amr.en_pk =mr.en_pk     
  inner join mr_tpl p on mr.mr_tpl_cd = p.mr_tpl_cd and p.mr_tp_cd ='MRM16.18' and p.nm like '%手术前%' and p.del_f='0'
  left join qa_divide_level q on amr.amr_rank_cd = q.qa_divide_level_cd
 where 1=1  
  /*%if amrStatus != null && amrStatus != ""*/
  and amr.AMR_STA_CD = /*amrStatus*/'1'
  /*%end */
  /*%if curDeptNm != null && curDeptNm != "" */
  and amr.CUR_DEPT_CD = /*curDeptNm*/'1'
  /*%end */
  /*%if amrNo != null && amrNo != "" */
  and amr.AMR_NO like /* @contain(amrNo) */'%g%'
  /*%end*/
  /*%if patientName != null && patientName != "" */
  and amr.PA_NM like /* @contain(patientName) */'%g%'
  /*%end*/
  /*%if beginTime != null && beginTime != "" && beginTime != "undefined"*/
  and to_char(amr.FNSH_TIME,'yyyy-mm-dd hh:mm:ss') > /*beginTime*/'2010-02-19 21:05:10.630'
  /*%end */
  /*%if endTime != null && endTime != "" && endTime != "undefined"*/
  and to_char(amr.FNSH_TIME,'yyyy-mm-dd hh:mm:ss') < /*endTime*/'2016-07-19 21:05:10.630'
  /*%end */
  and amr.en_tp_cd='ENM01.04'--就诊类型为住院
  
  /*%if qaAutoScrMin != null && qaAutoScrMin != ""&& qaAutoScrMin != "undefined"*/
  and amr.qa_auto_scr>/*qaAutoScrMin*/'a'
  /*%end */
  /*%if qaAutoScrMax != null && qaAutoScrMax != "" && qaAutoScrMax != "undefined"*/
  and amr.qa_auto_scr</*qaAutoScrMax*/'a'
  /*%end */
  
  /*%if enStaCd != null && enStaCd != "" */
  and amr.EN_STA_CD=/*enStaCd*/'a' --当为医嘱质控时，需要查询此条件，就诊状态为ENM02.02已接诊
  /*%end */
  and amr.DEL_F=0
  group by 
  	flt.en_pk,
	amr.EN_PK,
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
	amr.QA_AUTO_SCR,
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
	amr.TERM_QA_CMPL_DEPT_CD,
	q.lvl,
	amr.terminal,
	amr.dept_terminal
  order by amr.CUR_BED_CD 
