select
  d.EMP_DEPT_CD,
  d.WARD_DEPT_CD,
  d.EMP_ID,
  w.NM,
  d.MEMO,
  d.SORT_NO,
  d.SPELL_NO,
  d.WUBI_NO,
  d.UPD_CNT,
  d.CRT_TIME,
  d.CRT_USER_ID,
  d.CRT_DEPT_CD,
  d.LAST_UPD_TIME,
  d.LAST_UPD_DEPT_CD,
  d.LAST_UPD_USER_ID,
  d.DEL_F
from
  ORG_EMP_DEPT d
left join WARD_DEPT w on d.WARD_DEPT_CD=w.DEPT_CD
where
  d.EMP_ID = /* userId */'004942'
and d.DEL_F = 0
