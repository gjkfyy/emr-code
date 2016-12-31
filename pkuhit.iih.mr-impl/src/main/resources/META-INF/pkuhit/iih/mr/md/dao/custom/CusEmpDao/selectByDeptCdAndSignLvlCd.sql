select oe.emp_id, oe.nm
  from org_emp oe, ORG_EMP_DEPT oed
 where oe.emp_id = oed.emp_id
   and oe.del_f = '0'
   and oed.del_f = '0'
   and oed.sign_lvl_cd = /*signLvlCd*/'MRM02.03'
   and oed.ward_dept_cd = /*deptCd*/'4309'
