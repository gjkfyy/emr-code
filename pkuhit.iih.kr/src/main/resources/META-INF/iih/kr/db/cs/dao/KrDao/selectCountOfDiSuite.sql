select count(DI_SUITE_CD) from 
Di_Suite  ds
where ds.del_f = 0
    /*%if orgCode != null  */
and ds.org_cd = /*orgCode*/'00'
   /*%end */  
    /*%if ownerType != null  */
and ds.owner_type_cd  = /*ownerType*/'BCM001.01'
   /*%end */  
    /*%if ownerCode != null  */
and ds.owner_cd = /*ownerCode*/'00'
   /*%end */  
    /*%if enTypeCode != null  */
      and ds.en_tp_cd = /*enTypeCode*/'00'
   /*%end */ 
      
       /*%if diSuiteTypeCode != null  */
and ds.DI_SUITE_TP_CD = /*diSuiteTypeCode*/'00'
   /*%end */  
    /*%if diCode != null  */
      and ds.DI_CD = /*diCode*/'00'
   /*%end */ 
      
  order by ds.sort_no 