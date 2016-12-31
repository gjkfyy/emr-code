select
  ROLE_MENU_CD,
  ROLE_CD,
  MENU_CD,
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
  XAP_ROLE_MENU
where
  ROLE_MENU_CD = /* roleMenuCd */'a'
and del_f = 0
