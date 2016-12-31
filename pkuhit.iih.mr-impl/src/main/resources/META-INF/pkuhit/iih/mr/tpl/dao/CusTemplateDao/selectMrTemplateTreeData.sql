select *
  from (select t.en_tp_cd enTypeCode,
               t.org_cd hisOrgCode,
               '' hisOrgName,
               t.own_tp_cd ownerTypeCode,
               (select g.nm from md_gs g where g.gs_cd='MDM08.01') ownerTypeName,
               '' ownerName,
               t.own_cd ownerCode,
               '' templateCategoryCode,
               '' templateCategoryName,
               '' templateTypeCode,
               '' templateTypeName,
               '' templateCode,
               '' templateName,
               '' signLevelCode,
               '' filePk,
               t.own_tp_cd id,
               count(*) text,
               'owner' nodeType,
               /*dctNsF*/'1' dctNsF
          from mr_tpl t
         where t.del_f = 0
           and t.org_cd = /*orgCode*/'SZLH' 
           and t.own_tp_cd = 'MDM08.01'
           and t.own_cd = /*orgCode*/'SZLH' 
           and t.en_tp_cd = /*enTypeCode*/'ENM01.01'
           /*%if keyWord != null && keyWord != ""*/
           and t.nm like /*@contain(keyWord)*/'%入%'
           /*%end */
           /*%if mrTplTypeCd != null && mrTplTypeCd != ""*/
           and t.mr_tp_cd = /*mrTplTypeCd*/'MRM16.47'
           /*%end */
           /*%if mrTplStatCd != null && mrTplStatCd != ""*/
           and t.mr_tpl_sta_cd = /*mrTplStatCd*/'MRM07.04'
           /*%end */
           and exists (select *
                  from md_mr_tp_ccat_itm i, md_mr_tp_ccat c
                 where i.mr_tp_ccat_cd = c.mr_tp_ccat_cd
                   and i.mr_tp_cd = t.mr_tp_cd
                   and i.en_tp_cd = /*enTypeCode*/'ENM01.01'
                   /*%if mrTplCCat != null && mrTplCCat != ""*/
                   and c.mr_tp_ccat_cd = /*mrTplCCat*/'MRM07.04'
                   /*%end */
                   and c.dct_ns_f = /*dctNsF*/'1')
         group by t.en_tp_cd, t.org_cd, t.own_tp_cd, t.own_cd
        union all
        select t.en_tp_cd enTypeCode,
               t.org_cd hisOrgCode,
               '' hisOrgName,
               t.own_tp_cd ownerTypeCode,
               '' ownerTypeName,
               '' ownerName,
               t.own_cd ownerCode,
               t2.mr_tp_ccat_cd templateCategoryCode,
               t2.nm templateCategoryName,
               '' templateTypeCode,
               '' templateTypeName,
               '' templateCode,
               '' templateName,
               '' signLevelCode,
               '' filePk,
               t2.mr_tp_ccat_cd id,
               count(*) text,
               'category' nodeType,
               /*dctNsF*/'1' dctNsF
          from mr_tpl t, md_mr_tp_ccat_itm t1, md_mr_tp_ccat t2
         where t.mr_tp_cd = t1.mr_tp_cd
           and t1.mr_tp_ccat_cd = t2.mr_tp_ccat_cd
           and t.del_f = 0
           and t1.del_f = 0
           and t2.del_f = 0
           and t.org_cd = /*orgCode*/'SZLH'
           and t.own_tp_cd = 'MDM08.01'
           and t.own_cd = /*orgCode*/'SZLH'
           and t.en_tp_cd = /*enTypeCode*/'ENM01.01'
           and t1.en_tp_cd = /*enTypeCode*/'ENM01.01'
           and t2.dct_ns_f = /*dctNsF*/'1'
           /*%if keyWord != null && keyWord != ""*/
           and t.nm like /*@contain(keyWord)*/'%入%'
           /*%end */
           /*%if mrTplTypeCd != null && mrTplTypeCd != ""*/
           and t.mr_tp_cd = /*mrTplTypeCd*/'MRM16.47'
           /*%end */
           /*%if mrTplStatCd != null && mrTplStatCd != ""*/
           and t.mr_tpl_sta_cd = /*mrTplStatCd*/'MRM07.04'
           /*%end */
           /*%if mrTplCCat != null && mrTplCCat != ""*/
           and t2.mr_tp_ccat_cd = /*mrTplCCat*/'MRM07.04'
           /*%end */
         group by t.en_tp_cd,
                  t.org_cd,
                  t.own_tp_cd,
                  t.own_cd,
                  t2.mr_tp_ccat_cd,
                  t2.nm
        union all
        select t.en_tp_cd enTypeCode,
               t.org_cd hisOrgCode,
               '' hisOrgName,
               t.own_tp_cd ownerTypeCode,
               '' ownerTypeName,
               '' ownerName,
               t.own_cd ownerCode,
               '' templateCategoryCode,
               '' templateCategoryName,
               '' templateTypeCode,
               '' templateTypeName,
               '' templateCode,
               '' templateName,
               '' signLevelCode,
               '' filePk,
               t.own_cd id,
               count(*) text,
               'owner' nodeType,
               /*dctNsF*/'1' dctNsF
          from mr_tpl t
         where t.del_f = 0
           and t.org_cd = /*orgCode*/'SZLH'
           and t.own_tp_cd = 'MDM08.02'
           and t.en_tp_cd = /*enTypeCode*/'ENM01.01'
           /*%if keyWord != null && keyWord != ""*/
           and t.nm like /*@contain(keyWord)*/'%入%'
           /*%end */
           /*%if mrTplTypeCd != null && mrTplTypeCd != ""*/
           and t.mr_tp_cd = /*mrTplTypeCd*/'MRM16.47'
           /*%end */
           /*%if mrTplStatCd != null && mrTplStatCd != ""*/
           and t.mr_tpl_sta_cd = /*mrTplStatCd*/'MRM07.04'
           /*%end */
           and exists (select *
                  from md_mr_tp_ccat_itm i, md_mr_tp_ccat c
                 where i.mr_tp_ccat_cd = c.mr_tp_ccat_cd
                   and i.mr_tp_cd = t.mr_tp_cd
                   and i.en_tp_cd = /*enTypeCode*/'ENM01.01'
                   /*%if mrTplCCat != null && mrTplCCat != ""*/
                   and c.mr_tp_ccat_cd = /*mrTplCCat*/'MRM07.04'
                   /*%end */
                   and c.dct_ns_f = /*dctNsF*/'1')
         group by t.en_tp_cd, t.org_cd, t.own_tp_cd, t.own_cd
        union all
        select t.en_tp_cd enTypeCode,
               t.org_cd hisOrgCode,
               '' hisOrgName,
               t.own_tp_cd ownerTypeCode,
               '' ownerTypeName,
               '' ownerName,
               t.own_cd ownerCode,
               t2.mr_tp_ccat_cd templateCategoryCode,
               t2.nm templateCategoryName,
               '' templateTypeCode,
               '' templateTypeName,
               '' templateCode,
               '' templateName,
               '' signLevelCode,
               '' filePk,
               t2.mr_tp_ccat_cd id,
               count(*) text,
               'category' nodeType,
               /*dctNsF*/'1' dctNsF
          from mr_tpl t, md_mr_tp_ccat_itm t1, md_mr_tp_ccat t2
         where t.mr_tp_cd = t1.mr_tp_cd
           and t1.mr_tp_ccat_cd = t2.mr_tp_ccat_cd
           and t.del_f = 0
           and t1.del_f = 0
           and t2.del_f = 0
           and t.org_cd = /*orgCode*/'SZLH'
           and t.own_tp_cd = 'MDM08.02'
           and t.en_tp_cd = /*enTypeCode*/'ENM01.01'
           /*%if keyWord != null && keyWord != ""*/
           and t.nm like /*@contain(keyWord)*/'%入%'
           /*%end */
           /*%if mrTplTypeCd != null && mrTplTypeCd != ""*/
           and t.mr_tp_cd = /*mrTplTypeCd*/'MRM16.47'
           /*%end */
           /*%if mrTplStatCd != null && mrTplStatCd != ""*/
           and t.mr_tpl_sta_cd = /*mrTplStatCd*/'MRM07.04'
           /*%end */
           /*%if mrTplCCat != null && mrTplCCat != ""*/
           and t2.mr_tp_ccat_cd = /*mrTplCCat*/'MRM07.04'
           /*%end */
           and t1.en_tp_cd = /*enTypeCode*/'ENM01.01'
           and t2.dct_ns_f = /*dctNsF*/'1'
         group by t.en_tp_cd,
                  t.org_cd,
                  t.own_tp_cd,
                  t.own_cd,
                  t2.mr_tp_ccat_cd,
                  t2.nm
        union all
        select t.en_tp_cd enTypeCode,
               t.org_cd hisOrgCode,
               '' hisOrgName,
               t.own_tp_cd ownerTypeCode,
               (select g.nm from md_gs g where g.gs_cd='MDM08.03') ownerTypeName,
               '' ownerName,
               t.own_cd ownerCode,
               '' templateCategoryCode,
               '' templateCategoryName,
               '' templateTypeCode,
               '' templateTypeName,
               '' templateCode,
               '' templateName,
               '' signLevelCode,
               '' filePk,
               t.own_tp_cd id,
               count(*) text,
               'owner' nodeType,
               /*dctNsF*/'1' dctNsF
          from mr_tpl t
         where t.del_f = 0
           and t.org_cd = /*orgCode*/'SZLH'
           and t.own_tp_cd = 'MDM08.03'
           and t.own_cd = /*userId*/'004942'
           and t.en_tp_cd = /*enTypeCode*/'ENM01.01'
           /*%if keyWord != null && keyWord != ""*/
           and t.nm like /*@contain(keyWord)*/'%入%'
           /*%end */
           /*%if mrTplTypeCd != null && mrTplTypeCd != ""*/
           and t.mr_tp_cd = /*mrTplTypeCd*/'MRM16.47'
           /*%end */
           /*%if mrTplStatCd != null && mrTplStatCd != ""*/
           and t.mr_tpl_sta_cd = /*mrTplStatCd*/'MRM07.04'
           /*%end */
           and exists (select *
                  from md_mr_tp_ccat_itm i, md_mr_tp_ccat c
                 where i.mr_tp_ccat_cd = c.mr_tp_ccat_cd
                   and i.mr_tp_cd = t.mr_tp_cd
                   and i.en_tp_cd = /*enTypeCode*/'ENM01.01'
                   /*%if mrTplCCat != null && mrTplCCat != ""*/
                   and c.mr_tp_ccat_cd = /*mrTplCCat*/'MRM07.04'
                   /*%end */
                   and c.dct_ns_f = /*dctNsF*/'1')
         group by t.en_tp_cd, t.org_cd, t.own_tp_cd, t.own_cd
        union all
        select t.en_tp_cd enTypeCode,
               t.org_cd hisOrgCode,
               '' hisOrgName,
               t.own_tp_cd ownerTypeCode,
               '' ownerTypeName,
               '' ownerName,
               t.own_cd ownerCode,
               t2.mr_tp_ccat_cd templateCategoryCode,
               t2.nm templateCategoryName,
               '' templateTypeCode,
               '' templateTypeName,
               '' templateCode,
               '' templateName,
               '' signLevelCode,
               '' filePk,
               t2.mr_tp_ccat_cd id,
               count(*) text,
               'category' nodeType,
               /*dctNsF*/'1' dctNsF
          from mr_tpl t, md_mr_tp_ccat_itm t1, md_mr_tp_ccat t2
         where t.mr_tp_cd = t1.mr_tp_cd
           and t1.mr_tp_ccat_cd = t2.mr_tp_ccat_cd
           and t.del_f = 0
           and t1.del_f = 0
           and t2.del_f = 0
           and t.org_cd = /*orgCode*/'SZLH'
           and t.own_tp_cd = 'MDM08.03'
           and t.own_cd = /*userId*/'004942'
           and t.en_tp_cd = /*enTypeCode*/'ENM01.01'
           /*%if keyWord != null && keyWord != ""*/
           and t.nm like /*@contain(keyWord)*/'%入%'
           /*%end */
           /*%if mrTplTypeCd != null && mrTplTypeCd != ""*/
           and t.mr_tp_cd = /*mrTplTypeCd*/'MRM16.47'
           /*%end */
           /*%if mrTplStatCd != null && mrTplStatCd != ""*/
           and t.mr_tpl_sta_cd = /*mrTplStatCd*/'MRM07.04'
           /*%end */
           /*%if mrTplCCat != null && mrTplCCat != ""*/
           and t2.mr_tp_ccat_cd = /*mrTplCCat*/'MRM07.04'
           /*%end */
           and t1.en_tp_cd = /*enTypeCode*/'ENM01.01'
           and t2.dct_ns_f = /*dctNsF*/'1'
         group by t.en_tp_cd,
                  t.org_cd,
                  t.own_tp_cd,
                  t.own_cd,
                  t2.mr_tp_ccat_cd,
                  t2.nm
        union all
        select t.en_tp_cd enTypeCode,
               t.org_cd hisOrgCode,
               '' hisOrgName,
               t.own_tp_cd ownerTypeCode,
               '' ownerTypeName,
               '' ownerName,
               t.own_cd ownerCode,
               t3.mr_tp_ccat_cd templateCategoryCode,
               t3.nm templateCategoryName,
               t1.mr_tp_cd templateTypeCode,
               t1.nm templateTypeName,
               '' templateCode,
               '' templateName,
               '' signLevelCode,
               '' filePk,
               t1.mr_tp_cd id,
               count(*) text,
               'type' nodeType,
               /*dctNsF*/'1' dctNsF
          from mr_tpl t, md_mr_tp t1, md_mr_tp_ccat_itm t2, md_mr_tp_ccat t3
         where t.mr_tp_cd = t1.mr_tp_cd
           and t1.mr_tp_cd = t2.mr_tp_cd
           and t2.mr_tp_ccat_cd = t3.mr_tp_ccat_cd
           and t.del_f = 0
           and t2.del_f = 0
           and t3.del_f = 0
           and t.org_cd = /*orgCode*/'SZLH'
           and t.own_tp_cd = 'MDM08.01'
           and t.own_cd = 'SZLH'
           and t.en_tp_cd = /*enTypeCode*/'ENM01.01'
           /*%if keyWord != null && keyWord != ""*/
           and t.nm like /*@contain(keyWord)*/'%入%'
           /*%end */
           /*%if mrTplTypeCd != null && mrTplTypeCd != ""*/
           and t.mr_tp_cd = /*mrTplTypeCd*/'MRM16.47'
           /*%end */
           /*%if mrTplStatCd != null && mrTplStatCd != ""*/
           and t.mr_tpl_sta_cd = /*mrTplStatCd*/'MRM07.04'
           /*%end */
           /*%if mrTplCCat != null && mrTplCCat != ""*/
           and t3.mr_tp_ccat_cd = /*mrTplCCat*/'MRM07.04'
           /*%end */
           and t2.en_tp_cd = /*enTypeCode*/'ENM01.01'
           and t3.dct_ns_f = /*dctNsF*/'1'
         group by t.en_tp_cd,
                  t.org_cd,
                  t.own_tp_cd,
                  t.own_cd,
                  t3.mr_tp_ccat_cd,
                  t3.nm,
                  t1.mr_tp_cd,
                  t1.nm
        union all
        select t.en_tp_cd enTypeCode,
               t.org_cd hisOrgCode,
               '' hisOrgName,
               t.own_tp_cd ownerTypeCode,
               '' ownerTypeName,
               '' ownerName,
               t.own_cd ownerCode,
               t3.mr_tp_ccat_cd templateCategoryCode,
               t3.nm templateCategoryName,
               t1.mr_tp_cd templateTypeCode,
               t1.nm templateTypeName,
               '' templateCode,
               '' templateName,
               '' signLevelCode,
               '' filePk,
               t1.mr_tp_cd id,
               count(*) text,
               'type' nodeType,
               /*dctNsF*/'1' dctNsF
          from mr_tpl t, md_mr_tp t1, md_mr_tp_ccat_itm t2, md_mr_tp_ccat t3
         where t.mr_tp_cd = t1.mr_tp_cd
           and t1.mr_tp_cd = t2.mr_tp_cd
           and t2.mr_tp_ccat_cd = t3.mr_tp_ccat_cd
           and t.del_f = 0
           and t2.del_f = 0
           and t3.del_f = 0
           and t.org_cd = /*orgCode*/'SZLH'
           and t.own_tp_cd = 'MDM08.02'
           and t.en_tp_cd = /*enTypeCode*/'ENM01.01'
           /*%if keyWord != null && keyWord != ""*/
           and t.nm like /*@contain(keyWord)*/'%入%'
           /*%end */
           /*%if mrTplTypeCd != null && mrTplTypeCd != ""*/
           and t.mr_tp_cd = /*mrTplTypeCd*/'MRM16.47'
           /*%end */
           /*%if mrTplStatCd != null && mrTplStatCd != ""*/
           and t.mr_tpl_sta_cd = /*mrTplStatCd*/'MRM07.04'
           /*%end */
           /*%if mrTplCCat != null && mrTplCCat != ""*/
           and t3.mr_tp_ccat_cd = /*mrTplCCat*/'MRM07.04'
           /*%end */
           and t2.en_tp_cd = /*enTypeCode*/'ENM01.01'
           and t3.dct_ns_f = /*dctNsF*/'1'
         group by t.en_tp_cd,
                  t.org_cd,
                  t.own_tp_cd,
                  t.own_cd,
                  t3.mr_tp_ccat_cd,
                  t3.nm,
                  t1.mr_tp_cd,
                  t1.nm
        union all
        select t.en_tp_cd enTypeCode,
               t.org_cd hisOrgCode,
               '' hisOrgName,
               t.own_tp_cd ownerTypeCode,
               '' ownerTypeName,
               '' ownerName,
               t.own_cd ownerCode,
               t3.mr_tp_ccat_cd templateCategoryCode,
               t3.nm templateCategoryName,
               t1.mr_tp_cd templateTypeCode,
               t1.nm templateTypeName,
               '' templateCode,
               '' templateName,
               '' signLevelCode,
               '' filePk,
               t1.mr_tp_cd id,
               count(*) text,
               'type' nodeType,
               /*dctNsF*/'1' dctNsF
          from mr_tpl t, md_mr_tp t1, md_mr_tp_ccat_itm t2, md_mr_tp_ccat t3
         where t.mr_tp_cd = t1.mr_tp_cd
           and t1.mr_tp_cd = t2.mr_tp_cd
           and t2.mr_tp_ccat_cd = t3.mr_tp_ccat_cd
           and t.del_f = 0
           and t2.del_f = 0
           and t3.del_f = 0
           and t.org_cd = /*orgCode*/'SZLH'
           and t.own_tp_cd = 'MDM08.03'
           and t.own_cd = /*userId*/'004942'
           and t.en_tp_cd = /*enTypeCode*/'ENM01.01'
           /*%if keyWord != null && keyWord != ""*/
           and t.nm like /*@contain(keyWord)*/'%入%'
           /*%end */
           /*%if mrTplTypeCd != null && mrTplTypeCd != ""*/
           and t.mr_tp_cd = /*mrTplTypeCd*/'MRM16.47'
           /*%end */
           /*%if mrTplStatCd != null && mrTplStatCd != ""*/
           and t.mr_tpl_sta_cd = /*mrTplStatCd*/'MRM07.04'
           /*%end */
           /*%if mrTplCCat != null && mrTplCCat != ""*/
           and t3.mr_tp_ccat_cd = /*mrTplCCat*/'MRM07.04'
           /*%end */
           and t2.en_tp_cd = /*enTypeCode*/'ENM01.01'
           and t3.dct_ns_f = /*dctNsF*/'1'
         group by t.en_tp_cd,
                  t.org_cd,
                  t.own_tp_cd,
                  t.own_cd,
                  t3.mr_tp_ccat_cd,
                  t3.nm,
                  t1.mr_tp_cd,
                  t1.nm) tmp
 order by tmp.ownerTypeCode || tmp.ownerCode || tmp.templateCategoryCode ||
          tmp.templateTypeCode
