select di_cd,nm,ICD_CD from md_di
where 
del_f = 0
/*%if orgCode != null*/
and ORG_CD = /*orgCode*/'SZLH' 
/*%end */
/*%if diCodes != null && diCodes.size()>0 */
  and DI_CD in /*diCodes*/('MRM07.06') 
/*%end */