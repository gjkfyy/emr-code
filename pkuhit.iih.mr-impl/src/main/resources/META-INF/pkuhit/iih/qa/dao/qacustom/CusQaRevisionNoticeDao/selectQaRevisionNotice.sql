select 
  amr.PA_NM,
  amr.PA_ID,
  amr.SEX_CD,
  amr.AGE,
  amr.AMR_NO,
  amr.EN_NO,
  amr.CUR_MAIN_DI_CD,
  amr.CUR_DEPT_INTO_TIME,
  amr.CUR_BED_CD,
  rn.REVISION_CD,
  rn.STATUS,
  rn.SEND_TIME,
  rn.EXEC_DOCTOR_CD,
  rn.RFM_DEADLINE,
  rn.RFM_TIME,
  rn.DEADLINE,
  rn.EXEC_DEPT_CD,
  rn.EN_PK,
  rn.RFM_DOCTOR_CD,
  rn.RFM_DEPT_CD,
  rn.QA_TY_CD,
  rn.CMPL_F,
  rn.MEMO,
  rn.SORT_NO,
  rn.SPELL_NO,
  rn.WUBI_NO,
  rn.UPD_CNT,
  rn.CRT_TIME,
  rn.CRT_USER_ID,
  rn.CRT_DEPT_CD,
  rn.LAST_UPD_TIME,
  rn.LAST_UPD_DEPT_CD,
  rn.LAST_UPD_USER_ID,
  rn.DEL_F 
  from QA_REVISION_NOTICE rn
  left join MR_AMR amr on rn.EN_PK=amr.EN_PK
  where 1=1
  /*%if qaTypeCode != null && qaTypeCode != "" */
  and rn.QA_TY_CD = /*qaTypeCode*/'a'
  /*%end */
  /*%if userId != null && userId != "" && (workScreen=="3" || workScreen=="6" || workScreen=="10") */
  and rn.RFM_DOCTOR_CD = /*userId*/'a'
  /*%end */
  /*%if deptId != null && deptId != "" && (workScreen=="3" || workScreen=="6" || workScreen=="10") */
  and rn.RFM_DEPT_CD = /*deptId*/'a'
  /*%end */
  /*%if userId != null && userId != "" && (workScreen=="2" || workScreen=="5" || workScreen=="9") */
  and rn.EXEC_DOCTOR_CD = /*userId*/'a'
  /*%end */
  /*%if deptId != null && deptId != "" && (workScreen=="2" || workScreen=="5" || workScreen=="9") */
  and rn.EXEC_DEPT_CD = /*deptId*/'a'
  /*%end */
  /*%if workScreen=="3" && qaTypeCode == "QAM13.01" */
  and amr.AMR_STA_CD in ('MRM22.01','MRM22.02')
  /*%end */
  /*%if workScreen=="6" && qaTypeCode == "QAM13.03" */
  and amr.AMR_STA_CD in ('MRM22.01','MRM22.02','MRM22.03','MRM22.04','MRM22.05','MRM22.06')
  /*%end */
  /*%if workScreen=="10" && qaTypeCode == "QAM13.02" */
  and amr.AMR_STA_CD in ('MRM22.01','MRM22.02','MRM22.03')
  /*%end */
  /*%if (workScreen=="2" || workScreen=="5" || workScreen=="9")  && verifiedDeadline == 0 */
  and rn.STATUS in ('QAM11.01', 'QAM11.02', 'QAM11.03')
  /*%end */
  /*%if (workScreen=="2" || workScreen=="5" || workScreen=="9") && verifiedDeadline != 0 */
  and (rn.STATUS in ('QAM11.01', 'QAM11.02', 'QAM11.03')
  or (rn.STATUS='QAM11.04' and (sysdate-rn.LAST_UPD_TIME) * 24 * 60 <  /*verifiedDeadline*/0 ))
  /*%end */
  /*%if (workScreen=="3" || workScreen=="6" || workScreen=="10")*/  --整改时整改通知单状态只显示待整改，整改中
  and rn.STATUS in ('QAM11.01', 'QAM11.02')
  /*%end */
  and rn.DEL_F=0
  order by rn.SEND_TIME desc
