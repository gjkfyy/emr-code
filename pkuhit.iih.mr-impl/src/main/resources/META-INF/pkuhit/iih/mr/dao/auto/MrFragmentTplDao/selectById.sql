select FRAGMENT_TPL_CD,
       FRAGMENT_TPL_CONTENT,
       FRAGMENT_TPL_TYPE_CD,
       OWNER_CD,
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
       FRAGMENT_TPL_NM,
       OWNER_TYPE_CD
  from MR_FRAGMENT_TPL
 where FRAGMENT_TPL_CD = /*fragmentTplCd*/'a'
   and DEL_F = 0