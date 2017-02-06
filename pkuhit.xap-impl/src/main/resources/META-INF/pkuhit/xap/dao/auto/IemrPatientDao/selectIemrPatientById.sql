select
  *
from
  IEMR_PATIENT
where 1=1
/*%if patientId != null */
 and  patient_id = /* patientId */'a' 
/*%end */
 and del_f = 0