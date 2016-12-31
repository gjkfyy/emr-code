select t.MR_TPL_CD,
       t.NM,
       t.EN_TP_CD,
       t.ORG_CD,
       o.nm ORGANIZATIONNAME,
       t.MR_BASE_TPL_CD,
       bt.nm BASETEMPLATENAME,
       t.FILE_PK,
       t.XML_FILE_PK,
       t.MR_TPL_STA_CD,
       gs.nm STATUSNAME,
       t.DES,
       t.OWN_TP_CD,
       gs1.nm OWNERTYPENAME,
       t.OWN_CD,
       (case
         when t.own_tp_cd = 'MDM08.01' then
          (select nm from md_gs where GS_CD = 'MDM08.01')
         else
          (case
         when t.own_tp_cd = 'MDM08.02' then
          (select nm from org where ORG_CD = t.own_cd)
         else
          (select nm from md_gs where GS_CD = 'MDM08.03')
       end) end) OWNERNAME,
       to_char(t.CRT_TIME,'yyyy-MM-dd hh:mm:ss') CRT_TIME,
       t.CRT_USER_ID,
       oe.nm CREATEUSERNAME,
       to_char(t.LAST_UPD_TIME,'yyyy-MM-dd hh:mm:ss') LAST_UPD_TIME,
       t.LAST_UPD_USER_ID,
       oe1.nm LASTUPDATEUSERNAME,
       t.DEFAULT_F,
       (case t.DEFAULT_F
         when 1 then
          '是'
         else
          '否'
       end) DEFAULTNAME,
       t.MR_TP_CD,
       tp.nm MRTYPENAME,
       t.MR_SIGN_LVL_CD,
       gs2.nm SIGNLEVELNAME,
       (case
          when t.own_tp_cd = 'MDM08.01' then
           (case
          when exists (select r.user_role_cd
                  from xap_user_role r
                 where r.user_id = /*userCode*/'004288'
                   and r.role_cd = 'XAPM14.11') then
           1
          else
           0
        end) when t.own_tp_cd = 'MDM08.02' then(case
         when exists
          (select r.user_role_cd
                 from xap_user_role r
                where r.user_id =
                      /*userCode*/'004288'
                  and (r.role_cd =
                      'XAPM14.11' or
                      r.role_cd =
                      'XAPM14.12')) then
          1
         else
          0
       end) else 1 end) CANUPDATE
  from MR_TPL t
  left join org_emp oe on t.CRT_USER_ID = oe.emp_id
  left join org_emp oe1 on t.LAST_UPD_USER_ID = oe1.emp_id
  left join org o on t.ORG_CD = o.ORG_CD
  left join mr_base_tpl bt on t.MR_BASE_TPL_CD = bt.MR_BASE_TPL_CD
  left join md_gs gs on t.MR_TPL_STA_CD = gs.gs_cd
  left join md_gs gs1 on t.OWN_TP_CD = gs1.gs_cd
  left join md_gs gs2 on t.MR_SIGN_LVL_CD = gs2.gs_cd
  left join MD_MR_TP tp on t.MR_TP_CD = tp.MR_TP_CD
 where t.del_f = 0
 and t.ORG_CD = /*orgCode*/'SZLH'
/*%if statusCode != null && statusCode != ""*/
  and t.MR_TPL_STA_CD = /*statusCode*/'MRM07.06'
/*%end */
/*%if name != null*/
  and t.NM like /* @contain(name) */'%g%'
/*%end */ 
/*%if dctNsF != null*/
  and exists (select i.mr_tp_ccat_itm_cd
	  from md_mr_tp_ccat_itm i, md_mr_tp_ccat c
	 where i.mr_tp_ccat_cd = c.mr_tp_ccat_cd
	   and i.mr_tp_cd = t.mr_tp_cd
	   and c.dct_ns_f = /*dctNsF*/'1'
	   and i.en_tp_cd = /*enTypeCode*/'MRM06.03'
	)
/*%end */ 
/*%if ownerTypeCode != null*/
  and t.own_tp_cd = /*ownerTypeCode*/'MDM08.01' 
/*%end */   
/*%if ownerCode != null*/  
  and t.own_cd = /*ownerCode*/'MRM06.03' 
/*%end */   
/*%if mrCategoryCode != null*/
  and exists (select i.mr_tp_ccat_itm_cd
	  from md_mr_tp_ccat_itm i
	 where i.mr_tp_cd = t.mr_tp_cd
	   and i.mr_tp_ccat_cd = /*mrCategoryCode*/'MDM08.01'
   )
/*%end */  
/*%if typeCode != null*/
  and t.mr_tp_cd = /*typeCode*/'MRM06.03'
/*%end */  
  /*%if enTypeCode != null*/
  and t.en_tp_cd = /*enTypeCode*/'MRM06.03' 
/*%end */  
order by to_number(nvl(t.sort_no,0)) asc,t.own_tp_cd , t.crt_time  desc , t.NM  