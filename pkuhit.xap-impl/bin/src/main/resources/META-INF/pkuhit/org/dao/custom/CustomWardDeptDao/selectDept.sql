select
o.org_cd code , o.nm name
from
  WARD_DEPT  wd,org o 
where
o.del_f = 0
and wd.org_cd = o.org_cd
/*%if deptCode != null */
  and  wd.DEPT_CD = /*deptCode*/'4309'
/*%end */
  
/*%if deptTypeCode != null &&  deptTypeCode == "ORGM02.01"*/
  and  wd.DEPT_TP_CD = /*deptTypeCode*/'ORGM02.01'
/*%end */
/*%if deptTypeCode != null &&  deptTypeCode == "ORGM02.05"*/
  and  wd.DEPT_TP_CD = /*deptTypeCode*/'ORGM02.05'
  and o.nm  not like '急诊%'   --不包括急诊
/*%end */
 /*%if deptTypeCode != null &&  deptTypeCode == "ORGM02.06"*/
  and  wd.DEPT_TP_CD = 'ORGM02.05'     --只包括急诊
   and o.nm  like '急诊%'
/*%end */
/*%if deptTypeCode != null &&  deptTypeCode == "ORGM02.07"*/
  and  wd.DEPT_TP_CD = 'ORGM02.05'
/*%end */