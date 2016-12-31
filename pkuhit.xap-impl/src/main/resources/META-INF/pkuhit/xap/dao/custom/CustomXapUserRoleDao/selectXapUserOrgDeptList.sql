select 
	*
from 
	ORG_EMP_DEPT
where
/*%if userId != null */
  EMP_ID = /* userId */'a'
/*%end*/
and DEL_F = 0
