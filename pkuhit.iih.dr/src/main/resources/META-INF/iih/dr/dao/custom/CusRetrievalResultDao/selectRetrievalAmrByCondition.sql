select 
	r.XML_FILE_PK,
	r.MR_TPL_CD,
	f.FILE_DATA,
	m.EN_PK,
	r.MR_PK
  from MR_AMR m  
	left join MR r on m.EN_PK=r.EN_PK
	left join XAP_BIZFILE f on f.FILE_PK=r.XML_FILE_PK
  where r.XML_FILE_PK is not null
    and m.DEL_F = 0 and r.DEL_F = 0 and f.DEL_F = 0
    /*%if lastUpdTime != null */
    and f.LAST_UPD_TIME > /* lastUpdTime */'yyyy-MM-dd HH:mm:ss'
    /*%end */
    -- and m.EN_STA_CD='ENM02.04'--完成（诊毕、出院出科）
    -- and m.AMR_STA_CD='MRM22.07'--已归档
    -- and m.EN_TP_CD='ENM01.04'--住院
