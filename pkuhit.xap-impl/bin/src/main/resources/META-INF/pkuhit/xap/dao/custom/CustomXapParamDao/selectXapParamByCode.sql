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
from XAP_PARAM p where DEL_F = 0
/*%if code != null  && code != ""*/
  and p.CODE = /* code */'a'
/*%end*/
