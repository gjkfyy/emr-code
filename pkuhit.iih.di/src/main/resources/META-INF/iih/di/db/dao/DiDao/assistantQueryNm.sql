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
 and
/*%if prefixF == true*/
t.nm like /* @prefix(keyWord) */'g%'
/*%else*/
 t.nm like /* @contain(keyWord) */'%g%'
 and t.nm not in (select t2.nm
                      from MD_DI t2
                     where t2.nm like /* @prefix(keyWord) */'g%')
/*%end*/
order by t.nm, t.spell_no
