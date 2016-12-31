select 
ds.di_suite_cd diSuiteCode,
ds.di_suite_tp_cd diSuiteTypeCode, 
dst.di_suite_tp_nm diSuiteTypeName,
ds.di_cd diCode,
mddi.nm diName 
from DI_SUITE ds
left join Di_Suite_Tp dst
on ds.di_suite_tp_cd = dst.di_suite_tp_cd
left join md_di mddi
on ds.di_cd = mddi.di_cd
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
  order by dst.sort_no,ds.sort_no 