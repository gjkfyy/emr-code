select 
  QA_SYS_MR_CD,
  QA_SYS_AMR_CD,
  MR_TP_CD,
  REQ,
  TTL_SCR,
  SORT_NO,
  UPD_CNT,
  CRT_TIME,
  CRT_USER_ID,
  CRT_DEPT_CD,
  LAST_UPD_TIME,
  LAST_UPD_DEPT_CD,
  LAST_UPD_USER_ID,
  DEL_F
  from qa_sys_mr t
 where t.mr_tp_cd like /*mrTpCd*/'MRM16.07'
