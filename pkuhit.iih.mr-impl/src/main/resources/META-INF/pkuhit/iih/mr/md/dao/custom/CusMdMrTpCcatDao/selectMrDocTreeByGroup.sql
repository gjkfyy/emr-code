select 
	mr_tp_ccat_cd,
	TO_CHAR(nm)||'('||TO_CHAR(doc_count)||')' as nm 
from (
	select 
		mr_tp_ccat_cd, 
		nm,
		doc_count,
		sort_no 
	from(
		select DISTINCT 
			t.mr_tp_ccat_cd,
			t.nm,
			(select count(*) from mr where mr.en_pk in /*enPks*/('a')   and mr.del_f='0' and mr.mr_tp_cd  in(select a.mr_tp_cd from MD_MR_TP_CCAT_ITM a where a.mr_tp_ccat_cd=t.mr_tp_ccat_cd)) doc_count,
			t.sort_no
		from md_mr_tp_ccat t 
		left join md_mr_tp_ccat_itm m on t.mr_tp_ccat_cd = m.mr_tp_ccat_cd
		where m.en_tp_cd in /*enTpCdList*/('ENM01.04') order by   CAST(sort_no AS INTEGER) 
  ) ta 
  where ta.doc_count>0
)