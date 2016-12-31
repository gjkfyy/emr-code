select
  eventid,
  recid,
  eventtype,
  happentime,
  note,
  treattime,
  endtime,
  evt_source,
  order_sn,
  enc_id,
  deleted_flag
from
  emr_event
where
  eventid = /* eventid */1
