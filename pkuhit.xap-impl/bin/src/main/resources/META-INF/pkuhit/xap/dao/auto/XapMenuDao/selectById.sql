select
  MENU_CD,
  PAR_MENU_CD,
  PORTAL_CD,
  NM,
  DES,
  SHT_NM_EN,
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
  DEL_F
from
  XAP_MENU
where
  MENU_CD = /* menuCd */'a'
and del_f = 0
