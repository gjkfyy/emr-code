select 
  max(r.LAST_UPD_TIME)  as LAST_UPD_TIME
  from IEMR_RETRIEVAL_RESULT r
  --where r.DEL_F=0