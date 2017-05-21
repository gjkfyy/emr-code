 select
  *
from
  IEMR_PATIENT t
where 1=1
/*%if patientName != null */
 and  t.patient_name = /*patientName*/'刑茜2'
/*%end */ 
/*%if admissionDateStart != null */ 
 and t.admission_date >= to_date(/*admissionDateStart*/'2015-01-01 00:00:00','yyyy-mm-dd hh24:mi:ss')
/*%end */ 
/*%if admissionDateEnd != null */ 
 and t.admission_date <= to_date(/*admissionDateEnd*/'2015-01-01 00:00:00','yyyy-mm-dd hh24:mi:ss')
/*%end */ 
 /*%if inpatientNoStart != null */ 
 and t.inpatient_no > /*inpatientNoStart*/'12'
/*%end */ 
 /*%if inpatientNoEnd != null */ 
 and t.inpatient_no < /*inpatientNoEnd*/'100'
/*%end */ 
 /*%if sex != null */ 
 and t.sex = /*sex*/'0'
/*%end */ 
 /*%if birthdayEnd != null */ 
 and t.age >= sysdate - to_date(/*birthdayEnd*/'2015-01-01 00:00:00','yyyy-mm-dd hh24:mi:ss')
/*%end */ 
 /*%if birthdayStart != null */ 
 and t.age <= sysdate - to_date(/*birthdayStart*/'2015-01-05 00:00:00','yyyy-mm-dd hh24:mi:ss') 
/*%end */ 
 /*%if tel != null */ 
 and t.tel = '110'
/*%end */ 
 /*%if address != null */ 
 and t.adress like /* @contain(address) */'%g%'
/*%end */ 
 /*%if diagnosis != null */ 
 and t.diagnosis like /* @contain(diagnosis) */'%g%'
 /*%end */ 

 and t.del_f = 0
