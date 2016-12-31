select
 e.emp_id code
 , e.nm name
from 
org_emp_dept ed left join org_emp e
on ed.emp_id = e.emp_id 
where ed.del_f = 0
/*%if deptCode != null */
and  ed.ward_dept_cd = /* deptCode */'0412'
/*%end*/
