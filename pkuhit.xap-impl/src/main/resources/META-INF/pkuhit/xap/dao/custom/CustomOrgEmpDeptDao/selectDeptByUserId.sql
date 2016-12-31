select e.DEPT_CD 
from XAP_USER u
left join ORG_EMP e on u.EMP_ID=e.EMP_ID
where e.EMP_ID=/* userId */'004942'