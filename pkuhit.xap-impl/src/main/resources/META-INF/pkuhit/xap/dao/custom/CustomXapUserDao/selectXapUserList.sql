select
  a.*
from
  XAP_USER a
where
  a.del_f = 0
  /*%if dctNsF != null*/
  and a.dct_ns_f = /* dctNsF */'a'
/*%end*/
/*%if orgCd != null && dctNsF == "0"*/
  and a.org_cd = /* orgCd */'a'
/*%end*/
/*%if orgCd != null*/
  --and exists 
   -- (select b.org_cd from xap_user_role b where b.user_id = a.user_id and b.org_cd=/* orgCd */'4309')
/*%end*/
/*%if userId != null*/
  and a.user_id = /* userId */'a'
/*%end*/
/*%if name != null*/
  and a.nm like /* @contain(name) */'%g%'
/*%end*/
/*%if statusCd != null*/
  and a.user_sta_cd = /* statusCd */'a'
/*%end*/
/*%if curDeptNm != null*/
  and a.org_cd = /* curDeptNm */'a'
/*%end*/
/*%if empId != null */
  and a.emp_id = /* empId */'a'
/*%end*/  
  
order by 
  a.NM