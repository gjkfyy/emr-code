select  
DI_CD,
  ORG_CD,
  NM,
  DES,
  ICD_CD,
  INF_F,
  SYM_F,
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
  from MD_DI a
where
  a.del_f = 0
/*%if keyword != null && keyword != "" */
  and (a.nm like /* @prefix(keyword) */'G%'
  --  or a.icd_cd like /* @contain(keyword) */'%801%'
    or upper(a.spell_no) like /* @prefix(keyword) */'G%'
  )
  --and a.icd_cd is not null
/*%end */

order by 
  a.sort_no