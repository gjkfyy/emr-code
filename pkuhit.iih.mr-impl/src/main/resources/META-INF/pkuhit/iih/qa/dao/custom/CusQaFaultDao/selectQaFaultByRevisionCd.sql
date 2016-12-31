select
  flt.QA_FLT_PK,
  flt.QA_ITM_PK,
  flt.QA_SYS_ITM_CD,
  flt.TAR_OBJ_CD,
  flt.TAR_OBJ_PK,
  flt.SRC_OBJ_CD,
  flt.SRC_OBJ_PK,
  flt.FLT_STA_CD,
  flt.SBMT_TIME,
  flt.SBMT_USER_ID,
  flt.SBMT_DEPT_CD,
  flt.RFM_REQ,
  flt.RFM_TIME,
  flt.RFM_USER_ID,
  flt.RFM_DEPT_CD,
  flt.RFM_DES,
  flt.VRF_TIME,
  flt.VRF_USER_ID,
  flt.VRF_DEPT_CD,
  flt.DRP_DES,
  flt.SEG_TP_CD,
  flt.FLT_FROM_CD,
  flt.FLT_CFM_RST_CD,
  flt.EN_PK
from
  QA_FLT flt
where 1=1
 and flt.REVISION_CD = /*revisionCd*/'a'
 and flt.DEL_F = 0