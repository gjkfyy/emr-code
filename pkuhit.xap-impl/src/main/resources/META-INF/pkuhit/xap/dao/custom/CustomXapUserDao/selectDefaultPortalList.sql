select distinct xp.PORTAL_CD,
  xp.ORG_CD,
  xp.NM,
  xp.DES,
  xp.SHT_NM_EN,
  xp.NM_EN,xp.sort_no 
  from xap_portal xp,
       xap_role_portal rp,
       (select r.role_cd
          from xap_user_role r
         where r.user_id = /* userId */'a'
           and r.del_f=0) tmp
 where xp.portal_cd = rp.portal_cd
   and rp.role_cd = tmp.role_cd
   and xp.del_f=0
   and rp.del_f=0
  order by xp.sort_no
             