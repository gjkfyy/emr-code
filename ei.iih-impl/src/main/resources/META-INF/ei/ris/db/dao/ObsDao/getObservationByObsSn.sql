select 
OB_RP_PK	obRpPk,
PA_ID	paId,
EN_CNT	enCnt,
PA_NM	paNm,
OB_RP_STA_CD	obRpStaCd,
OB_RP_STA_NM	obRpStaNm,
OB_RP_NO	obRpNo,
OB_RP_NM	obRpNm,
OB_IMPR	obImpr,
''	obFndg,
''	obVal,
''	nrmlF,
''	obItmCd,
OB_ITM_NM	obItmNm,
EXEC_TIME	execTime,
EXEC_DCT_ID	execDctId,
EXEC_DCT_NM	execDctNm,
EXEC_DEPT_CD	execDeptCd,
EXEC_DEPT_NM	execDeptNm,
RLS_USER_ID	rlsUserId,
RLS_USER_NM	rlsUserNm,
RLS_TIME	rlsTime,
RQS_TIME	rqsTime,
''	rqsDctId,
RQS_DCT_NM	rqsDctNm,
''	obDi,
''	adv
from  VW_OB_RP 
where 
OB_RP_PK=/*obRpPk*/14138 
order by RQS_TIME desc,RLS_TIME desc,EXEC_TIME desc