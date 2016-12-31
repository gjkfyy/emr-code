select
  COND_CD,
  RETRIEVAL_CD,
  COND_NAME,
  REL_TYPE,
  COND_TYPE,
  OBJ_CODE,
  OBJ_NAME,
  LOGIC,
  VAL_NAME,
  VAL_CODE,
  GRADE,
  UPCOND,
  FULL_PATH,
  DES,
  COND_NO,
  MEMO,
  SORT_NO
from
  IEMR_RETRIEVAL_COND
where
  DEL_F = 0
  /*%if retrievalCd != null && retrievalCd != "" */
  and RETRIEVAL_CD = /* retrievalCd */'a'
  /*%end */
  /*%if condCd != null && condCd != "" */
  and COND_CD = /* condCd */'a'
  /*%end */
  /*%if grade != null && grade != "" */
  and GRADE = /* grade */'a'
  /*%end */
  order by COND_NO
