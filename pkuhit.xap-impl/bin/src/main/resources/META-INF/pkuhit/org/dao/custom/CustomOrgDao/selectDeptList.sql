select a.* from WARD_DEPT a 
where
  a.del_f = 0
/*%if keyword != null && keyword != ""*/
  and (a.nm like /* @contain(keyword) */'%g%'
    or a.SPELL_NO like /* @contain(keyword) */'%g%')
/*%end */
/*%if id != null && id != ""*/
  and a.dept_cd = /* id */'4309'
/*%end */
/*%if deptTpCd != null && deptTpCd != ""*/
  and a.DEPT_TP_CD = /* deptTpCd */'ORGM02.01'
/*%end */
order by 
  a.nm