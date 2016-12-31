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
  XML_FILE_PK,
  DEL_F 
 from MR_TPL 
where 
 ORG_CD = /*orgCode*/'SZLH' 
/*%if codeList != null   && codeList.size() > 0 */  
    and mr_tpl_cd  in /*codeList*/('MRK02.00267.01','MRK02.00267.01') 
/*%end */   
/*%if excludeDelete != null*/
 and del_f != 1
/*%end */
/*%if statusCode != null && statusCode.size()>0 */
  and MR_TPL_STA_CD in /*statusCode*/('MRM07.06') 
/*%end */
/*%if name != null*/
  and NM like /* @contain(name) */'%g%'
/*%end */ 
/*%if rootCode != null*/
  and rt_mr_tpl_pk = /*rootCode*/'MRM06.03'
/*%end */ 
/*%if ownerTypeCode != null   && ownerCode  != null */
  and own_tp_cd = /*ownerTypeCode*/'MDM08.01' 
/*%end */   
/*%if ownerCode != null   && ownerCode.size() > 0 */  
    and own_cd in /*ownerCode*/('MRM06.03','MRM06.03') 
/*%end */   
/*%if baseTemplateCode != null*/
  and mr_base_tpl_cd /*baseTemplateCode*/'MRM06.03' 
/*%end */  
/*%if typeCode != null  && typeCode.size() > 0 */
  and mr_tp_cd in /*typeCode*/('MRM06.03' )
/*%end */  
  /*%if enTypeCode != null*/
  and en_tp_cd = /*enTypeCode*/'MRM06.03' 
/*%end */  
order by to_number(nvl(sort_no,0)) asc,own_tp_cd , crt_time  desc , NM  