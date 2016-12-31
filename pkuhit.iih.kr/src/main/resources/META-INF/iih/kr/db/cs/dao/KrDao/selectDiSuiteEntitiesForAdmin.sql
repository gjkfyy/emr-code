select 
dst.di_suite_tp_cd diSuiteTypeCode, 
dst.di_suite_tp_nm diSuiteTypeName,
ds.di_suite_cd diSuiteCode,
ds.di_cd diCode,
mddi.nm diName 
from Di_Suite_Tp  dst
left join DI_SUITE ds
on ds.di_suite_tp_cd = dst.di_suite_tp_cd
left join md_di mddi
on ds.di_cd = mddi.di_cd
where
dst.del_f = 0
    /*%if orgCode != null  */
and dst.org_cd = /*orgCode*/'00'
   /*%end */  
    /*%if ownerType != null  */
and dst.owner_type_cd  = /*ownerType*/'BCM001.01'
   /*%end */  
    /*%if ownerCode != null  */
and dst.owner_cd = /*ownerCode*/'00'
   /*%end */  
    /*%if enTypeCode != null  */
and dst.en_tp_cd = /*enTypeCode*/'00'
   /*%end */  
  order by dst.sort_no,ds.sort_no 