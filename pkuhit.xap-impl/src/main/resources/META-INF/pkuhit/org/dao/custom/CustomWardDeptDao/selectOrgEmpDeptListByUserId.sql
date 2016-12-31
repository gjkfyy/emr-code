select distinct oed.WARD_DEPT_CD,oed.emp_dept_cd, o.nm,oed.sort_no
from org_emp_dept oed,ward_dept wd,org o 
 where 
 o.del_f = 0
/*%if userId != null && userId != ""*/
  and oed.emp_id = /* userId */'004910'
/*%end */
  /*%if deployMode=="1"*/
  and (wd.dept_tp_cd = 'ORGM02.01' or wd.dept_tp_cd = 'ORGM02.03')
	/*%end */
  /*%if deployMode=="2"*/
  and (wd.dept_tp_cd = 'ORGM02.05' or wd.dept_tp_cd = 'ORGM02.03')
	/*%end */
  /*%if deployMode=="3"*/
  and (wd.dept_tp_cd = 'ORGM02.01' or wd.dept_tp_cd = 'ORGM02.03' or wd.dept_tp_cd = 'ORGM02.05')
	/*%end */
 and oed.ward_dept_cd = wd.dept_cd and wd.org_cd = o.org_cd
 order by oed.sort_no,o.nm