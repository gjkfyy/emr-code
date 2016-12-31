select
  RESULT_CD,
  RETRIEVAL_CD,
  EN_PK,
  MR_PK,
  COND_CD,
  COND_NAME,
  COND_TEXT,
  MEMO,
  SORT_NO,
  SPELL_NO,
  WUBI_NO,
  UPD_CNT,
  CRT_TIME,
  CRT_USER_ID,
  CRT_DEPT_CD,
  LAST_UPD_TIME,
  LAST_UPD_DEPT_CD,
  LAST_UPD_USER_ID,
  DEL_F
from
  IEMR_RETRIEVAL_RESULT
where
	DEL_F=0
	/*%if retrievalCd != null && retrievalCd != "" */
    and RETRIEVAL_CD = /* retrievalCd */'a'
    /*%end */

