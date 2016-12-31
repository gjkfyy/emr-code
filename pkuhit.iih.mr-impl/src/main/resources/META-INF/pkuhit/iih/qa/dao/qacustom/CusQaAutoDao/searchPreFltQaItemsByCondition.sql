select 
distinct 
t.*, c.mr_types, c.qa_itm_tp_cd,c.DEAD_HOURS,c.MR_OP_TYPE,t.event_id EVENT_TYPE_CODE,c.dct_op_tp_cd
  from QA_AUTO_FLT t
  left join qa_auto_itm_config c
    on t.qa_itm_cd = c.qa_itm_cd
  left join mr_amr m
    on t.encounter_sn = m.en_pk
where 1=1
	and t.del_f = '0'
/*%if fltFlag == "0" */
	and t.flt_flag='0'


	/*%if qaItmTpCd == "QAM06.02" */
	
		and c.qa_itm_tp_cd='QAM06.02'
		/*%if currentTime != null && currentTime != "" */
		and t.end_time<= to_date(/*currentTime*/'2015-01-01 00:00:00','yyyy-mm-dd hh24:mi:ss')
		/*%end */
	
	/*%end */
	
	/*%if qaItmTpCd == "QAM06.04" */
	
		and c.qa_itm_tp_cd='QAM06.04'
		and m.amr_sta_cd != 'MRM22.07'
		and m.en_sta_cd = 'ENM02.04'
	
	/*%end */
	
	/*%if qaItmTpCd == "QAM06.02,QAM06.04" */
		and ((c.qa_itm_tp_cd='QAM06.02'
			/*%if currentTime != null && currentTime != "" */
			and t.end_time<= to_date(/*currentTime*/'2015-01-01 00:00:00','yyyy-mm-dd hh24:mi:ss')
			/*%end */)
			or
			(
			 c.qa_itm_tp_cd in('QAM06.04','QAM06.02')
			and m.amr_sta_cd != 'MRM22.07'
			and m.amr_sta_cd != 'MRM22.01'
			and m.en_sta_cd = 'ENM02.04'
		))
	/*%end */

/*%end */
	
/*%if fltFlag == "1"*/
	and t.flt_flag='1'
	and t.div_flag='0'
	and m.amr_sta_cd != 'MRM22.07'
	and m.amr_sta_cd != 'MRM22.01'
	and m.en_sta_cd = 'ENM02.04'
/*%end */	