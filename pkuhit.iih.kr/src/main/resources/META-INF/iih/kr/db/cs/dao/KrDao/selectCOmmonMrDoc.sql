select tpl.*
from MR_TPL tpl
left join 
(select * from DI_SUITE_TEMPLATE where del_f = 0) td
on tpl.mr_tpl_cd = td.mr_template_cd
where 
tpl.del_f  = 0 AND tpl.MR_TPL_STA_CD = 'MRM07.05'
 /*%if ownerType != null  */
 and  tpl.en_tp_cd = /*enTypeCode*/'00'
 /*%end */ 
and td.MR_TEMPLATE_CD is null
and tpl.mr_tp_cd in('MRM16.47','MRM16.48')
 /*%if ownerType != null  */
 and tpl.OWN_TP_CD = /*ownerType*/'MA.M.026.D.1'
/*%end */
/*%if ownerCode != null  */
   and tpl.OWN_CD = /*ownerCode*/'00'
/*%end */
