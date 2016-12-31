select 
 * 
from DI_SUITE ds
where del_f = 0
    /*%if orgCode != null  */
and org_cd = /*orgCode*/'00'
   /*%end */  
    /*%if ownerType != null  */
and owner_type_cd  = /*ownerType*/'BCM001.01'
   /*%end */  
    /*%if ownerCode != null  */
and owner_cd = /*ownerCode*/'00'
   /*%end */  
    /*%if enTypeCode != null  */
      and en_tp_cd = /*enTypeCode*/'00'
   /*%end */  
       /*%if diSuiteTypeCode != null  */
and di_suite_tp_cd = /*diSuiteTypeCode*/'00'
   /*%end */  
order by sort_no 