select menu_cd,nm,nm_en
  from XAP_MENU menu
where menu.portal_cd = /* portalCd */'a'
   and (exists
        (select *
           from XAP_ROLE_MENU rm, XAP_USER_ROLE ur
          where rm.ROLE_CD = ur.ROLE_CD
            and ur.USER_ID = /* userId */'1001'
            /*%if orgCd != null && orgCd != "" */
            and ur.ORG_CD = /* orgCd */'a'
            /*%end*/
            and rm.menu_cd = menu.menu_cd
            and rm.del_f = 0
            and ur.del_f = 0) )
   /*%if parMenuCd != null && parMenuCd != "" */
   and menu.par_menu_cd = /* parMenuCd */'a'
   /*%end*/
   /*%if parMenuCd == null || parMenuCd == "" */
   and menu.par_menu_cd IS NULL
   /*%end*/
   and menu.del_f = 0
order by menu.sort_no