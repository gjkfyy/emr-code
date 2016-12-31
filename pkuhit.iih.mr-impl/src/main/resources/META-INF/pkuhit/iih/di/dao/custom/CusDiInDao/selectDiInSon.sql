select 
  DI_SN,
  EN_SN,
  PAR_DI_SN,
  ORG_CD,
  LVL,
  LVL1_SORT_NO,
  LVL2_SORT_NO,
  DI_TYPE_CD,
  DI_CD,
  DI_NM,
  ICD_CD,
  ADD_DESCR,
  MAIN_F,
  DI_TIME,
  DI_EMP_ID,
  DI_DEPT_CD,
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
  DI_TYPE_NM
  from DI_IN t
 where del_f = 0 
/*%if parDiSn != null*/
 and t.par_di_sn = /*parDiSn*/'p5s1'
/*%end */
