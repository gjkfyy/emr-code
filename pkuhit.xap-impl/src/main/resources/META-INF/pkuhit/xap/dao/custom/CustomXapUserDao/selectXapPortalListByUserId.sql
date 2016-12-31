select distinct xp.PORTAL_CD,
  xp.ORG_CD,
  xp.NM,
  xp.DES,
  xp.SHT_NM_EN,
  xp.NM_EN,xp.sort_no from xap_role_portal xrp,xap_user_role xur,xap_portal xp 
       where xur.user_id = /* userId */'a'
             and xur.role_cd = xrp.role_cd 
             and xrp.portal_cd = xp.portal_cd
             /*%if orgCd != null && orgCd != "" */
            and xur.org_cd = /* orgCd */'a'
            /*%end*/
            and xrp.del_f = 0
            and xur.del_f = 0
            and xp.del_f = 0
            order by xp.sort_no
             