select 
OB_RP_PK	obRpPk,
EN_PK	enPk,
PA_ID	paId,
EN_CNT	enCnt,
PA_NM	paNm,
OB_RP_STA_CD	obRpStaCd,
OB_RP_STA_NM	obRpStaNm,
OB_RP_NO	obRpNo,
OB_RP_NM	obRpNm,
OB_IMPR	obImpr,
OB_FNDG	obFndg,
OB_VAL	obVal,
NRML_F	nrmlF,
OB_ITM_CD	obItmCd,
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
RQS_DCT_ID	rqsDctId,
RQS_DCT_NM	rqsDctNm,
OB_DI	obDi,
ADV	adv
from VW_OB_RP 
where 
1=1 
/*%if enPk != null */
 and EN_PK = /*enPk*/870719  
/*%end */
 /*%if patientId != null */
 and PA_ID = /*patientId*/870719  
/*%end */
 /*%if times != null */
 and EN_CNT = /*times*/870719  
/*%end */
order by RQS_TIME desc,RLS_TIME desc,EXEC_TIME desc
