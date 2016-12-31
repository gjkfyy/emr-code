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
/*%if prefixF == true*/
  and  spell_no like /* @prefix(keyWord) */'g%'
    and spell_no not in (select t2.spell_no
                      from MD_DI t2
                     where t2. spell_no = /*keyWord*/'g%' )
/*%else*/
  and  spell_no like /* @contain(keyWord) */'%g%'
 and  spell_no not in (select t2.spell_no
                      from MD_DI t2
                     where t2.spell_no like /* @prefix(keyWord) */'g%')
/*%end*/
order by t.spell_no, t.nm
