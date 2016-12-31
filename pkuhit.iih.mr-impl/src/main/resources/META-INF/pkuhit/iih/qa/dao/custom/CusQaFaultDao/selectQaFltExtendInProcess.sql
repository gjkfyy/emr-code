select
  distinct flt.QA_FLT_PK,
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
  flt.EN_PK,
  flt.UPD_CNT,
  flt.CRT_TIME,
  flt.CRT_USER_ID,
  flt.CRT_DEPT_CD,
  flt.LAST_UPD_TIME,
  flt.LAST_UPD_DEPT_CD,
  flt.LAST_UPD_USER_ID,
  flt.DEL_F
from
  QA_FLT flt
left join QA_FLT_ITM fi on fi.QA_FLT_PK = flt.QA_FLT_PK
left join QA qa on fi.QA_PK = qa.QA_PK
where 1=1
  /*%if enPk != null && enPk != "" */
  and flt.EN_PK = /*enPk*/'a'
  /*%end */
  and qa.QA_TY_CD='QAM03.01'
  and ((qa.AUTO_F=0 and flt.FLT_STA_CD in ('QAM01.02', 'QAM01.03')) or qa.AUTO_F=1 )
  and fi.ACTIVE_F = 1
  and flt.DEL_F = 0
