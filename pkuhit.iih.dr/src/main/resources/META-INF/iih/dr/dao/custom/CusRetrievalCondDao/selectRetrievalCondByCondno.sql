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
  and RETRIEVAL_CD = /* retrievalCd */'0CD6FE015B4B42F9B867F3B7BEA5CC65'
  /*%end */
  /*%if grade != null && grade != 0 */
  and GRADE = /* grade */2
  /*%end */
  /*%if upcond != null && upcond != "" */
  and UPCOND = /* upcond */'D635617929BC462BBE413CB94054CF81'
  /*%end */
  order by COND_NO
