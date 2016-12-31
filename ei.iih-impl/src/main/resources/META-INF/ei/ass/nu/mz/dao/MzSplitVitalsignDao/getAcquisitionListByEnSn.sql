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
BLD_SUGAR bldSugar,
NORMAL_STOOL normalStool,
NORMAL_PISS normalPiss,
INTAKE_SUM intakeSum,
OUTTAKE_SUM outtakeSum,
HEIGHT height,
DRUG_ALLERGIC drugAllergic
from VW_VITAL_SIGN_MZ 
where 
1=1 
 /*%if patientId != null */
 and PA_ID = /*patientId*/870719  
/*%end */
 /*%if times != null */
 and EN_CNT = /*times*/870719  
/*%end */
/*%if acquisitionStartTime != null */
 and ACQUISITION_DATE  > /*acquisitionStartTime*/'2010-02-19 21:05:10.630'
/*%end */
/*%if acquisitionStopTime != null */
and ACQUISITION_DATE  < /*acquisitionStopTime*/'2020-02-19 21:05:10.630'
/*%end */
order by ACQUISITION_DATE
/*%if isDesc != null */
   desc
/*%end */
   ,VITAL_SIGN_PK