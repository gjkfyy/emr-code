select 
  MR_TPL_CD,
  ORG_CD,
  MR_BASE_TPL_CD,
  FILE_PK,
  MR_TPL_STA_CD,
  NM,
  DES,
  OWN_TP_CD,
  OWN_CD,
  MR_TP_CD,
  MR_SIGN_LVL_CD,
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
  EN_TP_CD,
  DEL_F
  from mr_tpl mt
 where mt.del_f = 0
   and mt.default_f = 1
   /*%if ownerTypeCode != null */
         and mt.own_tp_cd = /*ownerTypeCode*/'MDM08.02'
   /*%end */
   /*%if mrTypeCode != null */
         and mt.mr_tp_cd = /*mrTypeCode*/'MRM16.13'
   /*%end */
   /*%if ownerCode != null */
         and mt.own_cd = /*ownerCode*/'4309'
   /*%end */
