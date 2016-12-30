select top 2000 ORG_EMP_ID,EMP_ID empId,
DEPT_CD deptCd,
EMP_NO empNo,
NM nm,
NM_SPELL  nmSpell,
SEX_CD sexCd,
convert(varchar(100), BIRTHDAY ,20)  birthday,
ID_CARD_NO idCardNo,
EMAIL  email,
JOB_TITLE_CD  jobTitleCd,
POSITION_CD positionCd,
PROF_CD  profCd,
TEL_NO  telNo,
MOBILE_NO mobileNo,
IEMR_JOB_TITLE_CD iemrJobTitleCd,
0  delF,
FLAG  flag
from  iemr_org_emp 
order by SORT_DATE