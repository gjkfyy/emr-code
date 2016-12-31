select  distinct * from (
select distinct 
  ma.pa_id,
  ma.pa_nm
from mr_amr ma, mr m,md_gs mg
where ma.en_pk = m.en_pk
   and m.en_pk = ma.en_pk
   and ma.sex_cd=mg.gs_cd
   and mg.del_f='0'
   and m.del_f = '0'
   and ma.del_f = '0'
   and (ma.amr_sta_cd='MRM22.01' or ma.amr_sta_cd='MRM22.02')
   and m.mr_tp_cd not in ('MRM16.19', 'MRM16.20')
   and ( 
       (m.mast_doctor_cd = /*userId*/'004729' and (m.mr_sta_cd = 'MRM04.04' or m.mr_sta_cd = 'MRM04.05' or m.mr_sta_cd = 'MRM04.06')) or
       (m.dir_doctor_cd = /*userId*/'004729' and m.mr_sta_cd = 'MRM04.06')
   )
   and ma.en_tp_cd='ENM01.04'
   and m.dept_cd = /*deptCd*/'4309'
   
 union all 
 
  select distinct 
    ma.pa_id,
    ma.pa_nm
from mr_amr ma, mr m,md_gs mg
where ma.en_pk = m.en_pk
   and m.en_pk = ma.en_pk
   and ma.sex_cd=mg.gs_cd
   and mg.del_f='0'
   and m.del_f = '0'
   and ma.del_f = '0'
   and (ma.amr_sta_cd='MRM22.01' or ma.amr_sta_cd='MRM22.02')
   and m.mr_tp_cd in ('MRM16.19', 'MRM16.20')
   and (((select org.sign_lvl_cd from ORG_EMP_DEPT org where org.emp_id = /*userId*/'004729' and org.ward_dept_cd = /*deptCd*/'4309')='MRM02.03' and m.mr_sta_cd = 'MRM04.04') or
        ((select org.sign_lvl_cd from ORG_EMP_DEPT org where org.emp_id = /*userId*/'004729' and org.ward_dept_cd = /*deptCd*/'4309')='MRM02.04' and m.mr_sta_cd = 'MRM04.06')
   )
   and m.sup_dct_id = /*userId*/'004729' 
   and ma.en_tp_cd='ENM01.04'
   and m.dept_cd = /*deptCd*/'4309')