select*from(
	select spl_fm_pk 
	from mr 
	where del_f=0	
	and mr.spl_fm_pk is not null 
	
	and en_pk=/*enPk*/'864275' 
	
	order by crt_time desc ) t 
where  rownum<=1