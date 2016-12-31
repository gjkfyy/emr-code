 select
  DI_SUITE_TP_CD,
  ORG_CD,
  DI_SUITE_TP_NM,
  DESCR,
  OWNER_TYPE_CD,
  OWNER_CD,
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
from
  DI_SUITE_TP
 where 
  del_f = 0
 /*%if ownerType != null  */
and owner_type_cd = /*ownerType*/'BCM001.01'
/*%end */
/*%if ownerCode != null  */
   and owner_cd = /*ownerCode*/'00'
   /*%end */
    /*%if sortNo != null && isInclude != null */
 and SORT_NO >= /* sortNo */1
 /*%end */
  /*%if sortNo != null && isInclude == null */
 and SORT_NO > /* sortNo */1
 /*%end */