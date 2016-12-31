SELECT count(*) from XAP_PARAM p where p.DEL_F = 0 
/*%if nm != null  && nm != ""*/
  and p.nm = /* nm */'a'
/*%end*/
/*%if paramCd != null && paramCd != ""*/
  and p.PARAM_CD != /* paramCd */'a'
/*%end*/
