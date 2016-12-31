select a.* from MR_GE a 
where
  a.del_f != 1
/*%if orgCd != null*/
  and a.ORG_CD = /*orgCd*/'SZLH'
/*%end */
/*%if ownTpCd != null*/
  and a.OWN_TP_CD=/*ownTpCd*/'MDM08.01'
/*%end */
/*%if ownCd != null*/
  and a.own_cd=/*ownCd*/'SZLH'
/*%end */  
/*%if typeCode != null*/
  and a.MR_GE_TP_CD=/*typeCode*/'MRM11.01'
/*%end */ 
/*%if categoryCd != null*/
  and a.MR_GE_CCAT_CD=/*categoryCd*/'MRM19.01' 
/*%end */ 
/*%if statusCode != null*/
  and a.MR_GE_STA_CD=/*statusCode*/'MRM05.01' 
/*%end */
/*%if keyword != null*/
  and a.NM like /* @contain(keyword) */'%g%'
/*%end */
   