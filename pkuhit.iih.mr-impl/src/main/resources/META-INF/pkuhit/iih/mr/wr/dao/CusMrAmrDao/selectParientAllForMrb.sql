select
 distinct
  amr.EN_PK,
  amr.CUR_DEPT_CD,
  amr.AMR_NO,
  amr.PA_NM,
  amr.SEX_CD,
  amr.AGE,
  amr.pa_id,
    amr.en_cnt,
  amr.RCV_TIME,
  amr.AMR_STA_CD,
  amr.FNSH_TIME,
  amr.CUR_MNG_DCT_ID,
  amr.CUR_MAIN_DI_CD,
  amr.ARC_F
from Mr_Amr amr 
   /*%if mrTypeList != null && mrTypeList.size()>0 */
     inner join mr m on amr.en_pk=m.en_pk 
      and m.MR_TP_CD  in /*mrTypeList*/('1') --文书类型
      and m.DEL_F='0'
  /*%end */
where amr.DEL_F='0'
   /*%if enTypeCodeList != null && enTypeCodeList.size()>0 */
      and amr.EN_TP_CD  in /*enTypeCodeList*/('1') --就诊类型
  /*%end */
   /*%if userRoleDeptListToSearch != null && userRoleDeptListToSearch.size()>0 */
   and amr.CUR_DEPT_CD in  /*userRoleDeptListToSearch*/('MRM07.06')   --科室
     /*%end */
   /*%if doctorCode != null && doctorCode != "" */
  and  amr.CUR_MNG_DCT_ID   = /*doctorCode*/'a'   
    
     /*%end */
   /*%if receiveTime != null && receiveTime != "" */
   and ((amr.RCV_TIME >= to_date(/*receiveTime*/'2015-01-01 00:00:00','yyyy-mm-dd hh24:mi:ss') and amr.en_tp_cd <> 'ENM01.04')
   or(amr.fnsh_time >= to_date(/*receiveTime*/'2015-01-01 00:00:00','yyyy-mm-dd hh24:mi:ss') and amr.en_tp_cd = 'ENM01.04')) --接诊时间 出院时间
      /*%end */
    /*%if finishTime != null && finishTime != "" */
   and ((amr.RCV_TIME < to_date(/*finishTime*/'2015-01-01 00:00:00','yyyy-mm-dd hh24:mi:ss') and amr.en_tp_cd <> 'ENM01.04')
   or(amr.fnsh_time < to_date(/*finishTime*/'2015-01-01 00:00:00','yyyy-mm-dd hh24:mi:ss') and amr.en_tp_cd = 'ENM01.04'))  --接诊时间
      /*%end */
     /*%if idCardNo != null && idCardNo != ""*/
       and  amr.pa_id  in(select pa_id from pa_info where  id_card = /* idCardNo */'a' )   --身份证号
    /*%end */
   
   /*%if amrNo != null && amrNo != ""*/
   and amr.AMR_NO = /* amrNo */'a' --住院号
    /*%end */
   /*%if paId != null && paId != ""*/
   and amr.pa_id = /* paId */'a' --住院号
    /*%end */
   /*%if mobile != null && mobile != ""*/
       and  amr.pa_id  in(select pa_id from pa_info where  home_tel = /* mobile */'a' )   --手机号
    /*%end */
   
   /*%if amrStaCd=="MRM22.07"*/
   and amr.AMR_STA_CD =/* amrStaCd */'a' --病案状态
   /*%end */
   /*%if amrStaCd=="MRM22.06"*/
   and amr.AMR_STA_CD <>/* amrStaCd */'a' --病案状态
   /*%end */
   /*%if patientName != null && patientName != ""*/
   and amr.PA_NM like /* @contain(patientName) */'%X%' --患者姓名
    /*%end */
order by amr.RCV_TIME desc