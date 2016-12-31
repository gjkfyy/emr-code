select 
  tpl.MR_TPL_CD,
  tpl.ORG_CD,
  tpl.MR_BASE_TPL_CD,
  tpl.FILE_PK,
  tpl.MR_TPL_STA_CD,
  tpl.NM,
  tpl.DES,
  tpl.OWN_TP_CD,
  tpl.OWN_CD,
  tpl.MR_TP_CD,
  tpl.MR_SIGN_LVL_CD,
  tpl.MEMO,
  tpl.SORT_NO,
  tpl.SPELL_NO,
  tpl.WUBI_NO,
  tpl.UPD_CNT,
  tpl.CRT_TIME,
  tpl.CRT_USER_ID,
  tpl.CRT_DEPT_CD,
  tpl.LAST_UPD_TIME,
  tpl.LAST_UPD_DEPT_CD,
  tpl.LAST_UPD_USER_ID,
  tpl.EN_TP_CD,
  tpl.DEL_F
from
(select cat.mr_tp_ccat_cd
from MD_MR_TP_CCAT cat
where cat.del_f = 0
/*%if dctNsF != null */
 and cat.dct_ns_f = /*dctNsF*/'a'
/*%end */
and cat.mr_tp_ccat_cd = /*mrCategoryCode*/'MRM14.13'
) all_cat
left join 
(
select * from 
MD_MR_TP_CCAT_ITM 
where 1=1 
      /*%if enTypeCode != null */
 and en_tp_cd =   /*enTypeCode*/'ENM01.01'
/*%end */
) itm on itm.mr_tp_ccat_cd = all_cat.mr_tp_ccat_cd
left join 
(
select mr_tp_cd,sort_no,nm
from MD_MR_TP 
where del_f =0
)tp on tp.mr_tp_cd = itm.mr_tp_cd
left join MR_TPL tpl on tpl.mr_tp_cd = tp.mr_tp_cd where 
    tpl.del_f = 0 
               /*%if ownerCode != null */
     and tpl.own_cd = /*ownerCode*/'10001'
     /*%end */
     		/*%if orgCode != null */
		 and tpl.org_cd =   /*orgCode*/'SZLH'
		/*%end */
		  /*%if enTypeCode != null */
 and tpl.en_tp_cd =   /*enTypeCode*/'ENM01.04'
/*%end */
  /*%if scTemplateTypeCode != null  */
	and tpl.mr_tp_cd = /*scTemplateTypeCode*/'aaa'
 /*%end */
	  /*%if statusCode != null */
 and tpl.MR_TPL_STA_CD =   /*statusCode*/'MRM07.05'
/*%end */
  /*%if keyWord != null*/
 	and tpl.nm like /* @contain(keyWord) */'%入%'
 /*%end */		 
order by  to_number(nvl(  tpl.sort_no,0)) asc,  tpl.own_tp_cd ,   tpl.crt_time  desc ,   tpl.NM 