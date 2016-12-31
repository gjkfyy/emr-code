select 
  DI_SUITE_TEMPLATE_CD,
  DI_SUITE_CD,
  MR_TEMPLATE_CD,
  DI_CD,
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
  DEL_F,
  DI_SUITE_TP_CD,
  MR_TEMPLATE_NM
from DI_SUITE_TEMPLATE 
where 
del_f = 0
 /*%if diSuiteCode != null  */
and DI_SUITE_CD = /*diSuiteCode*/'BCM001.01'
/*%end */
