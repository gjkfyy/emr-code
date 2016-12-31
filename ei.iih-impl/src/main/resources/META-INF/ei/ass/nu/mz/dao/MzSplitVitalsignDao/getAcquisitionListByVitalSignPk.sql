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
BLD_SUGAR bldSugar ,
NORMAL_STOOL normalStool,
NORMAL_PISS normalPiss,
INTAKE_SUM intakeSum,
OUTTAKE_SUM outtakeSum,
HEIGHT height,
DRUG_ALLERGIC drugAllergic
from VW_VITAL_SIGN_MZ 
where 
VITAL_SIGN_PK =	/*vitalSignPk*/147062
