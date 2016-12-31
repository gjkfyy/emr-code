select 
  mt.MR_TPL_CD,
  mt.ORG_CD,
  mt.FILE_PK,
  mt.MR_TPL_STA_CD,
  gs1.nm MR_TPL_STA_NM,
  mt.NM,
  mt.DES,
  mt.OWN_TP_CD,
  case mt.own_tp_cd 
    when 'MDM08.01'then '全院'
     when 'MDM08.02'then '科室'
   else  '个人' end  own_tp_nm,
  mt.OWN_CD,
  case mt.own_tp_cd 
    when 'MDM08.03'then oe.nm 
   else  o.nm end  own_nm ,
  mt.MR_TP_CD,
   mdtp.nm MR_TP_NM ,
  mt.MR_SIGN_LVL_CD
  ,gs.nm MR_SIGN_LVL_NM
    , mdi.di_cd
  ,  mdi.nm di_nm
   ,case mt.default_f  when 1 then '是' else '否' end default_name 
 from MR_TPL mt
 left join  md_gs gs on mt.mr_sign_lvl_cd = gs.gs_cd 
 left join  org o on mt.OWN_CD = o.org_cd  
 left join org_emp oe on  mt.own_cd = oe.emp_id 
 left join md_mr_tp mdtp on mdtp.mr_tp_cd = mt.mr_tp_cd 
  left join  md_gs gs1 on mt.mr_tpl_sta_cd = gs1.gs_cd 
left join mr_tpl_di mtd on mtd.mr_tpl_cd = mt.mr_tpl_cd 
left join md_di mdi on mtd.di_cd = mdi.di_cd
where 
   mt.del_f = 0 and     mt.MR_TPL_STA_CD  ='MRM07.05' 
 and   mt.ORG_CD = /*orgCode*/'SZLH' 
 /*%if name != null*/
  and   (mt.NM like /* @contain(name) */'%g%' or upper(mt.SPELL_NO)  like /* @contain(name) */'%g%' or lower(mt.SPELL_NO)  like /* @contain(name) */'%g%')
/*%end */ 
/*%if ownerTypeCode != null   && ownerCode  != null */
  and   mt.own_tp_cd = /*ownerTypeCode*/'MDM08.01' 
/*%end */   
/*%if ownerCode != null   && ownerCode.size() > 0 */  
    and   mt.mr_tpl_cd  in (select mr_tpl_cd from mr_tpl_dept where apl_to_cd in  /*ownerCode*/('MRM06.03','MRM06.03') )
/*%end */   
/*%if typeCode != null  && typeCode.size() > 0 */
  and   mt.mr_tp_cd in /*typeCode*/('MRM06.03' )
/*%end */  
  /*%if enTypeCode != null*/
  and   mt.en_tp_cd = /*enTypeCode*/'MRM06.03' 
/*%end */  
order by to_number(nvl(  mt.sort_no,0)) asc,  mt.own_tp_cd ,   mt.crt_time  desc ,   mt.NM  