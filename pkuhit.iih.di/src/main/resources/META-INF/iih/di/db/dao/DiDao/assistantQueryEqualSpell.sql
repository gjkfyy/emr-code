select 
  DI_CD,
  ORG_CD,
  NM,
  DES,
  ICD_CD,
  INF_F,
  SYM_F,
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
  from MD_DI t
 where
 t.del_f = 0
 /*%if isEqual == true*/
   and spell_no = /*keyWord*/'g%'
/*%end*/
order by t.spell_no, t.nm
