select 
   DATA_ELEMENT_VALUE_CD,
  DATA_ELEMENT_CD,
  VALUE_CODE,
  VALUE_DISPLAY,
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
 from MD_META_ELEMENT_VALUE m where m.DEL_F = 0
/*%if dataElementCd != null && dataElementCd != "" */
	and m.DATA_ELEMENT_CD = /*dataElementCd*/'a'
/*%end */
 order by m.SORT_NO,value_code