select m.*
from
mr m 
where m.en_pk = /*enPk*/'870013'
and m.del_f = 0
/*%if mrTypes != null && mrTypes.size() > 0 */
and m.mr_tp_cd in /*mrTypes*/('MDM12.01')
/*%end */
/*%if mrStaCd != null && mrStaCd != "" */
and m.mr_sta_cd != /*mrStaCd*/'MRM04.01'
/*%end */
