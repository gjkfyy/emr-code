select
  id,
  encounter_id,
  doc_type,
  create_date,
  creator,
  doc_id,
  doc_name,
  doc_content,
  message_id
from
  iemr_doc_content
where
  id = /* id */1
