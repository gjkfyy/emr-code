select
  sn,
  patient_id,
  admiss_times,
  diagtype,
  diag_subtype,
  doctor_sn,
  dept_sn,
  ward_sn,
  diag_str,
  diag_code,
  icd_code,
  comment_str,
  main_flag,
  uncertain_flag,
  contagion_flag,
  input_date,
  deleted_flag
from
  zy_patient_diagnosis
where
  sn = /* sn */1
and del_f = 0
