select 
   MR_SHARE_ELEMENT_CD,
  NM,
  DES,
  CATEGORY,
  MACRO_FLAG,
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
  from MD_MR_SHARE_ELEMENT m
 where m.del_f = 0
   and m.macro_flag = /*macroFlag*/'a'
      /*%if spellNo != null && spellNo != "" */
   		and (m.spell_no  like /* @contain(spellNo) */'%801%' 
	         or m.nm like /* @contain(spellNo) */'%801%' 
			 or m.wubi_no like /* @contain(spellNo) */'%801%')
	 /*%end */
 order by m.category,m.sort_no