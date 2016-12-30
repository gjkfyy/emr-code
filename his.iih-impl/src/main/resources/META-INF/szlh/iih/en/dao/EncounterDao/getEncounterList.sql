select 
EN_PK enPk ,
EN_NO enNo ,
SEX_CD sexCd,
SEX_NM sexNm,
AGE age,
AMR_NO amrNo,
SU_F suF,
PA_ID paId ,
PA_NM paNm ,
PA_INSUR_CD paInsurCd ,
PA_INSUR_NM paInsurNm ,
EN_CNT enCnt ,
EN_TP_CD enTpCd ,
EN_TP_NM enTpNm ,
EN_STA_CD enStaCd ,
EN_STA_NM enStaNm ,
NU_LVL_CD nuLvlCd ,
NU_LVL_NM nuLvlNm ,
ILL_STA_CD illStaCd ,
ILL_STA_NM illStaNm ,
REG_TIME regTime ,
RCV_TIME rcvTime ,
RCV_USER_ID rcvUserId ,
RCV_USER_NM rcvUserNm ,
RCV_DEPT_CD rcvDeptCd ,
RCV_DEPT_NM rcvDeptNm ,
CUR_MAIN_DI_CD curMainDiCd ,
CUR_MAIN_DI_NM curMainDiNm ,
CUR_DEPT_CD curDeptCd ,
CUR_DEPT_NM curDeptNm ,
CUR_DEPT_INTO_TIME curDeptIntoTime ,
CUR_WARD_CD curWardCd ,
CUR_WARD_NM curWardNm ,
CUR_WARD_INTO_TIME curWardIntoTime ,
CUR_GRP_CD curGrpCd ,
CUR_GRP_NM curGrpNm ,
CUR_BED_CD curBedCd ,
CUR_MNG_DCT_ID curMngDctId ,
CUR_MNG_DCT_NM curMngDctNm ,
CUR_MNG_NUR_ID curMngNurId ,
CUR_MNG_NUR_NM curMngNurNm ,
READM_F readmF ,
CALL_BACK_F callBackF ,
FLUP_VISIT_F flupVisitF ,
FNSH_TIME fnshTime ,
FNSH_USER_ID fnshUserId ,
FNSH_USER_NM fnshUserNm ,
FNSH_DEPT_CD fnshDeptCd ,
FNSH_DEPT_NM fnshDeptNm 	
from VW_EN t 
where 1=1  
/*%if curGrpCd != null  */
and t.CUR_GRP_CD = /* curGrpCd*/'0300' 
/*%end */
/*%if curDeptCd != null  */
and t.CUR_DEPT_CD = /* curDeptCd*/'0300' 
/*%end */
/*%if enStaCd != null */
and t.EN_STA_CD = /*enStaCd*/'compltd' 
/*%end */
/*%if curMngDctId != null */
and t.CUR_MNG_DCT_ID = /*curMngDctId*/'003022' 
/*%end */
/*%if enTpCd != null */
and t.EN_TP_CD = /*enTpCd*/'onp' 
/*%end */
/*%if paNm != null */
and t.PA_NM like '%'+/*paNm*/'陈*玲'+'%' 
/*%end */
/*%if paId != null */
and t.PA_ID = /*paId*/'0000181054' 
/*%end */
/*%if illStaCd != null */
and t.ILL_STA_CD = /*illStaCd*/'07' 
/*%end */
/*%if curMainDiCd != null */
and t.CUR_MAIN_DI_CD = /*curMainDiCd*/'compltd' 
/*%end */
/*%if inpTimeStart != null */
and t.CUR_DEPT_INTO_TIME > /*inpTimeStart*/'2012-11-30 11:00:33.000' 
/*%end */
/*%if inpTimeStop != null */
and t.CUR_DEPT_INTO_TIME < /*inpTimeStop*/'2099-11-30 11:00:33.000' 
/*%end */
/*%if curBedCd != null */
and t.CUR_BED_CD = /*curBedCd*/'24' 
/*%end */
/*%if suF != null */
and t.SU_F = /*suF*/'24' 
/*%end */

 order by CUR_DEPT_INTO_TIME desc 