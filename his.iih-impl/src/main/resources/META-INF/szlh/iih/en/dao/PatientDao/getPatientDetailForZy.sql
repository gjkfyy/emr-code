select 
rtrim(ltrim(PA_ID))		paId	,
rtrim(ltrim(NM))		nm	,
BIRTHDAY		birthday	,
rtrim(ltrim(ENCOUNTER_CARD_NO))  encounterCardNo,
SEX_CD		sexCd	,
SEX_NM		sexNm	,
MARI_CD		mariCd	,
rtrim(ltrim(MARI_NM))		mariNm	,
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
DIST_NM		distNm	,
id_card_no	idCardNo ,
ID_CARD_ADRESS idCardAdress ,
RESERVED_COLUMN1  reservedColumn1,
RESERVED_COLUMN2  reservedColumn2,
RESERVED_COLUMN3  reservedColumn3,
RESERVED_COLUMN4  reservedColumn4,
RESERVED_COLUMN5  reservedColumn5,
RESERVED_COLUMN6  reservedColumn6,
RESERVED_COLUMN7  reservedColumn7,
RESERVED_COLUMN8  reservedColumn8
 from VW_MD_PA_ZY
where 
PA_ID = /* paId */'0000236569'