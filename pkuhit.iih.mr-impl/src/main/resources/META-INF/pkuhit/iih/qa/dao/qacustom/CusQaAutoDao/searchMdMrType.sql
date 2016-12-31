select 
  MR_TP_CD,
  NM,
  DES,
  NM_EN,
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
  MR_SIGN_LVL_CD,
  ONLY_F,
  NEW_PAGE_F 
 from MD_MR_TP 
 where 
 del_f = 0 
