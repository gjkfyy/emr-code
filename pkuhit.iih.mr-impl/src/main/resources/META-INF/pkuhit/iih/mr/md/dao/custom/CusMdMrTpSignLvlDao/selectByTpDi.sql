select
  MR_TP_SIGN_LVL_CD,
  MR_TP_CD,
  ORG_CD,
  DI_CD,
  MR_SIGN_LVL_CD,
  SORT_NO,
  UPD_CNT,
  CRT_TIME,
  CRT_USER_ID,
  CRT_DEPT_CD,
  LAST_UPD_TIME,
  LAST_UPD_DEPT_CD,
  LAST_UPD_USER_ID,
  DEL_F
from
  MD_MR_TP_SIGN_LVL
where
del_f = 0
and ORG_CD = /*deptCode*/'4100' 
and MR_TP_CD =/*mrTypeCode*/'a' 
/*%if mainDiCode != null*/
and DI_CD =/*mainDiCode*/'a' 
/*%end */