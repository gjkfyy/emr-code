select
  flt.QA_FLT_PK,
  flt.QA_ITM_CD,
  flt.CRT_TIME,
  flt.CRT_USER_ID,
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
  flt.DEDUCT_SCR_TIMES,
  flt.MR_PK,
  flt.REVISION_CD,
  itm.DEDUCT_DES,
  itm.REQ,  
  m.NM
from
  QA_FLT flt
left join QA_ITM itm on flt.QA_ITM_CD = itm.QA_ITM_CD
left join Mr m on m.MR_PK = flt.MR_PK
where 1=1 
  /*%if encounterPk != null && encounterPk != "" && encounterPk != "undefined" */
  and flt.EN_PK = /*encounterPk*/'a'
  /*%end */
  
  and flt.DEL_F = 0
  
  order by flt.SBMT_TIME asc
  
