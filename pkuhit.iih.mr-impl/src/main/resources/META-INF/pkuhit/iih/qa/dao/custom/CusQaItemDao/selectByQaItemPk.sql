select 
	count(QA_SYS_ITM_CD) 
from QA_SYS_ITM 
where 1=1
	/*%if qaItemPkList != null && qaItemPkList.size() > 0 */
	and QA_SYS_ITM_CD in /*qaItemPkList*/('a') 
	/*%end */
    and DFT_RFM_F = 1
    --and DEL_F = 0