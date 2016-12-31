select
  QA_FLT_PK,
  QA_ITM_CD,
  QA_TY_CD,
  FLT_STA_CD,
  REVISION_CD,
  SBMT_TIME,
  SBMT_USER_ID,
  SBMT_DEPT_CD,
  RFM_REQ,
  RFM_TIME,
  RFM_USER_ID,
  RFM_DEPT_CD,
  RFM_DES,
  VRF_TIME,
  VRF_USER_ID,
  VRF_DEPT_CD,
  DRP_DES,
  EN_PK,
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
  MR_PK,
  DEDUCT_SCR_TIMES
from
  QA_FLT flt
where 1=1 
  /*%if pk != null && pk != "" && pk != "undefined" */
  and flt.EN_PK = /*pk*/'a'
  /*%end */
  /*%if qaTypeCode != null && qaTypeCode != "" */
  and flt.QA_TY_CD = /*qaTypeCode*/'a'
  /*%end */
  and flt.flt_sta_cd = 'QAM12.04'
  and flt.DEL_F = 0
