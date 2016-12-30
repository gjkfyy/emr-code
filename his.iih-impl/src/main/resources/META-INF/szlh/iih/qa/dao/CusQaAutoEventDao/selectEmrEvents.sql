select  
t.eventid,
t.recid,
t.eventtype,
t.happentime,
t.endtime,
t.enc_id,
t.deleted_flag
from emr_event t  
where
  t.deleted_flag = 0
/*%if encId != null && encId != ""*/
  and t.enc_id = /* encId */'4309'
/*%else*/
  and t.enc_id = ""
/*%end */
order by 
  t.happentime asc