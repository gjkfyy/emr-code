select top 1000 id,EN_PK  ,PA_ID ,EN_CNT ,PA_NM ,SEX_CD 
       ,AGE ,ORG_CD ,AMR_NO ,EN_NO ,
        EN_TP_CD ,EN_STA_CD ,AMR_STA_CD ,
        AMR_RANK_CD ,QA_SCR ,
        convert(nvarchar(20),REG_TIME,20) REG_TIME
        ,REG_USER_ID ,REG_DEPT_CD ,RCV_USER_ID,RCV_DEPT_CD,
          convert(nvarchar(20),RCV_TIME,20) RCV_TIME ,ILL_STA_CD ,NU_LVL_CD ,
         CUR_MAIN_DI_CD ,CUR_DEPT_CD ,
         convert(nvarchar(20),CUR_DEPT_INTO_TIME,20) CUR_DEPT_INTO_TIME ,
         CUR_WARD_CD , convert(nvarchar(20),CUR_WARD_INTO_TIME,20) CUR_WARD_INTO_TIME ,
         CUR_GRP_CD ,
         CUR_BED_CD ,CUR_MNG_DCT_ID 
         ,CUR_MOJ_DCT_ID ,CUR_DRC_DCT_ID ,
         CUR_MNG_NUR_ID , SU_F ,
         DEATH_F ,READM_F ,CALL_BACK_F ,
         FLUP_VISIT_F ,
         convert(nvarchar(20),FNSH_TIME,20) FNSH_TIME,
         FNSH_USER_ID ,FNSH_DEPT_CD ,
         convert(nvarchar(20),TERM_QA_CMPL_TIME,20) TERM_QA_CMPL_TIME,
         TERM_QA_CMPL_USER_ID ,
         TERM_QA_CMPL_DEPT_CD ,
         INPROCESS ,TERMINAL ,
         DEPT_TERMINAL ,DEPT_QA_SCR ,PA_INSUR_CD,PA_INSUR_NM
         ,DEL_F ,flag 
 from iemr_mr_amr 
 where flag in ('I','U','D')
  order by SORT_DATE
  