select 
  count(m.EN_PK) as mrTotal,
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
  from MR_AMR amr  left join mr m on amr.en_pk=m.en_pk and m.del_f = '0'
  where amr.DEL_F=0 
  /*%if patientId != null && patientId != "" */
  and  (amr.PA_ID = /*patientId*/'a'
   or
   amr.PA_ID in ( 
   select b.pa_id 
  	from pa_info a, pa_info b
 	where
	    ( (a.id_card = b.id_card and a.id_card <> '''' and a.id_card is not null and 
	       a.id_card <> '000000000000000000' and a.id_card <> '000000000000000' and length(a.id_card)>6)
	       or (
	           ltrim(rtrim(a.pa_nm)) = ltrim(rtrim(b.pa_nm)) and
	           ltrim(rtrim(a.sex_cd)) = ltrim(rtrim(b.sex_cd)) and
	           to_char(a.birth_date,'yyyy-mm-dd') =  to_char(b.birth_date,'yyyy-mm-dd')  and
	          a.home_tel = b.home_tel
	      )
	    )
      and a.pa_id != b.pa_id
      and a.pa_id =  /*patientId*/'a'
      and a.del_f = 0
   ))
  /*%elseif cardCd != null && cardCd != "" */
   and amr.PA_ID=( select pa_id from pa_info where Id_card=/*cardCd*/'a')
   /*%end*/
   group by 
  
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
  order by amr.RCV_TIME desc