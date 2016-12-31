select 
	distinct flt.QA_FLT_PK 
	from QA_FLT flt
	left join QA_FLT_ITM fi on fi.QA_FLT_PK=flt.QA_FLT_PK
	left join QA qa on qa.QA_PK = fi.QA_PK
	where 1=1
	/*%if qaPk != null && qaPk != "" */
	and qa.QA_PK=/*qaPk*/'a'
  	/*%end */
	and flt.REVISION_CD is null
	and flt.FLT_STA_CD<>'QAM01.02'
	and fi.ACTIVE_F=1
	and flt.DEL_F=0