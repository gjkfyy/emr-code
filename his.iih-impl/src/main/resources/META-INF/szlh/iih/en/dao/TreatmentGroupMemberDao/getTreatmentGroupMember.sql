select 
EN_GRP_MEN_PK	enGrpMenPk,
EN_PK	enPk,
PA_ID patientID,
EN_CNT enCount,
USER_ID	empId,
BIZ_ROLE_CD	roleCd
from VW_EN_GRP_MEM 
where 1=1 
/*%if enPk != null */
and EN_PK = /*enPk*/'1'  
/*%end */
/*%if empId != null */
and USER_ID = /*empId*/'1' 
/*%end */
