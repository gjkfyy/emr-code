select
sp.SPL_FM_CD,
sp.MR_PK,
sp.EN_PK,
sp.PA_ID,
sp.NAME,
sp.CONTENT,
sp.MEMO,
sp.SORT_NO,
sp.SPELL_NO,
sp.WUBI_NO,
sp.UPD_CNT,
sp.CRT_TIME,
sp.CRT_USER_ID,
sp.CRT_DEPT_CD,
sp.LAST_UPD_TIME,
sp.LAST_UPD_DEPT_CD,
sp.LAST_UPD_USER_ID,
sp.DEL_F,
sp.FM_TYPE,
sp.FM_NAME
from 
	MR_SPL_FM sp,mr m
where sp.mr_pk=m.mr_pk and sp.del_f=0 and m.del_f=0
/*%if enPk != null && enPk != ""*/
and  sp.EN_PK=/*enPk*/'a'
/*%end */
/*%if fmType != null*/
and  sp.FM_TYPE=/*fmType*/1
/*%end */
/*%if fmName != null && fmName != ""*/
and  sp.FM_NAME=/*fmName*/'a'
/*%end */
order by sp.CONTENT asc