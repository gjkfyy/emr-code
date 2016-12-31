select w.dept_cd,m.cur_mng_dct_id,w.nm,count(m.cur_mng_dct_id) as defectCount
from qa_auto_flt q 
left join mr_amr m on m.en_pk = q.encounter_sn 
left join ward_dept w on w.dept_cd = m.cur_dept_cd
where 1=1
/*%if currentManageDoctorName != null && currentManageDoctorName != "" */
and m.cur_mng_dct_id = /*currentManageDoctorName*/'004910'
/*%end */
/*%if curDeptNm != null && curDeptNm != "" */
and w.dept_cd = /*curDeptNm*/'004910'
/*%end */
/*%if curDeptNm != null && curDeptNm != "" */
and w.dept_cd = /*curDeptNm*/'004910'
/*%end */
/*%if enStaCd != null && enStaCd != "" */
and m.EN_STA_CD=/*enStaCd*/'a'
/*%end */
and m.amr_sta_cd != 'MRM22.07'
and q.flt_flag = '1'
and q.del_f='0'
and m.cur_mng_dct_id is not null
group by w.dept_cd,m.cur_mng_dct_id,w.nm