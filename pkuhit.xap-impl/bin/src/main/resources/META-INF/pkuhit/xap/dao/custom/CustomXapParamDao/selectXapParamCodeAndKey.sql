SELECT value from XAP_PARAM p where p.DEL_F = 0 
 /*%if paramCd != null && paramCd != ""*/
  and p.PARAM_CD != /* paramCd */'a'
/*%end*/
/*%if code != null && code != ""*/
  and p.CODE = /* code */'a'
/*%end*/
 /*%if key != null  && key != ""*/
  and p.KEY = /* key */'a'
/*%end*/
