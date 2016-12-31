SELECT 
  MR_TPL_DEPT_PK,
  MR_TPL_CD,
  APL_TO_TP_CD,
  APL_TO_CD,
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
  from mr_tpl_dept t
where 
del_f != 1
     	/*%if mrTplCode != null */
	and t.mr_tpl_cd = /*mrTplCode*/'SZLH.MRK02.3033.0001'
/*%end */