  select sn,
  patient_id,
  times,
  doctor_sn,
  dept_sn,
  diag_str,
  diag_code,
  icd_code,
  comment_str,
  main_flag,
  uncertain_flag,
  contagion_flag,
  input_date,
  symptom
from
  mz_patient_diagnosis t
where 
1=1 

/*%if patientId != null */
 and t.patient_id = /*patientId*/870719  
/*%end */
 /*%if times != null */
 and t.times = /*times*/4  
/*%end */
/*%if diCodeList != null && diCodeList.size()>0 */
  and diag_code in /*diCodeList*/('1') 
/*%end */