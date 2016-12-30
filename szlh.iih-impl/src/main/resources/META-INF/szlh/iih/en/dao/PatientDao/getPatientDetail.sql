select 
PA_ID		paId	,
NM		nm	,
BIRTHDAY		birthday	,
ENCOUNTER_CARD_NO  encounterCardNo,
SEX_CD		sexCd	,
SEX_NM		sexNm	,
MARI_CD		mariCd	,
MARI_NM		mariNm	,
DEATH_F		deathF	,
DEATH_DATE		deathDate	,
AUTOPSY_F		autopsyF	,
TEL_NO		telNo	,
MOBILE_NO		mobileNo	,
EMAIL		email	,
WORK_ORG_CD		workOrgCd	,
WORK_ORG_NM		workOrgNm	,
NATION_CD		nationCd	,
NATION_NM		nationNm	,
HOME_ADDRESS      homeAddress,
OCCU_CD		occuCd	,
OCCU_NM		occuNm	,
DIST_CD		distCd	,
DIST_NM		distNm	
from VW_MD_PA
where 
PA_ID = /* paId */'0000236569'
