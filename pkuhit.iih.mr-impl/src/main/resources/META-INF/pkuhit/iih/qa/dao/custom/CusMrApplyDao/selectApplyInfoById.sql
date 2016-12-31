 select
  apply.APPLY_CD,
  apply.EN_PK,
  amr.PA_ID,
  amr.PA_NM,
  amr.CUR_DEPT_CD,
  oc.NM as CUR_DEPT_NM,
  amr.CUR_DEPT_INTO_TIME,
  apply.MR_TP_CD,
  apply.QA_AUTO_FLT_PK,
  t.NM as MR_TP_NM,
  apply.QA_ITM_CD,
  itm.REQ,
  itm.ONCE_DRP_SCR,
  apply.APPLY_TIME,
  apply.APPLY_DCT_CD,
  apply.APPLY_TYPE_CD,
  ga.NM as APPLY_TYPE_NM,
  ea.NM as APPLY_DCT_NM,
  apply.APPLY_STATUS,
  g.NM as APPLY_STATUS_NM,
  apply.APPLY_DESC,
  amr.CUR_MNG_DCT_ID as MNG_DCT_CD,
  em.NM as MNG_DCT_NM,
  apply.DEPT_CD,
  od.NM as DEPT_NM,
  apply.APPROVAL_TIME,
  apply.APPROVAL_DCT_CD,
  eaa.NM as APPROVAL_DCT_NM,
  apply.MEMO
from
  MR_APPLY apply
  left join MR_AMR amr on amr.EN_PK = apply.EN_PK
  left join QA_ITM itm on itm.QA_ITM_CD = apply.QA_ITM_CD
  left join MD_MR_TP t on t.MR_TP_CD = apply.MR_TP_CD
  left join MD_GS g on g.GS_CD = apply.APPLY_STATUS
  left join MD_GS ga on ga.GS_CD = apply.APPLY_TYPE_CD
  left join ORG oc on oc.ORG_CD = amr.CUR_DEPT_CD
  left join ORG od on od.ORG_CD = apply.DEPT_CD
  left join XAP_USER ea on ea.USER_ID= apply.APPLY_DCT_CD
  left join XAP_USER em on em.USER_ID= amr.CUR_MNG_DCT_ID
  left join XAP_USER eaa on eaa.USER_ID= apply.APPROVAL_DCT_CD
where apply.APPLY_CD =  /* applyCd */'a'
