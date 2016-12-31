select distinct
  m.en_pk,
  m.mr_pk,
  ma.cur_bed_cd,
  ma.pa_id,
  ma.pa_nm,
  (select mg.nm from md_gs mg where mg.gs_cd =ma.sex_cd ) sexName,
  m.nm,
  (select md.nm from md_mr_sta md where md.mr_sta_cd =m.mr_sta_cd ) MR_STA_NM,
  m.mr_sta_cd,
  (select o.nm from ORG_EMP o where o.emp_id = m.submit_cd) submit_cd,
  m.submit_date  SUBMIT_DATE,
  m.sign_lvl_cd,
  (select mg.nm from md_gs mg where mg.gs_cd = m.sign_lvl_cd ) signLvlNm
  from mr m 
  left join mr_amr ma on ma.en_pk = m.en_pk
  where 
  m.del_f = '0'
  and ma.del_f = '0'
  and ma.en_tp_cd='ENM01.04'
  and m.dept_cd = /*deptCd*/'4502'
  and ma.amr_sta_cd = 'MRM22.01'
  --and m.mr_tp_cd not in ('MRM16.19', 'MRM16.20')
  and (
      (
        m.sign_lvl_cd ='MRM02.03'
        and (select org.sign_lvl_cd from ORG_EMP_DEPT org where org.emp_id = /*userId*/'004917' and org.ward_dept_cd = /*deptCd*/'4502') in ('MRM02.03','MRM02.04')
        and m.mr_sta_cd in ('MRM04.02','MRM04.03')   
      )or 
      (
        m.sign_lvl_cd = 'MRM02.04'
        and (select org.sign_lvl_cd from ORG_EMP_DEPT org where org.emp_id = /*userId*/'004917' and org.ward_dept_cd = /*deptCd*/'4502') in ('MRM02.03','MRM02.04')
        and m.mr_sta_cd in ('MRM04.02','MRM04.03','MRM04.04','MRM04.05')
      )
  ) 
  and m.submit_cd != /*userId*/'004917'
  /*%if patientId != "ALL" && patientId != null*/
  and ma.pa_id = /*patientId*/'0000492774'
  /*%end */
  order by m.submit_date desc