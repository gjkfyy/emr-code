select itm.*,seg.MR_SEG_TP_CD
  from QA_SYS_ITM itm
  left join QA_SYS_AMR amr
    on itm.qa_sys_amr_cd = amr.qa_sys_amr_cd
  left join qa_sys_mr mr 
    on itm.qa_sys_mr_cd = mr.qa_sys_mr_cd
  left join qa_sys_seg seg
    on itm.qa_sys_seg_cd = seg.qa_sys_seg_cd
 where amr.en_tp_cd like /*enTpCd*/'ENM01.04'
   and mr.mr_tp_cd in /*mrTpCds*/('MRM16.02')
   /*%if mrSegmentTemplateCode != null && mrSegmentTemplateCode != ""*/
   and seg.mr_seg_tp_cd like /*mrSegmentTemplateCode*/'MRM01.01'
   and seg.del_f = 0
   /*%end*/
   and itm.del_f = 0 
   and amr.del_f = 0 
   and mr.del_f = 0 