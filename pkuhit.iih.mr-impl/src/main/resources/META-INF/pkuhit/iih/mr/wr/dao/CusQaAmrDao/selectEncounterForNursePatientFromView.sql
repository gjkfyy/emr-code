select 
 distinct amr.EN_PK,
  amr.PA_ID,
  amr.EN_CNT,
  amr.PA_NM,
  amr.SEX_CD,
  amr.AGE,
  amr.ORG_CD,
  amr.AMR_NO,
  amr.EN_TP_CD,
  amr.EN_STA_CD,
  amr.RCV_USER_ID,
  amr.RCV_DEPT_CD,
  amr.RCV_TIME,
  amr.NU_LVL_CD,
  amr.CUR_DEPT_CD,
  amr.CUR_DEPT_INTO_TIME,
  amr.CUR_WARD_CD,
  amr.CUR_WARD_INTO_TIME,
  amr.CUR_BED_CD,
  amr.CUR_MNG_DCT_ID,
  amr.CUR_MOJ_DCT_ID,
  amr.CUR_DRC_DCT_ID,
  amr.CUR_MNG_NUR_ID,
  amr.FNSH_TIME,
  amr.FNSH_USER_ID,
  amr.FNSH_DEPT_CD,
  '1' VIEW_F
  from VW_EN_ZY@dg4msql amr 
 
  where amr.DEL_F=0
  /*%if (groupType == "1") && (userId != null && userId != "")*/
  and amr.CUR_MNG_NUR_ID=/*userId*/'a'
  /*%end */
  /*%if wardCd != null && wardCd != "" */
  and amr.CUR_WARD_CD=/*wardCd*/'a'
  /*%end */
  /*%if patientName != null && patientName != ""*/
  and amr.PA_NM like /* @contain(patientName) */'%X%'
  /*%end */
  /*%if amrNo != null && amrNo != ""*/
  and amr.AMR_NO like /* @contain(amrNo) */'%X%'
  /*%end */
  /*%if currentBedCode != null && currentBedCode != ""*/
  and amr.CUR_BED_CD like /* @contain(currentBedCode) */'%X%'
  /*%end */
  /*%if curMgNurId != null && curMgNurId != "" */
  and amr.CUR_MNG_NUR_ID=/*curMgNurId*/'a' 
  /*%end */
  /*%if (groupType == "6" || groupType == "7") && startDate != null && startDate != "" && endDate != null && endDate != "" */
  and amr.FNSH_TIME between to_date(/*startDate*/'2015-01-01 00:00:00','yyyy-mm-dd hh24:mi:ss') and  to_date(/*endDate*/'2015-01-01 00:00:00','yyyy-mm-dd hh24:mi:ss')
  /*%end */
  /*%if (groupType == "6" || groupType == "7") && startDate != null && startDate != "" && (endDate == null || endDate == "") */
  and amr.FNSH_TIME > to_date(/*startDate*/'2015-01-01 00:00:00','yyyy-mm-dd hh24:mi:ss')
  /*%end */
  /*%if (groupType == "6" || groupType == "7") && (startDate == null || startDate == "") && endDate != null && endDate != "" */
  and amr.FNSH_TIME < to_date(/*endDate*/'2015-01-01 00:00:00','yyyy-mm-dd hh24:mi:ss')
  /*%end */
  /*%if groupType != "6"*/
  and amr.EN_STA_CD='ENM02.02'
  /*%end */
  /*%if groupType == "6"*/
  and amr.EN_STA_CD='ENM02.04' and amr.AMR_STA_CD='MRM22.01'
  /*%end */
  and amr.EN_TP_CD = 'ENM01.04'
  order by amr.FNSH_TIME desc,amr.CUR_BED_CD

