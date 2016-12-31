select oe.* 
	from org_emp_dept oed left join org_emp oe on oed.emp_id=oe.emp_id 
	where oe.del_f= 0
	/*%if keyword != null && keyword != ""*/
	and (oe.NM like /* @contain(keyword) */'%g%' or lower(oe.nm_spell) like lower(/* @contain(keyword) */'%g%'))
	/*%end */
	/*%if deptCd != null && deptCd != ""*/
	and ward_dept_cd = /* deptCd */'4309'
	/*%end */
	/*%if id != null && id != ""*/
	and oe.emp_id = /* id */'004910'
	/*%end */
