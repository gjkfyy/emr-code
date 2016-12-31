select all_cat.mr_tp_ccat_cd, count(tpl.mr_tpl_cd) tpl_cnt,all_cat.nm
from
(select cat.mr_tp_ccat_cd  ,cat.nm, to_number(cat.sort_no)   sort_no
from MD_MR_TP_CCAT cat
where cat.del_f = 0  
/*%if dctNsF != null */
and cat.DCT_NS_F = /*dctNsF*/'aaa'
/*%end */
/*%if scTemplateCategoryCode != null */
and mr_tp_ccat_cd = /*scTemplateCategoryCode*/'aaa'
/*%end */
 order by   to_number(sort_no)
) all_cat
left join 
(
select * from 
MD_MR_TP_CCAT_ITM 
where 
1=1 
      /*%if enTypeCode != null */
 and en_tp_cd =   /*enTypeCode*/'ENM01.01'
/*%end */
)
 itm on itm.mr_tp_ccat_cd = all_cat.mr_tp_ccat_cd
left join MD_MR_TP tp on tp.mr_tp_cd = itm.mr_tp_cd
left join MR_TPL tpl on tpl.mr_tp_cd = tp.mr_tp_cd
     where tpl.del_f = 0
          /*%if ownerCode != null */
     and tpl.own_cd = /*ownerCode*/'10001'
     /*%end */
		/*%if orgCode != null */
		 and tpl.org_cd =   /*orgCode*/'SZLH'
		/*%end */
		  /*%if enTypeCode != null */
 and tpl.en_tp_cd =   /*enTypeCode*/'ENM01.04'
/*%end */
   /*%if statusCode != null */
 and tpl.MR_TPL_STA_CD =   /*statusCode*/'MRM07.05'
/*%end */
 /*%if scTemplateTypeCode != null  */
	and tpl.mr_tp_cd = /*scTemplateTypeCode*/'aaa'
 /*%end */
  /*%if keyWord != null*/
 	and tpl.nm like /* @contain(keyWord) */'%入%'
 /*%end */
group by all_cat.mr_tp_ccat_cd,all_cat.sort_no,all_cat.nm
having count(tpl.mr_tpl_cd) > 0
  order by  all_cat.sort_no
  