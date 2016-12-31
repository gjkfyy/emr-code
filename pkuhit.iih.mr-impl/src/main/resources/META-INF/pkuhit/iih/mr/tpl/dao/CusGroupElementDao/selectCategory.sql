select a.* from MD_MR_GE_CCAT a
where
 a.del_f != 1
/*%if orgCd != null*/
  and a.ORG_CD = /*orgCd*/'SZLH'
/*%end */
/*%if parentCode != null*/
  and a.par_mr_ge_ccat_cd=/*parentCode*/'MRM11.01'
/*%else*/
  and a.par_mr_ge_ccat_cd is null
/*%end */
/*%if keyword != null*/
  and a.NM like /* @contain(keyword) */'%g%'
/*%end */