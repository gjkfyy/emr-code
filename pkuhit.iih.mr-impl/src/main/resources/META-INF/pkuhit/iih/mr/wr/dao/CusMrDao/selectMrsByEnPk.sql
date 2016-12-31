select
	MR_PK,
	NM,
	MR_TP_CD,--文书类型
	CRT_USER_ID,
	CRT_TIME,
	LAST_UPD_TIME,
   	FILE_PK,--文件编号
  	EN_PK,--患者编号
  	ARC_F
 -- amr.en_cnt  --就诊次数    
from MR 
where  DEL_F='0' and (arc_f='0' or arc_f is null)
 	/*%if enPk != null && enPk != "" */
	 and EN_PK = /*enPk*/'a'  --主键
	   /*%end */
	 and MR_TP_CD in /*mrTypeCodes*/('a') 