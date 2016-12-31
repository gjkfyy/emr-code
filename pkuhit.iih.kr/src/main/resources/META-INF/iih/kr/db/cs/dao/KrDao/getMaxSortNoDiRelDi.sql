select decode(max(SORT_NO),null,0,max(SORT_NO)) from 
 DI_SUITE_DI
where del_f = 0
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
and DI_SUITE_TP_CD = /*diSuiteTypeCode*/'00'
   /*%end */  
    /*%if diSuiteCode != null  */
      and DI_SUITE_CD = /*diSuiteCode*/'00'
   /*%end */ 
      
  order by sort_no 