select 
	t.MR_TPL_CD,
	t.XML_FILE_PK,
	b.FILE_DATA,
	t.NM
  from MR_TPL t
  left join XAP_BASEFILE b on t.XML_FILE_PK=b.FILE_PK
  where t.XML_FILE_PK is not null
    /*%if xmlFilePk != null && xmlFilePk != "" */
    and t.XML_FILE_PK = /* xmlFilePk */'a'
    /*%end */
    /*%if xmlFilePk == null || xmlFilePk == "" */
    and t.DEL_F = 0
    /*%end */