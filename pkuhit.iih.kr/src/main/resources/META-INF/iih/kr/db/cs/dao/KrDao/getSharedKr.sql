select 
  DI_SUITE_SHARE_CD,
  OWNER_TYPE_CD,
  OWNER_CD,
  SHARE_NM,
  TO_OWNER_TYPE_CD,
  TO_OWNER_CD,
  TO_SHARE_NM,
  MEMO,
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
from DI_SUITE_SHARE s
where 
 /*%if sOwnerType != null  */
and s.OWNER_TYPE_CD = /*sOwnerType*/'BCM001.01'
/*%end */
 /*%if sOwnerCode != null  */
and s.OWNER_CD = /*sOwnerCode*/'93001'
/*%end */
 /*%if dOwnerType != null  */
and s.TO_OWNER_TYPE_CD = /*dOwnerType*/'BCM001.01'
/*%end */
 /*%if dOwnerCode != null  */
and TO_OWNER_CD = /*dOwnerCode*/'93001'
/*%end */