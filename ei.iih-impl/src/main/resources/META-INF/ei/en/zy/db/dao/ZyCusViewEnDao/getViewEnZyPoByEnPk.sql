select 
 EN_PK
, PA_ID
, EN_CNT
, PA_NM
, SEX_CD
, AGE
, ORG_CD
, AMR_NO
, EN_NO
, EN_TP_CD
, EN_STA_CD
, AMR_STA_CD
, AMR_RANK_CD
, QA_SCR
, REG_TIME
, REG_USER_ID
, REG_DEPT_CD
, RCV_USER_ID
, RCV_DEPT_CD
, RCV_TIME
, ILL_STA_CD
, NU_LVL_CD
, CUR_MAIN_DI_CD
, CUR_DEPT_CD
, CUR_DEPT_INTO_TIME
, CUR_WARD_CD
, CUR_WARD_INTO_TIME
, CUR_GRP_CD
, CUR_BED_CD
, CUR_MNG_DCT_ID
, CUR_MOJ_DCT_ID
, CUR_DRC_DCT_ID
, CUR_MNG_NUR_ID
, SU_F
, DEATH_F
, READM_F
, CALL_BACK_F
, FLUP_VISIT_F
, FNSH_TIME
, FNSH_USER_ID
, FNSH_DEPT_CD
, TERM_QA_CMPL_TIME
, TERM_QA_CMPL_USER_ID
, TERM_QA_CMPL_DEPT_CD
, INPROCESS
, TERMINAL
, DEPT_TERMINAL
, DEPT_QA_SCR
, null BIRTH_DATE
, '' ID_CARD
, '' HIC_NO
, '' HOME_TEL
, '' SOCIAL_SN
, PA_INSUR_CD
, DEL_F
from VW_EN_ZY w
where 
1= 1
      /*%if enPk != null */
 		AND  EN_PK = /*enPk*/838535 
     /*%end */
 	 /*%if enPk == null */
		AND PA_ID = /*patientId*/'1'
		and EN_CNT = /*times*/'1'
     /*%end */
