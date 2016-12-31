select 
  ENCOUNTER_SN,
  MR_DOC_SN,
  DATA_ELEMENT_ID,
  VALUE,
  MRB_MR_DOC_VALUE_ID,
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
  from mr_doc_value m
 where m.del_f = 0
    /*%if enPk != null && enPk != "" */
   and m.encounter_sn = /*enPk*/'a'
	 /*%end */
    /*%if mrPk != null && mrPk != "" */
   and m.mr_doc_sn = /*mrPk*/'a'
	 /*%end */
       /*%if elemId != null && elemId != "" */
   and m.data_element_id = /*elemId*/'a'
	 /*%end */
order by m.last_upd_time desc