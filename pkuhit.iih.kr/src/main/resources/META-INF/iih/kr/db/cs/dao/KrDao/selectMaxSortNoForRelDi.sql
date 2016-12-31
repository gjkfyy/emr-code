select decode(max(SORT_NO),null,0,max(SORT_NO)) from 
DI_SUITE_DI
where 
del_f = 0
    /*%if diSuiteCode != null  */
and DI_SUITE_CD = /*diSuiteCode*/'00'
   /*%end */  

  order by sort_no desc 