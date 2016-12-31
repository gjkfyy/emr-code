select
  distinct flt.QA_FLT_PK,
  flt.QA_ITM_PK,
  qa.QA_PK as qaPk,
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
  si.ONCE_DRP_SCR as onceDropScore,
  --si.QA_DRP_SCR_TP_CD,
  --(qa.EXEC_BEGIN_TIME+qa.RFM_DEADLINE) as deadline,
  qa.DEADLINE as deadline,
  (case when (qa.EXEC_BEGIN_TIME+qa.RFM_DEADLINE)>sysdate then 1 else 0 end) as canOverdue,
  /*%if qaTypeCode != null && qaTypeCode != "" && qaTypeCode == "QAM03.01" */
  (case when flt.FLT_STA_CD in ('QAM01.01','QAM01.03','QAM01.04') then 1 else 0 end) as canEdit,
  /*%end */
  /*%if qaTypeCode != null && qaTypeCode != "" && qaTypeCode == "QAM03.02" */
  (case when mr.MR_QA_STA_CD in ('QAM04.01','QAM04.04','QAM04.05') then 1 else 0 end) as canEdit,
  /*%end */
  mr.NM as mrName,
  si.REQ as qaSystemItemName,
  si.DFT_RFM_F as canReform
from
  QA_FLT flt
left join QA_FLT_ITM fi on fi.QA_FLT_PK = flt.QA_FLT_PK
left join QA qa on fi.QA_PK = qa.QA_PK
left join QA_ITM si on si.QA_ITM_CD = flt.QA_SYS_ITM_CD
left join MR mr on mr.MR_PK = flt.TAR_OBJ_PK
where 1=1 
  /*%if encounterPk != null && encounterPk != "" */
  and flt.EN_PK = /*encounterPk*/'a'
  /*%end */
  /*%if qaTypeCode != null && qaTypeCode != "" */
  and qa.QA_TY_CD = /*qaTypeCode*/'a'
  /*%end */
  /*%if statusCode != null && statusCode != "" && statusCode!="overDeadline" */
  and flt.FLT_STA_CD = /*statusCode*/'a'
  /*%end */
  /*%if statusCode != null && statusCode != "" && statusCode=="overDeadline" */
  and (qa.EXEC_BEGIN_TIME+qa.RFM_DEADLINE)>sysdate
  /*%end */
  /*%if dropFlag != null && dropFlag != "" && dropFlag == "1" */
  and flt.FLT_CFM_RST_CD = 'QAM07.04' 
  /*%end */
  /*%if submittedUserId != null && submittedUserId != "" */
  and flt.SBMT_USER_ID = /*submittedUserId*/'1'
  /*%end */
  /*%if submittedDeptCode != null && submittedDeptCode != "" */
  and flt.SBMT_DEPT_CD = /*submittedDeptCode*/'1'
  /*%end */
  and fi.ACTIVE_F = 1
  and flt.REVISION_CD is null
  and flt.DEL_F = 0
order by si.REQ