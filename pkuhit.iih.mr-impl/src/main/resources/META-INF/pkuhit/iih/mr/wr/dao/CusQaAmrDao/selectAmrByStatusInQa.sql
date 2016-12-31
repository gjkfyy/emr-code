--select * from ( 
select 
 distinct amr.EN_PK,
  amr.AMR_NO,
  amr.AMR_STA_CD,
  amr.AMR_RANK_CD,
  amr.QA_SCR,
  amr.TERM_QA_CMPL_TIME,
  amr.TERM_QA_CMPL_USER_ID,
  amr.TERM_QA_CMPL_DEPT_CD,
  amr.EN_TP_CD,
  amr.EN_STA_CD,
  amr.RCV_TIME,
  amr.FNSH_TIME,
  amr.SU_F,
  amr.ILL_STA_CD,
  amr.CUR_MAIN_DI_CD,
  --amr.CUR_MAIN_DI_NM,
  amr.CUR_DEPT_CD,
  (case when qa.QA_PK is not null then 1 else 0 end) as qaFlag,
  (case when qa.QA_TY_CD='QAM03.02' and amr.AMR_STA_CD in ('MRM03.02', 'MRM03.03')  then 1 else 0 end) as canEdit
  --,row_number() over(order by amr.RCV_TIME desc) rwn
  from MR_AMR amr
  left join QA qa on amr.EN_PK=qa.EN_PK
  left join QA_FLT_ITM fi on fi.QA_PK=qa.QA_PK
  left join QA_FLT flt on flt.QA_FLT_PK=fi.QA_FLT_PK
  where 1=1
  /*%if amrStatusList != null && amrStatusList.size()>0 */
  and amr.AMR_STA_CD in /*amrStatusList*/('a')
  /*%end */
  /*%if curDeptNm != null && curDeptNm != "" */
  and amr.CUR_DEPT_CD = /*curDeptNm*/'1'
  /*%end */
  /*%if curMainDiNm != null && curMainDiNm != "" */
  and amr.CUR_MAIN_DI_CD=/*curMainDiNm*/'a'
  /*%end */
  /*%if staIll != null && staIll != "" */
  and amr.ILL_STA_CD=/*staIll*/'a'
  /*%end */
  /*%if qaTypeCode=="QAM03.01" && rcvTime != null && rcvTime != "" && rcvTime == "1" */  -- 入院24小时内，到分钟
  and (sysdate-amr.RCV_TIME) * 24 * 60 < 1440
  /*%end */
  /*%if qaTypeCode=="QAM03.01" && rcvTime != null && rcvTime != "" && rcvTime == "2" */  -- 入院7日内，到分钟
  and (sysdate-amr.RCV_TIME) * 24 * 60 < 10080
  /*%end */
  /*%if qaTypeCode=="QAM03.01" && enStaCd == null && rcvTime != null && rcvTime != "" && rcvTime == "3"*/  -- 全部在院
  and amr.EN_STA_CD ='ENM02.01' and amr.AMR_STA_CD = 'MRM03.01'
  /*%end */
  /*%if qaTypeCode=="QAM03.02" && rcvTime != null && rcvTime != "" && rcvTime == "1" */  -- 入院24小时内出院，到分钟
  and amr.EN_STA_CD='ENM02.04' and (amr.RCV_TIME-amr.FNSH_TIME) * 24 * 60 < 1440
  /*%end */
  /*%if qaTypeCode=="QAM03.02" && rcvTime != null && rcvTime != "" && rcvTime == "2" */  -- 入院7日内出院，到分钟
  and amr.EN_STA_CD='ENM02.04' and (amr.RCV_TIME-amr.FNSH_TIME) * 24 * 60 < 10080
  /*%end */
  /*%if qaTypeCode=="QAM03.02" && enStaCd == null && rcvTime != null && rcvTime != "" && rcvTime == "3"*/  -- 全部 病案状态！=书写已开始
  and amr.EN_STA_CD='ENM02.04' and amr.AMR_STA_CD in ('MRM03.02', 'MRM03.03', 'MRM03.04')
  /*%end */
  /*%if enStaCd != null && enStaCd != "" */
  and amr.EN_STA_CD=/*enStaCd*/'a'
  /*%end */
  /*%if suF != null && suF != "" && suF == "1" */
  and amr.SU_F = /*suF*/'a'
  /*%end */
  /*%if qaFlag != null && qaFlag != "" && qaFlag == "1" && qaTypeCode != null && qaTypeCode != "" */
  and qa.QA_PK is not null and qa.QA_TY_CD = /*qaTypeCode*/'a'
  /*%end */
  /*%if workScreen != null && workScreen != "" && (workScreen == "4" || workScreen == "5") && qaTypeCode != null && qaTypeCode != "" */
  and flt.QA_FLT_PK is not null and qa.QA_TY_CD = /*qaTypeCode*/'a'
  /*%end */
  /*%if excuteUserId != null && excuteUserId != "" */
  and qa.CRT_USER_ID=/*excuteUserId*/'004910'
  /*%end */
  /*%if executeDeptCode != null && executeDeptCode != "" */
  and qa.CRT_DEPT_CD=/*executeDeptCode*/'4700'
  /*%end */
  and amr.DEL_F=0
--  order by amr.RCV_TIME desc
  --) where rwn between 1 and 25
  