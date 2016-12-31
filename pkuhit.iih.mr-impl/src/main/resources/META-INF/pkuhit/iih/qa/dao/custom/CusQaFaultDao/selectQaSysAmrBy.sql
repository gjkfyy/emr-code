select 
  QA_SYS_AMR_CD,
  QA_SYS_CD,
  EN_TP_CD,
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
  from QA_SYS_AMR t
 where t.qa_sys_cd like 
 /*qaSysCd*/'SZLH.QAK01.01.01'
   and t.en_tp_cd like 
 /*enTpCd*/'ENM01.04'
