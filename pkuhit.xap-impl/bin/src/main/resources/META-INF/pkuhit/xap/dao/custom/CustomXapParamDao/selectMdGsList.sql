select 
   GS_CD,
  OBJ_CD,
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
 from MD_GS a where
  a.del_f = 0
/*%if keyword != null && keyword != ""*/
  and (a.nm like /* @contain(keyword) */'%g%' or a.SPELL_NO like /* @contain(keyword) */'%g%')
/*%end */
/*%if id != null && id != ""*/
  and a.obj_cd = /* id */'SYSM01'
/*%end */
order by a.nm