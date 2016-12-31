select menu_cd, nm, nm_en
  from XAP_MENU menu
 where menu.portal_cd = /* portalCd */'a'
   and (exists (select *
                  from XAP_ROLE_MENU rm,
                       (select r.role_cd
                          from xap_user_role r
                         where r.user_id = /* userId */'1001'
                           and r.del_f = 0) tmp
                 where rm.ROLE_CD = tmp.ROLE_CD
                   and rm.menu_cd = menu.menu_cd
                   and rm.del_f = 0))
   /*%if parMenuCd != null && parMenuCd != "" */
   and menu.par_menu_cd = /* parMenuCd */'a'
   /*%end*/
   /*%if parMenuCd == null || parMenuCd == "" */
   and menu.par_menu_cd IS NULL
   /*%end*/
   and menu.del_f = 0
 order by menu.sort_no