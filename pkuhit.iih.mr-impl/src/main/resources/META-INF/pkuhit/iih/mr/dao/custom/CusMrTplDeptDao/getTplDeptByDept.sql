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
where del_f != 1 
/*%if deptCode != null && deptCode.size() > 0 */
 and t.apl_to_cd in /*deptCode*/('MDM12.01')
/*%end */
     	/*%if tplUseTypeCode != null */
and t.apl_to_tp_cd = /*tplUseTypeCode*/'MDM12.03'
/*%end */