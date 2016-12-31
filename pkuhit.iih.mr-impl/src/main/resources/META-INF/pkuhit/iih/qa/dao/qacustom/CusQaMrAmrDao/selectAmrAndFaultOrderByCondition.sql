select 
  amr.EN_PK,
  amr.PA_ID,
  amr.EN_CNT,
  amr.PA_NM,
  amr.SEX_CD,
  amr.AGE,
 -- amr.ORG_CD,
  amr.AMR_NO,
 -- amr.EN_NO,
  amr.EN_TP_CD,
  amr.EN_STA_CD,
  amr.AMR_STA_CD,
--  amr.AMR_RANK_CD,
 -- amr.QA_SCR,
--  amr.REG_TIME,
--  amr.REG_USER_ID,
--  amr.REG_DEPT_CD,
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
--  amr.CUR_GRP_CD,
  amr.CUR_BED_CD,
  amr.CUR_MNG_DCT_ID,
  amr.CUR_MOJ_DCT_ID,
  amr.CUR_DRC_DCT_ID,
  amr.CUR_MNG_NUR_ID,
 -- amr.SU_F,
--  amr.DEATH_F,
 -- amr.READM_F,
 -- amr.CALL_BACK_F,
--  amr.FLUP_VISIT_F,
  amr.FNSH_TIME,
  amr.FNSH_USER_ID,
  amr.FNSH_DEPT_CD,
  amr.TERM_QA_CMPL_TIME,
  amr.TERM_QA_CMPL_USER_ID,
  amr.TERM_QA_CMPL_DEPT_CD,
  count(flt.en_pk) as faultTotal, --缺陷数
  (case when amr.inprocess is not null then 1 else 0 end) as qaFlag
  from MR_AMR amr  
 
  left join QA_FLT flt
    on amr.EN_PK = flt.EN_PK
    /*%if qaTypeCode != null && qaTypeCode != "" */
   and flt.QA_TY_CD = /*qaTypeCode*/'QAM13.01'
    /*%end */
   and flt.DEL_F = 0
   inner join "view_general_order"@dg4msql b on amr.en_pk = b."enc_id" 
  where 1=1  
   and amr.DEL_F=0
   and amr.en_tp_cd='ENM01.04'--就诊类型为住院
  
  /*%if statusStr != null && statusStr != ""*/
  and amr.AMR_STA_CD = /*statusStr*/'a'
  /*%end */
  /*%if curDeptNm != null && curDeptNm != "" */
  /*%if isNurseRole != null && isNurseRole == "false" */
  and amr.CUR_DEPT_CD = /*curDeptNm*/'1'
  /*%end */
  /*%if isNurseRole != null && isNurseRole == "true" */
  and amr.CUR_WARD_CD = /*curDeptNm*/'1'
  /*%end */
  /*%end */
  /*%if amrNo != null && amrNo != "" */
  and amr.AMR_NO like /* @contain(amrNo) */'%g%'
  /*%end*/
  /*%if patientName != null && patientName != "" */
  and amr.PA_NM like /* @contain(patientName) */'%g%'
  /*%end*/
  /*%if staIll != null && staIll != "" */
  and amr.ILL_STA_CD=/*staIll*/'a'
  /*%end */
  /*%if qaTypeCode=="QAM13.01" && rcvTime != null && rcvTime != "" && rcvTime == "1" */  -- 入院24小时内，到分钟
  and (sysdate-amr.RCV_TIME) * 24 * 60 < 1440
  /*%end */
  /*%if qaTypeCode=="QAM13.01" && rcvTime != null && rcvTime != "" && rcvTime == "2" */  -- 入院7日内，到分钟
  and (sysdate-amr.RCV_TIME) * 24 * 60 < 10080
  /*%end */
  /*%if qaTypeCode=="QAM03.01" && rcvTime != null && rcvTime != "" && rcvTime == "3"*/  -- 全部时间
  and amr.AMR_STA_CD = 'MRM22.01'
  /*%end */
  /*%if enStaCd != null && enStaCd != "" */
  and amr.EN_STA_CD=/*enStaCd*/'a'
  /*%end */
  /*%if suF != null && suF != "" && suF == "1" */
  and amr.SU_F = /*suF*/'a'
  /*%end */
  /*%if qaFlag != null && qaFlag != "" && qaFlag == "1" && qaTypeCode != null && qaTypeCode == "QAM13.01" */
  and amr.inprocess is not null
  /*%end */
  /*%if beginTime != null && beginTime != ""*/
  and to_char(amr.RCV_TIME,'yyyy-mm-dd hh:mm:ss') > /*beginTime*/'2010-02-19 21:05:10.630'
  /*%end */
  /*%if endTime != null && endTime != ""*/
  and to_char(amr.RCV_TIME,'yyyy-mm-dd hh:mm:ss') < /*endTime*/'2016-07-19 21:05:10.630'
  /*%end */
 /*%if specialMr != "" && specialMr =="02"*/
     and b."display_name" like '%会诊%' 
   /*%end */
 /*%if specialMr != null && specialMr != "" && specialMr =="04"*/
     and b."code" ='601436' --术后医嘱  
  	and b."order_status" ='5'--已停  
  	and b."display_name" >'啊'--过滤已有文本术后医嘱  
  /*%end */
  /*%if specialMr != null && specialMr != "" && specialMr =="07"*/
    --and (b."display_name" like '%血小板%' or b."display_name" like '%血浆%' or b."display_name" like '%冷沉淀%' or b."display_name" like '%红细胞%' or  b."display_name" like '%全血%')
   and b."code" ='609785' and b."display_name" like '请%'
  /*%end */
  /*%if specialMr != null && specialMr != "" && specialMr =="08"*/
    and (b."display_name" like '病危%' or b."display_name" like '病重%' )
  /*%end */
  /*%if specialMr != null && specialMr != "" && specialMr =="09"*/
    and b."code" in ('603456','603462','603467','603133')
  /*%end */
  /*%if specialMr != null && specialMr != "" && specialMr =="10"*/
    and (b."code" = '603308' or b."code" ='608729')   
  /*%end */
  /*%if specialMr != null && specialMr != "" && specialMr =="12"*/
    and b."code" = '010304'  
  /*%end */
  group by 
          flt.en_pk,
          amr.EN_PK,
		  amr.PA_ID,
		  amr.EN_CNT,
		  amr.PA_NM,
		  amr.SEX_CD,
		  amr.AGE,
		 -- amr.ORG_CD,
		  amr.AMR_NO,
		--  amr.EN_NO,
		  amr.EN_TP_CD,
		  amr.EN_STA_CD,
		  amr.AMR_STA_CD,
		--  amr.AMR_RANK_CD,
		--  amr.QA_SCR,
		--  amr.REG_TIME,
		--  amr.REG_USER_ID,
		--  amr.REG_DEPT_CD,
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
		--  amr.CUR_GRP_CD,
		  amr.CUR_BED_CD,
		  amr.CUR_MNG_DCT_ID,
		  amr.CUR_MOJ_DCT_ID,
		  amr.CUR_DRC_DCT_ID,
		  amr.CUR_MNG_NUR_ID,
		--  amr.SU_F,
		 -- amr.DEATH_F,
		--  amr.READM_F,
		--  amr.CALL_BACK_F,
		--  amr.FLUP_VISIT_F,
		  amr.FNSH_TIME,
		  amr.FNSH_USER_ID,
		  amr.FNSH_DEPT_CD,
		  amr.TERM_QA_CMPL_TIME,
		  amr.TERM_QA_CMPL_USER_ID,
		  amr.TERM_QA_CMPL_DEPT_CD,
          amr.inprocess
  order by amr.CUR_BED_CD 
