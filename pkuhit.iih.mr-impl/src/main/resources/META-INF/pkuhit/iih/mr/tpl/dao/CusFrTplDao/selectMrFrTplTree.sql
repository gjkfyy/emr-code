select f.* from MR_FR_TPL f
 where f.del_f != 1 
 /*%if keyword != null*/
 and f.NM like /* @contain(keyword) */'%g%'
 /*%end */
/*%if mrFrTplTpCd != null  */
 and f.MR_FR_TPL_TP_CD =   /*mrFrTplTpCd*/'149'
/*%end */