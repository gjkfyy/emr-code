select xml_file_pk filePk from(
		select xml_file_pk,mr.biz_time from mr,mr_amr where mr.en_pk=mr_amr.en_pk and mr_tp_cd in/*mrTpCds*/('MRM16.13') 
		and mr_amr.en_cnt=/*enCnt */'1' and mr_amr.pa_id=/*paId */'0000488913' and trim(mr.xml_file_pk) is not null 
		and mr.del_f='0' order by mr.biz_time desc) where rownum<=1  