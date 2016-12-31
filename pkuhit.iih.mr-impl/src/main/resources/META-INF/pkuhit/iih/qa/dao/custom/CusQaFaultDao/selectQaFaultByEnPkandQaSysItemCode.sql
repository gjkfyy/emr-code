select flt.*
  from qa_flt flt
  left join qa_flt_itm itm
    on flt.qa_flt_pk = itm.qa_flt_pk
  left join qa t
    on itm.qa_pk = t.qa_pk
 where flt.en_pk like
      /*enPk*/'' --就诊序号
   and flt.qa_sys_itm_cd like
      /*qaSysItmCd*/'' --质控体系项目编码
   and flt.flt_cfm_rst_cd like 'QAM07.03' --需扣分
   and t.qa_ty_cd like 'QAM03.02'--质控类型（终末，环节），目前写死终末质控的类型
--   and qt.flt_sta_cd like 'QAM01.04' --已审核（实时算分时状态可能还没有变成已审核）
--qa中有个筛选条件，终末质控才扣分
