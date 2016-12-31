 select
  apply.APPLY_CD,
  apply.EN_PK,
  amr.PA_ID,
  amr.PA_NM,
  amr.AMR_NO,
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
  ea.NM as APPLY_DCT_NM,
  apply.APPLY_STATUS,
  g.NM as APPLY_STATUS_NM,
  apply.APPLY_DESC,
  apply.APPLY_TYPE_CD,
  ga.NM as APPLY_TYPE_NM,
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
where
  1=1
  /*%if applyTypeCd != null && applyTypeCd != "" */
  and apply.APPLY_TYPE_CD = /* applyTypeCd */'MRM25.01'
  /*%end */
  /*%if userId != null && userId != "" */
  and apply.APPLY_DCT_CD =  /* userId */'004917'
  /*%else */
  and apply.APPLY_STATUS != 'MRM24.01' --医务科不查询新建状态病历
  /*%end */
  /*%if enPk != null && enPk != "" */
  and apply.EN_PK= /* enPk */'862679'
  /*%end */
  /*%if dtcCd != null && dtcCd != "" */
  and apply.APPLY_DCT_CD = /* dtcCd */'a'
  /*%end */
  /*%if curDeptCd != null && curDeptCd != "" */
  and amr.CUR_DEPT_CD = /* curDeptCd */'a'
  /*%end */ 
  /*%if applyStatus != null && applyStatus != "" */
  and apply.APPLY_STATUS= /* applyStatus */'a'
  /*%end */
  /*%if timeStart != null && timeStart != "" && timeEnd != null && timeEnd != ""*/
  and apply.APPLY_TIME between to_date(/*timeStart*/'a', 'yyyy-MM-dd hh24:mi:ss') and to_date(/*timeEnd*/'a', 'yyyy-MM-dd hh24:mi:ss')
  /*%end */
and apply.DEL_F = 0 
order by apply.CRT_TIME desc