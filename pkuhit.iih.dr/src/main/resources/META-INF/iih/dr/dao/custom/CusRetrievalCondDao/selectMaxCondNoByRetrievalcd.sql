select
  max(COND_NO)
from
  IEMR_RETRIEVAL_COND
where
  1=1
  /*%if retrievalCd != null && retrievalCd != "" */
  and RETRIEVAL_CD = /* retrievalCd */'a'
  /*%end */
