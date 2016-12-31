SELECT
PARAM_CD,
NM,
CODE,
KEY,
VALUE,
MEMO,
SORT_NO,
SPELL_NO,
WUBI_NO,
UPD_CNT,
CRT_TIME,
CRT_USER_ID,
CRT_DEPT_CD,
LAST_UPD_TIME,
LAST_UPD_DEPT_CD,
LAST_UPD_USER_ID 
from XAP_PARAM
where 
DEL_F = 0

/*%if code != null && code != ""*/
  and CODE = /* code */'a'
/*%end*/
  /*%if conditionNmList != null   && conditionNmList.size() > 0 */  
  and (
  /*%for name : conditionNmList */
		lower(nm) like /* @contain(name) */'hoge'  or lower(memo) like /* @contain(name) */'hoge' 
	  /*%if name_has_next */
	/*# "or" */
	  /*%end */
/*%end*/
		)
	/*%end*/