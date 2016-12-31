select m.amr_no,m.pa_nm,m.cur_mng_dct_id,m.cur_dept_cd,c.req,c.mr_types,q.encounter_sn,mr.lgc_smt_time complete_time, t.nm,q.memo 
from qa_auto_flt q 
left join mr_amr m on m.en_pk = q.encounter_sn
left join qa_auto_itm_config c on q.qa_itm_cd = c.qa_itm_cd
left join md_mr_tp t on t.mr_tp_cd = c.mr_types
left join mr mr on (mr.en_pk = m.en_pk and mr.mr_tp_cd = c.mr_types)
where 1=1
/*%if currentManageDoctorId != null && currentManageDoctorId != "" */
and m.cur_mng_dct_id = /*currentManageDoctorId*/'004910'
/*%end */
/*%if deptCd != null && deptCd != "" */
and m.cur_dept_cd = /*deptCd*/'4309'
/*%end */
/*%if amrNo != null && amrNo != "" */
and m.AMR_NO like /* @contain(amrNo) */'%g%'
/*%end*/
/*%if patientName != null && patientName != "" */
and m.PA_NM like /* @contain(patientName) */'%g%'
/*%end*/
/*%if mrTypes != null && mrTypes != "" */
and c.mr_types=/*mrTypes*/'a'
/*%end */
/*%if enStaCd != null && enStaCd != "" */
and m.EN_STA_CD=/*enStaCd*/'a'
/*%end */
and m.en_tp_cd='ENM01.04'--就诊类型为住院
and q.flt_flag = '1'
and m.cur_mng_dct_id is not null
and m.amr_sta_cd != 'MRM22.07'
and q.del_f='0'
order by m.pa_nm