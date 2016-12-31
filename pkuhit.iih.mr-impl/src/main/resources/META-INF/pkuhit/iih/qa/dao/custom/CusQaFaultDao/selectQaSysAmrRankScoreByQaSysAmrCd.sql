select 
  QA_SYS_AMR_RANK_SCR_CD,
  QA_SYS_AMR_CD,
  AMR_RANK_CD,
  MAX_SCR,
  MIN_SCR
  from QA_SYS_AMR_RANK_SCR tt
 where tt.qa_sys_amr_cd like 
 	/*qaSysAmrCd*/'QAK02.01'
 order by tt.amr_rank_cd asc