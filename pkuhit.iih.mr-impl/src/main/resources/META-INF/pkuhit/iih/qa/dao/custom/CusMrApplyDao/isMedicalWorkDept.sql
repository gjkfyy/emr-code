select count(*) as medicalWorkDept
	from org o 
	where o.org_cd = /* deptCd */'0001' 
	and (o.nm like '%医务%' or o.alias_nm like '医务') 
	and o.del_f=0