select 
	EN_PK,
	AMR_NO,
	AMR_STA_CD
	from MR_AMR amr
	where amr.AMR_STA_CD=/*statusStr*/'a'--书写已开始
