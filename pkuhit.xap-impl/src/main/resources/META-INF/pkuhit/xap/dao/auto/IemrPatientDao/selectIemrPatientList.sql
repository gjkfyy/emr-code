select
  *
from
  IEMR_PATIENT
where 1=1
/*%if condition != null */
 and ( patient_name = /* condition */'a' 
 or inpatient_no = /* condition */'b'
 or admission_date = /* condition */'c') 
/*%end */
 and del_f = 0
 order by last_upd_time desc
