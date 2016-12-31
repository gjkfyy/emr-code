select
  DI_SUITE_DI_CD,
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
  DI_SUITE_CD,
  REL_DI_CD,
  REL_DI_NM,
  REL_DI_ICD,
  DI_NM  
from DI_SUITE_DI t 
where 
del_f = 0
 /*%if diSuiteCode != null  */
and DI_SUITE_CD = /*diSuiteCode*/'BCM001.01'
/*%end */
