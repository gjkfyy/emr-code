select  distinct * from (
select distinct 
  m.en_pk,
  m.mr_pk, 
  ma.cur_bed_cd,
  ma.pa_id,
  ma.pa_nm,
  ma.sex_cd,
  mg.nm as sexName,
  m.nm,
  m.mr_sta_cd,
    (select md.nm from md_mr_sta md where md.mr_sta_cd =m.mr_sta_cd ) MR_STA_NM,
    (select g.nm from md_gs g where g.gs_cd =m.sign_lvl_cd ) as SIGN_LVL_NM,
    (case when m.mast_doctor_cd=/*userId*/'004942' then m.mast_doctor_date 
         when m.dir_doctor_cd=/*userId*/'004942' then m.dir_doctor_date end
    ) as DOCTOR_DATE,
  m.submit_date
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
       (m.mast_doctor_cd = /*userId*/'004942' and (m.mr_sta_cd = 'MRM04.04' or m.mr_sta_cd = 'MRM04.05' or m.mr_sta_cd = 'MRM04.06')) or
       (m.dir_doctor_cd = /*userId*/'004942' and m.mr_sta_cd = 'MRM04.06')
   )
   and ma.en_tp_cd='ENM01.04'
   and m.dept_cd = /*deptCd*/'4309'
   
 union all 
 
  select distinct 
    m.en_pk,
    m.mr_pk, 
    ma.cur_bed_cd,
    ma.pa_id,
    ma.pa_nm,
    ma.sex_cd,
    mg.nm as sexName,
    m.nm,
    m.mr_sta_cd,
    (select md.nm from md_mr_sta md where md.mr_sta_cd =m.mr_sta_cd ) MR_STA_NM,
    (select g.nm from md_gs g where g.gs_cd =m.sign_lvl_cd ) as SIGN_LVL_NM,
    (case when m.mast_doctor_cd=/*userId*/'004942' then m.mast_doctor_date 
         when m.dir_doctor_cd=/*userId*/'004942' then m.dir_doctor_date end
    ) as DOCTOR_DATE,
  m.submit_date
from mr_amr ma, mr m,md_gs mg
where ma.en_pk = m.en_pk
   and m.en_pk = ma.en_pk
   and ma.sex_cd=mg.gs_cd
   and mg.del_f='0'
   and m.del_f = '0'
   and ma.del_f = '0'
	 and m.mr_sta_cd = 'MRM04.04'
   and (ma.amr_sta_cd='MRM22.01' or ma.amr_sta_cd='MRM22.02')
   and m.mr_tp_cd in ('MRM16.19', 'MRM16.20')
   and m.mast_doctor_cd=/*userId*/'004942'
-- and m.sup_dct_id = /*userId*/'004942' 
   and ma.en_tp_cd='ENM01.04'
   and m.dept_cd = /*deptCd*/'4309') w
   where 1=1
   /*%if patientId != "ALL" */
   and w.pa_id = /*patientId*/'0000492774'
   /*%end */
   order by w.DOCTOR_DATE desc