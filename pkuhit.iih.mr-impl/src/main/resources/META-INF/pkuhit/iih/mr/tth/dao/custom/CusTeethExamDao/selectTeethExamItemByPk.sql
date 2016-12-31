select TEETH_ITEM_PK,
	   TEETH_PK,
       TEETH_LOCATION,
       VALUE_STR,
       COL_DISABLED
  from MR_TEETH_EXAM_ITEM
 where 1 = 1
   /*%if pk != null && pk != "" */
   and TEETH_PK = /*pk*/'a'
   /*%end */
   order by TEETH_LOCATION