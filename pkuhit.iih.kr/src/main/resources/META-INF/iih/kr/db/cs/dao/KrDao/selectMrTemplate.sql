select 
MR_TPL_CD ,NM
from mr_tpl
where 
del_f = 0
/*%if mrCodes != null && mrCodes.size()>0 */
  and MR_TPL_CD in /*mrCodes*/('MRM07.06') 
/*%end */