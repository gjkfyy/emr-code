select DATA_ELEMENT_CD,DATA_ELEMENT_NM from MD_META_ELEMENT m where m.DEL_F = 0
	/*%if metaElementNm != null && metaElementNm != "null" */
	and (m.DATA_ELEMENT_NM like /* @contain(metaElementNm) */'%801%' or m.DATA_ELEMENT_CD = /* metaElementNm */'801' 
      	/*%if spellNo != null  && spellNo != "null"  */
   		or m.SPELL_NO  like /* @contain(spellNo) */'%801%' or m.WUBI_NO like /* @contain(spellNo) */'%801%'
	 	/*%end */
			 )
	/*%end */
 order by m.SORT_NO