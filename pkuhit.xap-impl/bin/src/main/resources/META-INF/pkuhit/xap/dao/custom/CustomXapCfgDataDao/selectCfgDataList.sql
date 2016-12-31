SELECT
CRT_USER_ID,
CRT_DEPT_CD,
LAST_UPD_TIME,
LAST_UPD_DEPT_CD,
LAST_UPD_USER_ID,
DEL_F,
CFG_DATA_CD,
ORG_CD,
CFG_CD,
VAL,
MAX_VAL,
MIN_VAL,
MEMO,
SORT_NO,
SPELL_NO,
WUBI_NO,
UPD_CNT,
CRT_TIME
from XAP_CFG_DATA

where
DEL_F = 0
/*%if orgCd != null*/
 and ORG_CD = /* orgCd*/'a'
/*%end */
/*%if  cfgCd != null*/
 and CFG_CD = /*cfgCd*/'b'
/*%end*/