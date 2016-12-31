select 
t.OB_RP_PK ObRpPk,
CONCAT(CONCAT(t.PA_ID,'_'),t.EN_CNT) enPk 
from RIS.VW_OB_RP t  
where t.PA_ID = 'PR20141208027'
