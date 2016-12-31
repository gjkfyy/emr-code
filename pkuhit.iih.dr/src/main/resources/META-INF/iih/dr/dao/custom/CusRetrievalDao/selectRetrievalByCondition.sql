select
  distinct r.RETRIEVAL_CD,
  r.RETRIEVAL_NM,
  r.OWN_TP_CD,
  r.DEPT_CD,
  r.RESPONSIBLE_CD,
  r.RETRIEVAL_KEY,
  r.STATUS_F,
  r.MEMO,
  c.OBJ_CODE,
  r.SORT_NO,
  r.SPELL_NO,
  r.WUBI_NO,
  r.UPD_CNT,
  r.CRT_TIME,
  r.CRT_USER_ID,
  r.CRT_DEPT_CD,
  r.LAST_UPD_TIME,
  r.LAST_UPD_DEPT_CD,
  r.LAST_UPD_USER_ID,
  r.DEL_F
from
  IEMR_RETRIEVAL r
  left join IEMR_RETRIEVAL_COND c on r.RETRIEVAL_CD=c.RETRIEVAL_CD
where
  r.DEL_F = 0 
  /*%if retrievalCd != null && retrievalCd != "" */
  and r.RETRIEVAL_CD = /* retrievalCd */'a'
  /*%end */
  /*%if retrievalNm != null && retrievalNm != "" */
  and upper(r.RETRIEVAL_NM) like /* @prefix(retrievalNm) */'a%'
  /*%end */
  /*%if ownTpCd != null && ownTpCd != "" */
  and r.OWN_TP_CD = /* ownTpCd */'a'
  /*%end */
  /*%if responsibleCd != null && responsibleCd != "" */
  and r.RESPONSIBLE_CD = /* responsibleCd */'a'
  /*%end */
  /*%if retrievalKey != null && retrievalKey != "" */
  and upper(r.RETRIEVAL_KEY) like /* @prefix(retrievalKey) */'a%'
  /*%end */
  /*%if deptCd != null && deptCd != "" */
  and r.DEPT_CD = /* deptCd */'a'
  /*%end */
  /*%if lastUpdTime != null */
  and c.DEL_F = 0
  and c.LAST_UPD_TIME > /* @roundDownTimePart(lastUpdTime) */'yyyy-MM-dd HH:mm:ss'
  /*%end */
  order by r.CRT_TIME desc
