select 
  MR_TP_CCAT_CD,
  NM,
  DES,
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
  DEL_F,
  CONTINUE_PRINT_F,
  DCT_NS_F
  from MD_MR_TP_CCAT a 
where
  a.del_f = 0
order by a.sort_no