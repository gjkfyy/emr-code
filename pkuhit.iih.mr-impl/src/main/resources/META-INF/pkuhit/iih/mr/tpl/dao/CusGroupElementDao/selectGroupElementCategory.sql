
select a.* from MD_MR_GE_CCAT a 
where
  EXISTS (
    select ge.* from mr_ge ge 
    where
      ge.mr_ge_ccat_cd in 
      (select cat.MR_GE_CCAT_CD 
       from MD_MR_GE_CCAT cat 
       where cat.del_f = 0 
         start with cat.mr_ge_ccat_cd= a.mr_ge_ccat_cd
         connect by cat.par_mr_ge_ccat_cd = prior cat.mr_ge_ccat_cd 
      )
      /*%if orgCd != null*/
        and ge.ORG_CD = /*orgCd*/'SZLH'
      /*%end */
      /*%if ownTpCd != null*/
        and ge.OWN_TP_CD=/*ownTpCd*/'MDM08.01'
      /*%end */
      /*%if ownCd != null*/
        and ge.own_cd=/*ownCd*/'SZLH'
      /*%end */  
      /*%if typeCode != null*/
        and ge.MR_GE_TP_CD=/*typeCode*/'MRM11.01'
      /*%end */ 
      /*%if keyword != null*/
        and ge.NM like /* @contain(keyword) */'%g%'
	  /*%end */
        and ge.del_f != 1
  )
/*%if parentCode != null*/
  and a.par_mr_ge_ccat_cd=/*parentCode*/'MRM19.02'
/*%else*/
  and a.par_mr_ge_ccat_cd is null
/*%end */

