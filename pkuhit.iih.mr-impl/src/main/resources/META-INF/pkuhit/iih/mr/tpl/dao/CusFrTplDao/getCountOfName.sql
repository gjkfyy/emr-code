select count(*) from MR_FR_TPL where del_f != 1
/*%if name != null */
 and NM = /*name */'g'
 /*%end */
/*%if code != null */
 and MR_FR_TPL_CD !=   /*code*/'149'
/*%end */