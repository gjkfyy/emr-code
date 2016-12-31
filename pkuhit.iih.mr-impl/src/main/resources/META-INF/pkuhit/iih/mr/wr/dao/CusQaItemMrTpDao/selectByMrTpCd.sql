select 
   FST_MR_TP_CD,
  FST_CD,
  MR_TP_CD,
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
  from QA_ITEM_MR_TP t
 where t.del_f = 0
   and t.mr_tp_cd = /*mrTypeCode*/'a'
