select   MR_BASE_TPL_CD,
  FILE_PK,
  NM,
  DES,
  PAPER_TP_CD,
  MR_BASE_TPL_STA_CD,
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
from MR_BASE_TPL 
where 
1=1 
/*%if excludeDelete != null*/
 and del_f != 1
/*%end */ 
/*%if statusCode != null && statusCode.size() > 0 */
  and mr_base_tpl_sta_cd in /*statusCode*/('MRM06.03','MRM06.03' )
/*%end */ 
 /*%if name != null*/
  and NM like /* @contain(name) */'%g%'
/*%end */  
/*%if rootCode != null*/
  and rt_mr_base_tpl_cd = /*rootCode*/'MRM06.03'
/*%end */  
  
order by  crt_time  desc 
