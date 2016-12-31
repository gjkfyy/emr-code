select count(DI_SUITE_TP_CD) from 
Di_Suite_Tp dst
where DI_SUITE_TP_NM =  /* diSuiteTypeName */'a' 
 and del_f = 0
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
  order by sort_no