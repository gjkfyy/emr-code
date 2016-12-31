select 
  count(flt.qa_flt_pk) as allFaultNum,--缺陷数
  count(case when flt.FLT_STA_CD='QAM12.01' then 1 else null end) as toReform, --新建，待整改
  count(case when flt.FLT_STA_CD='QAM12.02' then 1 else null end) as reformed  --已整改，待审核
  from QA_FLT flt
  where 1=1
  /*%if revisionCd != null && revisionCd != "" */
  and flt.REVISION_CD = /*revisionCd*/'571C32E85D3146C997ACEA2D8CC77A42'
  /*%end */
  and flt.DEL_F=0
