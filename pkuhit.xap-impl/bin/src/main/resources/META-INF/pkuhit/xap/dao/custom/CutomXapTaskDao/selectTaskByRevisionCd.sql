select
  TASK_ID,
  TASK_TYPE_CD,
  DOC_SN,
  EVENT_ID,
  BEGIN_TIME,
  END_TIME,
  ENCOUNTER_SN,
  COMPLETE_TIME,
  STATUS,
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
  LAST_UPD_USER_ID,
  DEL_F
from
  XAP_TASK
where
/*%if revisionCd != null */
and DOC_SN = /* revisionCd */'a'
/*%end*/
and del_f = 0
