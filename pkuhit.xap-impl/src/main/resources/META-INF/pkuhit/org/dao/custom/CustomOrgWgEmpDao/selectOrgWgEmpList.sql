select a.* from ORG_WG_EMP a
  left join ORG_WG b on a.wg_cd=b.wg_cd
where
/*%if wgCd != null && wgCd != "" */
  a.wg_cd = /* wgCd */'ORGB03.01'
/*%end*/
/*%if empId != null && empId != "" */
  and a.emp_id = /* empId */'10001'
/*%end*/