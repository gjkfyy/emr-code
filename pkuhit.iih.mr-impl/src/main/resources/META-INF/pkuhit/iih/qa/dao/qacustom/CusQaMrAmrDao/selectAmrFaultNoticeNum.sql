select 
count(flt.qa_flt_pk) as allFaultNum,--缺陷数
count(case when flt.FLT_STA_CD='QAM12.01' then 1 else null end) as toReform, --新建，待整改
count(case when flt.FLT_STA_CD='QAM12.02' then 1 else null end) as reformed,  --已整改，待审核
count(case when flt.flt_sta_cd in ('QAM12.03','QAM12.04') then 1 else null end ) otherState
from QA_FLT flt
  where 1=1
  /*%if enPk != null && enPk != "" */
  and flt.EN_PK = /*enPk*/'722189'
  /*%end */
  /*%if qaTypeCode != null && qaTypeCode != "" */
  and flt.QA_TY_CD = /*qaTypeCode*/'a'
  /*%end */
  and flt.DEL_F=0
