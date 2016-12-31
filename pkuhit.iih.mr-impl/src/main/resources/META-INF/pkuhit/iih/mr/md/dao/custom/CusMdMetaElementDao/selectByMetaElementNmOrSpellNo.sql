select DATA_ELEMENT_CD,DATA_ELEMENT_NM,memo from MD_META_ELEMENT m where m.DEL_F = 0
	/*%if cond != null && cond != "" && cond != "null" */
	and (m.DATA_ELEMENT_NM like /* @contain(cond) */'%801%' or m.DATA_ELEMENT_CD = /* cond */'801' 
   		or upper(m.SPELL_NO)  like /* @contain(cond) */'%801%' or upper(m.WUBI_NO) like /* @contain(cond) */'%801%'
			 )
	/*%end */
 order by m.SORT_NO