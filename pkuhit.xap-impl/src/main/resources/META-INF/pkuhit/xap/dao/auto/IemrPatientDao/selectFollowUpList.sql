select
  t.*
from
  IEMR_PATIENT t
where 1=1
 and t.del_f = 0
/*%if patientName != null && patientName !="" */
 and t.patient_name like /* @contain(patientName) */'%X%' 
/*%end */
/*%if inpatientNo != null && inpatientNo !="" */
 and t.inpatient_no like /* @contain(inpatientNo) */'%X%' 
/*%end */
/*%if tel != null && tel !="" */
 and t.tel like /* @contain(tel) */'%X%' 
/*%end */
/*%if diagnosis != null && diagnosis !="" */
 and t.diagnosis like /* @contain(diagnosis) */'%X%' 
/*%end */
/*%if fuFlag !="all" */
 and t.fu_flag = /*fuFlag*/'a' 
/*%end */
/*%if startDate != null && startDate !="" && endDate!=null && endDate!="" */
 and (add_months(t.admission_date,3) between to_date(/*startDate*/'2015-01-01 00:00:00','yyyy-mm-dd hh24:mi:ss') and  to_date(/*endDate*/'2015-01-01 00:00:00','yyyy-mm-dd hh24:mi:ss')
 or add_months(t.admission_date,6) between to_date(/*startDate*/'2015-01-01 00:00:00','yyyy-mm-dd hh24:mi:ss') and  to_date(/*endDate*/'2015-01-01 00:00:00','yyyy-mm-dd hh24:mi:ss')
 or add_months(t.admission_date,12) between to_date(/*startDate*/'2015-01-01 00:00:00','yyyy-mm-dd hh24:mi:ss') and  to_date(/*endDate*/'2015-01-01 00:00:00','yyyy-mm-dd hh24:mi:ss')
 or add_months(t.admission_date,36) between to_date(/*startDate*/'2015-01-01 00:00:00','yyyy-mm-dd hh24:mi:ss') and  to_date(/*endDate*/'2015-01-01 00:00:00','yyyy-mm-dd hh24:mi:ss')
 )
/*%end */
 order by t.last_upd_time desc
