select 
   QA_SYS_ITM_CD,
  QA_SYS_MR_CD,
  QA_SYS_SEG_CD,
  QA_SYS_AMR_CD,
  REQ,
  QA_DRP_SCR_TP_CD,
  ONCE_DRP_SCR,
  MAX_DRP_SCR,
  DFT_RFM_F,
  AUTO_QA_F,
  QA_ITM_TP_CD,
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
  DEL_F
  from qa_sys_itm t
 where t.qa_sys_amr_cd like
      /*qaSysAmrCd*/'QAK02.01'
   and t.qa_sys_mr_cd is null
   and t.qa_sys_seg_cd is null
