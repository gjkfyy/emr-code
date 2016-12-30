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
  /*%if startTime != null && startTime != ""*/
  and t.happentime >= /* startTime */'2014-8-27 16:20:00'
  /*%end */
  /*%if endTime != null && endTime != ""*/
  and t.happentime <= /* endTime */'2014-8-27 16:20:00'
  /*%end */
  and t.treattime is null
order by 
  t.happentime asc