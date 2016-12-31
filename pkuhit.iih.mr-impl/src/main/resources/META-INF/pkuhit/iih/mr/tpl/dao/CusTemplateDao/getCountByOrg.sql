select tpl.own_tp_cd, tpl.own_cd, count(tpl.mr_tpl_cd) tpl_cnt
from MR_TPL tpl
where tpl.del_f = 0 
  /*%if keyWord != null*/
 and nm like /* @contain(keyWord) */'%入%'
 /*%end */
/*%if orgCode != null */
 and tpl.org_cd =   /*orgCode*/'SZLH'
/*%end */
 /*%if owerCodes != null && owerCodes.size() > 0*/
 and own_cd in /*owerCodes*/('SZLH')
 /*%end */
 /*%if enTypeCode != null */
 and tpl.en_tp_cd =   /*enTypeCode*/'ENM01.04'
/*%end */
  /*%if statusCode != null */
 and tpl.MR_TPL_STA_CD =   /*statusCode*/'MRM07.05'
/*%end */
 /*%if scTemplateTypeCode != null  && scTemplateTypeCode.size() > 0 */
  and mr_tp_cd in /*scTemplateTypeCode*/('MRM06.03' )
/*%end */ 
 
group by tpl.own_tp_cd, tpl.own_cd
having count(tpl.mr_tpl_cd) > 0

