select 
	count(*)
from Qa_Flt 
where Del_f=0  
and (flt_sta_cd='QAM12.01' or flt_sta_cd='QAM12.02')
/*%if qaTyCd != null && qaTyCd != "" */
and qa_ty_cd=/*qaTyCd*/'QAM13.01'  
/*%end */
/*%if enPk != null && enPk != "" */
and en_pk=/*enPk*/'263385' 
/*%end */