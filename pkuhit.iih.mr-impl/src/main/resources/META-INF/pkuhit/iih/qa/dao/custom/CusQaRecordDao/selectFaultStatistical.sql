select
  count(flt.QA_FLT_PK) as faultTotal,
  count(case when flt.FLT_CFM_RST_CD in ('QAM07.03', 'QAM07.04') then 1 else null end ) as faultTodoReform,--已审核
  count(case when flt.FLT_CFM_RST_CD='QAM07.02' and flt.FLT_STA_CD in ('QAM01.02','QAM01.03','QAM01.04') then 1 else null end ) as faultReviewed,--再整改   需要修改一下
  count(case when flt.FLT_STA_CD='QAM01.01' then 1 else null end ) as faultReformed,--新提出
  count(case when flt.FLT_CFM_RST_CD='QAM07.02' then 1 else null end ) as faultSubmited,--需整改
  count(case when flt.FLT_STA_CD='QAM01.03' then 1 else null end) as faultTodoReview --待审核
from
  QA qa
left join QA_FLT_ITM fi on fi.QA_PK = qa.QA_PK
left join QA_FLT flt on fi.QA_FLT_PK = flt.QA_FLT_PK 
where 1=1
  /*%if qaPk != null && qaPk != "" */
  and qa.QA_PK = /*qaPk*/'a'
  /*%end */
  /*%if userId != null && userId != "" */
 and flt.SBMT_USER_ID = /*userId*/'a'
  /*%end */
  /*%if deptCd != null && deptCd != "" */
 and flt.SBMT_DEPT_CD = /*deptCd*/'a'
  /*%end */
 and fi.ACTIVE_F = 1
 and flt.DEL_F = 0