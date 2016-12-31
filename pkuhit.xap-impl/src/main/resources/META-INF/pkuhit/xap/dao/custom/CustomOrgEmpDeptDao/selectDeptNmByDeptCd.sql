select distinct(w.NM) 
from ORG_EMP_DEPT d
left join WARD_DEPT w on w.DEPT_CD = d.WARD_DEPT_CD
where d.WARD_DEPT_CD=/* wardDeptCd */'4309'
