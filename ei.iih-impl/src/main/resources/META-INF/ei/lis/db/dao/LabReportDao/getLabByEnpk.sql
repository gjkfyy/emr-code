select 
LAB_RP_PK	labRpPk,
EN_PK	enPk,
PA_ID	paId,
EN_CNT	enCnt,
PA_NM	paNm,
LAB_RP_NO	labRpNo,
LAB_RP_NM	labRpNm,
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
MEMO	memo
from VW_LAB_RP 
where 
EN_PK = /*enPk*/241154 
order by RQS_TIME desc,RLS_TIME desc,EXEC_TIME desc