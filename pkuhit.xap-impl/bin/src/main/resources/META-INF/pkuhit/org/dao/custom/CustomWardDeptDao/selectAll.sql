select
o.* 
from
  WARD_DEPT  wd,org o 
where
o.del_f = 0
and wd.org_cd = o.org_cd
/*%if deptCode != null */
  and  wd.DEPT_CD = /*deptCode*/'4309'
/*%end */
/*%if deptTypeCode != null */
  and  wd.DEPT_TP_CD = /*deptTypeCode*/'ENM01.04'
/*%end */

