select MR_TPL_CD , NM ,MR_TP_CD
from MR_TPL 
where 
/*%if orgCode != null*/
   ORG_CD = /*orgCode*/'SZLH' 
/*%end */ 
/*%if ownerType != null  */
  and own_tp_cd = /*ownerType*/'MDM08.01' 
/*%end */   
/*%if ownerCode != null  */  
    and own_cd = /*ownerCode*/'MRM06.03'
/*%end */     
  /*%if enTypeCode != null*/
  and en_tp_cd = /*enTypeCode*/'MRM06.03' 
/*%end */  
order by  crt_time  desc , NM  