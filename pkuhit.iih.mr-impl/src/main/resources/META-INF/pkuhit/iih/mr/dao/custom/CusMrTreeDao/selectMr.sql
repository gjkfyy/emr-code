select 
  MR_PK,
  EN_PK,
  MR_TPL_CD,
  FILE_PK,
  NM,
  MR_TP_CD,
  ENCOUNTER_SN,
  MR_STA_CD,
  MR_QA_STA_CD,
  COMPLETED_F,
  SIGN_LVL_CD,
  BIZ_TIME,
  SUP_DCT_ID,
  SUBMIT_CD,
  SUBMIT_DATE,
  DEPT_CD,
  TREAT_DOCTOR_CD,
  MAST_DOCTOR_CD,
  MAST_DOCTOR_DATE,
  DIR_DOCTOR_CD,
  DIR_DOCTOR_DATE,
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
  DEL_F,
  CA_FILE_PK,
  ARC_F 
from mr 
where
mr.mr_tp_cd in
(select itm.mr_tp_cd from MD_MR_TP_CCAT_ITM itm 
 where itm.MR_TP_CCAT_CD in 
  (select cat.MR_TP_CCAT_CD 
   from MD_MR_TP_CCAT cat 
   where cat.del_f != 1 and
     cat.MR_TP_CCAT_CD= /*custCategoryCode*/'MRM14.03'
  )
)
/*%if encounterCode != null*/
  and mr.en_pk =/*encounterCode*/'1203730'
/*%end */
  and mr.del_f != 1
order by 
  mr.crt_time 