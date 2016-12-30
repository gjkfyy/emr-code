select 
VITAL_SIGN_PK	vitalSignPk,
EN_PK	enPk,
PA_ID	paId,
EN_CNT	enCnt,
PA_NM	paNm,
TEMPER	temper,
WEIGHT	weight,
HEART_RATE	heartRate,
PULSE	pulse,
BREATHE	breathe,
BLD_OXYGEN	bldOxygen,
SYSTOLIC_PRESS	systolicPress,
DIASTOLIC_PRESS	diastolicPress,
ACQUISITION_DATE	acquisitionDate,
CIRCUMFERENCE circumference,
BLD_SUGAR bldSugar 
from VW_VITAL_SIGN 
where 
VITAL_SIGN_PK =	/*vitalSignPk*/147062
