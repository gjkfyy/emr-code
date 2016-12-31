select EMP_ID as EMP_ID,
       TO_CHAR(NM)||' '||TO_CHAR(JOB_TITLE_NM) as NM,
       JOB_TITLE_CD,
       JOB_TITLE_NM
from ( select oe.emp_id as EMP_ID,
       oe.nm AS NM,
       oe.job_title_cd AS JOB_TITLE_CD,
       (select gs.nm from MD_GS gs where gs.gs_cd =oe.job_title_cd ) AS JOB_TITLE_NM
  from org_emp oe, ORG_EMP_DEPT oed
 where oe.del_f = '0'
   and oed.emp_id = oe.emp_id
   and oe.job_title_cd in('MRM20.02','MRM20.03','MRM20.04') 
   and oed.ward_dept_cd = /*deptCd*/'4309')